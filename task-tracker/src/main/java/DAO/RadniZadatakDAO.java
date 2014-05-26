package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import Entity.Klijent;
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
   	 	System.out.println("Dodan student sa IDom "+id); 
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

		radniZadaci = session.createCriteria(RadniZadatak.class).
				addOrder(Order.asc("naziv"))
				.list(); 

		return radniZadaci;
	}

	
		@SuppressWarnings("unchecked")
		public List<RadniZadatak> getByRestrictions(Date pocetniDatum, Klijent klijent)
		{
			List<RadniZadatak> radniZadaci = new ArrayList<RadniZadatak>();

			radniZadaci = session.createCriteria(RadniZadatak.class)
					    .add( Restrictions.and(Restrictions.like( "klijent", klijent)) )
					    .list();

			return radniZadaci;
		}
	 
		@SuppressWarnings("unchecked")
		public List<RadniZadatak> getByKlijent(Klijent klijent)
		{
			List<RadniZadatak> radniZadaci = new ArrayList<RadniZadatak>();

			radniZadaci = session.createCriteria(RadniZadatak.class)
				    .add( Restrictions.like("klijent", klijent) )
				    .list();

			return radniZadaci;
		}
		
		 
			@SuppressWarnings("unchecked")
			public List<RadniZadatak> getByStatusIzvrsenosti(Boolean statusIzvrsenosti)
			{
				List<RadniZadatak> radniZadaci = new ArrayList<RadniZadatak>();

				radniZadaci = session.createCriteria(RadniZadatak.class)
					    .add( Restrictions.like("statusIzvrsenosti", statusIzvrsenosti) )
					    .list();

				return radniZadaci;
			}
		
		
		@SuppressWarnings("unchecked")
		public List<RadniZadatak> getByPeriod(Date pocetniDatum, Date krajnjiDatum)
		{
			List<RadniZadatak> radniZadaci = new ArrayList<RadniZadatak>();

			radniZadaci = session.createCriteria(RadniZadatak.class)
					 	.add( Restrictions.between("datumUnosa", pocetniDatum, krajnjiDatum) )
					    .list();

			return radniZadaci;
		}
		
		
			@SuppressWarnings("unchecked")
			public List<RadniZadatak> getByDatumUnosa(Date datumUnosa)
			{
				List<RadniZadatak> radniZadaci = new ArrayList<RadniZadatak>();

				radniZadaci = session.createCriteria(RadniZadatak.class)
						 	.add( Restrictions.like("datumUnosa", datumUnosa) )
						    .list();

				return radniZadaci;
			}
			
			
			@SuppressWarnings("unchecked")
			public List<RadniZadatak> getByRestrictions1(Date datumUnosa, Date krajnjiDatumIzvrsenja, Klijent klijent)
			{
				List<RadniZadatak> radniZadaci = new ArrayList<RadniZadatak>();

				radniZadaci = session.createCriteria(RadniZadatak.class)
						.add( Restrictions.like("datumUnosa", datumUnosa) )
						.add( Restrictions.and(Restrictions.like( "krajnjiDatumIzvrsenja", krajnjiDatumIzvrsenja)) )
					    .add( Restrictions.and(Restrictions.like( "klijent", klijent)) )
						    .list();

				return radniZadaci;
			}
			
			@SuppressWarnings("unchecked")
			public List<RadniZadatak> getByRestrictions2(Date datumUnosa, Klijent klijent)
			{
				List<RadniZadatak> radniZadaci = new ArrayList<RadniZadatak>();

				radniZadaci = session.createCriteria(RadniZadatak.class)
						.add( Restrictions.like("datumUnosa", datumUnosa) )
					    .add( Restrictions.and(Restrictions.like( "klijent", klijent)) )
						    .list();

				return radniZadaci;
			}
			
			@SuppressWarnings("unchecked")
			public List<RadniZadatak> getByRestrictions3(Date krajnjiDatumIzvrsenja, Klijent klijent)
			{
				List<RadniZadatak> radniZadaci = new ArrayList<RadniZadatak>();

				radniZadaci = session.createCriteria(RadniZadatak.class)
						.add( Restrictions.like("krajnjiDatumIzvrsenja", krajnjiDatumIzvrsenja) )
					    .add( Restrictions.and(Restrictions.like( "klijent", klijent)) )					    .list();

				return radniZadaci;
			}
			
			@SuppressWarnings("unchecked")
			public List<RadniZadatak> getByRestrictions4(Date krajnjiDatumIzvrsenja, Date datumUnosa)
			{
				List<RadniZadatak> radniZadaci = new ArrayList<RadniZadatak>();

				radniZadaci = session.createCriteria(RadniZadatak.class)
						.add( Restrictions.like("krajnjiDatumIzvrsenja", krajnjiDatumIzvrsenja) )
					    .add( Restrictions.and(Restrictions.like( "datumUnosa", datumUnosa)) )	
						    .list();

				return radniZadaci;
			}
			
			@SuppressWarnings("unchecked")
			public List<RadniZadatak> getByKrajnjiDatumIzvrsenja(Date krajnjiDatumIzvrsenja)
			{
				List<RadniZadatak> radniZadaci = new ArrayList<RadniZadatak>();

				radniZadaci = session.createCriteria(RadniZadatak.class)
						.add( Restrictions.like("krajnjiDatumIzvrsenja", krajnjiDatumIzvrsenja) )
						    .list();

				return radniZadaci;
			}
			
			@SuppressWarnings("unchecked")
			public List<RadniZadatak> getByIzvrsenIKlijent(Klijent klijent, Boolean statusIzvrsenosti)
			{
				List<RadniZadatak> radniZadaci = new ArrayList<RadniZadatak>();

				radniZadaci = session.createCriteria(RadniZadatak.class)
						.add( Restrictions.like("klijent", klijent) )
						.add( Restrictions.and(Restrictions.like( "statusIzvrsenosti", statusIzvrsenosti)) )	
						    .list();

				return radniZadaci;
			}


}