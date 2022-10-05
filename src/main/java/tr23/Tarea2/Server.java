package tr23.Tarea2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

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

            flujoEntrada = new DataInputStream(conexionCliente.getInputStream());

            //Recibimos primer numero entero
            double primerNum = flujoEntrada.readDouble();

            //Recibimos primer numero entero
            double segundoNum = flujoEntrada.readDouble();

            //Recibimos primer numero entero
            char simbolo = flujoEntrada.readUTF().charAt(0);

            double resultado;



            switch (simbolo)
            {
                case '+':

                    resultado=primerNum+segundoNum;
                    dataOutputStream.writeDouble(resultado);
                    break;

                case '-':
                    resultado=primerNum-segundoNum;
                    dataOutputStream.writeDouble(resultado);
                    break;

                case '*':
                    resultado=primerNum*segundoNum;
                    dataOutputStream.writeDouble(resultado);
                    break;

                case '/':
                    resultado=primerNum/segundoNum;
                    dataOutputStream.writeDouble(resultado);
                    break;

                default:
                    System.out.println("Error");

            }

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
