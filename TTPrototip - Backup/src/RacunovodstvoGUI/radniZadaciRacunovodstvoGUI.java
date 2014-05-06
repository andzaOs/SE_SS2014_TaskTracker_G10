package RacunovodstvoGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;


public class radniZadaciRacunovodstvoGUI extends JFrame{
	public radniZadaciRacunovodstvoGUI() {
	setTitle("Upravljanje radnim zadacima");
	
	JMenuBar glavniMenuBar = new JMenuBar();
	setJMenuBar(glavniMenuBar);
	
	JMenu mojRacunMenu = new JMenu("Moj raèun");
	glavniMenuBar.add(mojRacunMenu);
	JMenuItem promijeniSifruItem = new JMenuItem("Promijeni šifru");
	promijeniSifruItem.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						JFrame frmPromjenaifre = new JFrame();
						promjenaSifreGUI window = new promjenaSifreGUI(frmPromjenaifre);
						
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
					odjaviSeGUI ex = new odjaviSeGUI();
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
					sistemObavještavanjaGUI ex = new sistemObavještavanjaGUI();
					ex.setVisible(true);
				}
			});
		}
	});
	alatiMenu.add(sistemObavjestavanjaItem);
	
	JMenu pomocMenu = new JMenu("Pomoæ");
	glavniMenuBar.add(pomocMenu);		
	JMenuItem oNamaItem = new JMenuItem("O nama");
	oNamaItem.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                oNamaGUI ex = new oNamaGUI();
	                ex.setSize(300, 150);
	                ex.setLocationRelativeTo(null);
	                ex.setVisible(true);
	            }
	        });
		}
	});
	JMenuItem korisnickoUputstvoItem = new JMenuItem("Korisnièko upustvo");
	korisnickoUputstvoItem.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(rootPane, "Opcija æe ponuditi preuzimanje .pdf dokumenta sa korisnièkm uputstvom", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
		}
	});
	pomocMenu.add(korisnickoUputstvoItem);
	pomocMenu.add(oNamaItem);		
	
	JPanel centralniPanel = new JPanel();
	centralniPanel.setLayout(new GridLayout(2,1,0,0));
	
	JPanel filter1Panel = new JPanel();
	JPanel filter2Panel = new JPanel();
	filter1Panel.setLayout(new GridLayout(1,6,1,1));
	filter2Panel.setLayout(new GridLayout(1,6,1,1));
		
	JLabel imePrezimeLbl = new JLabel("Ime i prezime servisera:");
	imePrezimeLbl .setHorizontalAlignment(SwingConstants.RIGHT);
	JLabel nazivKlijentaLbl = new JLabel("Naziv klijenta:");
	nazivKlijentaLbl.setHorizontalAlignment(SwingConstants.RIGHT);
	JLabel datumKreiranjaLbl = new JLabel("Datum kreiranja:");
	datumKreiranjaLbl.setHorizontalAlignment(SwingConstants.RIGHT);
	JLabel datumDodjeleLbl = new JLabel("Datum dodjele:");
	datumDodjeleLbl.setHorizontalAlignment(SwingConstants.RIGHT);
	JLabel datumIzvrsenjaLbl = new JLabel("Datum izvršenja:");
	datumIzvrsenjaLbl.setHorizontalAlignment(SwingConstants.RIGHT);
	JLabel datumZavrsniLbl = new JLabel("Krajnji datum za izvršenje:");
	datumZavrsniLbl.setHorizontalAlignment(SwingConstants.RIGHT);
	
	JTextField imePrezimeTxt = new JTextField();
	JTextField nazivKlijentaTxt = new JTextField();
	JTextField datumKreiranjaTxt = new JTextField();
	JTextField datumDodjeleTxt = new JTextField();
	JTextField datumIzvrsenjaTxt = new JTextField();
	JTextField datumZavrsniTxt = new JTextField();
	
	filter1Panel.add(imePrezimeLbl);
	filter1Panel.add(imePrezimeTxt);
	filter1Panel.add(nazivKlijentaLbl);
	filter1Panel.add(nazivKlijentaTxt);
	filter1Panel.add(datumKreiranjaLbl);
	filter1Panel.add(datumKreiranjaTxt);
	filter2Panel.add(datumDodjeleLbl);
	filter2Panel.add(datumDodjeleTxt);	
	filter2Panel.add(datumIzvrsenjaLbl);
	filter2Panel.add(datumIzvrsenjaTxt);	
	filter2Panel.add(datumZavrsniLbl);
	filter2Panel.add(datumZavrsniTxt);	
	
	JPanel filter3Panel = new JPanel();
	filter3Panel.setLayout(new GridLayout(1,6,1,1));
	JCheckBox nedodjeljenZadatakChckbx = new JCheckBox("Nedodjeljen zadatak");
	nedodjeljenZadatakChckbx.setHorizontalAlignment(SwingConstants.RIGHT);
	filter3Panel.add(nedodjeljenZadatakChckbx);
	
	JCheckBox neizvrsenZadatakChckbx = new JCheckBox("Neizvršen zadatak");
	neizvrsenZadatakChckbx.setHorizontalAlignment(SwingConstants.RIGHT);
	filter3Panel.add(neizvrsenZadatakChckbx);
	
	JCheckBox neprihvacenZadatakChckbx = new JCheckBox("Neprihvaæen zadatak");
	neprihvacenZadatakChckbx.setHorizontalAlignment(SwingConstants.RIGHT);
	filter3Panel.add(neprihvacenZadatakChckbx);
	
	JLabel prazno1Lbl = new JLabel("");
	filter3Panel.add(prazno1Lbl);
	
	JLabel prazno2Lbl = new JLabel("");
	filter3Panel.add(prazno2Lbl);
	
	
	JToolBar glavniToolBar = new JToolBar();
	ImageIcon dodajIkona = new ImageIcon(getClass().getResource("AddIcon.png"));
	JButton kreirajBtn = new JButton(dodajIkona);
	kreirajBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                kreiranjeZadatkaGUI ex = new kreiranjeZadatkaGUI();
	                ex.setSize(400, 400);
	                ex.setLocationRelativeTo(null);
	                ex.setVisible(true);
	            }
	        });
		}
	});
	kreirajBtn.setText("Novi zadatak");
	glavniToolBar.add(kreirajBtn);
	JButton evidencijaBtn = new JButton("Evidencija rada");
	evidencijaBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                evidencijaRadaRacunovodstvoGUI f = new evidencijaRadaRacunovodstvoGUI();
	                f.setTitle("Evidencija rada");
	                f.setSize(1000, 450);
	                f.setLocationRelativeTo(null);
	                f.setVisible(true);
	            }
	     });
		}
	});
	ImageIcon tekstIkona = new ImageIcon(getClass().getResource("TextIcon.png"));
	evidencijaBtn.setIcon(tekstIkona);
	glavniToolBar.add(evidencijaBtn);
	
	String imenaKolona[] = {"Vrsta", "Opis", "Klijent", "Serviser(i)" };

	String podaci[][] =
	{
		{ "", "", "", "" },
		{ "", "", "", "" },
		{ "", "", "", "" },
		{ "", "", "", "" },
		{ "", "", "", "" }
		
	};
	
	JTable podaciTbl = new JTable (podaci, imenaKolona);
	JScrollPane tabelaPane = new JScrollPane(podaciTbl);
	
	JButton pretraziBtn = new JButton("Pretra\u017Ei");
	ImageIcon traziIkona = new ImageIcon(getClass().getResource("SearchIcon.png"));
	pretraziBtn.setIcon(traziIkona);
	
	filter3Panel.add(pretraziBtn);
	
	JPanel sjeverniPanel = new JPanel();
	sjeverniPanel.setLayout(new GridLayout(4,1,2,2));
	sjeverniPanel.add(glavniToolBar);
	
	sjeverniPanel.add(filter1Panel);
	sjeverniPanel.add(filter2Panel);
	sjeverniPanel.add(filter3Panel);
	
	centralniPanel.add(tabelaPane);
	centralniPanel.setLayout(new GridLayout(1,1,0,0));

	JPanel juzniPanel = new JPanel();
	JButton modifikujZadatakBtn = new JButton("Modifikuj zadatak");
	modifikujZadatakBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                modifikacijaZadatakGUI ex = new modifikacijaZadatakGUI();
	                ex.setSize(400, 400);
	                ex.setLocationRelativeTo(null);
	                ex.setVisible(true);
	            }
	        });
		}
	});
	JButton izbrisiZadatakBtn = new JButton("Izbriši zadatak");
	izbrisiZadatakBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                izbrisiZadatakGUI ex = new izbrisiZadatakGUI();
	                ex.setSize(600, 150);
	                ex.setLocationRelativeTo(null);
	                ex.setVisible(true);
	            }
	        });
		}
	});
	JButton dodijeliZadatakBtn = new JButton("Dodijeli zadatak");
	dodijeliZadatakBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
			 SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                odabirServiseraGUI f = new odabirServiseraGUI();
		                f.setTitle("Odabir servisera");
		                f.setSize(1000, 350);
		                f.setLocationRelativeTo(null);
		                
		                f.setVisible(true);
		            }
		     });
		}
	});
	JButton prikaziViseBtn = new JButton("Prikaži detaljno");
	prikaziViseBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                prikaziDetaljnoZadatakGUI ex = new prikaziDetaljnoZadatakGUI();
	                ex.setSize(400, 400);
	                ex.setTitle("Prikaz radnog zadatka");
	                ex.setLocationRelativeTo(null);
	                ex.setVisible(true);
	            }
	        });
		}
	});
	
	juzniPanel.setBorder(BorderFactory.createEmptyBorder(2, 1, 2, 1));
	juzniPanel.setLayout(new GridLayout(1,6,1,1));
	
	
	juzniPanel.add(prikaziViseBtn);
	juzniPanel.add(modifikujZadatakBtn);
	juzniPanel.add(dodijeliZadatakBtn);
	
	juzniPanel.add(izbrisiZadatakBtn);
	
	getContentPane().add(sjeverniPanel, BorderLayout.NORTH);
	getContentPane().add(centralniPanel, BorderLayout.CENTER);
	getContentPane().add(juzniPanel, BorderLayout.SOUTH);
	
}

	
}
