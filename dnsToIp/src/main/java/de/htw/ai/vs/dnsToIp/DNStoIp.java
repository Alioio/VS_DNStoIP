package de.htw.ai.vs.dnsToIp;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNStoIp {

	public static void main(String[] args) {

		// args empty?
		// to short?

		getDNSofIP(args[0]);
		getDNSofIP(args[0]);

	}

	protected static void getIPofDNS(String hostname) {

		try {
			InetAddress inetAddr = InetAddress.getByName(hostname);
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
		} catch (UnknownHostException e) {
			System.out.println("Host not found: " + e.getMessage());
		}

	}

	protected static void getDNSofIP(String ipAdress) {

		try {
			InetAddress inetAddr = InetAddress.getByName(ipAdress);
			// Get the host name
			String hostname = inetAddr.getHostName();
			// Get canonical host name
			String canonicalHostname = inetAddr.getCanonicalHostName();
			System.out.println("Hostname: " + hostname);
			System.out.println("Canonical Hostname: " + canonicalHostname);
		} catch (UnknownHostException e) {
			System.out.println("Host not found: " + e.getMessage());
		}
	}

}
