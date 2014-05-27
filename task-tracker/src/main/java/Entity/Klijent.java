package Entity;

import java.util.Set;

public class Klijent implements java.io.Serializable{
	long klijent_id;
	String naziv, adresa, broj_telefona, email;
	Boolean vidljivo;
	Set<RadniZadatak> zadaci;
	public long getKlijent_id() {
		return klijent_id;
	}
	public void setKlijent_id(long klijent_id) {
		this.klijent_id = klijent_id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getBroj_telefona() {
		return broj_telefona;
	}
	public void setBroj_telefona(String broj_telefona) {
		this.broj_telefona = broj_telefona;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getVidljivo() {
		return vidljivo;
	}
	public void setVidljivo(Boolean vidljivo) {
		this.vidljivo = vidljivo;
	}
	public Set<RadniZadatak> getZadaci() {
		return zadaci;
	}
	public void setZadaci(Set<RadniZadatak> zadaci) {
		this.zadaci = zadaci;
	}
	@Override
	public String toString() {
		return  naziv;
	}

}
