package Entity;

import java.sql.Date;

public class ObavljeniPosao implements java.io.Serializable {
	long obavljeniPosao_id;
	RasporedjeniZadatak pripadajuciZadatak;
	VrstaUsluge vrstaUsluge;
	int brojSati;
	Date datumUnosa, datumObavljanja;
	String opisa;
	Boolean vidljivo;
	public long getObavljeniPosao_id() {
		return obavljeniPosao_id;
	}
	public void setObavljeniPosao_id(long obavljeniPosao_id) {
		this.obavljeniPosao_id = obavljeniPosao_id;
	}
	public RasporedjeniZadatak getPripadajuciZadatak() {
		return pripadajuciZadatak;
	}
	public void setPripadajuciZadatak(RasporedjeniZadatak pripadajuciZadatak) {
		this.pripadajuciZadatak = pripadajuciZadatak;
	}
	public VrstaUsluge getVrstaUsluge() {
		return vrstaUsluge;
	}
	public void setVrstaUsluge(VrstaUsluge vrstaUsluge) {
		this.vrstaUsluge = vrstaUsluge;
	}
	public int getBrojSati() {
		return brojSati;
	}
	public void setBrojSati(int brojSati) {
		this.brojSati = brojSati;
	}
	public Date getDatumUnosa() {
		return datumUnosa;
	}
	public void setDatumUnosa(Date datumUnosa) {
		this.datumUnosa = datumUnosa;
	}
	public Date getDatumObavljanja() {
		return datumObavljanja;
	}
	public void setDatumObavljanja(Date datumObavljanja) {
		this.datumObavljanja = datumObavljanja;
	}
	public String getOpisa() {
		return opisa;
	}
	public void setOpisa(String opisa) {
		this.opisa = opisa;
	}
	public Boolean getVidljivo() {
		return vidljivo;
	}
	public void setVidljivo(Boolean vidljivo) {
		this.vidljivo = vidljivo;
	}
}
