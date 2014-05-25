package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import Entity.EmailLog;
import UtilClasses.HibernateUtil;

public class EmailLogDAO {
	
	Session session;
	Transaction t;

	public EmailLogDAO() {
    	session = HibernateUtil.getSessionFactory().openSession();
    	t = session.beginTransaction();
	}
	
	public long create(EmailLog p) {

    	Long id = (Long) session.save(p); 
   	 	System.out.println("Dodan student sa IDom "+id); 
   	 	t.commit();
    	return id;

	}
	
	public EmailLog vratiLog() {
		
		EmailLog log = new EmailLog();
		
		log = (EmailLog)session.createCriteria(EmailLog.class)
		.addOrder(Order.desc("emaillog_id"))
		.setMaxResults(1)
		.uniqueResult();
		
		return log;
		
	}
	
}
