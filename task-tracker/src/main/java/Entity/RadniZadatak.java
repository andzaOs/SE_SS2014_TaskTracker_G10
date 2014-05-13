package Entity;

import java.sql.Date;
import java.util.Set;

public class RadniZadatak implements java.io.Serializable{
	long radniZadatak_id;
	Klijent klijent;
	Korisnik kreator;
	Set<RasporedjeniZadatak> rasporedjeniZadaci;
	int brojServisera, statusDodjeljenosti;
	Date datumUnosa, krajnjiDatumIzvrsenja;
	Boolean potpunoDodjeljen, statusIzvrsenosti, vidljivo;
	String opis, vrstaZadatka;
	public long getRadniZadatak_id() {
		return radniZadatak_id;
	}
	public void setRadniZadatak_id(long radniZadatak_id) {
		this.radniZadatak_id = radniZadatak_id;
	}
	public Klijent getKlijent() {
		return klijent;
	}
	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}
	public Korisnik getKreator() {
		return kreator;
	}
	public void setKreator(Korisnik kreator) {
		this.kreator = kreator;
	}
	public Set<RasporedjeniZadatak> getRasporedjeniZadaci() {
		return rasporedjeniZadaci;
	}
	public void setRasporedjeniZadaci(Set<RasporedjeniZadatak> rasporedjeniZadaci) {
		this.rasporedjeniZadaci = rasporedjeniZadaci;
	}
	public int getBrojServisera() {
		return brojServisera;
	}
	public void setBrojServisera(int brojServisera) {
		this.brojServisera = brojServisera;
	}
	public int getStatusDodjeljenosti() {
		return statusDodjeljenosti;
	}
	public void setStatusDodjeljenosti(int statusDodjeljenosti) {
		this.statusDodjeljenosti = statusDodjeljenosti;
	}
	public Date getDatumUnosa() {
		return datumUnosa;
	}
	public void setDatumUnosa(Date datumUnosa) {
		this.datumUnosa = datumUnosa;
	}
	public Date getKrajnjiDatumIzvrsenja() {
		return krajnjiDatumIzvrsenja;
	}
	public void setKrajnjiDatumIzvrsenja(Date krajnjiDatumIzvrsenja) {
		this.krajnjiDatumIzvrsenja = krajnjiDatumIzvrsenja;
	}
	public Boolean getPotpunoDodjeljen() {
		return potpunoDodjeljen;
	}
	public void setPotpunoDodjeljen(Boolean potpunoDodjeljen) {
		this.potpunoDodjeljen = potpunoDodjeljen;
	}
	public Boolean getStatusIzvrsenosti() {
		return statusIzvrsenosti;
	}
	public void setStatusIzvrsenosti(Boolean statusIzvrsenosti) {
		this.statusIzvrsenosti = statusIzvrsenosti;
	}
	public Boolean getVidljivo() {
		return vidljivo;
	}
	public void setVidljivo(Boolean vidljivo) {
		this.vidljivo = vidljivo;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getVrstaZadatka() {
		return vrstaZadatka;
	}
	public void setVrstaZadatka(String vrstaZadatka) {
		this.vrstaZadatka = vrstaZadatka;
	}
}
