package Kontroleri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import DAO.*;
import Entity.*;

public class EvidencijaRadaRacunovodstvoControler {
	
	private List<RasporedjeniZadatak> raPoUsluzi = new ArrayList<RasporedjeniZadatak>();
	private List<RasporedjeniZadatak> raPoServiserima = new ArrayList<RasporedjeniZadatak>();
	private List<RasporedjeniZadatak> raPoZadacima = new ArrayList<RasporedjeniZadatak>();
	private List<RasporedjeniZadatak> rasporedjeniZadaci = new ArrayList<RasporedjeniZadatak>();
	private List<Klijent> klijenti;
	private List<VrstaUsluge> vrsteUsluge;
	@SuppressWarnings({ "rawtypes" })
	private List<List> redovi = new ArrayList<List>();
	private List<ObavljeniPosao> obavljeniPosao = new ArrayList<ObavljeniPosao>();
	private Klijent klijent = new Klijent();
	private VrstaUsluge vrstaUsluge = new VrstaUsluge();
	private Boolean prServiser, prZadaci, prUsluga;
	

	public EvidencijaRadaRacunovodstvoControler(){
	}
	
	public void setKlijent(int index) {
		this.klijent = klijenti.get(index);
	}

	public List<Klijent> getKlijenti() {
		return klijenti;
	}


	public void setKlijenti() {
		klijenti = new ArrayList<Klijent>();;
		KlijentDAO kDAO = new KlijentDAO();
		klijenti = kDAO.getAll();
	}

	public Klijent getKlijent() {
		return klijent;
	}

	public void setVrsteUsluge() {
		vrsteUsluge = new ArrayList<VrstaUsluge>();;
		VrstaUslugeDAO vDAO = new VrstaUslugeDAO();
		vrsteUsluge = vDAO.getAll();
	}


	public void setVrstaUsluge(int index) {
		this.vrstaUsluge = vrsteUsluge.get(index);
	}

	public VrstaUsluge getVrstaUsluge() {
		return vrstaUsluge;
	}
	
	public List<RasporedjeniZadatak> getRasporedjeniZadaci() {
		return rasporedjeniZadaci;
	}
	
	public List<RasporedjeniZadatak> getRaPoServiserima() {
		return raPoServiserima;
	}

	
	public List<RasporedjeniZadatak> getRaPoUsluzi() {
		return raPoUsluzi;
	}


	public List<RasporedjeniZadatak> getRaPoZadacima() {
		return raPoZadacima;
	}

	public List<ObavljeniPosao> getObavljeniPosao() {
		return obavljeniPosao;
	}

	public List<VrstaUsluge> getVrsteUsluge()
	{
		return vrsteUsluge;
	}

	public void UnesenaPretragaZaServisera(String ime, String prezime, String jmbg)
	{
		List<Korisnik> korisnici = new ArrayList<Korisnik>();
		List<Korisnik> serviseri = new ArrayList<Korisnik>();
		KorisnikDAO kDAO = new KorisnikDAO();
	
		if (ime != "" && prezime != "" && jmbg != "") {
			korisnici = kDAO.getByRestrictions(ime, prezime, jmbg);
		} else if (ime == "" && prezime == "" && jmbg != "") {
			korisnici = kDAO.getByJmbg(jmbg);
		} else if (ime != "" && prezime != "" && jmbg == "") {
			korisnici = kDAO.getByNaziv(ime, prezime);
		} else if (ime != "" && prezime == "" && jmbg == "") {
			korisnici = kDAO.getByIme(ime);
		} else if (ime != "" && prezime == "" && jmbg != "") {
			korisnici = kDAO.getByImeIJmbg(ime, jmbg);
		} else
			korisnici = null;

		if (korisnici != null) {;
			for (int i = 0; i < korisnici.size(); i++) {
				if (korisnici.get(i).getTip_korisnika().getNaziv()
						.equals("Serviser"))

				{
					serviseri.add(korisnici.get(i));
				}
			}
			RasporedjeniZadatakDAO rasDAO = new RasporedjeniZadatakDAO();
			
			for (Korisnik s : serviseri) {
				raPoServiserima.addAll(rasDAO.getByServiser(s));
			}
			prServiser = true;
			
			
		} else {
			prServiser=false;
		}

	}

	public void UnesenaPretrageZaRadneZadatke(Boolean klijentOdabran, Boolean izvrsen, int indexKlijent) 
	{
		List<RadniZadatak> radniZadaci = new ArrayList<RadniZadatak>();
		RadniZadatakDAO rzDAO = new RadniZadatakDAO();
		
		if(klijentOdabran==true)
		{
			setKlijenti();
			setKlijent(indexKlijent);
		}

		if (klijentOdabran == true && izvrsen==false)
		{
			radniZadaci = rzDAO.getByKlijent(klijent);
		} 
		else if (izvrsen == true && klijentOdabran == false) 
		{
			radniZadaci = rzDAO.getByStatusIzvrsenosti(izvrsen);
		} 
		else if(klijentOdabran==true && izvrsen==true)
		{
			radniZadaci = rzDAO.getByIzvrsenIKlijent(klijent, izvrsen);
		}
		else 
		{
			radniZadaci = null;
		}
		
		if (radniZadaci!= null) 
		{
			RasporedjeniZadatakDAO rasDAO = new RasporedjeniZadatakDAO();
			for (int i=0; i<radniZadaci.size(); i++) 
			{
				raPoZadacima.addAll(rasDAO.getByRadniZadatak(radniZadaci.get(i)));
			}
			prZadaci=true;
		}
		else 
			{
				prZadaci=false;			
			}
	}
	
	public void UnsesenaPretragaZaVrstuUsluge(Boolean vrstaUslugeOdabrana, int indexVrstaUsluge,
			Date pocetniDatum, Date krajnjiDatum)
	{
		ObavljeniPosaoDAO opDAO = new ObavljeniPosaoDAO();
		List<ObavljeniPosao> op = new ArrayList<ObavljeniPosao>();
		
		if(vrstaUslugeOdabrana==true)
		{
			setVrsteUsluge();
			setVrstaUsluge(indexVrstaUsluge);
		}
		
		if (vrstaUslugeOdabrana==true && pocetniDatum!=null && krajnjiDatum!=null) 
		{	
			op = opDAO.getByRestrictions(pocetniDatum, krajnjiDatum, vrstaUsluge);
		}
		else if(vrstaUslugeOdabrana==true && pocetniDatum!=null && krajnjiDatum==null)
		{
			op = opDAO.getByVrstaUsluge(vrstaUsluge);
			for(ObavljeniPosao posao: op)
				if(posao.getDatumUnosa().before(pocetniDatum)) op.remove(posao);
		}
		else if(vrstaUslugeOdabrana==true && pocetniDatum==null && krajnjiDatum!=null)
		{
			op = opDAO.getByVrstaUsluge(vrstaUsluge);
			for(ObavljeniPosao posao: op)
				if(posao.getDatumUnosa().after(krajnjiDatum)) op.remove(posao);
		}
		else if(vrstaUslugeOdabrana==false && pocetniDatum!=null && krajnjiDatum==null)
		{
			Date now = new Date();
			op=opDAO.getByPeriod(pocetniDatum, now);
		}
		else if(vrstaUslugeOdabrana==false && pocetniDatum!=null && krajnjiDatum!=null)
		{
			op = opDAO.getByPeriod(pocetniDatum, krajnjiDatum);
		}
		else if(vrstaUslugeOdabrana==true && pocetniDatum==null && krajnjiDatum==null)
		{
			op = opDAO.getByVrstaUsluge(vrstaUsluge);

		}
		else if(vrstaUslugeOdabrana==false && pocetniDatum==null && krajnjiDatum!=null)
		{
			op = opDAO.getAll();
			for(ObavljeniPosao posao: op)
				if(posao.getDatumUnosa().after(krajnjiDatum)) op.remove(posao);
		}
		else op = null;
		
		if(op != null)
		{
			
			for (int i=0; i<op.size(); i++) 
			{
				if (raPoUsluzi.size() > 0)
					for (RasporedjeniZadatak r : raPoUsluzi) 
					{
						if (op.get(i).getPripadajuciZadatak()
								.getRasporedjeniZadatak_id() != r
								.getRasporedjeniZadatak_id())
							raPoUsluzi.add(op.get(i)
									.getPripadajuciZadatak());
					}

				else 
				{
					raPoUsluzi.add(op.get(i).getPripadajuciZadatak());
				}
			}
			prUsluga = true;
		}
		else 
			{
				prUsluga=false;
			}
	}
	
	public void GrupisiRasporedjeneZadatke()
	{
		if (prServiser!=false && prZadaci!=false && prUsluga!=false) 
		{
			if(raPoServiserima.size()>0 && raPoZadacima.size()>0 && raPoUsluzi.size()>0)
			RasporedjeniZadaciPoSvimParametrimPretrage();
			else PostaviNaNullRasporedjeneZadatke();
		}
		else if (prServiser!=false && prZadaci!=false && prUsluga==false) 
		{
			if(raPoServiserima.size()>0 && raPoZadacima.size()>0)
			RasporedjeniZadaciPoServiserimaIRZadacima();
			else PostaviNaNullRasporedjeneZadatke();
		}

		else if (prServiser==false && prZadaci!=false && prUsluga!=false)
		{
			if(raPoUsluzi.size()>0 && raPoZadacima.size()>0)
			RasporedjeniZadaciPoRZadacimaIUsluzi();
			else PostaviNaNullRasporedjeneZadatke();
		}

		else if (prServiser!=false && prZadaci==false && prUsluga!=false) 
		{
			if(raPoServiserima.size()>0 && raPoUsluzi.size()>0)
			RasporedjeniZadaciPoServiserimaIUsluzi();
			else PostaviNaNullRasporedjeneZadatke();
		}

		else if (prServiser!=false && prZadaci==false && prUsluga==false)
		{
			if(raPoServiserima.size()>0)
			RasporedjeniZadaciPoServiserima();
			else PostaviNaNullRasporedjeneZadatke();
		}

		else if (prServiser==false && prZadaci!=false && prUsluga==false) 
		{
			if(raPoZadacima.size()>0)
				RasporedjeniZadaciPoRZadatku();
			else PostaviNaNullRasporedjeneZadatke();
		}

		else if (prServiser==false && prZadaci==false && prUsluga!=false) 
		{
			if(raPoUsluzi.size()>0)
				RasporedjeniZadaciPoUsluzi();
			else PostaviNaNullRasporedjeneZadatke();
		}
		else
			PostaviNaNullRasporedjeneZadatke();
	}
	
	public void RasporedjeniZadaciPoSvimParametrimPretrage()
	{
		rasporedjeniZadaci.addAll(raPoServiserima);
		for(RasporedjeniZadatak rZ : raPoZadacima)
			for(int i=0; i<rasporedjeniZadaci.size(); i++)
				if(rZ.getRasporedjeniZadatak_id()!=rasporedjeniZadaci.get(i).getRasporedjeniZadatak_id())
					rasporedjeniZadaci.add(rZ);
		for(RasporedjeniZadatak rZ : raPoUsluzi)
			for(int i=0; i<rasporedjeniZadaci.size(); i++)
				if(rZ.getRasporedjeniZadatak_id()!=rasporedjeniZadaci.get(i).getRasporedjeniZadatak_id())
					rasporedjeniZadaci.add(rZ);
	}
	
	public void RasporedjeniZadaciPoServiserimaIRZadacima()
	{
		rasporedjeniZadaci.addAll(raPoServiserima);
		for(RasporedjeniZadatak rZ : raPoZadacima)
			for(int i=0; i<rasporedjeniZadaci.size(); i++)
				if(rZ.getRasporedjeniZadatak_id()!=rasporedjeniZadaci.get(i).getRasporedjeniZadatak_id())
					rasporedjeniZadaci.add(rZ);
	}
	
	public void RasporedjeniZadaciPoRZadacimaIUsluzi()
	{
		rasporedjeniZadaci.addAll(raPoUsluzi);
		for(RasporedjeniZadatak rZ : raPoZadacima)
			for(int i=0; i<rasporedjeniZadaci.size(); i++)
				if(rZ.getRasporedjeniZadatak_id()!=rasporedjeniZadaci.get(i).getRasporedjeniZadatak_id())
					rasporedjeniZadaci.add(rZ);
	}
	
	public void RasporedjeniZadaciPoServiserimaIUsluzi()
	{
		rasporedjeniZadaci.addAll(raPoServiserima);
		for(RasporedjeniZadatak rZ : raPoUsluzi)
			for(int i=0; i<rasporedjeniZadaci.size(); i++)
				if(rZ.getRasporedjeniZadatak_id()!=rasporedjeniZadaci.get(i).getRasporedjeniZadatak_id())
					rasporedjeniZadaci.add(rZ);
	}
	
	public void RasporedjeniZadaciPoServiserima()
	{
		rasporedjeniZadaci.addAll(raPoServiserima);
	}
	
	public void RasporedjeniZadaciPoUsluzi()
	{
		rasporedjeniZadaci.addAll(raPoUsluzi);
	}
	
	public void RasporedjeniZadaciPoRZadatku()
	{
		rasporedjeniZadaci.addAll(raPoZadacima);
	}
	
	public void PostaviNaNullRasporedjeneZadatke()
	
	{
		rasporedjeniZadaci=null;
	}
	
	
	@SuppressWarnings({ "unchecked" })
	public Boolean PronadjiObavljenePoslove(Boolean neizvrsen, String ime, String prezime,
			String jmbg, Boolean klijentOdabran, int indexKlijent, Boolean izvrsen, Boolean vrstaUslugeOdabrana,
			int indexVrstaUsluge, Date pocetniDatum, Date krajnjiDatum)
	{
		UnesenaPretragaZaServisera(ime, prezime, jmbg);
		UnesenaPretrageZaRadneZadatke(klijentOdabran, izvrsen, indexKlijent);
		UnsesenaPretragaZaVrstuUsluge(vrstaUslugeOdabrana, indexVrstaUsluge, pocetniDatum, krajnjiDatum);
		GrupisiRasporedjeneZadatke();
		ObavljeniPosaoDAO obavljeniPosaoDAO = new ObavljeniPosaoDAO();
		if(prServiser==false && prUsluga==false && prZadaci==false && neizvrsen==true)
		{
			RasporedjeniZadatakDAO rzDAO = new RasporedjeniZadatakDAO();
			rasporedjeniZadaci = rzDAO.getAll();
		}
		if(rasporedjeniZadaci!=null)
		{
			List<RasporedjeniZadatak> duplikati = new ArrayList<RasporedjeniZadatak>();
			duplikati.addAll(rasporedjeniZadaci);
			rasporedjeniZadaci.clear();
			int brojac=0;
			for(int i=0; i<duplikati.size(); i++)
			{
				for(int j=0; j<duplikati.size(); j++)
				{
					if(duplikati.get(i).getRasporedjeniZadatak_id()==duplikati.get(j).getRasporedjeniZadatak_id())
						brojac++;
				}
				if(brojac>1) duplikati.remove(duplikati.get(i));
			}
			rasporedjeniZadaci.addAll(duplikati);	
		
		for (int i=0; i<rasporedjeniZadaci.size(); i++) 
		{
			if(neizvrsen==true)
				{
					if(rasporedjeniZadaci.get(i).getZadatak().getStatusIzvrsenosti()==false)
					obavljeniPosao.addAll(obavljeniPosaoDAO.getByRasporedjeniZadatak(rasporedjeniZadaci.get(i)));
					
				}			
		}
		
		if (obavljeniPosao.size() == 0) 
		{
			return false;
		} 
		else 
		{
		
				List<ObavljeniPosao> duplikati1 = new ArrayList<ObavljeniPosao>();
				duplikati1.addAll(obavljeniPosao);
				obavljeniPosao.clear();
				int brojac1=0;
				for(int i=0; i<duplikati1.size(); i++)
				{
					for(int j=0; j<duplikati1.size(); j++)
					{
						if(duplikati1.get(i).getObavljeniPosao_id()==duplikati1.get(j).getObavljeniPosao_id())
							brojac1++;
					}
					if(brojac1>1) duplikati1.remove(duplikati1.get(i));
				}
				obavljeniPosao.addAll(duplikati1);
			
			for (ObavljeniPosao o : obavljeniPosao) {
				redovi.add(Arrays.asList (
							o.getPripadajuciZadatak().getZadatak()
									.getVrstaZadatka(),
							o.getPripadajuciZadatak().getZadatak()
									.getOpis(),
							o.getPripadajuciZadatak().getZadatak()
									.getKlijent().getNaziv(),
							o.getPripadajuciZadatak()
									.getIzvrsilac().getIme()
									+ " "
									+ o.getPripadajuciZadatak()
											.getIzvrsilac()
											.getPrezime(),
							o.getVrstaUsluge().getNaziv(),
							o.getBrojSati() ));
				
			}
			return true;
		}
		}
		else return false;
	}
	@SuppressWarnings("rawtypes")
	public List<List> getRedovi() {
		return redovi;
	}
	

}
