
import java.net .*; 

import java.io. *; 

public class Server { 

	ServerSocket server; 
	Socket client; 
	InputStream is; // input stream 
	OutputStream os; // output stream 
	BufferedReader in; 
	PrintStream out; 
	public void launch() { 
		String line; 
		try { 
			server = new ServerSocket(8888); // Create the server socket 
			 client = server.accept(); // program will block until a client connects 
			System.out.println ("The server accepts the connection"); 
			is = client.getInputStream(); // input stream recovery 
			os = client.getOutputStream(); // output stream recovery 
			in = new BufferedReader(new InputStreamReader (is));
			out = new PrintStream(os);
			System.out.println ("Connected Client effected"); 
			while (true) { 
				out.println ("Server is ready to enter a string (q to quit ):"); 
				line = in.readLine(); // reading a line from the client 
				if (line.equals ("q")) { 
					System.out.println ("End of communication"); 
					out.println ("Stopping server"); 
					client.close(); // close connection with the customer 
					break; // while we go out of 
				} else {
					out.println ("line received is : " + line); 
					out.println ("It includes" + line.length() + "letters popopopo"); 
				} 
			} 
		} catch (Exception e) { 
			System.out.println (e); // Display the exception 
		} 
		System.out.println ("Server stopped"); 
	} 
	public static void main (String [] args) { 
		new Server().launch(); 
	} 
}
