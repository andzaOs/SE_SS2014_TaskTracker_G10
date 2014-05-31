package Kontroleri;

import java.sql.Date;

import junit.framework.TestCase;

public class EvidencijaRadaRacunovodstvoControlerTest extends TestCase {
EvidencijaRadaRacunovodstvoControler e;
	
	public void testPronadjiObavljenePoslove() throws Exception {
		e = new EvidencijaRadaRacunovodstvoControler();
		Boolean neizvrsen=false;
		String ime="Anela";
		String prezime="";
		String jmbg="";
		Boolean klijentOdabran=false;
		int indexKlijent=0;
		Boolean izvrsen=false;
		Boolean vrstaUslugeOdabrana=false;
		int indexVrstaUsluge=0;
		Date pocetniDatum=null;
		Date krajnjiDatum=null;
//		Zavisi od podataka u bazi pa je zakomentarisano
//		e.PronadjiObavljenePoslove(neizvrsen, ime, prezime, jmbg, klijentOdabran, indexKlijent, izvrsen, vrstaUslugeOdabrana, indexVrstaUsluge, pocetniDatum, krajnjiDatum);
//		assertEquals(1, e.getObavljeniPosao().size());
	}
}
