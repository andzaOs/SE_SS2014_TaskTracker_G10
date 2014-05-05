package RacunovodstvoGUI;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class kreiranjeKorisnikaGUI extends JFrame {
	private JFrame frmKreiranjeKorisnika;

	public kreiranjeKorisnikaGUI() {
		initialize();
	}

	private void initialize() {
		
		setTitle("Kreiranje novog korisnika");
		frmKreiranjeKorisnika = new JFrame();
		frmKreiranjeKorisnika.setTitle("Kreiranje novog korisnika");
		frmKreiranjeKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);		
		JMenu mojRacunMenu = new JMenu("Moj ra\u010Dun");
		menuBar.add(mojRacunMenu);
		JMenuItem promijeniSifruItem = new JMenuItem("Promijeni \u0161ifru");
		mojRacunMenu.add(promijeniSifruItem);		
		JMenuItem odjaviSeItem = new JMenuItem("Odjavi se");
		odjaviSeItem.addActionListener(new ActionListener() {
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
		mojRacunMenu.add(odjaviSeItem);
		
		JMenu alatiMenu = new JMenu("Alati");
		menuBar.add(alatiMenu);		
		JMenuItem sistemObavjetavanjaItem = new JMenuItem("Sistem obavje\u0161tavanja");
		alatiMenu.add(sistemObavjetavanjaItem);
		
		JMenu oNamaMenu = new JMenu("Pomo\u0107");
		menuBar.add(oNamaMenu);		
		JMenuItem korisnikoUputstvoItem = new JMenuItem("Korisni\u010Dko upustvo");
		oNamaMenu.add(korisnikoUputstvoItem);		
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
		oNamaMenu.add(oNamaItem);
		
		JPanel centralniPanel = new JPanel();
		centralniPanel.setLayout(new GridLayout(11,2,2,2));
		
		JLabel imeLbl = new JLabel("Ime*:");
		imeLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JTextField imeTxt = new JTextField();
		centralniPanel.add(imeLbl);
		centralniPanel.add(imeTxt);
		
		JLabel prezimeLbl = new JLabel("Prezime*:");
		prezimeLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JTextField prezimeTxt = new JTextField();
		centralniPanel.add(prezimeLbl);
		centralniPanel.add(prezimeTxt);
				
		JLabel jmbgLbl = new JLabel("JMBG*:");
		jmbgLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JTextField jmbgTxt = new JTextField();
		centralniPanel.add(jmbgLbl);
		centralniPanel.add(jmbgTxt);
		
		JLabel brojLKLbl = new JLabel("Broj liène karte:");
		brojLKLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JTextField brojLKTxt = new JTextField();
		centralniPanel.add(brojLKLbl);
		centralniPanel.add(brojLKTxt);		
		
		JLabel adresaLbl = new JLabel("Adresa:");
		adresaLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JTextField adresaTxt = new JTextField();
		centralniPanel.add(adresaLbl);
		centralniPanel.add(adresaTxt);	
		
		JLabel telefonLbl = new JLabel("Telefon:");
		telefonLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JTextField telefonTxt = new JTextField();
		centralniPanel.add(telefonLbl);
		centralniPanel.add(telefonTxt);	
		
		JLabel emailLbl = new JLabel("E-mail:");
		emailLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JTextField emailTxt = new JTextField();
		centralniPanel.add(emailLbl);
		centralniPanel.add(emailTxt);	
		
		JLabel datumZaposlenjaLbl = new JLabel("Datum zaposlenja:");
		datumZaposlenjaLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JTextField datumZaposlenjaTxt = new JTextField();
		centralniPanel.add(datumZaposlenjaLbl);
		centralniPanel.add(datumZaposlenjaTxt);	
		
		JLabel korisnickoImeLbl = new JLabel("Korisnicko ime:");
		korisnickoImeLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JTextField korisnickoImeTxt = new JTextField();
		centralniPanel.add(korisnickoImeLbl);
		centralniPanel.add(korisnickoImeTxt);	
		
		JLabel sifraLbl = new JLabel("Šifra:");
		sifraLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JTextField sifraTxt = new JTextField();
		centralniPanel.add(sifraLbl);
		centralniPanel.add(sifraTxt);	

		JLabel tipKorisnikaLbl = new JLabel("Tip korisnika:");
		tipKorisnikaLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JTextField tipKorisnikaTxt = new JTextField();
		centralniPanel.add(tipKorisnikaLbl);
		centralniPanel.add(tipKorisnikaTxt);
		
		JPanel juzniPanel = new JPanel();
		juzniPanel.setBorder(BorderFactory.createEmptyBorder(2, 1, 2, 1));
		juzniPanel.setLayout(new GridLayout(1,2,1,1));
		JButton kreirajBtn = new JButton("Kreiraj");
		JButton odustaniBtn = new JButton("Odustani");
		juzniPanel.add(odustaniBtn);
		juzniPanel.add(kreirajBtn);
		
		
		getContentPane().add(centralniPanel, BorderLayout.CENTER);
		getContentPane().add(juzniPanel, BorderLayout.SOUTH);
	}

}
