package tr18;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class descargaDatos {
	
	public static void main( String[] args )
    {
        try {
            URL url = new URL("http://www.iesjandula.es:80/drupal/");
            System.out.println("Protocolo: " + url.getProtocol());
            System.out.println("Host name: " + url.getHost());
            System.out.println("Port number: " + url.getPort());
            System.out.println("Port number Defautl: " + url.getDefaultPort());
            System.out.println("File name: " + url.getFile());

            System.out.println(isURL1("https://www.fgds.com"));
            System.out.println(isURL2("https://www.google.com"));

            System.out.println(returnContentString(url));
            returnContentFile(url);
            
        } catch (MalformedURLException e) 
        {
            e.printStackTrace();
        }
    }

    public static boolean isURL1 (String url) 
    {

        try {
            new URL(url).openStream().close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static boolean isURL2 (String url)
    {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());    
            return false;
        }
    }

    public static String returnContentString(URL url)
    {
        String inputLine = "";
        String inputText = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            while ((inputLine = in.readLine()) != null)
            {
                inputText = inputText + inputLine;
            }
            in.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            inputText = "ERROR DE LECTURA DE WEB";
        }
        return inputText;
    }

    /**
     * @param url
     */
    public static void returnContentFile(URL url)
    {
        
        String inputLine = "";
        String inputText = "";

        try {
            File fichero = new File("html.txt");
            PrintWriter pw = new PrintWriter(fichero);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            while ((inputLine = in.readLine()) != null)
            {
                inputText = inputText + inputLine;
                pw.println(inputLine);
            }

            in.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
