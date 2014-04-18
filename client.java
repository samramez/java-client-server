
import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		String line = null;
		
		String inp = IO.readString(); //Client
		
		String server = IO.readString(); //host
		
		int port = IO.readInt(); //port
		
		
		BufferedReader userdata = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			//System.out.print("input is :" + userdata);
//			String server = "localhost";
//			int port = 12345;
			
			Socket socket = new Socket(server , port);
			
			/* ÐThe methods getInputStream() and getOutputStream() return the
			 *  basic streams for the socket 
			 * ÐCreate a DataOutputStream for the socket so we can write a
			 *  string as bytes
			 * ÐCreate a BufferedReader so we can read a line of results
			 *  from the server */
			DataOutputStream toServer = new	DataOutputStream(socket.getOutputStream() );
			BufferedReader fromServer = new	BufferedReader(
					new	InputStreamReader (	socket.getInputStream()));
			
			while(true){
				//While starts
				System.out.println("Type the input");
				line = userdata.readLine();
				toServer.writeBytes(line + '\n'); //// send the line we read from the user 
				String result = fromServer.readLine(); //// read the response from the server
//				System.out.println("(TEST) data recieved from the server ");//test
				
				System.out.println("=> " + result);
				
				if (result.charAt(0) == '~')
					break;
				
			
			}// end of while loop
			
			System.out.println("conncetion is terminated");
			socket.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
