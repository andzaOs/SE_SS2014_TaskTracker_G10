package Entity;

import java.util.Set;

public class VrstaUsluge implements java.io.Serializable {
	long vrstaUsluge_id;
	String naziv;
	Set<ObavljeniPosao> savObavljeniPosao;
	Boolean vidljivo;
	public long getVrstaUsluge_id() {
		return vrstaUsluge_id;
	}
	public void setVrstaUsluge_id(long vrstaUsluge_id) {
		this.vrstaUsluge_id = vrstaUsluge_id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Set<ObavljeniPosao> getSavObavljeniPosao() {
		return savObavljeniPosao;
	}
	public void setSavObavljeniPosao(Set<ObavljeniPosao> savObavljeniPosao) {
		this.savObavljeniPosao = savObavljeniPosao;
	}
	public Boolean getVidljivo() {
		return vidljivo;
	}
	public void setVidljivo(Boolean vidljivo) {
		this.vidljivo = vidljivo;
	}
	@Override
	public String toString() {
		return  naziv;
	}
}
