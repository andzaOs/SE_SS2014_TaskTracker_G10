package Kontroleri.ControlersServiseri;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import junit.framework.TestCase;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import DAO.KorisnikDAO;
import DAO.ObavljeniPosaoDAO;
import DAO.RasporedjeniZadatakDAO;
import Entity.Korisnik;
import Entity.ObavljeniPosao;
import Entity.RasporedjeniZadatak;

public class ObavljeniPosaoControlerTest extends TestCase {
	ObavljeniPosaoControler o;

	public void testPretraga() 
	{
		o = new ObavljeniPosaoControler();
//		JTextField nazivKlijenta = new JTextField();
//		nazivKlijenta.setText("Bosnalijek");
//		UtilDateModel model = new UtilDateModel();
//		final JDatePanelImpl datePanel = new JDatePanelImpl(model);
//		JDatePickerImpl datumObavljanja = new JDatePickerImpl(datePanel);
//		datumObavljanja.getModel().setValue(null);
//		JComboBox<String> comboUsluga = new JComboBox<String>();
//		comboUsluga.setSelectedItem("Instalacija OS");
//		JSpinner spinnSati = new JSpinner();
//		spinnSati.setValue(2);
//		DefaultTableModel model1 = new DefaultTableModel();
//		List<ObavljeniPosao> li = new ArrayList<ObavljeniPosao>();
//		List<ObavljeniPosao> po = new ArrayList<ObavljeniPosao>();
//		ObavljeniPosaoDAO opDAO = new ObavljeniPosaoDAO();
//		li.addAll(opDAO.getAll());
//		Korisnik k = new Korisnik();
//		KorisnikDAO kDAO = new KorisnikDAO();
//		k = kDAO.getById(9);
//		List<RasporedjeniZadatak> r = new ArrayList<RasporedjeniZadatak>();
//		RasporedjeniZadatakDAO rDAO = new RasporedjeniZadatakDAO();
//		r = rDAO.getByServiser(k);
//		for(RasporedjeniZadatak rz: r)
//		po.addAll(opDAO.getByRasporedjeniZadatak(rz));
//		li.addAll(po);
//		model1.setRowCount(li.size());
//		assertEquals("Niti jedan obavljeni posao nije pronađen u bazi!", o.pretraga(nazivKlijenta, datumObavljanja, comboUsluga, spinnSati, model1, li, po));
//		
	}

	public void testPrikaziVise() {
		o = new ObavljeniPosaoControler();
//		DefaultTableModel model1 = new DefaultTableModel();
//		model1.setRowCount(2);
//		assertEquals("", o.prikaziVise(1, model1));
	}

}
