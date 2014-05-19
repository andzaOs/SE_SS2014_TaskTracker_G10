 	package RacunovodstvoGUI;
 	
 	
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import DAO.KlijentDAO;
import Entity.Klijent;
import UtilClasses.Validacija;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 	
 	public class ModifikovanjeKlijentaGUI extends JFrame {
 		private JFrame frmModifikovanjeKlijenta;
 		Boolean uslov1, uslov2, uslov3, uslov4, uslov5, uslov6, uslov7;
 	
 		private static ModifikovanjeKlijentaGUI instanca;
 		public ModifikovanjeKlijentaGUI(long klijent) {
 			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 			
 			initialize(klijent);
 		}
 		public static ModifikovanjeKlijentaGUI dajInstancu(long klijent) {
 			if(instanca==null) {
	 			instanca=new ModifikovanjeKlijentaGUI(klijent);
 			}
 			return instanca;
 		}
 		
 		public static void unistiInstancu() { instanca= null; }
 	
 		private void initialize(final long id) {
 			
 			
 			
 			setTitle("Modifikovanje novog klijenta");
 			frmModifikovanjeKlijenta = new JFrame();
 			frmModifikovanjeKlijenta.setTitle("Kreiranje novog korisnika");
 			frmModifikovanjeKlijenta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 			
 			JMenuBar glavniMenuBar = new JMenuBar();
 			setJMenuBar(glavniMenuBar);
 			
 			JMenu mojRacunMenu = new JMenu("Moj račun");
 			glavniMenuBar.add(mojRacunMenu);
 			JMenuItem promijeniSifruItem = new JMenuItem("Promijeni šifru");
 			promijeniSifruItem.addActionListener(new ActionListener() {
 				public void actionPerformed(ActionEvent e) {
 					EventQueue.invokeLater(new Runnable() {
 						public void run() {
 							try {
 								JFrame frmPromjenaifre = new JFrame();
 								PromjenaSifreGUI window = new PromjenaSifreGUI(frmPromjenaifre);
 								
 							} catch (Exception e) {
 								e.printStackTrace();
 							}
 						}
 					});
 				}
 			});
 			mojRacunMenu.add(promijeniSifruItem);
 			JMenuItem odjavaItem = new JMenuItem("Odjavi se");
 			odjavaItem.addActionListener(new ActionListener() {
 				public void actionPerformed(ActionEvent e) {
 					SwingUtilities.invokeLater(new Runnable() 
 					{
 						public void run() 
 						{
 							OdjaviSeGUI ex = new OdjaviSeGUI();
 				             ex.setSize(600, 150);
 				             ex.setLocationRelativeTo(null);
 				             ex.setVisible(true);
 						}
 					});
 				}
 			});
 			mojRacunMenu.add(odjavaItem);
 			
 			JMenu alatiMenu = new JMenu("Alati");
 			glavniMenuBar.add(alatiMenu);		
 			JMenuItem sistemObavjestavanjaItem = new JMenuItem("Sistem obavještavanja");
 			sistemObavjestavanjaItem.addActionListener(new ActionListener() {
 				public void actionPerformed(ActionEvent e) {
 					SwingUtilities.invokeLater(new Runnable() 
 					{
 						public void run() 
 						{
 							SistemObavjestavanjaGUI ex = new SistemObavjestavanjaGUI();
 							ex.setVisible(true);
 						}
 					});
 				}
 			});
 			alatiMenu.add(sistemObavjestavanjaItem);
 			
 			JMenu pomocMenu = new JMenu("Pomoć");
 			glavniMenuBar.add(pomocMenu);		
 			JMenuItem oNamaItem = new JMenuItem("O nama");
 			oNamaItem.addActionListener(new ActionListener() {
 				public void actionPerformed(ActionEvent e) {
 					SwingUtilities.invokeLater(new Runnable() {
 			            public void run() {
 			                ONamaGUI ex = new ONamaGUI();
 			                ex.setSize(300, 150);
 			                ex.setLocationRelativeTo(null);
 			                ex.setVisible(true);
 			            }
 			        });
 				}
 			});
 			pomocMenu.add(oNamaItem);		
 			JMenuItem korisnickoUputstvoItem = new JMenuItem("Korisni\u010Dko uputstvo");
 			korisnickoUputstvoItem.addActionListener(new ActionListener() {
 				public void actionPerformed(ActionEvent e) {
 					JOptionPane.showMessageDialog(rootPane, "Opcija će ponuditi preuzimanje .pdf dokumenta sa korisničkm uputstvom", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
 				}
 			});
 			pomocMenu.add(korisnickoUputstvoItem);	
 			
 			JPanel centralniPanel = new JPanel();
 			centralniPanel.setLayout(new GridLayout(4,2,2,2));
 			
 			final Validacija v = new Validacija();
 			
 			
 			JLabel nazivLbl = new JLabel("Naziv klijenta*:");
 			nazivLbl.setHorizontalAlignment(SwingConstants.RIGHT);
 			final JTextField nazivTxt = new JTextField();
 			centralniPanel.add(nazivLbl);
 			centralniPanel.add(nazivTxt);
 			 			
 			JLabel adresaLbl = new JLabel("Adresa*:");
 			adresaLbl.setHorizontalAlignment(SwingConstants.RIGHT);
 			final JTextField adresaTxt = new JTextField();
 			centralniPanel.add(adresaLbl);
 			centralniPanel.add(adresaTxt);
 			
 					
 			JLabel emailLbl = new JLabel("E-mail:");
 			emailLbl.setHorizontalAlignment(SwingConstants.RIGHT);
 			final JTextField emailTxt = new JTextField();
 			centralniPanel.add(emailLbl);
 			centralniPanel.add(emailTxt);
 					
 			
 			JLabel brojTelefonaLbl = new JLabel("Broj telefona*:");
 			brojTelefonaLbl.setHorizontalAlignment(SwingConstants.RIGHT);
 			final JTextField brojTelefonaTxt = new JTextField();
 			centralniPanel.add(brojTelefonaLbl);
 			centralniPanel.add(brojTelefonaTxt);
 			// Ispis postojećih podataka
 			KlijentDAO klDAO2 = new KlijentDAO();				
 			final Klijent kl = klDAO2.getById(id);
 			nazivTxt.setText(kl.getNaziv());
 			emailTxt.setText(kl.getEmail());
			adresaTxt.setText(kl.getAdresa());
			brojTelefonaTxt.setText(kl.getBroj_telefona());
 			
 			nazivTxt.addFocusListener(
			          new FocusListener() {
			             public void focusGained(FocusEvent e) {};

			             public void focusLost(FocusEvent e) {
			            	uslov1 = v.praznoPoljeBolean(nazivTxt);
			      			uslov2 = v.minimalnaDuzina(nazivTxt, 2);
			             }
			});
 			adresaTxt.addFocusListener(
			          new FocusListener() {
			             public void focusGained(FocusEvent e) {};

			             public void focusLost(FocusEvent e) {
			            	uslov3 = v.praznoPoljeBolean(adresaTxt);
			      			uslov4 = v.minimalnaDuzina(adresaTxt, 5);
			             }
			});
 			emailTxt.addFocusListener(
			          new FocusListener() {
			             public void focusGained(FocusEvent e) {};

			             public void focusLost(FocusEvent e) {
			            	
			      			uslov5 = v.emailAdresa(emailTxt);
			             }
			});
 			brojTelefonaTxt.addFocusListener(
			          new FocusListener() {
			             public void focusGained(FocusEvent e) {};

			             public void focusLost(FocusEvent e) {
			            	uslov6 = v.praznoPoljeBolean(brojTelefonaTxt);
			      			uslov7 = v.brojTelefona(brojTelefonaTxt);
			             }
			});
 			
 			JPanel juzniPanel = new JPanel();
 			juzniPanel.setBorder(BorderFactory.createEmptyBorder(2, 1, 2, 1));
 			juzniPanel.setLayout(new GridLayout(1,2,1,1));
 			JButton modifikujBtn = new JButton("Modifikuj");
 			modifikujBtn.addActionListener(new ActionListener() {
 				public void actionPerformed(ActionEvent arg0) {
 					uslov1 = v.praznoPoljeBolean(nazivTxt);
	      			uslov2 = v.minimalnaDuzina(nazivTxt, 2);
	      			uslov3 = v.praznoPoljeBolean(adresaTxt);
	      			uslov4 = v.minimalnaDuzina(adresaTxt, 5);
	      			uslov5 = v.emailAdresa(emailTxt);
	      			uslov6 = v.praznoPoljeBolean(brojTelefonaTxt);
	      			uslov7 = v.brojTelefona(brojTelefonaTxt);
	      			final Boolean validno = (uslov1 && uslov2 && uslov3 && uslov4 && uslov5 && uslov6 && uslov7);
 					if(validno) {
 						Klijent k = new Klijent();
 						k.setKlijent_id(id);
 						k.setNaziv(nazivTxt.getText());
 						k.setAdresa(adresaTxt.getText());
 						k.setEmail(emailTxt.getText());
 						k.setBroj_telefona(brojTelefonaTxt.getText());
 						k.setVidljivo(true);
 							
 						KlijentDAO klDAO3 = new KlijentDAO();
 						klDAO3.update(k);
 						dispose();
 						
 						JOptionPane.showMessageDialog(frmModifikovanjeKlijenta,
 							    "Klijent je uspješno modifikovan.",
 							    "Modifikovanje klijenta",
 							    JOptionPane.INFORMATION_MESSAGE);
 						
 						
 					}
 					else {
 						JOptionPane.showMessageDialog(frmModifikovanjeKlijenta,
 							    "Da biste spremili podatke u bazu morate unijeti ispravne podatke u označenim poljima.",
 							    "Poruka o greški",
 							    JOptionPane.ERROR_MESSAGE);
 					}
 					
 				}
 			});
 			JButton odustaniBtn = new JButton("Odustani");
 			odustaniBtn.addActionListener(new ActionListener() {
 				public void actionPerformed(ActionEvent e) {
 					dispose();
 					
 				}
 			});
 			juzniPanel.add(odustaniBtn);
 			juzniPanel.add(modifikujBtn);
 			
 			
 			getContentPane().add(centralniPanel, BorderLayout.CENTER);
 			getContentPane().add(juzniPanel, BorderLayout.SOUTH);
 		}
		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			unistiInstancu();
			super.dispose();
		}
 		
 	
 	
 	}
 	

