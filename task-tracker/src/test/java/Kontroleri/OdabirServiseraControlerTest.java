package Kontroleri;

import junit.framework.TestCase;
import DAO.KorisnikDAO;
import DAO.RadniZadatakDAO;
import Entity.Korisnik;
import Entity.RadniZadatak;

public class OdabirServiseraControlerTest extends TestCase 
{
OdabirServiseraControler o;
	
	public void testSetServisere() {
		RadniZadatakDAO rDAO = new RadniZadatakDAO();
		RadniZadatak r = new RadniZadatak();
		r=rDAO.getById(15);
		o = new OdabirServiseraControler();
		o.setServisere(r);
		//Testiramo broj servisera kojim ovaj zadatak nije dodijeljen
		assertEquals(0, o.getServiseri().size());
		
	}

	public void testProvjeriBrojServisera() {
		int index[]={0};
		o = new OdabirServiseraControler();
		RadniZadatakDAO rDAO = new RadniZadatakDAO();
		RadniZadatak r = new RadniZadatak();
		r=rDAO.getById(22);
		o.setServisere(r);
		@SuppressWarnings("unused")
		int size = o.getSelektoviServiseriSize(index);
		Boolean dozvoljen = o.ProvjeriBrojServisera(4);
		assertTrue(dozvoljen);
	}

	public void testGetSelektoviServiseriSize() {
		int index[]={0};
		o = new OdabirServiseraControler();
		RadniZadatakDAO rDAO = new RadniZadatakDAO();
		RadniZadatak r = new RadniZadatak();
		r=rDAO.getById(22);
		o.setServisere(r);
		int size = o.getSelektoviServiseriSize(index);
		assertEquals(1, size);
	}

	public void testGetSelektovaniServiser() {
		o = new OdabirServiseraControler();
		RadniZadatakDAO rDAO = new RadniZadatakDAO();
		RadniZadatak r = new RadniZadatak();
		r=rDAO.getById(22);
		o.setServisere(r);
		KorisnikDAO kDAO = new KorisnikDAO();
		Korisnik k = new Korisnik();
		k=kDAO.getById(3);
		int index[]={0};
		@SuppressWarnings("unused")
		int size = o.getSelektoviServiseriSize(index);
		assertEquals(k.getKorisnik_id(), o.getSelektovaniServiser(0).getKorisnik_id());
		
	}

	public void testDodijeliServisere() {
		o = new OdabirServiseraControler();
		RadniZadatakDAO rDAO = new RadniZadatakDAO();
		RadniZadatak r = new RadniZadatak();
		r=rDAO.getById(22);
		o.setServisere(r);
		int index[]={0};
		@SuppressWarnings("unused")
		int size = o.getSelektoviServiseriSize(index);
		Boolean dodijeljeno = o.DodijeliServisere(r);
		//False je zato sto je maskimalni broj servisera popunjen
		assertFalse(dodijeljeno);
	}

}
