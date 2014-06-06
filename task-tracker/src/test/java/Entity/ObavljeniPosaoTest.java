package Entity;


import junit.framework.TestCase;

public class ObavljeniPosaoTest extends TestCase {
	
	public void testGetOpavljeniPosao_id() {
		ObavljeniPosao p1= new ObavljeniPosao();
		p1.setObavljeniPosao_id(160);
		assertEquals(160, p1.getObavljeniPosao_id());
	}
	
	public void testGetPripadajuciZadatak() {
		RasporedjeniZadatak z1= new RasporedjeniZadatak();
		z1.setRasporedjeniZadatak_id(12);
		ObavljeniPosao p2= new ObavljeniPosao();
		p2.setPripadajuciZadatak(z1);
		assertEquals(z1, p2.getPripadajuciZadatak());
	}
	
	public void testGetVrstaUsluge() {
		VrstaUsluge u1= new VrstaUsluge();
		u1.setVrstaUsluge_id(12);
		ObavljeniPosao p3= new ObavljeniPosao();
		p3.setVrstaUsluge(u1);
		assertEquals(u1, p3.getVrstaUsluge());
	}
	
	public void testGetBrojSati() {
		ObavljeniPosao p4= new ObavljeniPosao();
		p4.setBrojSati(0);
		assertEquals(0, p4.getBrojSati());
	}
	
	
	public void testGetOpisa(){
		ObavljeniPosao p7= new ObavljeniPosao();
		p7.setOpisa("testni opis");
		assertEquals("testni opis" , p7.getOpisa());
	}
	
	public void testGetVidljivo() {
		ObavljeniPosao p8= new ObavljeniPosao();
		p8.setVidljivo(6>3);
		assertTrue(p8.getVidljivo());
		p8.setVidljivo(3>6);
		assertFalse(p8.getVidljivo());
	}
	
	
	
	

}
