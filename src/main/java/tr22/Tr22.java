package tr22;

import tr21.Tr21;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;



public class Tr22 {

    private static  final String HOST = "192.168.14.135";

    public static void main(String[] args)
    {
        Socket socketServidor = null;
        DataInputStream flujoEntrada = null;

        try
        {
            socketServidor = new Socket(HOST, 8080);
            flujoEntrada = new DataInputStream(socketServidor.getInputStream());
            System.out.println(flujoEntrada.readUTF()) ;
        }
        catch(UnknownHostException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (flujoEntrada != null)
            {
                try
                {
                    flujoEntrada.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

            if (socketServidor != null)
            {
                try
                {
                    socketServidor.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }
}
