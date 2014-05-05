package RacunovodstvoGUI;


import java.awt.BorderLayout;
import java.awt.GridLayout;

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

public class modifikacijaZadatakGUI extends JFrame {

	private JFrame frmKreiranjeRadnogZadatka;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;



	public modifikacijaZadatakGUI() {
		initialize();
	}


	private void initialize() {
		
		setTitle("Modifikacija radnog zadatka");
		frmKreiranjeRadnogZadatka = new JFrame();
		frmKreiranjeRadnogZadatka.setTitle("Modifikovanje radnog zadatka");
		frmKreiranjeRadnogZadatka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mojRacunMenu = new JMenu("Moj ra\u010Dun");
		menuBar.add(mojRacunMenu);
		
		JMenuBar menuBar_1 = new JMenuBar();
		mojRacunMenu.add(menuBar_1);
		
		JMenuItem promijeniSifruItem = new JMenuItem("Promijeni \u0161ifru");
		mojRacunMenu.add(promijeniSifruItem);
		
		JMenuItem odjaviSeItem = new JMenuItem("Odjavi se");
		mojRacunMenu.add(odjaviSeItem);
		
		JMenu alatiMenu = new JMenu("Alati");
		menuBar.add(alatiMenu);
		
		JMenuItem sistemObavjetavanjaItem = new JMenuItem("Sistem obavje\u0161tavanja");
		alatiMenu.add(sistemObavjetavanjaItem);
		
		JMenu oNamaMenu = new JMenu("Pomo\u0107");
		menuBar.add(oNamaMenu);
		
		JMenuItem korisnikoUpustvoItem = new JMenuItem("Korisni\u010Dko upustvo");
		oNamaMenu.add(korisnikoUpustvoItem);
		
		JMenuItem oNamaItem = new JMenuItem("O nama");
		oNamaMenu.add(oNamaItem);
		
		JPanel centralniPanel = new JPanel();
		centralniPanel.setLayout(new GridLayout(9,2,2,2));
		
		JLabel vrstaRadnogZadatkaLbl = new JLabel("Vrsta radnog zadatka*:");
		vrstaRadnogZadatkaLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JComboBox vrstaZadatkaCmbx = new JComboBox();
		vrstaZadatkaCmbx.setModel(new DefaultComboBoxModel(new String[] {"Hardware", "Software"}));
		centralniPanel.add(vrstaRadnogZadatkaLbl);
		centralniPanel.add(vrstaZadatkaCmbx);
		
		JLabel klijentLbl = new JLabel("Klijent*:");
		klijentLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JTextField klijentTxt = new JTextField();
		centralniPanel.add(klijentLbl);
		centralniPanel.add(klijentTxt);
				
		JLabel krajnjiDatumLbl = new JLabel("Krajnji datum za izvršenje*:");
		krajnjiDatumLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JTextField datumTxt = new JTextField();
		centralniPanel.add(krajnjiDatumLbl);
		centralniPanel.add(datumTxt);
		
		JLabel maksimalniBrojServiseraLbl = new JLabel("Maksimalni broj servisera*:");
		maksimalniBrojServiseraLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JTextField maxBrojServiseraTxt = new JTextField();
		centralniPanel.add(maksimalniBrojServiseraLbl);
		centralniPanel.add(maxBrojServiseraTxt);		
		
		JLabel statusODodjeljenostiLbl = new JLabel("Status o dodijeljenosti:");
		statusODodjeljenostiLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JComboBox dodjeljenostCmbx = new JComboBox();
		dodjeljenostCmbx.setModel(new DefaultComboBoxModel(new String[] {"Nedodijeljen", "Dodijeljen"}));
		centralniPanel.add(statusODodjeljenostiLbl);
		centralniPanel.add(dodjeljenostCmbx);
		
		JLabel statusOIzvrsenostiLbl = new JLabel("Status o izvr\u0161enosti:");
		statusOIzvrsenostiLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JComboBox izvrsenostCmbx = new JComboBox();
		izvrsenostCmbx.setModel(new DefaultComboBoxModel(new String[] {"Nije izvr\u0161en", "Procesiranje ", "Izvr\u0161en"}));
		centralniPanel.add(statusOIzvrsenostiLbl);
		centralniPanel.add(izvrsenostCmbx);
		
		
		JLabel serviserLbl = new JLabel("Serviser(i):");
		serviserLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JComboBox serviserCmbx = new JComboBox<>();
		serviserCmbx.setModel(new DefaultComboBoxModel(new String[] {"Izaberi..", "Miki Maus", "Popaj", "Shrek"}));
		centralniPanel.add(serviserLbl);
		centralniPanel.add(serviserCmbx);
		
		JLabel lblPrazna = new JLabel("");
		JButton izmjeniBtn = new JButton("Izmjeni kolaboratore");
		centralniPanel.add(lblPrazna);
		centralniPanel.add(izmjeniBtn);
			
		JLabel opisLbl = new JLabel("Opis:");
		opisLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		centralniPanel.add(opisLbl);
		JTextField opisTxt = new JTextField();
		opisTxt.setColumns(10);
		centralniPanel.add(opisTxt);
		
		
		JPanel juzniPanel = new JPanel();
		juzniPanel.setBorder(BorderFactory.createEmptyBorder(2, 1, 2, 1));
		juzniPanel.setLayout(new GridLayout(1,2,1,1));
		JButton modifikujBtn = new JButton("Modifikuj");
		JButton odustaniBtn = new JButton("Odustani");
		juzniPanel.add(odustaniBtn);
		juzniPanel.add(modifikujBtn);
		
		
		getContentPane().add(centralniPanel, BorderLayout.CENTER);
		getContentPane().add(juzniPanel, BorderLayout.SOUTH);
	}

}
