package tr23.Tarea3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

            //Recibimos fechas
            flujoEntrada = new DataInputStream(conexionCliente.getInputStream());


            String fecha1 = flujoEntrada.readUTF();

            String fecha2 = flujoEntrada.readUTF();

            SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");


            Date date1 = f.parse(fecha1);
            Date date2 = f.parse(fecha2);

            long fecha1MilSeg = date1.getTime();
            long fecha2MilSeg = date2.getTime();

            System.out.println("Milisegundos fecha 1 :" + fecha1MilSeg);
            System.out.println("Milisegundos fecha 2 :" + fecha2MilSeg);

            /**
             * Forma mas optima-> Comparar dates metodos .isBefore/.isAfter
             *

            if(date1.before(date2))
            {
                dataOutputStream.writeUTF(date1.getTime());
            }
            else
            {
                dataOutputStream.writeUTF(date2.getTime());
            }
             **/


            if(fecha1MilSeg>fecha2MilSeg){

                dataOutputStream.writeUTF(fecha2);

            }else{

                dataOutputStream.writeUTF(fecha1);
            }
        }
        catch(IOException ioException)
        {
            ioException.printStackTrace();
        }
        catch (ParseException parseException) {

            parseException.printStackTrace();
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
