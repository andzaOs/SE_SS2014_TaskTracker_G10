package Kontroleri;

import DAO.RadniZadatakDAO;
import Entity.RadniZadatak;

public class IzbrisiZadatakControler {
	
	public IzbrisiZadatakControler(){}
	
	public void Izbrisi(RadniZadatak radniZadatak) throws Exception
	{
		try
		{
		RadniZadatakDAO rDAO = new RadniZadatakDAO();
		radniZadatak.setVidljivo(false);
		RadniZadatak r = new RadniZadatak();
		r.setBrojServisera(radniZadatak.getBrojServisera());
		r.setDatumUnosa(radniZadatak.getDatumUnosa());
		r.setKlijent(radniZadatak.getKlijent());
		r.setKrajnjiDatumIzvrsenja(radniZadatak.getKrajnjiDatumIzvrsenja());
		r.setOpis(radniZadatak.getOpis());
		r.setKreator(radniZadatak.getKreator());
		r.setPotpunoDodjeljen(radniZadatak.getPotpunoDodjeljen());
		r.setRadniZadatak_id(radniZadatak.getRadniZadatak_id());
		r.setStatusDodjeljenosti(radniZadatak.getStatusDodjeljenosti());
		r.setStatusIzvrsenosti(radniZadatak.getStatusIzvrsenosti());
		r.setVidljivo(radniZadatak.getVidljivo());
		r.setVrstaZadatka(radniZadatak.getVrstaZadatka());
		rDAO.update(r);
		}
		catch (Exception e) {
		// TODO Auto-generated catch block
		throw e;
	}
	}

}
