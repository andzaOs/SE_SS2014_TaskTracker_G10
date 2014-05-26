package Kontroleri;

import junit.framework.TestCase;

public class EvidencijaRadaRacunovodstvoControlerTest extends TestCase 
{
EvidencijaRadaRacunovodstvoControler e;
	
	public void testUnesenaPretragaZaServisera() 
	{
		e = new EvidencijaRadaRacunovodstvoControler();
		e.UnesenaPretragaZaServisera("Anesa", "", "");
		assertEquals(1, e.getRaPoServiserima().size());
	}

	public void testUnesenaPretrageZaRadneZadatke() 
	{
		e = new EvidencijaRadaRacunovodstvoControler();
		e.UnesenaPretrageZaRadneZadatke(false, true, 0);
		assertEquals(0, e.getRaPoZadacima().size());
	}

	public void testUnsesenaPretragaZaVrstuUsluge() 
	{
		e = new EvidencijaRadaRacunovodstvoControler();
		e.UnsesenaPretragaZaVrstuUsluge(true, 1, null, null);
		assertEquals(1, e.getRaPoUsluzi().size());
	}

	public void testGrupisiRasporedjeneZadatke() 
	{
		e = new EvidencijaRadaRacunovodstvoControler();
		e.UnesenaPretragaZaServisera("Anesa", "", "");
		e.UnesenaPretrageZaRadneZadatke(false, false, 0);
		e.UnsesenaPretragaZaVrstuUsluge(true, 1, null, null);
		e.GrupisiRasporedjeneZadatke();
		assertEquals(1, e.getRasporedjeniZadaci().size());
	}

	public void testPronadjiObavljenePoslove() 
	{
//		e = new EvidencijaRadaRacunovodstvoControler();
//		e.PronadjiObavljenePoslove(true, "Anesa", "", "", true, 0, false, true, 1, null, null);
//		assertEquals(1, e.getObavljeniPosao().size());
		
	}

}
