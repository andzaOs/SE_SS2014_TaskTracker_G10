package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import Entity.ObavljeniPosao;
import Entity.RasporedjeniZadatak;
import Entity.VrstaUsluge;
import UtilClasses.HibernateUtil;


public class ObavljeniPosaoDAO implements CRUD<ObavljeniPosao> {

	Session session;
	Transaction t;

	public ObavljeniPosaoDAO() {
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

	public long create(ObavljeniPosao k) {

    	Long id = (Long) session.save(k); 
   	 	System.out.println("Dodan student sa IDom "+id); 
   	 	t.commit();
    	return id;

	}

	public void update (ObavljeniPosao k) {
		session.update(k);
		t.commit();
	}

	public void delete (ObavljeniPosao k) {
		k.setVidljivo(false);
		update(k);
	}

	public ObavljeniPosao getById(long id) {
		ObavljeniPosao k = new ObavljeniPosao();
		k = (ObavljeniPosao) session.get(ObavljeniPosao.class, id);
		t.commit();
		return k;
	}

	@SuppressWarnings("unchecked")
	public List<ObavljeniPosao> getAll() {
		List<ObavljeniPosao> posao = new ArrayList<ObavljeniPosao>();

		posao = session.createCriteria(ObavljeniPosao.class)
				.list(); 

		return posao;
	}

	@SuppressWarnings("unchecked")
	public List<ObavljeniPosao> getByVrstaUsluge(VrstaUsluge vrstaUsluge) {
		List<ObavljeniPosao> posao = new ArrayList<ObavljeniPosao>();

		posao = session.createCriteria(ObavljeniPosao.class)
			    .add( Restrictions.like("vrstaUsluge", vrstaUsluge) )
			    .list();

		return posao;
	}
	
		@SuppressWarnings("unchecked")
		public List<ObavljeniPosao> getByRasporedjeniZadatak(RasporedjeniZadatak pripadajuciZadatak) {
			List<ObavljeniPosao> posao = new ArrayList<ObavljeniPosao>();

			posao = session.createCriteria(ObavljeniPosao.class)
				    .add( Restrictions.like("pripadajuciZadatak", pripadajuciZadatak) )
				    .list();

			return posao;
		}
	    
		@SuppressWarnings("unchecked")
		public List<ObavljeniPosao> getByDatumObavljanja(Date datumObavljanja) {
			List<ObavljeniPosao> posao = new ArrayList<ObavljeniPosao>();

			posao = session.createCriteria(ObavljeniPosao.class)
				    .add( Restrictions.like("datumObavljanja", datumObavljanja) )
				    .list();

			return posao;
		}
		
			@SuppressWarnings("unchecked")
			public List<ObavljeniPosao> getByPeriod(Date pocetniDatum, Date krajnjiDatum)
			{
				List<ObavljeniPosao> obavljeniPosao = new ArrayList<ObavljeniPosao>();

				obavljeniPosao = session.createCriteria(ObavljeniPosao.class)
						 	.add( Restrictions.between("datumUnosa", pocetniDatum, krajnjiDatum) )
						    .list();

				return obavljeniPosao;
			}
			
			
			@SuppressWarnings("unchecked")
			public List<ObavljeniPosao> getByRestrictions(Date pocetniDatum, Date krajnjiDatum, VrstaUsluge vrstaUsluge)
			{
				List<ObavljeniPosao> obavljeniPosao = new ArrayList<ObavljeniPosao>();

				obavljeniPosao = session.createCriteria(ObavljeniPosao.class)
						 	.add( Restrictions.between("datumUnosa", pocetniDatum, krajnjiDatum) )
						 	.add( Restrictions.and(Restrictions.like( "vrstaUsluge", vrstaUsluge)) )
						    .list();

				return obavljeniPosao;
			}
	


}