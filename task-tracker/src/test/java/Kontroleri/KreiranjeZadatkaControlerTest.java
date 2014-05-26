package Kontroleri;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import Entity.Korisnik;

public class KreiranjeZadatkaControlerTest extends TestCase 
{
KreiranjeZadatkaControler k;
	
	public void tearDown() throws Exception {
	k=null;
	}

	public void testSetKlijente()
	{
		k = new KreiranjeZadatkaControler();
		k.setKlijenti();
		assertNotNull(k.getKlijente());
	}
	public void testGetKlijente() {
		k = new KreiranjeZadatkaControler();
		k.setKlijenti();
		assertNotNull(k.getKlijente());
	}

	public void testKreirajRadniZadatak() {
		k = new KreiranjeZadatkaControler();
		k.setKlijenti();
		int maksimalanBrojServisera=2;
		Date datumIzvrsenja = new Date();
		int indexKlijent=0;
		String opis="";
		String vrstaZadatka="Hardver";
		Boolean serviserSelektovan=false;
		List<Korisnik> selektovaniServiseri = new ArrayList<Korisnik>();
		k.KreirajRadniZadatak(maksimalanBrojServisera, datumIzvrsenja, indexKlijent, opis, vrstaZadatka, serviserSelektovan, selektovaniServiseri);
		assertEquals(0, k.getBrojRasporedjenihZadataka());
	}
}
