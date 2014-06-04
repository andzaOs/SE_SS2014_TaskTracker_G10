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
	public Korisnik getByUsername(String korisnicko_ime) {
		Korisnik korisnik = new Korisnik();
		korisnik = (Korisnik) session.createCriteria(Korisnik.class)
			    .add( Restrictions.like("korisnicko_ime", korisnicko_ime) )
			    .uniqueResult();

		return korisnik;
	}
	@SuppressWarnings("unchecked")
	public List<Korisnik> getByNaziv(String ime, String prezime) {
		List<Korisnik> korisnici = new ArrayList<Korisnik>();

		korisnici = session.createCriteria(Korisnik.class)
			    .add( Restrictions.like("ime", ime) )
			    .add( Restrictions.and(Restrictions.like( "prezime", prezime)))
			    .addOrder(Order.asc("prezime") )
			    .list();

		return korisnici;
	}
	
	@SuppressWarnings("unchecked")
	public Korisnik getByJmbg2(String jmbg) {
		Korisnik korisnik = new Korisnik();
		korisnik = (Korisnik) session.createCriteria(Korisnik.class)
			    .add( Restrictions.like("jmbg", jmbg) )
			    .uniqueResult();

		return korisnik;
	}
			

	@SuppressWarnings("unchecked")
	public List<Korisnik> getByJmbg(String jmbg) {
		List<Korisnik> korisnici = new ArrayList<Korisnik>();

		korisnici = session.createCriteria(Korisnik.class)
			    .add( Restrictions.like("jmbg", jmbg) )
			    .addOrder(Order.asc("prezime") )
			    .list();

		return korisnici;
	}
			@SuppressWarnings("unchecked")
			public List<Korisnik> getByIme(String ime) {
				List<Korisnik> korisnici = new ArrayList<Korisnik>();

				korisnici = session.createCriteria(Korisnik.class)
					    .add( Restrictions.like("ime", ime) )
					    .addOrder(Order.asc("prezime") )
					    .list();

				return korisnici;
			}
			
			@SuppressWarnings("unchecked")
			public List<Korisnik> getByPrezime(String prezime) {
				List<Korisnik> korisnici = new ArrayList<Korisnik>();

				korisnici = session.createCriteria(Korisnik.class)
					    .add( Restrictions.like("prezime", prezime) )
					    .addOrder(Order.asc("prezime") )
					    .list();

				return korisnici;
			}
			
		@SuppressWarnings("unchecked")
		public List<Korisnik> getByRestrictions(String ime, String prezime, String jmbg) 
		{
			
			List<Korisnik> korisnici = new ArrayList<Korisnik>();

			korisnici = session.createCriteria(Korisnik.class)
				    .add( Restrictions.like("ime", ime) )
				    .add( Restrictions.and(Restrictions.like( "prezime", prezime)))
					.add( Restrictions.and( Restrictions.like( "jmbg", jmbg)))
					.addOrder(Order.asc("prezime") )
				    .list();
			return korisnici;
		}

		@SuppressWarnings("unchecked")
		public List<Korisnik> getByImeIJmbg(String ime, String jmbg) 
		{
			
			List<Korisnik> korisnici = new ArrayList<Korisnik>();

			korisnici = session.createCriteria(Korisnik.class)
				    .add( Restrictions.like("ime", ime) )
					.add( Restrictions.and( Restrictions.like( "jmbg", jmbg)))
					.addOrder(Order.asc("prezime") )
				    .list();
			return korisnici;
		}
		
		public Korisnik getByEmail(String email) {
			Korisnik korisnik = new Korisnik();
			korisnik = (Korisnik) session.createCriteria(Korisnik.class)
				    .add( Restrictions.like("email", email) )
				    .uniqueResult();

			return korisnik;
		}

}