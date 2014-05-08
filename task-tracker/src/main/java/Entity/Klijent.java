package Entity;

public class Klijent  implements java.io.Serializable {
	long id;
	String naziv, adresa, brojTelefona, email;
	Boolean vidljivo;
	
	public Klijent() {};
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
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
	
	
}
