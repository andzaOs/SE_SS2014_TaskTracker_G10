package ba.unsa.etf.si.tim10.task_tracker;

import java.util.ArrayList;
import java.util.List;

import DAO.KlijentDAO;
import Entity.Klijent;
 
public class App 
{
    public static void main( String[] args )
    {
    	
    	 KlijentDAO kDAO = new KlijentDAO();
    	 List<Klijent> klijenti = new ArrayList<Klijent>();

       	 klijenti = kDAO.getByNaziv("Bosnalijek");

       	 for(int i=0; i<klijenti.size(); i++){
       		 System.out.println( klijenti.get(i).getNaziv() + "\n" );
       	 }
       	 
    }
    
    
}

