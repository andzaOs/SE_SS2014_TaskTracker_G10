package Kontroleri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import DAO.*;
import Entity.*;

public class OdabirServiseraModifikacijaControler {

	private List<Korisnik> serviseri = new ArrayList<Korisnik>();
	private List<Korisnik> odabraniServiseri = new ArrayList<Korisnik>();
	private List<Korisnik> selektovaniServiseri = new ArrayList<Korisnik>();
	private KorisnikDAO kDAO;
	
	
	public OdabirServiseraModifikacijaControler(){}
	
	public List<Korisnik> getSelektovaniServiseri() {
		return selektovaniServiseri;
	}

	public void setSelektovaniServiseri(List<Korisnik> selektovaniServiseri) {
		this.selektovaniServiseri = selektovaniServiseri;
	}

	public List<Korisnik> getOdabraniServiseri() {
		return odabraniServiseri;
	}
	

	public List<Korisnik> getServiseri() {
		return serviseri;
	}
	
	public void setPostojeceServisere(RadniZadatak zadatak) throws Exception
	{
		try
		{
		List<RasporedjeniZadatak> rzadaci = new ArrayList<RasporedjeniZadatak>();
		RasporedjeniZadatakDAO rDAO = new RasporedjeniZadatakDAO();
		rzadaci = rDAO.getByRadniZadatak(zadatak);
		for(int i=0; i<rzadaci.size(); i++)
			odabraniServiseri.add(rzadaci.get(i).getIzvrsilac());
		}
	 catch (Exception e) {
		throw e;
	}
	}
	public void setDostupneServisere(RadniZadatak zadatak) throws Exception
	{
		try
		{
		List<Korisnik> korisnici;
		korisnici = new ArrayList<Korisnik>();
		kDAO = new KorisnikDAO();
		korisnici = kDAO.getAll();

		// Dobavljamo samo servisere iz baze podataka
		for (int i = 0; i < korisnici.size(); i++) {
			if (korisnici.get(i).getTip_korisnika().getNaziv()
					.equals("Serviser"))
				serviseri.add(korisnici.get(i));
		}
		
		List<RasporedjeniZadatak> r = new ArrayList<RasporedjeniZadatak>();
		RasporedjeniZadatakDAO rDAO = new RasporedjeniZadatakDAO();
		r = rDAO.getByRadniZadatak(zadatak);
		for(int i=0; i<r.size(); i++)
		{
			for(int j=0; j<serviseri.size(); j++)
			{
				if(r.get(i).getIzvrsilac().getKorisnik_id()==serviseri.get(j).getKorisnik_id())
				{
					serviseri.remove(j);
				}
			}
		}
		}
	 catch (Exception e) {
		throw e;
	}
	}
	
	public Boolean ProvjeriBrojServisera(int maxBrojServisera)
	{
		int status;
		status=selektovaniServiseri.size();
		if(status>maxBrojServisera) return false;
		else return true;

	}
	
	@SuppressWarnings("rawtypes")
	public List<List> getRedoviTabele(int brojTabela) throws Exception
	{
	
		RasporedjeniZadatakDAO rzDAO = new RasporedjeniZadatakDAO();
		List<RasporedjeniZadatak> rasporedjeniZadaci = new ArrayList<RasporedjeniZadatak>();
		try
		{
		rasporedjeniZadaci = rzDAO.getAll();
		}
		 catch (Exception e) {
				throw e;
			}
		@SuppressWarnings("unchecked")
		List<List> redovi = new ArrayList();

		List<Korisnik> serviseriTabela = new ArrayList<Korisnik>();
		if(brojTabela==1) serviseriTabela.addAll(serviseri);
		else serviseriTabela.addAll(odabraniServiseri);
		
		for (int i = 0; i < serviseriTabela.size(); i++)
		{
			// Računamo broj dodijeljenih zadataka svakom serviseru pojedinačno,
			// a koji nisu izvršeni
			List<RadniZadatak> radniZadaci = new ArrayList<RadniZadatak>();
			for (int j = 0; j < rasporedjeniZadaci.size(); j++) 
			{
				if (rasporedjeniZadaci.get(j).getIzvrsilac().getKorisnik_id() == serviseriTabela
						.get(i).getKorisnik_id()) 
				{
					if (rasporedjeniZadaci.get(j).getZadatak()
							.getStatusIzvrsenosti() == false)
						radniZadaci.add(rasporedjeniZadaci.get(j).getZadatak());
				}

			}

			Integer zadaci = radniZadaci.size();
			String brojDodijeljenihZadataka = zadaci.toString();
			redovi.add(Arrays.asList(serviseriTabela.get(i).getIme(),serviseriTabela.get(i).getPrezime(), brojDodijeljenihZadataka));
			
		}
			return redovi;
		
		}
	
	public int getSelektoviServiseriSize(int indexServiseri[])
	{
		for (int i = 0; i < indexServiseri.length; i++) 
		{
			int index = indexServiseri[i];
			selektovaniServiseri.add(serviseri.get(index));
		}
		return selektovaniServiseri.size();
	}
	

	public Korisnik getSelektovaniServiser(int indexTabela)
	{
		Korisnik selektovaniServiser = new Korisnik();
		selektovaniServiser = serviseri.get(indexTabela);
		return selektovaniServiser;
	}
	

}


