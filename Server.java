package sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static final int PORT = 3191 ;
    public static void main(String args []) throws Exception
    {
        new Server();
        
    }
    public Server() throws Exception
    {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is up and up running on port:"+ PORT);
        Socket socket = serverSocket.accept();   
        
        ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
        
        Packet recvPacket = (Packet)inStream.readObject();
        
        System.out.println(recvPacket.getMessage());
        
        if(recvPacket.getMessage().equals("Hello!"))
        {
            Packet packet = new Packet("Hi! - From the server");
            outStream.writeObject(packet);
        }
        serverSocket.close();
    }

}
