package echoserver;
import java.net.*;
import java.io.*;

public class EchoServer {
	public static final int portNumber = 6013;

	public static void main(String[] args) {
		try {
			ServerSocket sock = new ServerSocket(portNumber);
			while(true) {
				Socket client = sock.accept();
				System.out.println("Made a new friend!");

				OutputStream output = client.getOutputStream();
				InputStream input = client.getInputStream();

				int b;
				while ((b = input.read()) != -1) {
					output.write(b);
				}
                                output.flush();
				
				output.close();
				input.close();
				client.close();
				
			}
		} catch (IOException ioe) {
			System.out.println("We caught an unexpected exception");
			System.err.println(ioe);
		}
	}
}
