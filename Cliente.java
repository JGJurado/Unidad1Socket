import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner in = new Scanner(socket.getInputStream());
            Scanner userInput = new Scanner(System.in);

            while (true) {
                while (in.hasNextLine()) {
                    String message = in.nextLine();
                    System.out.println("Servidor: " + message);
                }

                String option = userInput.nextLine();
                out.println(option);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
