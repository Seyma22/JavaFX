package com.company;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MyClient
{
    /**
     *80 HTTP PORTU
     * 3306 MYSQL PORTU
     * 5432 POSTGRE
     * 156 SQL SERVER
     *
     *  // socket.getInputStream();        //socket den gelen verileri okumak için
     *       //  socket.getOutputStream();       //socket e veri göndermek için
     *
     *         //try-with-resources
     */

    private static final String HOST="localhost";   //127.0.0.1

    private static final int PORT=2020;

    public void sendMessage(String message)
    {

        //try-with-resources
        try (
                Socket socket=new Socket(HOST,PORT);
                DataOutputStream dos=new DataOutputStream((socket.getOutputStream()))
        )
        {
            dos.writeUTF(message);
            dos.flush();
        }
        catch(IOException ex)
        {
            throw new RuntimeException(ex);
        }


    }
}
