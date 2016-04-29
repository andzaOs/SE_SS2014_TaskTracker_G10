package ba.unsa.etf.si.tim10.task_tracker;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import DAO.KlijentDAO;
import DAO.KorisnikDAO;
import DAO.RadniZadatakDAO;
import DAO.TipKorisnikaDAO;
import DAO.VrstaUslugeDAO;
import Entity.Klijent;
import Entity.Korisnik;
import Entity.RadniZadatak;
import Entity.TipKorisnika;
import Entity.VrstaUsluge;
import Izvjestaj.Izvjestaj;
import Izvjestaj.stavkaIzvjestajaKlijent;
import Izvjestaj.stavkaIzvjestajaRadnik;
import Izvjestaj.stavkaIzvjestajaSat;
import Izvjestaj.stavkaIzvjestajaUsluga;
 
public class App 
{
    public static void main( String[] args )
    {
    	
    	/*Date pocetak = Date.valueOf("2014-05-10");
    	Date kraj = Date.valueOf("2014-05-25");
    	
    	Korisnik k = new Korisnik();
    	KorisnikDAO kDAO = new KorisnikDAO();
    	k = kDAO.getById(1);		
    	
    	Izvjestaj iz = new Izvjestaj();
    	List<stavkaIzvjestajaRadnik> red = iz.vratiIzvjestajPremaRadniku(k, pocetak, kraj);
    	
        for(int i=0; i<red.size(); i++)
        {
        	System.out.println(red.get(i).getKlijent() + " " + red.get(i).getVrstaUsluge() + 
        			" " + red.get(i).getDatum() + " " + red.get(i).getBrojSati() );
        }*/
    	

    	
    	/*VrstaUsluge v = new VrstaUsluge();
    	VrstaUslugeDAO vDAO = new VrstaUslugeDAO();
    	v = vDAO.getById(1);
    	
    	Izvjestaj iz = new Izvjestaj();
    	List<stavkaIzvjestajaUsluga> red = iz.vratiIzvjestajPremaUslugi(v, pocetak, kraj);
    	
        for(int i=0; i<red.size(); i++)
        {
        	System.out.println(red.get(i).getRadnik() + " " + red.get(i).getKlijent() + 
        			" " + red.get(i).getDatum() + " " + red.get(i).getBrojSati() );
        }*/
    	
    	/*Klijent k = new Klijent();
    	KlijentDAO kDAO = new KlijentDAO();
    	k = kDAO.getById(1);
    	
    	Izvjestaj iz = new Izvjestaj();
    	List<stavkaIzvjestajaKlijent> red = iz.vratiIzvjestajPremaKlijentu(k, pocetak, kraj);
    	
        for(int i=0; i<red.size(); i++)
        {
        	System.out.println(red.get(i).getRadnik() + " " + red.get(i).getUsluga() + 
        			" " + red.get(i).getDatum() + " " + red.get(i).getBrojSati() );
        }*/
    	
    	/*Izvjestaj iz = new Izvjestaj();
    	List<stavkaIzvjestajaSat> red = iz.vratiIzvjestajPremaSatima(pocetak, kraj);
    	
        for(int i=0; i<red.size(); i++)
        {
        	System.out.println(red.get(i).getRadnik() + " " + red.get(i).getBrojSati() );
        }*/
    	
    	/*Izvjestaj iz = new Izvjestaj();
    	List< List<stavkaIzvjestajaRadnik> > red = iz.vratiDetaljniIzvjestaj(pocetak, kraj);
    	
        for(int i=0; i<red.size(); i++)
        {
        	for(int j=0; j<red.get(i).size(); j++) {
            	System.out.println(red.get(i).get(j).getKlijent() + " " + red.get(i).get(j).getVrstaUsluge() + 
            			" " + red.get(i).get(j).getDatum() + " " + red.get(i).get(j).getBrojSati() );
        	}
        }*/
    	
    	/*Korisnik k = new Korisnik();
    	KorisnikDAO kDAO = new KorisnikDAO();
    	k = kDAO.getByUsername("peroP");
    	System.out.println(k.getKorisnicko_ime());*/
    	
    	//String s = "username";
    	//System.out.println(s.hashCode());
     	
    }
}

