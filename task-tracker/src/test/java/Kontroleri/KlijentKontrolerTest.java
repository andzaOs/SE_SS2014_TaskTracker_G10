package Kontroleri;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.KlijentDAO;
import Entity.Klijent;
import junit.framework.TestCase;

public class KlijentKontrolerTest extends TestCase {

	 KlijentKontroler k;
	 
	public void testNapuniTabelu() {
		k = new  KlijentKontroler();
		DefaultTableModel model1 = new DefaultTableModel();	
		try {
			k.napuniTabelu(model1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testNapuniTabeluFiltrirano() {
		k = new  KlijentKontroler();
		DefaultTableModel model1 = new DefaultTableModel();	
		try {
			k.napuniTabeluFiltrirano(model1, "Bosnalijek");;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void testKreiranjeKlijenta() {
		k = new  KlijentKontroler();
		JTextField nazivTxt = new JTextField();
		nazivTxt.setText("Eurolines");
		JTextField adresaTxt = new JTextField();
		adresaTxt.setText("Bosanska 34");
		JTextField emailTxt = new JTextField();
		emailTxt.setText("info@eurolines.ba");
		JTextField brojTelefona = new JTextField();
		brojTelefona.setText("033-222233");
		try {
			assertTrue(k.kreiranjeKlijenta(nazivTxt, adresaTxt, emailTxt, brojTelefona));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void testModifikacijaKlijenta() {
		JTextField nazivTxt = new JTextField();
		nazivTxt.setText("Eurolines1");
		JTextField adresaTxt = new JTextField();
		adresaTxt.setText("Bosanska 34");
		JTextField emailTxt = new JTextField();
		emailTxt.setText("info@eurolines.ba");
		JTextField brojTelefona = new JTextField();
		brojTelefona.setText("033-222233");
		long id = 1;
		try {
			assertTrue(k.modifikacijaKlijenta(nazivTxt, adresaTxt, emailTxt, brojTelefona, id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void testBrisanjeKlijenta() {
		k = new  KlijentKontroler();
		long id = 1;
		try {
			assertTrue(k.brisanjeKlijenta(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
