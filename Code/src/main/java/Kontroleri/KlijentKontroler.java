package Kontroleri;

import java.io.IOException;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.KlijentDAO;
import Entity.Klijent;
import RacunovodstvoGUI.IzbrisiKlijentaGUI;
import RacunovodstvoGUI.ModifikovanjeKlijentaGUI;
import UtilClasses.Validacija;



public class KlijentKontroler {
	private List<Klijent> klijenti;
	
	public KlijentKontroler() {}
	
	public void napuniTabelu(DefaultTableModel t) throws Exception {
		try {
			KlijentDAO kDAO = new KlijentDAO();
	 		klijenti = kDAO.getAll(); 
	 		for(int i=0; i<klijenti.size(); i++) {
	 			if(klijenti.get(i).getVidljivo()) {
					String naziv = klijenti.get(i).getNaziv(); 
					String telefon = klijenti.get(i).getBroj_telefona(); 
					String adresa = klijenti.get(i).getAdresa();
					String mail = klijenti.get(i).getEmail();
					
					Object[] o = {naziv, telefon, adresa, mail};
					
					t.addRow(o);
	 			}
	 			else {
	 				klijenti.remove(i);
	 				i=i-1;;
	 			}
	 		}
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public void napuniTabeluFiltrirano(DefaultTableModel t, String n) throws Exception {
		try {
			KlijentDAO kDAO = new KlijentDAO();
			if(n.equals("")) n="%";
	 		klijenti = kDAO.getByNaziv(n); 
	 		
	 		for(int i=0; i<klijenti.size(); i++) {
	 			if(klijenti.get(i).getVidljivo()) {
					String naziv = klijenti.get(i).getNaziv(); 
					String telefon = klijenti.get(i).getBroj_telefona(); 
					String adresa = klijenti.get(i).getAdresa();
					String mail = klijenti.get(i).getEmail();
					
					Object[] o = {naziv, telefon, adresa, mail};
					
					t.addRow(o);
	 			}
	 			else {
	 				klijenti.remove(i);
	 				i=i-1;
	 			}
	 		
	 		}
		}
		catch (Exception e) {
			throw e;
		}
	}

	public Boolean kreiranjeKlijenta(JTextField nazivTxt, JTextField adresaTxt, JTextField emailTxt, JTextField brojTelefonaTxt) throws Exception {
			try {
				Validacija v = new Validacija();
			    Boolean uslov1 = v.praznoPoljeBolean(nazivTxt);
			    Boolean uslov2 = v.minimalnaDuzina(nazivTxt, 2);
			    Boolean uslov3 = v.praznoPoljeBolean(adresaTxt);
			    Boolean uslov4 = v.minimalnaDuzina(adresaTxt, 5);
			    Boolean uslov5 = v.emailAdresa(emailTxt);
			    Boolean uslov6 = v.praznoPoljeBolean(brojTelefonaTxt);
			    Boolean uslov7 = v.brojTelefona(brojTelefonaTxt);
				final Boolean validno = (uslov1 && uslov2 && uslov3 && uslov4 && uslov5 && uslov6 && uslov7);
				if(validno) {
					
					Klijent kl = new Klijent();
					kl.setNaziv(nazivTxt.getText());
					kl.setAdresa(adresaTxt.getText());
					kl.setEmail(emailTxt.getText());
					kl.setBroj_telefona(brojTelefonaTxt.getText());
					kl.setVidljivo(true);
					KlijentDAO klDAO = new KlijentDAO();
					long id = klDAO.create(kl);
					nazivTxt.setText("");
					emailTxt.setText("");
					adresaTxt.setText("");
					brojTelefonaTxt.setText("");
					return true;	
				}
				else {
					return false;
				}
			}
			catch (Exception e){
				throw e;
			}
	}
	
	public void otvoriModifikaciju(int i) {
		Klijent selektovani = klijenti.get(i);		 		        	
         ModifikovanjeKlijentaGUI ex = ModifikovanjeKlijentaGUI.dajInstancu(selektovani.getKlijent_id());
         ex.setSize(250,200);
         ex.setVisible(true);
         ex.setLocationRelativeTo(null);
	}
	
	public Boolean modifikacijaKlijenta(JTextField nazivTxt, JTextField adresaTxt, JTextField emailTxt, JTextField brojTelefonaTxt, long id) throws Exception {
			try {
				Validacija v = new Validacija();
				Boolean uslov1 = v.praznoPoljeBolean(nazivTxt);
				Boolean uslov2 = v.minimalnaDuzina(nazivTxt, 2);
				Boolean uslov3 = v.praznoPoljeBolean(adresaTxt);
				Boolean uslov4 = v.minimalnaDuzina(adresaTxt, 5);
				Boolean uslov5 = v.emailAdresa(emailTxt);
				Boolean uslov6 = v.praznoPoljeBolean(brojTelefonaTxt);
				Boolean uslov7 = v.brojTelefona(brojTelefonaTxt);
				final Boolean validno = (uslov1 && uslov2 && uslov3 && uslov4 && uslov5 && uslov6 && uslov7);
				if(validno) {
					Klijent k = new Klijent();
					k.setKlijent_id(id);
					k.setNaziv(nazivTxt.getText());
					k.setAdresa(adresaTxt.getText());
					k.setEmail(emailTxt.getText());
					k.setBroj_telefona(brojTelefonaTxt.getText());
					k.setVidljivo(true);
						
					KlijentDAO klDAO3 = new KlijentDAO();
					klDAO3.update(k);
					return true;
				}
				else{
					return false;
				}
			}
			catch (Exception e){
				throw e;
			}
	}
	
	public void otvoriBrisanje(int i) {
		Klijent selektovani = klijenti.get(i);
        IzbrisiKlijentaGUI ex = new IzbrisiKlijentaGUI(selektovani.getKlijent_id());
        ex.setSize(600, 150);
        ex.setLocationRelativeTo(null);
        ex.setVisible(true);
	}
	
	public Boolean brisanjeKlijenta(long id) throws Exception {
		try {
			KlijentDAO kDAO = new KlijentDAO();
			Klijent kl = kDAO.getById(id);
			Klijent k = new Klijent();
			k.setKlijent_id(kl.getKlijent_id());
			k.setNaziv(kl.getNaziv());
			k.setAdresa(kl.getAdresa());
			k.setEmail(kl.getEmail());
			k.setBroj_telefona(kl.getBroj_telefona());
			k.setVidljivo(kl.getVidljivo());
			KlijentDAO kDAO2 = new KlijentDAO();
			kDAO2.delete(k);
			return true;
		}
		catch(Exception e){
			throw e;
		}
	}
	
}
