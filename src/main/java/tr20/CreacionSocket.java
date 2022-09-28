package tr20;

import java.io.IOException;
import java.net.ServerSocket;

public class CreacionSocket {
    public static void main(String[] args)
    {
        ServerSocket server = null;
        try
        {
            server = new ServerSocket(0);
            System.out.println("Server started: "+ server);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(server !=null)
            {
                try {
                    server.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

        }
    }
}
