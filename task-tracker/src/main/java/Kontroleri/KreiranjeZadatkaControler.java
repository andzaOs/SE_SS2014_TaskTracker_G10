package Kontroleri;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DAO.*;
import Entity.*;

public class KreiranjeZadatkaControler {
	
	private List<Klijent> klijenti;
	private int brojRasporedjenihZadataka;
	
	public int getBrojRasporedjenihZadataka() {
		return brojRasporedjenihZadataka;
	}

	public KreiranjeZadatkaControler(){
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
	 			i=i-1;;
	 		}
		}
	}
	
	public List<Klijent> getKlijente()
	{	
		return klijenti;
	}
	
	public void KreirajRadniZadatak(int maksimalanBrojServisera, Date datumIzvrsenja, int indexKlijent, String opis, String vrstaZadatka, Boolean serviserSelektovan, List<Korisnik> selektovaniServiseri)
	{
		setKlijenti();
		RadniZadatak radniZadatak = new RadniZadatak();
		Date now = new Date();
		radniZadatak.setDatumUnosa(now);
		radniZadatak.setBrojServisera(maksimalanBrojServisera);
		Klijent k = new Klijent();
		System.out.println(indexKlijent);
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

			radniZadatak.setStatusDodjeljenosti(selektovaniServiseri.size());
			
			if (radniZadatak.getStatusDodjeljenosti() == maksimalanBrojServisera) 
			{
				radniZadatak.setPotpunoDodjeljen(true);
			} 
			else
				radniZadatak.setPotpunoDodjeljen(false);

			long idZadatak = radniZadatakDAO.create(radniZadatak);
			radniZadatak.setRadniZadatak_id(idZadatak);

			for (int i = 0; i < selektovaniServiseri.size(); i++) {
				RasporedjeniZadatak raz = new RasporedjeniZadatak();
				raz.setIzvrsilac(selektovaniServiseri.get(i));
				raz.setZadatak(radniZadatak);
				raz.setVidljivo(true);
				raz.setStatusPrihvacenosti(false);
				RasporedjeniZadatakDAO razDAO = new RasporedjeniZadatakDAO();
				long idRasporedjeniZadatak = razDAO.create(raz);
				raz.setRasporedjeniZadatak_id(idRasporedjeniZadatak);
				brojRasporedjenihZadataka++;
			}
		
		}
		
		else 
		{
				radniZadatak.setStatusDodjeljenosti(0);
				radniZadatak.setPotpunoDodjeljen(false);
				long idZadatak = radniZadatakDAO.create(radniZadatak);
				radniZadatak.setRadniZadatak_id(idZadatak);
		}
	}
	
	
}
