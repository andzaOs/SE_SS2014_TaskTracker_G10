package UtilClasses;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import DAO.KorisnikDAO;

public class Validacija {
	
	Date datumZaposlenja, datumTrenutni;
	
	
	public boolean jedinstvenEmail(JTextField polje) {
				
		try {
			KorisnikDAO kDAO = new KorisnikDAO();
			if ((kDAO.getByEmail(polje.getText())).equals(null)) return true;
			else {
				Border border = BorderFactory.createLineBorder(Color.RED, 1);
				polje.setBorder(border);			
				polje.setToolTipText("Email nije jedinstven");
				return false;
			}
		}
		catch(NullPointerException ex) {
			return true;
		}

	}
	
	
	public boolean validirajAdresuBrojevi(JTextField polje) {
		
		if(polje.getText().matches("[0-9]{0,}"))
		{
			Border border = BorderFactory.createLineBorder(Color.RED, 1);
			polje.setBorder(border);			
			polje.setToolTipText("Adresa ne može biti samo od brojeva.");
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean validirajString(JTextField polje) {
		
		if(polje.getText().matches("^([a-z]|[A-Z]|[č,ć,š,ž]){3,20}( ){0,1}([a-z]|[A-Z]|[č,ć,š,ž]){0,20}$"))
			{
			return true;
		}
		else {
			Border border = BorderFactory.createLineBorder(Color.RED, 1);
			polje.setBorder(border);			
			polje.setToolTipText("Možete unijeti samo slova!");
			return false;
		}
	}
	
	public boolean validirajDatum( JFormattedTextField polje, Date d ){
		
		 Date trenutni= new Date();
		    if(d.before(trenutni)) return true;
		    else{
		    	Border border = BorderFactory.createLineBorder(Color.RED, 1);
				polje.setBorder(border);			
				polje.setToolTipText("Ne možete unijeti datum u budućnosti!");
				return false;
		    	
		    }
	}
	
	public Boolean jedinstvenJMBG(JTextField polje) {
		try {
			KorisnikDAO kDAO = new KorisnikDAO();
			if ((kDAO.getByJmbg2(polje.getText())).equals(null)) return true;
			else {
				Border border = BorderFactory.createLineBorder(Color.RED, 1);
				polje.setBorder(border);			
				polje.setToolTipText("JMBG nije jedinstven");
				return false;
			}
		}
		catch(NullPointerException ex) {
			return true;
		}
	}
	
	public Boolean jedinstvenJMBGM(JTextField polje, long id) {
		try {
			KorisnikDAO kDAO = new KorisnikDAO();
			KorisnikDAO kDAO2 = new KorisnikDAO();
			
			if ((kDAO.getByJmbg2(polje.getText())).equals(null)) return true;
			else {
				if((kDAO2.getById(id).getJmbg().equals(polje.getText()))) { 
					return true;
					}
				else {
					Border border = BorderFactory.createLineBorder(Color.RED, 1);
					polje.setBorder(border);			
					polje.setToolTipText("JMBG nije jedinstven");
					return false;
				}
			}
		}
		catch(NullPointerException ex) {
			return true;
		}
	}
	
	public Boolean jedinstvenBrLK(JTextField polje) {
		try {
			KorisnikDAO kDAO = new KorisnikDAO();
			if ((kDAO.getByBrLK(polje.getText())).equals(null)) return true;
			else {
				Border border = BorderFactory.createLineBorder(Color.RED, 1);
				polje.setBorder(border);			
				polje.setToolTipText("Broj lične karte nije jedinstven");
				return false;
			}
		}
		catch(NullPointerException ex) {
			return true;
		}
	}
	
	public Boolean jedinstvenBrLKM(JTextField polje, long id) {
		try {
			KorisnikDAO kDAO = new KorisnikDAO();
			KorisnikDAO kDAO2 = new KorisnikDAO();
			
			if ((kDAO.getByBrLK(polje.getText())).equals(null)) return true;
			else {
				if((kDAO2.getById(id).getBr_lk().equals(polje.getText()))) { 
					return true;
					}
				else {
					Border border = BorderFactory.createLineBorder(Color.RED, 1);
					polje.setBorder(border);			
					polje.setToolTipText("Broj lične karte nije jedinstven");
					return false;
				}
			}
		}
		catch(NullPointerException ex) {
			return true;
		}
	}
	
	public Boolean jedinstvenUsername(JTextField polje) {
		try {
			KorisnikDAO kDAO = new KorisnikDAO();
			if ((kDAO.getByUsername(polje.getText())).equals(null)) return true;
			else {
				Border border = BorderFactory.createLineBorder(Color.RED, 1);
				polje.setBorder(border);			
				polje.setToolTipText("Korisnicko ime nije jedinstveno");
				return false;
			}
		}
		catch(NullPointerException ex) {
			return true;
		}
	}
	
	public Boolean jedinstvenUsernameM(JTextField polje, long id) {
		try {
			KorisnikDAO kDAO = new KorisnikDAO();
			KorisnikDAO kDAO2 = new KorisnikDAO();
			if ((kDAO.getByUsername(polje.getText())).equals(null)) return true;
			else {
				if((kDAO2.getById(id).getKorisnicko_ime()).equals(polje.getText())) {
					return true;
				}
				else {
					Border border = BorderFactory.createLineBorder(Color.RED, 1);
					polje.setBorder(border);			
					polje.setToolTipText("Korisnicko ime nije jedinstveno");
					return false;
				}
			}
		}
		catch(NullPointerException ex) {
			return true;
		}
	}

	public Boolean minimalnaDuzina(JTextField polje, int duzina) {
		
		if (polje.getText().equals("") || polje.getText().length() < duzina) {
			Border border = BorderFactory.createLineBorder(Color.RED, 1);
			polje.setBorder(border);			
			polje.setToolTipText("Polje mora biti ispunjeno. ");
			return false;
		} else {
			Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
			polje.setBorder(border);
			polje.setToolTipText(null);
			return true;
		}
		
	}
	
	
	
	public Boolean emailAdresa(JTextField polje) {
		
		final Pattern EMAIL_ADDRESS_REGEX =  Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = EMAIL_ADDRESS_REGEX .matcher(polje.getText());

        if ( matcher.find() ) {
			Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
			polje.setBorder(border);
			polje.setToolTipText(null);
			return true;
        } else {
			Border border = BorderFactory.createLineBorder(Color.RED, 1);
			polje.setBorder(border);	
			polje.setToolTipText("Email adresa mora biti u validnom formatu.");
			return false;
        }
        
	}
	
	
	public Boolean JMBG(JTextField polje) {
		
		Boolean ispravno;
        List<Integer> JMBG_N = new ArrayList<Integer>();
		
		for (char c : polje.getText().toCharArray()) 
			JMBG_N.add(Character.getNumericValue(c));
		
		if(polje.getText().length() != 13)
			ispravno=false;
		
		else 
		{
			double eval = 0;
			
			for(int i = 0; i < 6; i++)
				eval += (7 - i) * (JMBG_N.get(i) + JMBG_N.get(i + 6));
			
			ispravno=JMBG_N.get(12) == 11 - eval % 11;
		}
        
        if ( ispravno ) {
			Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
			polje.setBorder(border);
			polje.setToolTipText(null);
			return true;
        } else {
			Border border = BorderFactory.createLineBorder(Color.RED, 1);
			polje.setBorder(border);	
			polje.setToolTipText("JMBG mora biti validnom formatu.");
			return false;
        }
        
	}
	
	public Boolean brojTelefona(JTextField polje)
	{
		 String regex = "^\\+?[0-9. ()-]{10,25}$";
		 Pattern pattern = Pattern.compile(regex);
		 Matcher matcher = pattern.matcher(polje.getText());
		 if (matcher.matches()) {
			 Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
				polje.setBorder(border);
				polje.setToolTipText(null);
				return true;
		 } else {
			 Border border = BorderFactory.createLineBorder(Color.RED, 1);
				polje.setBorder(border);	
				polje.setToolTipText("Broj telefona mora biti sljedećeg formata: xxx-xxxxxx");
				return false;
		 }
		
	}
	
	public Boolean datum(JTextField polje) 
	{
		final Pattern DATUM_ZAPOSLENJA_REGEX =  Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = DATUM_ZAPOSLENJA_REGEX .matcher(polje.getText());
        if(matcher.matches()){
        	try 
        	{
				datumZaposlenja = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH).parse(polje.getText());
				datumTrenutni = new Date();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       	 matcher.reset();
        
       	 if(matcher.find()){
        
                    String day = matcher.group(1);
       	     String month = matcher.group(2);
       	     int year = Integer.parseInt(matcher.group(3));
        
       	     if (day.equals("31") &&  (month.equals("4") || month .equals("6") || month.equals("9") ||
                month.equals("11") || month.equals("04") || month .equals("06") ||
                month.equals("09"))) 
       	     {
       			return false; // only 1,3,5,7,8,10,12 has 31 days
       	     }
       	     else if (month.equals("2") || month.equals("02")) 
       	     {
                         //leap year
       	    	 if(year % 4==0)
       		  	{
       			  if(day.equals("30") || day.equals("31"))
       			  {
       				  return false;
       			  }
       			  else
       			  {
       				return true;
       			  }
       		  	}
       		  	else
       		  	{
       		        if(day.equals("29")||day.equals("30")||day.equals("31"))
       		        {
       				  return false;
       		         }
       		        else
       		        {
       		        	return true;
       		        }
       		  	}
       	      }
       	     else
       	     {				 
       	    	 return true;				 
       	      }

       	   }
       	 else
       	   {
           	     return false;
       	   }
        }
        else
        {
        	return false;
        }	
	}
	
	public Boolean tipKorisnika(JTextField polje) 
	{

		 if (polje.getText().equals("računovodstvo")|| polje.getText().equals("serviseri")) {
			 Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
				polje.setBorder(border);
				polje.setToolTipText(null);
				return true;
		 } else {
			 Border border = BorderFactory.createLineBorder(Color.RED, 1);
				polje.setBorder(border);	
				polje.setToolTipText("Broj telefona mora biti sljedećeg formata: xxx-xxxxxx");
				return false;
		 }
		
	}



	public Boolean praznoPoljeBolean(JTextField polje) {
		
		if (polje.getText().equals("")) {
			Border border = BorderFactory.createLineBorder(Color.RED, 1);
			polje.setBorder(border);			
			polje.setToolTipText("Polje mora biti ispunjeno. ");
			return false;
		} else {
			Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
			polje.setBorder(border);
			polje.setToolTipText(null);
			return true;
		}
	}



	public Boolean emailAdresaBolean(JTextField polje) {
		final Pattern EMAIL_ADDRESS_REGEX =  Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = EMAIL_ADDRESS_REGEX .matcher(polje.getText());

        if ( matcher.find() ) {
			Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
			polje.setBorder(border);
			polje.setToolTipText(null);
			return true;
        } else {
			Border border = BorderFactory.createLineBorder(Color.RED, 1);
			polje.setBorder(border);	
			polje.setToolTipText("Email adresa mora biti u validnom formatu.");
			return false;
        }
	}
	
	public Boolean brojLicneKarte(JTextField polje) {
		final Pattern BROJ_LICNE_KARTE_REGEX =  Pattern.compile("[0-9]{2}[A-Z]{3}[0-9]{4}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = BROJ_LICNE_KARTE_REGEX .matcher(polje.getText());

        if ( matcher.find() ) {
			Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
			polje.setBorder(border);
			polje.setToolTipText(null);
			return true;
        } else {
			Border border = BorderFactory.createLineBorder(Color.RED, 1);
			polje.setBorder(border);	
			polje.setToolTipText("Broj lične karte mora biti sljedećeg formata: 2 broja, 3 slova i na kraju 4 broja.");
			return false;
        }
	}
	
	public Boolean PoredjenjeDatuma(Date datum1, Date datum2, JDatePickerImpl datePicker)
	{
		if(datum1.after(datum2) || datum1.equals(datum2))
			{
			datePicker.setBorder(null);	
			return true;
			}
		else
			{
			Border etchedBorder = new EtchedBorder(Color.RED, Color.RED);
			datePicker.setBorder(etchedBorder);	
			datePicker.setToolTipText("Datum izvršenja ne smije biti manji od datuma unosa radnog zadatka.");
			return false;
			}
	}

	}


