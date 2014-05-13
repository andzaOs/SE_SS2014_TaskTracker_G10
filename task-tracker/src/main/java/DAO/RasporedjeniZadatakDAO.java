package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import Entity.RasporedjeniZadatak;
import UtilClasses.HibernateUtil;


public class RasporedjeniZadatakDAO implements CRUD<RasporedjeniZadatak> {

	Session session;
	Transaction t;

	public RasporedjeniZadatakDAO() {
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
    }

	public long create(RasporedjeniZadatak k) {

    	Long id = (Long) session.save(k); 
   	 	System.out.println("Dodan student sa IDom "+id); 
   	 	t.commit();
    	return id;

	}

	public void update (RasporedjeniZadatak k) {
		session.update(k);
		t.commit();
	}

	public void delete (RasporedjeniZadatak k) {
		k.setVidljivo(false);
		update(k);
	}

	public RasporedjeniZadatak getById(long id) {
		RasporedjeniZadatak k = new RasporedjeniZadatak();
		k = (RasporedjeniZadatak) session.get(RasporedjeniZadatak.class, id);
		t.commit();
		return k;
	}

	@SuppressWarnings("unchecked")
	public List<RasporedjeniZadatak> getAll() {
		List<RasporedjeniZadatak> rasporedjeniZadaci = new ArrayList<RasporedjeniZadatak>();

		rasporedjeniZadaci = session.createCriteria(RasporedjeniZadatak.class).
				addOrder(Order.asc("naziv"))
				.list(); 

		return rasporedjeniZadaci;
	}

	@SuppressWarnings("unchecked")
	public List<RasporedjeniZadatak> getByNaziv(String naziv) {
		List<RasporedjeniZadatak> rasporedjeniZadaci = new ArrayList<RasporedjeniZadatak>();

		rasporedjeniZadaci = session.createCriteria(RasporedjeniZadatak.class)
			    .add( Restrictions.like("naziv", naziv) )
			    .addOrder(Order.asc("naziv") )
			    .list();

		return rasporedjeniZadaci;
	}



}