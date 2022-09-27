package tr13;

import java.io.IOException;
import java.net.InetAddress;

public class GetIp {
	public static void main( String[] args ) throws IOException {
		
		
		String hostName1 = InetAddress.getLocalHost().getHostName();
		InetAddress inetAddress1 = InetAddress.getByName(hostName1);
		
		String hostName2 = InetAddress.getLocalHost().getHostName();
		InetAddress inetAddress2 = InetAddress.getByName("www.google.com");
		
		System.out.println("HostName: "+ hostName1 + ", inetAddres: "+ inetAddress1);
		System.out.println("HostName: "+ hostName2 + ", inetAddres: "+ inetAddress2);
		
	
}

}
