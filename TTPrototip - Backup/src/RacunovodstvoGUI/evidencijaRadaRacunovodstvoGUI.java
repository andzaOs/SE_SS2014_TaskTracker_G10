package RacunovodstvoGUI;

import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;


public class evidencijaRadaRacunovodstvoGUI extends JFrame{
	public evidencijaRadaRacunovodstvoGUI() {
		setTitle("Pregled evidencije rada");

	
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
	
	JMenuItem SistemObavjestavanjaItem = new JMenuItem("Sistem obavje\u0161tavanja");
	SistemObavjestavanjaItem.addActionListener(new ActionListener() {
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
	alatiMenu.add(SistemObavjestavanjaItem);
	
	JMenu pomocMenu = new JMenu("Pomo\u0107");
	menuBar.add(pomocMenu);
	
	JMenuItem korisnikoUpustvoItem = new JMenuItem("Korisni\u010Dko upustvo");
	pomocMenu.add(korisnikoUpustvoItem);
	
	JMenuItem oNamaItem = new JMenuItem("O nama");
	pomocMenu.add(oNamaItem);
	
	JPanel centralniPanel = new JPanel();
	centralniPanel.setLayout(new GridLayout(2,1,0,0));
	
	final JPanel filterPanel1 = new JPanel();
	final JPanel filterPanel2 = new JPanel();
	filterPanel1.setLayout(new GridLayout(1,6,1,1));
	filterPanel2.setLayout(new GridLayout(1,6,1,1));
		
	JLabel imePrezimeLbl= new JLabel("Ime i prezime servisera:");
	imePrezimeLbl.setHorizontalAlignment(SwingConstants.RIGHT);
	JLabel vrstaUslugeLbl= new JLabel("Vrsta usluge");
	vrstaUslugeLbl.setHorizontalAlignment(SwingConstants.RIGHT);
	JLabel periodLbl = new JLabel("Za period od:");
	periodLbl.setHorizontalAlignment(SwingConstants.RIGHT);
	JLabel datumIzvrsenjaLbl= new JLabel("do:");
	datumIzvrsenjaLbl.setHorizontalAlignment(SwingConstants.RIGHT);
	
	JTextField imePrezimeTxt = new JTextField();
	JTextField jmbgTxt = new JTextField();
	JTextField vrstaUslugeTxt = new JTextField();
	JTextField periodTxt = new JTextField();
	JTextField datumIzvrsenjaTxt = new JTextField();
	JTextField na = new JTextField();
	
	filterPanel1.add(imePrezimeLbl);
	filterPanel1.add(imePrezimeTxt);
	JLabel jmbgLbl= new JLabel("JMBG servisera:");
	filterPanel1.add(jmbgLbl);
	jmbgLbl.setHorizontalAlignment(SwingConstants.RIGHT);
	filterPanel1.add(jmbgTxt);
	filterPanel1.add(vrstaUslugeLbl);
	filterPanel1.add(vrstaUslugeTxt);
	filterPanel2.add(periodLbl);
	filterPanel2.add(periodTxt);	
	filterPanel2.add(datumIzvrsenjaLbl);
	filterPanel2.add(datumIzvrsenjaTxt);
	JLabel nazivLbl= new JLabel("Naziv klijenta:");
	filterPanel2.add(nazivLbl);
	nazivLbl.setHorizontalAlignment(SwingConstants.RIGHT);
	filterPanel2.add(na);	
	
	final JPanel filterPanel3 = new JPanel();
	filterPanel3.setLayout(new GridLayout(1,6,1,1));
	JCheckBox chckbxNewCheckBox = new JCheckBox("Zadatak u procesiranju");
	chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.RIGHT);
	filterPanel3.add(chckbxNewCheckBox);
	
	JCheckBox chckbxNeizvren = new JCheckBox("Izvr\u0161en zadatak");
	chckbxNeizvren.setHorizontalAlignment(SwingConstants.RIGHT);
	filterPanel3.add(chckbxNeizvren);
	
	JLabel prazno4Lbl = new JLabel("");
	filterPanel3.add(prazno4Lbl);
	
	JLabel praznoLbl = new JLabel("");
	filterPanel3.add(praznoLbl);
	
	JLabel prazno1Lbl = new JLabel("");
	filterPanel3.add(prazno1Lbl);
	
	
	String imenaKolona[] = {"Vrsta zadatka", "Opis zadatka", "Status izvršenosti", "Klijent", "Serviser", "Vrsta usluge", "Utrošeno sati" };

	String podaci[][] =
	{
		{ "", "", "", "", "", "", "" },
		{ "", "", "", "", "", "", "" },
		{ "", "", "", "", "", "", "" },
		{ "", "", "", "", "", "", "" },
		{ "", "", "", "", "", "", "" },
		{ "", "", "", "", "", "", "" },
		{ "", "", "", "", "", "", "" },
	};
	
	JTable tabela = new JTable (podaci, imenaKolona);
	JScrollPane tabelaPane = new JScrollPane(tabela);
	
	JButton pretraziBtn = new JButton("Pretraga");
	pretraziBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	ImageIcon traziIkona = new ImageIcon(getClass().getResource("SearchIcon.png"));
	pretraziBtn.setIcon(traziIkona);
	
	filterPanel3.add(pretraziBtn);
	
	final JPanel sjeverniPanel = new JPanel();
	sjeverniPanel.setLayout(new GridLayout(3,1,2,2));
	
	
	sjeverniPanel.add(filterPanel1);
	sjeverniPanel.add(filterPanel2);
	sjeverniPanel.add(filterPanel3);

	
	centralniPanel.add(tabelaPane);
	centralniPanel.setLayout(new GridLayout(1,1,0,0));

	JPanel juzniPanel = new JPanel();
    JButton ureduBtn = new JButton("Uredu");
 
	
	juzniPanel.setBorder(BorderFactory.createEmptyBorder(2, 1, 2, 1));
	juzniPanel.setLayout(new GridLayout(1,3,1,1));
	
	JButton evidencijaBtn = new JButton("Evidencija rada na zadatku");
	
	JLabel prazno3Lbl = new JLabel("");
	juzniPanel.add(prazno3Lbl);
	
	JLabel prazno2Lbl = new JLabel("");
	juzniPanel.add(prazno2Lbl);
	
	juzniPanel.add(ureduBtn);
	
	getContentPane().add(sjeverniPanel, BorderLayout.NORTH);
	getContentPane().add(centralniPanel, BorderLayout.CENTER);
	getContentPane().add(juzniPanel, BorderLayout.SOUTH);
	
}
	
	
	
}
