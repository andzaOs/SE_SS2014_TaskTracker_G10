package Entity;

import java.util.Set;




public class TipKorisnika implements java.io.Serializable {
	long tipKorisnika_id;
	String naziv;
	Boolean vidljivo;
	private Set<Korisnik> korisnici; 
	public long getTipKorisnika_id() {
		return tipKorisnika_id;
	}
	public void setTipKorisnika_id(long tipKorisnika_id) {
		this.tipKorisnika_id = tipKorisnika_id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Boolean getVidljivo() {
		return vidljivo;
	}
	public void setVidljivo(Boolean vidljivo) {
		this.vidljivo = vidljivo;
	}
	public Set<Korisnik> getKorisnici() {
		return korisnici;
	}
	public void setKorisnici(Set<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}
	
}
