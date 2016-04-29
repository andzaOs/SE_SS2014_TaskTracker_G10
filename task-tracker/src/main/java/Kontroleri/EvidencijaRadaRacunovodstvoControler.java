package Kontroleri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import DAO.*;
import Entity.*;

public class EvidencijaRadaRacunovodstvoControler {
	private Klijent klijent;
	private VrstaUsluge vrstaUsluge;
	private List<Klijent> klijenti = new ArrayList<Klijent>();
	private List<VrstaUsluge> vrsteUsluge = new ArrayList<VrstaUsluge>();
	private List<ObavljeniPosao> obavljeniPosao = new ArrayList<ObavljeniPosao>();

	public EvidencijaRadaRacunovodstvoControler(){
	}
	
	public List<ObavljeniPosao> getObavljeniPosao() {
		return obavljeniPosao;
	}
	
	public Klijent getKlijent(int index) {
		return this.klijent = klijenti.get(index-1);
	}

	public List<Klijent> getKlijenti() {
		return klijenti;
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

	public List<VrstaUsluge> getVrsteUsluge() {
		return vrsteUsluge;
	}

	
	public void setVrsteUsluge() throws Exception {
		try
		{
		VrstaUslugeDAO vDAO = new VrstaUslugeDAO();
		vrsteUsluge = vDAO.getAll();
		}
		catch (Exception e) {
			throw e;
		}
	}


	public VrstaUsluge getVrstaUsluge(int index) {
		this.vrstaUsluge = vrsteUsluge.get(index-1);
		return vrstaUsluge;
	}

	public Boolean PronadjiObavljenePoslove(Boolean neizvrsen, String ime, String prezime,
			String jmbg, Boolean klijentOdabran, int indexKlijent, Boolean izvrsen, Boolean vrstaUslugeOdabrana,
			int indexVrstaUsluge, Date pocetniDatum, Date krajnjiDatum) throws Exception
	{
		obavljeniPosao.addAll(PronadjiSvePoslove());
		setKlijenti();
		setVrsteUsluge();
		
		if(neizvrsen.equals(true))
			for (int i=obavljeniPosao.size()-1; i>=0; i--) 
			{
				ObavljeniPosao f = obavljeniPosao.get(i);
				if(f.getPripadajuciZadatak().getZadatak().getStatusIzvrsenosti().equals(true))
					{
						obavljeniPosao.remove(f);
					}
			}
		if(ime.equals("")==false)
		{
			for (int i=obavljeniPosao.size()-1; i>=0; i--) 
			{
				ObavljeniPosao f = obavljeniPosao.get(i);
				if(f.getPripadajuciZadatak().getIzvrsilac().getIme().equals(ime)==false)
					obavljeniPosao.remove(f);
			}
		}
		if(prezime.equals("")==false)
			for (int i=obavljeniPosao.size()-1; i>=0; i--) 
			{
				ObavljeniPosao f = obavljeniPosao.get(i);
				if(f.getPripadajuciZadatak().getIzvrsilac().getPrezime().equals(prezime)==false)
					obavljeniPosao.remove(f);
			}
		if(jmbg.equals("")==false)
			for (int i=obavljeniPosao.size()-1; i>=0; i--) 
			{
				ObavljeniPosao f = obavljeniPosao.get(i);
				if(f.getPripadajuciZadatak().getIzvrsilac().getJmbg().equals(jmbg)==false)
					obavljeniPosao.remove(f);
			}
		if(klijentOdabran==true)
		{
			klijent = getKlijent(indexKlijent);
			for (int i=obavljeniPosao.size()-1; i>=0; i--) 
			{
				ObavljeniPosao f = obavljeniPosao.get(i);
				if(f.getPripadajuciZadatak().getZadatak().getKlijent().getKlijent_id()!=klijent.getKlijent_id())
					obavljeniPosao.remove(f);
			}
		}
		if(izvrsen==true)
		{
			for (int i=obavljeniPosao.size()-1; i>=0; i--) 
			{
				ObavljeniPosao f = obavljeniPosao.get(i);
				if(f.getPripadajuciZadatak().getZadatak().getStatusIzvrsenosti()==false)
					obavljeniPosao.remove(f);
			}
		}
		if(vrstaUslugeOdabrana==true)
		{
			vrstaUsluge=getVrstaUsluge(indexVrstaUsluge);
			for (int i=obavljeniPosao.size()-1; i>=0; i--) 
			{
				ObavljeniPosao f = obavljeniPosao.get(i);
				if(f.getVrstaUsluge().getVrstaUsluge_id()!=vrstaUsluge.getVrstaUsluge_id())
					obavljeniPosao.remove(f);
			}
		}
		if(pocetniDatum!=null)
		{
			for (int i=obavljeniPosao.size()-1; i>=0; i--) 
			{
				ObavljeniPosao f = obavljeniPosao.get(i);
				if(f.getDatumObavljanja().before(pocetniDatum))
					obavljeniPosao.remove(f);
			}
		}
		if(krajnjiDatum!=null)
		{
			for (int i=obavljeniPosao.size()-1; i>=0; i--) 
			{
				ObavljeniPosao f = obavljeniPosao.get(i);
				if(f.getDatumObavljanja().after(krajnjiDatum))
					obavljeniPosao.remove(f);
			}
		}
		
		if(obavljeniPosao.size()>0) return true;
		else return false;
	}
	public List<ObavljeniPosao> PronadjiSvePoslove() throws Exception
	{
		List<ObavljeniPosao> poslovi = new ArrayList<ObavljeniPosao>();
		ObavljeniPosaoDAO oDAO = new ObavljeniPosaoDAO();
		try
		{
			poslovi = oDAO.getAll();
		}
		catch (Exception e) {
			throw e;
		}
		return poslovi;
		
	}

}
