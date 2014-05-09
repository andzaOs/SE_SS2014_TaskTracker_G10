package ba.unsa.etf.si.tim10.task_tracker;

import java.util.Date;

import DAO.KorisnikDAO;
import Entity.Korisnik;
 
public class App 
{
    public static void main( String[] args )
    {
    	
//    	 KlijentDAO kDAO = new KlijentDAO();
//    	 List<Klijent> klijenti = new ArrayList<Klijent>();
//
//       	 klijenti = kDAO.getByNaziv("Bosnalijek");
//
//       	 for(int i=0; i<klijenti.size(); i++){
//       		 System.out.println( klijenti.get(i).getNaziv() + "\n" );
//       	 }
    	
    	Korisnik k = new Korisnik();
    	k.setIme("Anela");
    	k.setPrezime("Osmanović");
    	k.setAdresa("Bosanska br.3");
    	k.setBrojLK("123456");
    	Date now = new Date();
    	k.setDatumZaposlenja(now);
    	k.setEmail("osmanovic.anela@gmail.com");
    	k.setJmbg("2912990186517");
    	k.setKorisnickoIme("anelao");
    	k.setSifra("anelao");
    	k.setTelefon("0603376831");
    	k.setTipKorisnika(0);
    	k.setVidljivo(true);
    	
    	
    	KorisnikDAO kDAO = new KorisnikDAO();
    	long id = kDAO.create(k);
    	k.setId(id);
       	 
    }
    
    
}

