package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import Entity.Klijent;
import UtilClasses.HibernateUtil;


public class KlijentDAO implements CRUD<Klijent> {

	Session session;
	Transaction t;

	public KlijentDAO() {
    	session = HibernateUtil.getSessionFactory().openSession();
    	t = session.beginTransaction();
	}

	@Override
    protected void finalize() throws Throwable {
        try{
        	session.close();
        }catch(Throwable t){
            throw t;
        }
        finally {
        	super.finalize();
        }
    }

	public long create(Klijent k) {

    	Long id = (Long) session.save(k); 
   	 	System.out.println("Dodan student sa IDom "+id); 
   	 	t.commit();
    	return id;

	}

	public void update (Klijent k) {
		session.update(k);
		t.commit();
	}

	public void delete (Klijent k) {
		k.setVidljivo(false);
		update(k);
	}

	public Klijent getById(long id) {
		Klijent k = new Klijent();
		k = (Klijent) session.get(Klijent.class, id);
		t.commit();
		return k;
	}

	@SuppressWarnings("unchecked")
	public List<Klijent> getAll() {
		List<Klijent> klijenti = new ArrayList<Klijent>();

		klijenti = session.createCriteria(Klijent.class).
				addOrder(Order.asc("naziv"))
				.list(); 

		return klijenti;
	}

	@SuppressWarnings("unchecked")
	public List<Klijent> getByNaziv(String naziv) {
		List<Klijent> klijenti = new ArrayList<Klijent>();

		klijenti = session.createCriteria(Klijent.class)
			    .add( Restrictions.like("naziv", naziv) )
			    .addOrder(Order.asc("naziv") )
			    .list();

		return klijenti;
	}



}