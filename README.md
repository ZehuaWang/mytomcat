# Tomcat_Prototype :cloud:
This is a simple Tomcat container application implement with Http and Socket Programming.
  
  Combine IDEA with Git : [CSDN](https://blog.csdn.net/erlian1992/article/details/77200700)  
  MarkDown Grammer : [简书](https://www.jianshu.com/p/f8021c881d0f)
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

### Step Two
Use a simulate server to create socket to listen localhost:8080 and send response.

    Client Side:
    1. Request localhost:8080 and wait the responce
    
    Server Side :
    1. Create ServerSocket Object and listen to 8080 port.
    2. Get the socket Object
    3. Use socket Object to get the output stream.
    4. Send the HTTP resonse part to client (browser)
    5. Close the resource