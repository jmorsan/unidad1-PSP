package tr26;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
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
        catch(InputMismatchException | IOException exception)
        {
            exception.printStackTrace();

        }
        finally
        {

            sc.close();


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
            if (flujoEntrada != null)
            {
                try
                {
                    flujoEntrada.close();
                }
                catch (IOException ioException)
                {
                    ioException.printStackTrace();
                }
            }

            if (conexionServidor != null)
            {
                try
                {
                    conexionServidor.close();
                }
                catch (IOException ioException)
                {
                    ioException.printStackTrace();
                }
            }
        }

    }
}

