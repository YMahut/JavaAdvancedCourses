import java.io.*;
import java.net.*;

/**
 * @author Jens Bennedsen
 *
 */
public class EchoClient {
	public static void main(String[] args) {
		String host = args.length > 0 ? host = args[0] : "localhost";
		try {
			Socket socket = new Socket(host, 8008);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			// send data to server
			for (int i = 1; i <= 10; i++) {
				System.out.println("Sending: line " + i);
				out.println("line " + i);
				out.flush();
			}
			out.println("BYE");
			out.flush();

			// receive data from server
			String str = null;
			while ((str = in.readLine()) != null) {
				System.out.println(str);
			}

			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

