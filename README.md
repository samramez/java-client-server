Example Program "Commuication Protocol"  04/10/2014

GENERAL USAGE NOTES (BASED ON THE HOMEWORK PROMPT)
------------------------------------------------------
Our task is to implement the following simple communication protocol. The client should be allowed to
send two different "commands" to the server:
1.GET <filename>
2.BOUNCE <text-to-bounce>

The server responds as requested, or sends a message back containing the requested file or the bounced
text message. The user should be informed about the outcome (a simple text message would suffice), while
the server should display the command and the content of the file for testing purpose. In the case of the
GET command, the response may be an error message in case the specified filename does not exist:
"ERROR: no such file"

It is a good idea to prepare several test files containing plain text and store them on the server side, so the
client can request some of those. When the client receives the file from the server, it can just print its
contents. (This would be inconvenient for binary files.) The client should be able to recognize ERROR messages and display them to the user.

3.EXIT <exit code>
The client sends a request to close the connection between the server and the client, the server should printout the exit code, and both the client and the server exit gracefully. The EXIT command should have a default parameter. In other words, command “EXIT” and command “EXIT <exit code>” should both work. The client should be continuously running and taking user's input. The client should be sufficiently "smart" to check and filter the user's input and accept only GET, BOUNCE and EXIT commands with appropriate syntax and arguments. All other input should be discarded and the user warned about it. 
-----------------------------------------------------------




Installing and running the program
------------------------------------------------------------

The user should first open 2 Terminal. Then on each of the Terminals, user open the directory where all the submitted files are located, including: server.java, server.class, client.java , client.class , file.txt , file1.txt , README.txt .

Then the user have to FIRST, run the server.java in one Terminal and the run the client.java in the other Terminal. 

ATTENTION: It is strongly suggested that client.java be run in Eclipse to get perfect results. User can then use the commands mentioned above in the terminal and use run the program. 

It should be noticed that this program is multithreaded as asked, meaning only one user at a time can have communication with the server
------------------------------------------------------------

------------------------------------------------------------



Sample test cases:
------------------------------------------------------------
-> BOUNCE I'm-testing-this-code
I'm-testing-this-code

-> Bounce hello goodbye
bad input. Try again

-> EXIT
SESSION WILL CLOSE

-> EXIT yes_its_finally_done
yes_its_finally_done
SESSION WILL CLOSE

-> GET fileThatDoesntExist.txt
ERROR: no such a file

=======================================================

Example program can be reached at :
Voice: (925)698-3306
Email: sam.ramezanli@rutgers.edu

copyright 2014 . All rights reserved! :)


