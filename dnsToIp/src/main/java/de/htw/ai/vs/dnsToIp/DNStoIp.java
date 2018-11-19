package de.htw.ai.vs.dnsToIp;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.Utilities;

public class DNStoIp {

	 private static Pattern VALID_IPV4_PATTERN = null;
	 private static Pattern VALID_IPV6_PATTERN = null;
	 private static final String ipv4Pattern = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
	 private static final String ipv6Pattern = "([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}";

	
	public static void main(String[] args) {


		IpValidator ipvalidate = new IpValidator();
		
		
		// check if argument exits (min. 3 max 253 characters)
		// check if valid ip adress if yes respond with hostname
		// check if valid hostname if yes respond with ip adress

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
