package Entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

public class RadniZadatakTest extends TestCase {
	
	public void testGetRadniZadatak_id(){
		RadniZadatak rz1 = new RadniZadatak();
		rz1.setRadniZadatak_id(12);
		assertEquals(12, rz1.getRadniZadatak_id());
	}
	
	public void testGetKlijent() {
		Klijent k1=new Klijent();
		k1.setKlijent_id(1);
		RadniZadatak rz2=new RadniZadatak();
		rz2.setKlijent(k1);
		assertEquals(k1, rz2.getKlijent());
	}
	
	public void testGetKreator() {
		Korisnik k2=new Korisnik();
		k2.setKorisnik_id(2);
		RadniZadatak rz3=new RadniZadatak();
		rz3.setKreator(k2);
		assertEquals(k2, rz3.getKreator());
	}
	
	public void testGetRasporedjeniZadaci() {
		RasporedjeniZadatak z1 = new RasporedjeniZadatak();
		z1.setRasporedjeniZadatak_id(1);
		RasporedjeniZadatak z2 = new RasporedjeniZadatak();
		z2.setRasporedjeniZadatak_id(2);
	
		Set<RasporedjeniZadatak> testni_zadaci = new HashSet<RasporedjeniZadatak>();
		testni_zadaci.add(z1);
		testni_zadaci.add(z2);
		RadniZadatak rz4=new RadniZadatak();
		rz4.setRasporedjeniZadaci(testni_zadaci);
		assertEquals(testni_zadaci, rz4.getRasporedjeniZadaci());
	}
	
	public void testGetBrojServisera() {
		RadniZadatak rz5=new RadniZadatak();
		rz5.setBrojServisera(20);
		assertEquals(20, rz5.getBrojServisera());
	}
	
	public void testGetStatusDodjeljenosti() {
		RadniZadatak rz6=new RadniZadatak();
		rz6.setStatusDodjeljenosti(20);
		assertEquals(20, rz6.getStatusDodjeljenosti());
	}
	
	public void testGetDatumUnosa() {
		RadniZadatak rz7=new RadniZadatak();
		Date d1=new Date(1991);
		rz7.setDatumUnosa(d1);
		assertEquals(d1 , rz7.getDatumUnosa());
	}
	
	public void testGetKrajnjiDatumIzvrsenja() {
		RadniZadatak rz8=new RadniZadatak();
		Date d1=new Date(1991);
		rz8.setKrajnjiDatumIzvrsenja(d1);
		assertEquals(d1 , rz8.getKrajnjiDatumIzvrsenja());
	}
	
	public void testGetVidljivo() {
		RadniZadatak rz9=new RadniZadatak();
		rz9.setVidljivo(6>3);
		assertTrue(rz9.getVidljivo());
		rz9.setVidljivo(3>6);
		assertFalse(rz9.getVidljivo());
	}
	
	public void testGetStatusIzvrsenosti() {
		RadniZadatak rz10=new RadniZadatak();
		rz10.setStatusIzvrsenosti(6>3);
		assertTrue(rz10.getStatusIzvrsenosti());
		rz10.setStatusIzvrsenosti(3>6);
		assertFalse(rz10.getStatusIzvrsenosti());
	}
	
	public void testGetPotpunoDodjeljen() {
		RadniZadatak rz11=new RadniZadatak();
		rz11.setPotpunoDodjeljen(6>3);
		assertTrue(rz11.getPotpunoDodjeljen());
		rz11.setPotpunoDodjeljen(3>6);
		assertFalse(rz11.getPotpunoDodjeljen());
	}
	
	public void testGetOpis() {
		RadniZadatak rz12=new RadniZadatak();
		rz12.setOpis("testni opis");
		assertEquals("testni opis", rz12.getOpis());
	}
	
	public void testGetVrstaZadatka() {
		RadniZadatak rz13=new RadniZadatak();
		rz13.setVrstaZadatka("vrsta zadatka");
		assertEquals("vrsta zadatka", rz13.getVrstaZadatka());
	}
	
	
	
	
	

}
