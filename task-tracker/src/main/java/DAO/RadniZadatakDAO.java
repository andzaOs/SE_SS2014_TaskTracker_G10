package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import Entity.RadniZadatak;
import UtilClasses.HibernateUtil;


public class RadniZadatakDAO implements CRUD<RadniZadatak> {
	
	Session session;
	Transaction t;
	
	public RadniZadatakDAO() {
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
	
	public long create(RadniZadatak k) {
			
    	Long id = (Long) session.save(k); 
   	 	System.out.println("Dodan zadatak sa IDom "+id); 
   	 	t.commit();
    	return id;
		
	}
	
	public void update (RadniZadatak k) {
		session.update(k);
		t.commit();
	}
	
	public void delete (RadniZadatak k) {
		k.setVidljivo(false);
		update(k);
	}
	
	public RadniZadatak getById(long id) {
		RadniZadatak k = new RadniZadatak();
		k = (RadniZadatak) session.get(RadniZadatak.class, id);
		t.commit();
		return k;
	}
	
	@SuppressWarnings("unchecked")
	public List<RadniZadatak> getAll() {
		List<RadniZadatak> radniZadaci = new ArrayList<RadniZadatak>();
		
		radniZadaci = session.createCriteria(RadniZadatak.class).list(); 
		
		return radniZadaci;
	}
	
	@SuppressWarnings("unchecked")
	public List<RadniZadatak> getByNaziv(String naziv) {
		List<RadniZadatak> radniZadaci = new ArrayList<RadniZadatak>();
		
		radniZadaci = session.createCriteria(RadniZadatak.class)
			    .add( Restrictions.like("naziv", naziv) )
			    .addOrder(Order.asc("naziv") )
			    .list();
		
		return radniZadaci;
	}
	
	

}
