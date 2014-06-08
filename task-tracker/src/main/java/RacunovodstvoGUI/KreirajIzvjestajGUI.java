package RacunovodstvoGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

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

import DAO.TipKorisnikaDAO;
import Entity.Korisnik;
import Entity.TipKorisnika;
import Kontroleri.IzvjestajKontroler;
import UtilClasses.KorisnickoUputstvo;
import UtilClasses.Validacija;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;


public class KreirajIzvjestajGUI extends JFrame {
	
	private IzvjestajKontroler ik = new IzvjestajKontroler();
		
	public KreirajIzvjestajGUI() {
		setTitle("Kreiraj izvještaj");
		
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
		JMenuItem korisnickoUputstvoItem = new JMenuItem("Korisni\u010Dko uputstvo");
		korisnickoUputstvoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KorisnickoUputstvo kp = new KorisnickoUputstvo();
				kp.dobaviUputstvo();
			}
		});
		pomocMenu.add(korisnickoUputstvoItem);
		
		JPanel centralniPanel = new JPanel();
		centralniPanel.setLayout(new GridLayout(3,4,2,2));
		
		JLabel pocetniDatumLbl = new JLabel("Za period od:");
		pocetniDatumLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		
		UtilDateModel model = new UtilDateModel();
		final JDatePanelImpl datePanel = new JDatePanelImpl(model);
		final JDatePickerImpl pocetniDatumDP = new JDatePickerImpl(datePanel);

		
		JLabel krajnjiDatumLbl = new JLabel("do:");
		krajnjiDatumLbl.setHorizontalAlignment(SwingConstants.RIGHT);

		UtilDateModel model1 = new UtilDateModel();
		final JDatePanelImpl datePanel1 = new JDatePanelImpl(model1);
		final JDatePickerImpl krajnjiDatumDP = new JDatePickerImpl(datePanel1);
		
		final JLabel unosLbl = new JLabel("Odaberite posao:");
		unosLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		final JComboBox unosCmbx = new JComboBox();
		unosCmbx.setModel(new DefaultComboBoxModel(new String[] {"", ""}));
		
		JLabel vrstaIzvjestajaLbl = new JLabel("Vrsta izvještaja:");
		vrstaIzvjestajaLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		final JComboBox vrstaIzvjestajaCmbx = new JComboBox();
		vrstaIzvjestajaCmbx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
		            @SuppressWarnings("unchecked")
					public void run() {
		               		               
						try {
							ik.napuniUnosCmbx(vrstaIzvjestajaCmbx, unosCmbx, unosLbl);
						}
						catch(Exception e) {
							JOptionPane.showMessageDialog(rootPane,
								    "Greška. Pojavio se izuzetak.",
								    "Izuzetak",
								    JOptionPane.ERROR_MESSAGE);
							System.exit(DISPOSE_ON_CLOSE);
						}
		            	
		            }
		        });
			}
		});
		vrstaIzvjestajaCmbx.setModel(new DefaultComboBoxModel(new String[] {"Po radniku", "Po vrsti usluge", "Po klijentu", "Sumarni izvjestaj", "Detaljni izvjestaj"}));
		JLabel prazna1Lbl = new JLabel("");
		JLabel prazna2Lbl = new JLabel("");
		
		JLabel prazna3Lbl = new JLabel("");
		JLabel prazna4Lbl= new JLabel("");
		
		centralniPanel.add(vrstaIzvjestajaLbl);
		centralniPanel.add(vrstaIzvjestajaCmbx);
		centralniPanel.add(prazna1Lbl);
		centralniPanel.add(prazna2Lbl);
		centralniPanel.add(pocetniDatumLbl);
		centralniPanel.add(pocetniDatumDP);
		centralniPanel.add(krajnjiDatumLbl);
		centralniPanel.add(krajnjiDatumDP);
		centralniPanel.add(unosLbl);
		centralniPanel.add(unosCmbx);
		centralniPanel.add(prazna3Lbl);
		centralniPanel.add(prazna4Lbl);
		getContentPane().add(centralniPanel, BorderLayout.CENTER);
		
		JPanel juzniPanel = new JPanel();
		juzniPanel.setBorder(BorderFactory.createEmptyBorder(2, 1, 2, 1));
		juzniPanel.setLayout(new GridLayout(1,4,1,1));
		JLabel prazna5Lbl = new JLabel("");
		JLabel prazna6Lbl = new JLabel("");
		juzniPanel.add(prazna5Lbl);
		JButton odustaniBtn = new JButton("Odustani");
		odustaniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		juzniPanel.add(odustaniBtn);
		JButton kreirajBtn = new JButton("Kreiraj izvještaj");
		kreirajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                	
		            	if (pocetniDatumDP.getModel().getValue() != null && krajnjiDatumDP.getModel().getValue() != null) {
			            	Date d1 = (Date) pocetniDatumDP.getModel().getValue();
			            	Date d2 = (Date) krajnjiDatumDP.getModel().getValue();
			            	if(d1.after(d2) || d1.equals(d2)) {
			            		JOptionPane.showMessageDialog(rootPane,
									    "Molimo Vas da prvi datum bude manji od drugog.",
									    "Obavijest",
									    JOptionPane.ERROR_MESSAGE);
			            	} else if (unosCmbx.getSelectedIndex() == -1 && unosCmbx.isVisible() == true ) {
								JOptionPane.showMessageDialog(rootPane,
									    "Greška. Niste izabrali sve parametre.",
									    "Obavijest",
									    JOptionPane.ERROR_MESSAGE);
			            	} 
			            	else {
								try {
									//System.out.println(unosCmbx.getSelected());
									ik.otvoriFormu(unosCmbx, vrstaIzvjestajaCmbx.getSelectedItem().toString(), d1, d2);
								}
								catch(Exception e) {
									JOptionPane.showMessageDialog(rootPane,
										    "Greška. Pojavio se izuzetak.",
										    "Izuzetak",
										    JOptionPane.ERROR_MESSAGE);
									System.exit(DISPOSE_ON_CLOSE);
								}
			            	}
		            	} else {
							JOptionPane.showMessageDialog(rootPane,
								    "Molimo Vas da izaberete opseg datuma.",
								    "Obavijest",
								    JOptionPane.ERROR_MESSAGE);
		            	}
		            			            	
		            }
		        });
			}
		});
		juzniPanel.add(kreirajBtn);
		juzniPanel.add(prazna6Lbl);
		getContentPane().add(juzniPanel, BorderLayout.SOUTH);
		
		try {
			ik.napuniUnosCmbx(vrstaIzvjestajaCmbx, unosCmbx, unosLbl);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(rootPane,
				    "Greška. Pojavio se izuzetak.",
				    "Izuzetak",
				    JOptionPane.ERROR_MESSAGE);
			System.exit(DISPOSE_ON_CLOSE);
		}
							
}
	

	
}

