import java.io.*;
import java.net.*;
import java.util.*;


public class Server {
	
	public static void main(String[] args) throws IOException {
		
		String blah = IO.readString(); //Server
		int ports = IO.readInt();
		
		ServerSocket svc = new ServerSocket(ports, 5);//listen on port 12345
		Socket conn = svc.accept(); //it waits till it gets a connection
		
		String str1 = "Bad input. Try again" + '\n';
		//While start
		while(true){
			String result = "";
			
			// get input/output streams for the socket
			BufferedReader fromClient = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			DataOutputStream toClient = new DataOutputStream(conn.getOutputStream());
			
			// reading the data from the client
			String line =  fromClient.readLine();
			System.out.println("got line \" " + line + "\"");
			
			String[] str = line.split(" ");
			
			
			//now we check each input received from the user
			
			if (str.length > 2)
				toClient.writeBytes(str1);
			
			// if the input has bounce in it
			else if ( str[0].equalsIgnoreCase("bounce") ) {
				
				//I know that input should be only two parts(for some inputs). 
				//So I split it to check it later
				
				
				//making sure that input is in the right structure
				if( str.length != 2 ){
					
					toClient.writeBytes(str1);
					

				}else{ 
					//we made sure that structure is right.
					//now we bounce back a message to the user.
					String snr = str[1];
					
					//Create the result
					result = snr.toUpperCase() + '\n';
					
					//Write back the result to the user:
					toClient.writeBytes(result);
					System.out.println(result + "-> bounced");
				}
				//end of bounce
				
				
			} else if (str[0].equalsIgnoreCase("GET")){
				
				//making sure that input is in the right structure
				if( str.length != 2 )
					toClient.writeBytes(str1 + '\n');
				else{
					System.out.println("else entered"); //test
					String path = str[1];
//					path = "src/" + path; //making the file path
					System.out.println("path is : " + path);
					System.out.println("path has created, ready to test the existance");
					
					File file = new File(path);
					String curLine = " ";
					
					//checking whether or not the file exists in our directory
					if (file.exists() == false ) {
						
						toClient.writeBytes("ERROR:no such file" + '\n');
						System.out.println("ERROR: no such file"); // test
						
					}
					// Now that we know the file exists, we get whats inside it
					// and send it to the user. 
					else{
						System.out.println("File existance confirmed. Ready to do sending process");//test
						
						BufferedReader input =  new BufferedReader(new FileReader(path));
						 String Line = null; //not declared within while loop
						 while (  (Line = input.readLine()) != null){
							 curLine = curLine.concat(";");
							 curLine = curLine.concat(Line);
						      //Process line
						  }//end of while
						 toClient.writeBytes(curLine + '\n');
						 System.out.println("User should recieved the data");//test
						
						}// end of else

					
				}
				
			}else if (str[0].equalsIgnoreCase("EXIT")){
				
				//making sure that input is in the right structure
				if( str.length == 1 ){
					toClient.writeBytes("~SESSION WILL CLOSE" + + '\n');
					break;
				}
				else if (str.length == 2){
					
					toClient.writeBytes("~" + str[1] + + '\n');
//					toClient.writeBytes("SERVEROFF");
					break;
					
				}else
					toClient.writeBytes("bad input . Try again \n");
			}
			
			// This case happens when none of the inputs are correct
			else{
				toClient.writeBytes("bad input . Try again \n");
			}
			// return bad input
			
			
		
		}
		//While ends
		
		System.out.println("server exiting\n");
		
		conn.close(); //closing the connection
		svc.close(); //stop listening
		
		
		
		
		
		
		
	}
	
	

}
