package ba.unsa.etf.si.tim10.task_tracker;

import java.util.Iterator;
import java.util.Set;

import DAO.KlijentDAO;
import DAO.KorisnikDAO;
import DAO.RadniZadatakDAO;
import DAO.TipKorisnikaDAO;
import Entity.Klijent;
import Entity.Korisnik;
import Entity.RadniZadatak;
import Entity.TipKorisnika;
 
public class App 
{
    public static void main( String[] args )
    {
//    	Klijent kl = new Klijent();
//    	kl.setNaziv("BBS");
//    	kl.setBroj_telefona("033/123-456");
//    	kl.setAdresa("Lozionicka 22");
//    	kl.setEmail("bbs@bbs.ba");
//    	
//    	KlijentDAO klDAO=new KlijentDAO();
//    	long idKlijent = klDAO.create(kl);
//    	kl.setKlijent_id(idKlijent);
//    	
//    	RadniZadatak r = new RadniZadatak();
//    	r.setBrojServisera(3);
//    	r.setDatumUnosa(null);
//    	r.setKlijent(kl);
//    	r.setKrajnjiDatumIzvrsenja(null);
//        	
//    	KorisnikDAO k2DAO = new KorisnikDAO();
//    	Korisnik test = k2DAO.getById(1);
//    	
//    	r.setKreator(test);
//    	r.setOpis("OPIS");
//    	r.setPotpunoDodjeljen(false);
//    	r.setDatumUnosa(null);
//    	r.setStatusDodjeljenosti(0);
//    	r.setStatusIzvrsenosti(false);
//    	r.setVidljivo(true);
//    	
//    	RadniZadatakDAO rDAO = new RadniZadatakDAO();
//    	long idZadatak=rDAO.create(r);
//    	r.setRadniZadatak_id(idZadatak);
//    	
//    	KlijentDAO kkDAO = new KlijentDAO();
//    	Klijent kk= kkDAO.getById(2);
//    	Set<RadniZadatak> lista = kk.getZadaci();
//    	
//    	for (Iterator<RadniZadatak> it = lista.iterator(); it.hasNext(); ) {
//            RadniZadatak f = it.next();
//            System.out.println(f.getOpis());
//        }
    	
    	TipKorisnika t=new TipKorisnika();
    	t.setNaziv("Serviser");    	
    	t.setVidljivo(true);
    	
    	TipKorisnikaDAO tDAO=new TipKorisnikaDAO();
    	long id = tDAO.create(t);
    	t.setTipKorisnika_id(id);
    	
    	Korisnik k=new Korisnik();
    	k.setIme("Pero");
    	k.setPrezime("Peric");
    	k.setAdresa("Cemalusa 23");
    	
    	k.setBr_lk("10BND2275");
    	k.setJmbg("0710992175025");
    	k.setTelefon("061-123-456");
    	k.setEmail("pero@domena.com");
    	k.setKorisnicko_ime("peroP");
    	k.setLozinka("123");
    	k.setDatum_zaposlenja(null);
    	k.setVidljivo(true);
    	k.setTip_korisnika(t);
    	
    	KorisnikDAO kDAO = new KorisnikDAO();
    	long id2=kDAO.create(k);
    	k.setKorisnik_id(id2);
    	
    	KorisnikDAO k2DAO = new KorisnikDAO();
    	Korisnik test = k2DAO.getById(1);
    	System.out.println(test.getTip_korisnika().getNaziv());
    	
    	TipKorisnikaDAO tkDAO = new TipKorisnikaDAO();
    	TipKorisnika tk= tkDAO.getById(1);
    	Set<Korisnik> lista = tk.getKorisnici();
    	
    	for (Iterator<Korisnik> it = lista.iterator(); it.hasNext(); ) {
            Korisnik f = it.next();
            System.out.println(f.getIme());
        }
    	
    	
    }
    
    
}

