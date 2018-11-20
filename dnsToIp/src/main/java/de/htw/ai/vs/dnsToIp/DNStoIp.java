package de.htw.ai.vs.dnsToIp;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNStoIp {
	
	public static void main(String[] args) {
		
		if(args.length == 0){
			System.out.println("Bitte geben sie ein hostnamen oder Ip als argument ein.");
		}else{
		System.out.println(ipDNSConvert(args[0]));
		}
	}
	
	protected static String ipDNSConvert(String ipOrDNS){
		
		IpValidator ipvalidate = new IpValidator();
		String ip =  getIPofDNS(ipOrDNS);
		getDNSofIP(ip);
		
		 if(!validInput(ipOrDNS)){
			 return "Plese type a valid IP or Hostname as argument";
		 }else if(ipvalidate.validate(ipOrDNS)){
			 return getDNSofIP(ipOrDNS);
		 }else{
			 return getIPofDNS(ipOrDNS);
		 }

	}
	
	private static boolean validInput(String input){	
		if (input.length() <= 3 || input.length() >253  ){
			return false;
		}else{
			return true;
		}
	}

	protected static String getIPofDNS(String hostname) {
		try {
			InetAddress inetAddr = InetAddress.getByName(hostname);
			byte[]  addrInBytes = inetAddr.getAddress();
			String ipAddr = ConvertToDotRepr(addrInBytes);
			return "IP: "+ipAddr;
		} catch (UnknownHostException e) {
			return "IP Adress not found: " + e.getMessage();
		}
	}
	
	private static String ConvertToDotRepr(byte[] addrInBytes){
		String ipAddr = "";
		for (int i = 0; i < addrInBytes.length; i++) {
			if (i > 0) {
				ipAddr += ".";
			}
			ipAddr += addrInBytes[i] & 0xFF;
		}	
		return ipAddr;	
	}

	protected static String getDNSofIP(String ipAdress) {
		try {
			InetAddress inetAddr = InetAddress.getByName(ipAdress);
			String hostname = inetAddr.getHostName();
			return "Host: "+hostname;
		} catch (UnknownHostException e) {
			return "Hostname not found: " + e.getMessage();	
		}
	}

}
