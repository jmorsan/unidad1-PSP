package tr23.Tarea2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
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

            System.out.println("Introduzca un primer numero:");
            dataOutputStream.writeDouble(sc.nextDouble());

            System.out.println("Introduzca un segundo numero:");
            dataOutputStream.writeDouble(sc.nextDouble());

            sc.nextLine();

            System.out.println("Introduzca tipo de opercion");
            String simbolo =sc.nextLine();

            if(simbolo.charAt(0) != '+' && simbolo.charAt(0) != '-' && simbolo.charAt(0) != '*' && simbolo.charAt(0) != '/' )
            {
                System.out.println("Operacion no soportada");
            }
            else
            {
                dataOutputStream.writeUTF(simbolo);
                System.out.println(flujoEntrada.readDouble()) ;
            }




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
