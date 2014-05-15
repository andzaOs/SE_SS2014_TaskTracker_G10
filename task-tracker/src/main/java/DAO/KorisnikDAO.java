package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import Entity.Korisnik;
import UtilClasses.HibernateUtil;


public class KorisnikDAO implements CRUD<Korisnik> {

	Session session;
	Transaction t;

	public KorisnikDAO() {
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

	public long create(Korisnik k) {

    	Long id = (Long) session.save(k); 
   	 	System.out.println("Dodan student sa IDom "+id); 
   	 	t.commit();
    	return id;

	}

	public void update (Korisnik k) {
		session.update(k);
		t.commit();
	}

	public void delete (Korisnik k) {
		k.setVidljivo(false);
		update(k);
	}

	public Korisnik getById(long id) {
		Korisnik k = new Korisnik();
		k = (Korisnik) session.get(Korisnik.class, id);
		t.commit();
		return k;
	}

	@SuppressWarnings("unchecked")
	public List<Korisnik> getAll() {
		List<Korisnik> korisnici = new ArrayList<Korisnik>();

		korisnici = session.createCriteria(Korisnik.class).
				addOrder(Order.asc("prezime"))
				.list(); 

		return korisnici;
	}

	@SuppressWarnings("unchecked")
	public List<Korisnik> getByNaziv(String naziv) {
		List<Korisnik> korisnici = new ArrayList<Korisnik>();

		korisnici = session.createCriteria(Korisnik.class)
			    .add( Restrictions.like("naziv", naziv) )
			    .addOrder(Order.asc("naziv") )
			    .list();

		return korisnici;
	}



}