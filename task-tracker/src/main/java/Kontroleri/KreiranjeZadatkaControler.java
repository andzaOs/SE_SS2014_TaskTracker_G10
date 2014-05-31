package Kontroleri;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DAO.KlijentDAO;
import DAO.KorisnikDAO;
import DAO.RadniZadatakDAO;
import DAO.RasporedjeniZadatakDAO;
import Entity.Klijent;
import Entity.Korisnik;
import Entity.RadniZadatak;
import Entity.RasporedjeniZadatak;

public class KreiranjeZadatkaControler {
	
	private List<Klijent> klijenti;


	public void setKlijenti() throws Exception 
	{
		try
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
	 catch (Exception e) {
		throw e;
	}
	}
	
	public List<Klijent> getKlijente()
	{	
		return klijenti;
	}
	
	public void KreirajRadniZadatak(int maksimalanBrojServisera, Date datumIzvrsenja, int indexKlijent, String opis, String vrstaZadatka, Boolean serviserSelektovan, List<Korisnik> selektovaniServiseri) throws Exception
	{
		setKlijenti();
		RadniZadatak radniZadatak = new RadniZadatak();
		Date now = new Date();
		radniZadatak.setDatumUnosa(now);
		radniZadatak.setBrojServisera(maksimalanBrojServisera);
		Klijent klijent = new Klijent();
		System.out.println(indexKlijent);
		klijent = klijenti.get(indexKlijent);
		radniZadatak.setKlijent(klijent);
		radniZadatak.setKrajnjiDatumIzvrsenja(datumIzvrsenja);
		radniZadatak.setOpis(opis);
		radniZadatak.setVidljivo(true);
		radniZadatak.setVrstaZadatka(vrstaZadatka);
		radniZadatak.setStatusIzvrsenosti(false);
		Korisnik korisnik = new Korisnik();
		KorisnikDAO kDAO = new KorisnikDAO();
		try
		{
		korisnik = kDAO.getById(SessionControler.getIdLog());
		radniZadatak.setKreator(korisnik);
		
		RadniZadatakDAO radniZadatakDAO = new RadniZadatakDAO();

		if (serviserSelektovan == true) 
		{

			radniZadatak.setStatusDodjeljenosti(selektovaniServiseri.size());
			
			if (selektovaniServiseri.size() == maksimalanBrojServisera) 
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
	 catch (Exception e) {
		throw e;
	}
	}
	
	
}
