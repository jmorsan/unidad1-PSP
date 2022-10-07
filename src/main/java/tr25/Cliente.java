package tr25;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente
{
    private static  final String HOST = "localhost";

    public static void main(String[] args)
    {
        Socket conexionServidor = null;
        DataInputStream flujoEntrada = null;
        DataOutputStream dataOutputStream = null;
        Scanner sc = null;

        try
        {
            conexionServidor = new Socket(HOST, 8080);
            flujoEntrada = new DataInputStream(conexionServidor.getInputStream());
            dataOutputStream = new DataOutputStream(conexionServidor.getOutputStream());
            sc = new Scanner(System.in);
            System.out.println(flujoEntrada.readUTF()) ;

            String palabra ="";

            while(!palabra.equals("fin"))
            {

                System.out.println("Introduzca palabra:");

                palabra = sc.nextLine();

                dataOutputStream.writeUTF(palabra);

                System.out.println(flujoEntrada.readUTF());

            }

            do
            {
                palabra=flujoEntrada.readUTF();

                if(!palabra.equals("fin"))
                {
                    System.out.println(palabra);
                }

            }
            while(!palabra.equals("fin"));

        }
        catch(InputMismatchException e)
        {
            e.printStackTrace();

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
            if (sc != null)
            {
                try
                {
                    sc.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
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

            if (conexionServidor != null)
            {
                try
                {
                    conexionServidor.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }
}
