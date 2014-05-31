package Kontroleri;

import java.sql.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import DAO.KorisnikDAO;
import Entity.Korisnik;
import junit.framework.TestCase;

public class IzvjestajKontrolerTest extends TestCase {

	IzvjestajKontroler i;
	
	public void testNapuniTabeluRadnik() {
		i = new IzvjestajKontroler();
		Korisnik k = new Korisnik();
		KorisnikDAO kDAO = new KorisnikDAO();
		long id = 9;
		k = kDAO.getById(id);
		DefaultTableModel model = new DefaultTableModel();
		@SuppressWarnings("deprecation")
		Date d1 = new Date(29, 05, 2014);
		@SuppressWarnings("deprecation")
		Date d2 = new Date(23, 10, 2014);
		
		try {
			i.napuniTabeluRadnik(model, k, d1, d2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testNapraviPdfRadnik() {
		i = new IzvjestajKontroler();
		Korisnik k = new Korisnik();
		KorisnikDAO kDAO = new KorisnikDAO();
		long id = 9;
		k = kDAO.getById(id);
		@SuppressWarnings("deprecation")
		Date d1 = new Date(29, 05, 2014);
		@SuppressWarnings("deprecation")
		Date d2 = new Date(23, 10, 2014);
		try {
			i.napraviPdfRadnik(k, d1, d2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testOtvoriFormu() {
		i = new IzvjestajKontroler();
		JComboBox<String> unosCmbx = new JComboBox<String>();
		unosCmbx.setSelectedItem("");
		@SuppressWarnings("deprecation")
		Date d1 = new Date(29, 05, 2014);
		@SuppressWarnings("deprecation")
		Date d2 = new Date(23, 10, 2014);
		i.otvoriFormu(unosCmbx, "", d1, d2);
	}

//	public void testNapuniUnosCmbx() {
//		i = new IzvjestajKontroler();
//		JComboBox<String> vrstaIzvjestajaCmbx = new JComboBox<String>();
//		vrstaIzvjestajaCmbx.addItem("Po radniku");
//		JComboBox unosCmbx = new JComboBox();
//		unosCmbx.addItem("");
//		JLabel unosLbl = new JLabel();
//		unosLbl.setText("");
//		i.napuniUnosCmbx(vrstaIzvjestajaCmbx, unosCmbx, unosLbl);
//		
//	}

	public void testNapuniTabeluUsluga() {
		i = new IzvjestajKontroler();
		DefaultTableModel model = new DefaultTableModel();
		@SuppressWarnings("deprecation")
		Date d1 = new Date(29, 05, 2014);
		@SuppressWarnings("deprecation")
		Date d2 = new Date(23, 10, 2014);
	}


}
