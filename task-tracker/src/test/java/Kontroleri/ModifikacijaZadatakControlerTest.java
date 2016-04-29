package Kontroleri;

import java.util.Date;

import junit.framework.TestCase;
import DAO.RadniZadatakDAO;
import Entity.RadniZadatak;

public class ModifikacijaZadatakControlerTest extends TestCase
{
ModifikacijaZadatakControler m;
	
	public void testSetKlijenti() throws Exception {
		m = new ModifikacijaZadatakControler();
		m.setKlijenti();
//		assertNotNull(m.getKlijente().get(0).getNaziv());
	}

	public void testModifikujRadniZadatak() {
		RadniZadatakDAO rDAO = new RadniZadatakDAO();
		RadniZadatak r = new RadniZadatak();
//		Da bi kod ispod radio treba postojati radni zadatak s ID-om 15
//		r = rDAO.getById(15);
//		m =new ModifikacijaZadatakControler();
//		Date datum = new Date();
//		m.ModifikujRadniZadatak(r, 4, datum, 0, "Test", "Hardver", false, null);
//		assertEquals("Test", r.getOpis());
	}

}
