package sockets;

import java.io.Serializable;

public class Packet implements Serializable
{

     private String message;

    
    public Packet(String _message)
    {
     
        message = _message;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String _message)
    {
        message = _message;
    }
     
     
}
