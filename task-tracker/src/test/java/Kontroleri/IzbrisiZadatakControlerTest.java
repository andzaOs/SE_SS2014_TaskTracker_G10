package Kontroleri;

import DAO.RadniZadatakDAO;
import Entity.RadniZadatak;
import junit.framework.TestCase;

public class IzbrisiZadatakControlerTest extends TestCase {
	IzbrisiZadatakControler c;
	public void testIzbrisi() {
	c=new IzbrisiZadatakControler();
	RadniZadatakDAO rDAO = new RadniZadatakDAO();
	RadniZadatak z = new RadniZadatak();
//	z=rDAO.getById(15);
//	c.Izbrisi(z);
//	assertFalse(z.getVidljivo());	
}
}
