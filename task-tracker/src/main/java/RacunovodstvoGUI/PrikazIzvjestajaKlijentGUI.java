package RacunovodstvoGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DAO.KorisnikDAO;
import Entity.Klijent;
import Entity.Korisnik;
import Izvjestaj.Izvjestaj;
import Izvjestaj.stavkaIzvjestajaRadnik;
import Kontroleri.IzvjestajKontroler;

import java.awt.Desktop; 
import java.io.File; 
import java.io.FileOutputStream; 
import java.io.IOException; 

import com.itextpdf.text.Document; 
import com.itextpdf.text.DocumentException; 
import com.itextpdf.text.Element; 
import com.itextpdf.text.Font; 
import com.itextpdf.text.Paragraph; 
import com.itextpdf.text.Phrase; 
import com.itextpdf.text.pdf.PdfPCell; 
import com.itextpdf.text.pdf.PdfPTable; 
import com.itextpdf.text.pdf.PdfWriter; 

public class PrikazIzvjestajaKlijentGUI extends JFrame{
	
	private IzvjestajKontroler ik = new IzvjestajKontroler();
	Klijent klijent;
	Date datum1;
	Date datum2;
	
	public PrikazIzvjestajaKlijentGUI(Klijent k, Date d1, Date d2) {
				
				klijent = k;
				datum1 = d1;
				datum2 = d2;
		
			    JPanel sjeverniPanel = new JPanel();
			    sjeverniPanel.setLayout(new GridLayout(2,4,2,2));
			    sjeverniPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				final JLabel naslovLbl = new JLabel ();
				naslovLbl.setHorizontalAlignment(SwingConstants.RIGHT);
				
				 naslovLbl.setText("Izvještaj za klijenta: ");
				 
				 java.sql.Date sqld1 = new java.sql.Date(d1.getTime());
				 java.sql.Date sqld2 = new java.sql.Date(d2.getTime());
				
				JLabel unosLbl = new JLabel ("");
				unosLbl.setText(k.toString());
				JLabel prazna1Lbl = new JLabel ("");
				JLabel prazna2Lbl= new JLabel ("");
				JLabel pocetniDatumLbl = new JLabel ("Za period od:" + sqld1.getDate()
		        		+ "." + (sqld1.getMonth()+1) + ".20" + (sqld1.getYear()-100) + ".");
				pocetniDatumLbl.setHorizontalAlignment(SwingConstants.RIGHT);
				JLabel pocetniDatumUnosLbl = new JLabel ("");
				JLabel krajnjiDatumLbl = new JLabel ("do:"+ sqld2.getDate()
		        		+ "." + (sqld2.getMonth()+1) + ".20" + (sqld2.getYear()-100) + ".");
				krajnjiDatumLbl.setHorizontalAlignment(SwingConstants.RIGHT);
				JLabel krajnjiDatumUnosLbl = new JLabel ("");
				sjeverniPanel.add(naslovLbl);
				sjeverniPanel.add(unosLbl);
				sjeverniPanel.add(prazna1Lbl);
				sjeverniPanel.add(prazna2Lbl);
				sjeverniPanel.add(pocetniDatumLbl);
				sjeverniPanel.add(pocetniDatumUnosLbl);
				sjeverniPanel.add(krajnjiDatumLbl);
				sjeverniPanel.add(krajnjiDatumUnosLbl);
				
				String imenaKolona[] = {"Radnik", "Vrsta usluge", "Datum", "Broj sati"};
					
				final DefaultTableModel tableModel = new DefaultTableModel(imenaKolona, 0){
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};

				try {
					ik.napuniTabeluKlijent(tableModel, klijent, sqld1, sqld2);
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(rootPane,
						    "Greška. Pojavio se izuzetak.",
						    "Izuzetak",
						    JOptionPane.ERROR_MESSAGE);
					System.exit(DISPOSE_ON_CLOSE);
				}
				final JTable podaciTbl = new JTable(tableModel);

				JScrollPane tabelaPane = new JScrollPane(podaciTbl);
	
				
				JPanel juzniPanel = new JPanel();
				JButton nazadBtn = new JButton("<< Nazad");
				nazadBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				JButton exportBtn = new JButton("Exportuj u .pdf");
				exportBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						try {
							java.sql.Date sqld1 = new java.sql.Date(datum1.getTime());
							java.sql.Date sqld2 = new java.sql.Date(datum2.getTime());
							ik.napraviPdfKlijent(klijent, sqld1, sqld2);
						}
						catch(Exception ex) {
							JOptionPane.showMessageDialog(rootPane,
								    "Greška. Pojavio se izuzetak.",
								    "Izuzetak",
								    JOptionPane.ERROR_MESSAGE);
							System.exit(DISPOSE_ON_CLOSE);
						}
					
					}
				});
				
				
				juzniPanel.setBorder(BorderFactory.createEmptyBorder(10, 1, 10, 1));
				juzniPanel.setLayout(new GridLayout(1,3,3,3));
				
				juzniPanel.add(nazadBtn);
				juzniPanel.add(exportBtn);
				
				getContentPane().add(sjeverniPanel, BorderLayout.NORTH);
				getContentPane().add(tabelaPane, BorderLayout.CENTER);
				getContentPane().add(juzniPanel, BorderLayout.SOUTH);
}
	
	
	
}
