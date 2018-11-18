package de.htw.ai.vs.dnsToIp;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNStoIp {

	public static void main(String[] args) {
		
		try {
			InetAddress inetAddr = InetAddress.getByName(args[0]);
			byte[] addr = inetAddr.getAddress();
			// Convert to dot representation
			String ipAddr = "";
			for (int i = 0; i < addr.length; i++) {
				if (i > 0) {
					ipAddr += ".";
				}
				ipAddr += addr[i] & 0xFF;
			}
			System.out.println("IP Address: " + ipAddr);
		}catch (UnknownHostException e) {
			System.out.println("Host not found: " + e.getMessage());
		}	
	}

}
