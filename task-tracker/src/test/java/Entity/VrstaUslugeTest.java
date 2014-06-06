package Entity;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

public class VrstaUslugeTest extends TestCase {
	
	public void testGetVrstaUsluge_id() {
		VrstaUsluge vu1= new VrstaUsluge();
		vu1.setVrstaUsluge_id(203);
		assertEquals(203, vu1.getVrstaUsluge_id());
	}
	
	public void testGetNaziv() {
		VrstaUsluge vu2= new VrstaUsluge();
		vu2.setNaziv("testni naziv");
		assertEquals("testni naziv", vu2.getNaziv());
	}
	
	public void testGetSavObavljeniPosao() {
		ObavljeniPosao p1 = new ObavljeniPosao();
		p1.setObavljeniPosao_id(1);
		ObavljeniPosao p2 = new ObavljeniPosao();
		p2.setObavljeniPosao_id(2);
	
		Set<ObavljeniPosao> testni_poslovi = new HashSet<ObavljeniPosao>();
		testni_poslovi.add(p1);
		testni_poslovi.add(p2);
		VrstaUsluge vu3= new VrstaUsluge();
		vu3.setSavObavljeniPosao(testni_poslovi);
		assertEquals(testni_poslovi, vu3.getSavObavljeniPosao());
	}
	
	public void testGetVidljivo() {
		VrstaUsluge vu4= new VrstaUsluge();
		vu4.setVidljivo(6>3);
		assertTrue(vu4.getVidljivo());
		vu4.setVidljivo(3>6);
		assertFalse(vu4.getVidljivo());
	}

}
