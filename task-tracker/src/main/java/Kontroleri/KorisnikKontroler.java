package Kontroleri;

import javax.swing.JPasswordField;

import DAO.KorisnikDAO;
import Entity.Korisnik;
import ba.unsa.etf.si.tim10.task_tracker.LoginGUI;

public class KorisnikKontroler {
	
	@SuppressWarnings("deprecation")
	public Boolean promjenaSifre(JPasswordField staraSifraTxt, JPasswordField novaSifraTxt, long id) throws Exception {
		try {
			KorisnikDAO kDAO = new KorisnikDAO();
			KorisnikDAO kDAO2 = new KorisnikDAO();
			Korisnik k = kDAO.getById(id);
			if(staraSifraTxt.getText().hashCode()==k.getLozinka()) {
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
			if(pass.hashCode()==k.getLozinka()) {
				if(k.getTip_korisnika().getNaziv().equals("Racunovodstvo")) {
					SessionControler sKontroler = SessionControler.dajInstancu(k.getKorisnik_id());
					return "Racunovodstvo";
					
				}
				else if(k.getTip_korisnika().getNaziv().equals("Serviser")) {
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
}
