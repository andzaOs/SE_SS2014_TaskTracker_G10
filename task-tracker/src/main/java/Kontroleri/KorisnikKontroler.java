package Kontroleri;

import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.KorisnikDAO;
import Entity.Korisnik;
import Entity.TipKorisnika;
import RacunovodstvoGUI.IzbrisiKorisnikaGUI;
import RacunovodstvoGUI.ModifikacijaKorisnikaGUI;
import RacunovodstvoGUI.PrikaziDetaljnoKorisnikaGUI;
import UtilClasses.Validacija;
import ba.unsa.etf.si.tim10.task_tracker.LoginGUI;

public class KorisnikKontroler {
	
	private List<Korisnik> korisnici;
	
	@SuppressWarnings("deprecation")
	public Boolean promjenaSifre(JPasswordField staraSifraTxt, JPasswordField novaSifraTxt, long id) throws Exception {
		try {
			Validacija v = new Validacija();
			JTextField polje = new JTextField(novaSifraTxt.getText());
			Boolean uslov = v.minimalnaDuzina(polje, 5);
			KorisnikDAO kDAO = new KorisnikDAO();
			KorisnikDAO kDAO2 = new KorisnikDAO();
			Korisnik k = kDAO.getById(id);
			if(staraSifraTxt.getText().hashCode()==k.getLozinka() && uslov) {
				k.setLozinka(novaSifraTxt.getText().hashCode());
				kDAO2.update(k);
				java.awt.Window win[] = java.awt.Window.getWindows(); 
				for(int i=0;i<win.length;i++){ 
					win[i].dispose(); 
				} 
				
				SessionControler.unistiInstancu();
				LoginGUI l = new LoginGUI();
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			throw e;
		}
	}

	public String provjeraPrijave(String username, String pass) throws Exception {
		try {
			KorisnikDAO kDAO = new KorisnikDAO();
			Korisnik k = kDAO.getByUsername(username);
			if(pass.hashCode()==k.getLozinka() && k.getVidljivo()) {
				if(k.getTip_korisnika().getNaziv().equals("Racunovodstvo")) {
					SessionControler sKontroler = SessionControler.dajInstancu(k.getKorisnik_id());
					return "Racunovodstvo";
					
				}
				else if(k.getTip_korisnika().getNaziv().equals("Serviser")) {
					SessionControler sKontroler = SessionControler.dajInstancu(k.getKorisnik_id());
					return "Serviser";
				}
				else { return ""; }
			}
			else return "Netacna sifra";
		}
		catch (Exception e) {
			throw e;
		}
		
	}

	public void napuniTabelu(DefaultTableModel t) throws Exception {
		try {
			KorisnikDAO kDAO = new KorisnikDAO();
	 		korisnici = kDAO.getAll(); 
	 		for(int i=0; i<korisnici.size(); i++) {
	 			if(korisnici.get(i).getVidljivo() && !korisnici.get(i).getKorisnicko_ime().equals("admin") && korisnici.get(i).getKorisnik_id()!=SessionControler.getIdLog()) {
					String ime = korisnici.get(i).getIme();
					String prezime = korisnici.get(i).getPrezime(); 					
					String mail = korisnici.get(i).getEmail();					
					String korisnicko_ime=korisnici.get(i).getKorisnicko_ime();					
					String tip = korisnici.get(i).getTip_korisnika().getNaziv();
					String jmbg = korisnici.get(i).getJmbg();
					
					Object[] o = {ime, prezime, jmbg, korisnicko_ime, mail, tip};
					
					t.addRow(o);
	 			}
	 			else {
	 				korisnici.remove(i);
	 				i=i-1;;
	 			}
	 		}
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public void napuniTabeluFiltrirano(DefaultTableModel t, String im, String p, String j) throws Exception {
		try {
			KorisnikDAO kDAO = new KorisnikDAO();
			if(im.equals("")) im="%";
			if(p.equals("")) p="%";
			if(j.equals("")) j="%";
	 		korisnici = kDAO.getByRestrictions(im,p,j); 
	 		
	 		for(int i=0; i<korisnici.size(); i++) {
	 			if(korisnici.get(i).getVidljivo() && !korisnici.get(i).getKorisnicko_ime().equals("admin") && korisnici.get(i).getKorisnik_id()!=SessionControler.getIdLog()) {
	 				String ime = korisnici.get(i).getIme();
					String prezime = korisnici.get(i).getPrezime(); 
					String mail = korisnici.get(i).getEmail();
					String korisnicko_ime=korisnici.get(i).getKorisnicko_ime();
					String tip = korisnici.get(i).getTip_korisnika().getNaziv();
					String jmbg = korisnici.get(i).getJmbg();
					
					Object[] o = {ime, prezime, jmbg, korisnicko_ime, mail, tip};
					
					t.addRow(o);
	 			}
	 			else {
	 				korisnici.remove(i);
	 				i=i-1;
	 			}
	 		
	 		}
		}
		catch (Exception e) {
			throw e;
		}
	}

	public Boolean kreiranjeKorisnika(Boolean dat, JTextField imeTxt, JTextField prezimeTxt, JTextField jmbgTxt, JTextField brojLKTxt, JTextField adresaTxt,  JTextField telefonTxt, JTextField emailTxt, Date d, JTextField korisnickoImeTxt, JLabel sifraTxt, TipKorisnika tip) throws Exception {
			try {
				
				Validacija v = new Validacija();
				Boolean uslov1 = v.minimalnaDuzina(imeTxt, 2) && v.validirajString(imeTxt);
			    Boolean uslov2 = v.minimalnaDuzina(prezimeTxt, 3) && v.validirajString(prezimeTxt);
			    Boolean uslov3 = v.JMBG(jmbgTxt) ;
			    Boolean uslov4 = v.brojLicneKarte(brojLKTxt);
			    Boolean uslov5 = v.minimalnaDuzina(adresaTxt, 5);
			    Boolean uslov6=v.brojTelefona(telefonTxt);
			    Boolean uslov7=v.emailAdresa(emailTxt);
			    Boolean uslov8=v.jedinstvenJMBG(jmbgTxt);
			    Boolean uslov9=v.jedinstvenUsername(korisnickoImeTxt);
			    Boolean uslov10=v.minimalnaDuzina(korisnickoImeTxt, 3);
			    
			    Boolean uslov12=dat;
			    Boolean validno = (uslov1 && uslov2 && uslov3 && uslov4 && uslov5 && uslov6 && uslov7 && uslov8 && uslov9 && uslov10 && uslov12);
				if(validno) {
					
					Korisnik k1 = new Korisnik();
					k1.setIme(imeTxt.getText());
					k1.setPrezime(prezimeTxt.getText());
					k1.setAdresa(adresaTxt.getText());
					k1.setBr_lk(brojLKTxt.getText());
					k1.setEmail(emailTxt.getText());
					k1.setTelefon(telefonTxt.getText());
					k1.setDatum_zaposlenja(d);
					k1.setTip_korisnika(tip);
					k1.setJmbg(jmbgTxt.getText());
					k1.setKorisnicko_ime(korisnickoImeTxt.getText());
					k1.setLozinka(sifraTxt.getText().hashCode());
					k1.setVidljivo(true);
					KorisnikDAO klDAO = new KorisnikDAO();
					long id = klDAO.create(k1);
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
		Korisnik selektovani = korisnici.get(i);		 		        	
         ModifikacijaKorisnikaGUI ex = ModifikacijaKorisnikaGUI.dajInstancu(selektovani.getKorisnik_id());
         ex.setSize(400,500);
         ex.setVisible(true);
         ex.setLocationRelativeTo(null);
	}
	
	public Boolean modifikacijaKorisnika(Boolean izmjena, JTextField imeTxt, JTextField prezimeTxt, JTextField jmbgTxt, JTextField brojLKTxt, JTextField adresaTxt,  JTextField telefonTxt, JTextField emailTxt, Date d, JTextField korisnickoImeTxt, JTextField sifraTxt, long id, TipKorisnika tip) throws Exception {
			try {
				Validacija v = new Validacija();
				Boolean uslov1 = v.minimalnaDuzina(imeTxt, 2) && v.validirajString(imeTxt);
			    Boolean uslov2 = v.minimalnaDuzina(prezimeTxt, 3) && v.validirajString(prezimeTxt);
			    Boolean uslov3 = v.JMBG(jmbgTxt);
			    Boolean uslov4 = v.brojLicneKarte(brojLKTxt);
			    Boolean uslov5 = v.minimalnaDuzina(adresaTxt, 5);
			    Boolean uslov6=v.brojTelefona(telefonTxt);
			    Boolean uslov7=v.emailAdresa(emailTxt);
			    Boolean uslov8=v.jedinstvenJMBGM(jmbgTxt, id);
			    Boolean uslov9=v.jedinstvenUsernameM(korisnickoImeTxt, id);
			    Boolean uslov10=v.minimalnaDuzina(korisnickoImeTxt, 3);
			    Boolean uslov11;
			    if(sifraTxt.getText().equals("")) { uslov11=true; }
			    else { uslov11=v.minimalnaDuzina(sifraTxt, 5);}
			    
				final Boolean validno = (uslov1 && uslov2 && uslov3 && uslov4 && uslov5 && uslov6 && uslov7 && uslov8 && uslov9 && uslov10 && uslov11);
				if(validno) {
					Korisnik k1 = new Korisnik();
					KorisnikDAO kDAO = new KorisnikDAO();
					KorisnikDAO kDAO2 = new KorisnikDAO();
					Korisnik k = kDAO2.getById(id);
					Date datum = (Date) k.getDatum_zaposlenja();
					k1.setKorisnik_id(id);
					k1.setIme(imeTxt.getText());
					k1.setPrezime(prezimeTxt.getText());
					k1.setAdresa(adresaTxt.getText());
					k1.setBr_lk(brojLKTxt.getText());
					k1.setEmail(emailTxt.getText());
					k1.setTelefon(telefonTxt.getText());
					if(izmjena) {k1.setDatum_zaposlenja(d);}
					else {k1.setDatum_zaposlenja(datum);}
					//k1.setDatum_zaposlenja(d);
					k1.setTip_korisnika(tip);
					k1.setJmbg(jmbgTxt.getText());
					k1.setKorisnicko_ime(korisnickoImeTxt.getText());
					if(sifraTxt.getText().equals("")) { k1.setLozinka(kDAO.getById(id).getLozinka()); }
				    else { k1.setLozinka(sifraTxt.getText().hashCode());}
					
					k1.setVidljivo(true);
					KorisnikDAO klDAO3 = new KorisnikDAO();
					klDAO3.update(k1);
					return true;
				}
				else{
					return false;
				}
			}
			catch (Exception e){
				return true;
			}
	}
	
	public void otvoriBrisanje(int i) {
		Korisnik selektovani = korisnici.get(i);
        IzbrisiKorisnikaGUI ex = IzbrisiKorisnikaGUI.dajInstancu(selektovani.getKorisnik_id());
        ex.setSize(600, 150);
        ex.setLocationRelativeTo(null);
        ex.setVisible(true);
	}
	
	public Boolean brisanjeKorisnika(long id) throws Exception {
		try {
			KorisnikDAO kDAO = new KorisnikDAO();
			Korisnik kl = kDAO.getById(id);
			Korisnik k = new Korisnik();
			Date datum = (Date) kl.getDatum_zaposlenja();
			k.setKorisnik_id(id);
			k.setIme(kl.getIme());
			k.setPrezime(kl.getPrezime());
			k.setAdresa(kl.getAdresa());
			k.setBr_lk(kl.getBr_lk());
			k.setEmail(kl.getEmail());
			k.setTelefon(kl.getTelefon());
			k.setDatum_zaposlenja(datum);
			k.setTip_korisnika(kl.getTip_korisnika());
			k.setJmbg(kl.getJmbg());
			k.setKorisnicko_ime(kl.getKorisnicko_ime());
			k.setLozinka(kl.getLozinka()); 
		    k.setVidljivo(kl.getVidljivo());
			KorisnikDAO kDAO2 = new KorisnikDAO();
			kDAO2.delete(k);
			return true;
		}
		catch(Exception e){
			throw e;
		}
	}

	public void prikaziVise(int i) {
		KorisnikDAO kDAO = new KorisnikDAO();
		Korisnik k = kDAO.getById(korisnici.get(i).getKorisnik_id());
		PrikaziDetaljnoKorisnikaGUI win = new PrikaziDetaljnoKorisnikaGUI(k);
	}
	
	public void odjaviKorisnika() {
		java.awt.Window win[] = java.awt.Window.getWindows(); 
		for(int i=0;i<win.length;i++){ 
			win[i].dispose(); 
		} 
		SessionControler.unistiInstancu();
		LoginGUI l = new LoginGUI();
	}

}
