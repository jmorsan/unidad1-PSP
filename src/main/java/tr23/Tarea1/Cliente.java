package tr23.Tarea1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente {

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

            System.out.println("Introduzca un numero:");
            dataOutputStream.writeInt(sc.nextInt());

            System.out.println(flujoEntrada.readDouble()) ;
        }
        catch(InputMismatchException inputMismatchException)
        {
            inputMismatchException.printStackTrace();

        }
        catch(UnknownHostException unknownHostException)
        {
            unknownHostException.printStackTrace();
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
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
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }
}
