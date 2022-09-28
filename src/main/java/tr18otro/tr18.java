package tr18otro;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;


public class tr18 {
    public static void main(String[] args)  {
        tr18 tr18 = new tr18();
        try
        {
            System.out.println(tr18.returnContentString(new URL("http://www.iesjandula.es/drupal")));
            tr18.returnContentFile(new URL("http://www.iesjandula.es/drupal"));

        }catch (MalformedURLException e)
        {
            e.printStackTrace();
        }



    }
    public String returnContentString(URL url)
    {
        String inputText = "";
        InputStreamReader inputStreamReader = null;
        BufferedReader in = null;
        try
        {
            inputStreamReader = new InputStreamReader(url.openStream());
            in = new BufferedReader(inputStreamReader);

            String inputline = in.readLine();


            while (inputline !=null)
            {
                inputText = inputText + inputline;
                inputline = in.readLine();
            }
        }
        catch (IOException e)
        {

            e.printStackTrace();

        }
        finally
        {

            if (in != null)
            {
                try
                {
                    in.close();
                }catch (IOException e)
                {
                    e.printStackTrace();
                }

            }

            if (inputStreamReader != null)
            {
                try
                {
                    inputStreamReader.close();

                }catch (IOException e)
                {
                    e.printStackTrace();
                }

            }


        }

        return inputText;

    }

    public void returnContentFile(URL url)
    {
        File file = new File("pagina.html");
        PrintWriter printWriter = null;

        InputStreamReader inputStreamReader = null;
        BufferedReader in = null;

        try
        {
            printWriter = new PrintWriter(file);
            inputStreamReader = new InputStreamReader(url.openStream());
            in = new BufferedReader(inputStreamReader);

            String inputline = in.readLine();


            while (inputline !=null)
            {
                printWriter.println(inputline);
                inputline = in.readLine();
            }
        }
        catch (IOException e)
        {

            e.printStackTrace();

        }
        finally
        {

            if (in != null)
            {
                try
                {
                    in.close();
                }catch (IOException e)
                {
                    e.printStackTrace();
                }

            }

            if (printWriter != null)
            {
                    printWriter.close();

            }
        }
    }
}
