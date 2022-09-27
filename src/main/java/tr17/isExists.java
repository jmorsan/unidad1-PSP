package tr17;

import java.net.URL;

public class isExists {
	 public static void main(String[] args) 
	    {
	        String url="https://www.youtube.com/";

	        isURL1(url);
	        System.out.println(isURL1(url));
	        System.out.println(isURL2(url));
	    }

	    //si existe la pagina
	    public static boolean isURL1(String url) {
	        try 
	        { 
	            URL u = new URL(url);
	            u.openStream().close();
	            return true;
	        }catch (Exception ex) 
	        {
	            System.out.println(ex.getMessage());
	            return false;
	        }
	    }

	    //si esta escrito el  formato de la pagina correctamente
	    public static boolean isURL2(String url) {
	        try 
	        { 
	            new URL(url).toURI();
	            return true;
	        }catch (Exception ex) 
	        {
	            ex.printStackTrace();
	            return false;
	        }
	    }

}
