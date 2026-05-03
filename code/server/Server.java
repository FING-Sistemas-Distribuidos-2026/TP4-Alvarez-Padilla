import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZContext;

public class Server {

    public static void main(String[] args) {

        try (ZContext context = new ZContext()) {

            ZMQ.Socket sock = context.createSocket(SocketType.REP);

            sock.bind("tcp://*:3000");

            System.out.println("Reply server iniciado");

            String msg = sock.recvStr();

            System.out.println("Recibido: " + msg);

            String reply = "Good Morning! :D";

            sock.send(reply);

            System.out.println("Servidor finalizado");
        }
    }
}