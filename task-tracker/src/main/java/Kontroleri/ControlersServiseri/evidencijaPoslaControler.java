package Kontroleri.ControlersServiseri;

import java.util.Date;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import DAO.ObavljeniPosaoDAO;
import DAO.VrstaUslugeDAO;
import Entity.ObavljeniPosao;
import Entity.RadniZadatak;
import Entity.RasporedjeniZadatak;
import Entity.VrstaUsluge;

public class evidencijaPoslaControler {
	public evidencijaPoslaControler() {}
	
	public String evidentirajPosao(JComboBox comboUsluga,JTextArea opisPoslaTxt,
			JDatePickerImpl datumObavljanja,JSpinner spinnVrijeme,RasporedjeniZadatak zadatak) throws Exception{
		try{
		if(comboUsluga.getSelectedIndex()==-1 || datumObavljanja.getModel().getValue()==null || opisPoslaTxt.getText().equals("") || spinnVrijeme.getValue()==null ){
			return "Morate unijeti i odabrati sva polja!";
		}
		else{
		
		Date d=(Date) datumObavljanja.getModel().getValue();
		if(d.before(zadatak.getDatumPrihvatanja())){return "Datum mora biti veci od datuma prihvacanja zadatka!";}
		else if(d.before(zadatak.getZadatak().getDatumUnosa())){return "Datum mora biti veci od datuma prihvacanja zadatka!";}
		else{
			ObavljeniPosao posao=new ObavljeniPosao();
			posao.setPripadajuciZadatak(zadatak);
			int value = (Integer) spinnVrijeme.getValue();
			posao.setBrojSati(value);
			java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			posao.setDatumUnosa(sqlDate);
		java.sql.Date sqlDate1 = new java.sql.Date(d.getTime());
		posao.setDatumObavljanja(sqlDate1);
		posao.setOpisa(opisPoslaTxt.getText());
		VrstaUslugeDAO uDAO= new VrstaUslugeDAO();
		final List<VrstaUsluge> usluge;
		usluge=uDAO.getAll();
		posao.setVrstaUsluge(usluge.get(comboUsluga.getSelectedIndex()));
		posao.setVidljivo(true);
		ObavljeniPosaoDAO oDAO = new  ObavljeniPosaoDAO();
		oDAO.create(posao);
		return "Uspješno ste evidentirali posao!";}}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return "";	

}
	}

