package tr19;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class tr19 {
    public static void main(String[] args)
    {
        try {
            URL url = new URL("http://www.iesjandula.es/drupal");
            URLConnection urlcon = url.openConnection();
            InputStream stream = urlcon.getInputStream();
            int i = stream.read();

            while(i  != -1)
            {
                System.out.println((char) i);
                i= stream.read();
            }

        }catch (IOException e){

        }
    }
}
