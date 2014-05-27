package Entity;

import java.util.Date;
import java.util.Set;



public class Korisnik implements java.io.Serializable{
	long korisnik_id;
	String ime;
	String prezime;
	String jmbg;
	String br_lk;
	String adresa;
	String telefon;
	String email;
	String korisnicko_ime;
	int lozinka;
	Date datum_zaposlenja;
	Boolean vidljivo;
	private TipKorisnika tip_korisnika;
	Set<RadniZadatak> dodjeljeniZadaci; // Za racunovodju zadaci koje je dodijelio
	Set<RasporedjeniZadatak> vlastitiZadaci; // Za servisera zadaci na kojima radi (bez obzira je li ih prihvatio ili ne
	public long getKorisnik_id() {
		return korisnik_id;
	}
	public void setKorisnik_id(long korisnik_id) {
		this.korisnik_id = korisnik_id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public String getBr_lk() {
		return br_lk;
	}
	public void setBr_lk(String br_lk) {
		this.br_lk = br_lk;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getKorisnicko_ime() {
		return korisnicko_ime;
	}
	public void setKorisnicko_ime(String korisnicko_ime) {
		this.korisnicko_ime = korisnicko_ime;
	}
	public int getLozinka() {
		return lozinka;
	}
	public void setLozinka(int lozinka) {
		this.lozinka = lozinka;
	}
	public Date getDatum_zaposlenja() {
		return datum_zaposlenja;
	}
	public void setDatum_zaposlenja(Date datum_zaposlenja) {
		this.datum_zaposlenja = datum_zaposlenja;
	}
	public Boolean getVidljivo() {
		return vidljivo;
	}
	public void setVidljivo(Boolean vidljivo) {
		this.vidljivo = vidljivo;
	}
	public TipKorisnika getTip_korisnika() {
		return tip_korisnika;
	}
	public void setTip_korisnika(TipKorisnika tip_korisnika) {
		this.tip_korisnika = tip_korisnika;
	}
	public Set<RadniZadatak> getDodjeljeniZadaci() {
		return dodjeljeniZadaci;
	}
	public void setDodjeljeniZadaci(Set<RadniZadatak> dodjeljeniZadaci) {
		this.dodjeljeniZadaci = dodjeljeniZadaci;
	}
	public Set<RasporedjeniZadatak> getVlastitiZadaci() {
		return vlastitiZadaci;
	}
	public void setVlastitiZadaci(Set<RasporedjeniZadatak> vlastitiZadaci) {
		this.vlastitiZadaci = vlastitiZadaci;
	}
	@Override
	public String toString() {
		return ime + " " + prezime;
	}
}

