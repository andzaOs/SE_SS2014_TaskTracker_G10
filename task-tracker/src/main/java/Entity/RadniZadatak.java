package Entity;


import java.util.Date;
import java.util.List;



public class RadniZadatak implements java.io.Serializable{
	long id;
	String opis;
	Klijent klijent;
	Date krajnjiDatumIzvrsenja,vrijemeUnosa;
	int maxBrojServisera,statusDodjeljenosti;
	Boolean statusIzvrsenja, zadatakDodjeljen, vidljivo;
	Korisnik racunovodja;
	public Korisnik getRacunovodja() {
		return racunovodja;
	}
	public void setRacunovodja(Korisnik racunovodja) {
		this.racunovodja = racunovodja;
	}
	public List<Korisnik> getServiseri() {
		return serviseri;
	}
	public void setServiseri(List<Korisnik> serviseri) {
		this.serviseri = serviseri;
	}
	List<Korisnik> serviseri;
	public RadniZadatak() {};
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Klijent getKlijent() {
		return klijent;
	}
	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}
	public Date getKrajnjiDatumIzvrsenja() {
		return krajnjiDatumIzvrsenja;
	}
	public void setKrajnjiDatumIzvrsenja(Date krajnjiDatumIzvrsenja) {
		this.krajnjiDatumIzvrsenja = krajnjiDatumIzvrsenja;
	}
	public Date getVrijemeUnosa() {
		return vrijemeUnosa;
	}
	public void setVrijemeUnosa(Date vrijemeUnosa) {
		this.vrijemeUnosa = vrijemeUnosa;
	}
	public int getMaxBrojServisera() {
		return maxBrojServisera;
	}
	public void setMaxBrojServisera(int maxBrojServisera) {
		this.maxBrojServisera = maxBrojServisera;
	}
	public int getStatusDodjeljenosti() {
		return statusDodjeljenosti;
	}
	public void setStatusDodjeljenosti(int statusDodjeljenosti) {
		this.statusDodjeljenosti = statusDodjeljenosti;
	}
	public Boolean getStatusIzvrsenja() {
		return statusIzvrsenja;
	}
	public void setStatusIzvrsenja(Boolean statusIzvrsenja) {
		this.statusIzvrsenja = statusIzvrsenja;
	}
	public Boolean getZadatakDodjeljen() {
		return zadatakDodjeljen;
	}
	public void setZadatakDodjeljen(Boolean zadatakDodjeljen) {
		this.zadatakDodjeljen = zadatakDodjeljen;
	}
	public Boolean getVidljivo() {
		return vidljivo;
	}
	public void setVidljivo(Boolean vidljivo) {
		this.vidljivo = vidljivo;
	}
	
	
	
	
	
	
	
	

}


