package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import Entity.VrstaUsluge;
import UtilClasses.HibernateUtil;


public class VrstaUslugeDAO implements CRUD<VrstaUsluge> {

	Session session;
	Transaction t;

	public VrstaUslugeDAO() {
    	session = HibernateUtil.getSessionFactory().openSession();
    	t = session.beginTransaction();
	}

	

	public long create(VrstaUsluge k) {

    	Long id = (Long) session.save(k); 
   	 	System.out.println("Dodan student sa IDom "+id); 
   	 	t.commit();
    	return id;

	}

	public void update (VrstaUsluge k) {
		session.update(k);
		t.commit();
	}

	public void delete (VrstaUsluge k) {
		k.setVidljivo(false);
		update(k);
	}

	public VrstaUsluge getById(long id) {
		VrstaUsluge k = new VrstaUsluge();
		k = (VrstaUsluge) session.get(VrstaUsluge.class, id);
		t.commit();
		return k;
	}

	@SuppressWarnings("unchecked")
	public List<VrstaUsluge> getAll() {
		List<VrstaUsluge> vrsteUsluga = new ArrayList<VrstaUsluge>();

		vrsteUsluga = session.createCriteria(VrstaUsluge.class).
				addOrder(Order.asc("naziv"))
				.list(); 

		return vrsteUsluga;
	}

	@SuppressWarnings("unchecked")
	public List<VrstaUsluge> getByNaziv(String naziv) {
		List<VrstaUsluge> vrsteUsluga = new ArrayList<VrstaUsluge>();

		vrsteUsluga = session.createCriteria(VrstaUsluge.class)
			    .add( Restrictions.like("naziv", naziv) )
			    .addOrder(Order.asc("naziv") )
			    .list();

		return vrsteUsluga;
	}



}