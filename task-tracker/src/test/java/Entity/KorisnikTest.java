package Entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

public class KorisnikTest extends TestCase {
	
	public void testGetKorisnik_id(){
		Korisnik k1= new Korisnik();
		k1.setKorisnik_id(245);
	    long test_id=k1.getKorisnik_id();
		assertEquals(245, test_id);
	}
	
	public void testGetIme() {
		Korisnik k2= new Korisnik();
		k2.setIme("Testno ime");
		assertEquals("Testno ime", k2.getIme());
	}
	
	public void testGetPrezime() {
		Korisnik k3= new Korisnik();
		k3.setPrezime("Testno prezime");
		assertEquals("Testno prezime", k3.getPrezime());
	}
	
	public void testGetJmbg() {
		Korisnik k4= new Korisnik();
		k4.setJmbg("Testni jmbg");
		assertEquals("Testni jmbg", k4.getJmbg());
	}
	
	public void testGetBr_lk() {
		Korisnik k5= new Korisnik();
		k5.setBr_lk("Testni broj licne karte");
		assertEquals("Testni broj licne karte", k5.getBr_lk());
	}
	
	public void testGetAdresa() {
		Korisnik k6= new Korisnik();
		k6.setAdresa("Testna adresa");
		assertEquals("Testna adresa" , k6.getAdresa());
	}
	
	public void testGetBroj_telefona() {
		Korisnik k7= new Korisnik();
		k7.setTelefon("061 865 688");
		assertEquals("061 865 688" , k7.getTelefon());
	}
	
	public void testGetEmail() {
		Korisnik k8= new Korisnik();
		k8.setEmail("testni@mail.com");
		assertEquals("testni@mail.com" , k8.getEmail());
	}
	
	public void testKorisnicko_ime() {
		Korisnik k9= new Korisnik();
		k9.setKorisnicko_ime("testno korisnicko ime");
		assertEquals("testno korisnicko ime" , k9.getKorisnicko_ime());
	}
	
	public void testDatum_zaposlenja() {
		Korisnik k11= new Korisnik();
	
		Date d1=new Date(1991);
		k11.setDatum_zaposlenja(d1);
		assertEquals(d1 , k11.getDatum_zaposlenja());
	}
	
	public void testGetVidljivo() {
		Korisnik k12= new Korisnik();
		k12.setVidljivo(6>3);
		assertTrue(k12.getVidljivo());
		k12.setVidljivo(3>6);
		assertFalse(k12.getVidljivo());
	}
	
	public void testGetTip_korisnika() {
		TipKorisnika testni_tip_korisnika= new TipKorisnika();
		testni_tip_korisnika.setTipKorisnika_id(1);
		Korisnik k13= new Korisnik();
		k13.setTip_korisnika(testni_tip_korisnika);
		assertEquals(testni_tip_korisnika,k13.getTip_korisnika());
	}
	
	public void testGetDodjeljeniZadaci() {
		RadniZadatak z1 = new RadniZadatak();
		z1.setRadniZadatak_id(1);
		RadniZadatak z2 = new RadniZadatak();
		z2.setRadniZadatak_id(2);
	
		Set<RadniZadatak> testni_zadaci = new HashSet<RadniZadatak>();
		testni_zadaci.add(z1);
		testni_zadaci.add(z2);
		Korisnik k14= new Korisnik();
		k14.setDodjeljeniZadaci(testni_zadaci);
		assertEquals(testni_zadaci, k14.getDodjeljeniZadaci());
	}
	
	public void testGetVlastiti_zadaci() {
		RasporedjeniZadatak z1 = new RasporedjeniZadatak();
		z1.setRasporedjeniZadatak_id(1);
		RasporedjeniZadatak z2 = new RasporedjeniZadatak();
		z2.setRasporedjeniZadatak_id(2);
	
		Set<RasporedjeniZadatak> testni_zadaci = new HashSet<RasporedjeniZadatak>();
		testni_zadaci.add(z1);
		testni_zadaci.add(z2);
		Korisnik k15= new Korisnik();
		k15.setVlastitiZadaci(testni_zadaci);
		assertEquals(testni_zadaci, k15.getVlastitiZadaci());
	}

}
