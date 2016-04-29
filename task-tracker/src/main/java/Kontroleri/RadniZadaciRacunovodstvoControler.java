package Kontroleri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import DAO.KlijentDAO;
import DAO.ObavljeniPosaoDAO;
import DAO.RadniZadatakDAO;
import DAO.RasporedjeniZadatakDAO;
import Entity.Klijent;
import Entity.ObavljeniPosao;
import Entity.RadniZadatak;
import Entity.RasporedjeniZadatak;

public class RadniZadaciRacunovodstvoControler {
	private List<Klijent> klijenti = new ArrayList<Klijent>();
	private List<String> nazivServisera = new ArrayList<String>();
	private Klijent klijent = new Klijent();
	private List<RadniZadatak> radniZadaci = new ArrayList<RadniZadatak>();
	private List<RadniZadatak> lista = new ArrayList<RadniZadatak>();
	private List<RasporedjeniZadatak> rasZadaci = new ArrayList<RasporedjeniZadatak>();

	public RadniZadaciRacunovodstvoControler(){}
	

	public List<RadniZadatak> getLista() {
		return lista;
	}
	

	public List<RadniZadatak> getRadniZadaci() {
		return radniZadaci;
	}
	
	public List<String> getNazivServisera(RadniZadatak zadatak) {
		
		List<RasporedjeniZadatak> zadaci = new ArrayList<RasporedjeniZadatak>();
		RasporedjeniZadatakDAO rDAO = new RasporedjeniZadatakDAO();
		zadaci = rDAO.getByRadniZadatak(zadatak);
		nazivServisera = new ArrayList<String>();
		String nazivServiser = "Nije dodijeljen/Preuzet";
		
		if(zadaci.size()>0)
		for(RasporedjeniZadatak z: zadaci)
		{
			nazivServisera.add(z.getIzvrsilac().getIme()+" "+z.getIzvrsilac().getPrezime());
		}
		else nazivServisera.add(nazivServiser);
		
		return nazivServisera;
	}
	
	public Klijent getKlijent(int index) {
		this.klijent = klijenti.get(index-1);
		return klijent;
	}

	public void setKlijenti() throws Exception {
		try
		{
		
		KlijentDAO kDAO = new KlijentDAO();
		klijenti = kDAO.getAll();
		for(int i=0; i<klijenti.size(); i++) {
	 		if(klijenti.get(i).getVidljivo()) {
	 			}
	 		else {
	 			klijenti.remove(i);
	 			i=i-1;;
	 		}
		}
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public List<Klijent> getKlijenti() {
		return klijenti;
	}
	
	
	public Boolean PronadjiRadneZadatke(String ime, String prezime, Boolean klijentOdabran, int indexKlijent, Date datumKreiranja, Date datumPreuzimanja, 
			Date datumIzvrsenja, Date krajnjiDatumIzvrsenja, Boolean neizvrsen, Boolean nedodjeljen, Boolean neprihvacen) throws Exception
	{
		
		try
		{
		RasporedjeniZadatakDAO rDAO = new RasporedjeniZadatakDAO();
		rasZadaci = rDAO.getAll();
		PretraziSve();
		setKlijenti();
		
		if(ime.equals("")==false)
		{
			for(int i=rasZadaci.size()-1; i>=0; i--)
			{
				RasporedjeniZadatak r = rasZadaci.get(i);
				if(r.getIzvrsilac().getIme().equals(ime)==false || r.getVidljivo()==false)
					rasZadaci.remove(i);
			}
				PronadjiRadneZadatke();
				lista=radniZadaci;
		}
		if(prezime.equals("")==false)
		{
			for(int i=rasZadaci.size()-1; i>=0; i--)
			{
				RasporedjeniZadatak r = rasZadaci.get(i);
				if(r.getIzvrsilac().getPrezime().equals(prezime)==false || r.getVidljivo()==false)
					rasZadaci.remove(i);
			}
			if(rasZadaci.size()>0) 
			{
				PronadjiRadneZadatke();
				lista=radniZadaci;
			}
		}
		if(klijentOdabran==true)
		{
			klijent = getKlijent(indexKlijent);
			for(int i=radniZadaci.size()-1; i>=0; i--)
			{
				RadniZadatak r = radniZadaci.get(i);
				if(r.getKlijent().getKlijent_id()!=klijent.getKlijent_id() || r.getVidljivo()==false)
					radniZadaci.remove(i);
			}
			lista = radniZadaci;
		}
		if(datumKreiranja!=null)
		{
			for(int i=radniZadaci.size()-1; i>=0; i--)
			{
				RadniZadatak r = radniZadaci.get(i);
				if(ProvjeriDatum(r.getDatumUnosa(), datumKreiranja)==false || r.getVidljivo()==false)
					radniZadaci.remove(i);
			}
			lista = radniZadaci;
		}
		if(krajnjiDatumIzvrsenja!=null)
		{
			for(int i=radniZadaci.size()-1; i>=0; i--)
			{
				RadniZadatak r = radniZadaci.get(i);
				if(ProvjeriDatum(r.getKrajnjiDatumIzvrsenja(), krajnjiDatumIzvrsenja)==false || r.getVidljivo()==false)
					radniZadaci.remove(i);
			}
			lista = radniZadaci;
		}
		if(datumPreuzimanja!=null)
		{
			for(int i=rasZadaci.size()-1; i>=0; i--)
			{
				RasporedjeniZadatak r = rasZadaci.get(i);
				if(ProvjeriDatum(r.getDatumPrihvatanja(), datumPreuzimanja)==false)
					rasZadaci.remove(i);
			}
			if(rasZadaci.size()>0) 
			{
				PronadjiRadneZadatke();
				lista=radniZadaci;
			}
		}
		if(nedodjeljen==true)
		{
			for(int i=radniZadaci.size()-1; i>=0; i--)
			{
				RadniZadatak r = radniZadaci.get(i);
				if(r.getPotpunoDodjeljen().equals(true) || r.getVidljivo()==false)
					radniZadaci.remove(i);
			}
			lista = radniZadaci;
		}
		if(neizvrsen==true)
		{
			for(int i=radniZadaci.size()-1; i>=0; i--)
			{
				RadniZadatak r = radniZadaci.get(i);
				if(r.getStatusIzvrsenosti().equals(true)|| r.getVidljivo()==false)
					radniZadaci.remove(i);
			}
			lista = radniZadaci;
		}
		if(neprihvacen==true)
		{
			for(int i=rasZadaci.size()-1; i>=0; i--)
			{
				RasporedjeniZadatak r = rasZadaci.get(i);
				if(r.getStatusPrihvacenosti()==true)
					{
						rasZadaci.remove(i);
					}
			}
			if(rasZadaci.size()>0) 
			{
				PronadjiRadneZadatke();
				lista=radniZadaci;
			}
		}
		
		if(datumIzvrsenja!=null)
		{
			List<ObavljeniPosao> posao = new ArrayList<ObavljeniPosao>();
			ObavljeniPosaoDAO oDAO = new ObavljeniPosaoDAO();
			List<RasporedjeniZadatak> zadaci = new ArrayList<RasporedjeniZadatak>();
			
			if(rasZadaci.size()>0)
			{
			for(int i=0; i<rasZadaci.size(); i++)
			{
				posao.addAll(oDAO.getByRasporedjeniZadatak(rasZadaci.get(i)));
			}
			
			for(int i=0; i<posao.size(); i++)
			{
				if(ProvjeriDatum(posao.get(i).getDatumObavljanja(),datumIzvrsenja)==true)
				{
					zadaci.add(posao.get(i).getPripadajuciZadatak());
				}
			}
			
			for(int i=0; i<rasZadaci.size(); i++)
			{
				int brojac=0;
				for(int j=0; j<zadaci.size(); j++)
					if(rasZadaci.get(i).getZadatak().getRadniZadatak_id()==zadaci.get(j).getZadatak().getRadniZadatak_id())
						brojac++;
				if(brojac==0) 
					{
						rasZadaci.remove(i);
					}
			}
			}
			else 
				{
					posao.addAll(oDAO.getAll());
					for(int i=0; i<posao.size(); i++)
					{
						if(ProvjeriDatum(posao.get(i).getDatumObavljanja(),datumIzvrsenja)==true)
						{
							zadaci.add(posao.get(i).getPripadajuciZadatak());
						}
					}
					rasZadaci.addAll(zadaci);
					
				}
			if(rasZadaci.size()>0) 
			{
				PronadjiRadneZadatke();
				lista=radniZadaci;
			}
		}
		}
		 catch (Exception e) {
				throw e;
		 }
		if(lista.size()>0) return true;
		else return false;
	
	}
	
	public RadniZadatak GetZadatak(List<RadniZadatak> zadaci, int index)
	{
		RadniZadatak zadatak = new RadniZadatak();
		zadatak=zadaci.get(index);
		return zadatak;
	}
	
	public void PretraziSve() throws Exception
	{
		List<RadniZadatak> zadaci = new ArrayList<RadniZadatak>();
		RadniZadatakDAO rDAO = new RadniZadatakDAO();
		if(radniZadaci.size()>0)radniZadaci.clear();
		try
		{
			zadaci= rDAO.getAll();
		for(int i=0; i<zadaci.size(); i++) 
			if(zadaci.get(i).getVidljivo()==false)
				zadaci.remove(i);
		radniZadaci.addAll(zadaci);
		}
		 catch (Exception e) {
			throw e;
		 }
	}
	@SuppressWarnings("rawtypes")
	public List<List> getRedovi(List<RadniZadatak> radniZadaci) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<List> redovi = new ArrayList();
		try
		{
		for(RadniZadatak zadatak: radniZadaci)
		{
			List<RasporedjeniZadatak> zadaci = new ArrayList<RasporedjeniZadatak>();
			RasporedjeniZadatakDAO rDAO = new RasporedjeniZadatakDAO();
			if(zadatak.getVidljivo()!=false)
			{
			zadaci = rDAO.getByRadniZadatak(zadatak);
			nazivServisera = new ArrayList<String>();
			String nazivServiser = "Nije dodijeljen/Preuzet";
			
			if(zadaci.size()>0)
			for(RasporedjeniZadatak z: zadaci)
			{
				nazivServisera.add(z.getIzvrsilac().getIme()+" "+z.getIzvrsilac().getPrezime());
			}
			else nazivServisera.add(nazivServiser);
				
				redovi.add(Arrays.asList (
						zadatak.getVrstaZadatka(),
						zadatak.getOpis(),
						zadatak.getKlijent().getNaziv(),
						nazivServisera));	
			}
		}
		}
		catch (Exception e) {
			throw e;
		}
		
		return redovi;
	}
	
	public Boolean ProvjeriDatum(Date datumBaza, Date datumForma)
	{
		if(datumBaza!=null)
		{
		Date datum = new Date();
		Calendar cal = Calendar.getInstance();
		Calendar cal1 = Calendar.getInstance();

				datum = datumBaza;
				Date d = datumForma;
				cal.setTime(datum);
				cal1.setTime(d);
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH);
				int day = cal.get(Calendar.DAY_OF_MONTH);
				int year1 = cal1.get(Calendar.YEAR);
				int month1 = cal1.get(Calendar.MONTH);
				int day1 = cal1.get(Calendar.DAY_OF_MONTH);

				if (year == year1 && month == month1 && day == day1) return true;
				else return false;
		}
		else return false;
}
	public void PronadjiRadneZadatke()
	{
		for(int i=radniZadaci.size()-1; i>=0; i--)
		{
			int brojac = 0;
			RadniZadatak rz = radniZadaci.get(i);
			for(int j=0; j<rasZadaci.size(); j++)
			{
				RasporedjeniZadatak r = rasZadaci.get(j);
				if(r.getZadatak().getRadniZadatak_id()==rz.getRadniZadatak_id() || r.getZadatak().getVidljivo()==false)
					brojac+=1;
			}
			if(brojac==0) radniZadaci.remove(rz);
		}
	}
}
