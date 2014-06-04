package RacunovodstvoGUI;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import DAO.KorisnikDAO;
import DAO.TipKorisnikaDAO;
import Entity.Korisnik;
import Entity.TipKorisnika;
import Kontroleri.KorisnikKontroler;
import UtilClasses.KorisnickoUputstvo;
import UtilClasses.Validacija;

public class ModifikacijaKorisnikaGUI extends JFrame {
	private JFrame frmKreiranjeKorisnika;
	Boolean uslov1;
	Boolean uslov2;
	Boolean uslov3;
	Boolean uslov4;
	Boolean uslov5;
	Boolean uslov6;
	Boolean uslov7;
	Boolean uslov8;
	Boolean uslov9;
	Boolean uslov10;
	Boolean uslov11;
	Boolean uslov12;
	Boolean uslov13;
	Boolean uslov14;
	Boolean uslov15;
	Date datumIzvrsenja;
	Boolean izmjena;
	java.sql.Date sqlDate1;
	
	

	private static ModifikacijaKorisnikaGUI instanca;
	
	public ModifikacijaKorisnikaGUI(long korisnika) {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			initialize(korisnika);
		}
	public static ModifikacijaKorisnikaGUI dajInstancu(long korisnik) {
			if(instanca==null) {
 			instanca=new ModifikacijaKorisnikaGUI(korisnik);
			}
			return instanca;
		}
		
		public static void unistiInstancu() { instanca= null; }
	
	private void initialize(final long id) {
		
		setTitle("Modifikacija korisnika");
		frmKreiranjeKorisnika = new JFrame();
		frmKreiranjeKorisnika.setTitle("Modifikacija korisnika");
		
		
		
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
		JMenuItem korisnickoUputstvoItem = new JMenuItem("Korisničko uputstvo");
		korisnickoUputstvoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KorisnickoUputstvo kp = new KorisnickoUputstvo();
				kp.dobaviUputstvo();
			}
		});
		pomocMenu.add(korisnickoUputstvoItem);	
		
		JPanel centralniPanel = new JPanel();
		centralniPanel.setLayout(new GridLayout(12,2,2,2));
		
		KorisnikDAO kDAO = new KorisnikDAO();
		final Korisnik k = kDAO.getById(id);
		
		JLabel imeLbl = new JLabel("Ime:");
		imeLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		final JTextField imeTxt = new JTextField();
		centralniPanel.add(imeLbl);
		imeTxt.setText(k.getIme());
		centralniPanel.add(imeTxt);
		
		JLabel prezimeLbl = new JLabel("Prezime:");
		prezimeLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		final JTextField prezimeTxt = new JTextField();
		centralniPanel.add(prezimeLbl);
		prezimeTxt.setText(k.getPrezime());
		centralniPanel.add(prezimeTxt);
				
		JLabel jmbgLbl = new JLabel("JMBG:");
		jmbgLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		final JTextField jmbgTxt = new JTextField();
		centralniPanel.add(jmbgLbl);
		jmbgTxt.setText(k.getJmbg());
		centralniPanel.add(jmbgTxt);
		
		JLabel brojLKLbl = new JLabel("Broj lične karte:");
		brojLKLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		final JTextField brojLKTxt = new JTextField();
		centralniPanel.add(brojLKLbl);
		brojLKTxt.setText(k.getBr_lk());
		centralniPanel.add(brojLKTxt);		
		
		JLabel adresaLbl = new JLabel("Adresa:");
		adresaLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		final JTextField adresaTxt = new JTextField();
		centralniPanel.add(adresaLbl);
		adresaTxt.setText(k.getAdresa());
		centralniPanel.add(adresaTxt);	
		
		JLabel telefonLbl = new JLabel("Telefon:");
		telefonLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		final JTextField telefonTxt = new JTextField();
		centralniPanel.add(telefonLbl);
		telefonTxt.setText(k.getTelefon());
		centralniPanel.add(telefonTxt);	
		
		JLabel emailLbl = new JLabel("E-mail:");
		emailLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		final JTextField emailTxt = new JTextField();
		centralniPanel.add(emailLbl);
		emailTxt.setText(k.getEmail());
		centralniPanel.add(emailTxt);	
		
		JLabel datumZaposlenjaLbl = new JLabel("Datum zaposlenja:");
		datumZaposlenjaLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		UtilDateModel model = new UtilDateModel(); 
		//Ubaciti trenutni datum
		
		final JDatePanelImpl datePanel = new JDatePanelImpl(model);
		final JDatePickerImpl pocetniDatumDP = new JDatePickerImpl(datePanel);	
		pocetniDatumDP.getJFormattedTextField().setText(k.getDatum_zaposlenja().toString());
		centralniPanel.add(datumZaposlenjaLbl);
		centralniPanel.add(pocetniDatumDP);	
		
		JLabel korisnickoImeLbl = new JLabel("Korisničko ime:");
		korisnickoImeLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		final JTextField korisnickoImeTxt = new JTextField();
		centralniPanel.add(korisnickoImeLbl);
		korisnickoImeTxt.setText(k.getKorisnicko_ime());
		centralniPanel.add(korisnickoImeTxt);	
		
		JLabel sifraLbl = new JLabel("Nova šifra:");
		sifraLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		final JTextField sifraTxt = new JTextField();
		centralniPanel.add(sifraLbl);
		sifraTxt.setToolTipText("Trenutnu šifru ne možete vidjeti. Unesite novu ili ostavite prazno polje!");
		centralniPanel.add(sifraTxt);	

		JLabel tipKorisnikaLbl = new JLabel("Tip korisnika:");
		tipKorisnikaLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		centralniPanel.add(tipKorisnikaLbl);
		
		datePanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				datumIzvrsenja = (Date) datePanel.getModel().getValue();
				sqlDate1 = new java.sql.Date(datumIzvrsenja.getTime());
				
			}
		});
		
		JPanel juzniPanel = new JPanel();
		juzniPanel.setBorder(BorderFactory.createEmptyBorder(2, 1, 2, 1));
		juzniPanel.setLayout(new GridLayout(1,2,1,1));
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Serviser", "Racunovodstvo"}));
		if(k.getTip_korisnika().getNaziv().equals("Serviser")) comboBox.setSelectedIndex(0);
		else comboBox.setSelectedIndex(1);
		centralniPanel.add(comboBox);
		
		 final Validacija v = new Validacija();
			
			//Validacija imena
		
			 imeTxt.addFocusListener(
			          new FocusListener() {
			             public void focusGained(FocusEvent e) {};

			             public void focusLost(FocusEvent e) {
//			            	 validacija v = new validacija();
			            	 uslov1 = v.minimalnaDuzina(imeTxt, 3);
			            	 uslov12 = v.validirajString(imeTxt);
			             }
			      });
			 
			 //Validacija prezime
			 
			prezimeTxt.addFocusListener(
			          new FocusListener() {
				             public void focusGained(FocusEvent e) {};

				             public void focusLost(FocusEvent e) {
//				            	 validacija v = new validacija();
				            	 uslov2=v.minimalnaDuzina(prezimeTxt, 3);
				            	 uslov13 = v.validirajString(prezimeTxt);
				            	 
				             }
				      });
			
			//Validacija JMBG
			
			jmbgTxt.addFocusListener(
			          new FocusListener() {
				             public void focusGained(FocusEvent e) {};

				             public void focusLost(FocusEvent e) {
//				            	 validacija v = new validacija();
				            	 uslov3=v.JMBG(jmbgTxt);
				            	 uslov8=v.jedinstvenJMBGM(jmbgTxt, id);
				             }
				      });
			
			//Validacija broja lične karte
			
			brojLKTxt.addFocusListener(
			          new FocusListener() {
				             public void focusGained(FocusEvent e) {};

				             public void focusLost(FocusEvent e) {
//				            	 validacija v = new validacija();
				            	 uslov4=v.brojLicneKarte(brojLKTxt);
				            	 
				             }
				      });
			
			
			//Validacija adrese
			
			adresaTxt.addFocusListener(
			          new FocusListener() {
				             public void focusGained(FocusEvent e) {};

				             public void focusLost(FocusEvent e) {
//				            	 validacija v = new validacija();
				            	 uslov5=v.minimalnaDuzina(adresaTxt, 3);
				            	 uslov14=v.validirajAdresuBrojevi(adresaTxt);
				             }
				      });
			
			//Validacija telefona
			
			telefonTxt.addFocusListener(
			          new FocusListener() {
				             public void focusGained(FocusEvent e) {};

				             public void focusLost(FocusEvent e) {
//				            	 validacija v = new validacija();
				            	 uslov6=v.brojTelefona(telefonTxt);
				             }
				      });
			
			//Validacija email-a
			
			emailTxt.addFocusListener(
			          new FocusListener() {
				             public void focusGained(FocusEvent e) {};

				             public void focusLost(FocusEvent e) {
//				            	 validacija v = new validacija();
				            	 uslov7=v.emailAdresa(emailTxt);
				            	 uslov15=v.jedinstvenEmail(emailTxt);
				             }
				      });
			
			
			
			//Validacija korisni�kog imena
			
			korisnickoImeTxt.addFocusListener(
			          new FocusListener() {
				             public void focusGained(FocusEvent e) {};

				             public void focusLost(FocusEvent e) {
				             uslov10=v.minimalnaDuzina(korisnickoImeTxt, 3);
				             uslov9=v.jedinstvenUsernameM(korisnickoImeTxt, id);
			             }
			      });
			
			
		
		JButton modifikujBtn = new JButton("Modifikuj");
		modifikujBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						 TipKorisnika ti= null;
						 if(comboBox.getSelectedItem()=="Serviser")
						 {
							 TipKorisnikaDAO ka = new TipKorisnikaDAO();
							 ti=ka.getById(2);
						 }
						 else if(comboBox.getSelectedItem()=="Racunovodstvo")
						 {
							 TipKorisnikaDAO ka = new TipKorisnikaDAO();
							 ti=ka.getById(1);
						 }
						KorisnikKontroler kKontroler = new KorisnikKontroler();
						if(pocetniDatumDP.getJFormattedTextField().getText().equals(k.getDatum_zaposlenja().toString())) izmjena=false;
						else izmjena =true;
						if(kKontroler.modifikacijaKorisnika(izmjena, imeTxt, prezimeTxt,  jmbgTxt, brojLKTxt,  adresaTxt, telefonTxt,emailTxt, sqlDate1 ,  korisnickoImeTxt,  sifraTxt, id,ti)) {
 						dispose();	 						
 						JOptionPane.showMessageDialog(frmKreiranjeKorisnika,
 							    "Korisnik je uspješno modifikovan.",
 							    "Modifikovanje korisnika",
 							    JOptionPane.INFORMATION_MESSAGE);				
						}
						else {
 						JOptionPane.showMessageDialog(frmKreiranjeKorisnika,
 							    "Da biste spremili podatke u bazu morate unijeti ispravne podatke u oznacenim poljima.",
 							    "Greška",
 							    JOptionPane.ERROR_MESSAGE);
						}
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
		ModifikacijaKorisnikaGUI.unistiInstancu();
		super.dispose();
	}

}
