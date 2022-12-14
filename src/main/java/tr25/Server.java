package tr25;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server
{
    public static final int PORT = 8080;

    public static void main(String[] args)
    {
        ServerSocket socketServidor = null;
        Socket conexionCliente = null;
        DataOutputStream dataOutputStream = null;
        DataInputStream flujoEntrada = null;

        try
        {

            socketServidor = new ServerSocket(PORT);


            conexionCliente = socketServidor.accept();

            dataOutputStream = new DataOutputStream(conexionCliente.getOutputStream());
            dataOutputStream.writeUTF("Hola cliente, Conexión recibida");

            //Recibimos palabras
            flujoEntrada = new DataInputStream(conexionCliente.getInputStream());


            List<String> listaPalabras = new ArrayList<>();
            String palabra="";

            while(!palabra.equals("fin"))
            {

                palabra = flujoEntrada.readUTF();

                if(!palabra.equals("fin"))
                {
                    listaPalabras.add(palabra);
                }

                dataOutputStream.writeUTF("Recibido");

            }


            for (int i = 0; i < listaPalabras.size() ; i++)
            {
                String palabraCifrada =" ";
                palabra = listaPalabras.get(i);

                for (int j = 0; j < palabra.length(); j++)
                {

                    palabraCifrada += String.valueOf ( (char) (palabra.charAt(j)+1));

                }

                listaPalabras.set(i,palabraCifrada);
            }


            for (int i = 0; i < listaPalabras.size() ; i++)
            {
                dataOutputStream.writeUTF(listaPalabras.get(i));
            }

            dataOutputStream.writeUTF("fin");

        }
        catch(IOException ioException)
        {
            ioException.printStackTrace();
        }
        finally
        {

            if (dataOutputStream != null)
            {
                try
                {
                    dataOutputStream.close();
                }
                catch (IOException ioException)
                {
                    ioException.printStackTrace();
                }
            }

            if (conexionCliente != null)
            {
                try
                {
                    conexionCliente.close();
                }
                catch (IOException ioException)
                {
                    ioException.printStackTrace();
                }
            }

            if (socketServidor != null)
            {
                try
                {
                    socketServidor.close();
                }
                catch (IOException ioException)
                {
                    ioException.printStackTrace();
                }
            }
        }
    }

}
