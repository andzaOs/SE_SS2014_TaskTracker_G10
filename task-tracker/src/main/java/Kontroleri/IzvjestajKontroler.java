package Kontroleri;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import DAO.KlijentDAO;
import DAO.KorisnikDAO;
import DAO.TipKorisnikaDAO;
import DAO.VrstaUslugeDAO;
import Entity.Klijent;
import Entity.Korisnik;
import Entity.TipKorisnika;
import Entity.VrstaUsluge;
import Izvjestaj.Izvjestaj;
import Izvjestaj.stavkaIzvjestajaKlijent;
import Izvjestaj.stavkaIzvjestajaRadnik;


import Izvjestaj.stavkaIzvjestajaSat;
import Izvjestaj.stavkaIzvjestajaUsluga;
import RacunovodstvoGUI.ModifikovanjeKlijentaGUI;
import RacunovodstvoGUI.PrikazIzvjestajaDetaljniGUI;
import RacunovodstvoGUI.PrikazIzvjestajaKlijentGUI;
import RacunovodstvoGUI.PrikazIzvjestajaRadnikGUI;
import RacunovodstvoGUI.PrikazIzvjestajaSumarniGUI;
import RacunovodstvoGUI.PrikazIzvjestajaUslugaGUI;

import com.itextpdf.text.Element; 
import com.itextpdf.text.Phrase; 
import com.itextpdf.text.pdf.PdfPCell; 
import com.itextpdf.text.pdf.PdfPTable; 

public class IzvjestajKontroler {
	
	private String formatirajDatum(String d){
		String[] split = d.split("-");
		return split[2] + "." + split[1] + "." + split[0] + ".";
	}
	
	public void napuniTabeluRadnik(DefaultTableModel t, Korisnik k, Date sqld1, Date sqld2) throws Exception {
		try {
			Korisnik korisnik = new Korisnik();
	    	KorisnikDAO kDAO = new KorisnikDAO();
	    	korisnik = kDAO.getById(k.getKorisnik_id());		
	    	
	    	Izvjestaj iz = new Izvjestaj();
	    	List<stavkaIzvjestajaRadnik> red = iz.vratiIzvjestajPremaRadniku(korisnik, sqld1, sqld2);
	    	
	    	int ukupno = 0;
	        for(int i=0; i<red.size(); i++)
	        {
	        	Object[] o = { red.get(i).getVrstaUsluge(), red.get(i).getKlijent(), formatirajDatum(red.get(i).getDatum()), red.get(i).getBrojSati() }; 
	        	t.addRow(o);
	        	ukupno += Integer.parseInt(red.get(i).getBrojSati());
	        }
	        Object[] o = { "", "", "Ukupno: ", String.valueOf(ukupno) };
	        t.addRow(o);
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	public void napraviPdfRadnik(Korisnik k, Date sqld1, Date sqld2 ) throws Exception {
		
		Random rand = new Random();
		int x = rand.nextInt(1000);
		
		final String FILE = "c:\\izvjestaj\\izv_" + k + "_" + sqld1 + "_" + sqld2 + "_" + x +".pdf"; 
	    final Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD); 
	    final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD); 
		
	    try { 
	        Document document = new Document(); 
	        PdfWriter.getInstance(document, new FileOutputStream(FILE)); 
	        document.open(); 
	        
	        //addMetaData(document); 
	        document.addTitle("TaskTracker - Izvjestaj"); 
	        	        
	        Paragraph preface = new Paragraph(); 
	        preface.add(new Paragraph(" ")); 
	        	          
	        preface.add(new Paragraph("Izvještaj za radnika: "+k, catFont)); 
	        preface.add(new Paragraph("Za period od: " + sqld1.getDate()
	        		+ "." + (sqld1.getMonth()+1) + ".20" + (sqld1.getYear()-100) + ". do: " 
	        		+ sqld2.getDate() + "." + (sqld2.getMonth()+1) + ".20" + (sqld2.getYear()-100), smallBold)); 
	        preface.add(new Paragraph(" ")); 
	        document.add(preface); 
	        
	        PdfPTable table = new PdfPTable(4); 
	      
	        PdfPCell c1 = new PdfPCell(new Phrase("Vrsta usluge")); 
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
	        table.addCell(c1); 
	      
	        c1 = new PdfPCell(new Phrase("Klijent")); 
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
	        table.addCell(c1); 
	      
	        c1 = new PdfPCell(new Phrase("Datum")); 
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
	        table.addCell(c1); 
	          
	        c1 = new PdfPCell(new Phrase("Broj sati")); 
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
	        table.addCell(c1); 
	          
	        table.setHeaderRows(1); 
	        
			Korisnik korisnik = new Korisnik();
	    	KorisnikDAO kDAO = new KorisnikDAO();
	    	korisnik = kDAO.getById(k.getKorisnik_id());		
	    	
	    	Izvjestaj iz = new Izvjestaj();
	    	List<stavkaIzvjestajaRadnik> red = iz.vratiIzvjestajPremaRadniku(korisnik, sqld1, sqld2);
	    	
	    	int ukupno = 0;
	        for(int i=0; i<red.size(); i++)
	        {
	        	table.addCell(red.get(i).getVrstaUsluge());
	        	table.addCell(red.get(i).getKlijent());
	        	table.addCell(formatirajDatum(red.get(i).getDatum()));
	        	table.addCell(red.get(i).getBrojSati());      
	        	ukupno += Integer.parseInt(red.get(i).getBrojSati());
	        }

        	table.addCell("");
        	table.addCell("");
        	table.addCell("Ukupno: ");
        	table.addCell(String.valueOf(ukupno));
	        
	        document.add(table); 

	        document.close(); 
	          
	        if (Desktop.isDesktopSupported()) { 
	              try { 
	                  File myFile = new File(FILE); 
	                  Desktop.getDesktop().open(myFile); 
	              } catch (IOException ex) { 
	                  // no application registered for PDFs 
	              } 
	          } 
	      } catch (Exception ex) { 
	        ex.printStackTrace(); 
	      } 
		
		
	}

	public void otvoriFormu(JComboBox unosCmbx, String vrsta, java.util.Date d1, java.util.Date d2) {
		
		if ( vrsta.equals("Po radniku") ) {
			Korisnik k = (Korisnik)unosCmbx.getSelectedItem();
			PrikazIzvjestajaRadnikGUI ex = new PrikazIzvjestajaRadnikGUI(k, d1, d2);
            ex.setTitle("Izvještaj");
            ex.setSize(600, 350);
            ex.setLocationRelativeTo(null);
            ex.setVisible(true);
		}
		
		if ( vrsta.equals("Po vrsti usluge") ) {
			VrstaUsluge v = (VrstaUsluge)unosCmbx.getSelectedItem();
			PrikazIzvjestajaUslugaGUI ex = new PrikazIzvjestajaUslugaGUI (v, d1, d2);
            ex.setTitle("Izvještaj");
            ex.setSize(600, 350);
            ex.setLocationRelativeTo(null);
            ex.setVisible(true);
		}
		
		if ( vrsta.equals("Po klijentu") ) {
			Klijent k = (Klijent)unosCmbx.getSelectedItem();
			PrikazIzvjestajaKlijentGUI ex = new PrikazIzvjestajaKlijentGUI (k, d1, d2);
            ex.setTitle("Izvještaj");
            ex.setSize(600, 350);
            ex.setLocationRelativeTo(null);
            ex.setVisible(true);
		}
		
		if ( vrsta.equals("Sumarni izvjestaj") ) {
			PrikazIzvjestajaSumarniGUI ex = new PrikazIzvjestajaSumarniGUI (d1, d2);
            ex.setTitle("Izvještaj");
            ex.setSize(600, 350);
            ex.setLocationRelativeTo(null);
            ex.setVisible(true);
		}
		
		if ( vrsta.equals("Detaljni izvjestaj") ) {
			PrikazIzvjestajaDetaljniGUI ex = new PrikazIzvjestajaDetaljniGUI (d1, d2);
            ex.setTitle("Izvještaj");
            ex.setSize(600, 350);
            ex.setLocationRelativeTo(null);
            ex.setVisible(true);
		}
		
	}

	public void napuniUnosCmbx(JComboBox vrstaIzvjestajaCmbx, JComboBox unosCmbx, JLabel unosLbl) {
		
		if(vrstaIzvjestajaCmbx.getSelectedItem().equals("Po radniku"))
        {
     	    unosLbl.setText("Serviser:");
     	    unosCmbx.removeAllItems();
     	    
             TipKorisnika tk = new TipKorisnika();
             TipKorisnikaDAO tkDAO = new TipKorisnikaDAO();
             tk = tkDAO.getById(1);
                          
             Set<Korisnik> korisnici = tk.getKorisnici();		                              
     	    		            	   
     	    @SuppressWarnings("rawtypes")
				Vector comboBoxItems=new Vector();

             for (Iterator<Korisnik> iter = korisnici.iterator(); iter.hasNext(); ) {
                 Korisnik k = iter.next();
                 comboBoxItems.add(k);
             }
     	    
     	    @SuppressWarnings("rawtypes")
				final DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
     	    unosCmbx.setModel(model);
     	    unosCmbx.setVisible(true); 
        }
		
		if(vrstaIzvjestajaCmbx.getSelectedItem().equals("Po vrsti usluge"))
        {
     	     unosLbl.setText("Vrsta usluge:");
     	     unosCmbx.removeAllItems();
     	    
     	     VrstaUslugeDAO vDAO = new VrstaUslugeDAO();
             List<VrstaUsluge> usluge = vDAO.getAll();
	                                   	    		            	   
     	    @SuppressWarnings("rawtypes")
				Vector comboBoxItems=new Vector();

             for (int i=0; i<usluge.size(); i++ ) {
                 comboBoxItems.add(usluge.get(i));
             }
     	    
     	    @SuppressWarnings("rawtypes")
			final DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
     	    unosCmbx.setModel(model);
     	    unosCmbx.setVisible(true); 
        }
		
		if(vrstaIzvjestajaCmbx.getSelectedItem().equals("Po klijentu"))
        {
     	     unosLbl.setText("Klijent:");
     	     unosCmbx.removeAllItems();
     	    
     	     KlijentDAO kDAO = new KlijentDAO();
             List<Klijent> klijenti = kDAO.getAll();
	                                   	    		            	   
     	    @SuppressWarnings("rawtypes")
				Vector comboBoxItems=new Vector();

             for (int i=0; i<klijenti.size(); i++ ) {
                 comboBoxItems.add(klijenti.get(i));
             }
     	    
     	    @SuppressWarnings("rawtypes")
			final DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
     	    unosCmbx.setModel(model);   
     	    unosCmbx.setVisible(true); 
        }
		
		if(vrstaIzvjestajaCmbx.getSelectedItem().equals("Sumarni izvjestaj"))
        {
     	     unosLbl.setText("");
     	     unosCmbx.removeAllItems();
     	     unosCmbx.setVisible(false);  	       	   
        }
		
		if(vrstaIzvjestajaCmbx.getSelectedItem().equals("Detaljni izvjestaj"))
        {
     	     unosLbl.setText("");
     	     unosCmbx.removeAllItems();
     	     unosCmbx.setVisible(false);  	       	   
        }
		
	}
	
	public void napuniTabeluUsluga(DefaultTableModel t, VrstaUsluge v, Date sqld1, Date sqld2) throws Exception {
		try {
			VrstaUsluge vrstaUsluge = new VrstaUsluge();
	    	VrstaUslugeDAO vDAO = new VrstaUslugeDAO();
	    	vrstaUsluge = vDAO.getById(v.getVrstaUsluge_id());		
	    	
	    	Izvjestaj iz = new Izvjestaj();
	    	List<stavkaIzvjestajaUsluga> red = iz.vratiIzvjestajPremaUslugi(vrstaUsluge, sqld1, sqld2);
	    	
	    	int ukupno = 0;
	        for(int i=0; i<red.size(); i++)
	        {
	        	Object[] o = { red.get(i).getRadnik(), red.get(i).getKlijent(), formatirajDatum(red.get(i).getDatum()), red.get(i).getBrojSati() }; 
	        	t.addRow(o);
	        	ukupno += Integer.parseInt(red.get(i).getBrojSati());
	        }
	        Object[] o = { "", "", "Ukupno: ", String.valueOf(ukupno) };
	        t.addRow(o);
		}
		catch(Exception e) {
			throw e;
		}
	}

	public void napraviPdfUsluga(VrstaUsluge v, Date sqld1, Date sqld2 ) throws Exception {
		
		Random rand = new Random();
		int x = rand.nextInt(1000);
		
		final String FILE = "c:\\izvjestaj\\izv_" + v + "_" + sqld1 + "_" + sqld2 + "_" + x +".pdf"; 
	    final Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD); 
	    final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD); 
		
	    try { 
	        Document document = new Document(); 
	        PdfWriter.getInstance(document, new FileOutputStream(FILE)); 
	        document.open(); 
	        
	        //addMetaData(document); 
	        document.addTitle("TaskTracker - Izvjestaj"); 
	        	        
	        Paragraph preface = new Paragraph(); 
	        preface.add(new Paragraph(" ")); 
	        	          
	        preface.add(new Paragraph("Izvještaj za vrstu usluge: "+v, catFont)); 
	        preface.add(new Paragraph("Za period od: " + sqld1.getDate()
	        		+ "." + (sqld1.getMonth()+1) + ".20" + (sqld1.getYear()-100) + ". do: " 
	        		+ sqld2.getDate() + "." + (sqld2.getMonth()+1) + ".20" + (sqld2.getYear()-100), smallBold)); 
	        preface.add(new Paragraph(" ")); 
	        document.add(preface); 
	        
	        PdfPTable table = new PdfPTable(4); 
	      
	        PdfPCell c1 = new PdfPCell(new Phrase("Radnik")); 
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
	        table.addCell(c1); 
	      
	        c1 = new PdfPCell(new Phrase("Klijent")); 
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
	        table.addCell(c1); 
	      
	        c1 = new PdfPCell(new Phrase("Datum")); 
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
	        table.addCell(c1); 
	          
	        c1 = new PdfPCell(new Phrase("Broj sati")); 
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
	        table.addCell(c1); 
	          
	        table.setHeaderRows(1); 
	        
			VrstaUsluge vrstaUsluge = new VrstaUsluge();
	    	VrstaUslugeDAO vDAO = new VrstaUslugeDAO();
	    	vrstaUsluge = vDAO.getById(v.getVrstaUsluge_id());		
	    	
	    	Izvjestaj iz = new Izvjestaj();
	    	List<stavkaIzvjestajaUsluga> red = iz.vratiIzvjestajPremaUslugi(vrstaUsluge, sqld1, sqld2);
	    	
	    	int ukupno = 0;
	        for(int i=0; i<red.size(); i++)
	        {
	        	table.addCell(red.get(i).getRadnik());
	        	table.addCell(red.get(i).getKlijent());
	        	table.addCell(formatirajDatum(red.get(i).getDatum()));
	        	table.addCell(red.get(i).getBrojSati());      
	        	ukupno += Integer.parseInt(red.get(i).getBrojSati());
	        }

        	table.addCell("");
        	table.addCell("");
        	table.addCell("Ukupno: ");
        	table.addCell(String.valueOf(ukupno));
	        
	        document.add(table); 

	        document.close(); 
	          
	        if (Desktop.isDesktopSupported()) { 
	              try { 
	                  File myFile = new File(FILE); 
	                  Desktop.getDesktop().open(myFile); 
	              } catch (IOException ex) { 
	                  // no application registered for PDFs 
	              } 
	          } 
	      } catch (Exception ex) { 
	        ex.printStackTrace(); 
	      } 
	    
	}
	
	public void napuniTabeluKlijent(DefaultTableModel t, Klijent k, Date sqld1, Date sqld2) throws Exception {
		try {
			Klijent klijent = new Klijent();
	    	KlijentDAO kDAO = new KlijentDAO();
	    	klijent = kDAO.getById(k.getKlijent_id());		
	    	
	    	Izvjestaj iz = new Izvjestaj();
	    	List<stavkaIzvjestajaKlijent> red = iz.vratiIzvjestajPremaKlijentu(klijent, sqld1, sqld2);
	    	
	    	int ukupno = 0;
	        for(int i=0; i<red.size(); i++)
	        {
	        	Object[] o = { red.get(i).getRadnik(), red.get(i).getUsluga(), formatirajDatum(red.get(i).getDatum()), red.get(i).getBrojSati() }; 
	        	t.addRow(o);
	        	ukupno += Integer.parseInt(red.get(i).getBrojSati());
	        }
	        Object[] o = { "", "", "Ukupno: ", String.valueOf(ukupno) };
	        t.addRow(o);
		}
		catch(Exception e) {
			throw e;
		}
	}

	public void napraviPdfKlijent(Klijent k, Date sqld1, Date sqld2 ) throws Exception {
		
		Random rand = new Random();
		int x = rand.nextInt(1000);
		
		final String FILE = "c:\\izvjestaj\\izv_" + k + "_" + sqld1 + "_" + sqld2 + "_" + x +".pdf"; 
	    final Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD); 
	    final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD); 
		
	    try { 
	        Document document = new Document(); 
	        PdfWriter.getInstance(document, new FileOutputStream(FILE)); 
	        document.open(); 
	        
	        //addMetaData(document); 
	        document.addTitle("TaskTracker - Izvjestaj"); 
	        	        
	        Paragraph preface = new Paragraph(); 
	        preface.add(new Paragraph(" ")); 
	        	          
	        preface.add(new Paragraph("Izvještaj za klijenta: "+k, catFont)); 
	        preface.add(new Paragraph("Za period od: " + sqld1.getDate()
	        		+ "." + (sqld1.getMonth()+1) + ".20" + (sqld1.getYear()-100) + ". do: " 
	        		+ sqld2.getDate() + "." + (sqld2.getMonth()+1) + ".20" + (sqld2.getYear()-100), smallBold)); 
	        preface.add(new Paragraph(" ")); 
	        document.add(preface); 
	        
	        PdfPTable table = new PdfPTable(4); 
	      
	        PdfPCell c1 = new PdfPCell(new Phrase("Radnik")); 
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
	        table.addCell(c1); 
	      
	        c1 = new PdfPCell(new Phrase("Vrsta usluge")); 
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
	        table.addCell(c1); 
	      
	        c1 = new PdfPCell(new Phrase("Datum")); 
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
	        table.addCell(c1); 
	          
	        c1 = new PdfPCell(new Phrase("Broj sati")); 
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
	        table.addCell(c1); 
	          
	        table.setHeaderRows(1); 
	        
			Klijent klijent = new Klijent();
	    	KlijentDAO kDAO = new KlijentDAO();
	    	klijent = kDAO.getById(k.getKlijent_id());	
	    	
	    	Izvjestaj iz = new Izvjestaj();
	    	List<stavkaIzvjestajaKlijent> red = iz.vratiIzvjestajPremaKlijentu(klijent, sqld1, sqld2);
	    	
	    	int ukupno = 0;
	        for(int i=0; i<red.size(); i++)
	        {
	        	table.addCell(red.get(i).getRadnik());
	        	table.addCell(red.get(i).getUsluga());
	        	table.addCell(formatirajDatum(red.get(i).getDatum()));
	        	table.addCell(red.get(i).getBrojSati());      
	        	ukupno += Integer.parseInt(red.get(i).getBrojSati());
	        }

        	table.addCell("");
        	table.addCell("");
        	table.addCell("Ukupno: ");
        	table.addCell(String.valueOf(ukupno));
	        
	        document.add(table); 

	        document.close(); 
	          
	        if (Desktop.isDesktopSupported()) { 
	              try { 
	                  File myFile = new File(FILE); 
	                  Desktop.getDesktop().open(myFile); 
	              } catch (IOException ex) { 
	                  // no application registered for PDFs 
	              } 
	          } 
	      } catch (Exception ex) { 
	        ex.printStackTrace(); 
	      } 
	    
	}

	public void napuniTabeluSumarni(DefaultTableModel t, Date sqld1, Date sqld2) throws Exception {
		try {

	    	Izvjestaj iz = new Izvjestaj();
	    	List<stavkaIzvjestajaSat> red = iz.vratiIzvjestajPremaSatima(sqld1, sqld2);
	    	
	    	int ukupno = 0;
	        for(int i=0; i<red.size(); i++)
	        {
	        	Object[] o = { red.get(i).getRadnik(), red.get(i).getBrojSati() }; 
	        	t.addRow(o);
	        	ukupno += Integer.parseInt(red.get(i).getBrojSati());
	        }
	        Object[] o = {  "Ukupno: ", String.valueOf(ukupno) };
	        t.addRow(o);
		}
		catch(Exception e) {
			throw e;
		}
	}

	public void napraviPdfSumarni(Date sqld1, Date sqld2 ) throws Exception {
		
		Random rand = new Random();
		int x = rand.nextInt(1000);
		
		final String FILE = "c:\\izvjestaj\\izv_" + "sumarni" + "_" + sqld1 + "_" + sqld2 + "_" + x +".pdf"; 
	    final Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD); 
	    final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD); 
		
	    try { 
	        Document document = new Document(); 
	        PdfWriter.getInstance(document, new FileOutputStream(FILE)); 
	        document.open(); 
	        
	        //addMetaData(document); 
	        document.addTitle("TaskTracker - Izvjestaj"); 
	        	        
	        Paragraph preface = new Paragraph(); 
	        preface.add(new Paragraph(" ")); 
	        	          
	        preface.add(new Paragraph("Sumarni izvještaj o radnim satima radnika", catFont)); 
	        preface.add(new Paragraph("Za period od: " + sqld1.getDate()
	        		+ "." + (sqld1.getMonth()+1) + ".20" + (sqld1.getYear()-100) + ". do: " 
	        		+ sqld2.getDate() + "." + (sqld2.getMonth()+1) + ".20" + (sqld2.getYear()-100), smallBold)); 
	        preface.add(new Paragraph(" ")); 
	        document.add(preface); 
	        
	        PdfPTable table = new PdfPTable(2); 
	      
	        PdfPCell c1 = new PdfPCell(new Phrase("Radnik")); 
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
	        table.addCell(c1); 
	      	          
	        c1 = new PdfPCell(new Phrase("Broj sati")); 
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
	        table.addCell(c1); 
	          
	        table.setHeaderRows(1); 
	        
	    	Izvjestaj iz = new Izvjestaj();
	    	List<stavkaIzvjestajaSat> red = iz.vratiIzvjestajPremaSatima(sqld1, sqld2);
	    	
	    	int ukupno = 0;
	        for(int i=0; i<red.size(); i++)
	        {
	        	table.addCell(red.get(i).getRadnik());
	        	table.addCell(red.get(i).getBrojSati());      
	        	ukupno += Integer.parseInt(red.get(i).getBrojSati());
	        }

        	table.addCell("Ukupno: ");
        	table.addCell(String.valueOf(ukupno));
	        
	        document.add(table); 

	        document.close(); 
	          
	        if (Desktop.isDesktopSupported()) { 
	              try { 
	                  File myFile = new File(FILE); 
	                  Desktop.getDesktop().open(myFile); 
	              } catch (IOException ex) { 
	                  // no application registered for PDFs 
	              } 
	          } 
	      } catch (Exception ex) { 
	        ex.printStackTrace(); 
	      } 
	    
	}

	public void napuniTabeluDetaljni(DefaultTableModel t, Date sqld1, Date sqld2) throws Exception {
		try {
	    			
	    	TipKorisnikaDAO tkDAO = new TipKorisnikaDAO();
	    	TipKorisnika tk= tkDAO.getById(1);
	    	Set<Korisnik> lista = tk.getKorisnici();
	    	
	    	for (Iterator<Korisnik> it = lista.iterator(); it.hasNext(); ) {
	            Korisnik k = it.next();

	            Izvjestaj iz = new Izvjestaj();
	            List<stavkaIzvjestajaRadnik> red = iz.vratiIzvjestajPremaRadniku(k, sqld1, sqld2);
	            
	        	Object[] o = { "Radnik: ", k.getIme(), k.getPrezime(), "" }; 
	        	t.addRow(o);
	        	
	        	Object[] o1 = { "Vrsta usluge ", "Klijent", "Datum", "Broj sati" };
	        	t.addRow(o1);
	        	
		    	int ukupno = 0;
		        for(int i=0; i<red.size(); i++)
		        {
		        	Object[] o2 = { red.get(i).getVrstaUsluge(), red.get(i).getKlijent(), formatirajDatum(red.get(i).getDatum()), red.get(i).getBrojSati() }; 
		        	t.addRow(o2);
		        	ukupno += Integer.parseInt(red.get(i).getBrojSati());
		        }
		        Object[] o3 = { "", "", "Ukupno: ", String.valueOf(ukupno) };
		        t.addRow(o3);
	        	
	        	Object[] o4 = { "", "", "", "" };
	        	t.addRow(o4);
	        	           
	        }

		}
		catch(Exception e) {
			throw e;
		}
	}

	public void napraviPdfDetaljni(Date sqld1, Date sqld2 ) throws Exception {
		
		Random rand = new Random();
		int x = rand.nextInt(1000);
		
		final String FILE = "c:\\izvjestaj\\izv_" + "detaljni" + "_" + sqld1 + "_" + sqld2 + "_" + x +".pdf"; 
	    final Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD); 
	    final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD); 
		
	    try { 
	        Document document = new Document(); 
	        PdfWriter.getInstance(document, new FileOutputStream(FILE)); 
	        document.open(); 
	        
	        //addMetaData(document); 
	        document.addTitle("TaskTracker - Izvjestaj"); 
	        	        
	        Paragraph preface = new Paragraph(); 
	        preface.add(new Paragraph(" ")); 
	        
	        Paragraph prazno = new Paragraph(); 
	        prazno.add(new Paragraph(" ")); 
	        	        
	        preface.add(new Paragraph("Detaljni izvještaj o radnim satima radnika", catFont)); 
	        preface.add(new Paragraph("Za period od: " + sqld1.getDate()
	        		+ "." + (sqld1.getMonth()+1) + ".20" + (sqld1.getYear()-100) + ". do: " 
	        		+ sqld2.getDate() + "." + (sqld2.getMonth()+1) + ".20" + (sqld2.getYear()-100), smallBold)); 
	        preface.add(new Paragraph(" ")); 
	        document.add(preface); 
	        
	    	TipKorisnikaDAO tkDAO = new TipKorisnikaDAO();
	    	TipKorisnika tk= tkDAO.getById(1);
	    	Set<Korisnik> lista = tk.getKorisnici();
	    	
	    	for (Iterator<Korisnik> it = lista.iterator(); it.hasNext(); ) {
	            Korisnik k = it.next();

	            Izvjestaj iz = new Izvjestaj();
	            List<stavkaIzvjestajaRadnik> red = iz.vratiIzvjestajPremaRadniku(k, sqld1, sqld2);
	            
		        Paragraph podaci = new Paragraph();
		        podaci.add(new Paragraph("Radnik: " + k));
		        document.add(podaci);
	        	document.add(prazno);
		        
		        PdfPTable table = new PdfPTable(4);
			      
		        PdfPCell c1 = new PdfPCell(new Phrase("Vrsta usluge")); 
		        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		        table.addCell(c1); 
		        
		        c1 = new PdfPCell(new Phrase("Klijent")); 
		        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		        table.addCell(c1); 
		        
		        c1 = new PdfPCell(new Phrase("Datum")); 
		        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		        table.addCell(c1); 
		      	          
		        c1 = new PdfPCell(new Phrase("Broj sati")); 
		        c1.setHorizontalAlignment(Element.ALIGN_CENTER); 
		        table.addCell(c1); 
		          
		        table.setHeaderRows(1); 
	        	
		    	int ukupno = 0;
		        for(int i=0; i<red.size(); i++)
		        {
		        	table.addCell(red.get(i).getVrstaUsluge());
		        	table.addCell(red.get(i).getKlijent());
		        	table.addCell(formatirajDatum(red.get(i).getDatum()));
		        	table.addCell(red.get(i).getBrojSati());      
		        	ukupno += Integer.parseInt(red.get(i).getBrojSati());
		        }

	        	table.addCell("");
	        	table.addCell("");
	        	table.addCell("Ukupno: ");
	        	table.addCell(String.valueOf(ukupno));
		        
		        document.add(table); 
		        document.add(prazno); 
		        
	        }
	        
	        document.close(); 
	          
	        if (Desktop.isDesktopSupported()) { 
	              try { 
	                  File myFile = new File(FILE); 
	                  Desktop.getDesktop().open(myFile); 
	              } catch (IOException ex) { 
	                  // no application registered for PDFs 
	              } 
	          } 
	      } catch (Exception ex) { 
	        ex.printStackTrace(); 
	      } 
	    
	}

	
}
