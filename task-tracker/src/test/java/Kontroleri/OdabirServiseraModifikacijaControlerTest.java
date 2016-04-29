package Kontroleri;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import DAO.KorisnikDAO;
import DAO.RadniZadatakDAO;
import Entity.Korisnik;
import Entity.RadniZadatak;

public class OdabirServiseraModifikacijaControlerTest extends TestCase 
{
OdabirServiseraModifikacijaControler o;
	
//Kod je zakomentarisan zbog razlicitosti podataka u bazi

	public void testSetPostojeceServisere() 
	{
		RadniZadatakDAO rDAO = new RadniZadatakDAO();
		RadniZadatak r = new RadniZadatak();
//		r=rDAO.getById(15);
//		o = new OdabirServiseraModifikacijaControler();
//		o.setPostojeceServisere(r);
//		assertEquals(1, o.getOdabraniServiseri().size());
	}

	public void testSetDostupneServisere() 
	{
		RadniZadatakDAO rDAO = new RadniZadatakDAO();
		RadniZadatak r = new RadniZadatak();
//		r=rDAO.getById(15);
//		o = new OdabirServiseraModifikacijaControler();
//		o.setDostupneServisere(r);
//		assertEquals(1, o.getServiseri().size());
	}

	public void testProvjeriBrojServisera() 
	{
		int index[]={0};
		o = new OdabirServiseraModifikacijaControler();
		RadniZadatakDAO rDAO = new RadniZadatakDAO();
		RadniZadatak r = new RadniZadatak();
//		r=rDAO.getById(22);
//		o.setPostojeceServisere(r);
//		o.setDostupneServisere(r);
//		@SuppressWarnings("unused")
//		int size = o.getSelektoviServiseriSize(index);
//		Boolean dozvoljen = o.ProvjeriBrojServisera(4);
//		assertTrue(dozvoljen);
	}

	public void testGetRedoviTabele() 
	{
		int index[]={0};
		o = new OdabirServiseraModifikacijaControler();
		RadniZadatakDAO rDAO = new RadniZadatakDAO();
		RadniZadatak r = new RadniZadatak();
//		r=rDAO.getById(22);
//		o.setDostupneServisere(r);
//		@SuppressWarnings("unused")
//		int size = o.getSelektoviServiseriSize(index);
//		@SuppressWarnings({ "rawtypes", "unchecked" })
//		List<List> redoviTabele = new ArrayList();
//		redoviTabele=o.getRedoviTabele(1);
//		assertEquals(1, redoviTabele.size());
	}

	public void testGetSelektoviServiseriSize() 
	{
		int index[]={0};
		o = new OdabirServiseraModifikacijaControler();
		RadniZadatakDAO rDAO = new RadniZadatakDAO();
		RadniZadatak r = new RadniZadatak();
//		r=rDAO.getById(22);
//		o.setDostupneServisere(r);
//		int size = o.getSelektoviServiseriSize(index);
//		assertEquals(1, size);
	}

	public void testGetSelektovaniServiser() 
	{
		o = new OdabirServiseraModifikacijaControler();
		RadniZadatakDAO rDAO = new RadniZadatakDAO();
		RadniZadatak r = new RadniZadatak();
//		r=rDAO.getById(22);
//		o.setDostupneServisere(r);
//		KorisnikDAO kDAO = new KorisnikDAO();
//		Korisnik k = new Korisnik();
//		k=kDAO.getById(3);
//		int index[]={0};
//		@SuppressWarnings("unused")
//		int size = o.getSelektoviServiseriSize(index);
//		assertEquals(k.getKorisnik_id(), o.getSelektovaniServiser(0).getKorisnik_id());
	}

}
