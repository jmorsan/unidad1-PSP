package tr16;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
	
	public static void main( String[] args )  
	{
		
		URL url;
		try {
			url = new URL("http://www.iesjandula.es/drupal/");
			
			System.out.println("Protocolo: "+url.getProtocol());
			System.out.println("Host name: "+url.getHost());
			System.out.println("Port number: "+url.getPort());
			System.out.println("File name: "+url.getFile());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	
	}

}