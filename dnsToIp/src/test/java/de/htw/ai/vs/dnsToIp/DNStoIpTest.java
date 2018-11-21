package de.htw.ai.vs.dnsToIp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DNStoIpTest {
	
	DNStoIp dns;

	@Test
	public void correntIPprovided(){
		
		
		Assertions.assertEquals(dns.getDNSofIP("ip von htw berlin"), dns.getIPofDNS(hostname));
	}	
	
	@Test
	public void correntDNSprovided(){
		Assertions.assertEquals(2, 1+1);
	}
	
	@Test
	public void correntNotExistingIPprovided(){
		Assertions.assertEquals(2, 1+1);
	}
	
	@Test
	public void correntNotExistingDNSprovided(){
		Assertions.assertEquals(2, 1+1);
	}
	
	@Test
	public void noArgumentProvided(){
		Assertions.assertEquals(2, 1+1);
	}
	
	@Test
	public void wrongArgument(){
		Assertions.assertEquals(2, 1+1);
	}
	
}
