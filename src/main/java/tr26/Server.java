package tr26;

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

            //Recibimos numeros
            flujoEntrada = new DataInputStream(conexionCliente.getInputStream());


            List<Integer> listaNumeros = new ArrayList<>();
            int numero=-1;

            while(numero != 0)
            {

                numero = flujoEntrada.readInt();

                if(numero != 0)
                {
                    listaNumeros.add(numero);
                }

                dataOutputStream.writeUTF("Recibido");

            }

            String resultado = "Media: "+String.valueOf(calcularMedia(listaNumeros))
                    +" ,Moda: "+String.valueOf(calcularModa(listaNumeros))
                    +" ,Mayor: "+String.valueOf(calcularMayor(listaNumeros))
                    +" ,Menor: "+String.valueOf(calcularMenor(listaNumeros));

            dataOutputStream.writeUTF(resultado);

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

    public static int calcularMedia(List<Integer>listaNumeros ){
        float media=0;

        for (int i = 0; i < listaNumeros.size() ; i++)
        {

            media += listaNumeros.get(i);

        }

        return Math.round(media/ listaNumeros.size());
    }

    public static int calcularModa(List<Integer> listaNumeros ){
        int moda = 0;
        int contModa = 0;


        for (int i = 0; i < listaNumeros.size() ; i++)
        {
            int numeroModa = listaNumeros.get(i);
            int cont=0;

            for (int j = 0; j < listaNumeros.size(); j++)
            {

                if(numeroModa == listaNumeros.get(j))
                {
                    cont++;
                }

            }
            //System.out.println(cont);

            if(cont>contModa)
            {
                contModa = cont;
                moda = numeroModa;
            }

        }

        return moda;
    }

    public static int calcularMayor(List<Integer>listaNumeros ){
        int mayor=0;

        for (int i = 0; i < listaNumeros.size() ; i++)
        {

            if(mayor<listaNumeros.get(i))
            {
                mayor=listaNumeros.get(i);
            }

        }

        return mayor;
    }

    public static int calcularMenor(List<Integer>listaNumeros ){
        int menor=listaNumeros.get(0);

        for (int i = 0; i < listaNumeros.size() ; i++)
        {

            if(menor>listaNumeros.get(i))
            {
                menor=listaNumeros.get(i);
            }

        }

        return menor;
    }



}
