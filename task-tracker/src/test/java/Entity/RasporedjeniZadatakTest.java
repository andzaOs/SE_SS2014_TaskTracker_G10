package Entity;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

public class RasporedjeniZadatakTest extends TestCase {
	
	public void testGetRasporedjeniZadatak_id(){
		RasporedjeniZadatak rz1 = new RasporedjeniZadatak();
		rz1.setRasporedjeniZadatak_id(12);
		assertEquals(12, rz1.getRasporedjeniZadatak_id());
	}
	
	public void testGetZadatak() {
		RasporedjeniZadatak rz2 = new RasporedjeniZadatak();
		RadniZadatak z1 = new RadniZadatak();
		z1.setRadniZadatak_id(2);
		rz2.setZadatak(z1);
		assertEquals(z1, rz2.getZadatak());
	}
	
	public void testGetIzvrsilac() {
		RasporedjeniZadatak rz3 = new RasporedjeniZadatak();
		Korisnik k1 = new Korisnik();
		k1.setKorisnik_id(2);
		rz3.setIzvrsilac(k1);
		assertEquals(k1, rz3.getIzvrsilac());
	}
	
	public void testGetVidljivo() {
		RasporedjeniZadatak rz4=new RasporedjeniZadatak();
		rz4.setVidljivo(6>3);
		assertTrue(rz4.getVidljivo());
		rz4.setVidljivo(3>6);
		assertFalse(rz4.getVidljivo());
	}
	
	public void testGetStatusPrihvacenosti() {
		RasporedjeniZadatak rz5=new RasporedjeniZadatak();
		rz5.setStatusPrihvacenosti(6>3);
		assertTrue(rz5.getStatusPrihvacenosti());
		rz5.setStatusPrihvacenosti(3>6);
		assertFalse(rz5.getStatusPrihvacenosti());
	}
		
	public void testGetSavPosao() {
		ObavljeniPosao p1 = new ObavljeniPosao();
		p1.setObavljeniPosao_id(1);
		ObavljeniPosao p2 = new ObavljeniPosao();
		p2.setObavljeniPosao_id(2);
	
		Set<ObavljeniPosao> testni_poslovi = new HashSet<ObavljeniPosao>();
		testni_poslovi.add(p1);
		testni_poslovi.add(p2);
		RasporedjeniZadatak rz7=new RasporedjeniZadatak();
		rz7.setSavPosao(testni_poslovi);
		assertEquals(testni_poslovi, rz7.getSavPosao());
	}
	
	

}
