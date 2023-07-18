import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Servidor conectado, Esperando conexiones...");

            while (true) {
                Socket socket = serverSocket.accept();
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner in = new Scanner(socket.getInputStream());

            out.println("1.Saludo");
            out.println("2.Cancion Melendi");
            out.println("3.Cancion Estopa");
            out.println("4.Cancion Camela");
            out.println("5.Cancion Maluma");

            while (true) {
                String option = in.nextLine();
                String response = "";

                switch (option) {
                    case "1":
                        response = "¡Hola! ¿En qué puedo ayudarte?";
                        break;
                    case "2":
                        response = "Desde que estamos juntos\n" +
                                "Han vuelto los pájaros a casa\n" +
                                "Desde que estamos juntos\n" +
                                "Han vuelto los sueños a mi cama\n" +
                                "\n" +
                                "Desde que estamos juntos\n" +
                                "El frío se ha vuelto primavera\n" +
                                "Desde que estamos juntos\n" +
                                "Hasta el pasado se ha vuelto buena espera\n" +
                                "\n" +
                                "Desde que estamos juntos\n" +
                                "El tiempo corre más lento\n" +
                                "Desde que estamos juntos\n" +
                                "Hasta la soledad me sigue de momento\n" +
                                "\n" +
                                "Desde que estamos juntos\n" +
                                "Las palabras se hacen canciones\n" +
                                "Desde que estamos juntos\n" +
                                "Me importa un bledo la opinión de los demás ";
                        break;
                    case "3":
                        response = "El run run, el que no deja de sonar\n" +
                                "El run run, el que no para de martillear\n" +
                                "El run run, que a veces va y viene y te hace enloquecer\n" +
                                "El run run, el que no deja dormir\n" +
                                "El run run, el que no para de insistir\n" +
                                "El run run, que a veces llega y se va sin saber por qué\n" +
                                "\n" +
                                "El run run, ese rumor que te trae y te va\n" +
                                "El run run, esa voz que no deja de hablar\n" +
                                "El run run, ese run run que te dice siempre la verdad";
                        break;
                    case "4":
                        response = "Cuando zarpa el amor\n" +
                                "No hay quien lo pueda detener\n" +
                                "Y yo me siento aquí\n" +
                                "Esperando que tú llegues a mí\n" +
                                "\n" +
                                "Cuando zarpa el amor\n" +
                                "Las olas se llevan el dolor\n" +
                                "Y yo me siento aquí\n" +
                                "Soñando que tú vuelvas junto a mí\n" +
                                "\n" +
                                "Y aunque pasen los años\n" +
                                "Siempre serás mi vida\n" +
                                "Tú eres mi alegría, mi luz y mi fe\n" +
                                "Te llevo en mis sueños, en cada latido\n" +
                                "Eres mi destino, no puedo olvidarte";
                        break;
                    case "5":
                        response = "Dime qué te pasó\n" +
                                "No sé ni con quién estás\n" +
                                "Hablé un par de veces\n" +
                                "Nos ignoramos y me va bien\n" +
                                "Me siento libre porque arriba de ti\n" +
                                "Yo tengo un vuelo sin salir del suelo\n" +
                                "Hoy salió pa' cenar\n" +
                                "Mis condolencias a ese amor\n" +
                                "Que quedó en el pasado, sé que conmigo te va mejor\n" +
                                "Hoy salió pa' cenar\n" +
                                "Mis condolencias a ese amor\n" +
                                "Que quedó en el pasado, sé que conmigo te va mejor";
                        break;
                    default:
                        response = "Opción inválida, pruebe otra";
                        break;
                }

                out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
