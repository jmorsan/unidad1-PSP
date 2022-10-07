package tr26;

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

            int numero =-1;

            while(numero != 0)
            {

                System.out.println("Introduzca numero:");

                numero = Integer.parseInt(sc.nextLine());

                dataOutputStream.writeInt(numero);

                System.out.println(flujoEntrada.readUTF());

            }

            System.out.println(flujoEntrada.readUTF());

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

