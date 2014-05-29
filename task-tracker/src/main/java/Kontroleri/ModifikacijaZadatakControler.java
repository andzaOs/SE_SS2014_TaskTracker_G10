package Kontroleri;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DAO.*;
import Entity.*;

public class ModifikacijaZadatakControler {
	
	private List<Klijent> klijenti;
	private int brojRasporedjenihZadataka;
	private int maxBrojServiseraZaDodjelu;
	
	public int getBrojRasporedjenihZadataka() {
		return brojRasporedjenihZadataka;
	}
	
	public int getMaxBrojServiseraZaDodjelu() {
		return maxBrojServiseraZaDodjelu;
	}

	public ModifikacijaZadatakControler(){
		brojRasporedjenihZadataka = 0;
	}

	public void setKlijenti() 
	{
		klijenti = new ArrayList<Klijent>();;
		KlijentDAO kDAO = new KlijentDAO();
		klijenti = kDAO.getAll();
		for(int i=0; i<klijenti.size(); i++) {
	 		if(klijenti.get(i).getVidljivo()) {
	 			}
	 		else {
	 			klijenti.remove(i);
	 			i=i-1;
	 		}
		}
	}
	
	public List<Klijent> getKlijente()
	{	
		return klijenti;
	}
	
	public Boolean ModifikujRadniZadatak(RadniZadatak zadatak, int maksimalanBrojServisera, Date datumIzvrsenja, int indexKlijent, String opis, String vrstaZadatka, Boolean serviserSelektovan, List<Korisnik> selektovaniServiseri)
	{
		setKlijenti();
		RadniZadatak radniZadatak = new RadniZadatak();
		radniZadatak.setRadniZadatak_id(zadatak.getRadniZadatak_id());
		radniZadatak.setDatumUnosa(zadatak.getDatumUnosa());
		radniZadatak.setBrojServisera(maksimalanBrojServisera);
		Klijent k = new Klijent();
		k = klijenti.get(indexKlijent);
		radniZadatak.setKlijent(k);
		radniZadatak.setKrajnjiDatumIzvrsenja(datumIzvrsenja);
		radniZadatak.setOpis(opis);
		radniZadatak.setVidljivo(true);
		radniZadatak.setVrstaZadatka(vrstaZadatka);
		radniZadatak.setStatusIzvrsenosti(false);
		
		RadniZadatakDAO radniZadatakDAO = new RadniZadatakDAO();
		
		if (serviserSelektovan == true) 
		{
			int statusDodijeljenosti = zadatak.getStatusDodjeljenosti()+selektovaniServiseri.size();
			radniZadatak.setStatusDodjeljenosti(statusDodijeljenosti);
			if(radniZadatak.getStatusDodjeljenosti() > maksimalanBrojServisera)
			{
				maksimalanBrojServisera=maksimalanBrojServisera-radniZadatak.getBrojServisera();
				return false;
			}
			
			else if (radniZadatak.getStatusDodjeljenosti() == maksimalanBrojServisera) 
			{
				radniZadatak.setPotpunoDodjeljen(true);
			} 
			else
				radniZadatak.setPotpunoDodjeljen(false);
			
			for (int i = 0; i < selektovaniServiseri.size(); i++) {
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
	
		else 
		{
				radniZadatak.setStatusDodjeljenosti(zadatak.getStatusDodjeljenosti());
				radniZadatak.setPotpunoDodjeljen(zadatak.getPotpunoDodjeljen());
		}
		
		radniZadatakDAO.update(radniZadatak);
		return true;
		
}
}

