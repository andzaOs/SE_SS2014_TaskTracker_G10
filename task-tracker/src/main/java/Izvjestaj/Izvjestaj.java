package Izvjestaj;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import UtilClasses.HibernateUtil;
import DAO.TipKorisnikaDAO;
import Entity.Klijent;
import Entity.Korisnik;
import Entity.TipKorisnika;
import Entity.VrstaUsluge;

public class Izvjestaj {
	
	public List<stavkaIzvjestajaRadnik> vratiIzvjestajPremaRadniku(Korisnik radnik, Date pocetak, Date kraj){
		
		List<stavkaIzvjestajaRadnik> izvjestaj = new ArrayList<stavkaIzvjestajaRadnik> ();

        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Query query = session.createSQLQuery("SELECT k.naziv as klijent, v.naziv as usluga, o.datumobavljanja, o.brojsati "
        		+ "FROM klijent k, vrstausluge v, obavljeniposao o, radnizadatak radz, rasporedjenizadatak rasz "
        		+ "WHERE k.klijent_id = radz.klijent_id "
        		+ "AND rasz.radnizadatak_id = radz.radnizadatak_id "
        		+ "AND o.rasporedjenizadatak_id = rasz.rasporedjenizadatak_id "
        		+ "AND o.vrstausluge_id = v.vrstausluge_id "
        		+ "AND rasz.korisnik_id = " + radnik.getKorisnik_id() + " "
        		+ "AND (o.datumobavljanja BETWEEN '" + pocetak.toString() + "' AND '" + kraj.toString() + "')");
        
        List<Object[]> rows = query.list();
        
        for (Object[] row : rows) {
            stavkaIzvjestajaRadnik s = new stavkaIzvjestajaRadnik();
        	s.setKlijent(row[0].toString());
            s.setVrstaUsluge(row[1].toString());
            s.setDatum(row[2].toString());
            s.setBrojSati(row[3].toString());
            izvjestaj.add(s);
        }
        
        session.close();
		
		return izvjestaj;
	}
	
	public List<stavkaIzvjestajaUsluga> vratiIzvjestajPremaUslugi(VrstaUsluge usluga, Date pocetak, Date kraj){
		
		List<stavkaIzvjestajaUsluga> izvjestaj = new ArrayList<stavkaIzvjestajaUsluga> ();

        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Query query = session.createSQLQuery("SELECT concat(k.ime, ' ', k.prezime), kl.naziv, o.datumobavljanja, o.brojsati "
        		+ "FROM korisnik k, vrstausluge v, obavljeniposao o, radnizadatak radz, rasporedjenizadatak rasz, klijent kl "
        		+ "WHERE k.korisnik_id = radz.korisnik_id "
        		+ "AND rasz.radnizadatak_id = radz.radnizadatak_id "
        		+ "AND o.rasporedjenizadatak_id = rasz.rasporedjenizadatak_id "
        		+ "AND kl.klijent_id = radz.klijent_id "
        		+ "AND o.vrstausluge_id = " + usluga.getVrstaUsluge_id() + " "
        		+ "AND (o.datumobavljanja BETWEEN '" + pocetak.toString() + "' AND '" + kraj.toString() + "')");
        
        List<Object[]> rows = query.list();
        
        for (Object[] row : rows) {
            stavkaIzvjestajaUsluga s = new stavkaIzvjestajaUsluga();
        	s.setRadnik(row[0].toString());
            s.setKlijent(row[1].toString());
            s.setDatum(row[2].toString());
            s.setBrojSati(row[3].toString());
            izvjestaj.add(s);
        }
        
        session.close();
        
        return izvjestaj;
	}

	public List<stavkaIzvjestajaKlijent> vratiIzvjestajPremaKlijentu(Klijent klijent, Date pocetak, Date kraj){
		
		List<stavkaIzvjestajaKlijent> izvjestaj = new ArrayList<stavkaIzvjestajaKlijent> ();

        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Query query = session.createSQLQuery("SELECT distinct concat(k.ime, ' ', k.prezime), v.naziv, o.datumobavljanja, o.brojsati "
        		+ "FROM korisnik k, vrstausluge v, obavljeniposao o, radnizadatak radz, rasporedjenizadatak rasz, klijent kl "
        		+ "WHERE k.korisnik_id = rasz.korisnik_id "
        		+ "AND rasz.radnizadatak_id = radz.radnizadatak_id "
        		+ "AND o.rasporedjenizadatak_id = rasz.rasporedjenizadatak_id "
        		+ "AND kl.klijent_id = radz.klijent_id "
        		+ "AND radz.klijent_id = " + klijent.getKlijent_id() + " AND radz.statusizvrsenosti = 1 "
        		+ "AND (o.datumobavljanja BETWEEN '" + pocetak.toString() + "' AND '" + kraj.toString() + "')");
        
        List<Object[]> rows = query.list();
        
        for (Object[] row : rows) {
            stavkaIzvjestajaKlijent s = new stavkaIzvjestajaKlijent();
        	s.setRadnik(row[0].toString());
            s.setUsluga(row[1].toString());
            s.setDatum(row[2].toString());
            s.setBrojSati(row[3].toString());
            izvjestaj.add(s);
        }
        
        session.close();
        
        return izvjestaj;
	}

	public List<stavkaIzvjestajaSat> vratiIzvjestajPremaSatima(Date pocetak, Date kraj) {
		List<stavkaIzvjestajaSat> izvjestaj = new ArrayList<stavkaIzvjestajaSat> ();

        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Query query = session.createSQLQuery("SELECT distinct concat(k.ime, ' ', k.prezime) AS ime, SUM(o.brojsati) "
        		+ "FROM korisnik k, vrstausluge v, obavljeniposao o, radnizadatak radz, rasporedjenizadatak rasz "
        		+ "WHERE k.korisnik_id = radz.korisnik_id "
        		+ "AND rasz.radnizadatak_id = radz.radnizadatak_id "
        		+ "AND o.rasporedjenizadatak_id = rasz.rasporedjenizadatak_id "
        		+ "AND (o.datumobavljanja BETWEEN '" + pocetak.toString() + "' AND '" + kraj.toString() + "') "
        		+ "GROUP BY ime");
        
        List<Object[]> rows = query.list();
        
        for (Object[] row : rows) {
        	stavkaIzvjestajaSat s = new stavkaIzvjestajaSat();
        	s.setRadnik(row[0].toString());
            s.setBrojSati(row[1].toString());
            izvjestaj.add(s);
        }
        
        session.close();
        
        return izvjestaj;		
	}
	
}
