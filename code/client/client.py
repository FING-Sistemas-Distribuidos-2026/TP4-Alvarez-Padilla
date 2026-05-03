import zmq

context = zmq.Context()

sock = context.socket(zmq.REQ)

server_host = "localhost"

sock.connect(f"tcp://{server_host}:3000")

print(f"Cliente conectado (?) al server {server_host}")

request = "Hello world!"

print("Request:", request)

sock.send_string(request)

result = sock.recv_string()

print("Respuesta del Server:", result)