package UtilityClasses;

import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class validacija {
	
	private  boolean uspjesna=true;
	
	
	public  boolean isUspjesna() {
		return uspjesna;
	}



	public void minimalnaDuzina(JTextField polje, int duzina) {
		
		if (polje.getText().equals("") || polje.getText().length() < duzina) {
			Border border = BorderFactory.createLineBorder(Color.RED, 1);
			polje.setBorder(border);			
			polje.setToolTipText("Polje mora biti ispunjeno. ");
			uspjesna=false;
		} else {
			Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
			polje.setBorder(border);
			polje.setToolTipText(null);
		}
		
	}
	
	
	//Comment test test
	
//	public void minimalnaDuzina(JTextField polje, int duzina) {
//		
//		if (polje.getText().length() <= duzina) {
//			Border border = BorderFactory.createLineBorder(Color.RED, 1);
//			polje.setBorder(border);	
//			polje.setToolTipText("Polje mora imati minimalno " + duzina + " znaka.");
//		} else {
//			Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
//			polje.setBorder(border);
//			polje.setToolTipText(null);
//		}
//		
//	}
	
	public void emailAdresa(JTextField polje) {
		
		final Pattern EMAIL_ADDRESS_REGEX =  Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = EMAIL_ADDRESS_REGEX .matcher(polje.getText());

        if ( matcher.find() ) {
			Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
			polje.setBorder(border);
			polje.setToolTipText(null);
        } else {
			Border border = BorderFactory.createLineBorder(Color.RED, 1);
			polje.setBorder(border);	
			polje.setToolTipText("Email adresa mora biti u validnom formatu.");
			uspjesna=false;
        }
        
	}
	
	
	public void JMBG(JTextField polje) {
		
		final Pattern EMAIL_ADDRESS_REGEX =  Pattern.compile("^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[012])[0-9]{9}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = EMAIL_ADDRESS_REGEX .matcher(polje.getText());

        if ( matcher.find() ) {
			Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
			polje.setBorder(border);
			polje.setToolTipText(null);
        } else {
			Border border = BorderFactory.createLineBorder(Color.RED, 1);
			polje.setBorder(border);	
			polje.setToolTipText("JMBG mora biti validnom formatu.");
			uspjesna=false;
        }
        
	}
	
	public void brojTelefona(JTextField polje)
	{
		 String regex = "^\\+?[0-9. ()-]{10,25}$";
		 Pattern pattern = Pattern.compile(regex);
		 Matcher matcher = pattern.matcher(polje.getText());
		 if (matcher.matches()) {
			 Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
				polje.setBorder(border);
				polje.setToolTipText(null);
		 } else {
			 Border border = BorderFactory.createLineBorder(Color.RED, 1);
				polje.setBorder(border);	
				polje.setToolTipText("Broj telefona mora biti sljedećeg formata: xxx-xxxxxx");
				uspjesna=false;
		 }
		
	}
	
	public void datum(JFormattedTextField polje) 
	{
		java.util.Date date = (java.util.Date)polje.getValue(); 
        long millisInDay = 60 * 60 * 24 * 1000;
        long currentTime = new Date().getTime();
        long dateOnly = (currentTime/millisInDay)*millisInDay;
        Date clearDate = new Date(dateOnly);
        
		 if (clearDate.after(date)) {
			 Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
				polje.setBorder(border);
				polje.setToolTipText(null);
		 } else {
			 Border border = BorderFactory.createLineBorder(Color.RED, 1);
				polje.setBorder(border);	
				polje.setToolTipText("Datum mora biti ispravnog formata");
				uspjesna=false;
		 }
	}
	
	public void tipKorisnika(JTextField polje) 
	{

		 if (polje.getText()=="računovodstvo" || polje.getText()=="serviser") {
			 Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
				polje.setBorder(border);
				polje.setToolTipText(null);
		 } else {
			 Border border = BorderFactory.createLineBorder(Color.RED, 1);
				polje.setBorder(border);	
				polje.setToolTipText("Broj telefona mora biti sljedećeg formata: xxx-xxxxxx");
				uspjesna=false;
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
			uspjesna=false;
			return false;
        }
	}

	}


