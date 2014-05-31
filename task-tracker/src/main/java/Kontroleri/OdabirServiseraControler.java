package Kontroleri;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import DAO.*;
import Entity.*;

public class OdabirServiseraControler {

	private List<Korisnik> serviseri = new ArrayList<Korisnik>();
	private List<Korisnik> selektovaniServiseri = new ArrayList<Korisnik>();
	
	
	public OdabirServiseraControler(){
		serviseri.clear();
		selektovaniServiseri.clear();
	}
	
	public List<Korisnik> getSelektovaniServiseri() {
		return selektovaniServiseri;
	}

	public void setSelektovaniServiseri(List<Korisnik> selektovaniServiseri) {
		this.selektovaniServiseri = selektovaniServiseri;
	}

	public List<Korisnik> getServiseri() {
		return serviseri;
	}
	public void setServisere(RadniZadatak zadatak) throws Exception
	{
		try
		{
		KorisnikDAO kDAO;
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
		
		if(zadatak!=null)
		{
			korisnici.clear();
			korisnici.addAll(serviseri);
			serviseri.clear();
			List<RasporedjeniZadatak> r = new ArrayList<RasporedjeniZadatak>();
			RasporedjeniZadatakDAO rDAO = new RasporedjeniZadatakDAO();
			r = rDAO.getByRadniZadatak(zadatak);
			for(int i=0; i<r.size(); i++)
			{
				for(int j=0; j<korisnici.size(); j++)
				{
					if(r.get(i).getIzvrsilac().getKorisnik_id()==korisnici.get(j).getKorisnik_id())
					{
						korisnici.remove(j);
					}
				}
			}
			serviseri.addAll(korisnici);
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
	public List<List> getRedoviTabele() throws Exception
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

		for (int i = 0; i < serviseri.size(); i++)
		{
			// Računamo broj dodijeljenih zadataka svakom serviseru pojedinačno,
			// a koji nisu izvršeni
			List<RadniZadatak> radniZadaci = new ArrayList<RadniZadatak>();
			for (int j = 0; j < rasporedjeniZadaci.size(); j++) 
			{
				if (rasporedjeniZadaci.get(j).getIzvrsilac().getKorisnik_id() == serviseri
						.get(i).getKorisnik_id()) 
				{
					if (rasporedjeniZadaci.get(j).getZadatak()
							.getStatusIzvrsenosti() == false)
						radniZadaci.add(rasporedjeniZadaci.get(j).getZadatak());
				}

			}

			Integer zadaci = radniZadaci.size();
			String brojDodijeljenihZadataka = zadaci.toString();
			redovi.add(Arrays.asList(serviseri.get(i).getIme(),serviseri.get(i).getPrezime(), brojDodijeljenihZadataka));
			
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
	public Boolean DodijeliServisere(RadniZadatak zadatak) throws Exception
	{
	
		RadniZadatakDAO radniZadatakDAO = new RadniZadatakDAO();
		
		int statusDodijeljenosti = zadatak.getStatusDodjeljenosti()+selektovaniServiseri.size();
		if(statusDodijeljenosti>zadatak.getBrojServisera()) return false;
		
		else
		{
			zadatak.setStatusDodjeljenosti(statusDodijeljenosti);
			
			if (zadatak.getStatusDodjeljenosti() == zadatak.getBrojServisera()) 
			{
				zadatak.setPotpunoDodjeljen(true);
			} 
			else
				zadatak.setPotpunoDodjeljen(false);
			
			zadatak.setStatusDodjeljenosti(statusDodijeljenosti);
			try
			{
			RadniZadatak z = new RadniZadatak();
			System.out.println("ID"+zadatak.getRadniZadatak_id());
			z.setRadniZadatak_id(zadatak.getRadniZadatak_id());
			z.setBrojServisera(zadatak.getBrojServisera());
			z.setDatumUnosa(zadatak.getDatumUnosa());
			z.setKlijent(zadatak.getKlijent());
			z.setKrajnjiDatumIzvrsenja(zadatak.getKrajnjiDatumIzvrsenja());
			z.setOpis(zadatak.getOpis());
			z.setPotpunoDodjeljen(zadatak.getPotpunoDodjeljen());
			z.setStatusDodjeljenosti(zadatak.getStatusDodjeljenosti());
			z.setStatusIzvrsenosti(zadatak.getStatusIzvrsenosti());
			z.setVidljivo(zadatak.getVidljivo());
			Korisnik korisnik = new Korisnik();
			KorisnikDAO kDAO = new KorisnikDAO();
			korisnik = kDAO.getById(SessionControler.getIdLog());
			z.setVrstaZadatka(zadatak.getVrstaZadatka());
			z.setKreator(korisnik);
			radniZadatakDAO.update(z);
		
			for (int i = 0; i < selektovaniServiseri.size(); i++)
			{
				RasporedjeniZadatak raz = new RasporedjeniZadatak();
				raz.setIzvrsilac(selektovaniServiseri.get(i));
				raz.setZadatak(zadatak);
				raz.setVidljivo(true);
				raz.setStatusPrihvacenosti(false);
				RasporedjeniZadatakDAO razDAO = new RasporedjeniZadatakDAO();
				long idRasporedjeniZadatak = razDAO.create(raz);
				raz.setRasporedjeniZadatak_id(idRasporedjeniZadatak);
			}
			}
			 catch (Exception e) {
				throw e;
				}
			return true;
		}
	
	}

	}
	




