package UtilClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.hibernate.Query;

import DAO.EmailLogDAO;
import DAO.PostavkaMailDAO;
import Entity.EmailLog;
import Entity.PostavkaMail;

public class Email {
	
	String username = "tasktracker.info@gmail.com";
	String password = "asdfgh987";
	String Adrese;
	
	private void posaljiEmail(String Poruka, List<String> Emailovi) {
	
		if(Emailovi.size()>1){
			Adrese = Emailovi.get(1);
			for(int i=2; i<Emailovi.size(); i++) 
			{
				Adrese += "," + Emailovi.get(i);
			}
		}
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("tasktracker.info@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(Emailovi.get(0)));
			
			if(Emailovi.size()>1){
			    message.setRecipients(Message.RecipientType.CC, 
				InternetAddress.parse(Adrese));
			}
			
			message.setSubject("TaskTracker - Info");
			message.setText(Poruka);
 
			Transport.send(message);
 
			System.out.println("Email poslan :)");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}

	private void posaljiUpozorenje()
	{

		List<String> adrese = new ArrayList<String> ();
        PostavkaMail p = new PostavkaMail();
		PostavkaMailDAO pDAO = new PostavkaMailDAO();
		p = pDAO.vratiPostavke();

        org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
        
        Query query = session.createSQLQuery("SELECT DISTINCT k.email "
        		+ "FROM korisnik k, radnizadatak radz, rasporedjenizadatak rasz "
        		+ "WHERE k.korisnik_id = radz.korisnik_id AND radz.radnizadatak_id = rasz.radnizadatak_id AND rasz.statusprihvacenosti = 0 "
        		+ "AND (TO_DAYS(CURDATE())-TO_DAYS(radz.datumunosa)) = " + p.getRokPreuzimanje() );
        
        adrese = query.list();        
        session.close();
        
         if (adrese.size() > 0) posaljiEmail(p.getOpomena(), adrese);
		
	}

	private void posaljiObavijest() {
		
		List<String> adrese = new ArrayList<String> ();
        PostavkaMail p = new PostavkaMail();
		PostavkaMailDAO pDAO = new PostavkaMailDAO();
		p = pDAO.vratiPostavke();
		
        org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createSQLQuery("SELECT DISTINCT k.email "
        		+ "FROM korisnik k, radnizadatak radz, rasporedjenizadatak rasz, obavljeniposao o "
        		+ "WHERE k.korisnik_id = radz.korisnik_id "
        		+ "AND radz.radnizadatak_id = rasz.radnizadatak_id "
        		+ "AND o.rasporedjenizadatak_id = rasz.rasporedjenizadatak_id "
        		+ "AND radz.statusizvrsenosti = 1 "
        		+ "AND (TO_DAYS(CURDATE())-TO_DAYS(radz.krajnjidatumizvrsenja)) = " + p.getRokUnos() );
        
        adrese = query.list();        
        session.close();
        
        if (adrese.size() > 0) posaljiEmail(p.getObavijest(), adrese);
		
	}

	public void posaljiPoruke() {
		
		try {
			EmailLogDAO eDAO = new EmailLogDAO();
			EmailLog e = eDAO.vratiLog();
			
	    	java.util.Date datum = new java.util.Date();
	    	java.sql.Date sqlDatum = new java.sql.Date(datum.getTime());
	    	
	    	System.out.println(sqlDatum);
	    	System.out.println(e.getDatum());
	    	System.out.println(sqlDatum.toString().equals(e.getDatum().toString()) );
	    	
	    	if ( !sqlDatum.toString().equals(e.getDatum().toString()) ) {
	    		System.out.println("...");
	    		
	    		posaljiUpozorenje();
				posaljiObavijest();
				
				EmailLog e1 = new EmailLog();
				e1.setDatum(sqlDatum);
				
				EmailLogDAO eDAO1 = new EmailLogDAO();
				eDAO1.create(e1);
				
	    	}
			
		} catch ( Exception ex ) {

		}
		
		
	}
	
}