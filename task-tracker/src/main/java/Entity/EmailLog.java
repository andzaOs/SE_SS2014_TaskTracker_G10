package Entity;

import java.sql.Date;

public class EmailLog implements java.io.Serializable {

	long emaillog_id;
	Date datum;
	
	public long getEmaillog_id() {
		return emaillog_id;
	}
	public void setEmaillog_id(long emaillog_id) {
		this.emaillog_id = emaillog_id;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
		
}
