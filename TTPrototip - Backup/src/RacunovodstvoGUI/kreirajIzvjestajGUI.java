package RacunovodstvoGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;




public class kreirajIzvjestajGUI extends JFrame {
	public kreirajIzvjestajGUI() {
		setTitle("Kreiraj izvještaj");
		
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
		JMenuItem korisnickoUputstvoItem = new JMenuItem("Korisnièko upustvo");
		pomocMenu.add(korisnickoUputstvoItem);
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
		pomocMenu.add(oNamaItem);		
		
		JPanel centralniPanel = new JPanel();
		centralniPanel.setLayout(new GridLayout(3,4,2,2));
		
		JLabel vrstaIzvjestajaLbl = new JLabel("Vrsta izvještaja:");
		vrstaIzvjestajaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		JComboBox vrstaIzvjestajaCmbx = new JComboBox();
		vrstaIzvjestajaCmbx.setModel(new DefaultComboBoxModel(new String[] {"Po vrsti posla", "Po radniku", "Po klijentu", "Sumarni izvjestaj"}));
		JLabel prazna1Lbl = new JLabel("");
		JLabel prazna2Lbl = new JLabel("");
		JLabel pocetniDatumLbl = new JLabel("Za period od:");
		pocetniDatumLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JTextField pocetniDatumTxt = new JTextField();
		JLabel krajnjiDatumLbl = new JLabel("do:");
		krajnjiDatumLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JTextField krajnjiDatumTxt = new JTextField();
		JLabel unosLbl = new JLabel("Odaberite radnika:");
		unosLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JComboBox unosCmbx = new JComboBox();
		unosCmbx.setModel(new DefaultComboBoxModel(new String[] {"Miki Maus", "Paja Patak"}));
		JLabel prazna3Lbl = new JLabel("");
		JLabel prazna4Lbl= new JLabel("");
		
		centralniPanel.add(vrstaIzvjestajaLbl);
		centralniPanel.add(vrstaIzvjestajaCmbx);
		centralniPanel.add(prazna1Lbl);
		centralniPanel.add(prazna2Lbl);
		centralniPanel.add(pocetniDatumLbl);
		centralniPanel.add(pocetniDatumTxt);
		centralniPanel.add(krajnjiDatumLbl);
		centralniPanel.add(krajnjiDatumTxt);
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
		juzniPanel.add(odustaniBtn);
		JButton kreirajBtn = new JButton("Kreiraj izvještaj");
		kreirajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                prikazIzvjestajaGUI ex = new prikazIzvjestajaGUI();
		                ex.setTitle("Izvještaj");
		                ex.setSize(600, 350);
		                ex.setLocationRelativeTo(null);
		                ex.setVisible(true);
		            }
		        });
			}
		});
		juzniPanel.add(kreirajBtn);
		juzniPanel.add(prazna6Lbl);
				getContentPane().add(juzniPanel, BorderLayout.SOUTH);
}
}
