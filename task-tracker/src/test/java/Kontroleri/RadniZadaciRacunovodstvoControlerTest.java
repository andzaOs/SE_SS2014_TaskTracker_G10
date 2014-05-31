package Kontroleri;

import java.util.Date;

import junit.framework.TestCase;

public class RadniZadaciRacunovodstvoControlerTest extends TestCase 
{

	RadniZadaciRacunovodstvoControler r;
	public void testPronadjiRadneZadatke() throws Exception {
		r = new RadniZadaciRacunovodstvoControler();
		String ime = "Anela";
		String prezime = "";
		int indexKlijent=0;
		Date datumKreiranja=null;
		Date datumPreuzimanja=null;
		Date datumIzvrsenja=null;
		Date krajnjiDatumIzvrsenja=null;
		Boolean neizvrsen = false;
		Boolean nedodjeljen = false;
		Boolean neprihvacen = false;
//		Zavisi od baze pa je zakomentirano
//		r.PronadjiRadneZadatke(ime, prezime, false, indexKlijent, datumKreiranja, datumPreuzimanja, datumIzvrsenja, krajnjiDatumIzvrsenja, neizvrsen, nedodjeljen, neprihvacen);
//		assertEquals(7, r.getRadniZadaci().size());
	}
}
