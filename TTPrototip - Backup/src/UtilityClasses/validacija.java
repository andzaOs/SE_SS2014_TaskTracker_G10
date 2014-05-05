package UtilityClasses;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class validacija {
	
	
	public Boolean praznoPolje(JTextField polje) {
		
		if (polje.getText().equals("")) {
			Border border = BorderFactory.createLineBorder(Color.RED, 1);
			polje.setBorder(border);			
			polje.setToolTipText("Polje mora biti ispunjeno. ");
			return false;
		} else {
			polje.setBackground(Color.WHITE);
			polje.setToolTipText("");
			return true;
		}
		
	}
	
	public Boolean minimalnaDuzina(JTextField polje, int duzina) {
		
		if (polje.getText().length() <= duzina) {
			Border border = BorderFactory.createLineBorder(Color.RED, 1);
			polje.setBorder(border);	
			polje.setToolTipText("Polje mora imati minimalno " + duzina + " znaka.");
			return false;
		} else {
			polje.setBackground(Color.WHITE);
			polje.setToolTipText("");
			return true;
		}
		
	}
	
	public Boolean emailAdresa(JTextField polje) {
		
		final Pattern EMAIL_ADDRESS_REGEX =  Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = EMAIL_ADDRESS_REGEX .matcher(polje.getText());

        if ( matcher.find() ) {
			polje.setBackground(Color.WHITE);
			polje.setToolTipText("");
			return true;
        } else {
			Border border = BorderFactory.createLineBorder(Color.RED, 1);
			polje.setBorder(border);	
			polje.setToolTipText("Email adresa mora biti u validnom formatu.");
			return false;
        }
        
	}
	
	
	public Boolean JMBG(JTextField polje) {
		
		final Pattern EMAIL_ADDRESS_REGEX =  Pattern.compile("^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[012])[0-9]{9}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = EMAIL_ADDRESS_REGEX .matcher(polje.getText());

        if ( matcher.find() ) {
			polje.setBackground(Color.WHITE);
			polje.setToolTipText("");
			return true;
        } else {
			Border border = BorderFactory.createLineBorder(Color.RED, 1);
			polje.setBorder(border);	
			polje.setToolTipText("JMBG mora biti validnom formatu.");
			return false;
        }
        
	}

}
