import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server2 {
	ServerSocket server; 
	Socket client; 
	InputStream is; // input stream 
	OutputStream os; // output stream 
	BufferedReader in; 
	PrintStream out; 
	boolean close;
	public void launch() { 
		String line; 
		try { 
			server = new ServerSocket(8888); // Create the server socket 
			while(true){
				client = server.accept(); // program will block until a client connects 
				close = false;
				System.out.println ("The server accepts the connection"); 
				is = client.getInputStream(); // input stream recovery 
				os = client.getOutputStream(); // output stream recovery 
				in = new BufferedReader(new InputStreamReader (is)); 
				out = new PrintStream(os);
				System.out.println ("Connected Client effected"); 
				while (!close) { 
					out.println ("Server is ready to enter a string (q to quit ):"); 
					line = in.readLine(); // reading a line from the client 
					if (line.equals ("q")) { 
						System.out.println ("End of communication"); 
						//out.println ("Stopping server"); 
						client.close(); // close connection with the customer 
						close = true;
						//break; // while we go out of 
					} else {
						out.println ("line received is : " + line); 
						out.println ("It includes" + line.length() + "letters"); 
					} 
				} 
			}
		} catch (Exception e) { 
			System.out.println (e); // Display the exception 
		} 
		System.out.println ("Server stopped"); 
	} 
	public static void main (String [] args) { 
		new Server2().launch(); 
	} 
}
