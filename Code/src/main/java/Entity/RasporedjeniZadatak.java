package Entity;

import java.sql.Date;
import java.util.Set;

public class RasporedjeniZadatak implements java.io.Serializable {
	long rasporedjeniZadatak_id;
	RadniZadatak zadatak;
	Korisnik izvrsilac;
	Boolean statusPrihvacenosti, vidljivo;
	Date datumPrihvatanja;
	Set<ObavljeniPosao> savPosao;
	public long getRasporedjeniZadatak_id() {
		return rasporedjeniZadatak_id;
	}
	public void setRasporedjeniZadatak_id(long rasporedjeniZadatak_id) {
		this.rasporedjeniZadatak_id = rasporedjeniZadatak_id;
	}
	public RadniZadatak getZadatak() {
		return zadatak;
	}
	public void setZadatak(RadniZadatak zadatak) {
		this.zadatak = zadatak;
	}
	public Korisnik getIzvrsilac() {
		return izvrsilac;
	}
	public void setIzvrsilac(Korisnik izvrsilac) {
		this.izvrsilac = izvrsilac;
	}
	public Boolean getStatusPrihvacenosti() {
		return statusPrihvacenosti;
	}
	public void setStatusPrihvacenosti(Boolean statusPrihvacenosti) {
		this.statusPrihvacenosti = statusPrihvacenosti;
	}
	public Boolean getVidljivo() {
		return vidljivo;
	}
	public void setVidljivo(Boolean vidljivo) {
		this.vidljivo = vidljivo;
	}
	public Date getDatumPrihvatanja() {
		return datumPrihvatanja;
	}
	public void setDatumPrihvatanja(Date datumPrihvatanja) {
		this.datumPrihvatanja = datumPrihvatanja;
	}
	public Set<ObavljeniPosao> getSavPosao() {
		return savPosao;
	}
	public void setSavPosao(Set<ObavljeniPosao> savPosao) {
		this.savPosao = savPosao;
	}
}
