package Kontroleri.ControlersServiseri;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import DAO.KorisnikDAO;
import DAO.RadniZadatakDAO;
import DAO.RasporedjeniZadatakDAO;
import Entity.Korisnik;
import Entity.RadniZadatak;
import Entity.RasporedjeniZadatak;
import junit.framework.TestCase;

public class RadniZadaciControlerTest extends TestCase {
	RadniZadaciControler r;
	
	public void testPronadji() {
		r = new RadniZadaciControler();
		long id = 9;
		try {
			r.pronadji(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
// 		Ovisi od stanja u bazi
//		assertEquals(7, r.getRasporedjeniZadaci().size());
	}
// Ne znam fkt kako da ovo testiram
//	public void testIspisi() {
//		
//	}

	public void testPretraga() 
	{
		r = new RadniZadaciControler();
		JTextField nazivKlijenta = new JTextField();
		nazivKlijenta.setText("Bosnalijek");
		UtilDateModel model = new UtilDateModel();
		final JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datumIzvrsenja = new JDatePickerImpl(datePanel);
		JDatePickerImpl datumKreiranja = new JDatePickerImpl(datePanel);
		datumKreiranja.getModel().setValue(null);
		datumIzvrsenja.getModel().setValue(null);
		JComboBox<String> vrstaZadatkacombo = new JComboBox<String>();
		vrstaZadatkacombo.addItem("");
		vrstaZadatkacombo.setSelectedIndex(0);;
		DefaultTableModel model1 = new DefaultTableModel();
		List<RadniZadatak> zadaci = new ArrayList<RadniZadatak>();
		RadniZadatakDAO rDAO = new RadniZadatakDAO();
		zadaci.addAll(rDAO.getAll());
		List<RasporedjeniZadatak> rzadaci = new ArrayList<RasporedjeniZadatak>();
		RasporedjeniZadatakDAO rDAO1 = new RasporedjeniZadatakDAO();
		rzadaci = rDAO1.getAll();
		r.pretraga(nazivKlijenta, datumIzvrsenja, datumKreiranja, vrstaZadatkacombo, model1, zadaci, rzadaci, zadaci);
		// ovisi od baze
		//assertEquals(1, r.getLista().size());
	}

	public void testPrikaziVise() {
		r = new RadniZadaciControler();
		DefaultTableModel model1 = new DefaultTableModel();
		model1.setRowCount(2);
		assertEquals("", r.prikaziVise(1, model1));
	}


	public void testPreuzmiRadniZadatak() {
		r = new RadniZadaciControler();
		int red=0;
		RadniZadatakDAO rDAO = new RadniZadatakDAO();
		RasporedjeniZadatakDAO rzDAO = new RasporedjeniZadatakDAO();
		List<RadniZadatak> serZadaci = new ArrayList<RadniZadatak>();
		List<RadniZadatak> dostupniZadaci = new ArrayList<RadniZadatak>();
		List<RasporedjeniZadatak> Zadaci = new ArrayList<RasporedjeniZadatak>();
		Korisnik serviser = new Korisnik();
		KorisnikDAO kDAO = new KorisnikDAO();
		long id = 9;
		serviser = kDAO.getById(id);
		Zadaci = rzDAO.getByServiser(serviser);
		for(RasporedjeniZadatak r: Zadaci)
		serZadaci.add(r.getZadatak());
//		dostupniZadaci = rDAO.getByPotpunoDodijeljen(false);
//		Ovisi od stanja u bazi
//		assertEquals("Uspješno ste preuzeli zadatak", r.preuzmiRadniZadatak(red, serZadaci, dostupniZadaci, id));
	}

}
