package Entity;

public class PostavkaMail implements java.io.Serializable {
	long postavkamail_id;
	int rokUnos;
	int rokPreuzimanje;
	String opomena;
	String obavijest;
	
	public PostavkaMail() {};
	
	public long getPostavkamail_id() {
		return postavkamail_id;
	}
	public void setPostavkamail_id(long postavkamail_id) {
		this.postavkamail_id = postavkamail_id;
	}	
	public int getRokUnos() {
		return rokUnos;
	}
	public void setRokUnos(int rokUnos) {
		this.rokUnos = rokUnos;
	}
	public int getRokPreuzimanje() {
		return rokPreuzimanje;
	}
	public void setRokPreuzimanje(int rokPreuzimanje) {
		this.rokPreuzimanje = rokPreuzimanje;
	}
	public String getOpomena() {
		return opomena;
	}
	public void setOpomena(String opomena) {
		this.opomena = opomena;
	}
	public String getObavijest() {
		return obavijest;
	}
	public void setObavijest(String obavijest) {
		this.obavijest = obavijest;
	}
	
	
	
}
