package Kontroleri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import DAO.*;
import Entity.*;

public class RadniZadaciRacunovodstvoControler {
	private List<Klijent> klijenti;
	private List<String> nazivServisera = new ArrayList<String>();
	private Klijent klijent = new Klijent();
	private Set<RasporedjeniZadatak> raPoServiserima = new HashSet<RasporedjeniZadatak>();
	private Set<RasporedjeniZadatak> raPoObavljenomPoslu = new HashSet<RasporedjeniZadatak>();
	private Set<RadniZadatak> radniZadaci = new HashSet<RadniZadatak>();

	private Set<RadniZadatak> raPoZadacima = new HashSet<RadniZadatak>();
	private Boolean prServiser, prZadaci, prObavljeniPosao;
	@SuppressWarnings({ "rawtypes" })
	private List<List> 	redovi = new ArrayList<List>();

	public RadniZadaciRacunovodstvoControler(){
		radniZadaci.isEmpty();
		nazivServisera.clear();
		raPoObavljenomPoslu.clear();
		raPoServiserima.clear();
		raPoZadacima.clear();
	}

	public Set<RadniZadatak> getRadniZadaci() {
		return radniZadaci;
	}
	
	public List<String> getNazivServisera() {
		return nazivServisera;
	}
	
	public void setKlijent(int index) {
		this.klijent = klijenti.get(index);
	}
	
	public Klijent getKlijent() {
		return klijent;
	}

	public void setKlijenti() {
		klijenti = new ArrayList<Klijent>();;
		KlijentDAO kDAO = new KlijentDAO();
		klijenti = kDAO.getAll();
	}
	
	public List<Klijent> getKlijenti() {
		return klijenti;
	}
	
	@SuppressWarnings("rawtypes")
	public List<List> getRedovi() {
		return redovi;
	}

	@SuppressWarnings("rawtypes")
	public Boolean PronadjiRadneZadatke(String ime, String prezime, Boolean klijentOdabran, int indexKlijent, Date datumKreiranja, Date datumPreuzimanja, 
			Date datumIzvrsenja, Date krajnjiDatumIzvrsenja, Boolean neizvrsen, Boolean nedodjeljen, Boolean neprihvacen)
	{
		
		UnesenaPretragaZaServisera(ime, prezime);
		UnesenaPretrageZaRadneZadatke(klijentOdabran, indexKlijent, datumKreiranja, krajnjiDatumIzvrsenja,
				nedodjeljen, neizvrsen);
		UnesenaPretragaZaObavljenePoslove(datumIzvrsenja);
		UnesenaPretragaZaRasporedjeneZadatke(datumPreuzimanja, neprihvacen);

	
		List<RadniZadatak> zzadaci = new ArrayList<RadniZadatak>();
		zzadaci.addAll(radniZadaci);
		radniZadaci.clear();
		if(zzadaci.size()>0)
		radniZadaci.add(zzadaci.get(0));
		for(int i=1; i<zzadaci.size(); i++)
		{
			for(int j=0; j<i; j++)
				if(zzadaci.get(i).getRadniZadatak_id()==zzadaci.get(j).getRadniZadatak_id())
					{
						zzadaci.remove(i);
					}
		}
		
		radniZadaci.addAll(zzadaci);
		if(radniZadaci.size()>0)
		{
			RasporedjeniZadatakDAO rDAO = new RasporedjeniZadatakDAO();
			List<RasporedjeniZadatak> zadaci = new ArrayList<RasporedjeniZadatak>();
		
			System.out.println(radniZadaci.size());
			
			for(RadniZadatak zadatak: radniZadaci)
			{
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
			return true;
		}
		else return false;
	
	}
	public void UnesenaPretragaZaServisera(String ime, String prezime)
	{
		List<Korisnik> korisnici = new ArrayList<Korisnik>();
		List<Korisnik> serviseri = new ArrayList<Korisnik>();
		KorisnikDAO kDAO = new KorisnikDAO();
		
		if(ime!="" && prezime!="")
		{
			korisnici = kDAO.getByNaziv(ime, prezime);
		}
		else if(ime!="" && prezime=="")
		{
			korisnici=kDAO.getByIme(ime);
		}
		else korisnici=null;
		if(korisnici!=null)
		{
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
			Set<RadniZadatak> zadaci = new HashSet<RadniZadatak>();
			for (Iterator<RasporedjeniZadatak> it = raPoServiserima.iterator(); it.hasNext(); ) {
						RasporedjeniZadatak f = it.next();
				        zadaci.add(f.getZadatak());
			}
			radniZadaci.addAll(zadaci);
			prServiser = true;
		}	
		else prServiser=false;
	}
	

	public void UnesenaPretrageZaRadneZadatke(Boolean klijentOdabran, int indexKlijent, Date datumKreiranja, Date krajnjiDatumIzvrsenja,
			Boolean nedodjeljen, Boolean neizvrsen)
			{
				RadniZadatakDAO rzDAO = new RadniZadatakDAO();
		
				if(klijentOdabran==true)
				{
					setKlijenti();
					setKlijent(indexKlijent);
				}
				
				if(klijentOdabran==true && datumKreiranja!=null && krajnjiDatumIzvrsenja!=null)
				{
					raPoZadacima.addAll(rzDAO.getByRestrictions1(datumKreiranja, krajnjiDatumIzvrsenja, klijent));
				}
				else if(klijentOdabran!=true && datumKreiranja!=null && krajnjiDatumIzvrsenja!=null)
				{
					raPoZadacima.addAll(rzDAO.getByRestrictions4(krajnjiDatumIzvrsenja, datumKreiranja));
				}
				else if(klijentOdabran==true && datumKreiranja!=null && krajnjiDatumIzvrsenja==null)
				{
					raPoZadacima.addAll(rzDAO.getByRestrictions2(datumKreiranja, klijent));
				}
				else if(klijentOdabran==true && datumKreiranja==null && krajnjiDatumIzvrsenja!=null)
				{
					raPoZadacima.addAll(rzDAO.getByRestrictions3(krajnjiDatumIzvrsenja, klijent));
				}
				else if(klijentOdabran!=true && datumKreiranja!=null && krajnjiDatumIzvrsenja==null)
				{
					raPoZadacima.addAll(rzDAO.getByDatumUnosa(datumKreiranja));
				}
				else if(klijentOdabran==false && datumKreiranja==null && krajnjiDatumIzvrsenja!=null)
				{
					raPoZadacima.addAll(rzDAO.getByKrajnjiDatumIzvrsenja(krajnjiDatumIzvrsenja));
				}
				else if(klijentOdabran==true && datumKreiranja==null && krajnjiDatumIzvrsenja==null)
				{
					raPoZadacima.addAll(rzDAO.getByKlijent(klijent));
				}
				else if(klijentOdabran==false && datumKreiranja==null && krajnjiDatumIzvrsenja==null 
						&& neizvrsen==true && nedodjeljen==false)
				{
					raPoZadacima.addAll(rzDAO.getAll());
				}
				else if(klijentOdabran==false && datumKreiranja==null && krajnjiDatumIzvrsenja==null 
						&& neizvrsen==false && nedodjeljen==true)
				{
					raPoZadacima.addAll(rzDAO.getAll());
				}
				else raPoZadacima=null;
				
				if(raPoZadacima!=null && (prServiser==false || prServiser==true && radniZadaci.size()>0 ))
				{

					if(neizvrsen==true && raPoZadacima.size()>0)
						while(raPoZadacima.iterator().hasNext())
						{
							RadniZadatak element=raPoZadacima.iterator().next();
							if(raPoZadacima.iterator().next().getStatusIzvrsenosti()==true)
								raPoZadacima.remove(element);
						}
					if(nedodjeljen==true && raPoZadacima.size()>0)
						while(raPoZadacima.iterator().hasNext())
						{
							RadniZadatak element=raPoZadacima.iterator().next();
							if(raPoZadacima.iterator().next().getPotpunoDodjeljen()==true)
								raPoZadacima.remove(element);
						}
					if(raPoZadacima.size()>0) radniZadaci.addAll(raPoZadacima);
					else radniZadaci.clear();
					prZadaci=true;
				}
				else prZadaci=false;
			}
	public void UnesenaPretragaZaObavljenePoslove(Date datumIzvrsenja)
	{
		if(datumIzvrsenja!=null && (prZadaci==false || (prZadaci==true && raPoZadacima.size()>0)))
		{
			ObavljeniPosaoDAO opDAO = new ObavljeniPosaoDAO();
			Set<ObavljeniPosao> op = new HashSet<ObavljeniPosao>();
			
			op.addAll(opDAO.getByDatumObavljanja(datumIzvrsenja));
			
			for (ObavljeniPosao posao : op) 
			{
				if (raPoObavljenomPoslu.size() > 0)
					for (RasporedjeniZadatak r : raPoObavljenomPoslu) 
					{
						if (posao.getPripadajuciZadatak()
								.getRasporedjeniZadatak_id() != r
								.getRasporedjeniZadatak_id())
							raPoObavljenomPoslu.add(posao
									.getPripadajuciZadatak());
					}

				else 
				{
					raPoObavljenomPoslu.add(posao.getPripadajuciZadatak());
				}
			}
			if(raPoObavljenomPoslu.size()>0)
			{
				for (Iterator<RasporedjeniZadatak> it = raPoObavljenomPoslu.iterator(); it.hasNext(); ) 
				{
					RasporedjeniZadatak f = it.next();
					radniZadaci.add(f.getZadatak());
				}
			}
			else
			{
				radniZadaci.clear();
			}
			
			prObavljeniPosao = true;
		}
		else prObavljeniPosao=false;
	}
	
	public void UnesenaPretragaZaRasporedjeneZadatke(Date datumPreuzimanja, Boolean neprihvacen)
	{
		Set<RasporedjeniZadatak> rzadaci = new HashSet<RasporedjeniZadatak>();
		RasporedjeniZadatakDAO rDAO = new RasporedjeniZadatakDAO();
		
		if(datumPreuzimanja!=null && (neprihvacen==false || neprihvacen==true))
		{
			rzadaci.addAll(rDAO.getByDatumPrihvatanja(datumPreuzimanja));
		}

		else if(datumPreuzimanja==null && neprihvacen==true)
		{
			rzadaci.addAll(rDAO.getAll());
		}
		else
			rzadaci=null;
		
		if(rzadaci!=null && (prObavljeniPosao==false || (prObavljeniPosao==true && raPoObavljenomPoslu.size()>0)))
		{
			if(neprihvacen==true && rzadaci.size()>0)
			{
				for (Iterator<RasporedjeniZadatak> it = rzadaci.iterator(); it.hasNext(); ) 
				{
					RasporedjeniZadatak f = it.next();
					if(f.getStatusPrihvacenosti()!=false)
						rzadaci.remove(f);
				}
			}
			if(rzadaci.size()>0)
			{
			for (Iterator<RasporedjeniZadatak> it = rzadaci.iterator(); it.hasNext(); )
			{
				RasporedjeniZadatak f = it.next();
				radniZadaci.add(f.getZadatak());
			}
			}
			else
			{
				radniZadaci.clear();
			}
		}
	}
	
	public RadniZadatak GetZadatak(List<RadniZadatak> zadaci, int index)
	{
		RadniZadatak zadatak = new RadniZadatak();
		zadatak=zadaci.get(index);
		return zadatak;
	}
}
