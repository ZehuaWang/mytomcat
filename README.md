# Tomcat_Prototype :cloud:
This is a simple Tomcat container application implement with Http and Socket Programming.
Combine IDEA with Git : https://blog.csdn.net/erlian1992/article/details/77200700
***
### Step One 
Use a simulate client to create socket connection with server and get the respond.

    Client Side :
    1. Create a Socket Object that point to the Server side, give the domain name and server port number
    2. Use socket to get the output stream object
    3. Get a input stream through socket
    4. Send the HTTP request to the server side
    5. Get the respond from server
    6. Close the resource
    
    Server Side :
    1. Get the request and send respond.
