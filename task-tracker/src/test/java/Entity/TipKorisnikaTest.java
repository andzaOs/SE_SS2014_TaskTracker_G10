package Entity;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

public class TipKorisnikaTest extends TestCase {

	public void testGetTipKorisnika_id() {
		TipKorisnika tk1 = new TipKorisnika();
		tk1.setTipKorisnika_id(203);
		assertEquals(203, tk1.getTipKorisnika_id());
	}
	
	public void testGetNaziv() {
		TipKorisnika tk2 = new TipKorisnika();
		tk2.setNaziv("testni naziv");
		assertEquals("testni naziv", tk2.getNaziv());
	}
	
	public void testGetVidljivo() {
		TipKorisnika tk3 = new TipKorisnika();
		tk3.setVidljivo(6>3);
		assertTrue(tk3.getVidljivo());
		tk3.setVidljivo(3>6);
		assertFalse(tk3.getVidljivo());
	}
	
	public void testGetKorisnici() {
		Korisnik k1 = new Korisnik();
		k1.setKorisnik_id(1);
		Korisnik k2 = new Korisnik();
		k2.setKorisnik_id(2);
	
		Set<Korisnik> testni_korisnici = new HashSet<Korisnik>();
		testni_korisnici.add(k1);
		testni_korisnici.add(k2);
		TipKorisnika tk4 = new TipKorisnika();
		tk4.setKorisnici(testni_korisnici);
		assertEquals(testni_korisnici, tk4.getKorisnici());
	}
}
