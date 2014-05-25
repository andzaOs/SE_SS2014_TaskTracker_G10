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
import Kontroleri.KlijentKontroler;
import UtilClasses.KorisnickoUputstvo;
import UtilClasses.Validacija;
 	
 	public class KreiranjeKlijentaGUI extends JFrame {
 		private JFrame frmKreiranjeKlijenta;
 		Boolean uslov1, uslov2, uslov3, uslov4, uslov5, uslov6, uslov7;
 		private static KreiranjeKlijentaGUI instanca;
 		public KreiranjeKlijentaGUI() {
 			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 			initialize();
 		}
 		public static KreiranjeKlijentaGUI dajInstancu() {
 			if(instanca==null) {
	 			instanca=new KreiranjeKlijentaGUI();
	 			
 			}
 			return instanca;
 		}
 		public static void unistiInstancu() { instanca= null; }
 	
 		private void initialize() {
 			
 			setTitle("Kreiranje novog klijenta");
 			frmKreiranjeKlijenta = new JFrame();
 			frmKreiranjeKlijenta.setTitle("Kreiranje novog korisnika");
 			frmKreiranjeKlijenta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 			
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
 								PromjenaSifreGUI window = new PromjenaSifreGUI();
 								
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
 					KorisnickoUputstvo kp = new KorisnickoUputstvo();
 					kp.dobaviUputstvo();
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
 			KlijentDAO klDAO4 = new KlijentDAO();
 			final Klijent test = klDAO4.getById(3);
 			JPanel juzniPanel = new JPanel();
 			juzniPanel.setBorder(BorderFactory.createEmptyBorder(2, 1, 2, 1));
 			juzniPanel.setLayout(new GridLayout(1,2,1,1));
 			JButton kreirajBtn = new JButton("Kreiraj");
 			kreirajBtn.addActionListener(new ActionListener() {
 				public void actionPerformed(ActionEvent arg0) {
 					try {
	 					KlijentKontroler kKontroler = new KlijentKontroler();
	 					if(kKontroler.kreiranjeKlijenta(nazivTxt, adresaTxt, emailTxt, brojTelefonaTxt)) {
	 						dispose();
	 						JOptionPane.showMessageDialog(frmKreiranjeKlijenta,
	 							    "Novi klijent je uspješno dodan.",
	 							    "Dodavanje klijenta",
	 							    JOptionPane.INFORMATION_MESSAGE);
	 					}
	 					else{
	 						JOptionPane.showMessageDialog(frmKreiranjeKlijenta,
	 							    "Da biste spremili podatke u bazu morate unijeti ispravne podatke u označenim poljima.",
	 							    "Poruka o greški",
	 							    JOptionPane.ERROR_MESSAGE);
	 					}
 					}
 					catch (Exception e) {
 						JOptionPane.showMessageDialog(rootPane,
								    "Greška. Pojavio se izuzetak.",
								    "Izuzetak",
								    JOptionPane.ERROR_MESSAGE);
							System.exit(DISPOSE_ON_CLOSE);
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
 			juzniPanel.add(kreirajBtn);
 			
 			
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
 	
