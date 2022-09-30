package tr21;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Tr21 {
    public static final int PORT = 8080;



    public static void main(String[] args)
    {
        ServerSocket socketServidor = null;
        Socket socketCliente = null;
        DataOutputStream dataOutputStream = null;

        try
        {

            socketServidor = new ServerSocket(PORT);

            socketCliente = socketServidor.accept();

            dataOutputStream = new DataOutputStream(socketCliente.getOutputStream());
            dataOutputStream.writeUTF("Hola cliente, Conexión recibida");

            dataOutputStream.close();
            socketCliente.close();
            socketServidor.close();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (dataOutputStream != null)
            {
                try
                {
                    dataOutputStream.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

            if (socketCliente != null)
            {
                try
                {
                    socketCliente.close();
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
