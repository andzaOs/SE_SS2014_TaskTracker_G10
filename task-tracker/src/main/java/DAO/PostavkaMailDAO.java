package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import Entity.Korisnik;
import Entity.PostavkaMail;
import UtilClasses.HibernateUtil;

public class PostavkaMailDAO {
	
	Session session;
	Transaction t;

	public PostavkaMailDAO() {
    	session = HibernateUtil.getSessionFactory().openSession();
    	t = session.beginTransaction();
	}
	
	public long create(PostavkaMail p) {

    	Long id = (Long) session.save(p); 
   	 	System.out.println("Dodan student sa IDom "+id); 
   	 	t.commit();
    	return id;

	}
	
	public PostavkaMail vratiPostavke() {
		PostavkaMail postavke = new PostavkaMail();
		
		postavke = (PostavkaMail)session.createCriteria(PostavkaMail.class)
		.addOrder(Order.desc("postavkamail_id"))
		.setMaxResults(1)
		.uniqueResult();
		
		return postavke;
	}

}
