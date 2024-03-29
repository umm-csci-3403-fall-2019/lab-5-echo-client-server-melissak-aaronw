package echoserver;
import java.net.*;
import java.io.*;

public class EchoClient {
	public static final int portNumber = 6013;

	public static void main(String[] args) throws IOException {
		String server;
		if (args.length == 0) {
			server = "127.0.0.1";
		} else {
			server = args[0];
		}

		try {
			Socket socket = new Socket(server, portNumber);
			OutputStream output = socket.getOutputStream();
			InputStream input = socket.getInputStream();

			int b;
			int response;
			
			while ((b = System.in.read()) != -1) {
				output.write(b);
				output.flush();
				response = input.read();
				System.out.write(response);
			}
                        System.out.flush();
	
			output.close();
			input.close();
			socket.close();

		} catch (ConnectException ce) {
			System.out.println("We were unable to connect to " + server);
			System.out.println("You should make sure that the server is running.");
		} catch (IOException ioe) {
			System.out.println("We caught an unexpected exception");
			System.err.println(ioe);
			}
		}

			
			
}
