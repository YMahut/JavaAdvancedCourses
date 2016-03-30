import java.io.*;
import java.net.*;

public class EchoServer {
	public static void main(String[] args) {
	       try {
	         ServerSocket server = new ServerSocket(8008);
	         while (true) {  
	            Socket s = server.accept();
	            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
	            PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

	            out.print("Hello! This is the Java EchoSever. ");
	            out.println("Enter BYE to exit.");
	            out.flush();
	            String str = null;
	            while ((str = in.readLine()) != null) {
	               System.out.println("Received: " + str);
	               out.println("Echo: " + str);
	               out.flush();
	               if (str.trim().equals("BYE")) {
	                  break;
	               }
	            }

	            s.close();
	         }
	       } catch (Exception e) { e.printStackTrace(); }
	   }
	}

