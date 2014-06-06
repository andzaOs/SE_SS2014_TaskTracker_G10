package Entity;


import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;



public class KlijentTest extends TestCase {
	
	


	public void testGetKlijent_id(){
		Klijent k1= new Klijent();
		k1.setKlijent_id(245);
	    long test_id=k1.getKlijent_id();
		assertEquals(245, test_id);
	}
	
	public void testGetNaziv() {
		Klijent k2= new Klijent();
		k2.setNaziv("Testni naziv");
		assertEquals("Testni naziv", k2.getNaziv());
	}
	
	public void testGetAdresa() {
		Klijent k3= new Klijent();
		k3.setAdresa("Testna adresa");
		assertEquals("Testna adresa" , k3.getAdresa());
	}
	
	public void testGetBroj_telefona() {
		Klijent k4= new Klijent();
		k4.setBroj_telefona("061 865 688");
		assertEquals("061 865 688" , k4.getBroj_telefona());
	}
	
	public void testGetEmail() {
		Klijent k5= new Klijent();
		k5.setEmail("testni@mail.com");
		assertEquals("testni@mail.com" , k5.getEmail());
	}
	
	public void testGetVidljivo() {
		Klijent k6= new Klijent();
		k6.setVidljivo(6>3);
		assertTrue(k6.getVidljivo());
		k6.setVidljivo(3>6);
		assertFalse(k6.getVidljivo());
	}
	
	public void testGetZadaci() {
		RadniZadatak z1 = new RadniZadatak();
		z1.setRadniZadatak_id(1);
		RadniZadatak z2 = new RadniZadatak();
		z2.setRadniZadatak_id(2);
	
		Set<RadniZadatak> testni_zadaci = new HashSet<RadniZadatak>();
		testni_zadaci.add(z1);
		testni_zadaci.add(z2);
		Klijent k7= new Klijent();
		k7.setZadaci(testni_zadaci);
		assertEquals(testni_zadaci, k7.getZadaci());
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
