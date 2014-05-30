package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import Entity.Korisnik;
import Entity.RadniZadatak;
import Entity.RasporedjeniZadatak;
import UtilClasses.HibernateUtil;


public class RasporedjeniZadatakDAO implements CRUD<RasporedjeniZadatak> {

	Session session;
	Transaction t;

	public RasporedjeniZadatakDAO() {
    	session = HibernateUtil.getSessionFactory().openSession();
    	t = session.beginTransaction();
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

		rasporedjeniZadaci = session.createCriteria(RasporedjeniZadatak.class).list(); 

		return rasporedjeniZadaci;
	}


	
		@SuppressWarnings("unchecked")
		public List<RasporedjeniZadatak> getByServiser(Korisnik serviser) {
			List<RasporedjeniZadatak> rasporedjeniZadaci = new ArrayList<RasporedjeniZadatak>();

			rasporedjeniZadaci = session.createCriteria(RasporedjeniZadatak.class)
				    .add( Restrictions.like("izvrsilac", serviser) )
				    .list();

			return rasporedjeniZadaci;
		}
		
		
			@SuppressWarnings("unchecked")
			public List<RasporedjeniZadatak> getByRadniZadatak(RadniZadatak  radniZadatak) {
				List<RasporedjeniZadatak> rasporedjeniZadaci = new ArrayList<RasporedjeniZadatak>();

				rasporedjeniZadaci = session.createCriteria(RasporedjeniZadatak.class)
					    .add( Restrictions.like("zadatak", radniZadatak) )
					    .list();

				return rasporedjeniZadaci;
			}
			
			
					@SuppressWarnings("unchecked")
					public List<RasporedjeniZadatak> getByDatumPrihvatanja(Date datumPrihvatanja) {
						List<RasporedjeniZadatak> rasporedjeniZadaci = new ArrayList<RasporedjeniZadatak>();

						rasporedjeniZadaci = session.createCriteria(RasporedjeniZadatak.class)
							    .add( Restrictions.like("datumPrihvatanja", datumPrihvatanja) )
							    .list();

						return rasporedjeniZadaci;
					}

			
					@SuppressWarnings("unchecked")
					public List<RasporedjeniZadatak> getByStatus(Boolean statusPrihvacenosti) {
						List<RasporedjeniZadatak> rasporedjeniZadaci = new ArrayList<RasporedjeniZadatak>();

						rasporedjeniZadaci = session.createCriteria(RasporedjeniZadatak.class)
							    .add( Restrictions.like("statusPrihvacenosti", statusPrihvacenosti) )
							    .list();

						return rasporedjeniZadaci;
					}

					
					@SuppressWarnings("unchecked")
					public List<RasporedjeniZadatak> getByStatusIDatum(Date datumPrihvatanja, Boolean statusPrihvacenosti) {
						List<RasporedjeniZadatak> rasporedjeniZadaci = new ArrayList<RasporedjeniZadatak>();

						rasporedjeniZadaci = session.createCriteria(RasporedjeniZadatak.class)
							    .add( Restrictions.like("statusPrihvacenosti", statusPrihvacenosti) )
							    .add( Restrictions.and(Restrictions.like( "datumPrihvatanja", datumPrihvatanja)) )
							    .list();

						return rasporedjeniZadaci;
					}



}