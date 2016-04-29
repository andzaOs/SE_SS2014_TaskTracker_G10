package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import Entity.TipKorisnika;
import UtilClasses.HibernateUtil;


public class TipKorisnikaDAO implements CRUD<TipKorisnika> {

	Session session;
	Transaction t;

	public TipKorisnikaDAO() {
    	session = HibernateUtil.getSessionFactory().openSession();
    	t = session.beginTransaction();
	}



	public long create(TipKorisnika k) {

    	Long id = (Long) session.save(k); 
   	 	System.out.println("Dodan student sa IDom "+id); 
   	 	t.commit();
    	return id;

	}

	public void update (TipKorisnika k) {
		session.update(k);
		t.commit();
	}

	public void delete (TipKorisnika k) {
		k.setVidljivo(false);
		update(k);
	}

	public TipKorisnika getById(long id) {
		TipKorisnika k = new TipKorisnika();
		k = (TipKorisnika) session.get(TipKorisnika.class, id);
		t.commit();
		return k;
	}

	@SuppressWarnings("unchecked")
	public List<TipKorisnika> getAll() {
		List<TipKorisnika> tipovi = new ArrayList<TipKorisnika>();

		tipovi = session.createCriteria(TipKorisnika.class).
				addOrder(Order.asc("naziv"))
				.list(); 

		return tipovi;
	}

	@SuppressWarnings("unchecked")
	public List<TipKorisnika> getByNaziv(String naziv) {
		List<TipKorisnika> tipovi = new ArrayList<TipKorisnika>();

		tipovi = session.createCriteria(TipKorisnika.class)
			    .add( Restrictions.like("naziv", naziv) )
			    .addOrder(Order.asc("naziv") )
			    .list();

		return tipovi;
	}



}