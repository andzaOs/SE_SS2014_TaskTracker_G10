package RacunovodstvoGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Entity.RadniZadatak;
import Kontroleri.RadniZadaciRacunovodstvoControler;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class PrikaziDetaljnoZadatakGUI extends JFrame{

	private static final long serialVersionUID = 1L;
	private static PrikaziDetaljnoZadatakGUI instanca;

	public static PrikaziDetaljnoZadatakGUI dajInstancu(RadniZadatak zadatak, List<String> naziviServisera) {
		if(instanca==null) {
			instanca=new PrikaziDetaljnoZadatakGUI(zadatak, naziviServisera);
			
		}
		return instanca;
	}
public static void unistiInstancu() { instanca= null; }

public PrikaziDetaljnoZadatakGUI(RadniZadatak zadatak, List<String> naziviServisera) {
	
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	JPanel centralniPanel = new JPanel();
	centralniPanel.setBackground(Color.WHITE);
	centralniPanel.setLayout(new GridLayout(9,2,2,2));
	
	JLabel IDLbl = new JLabel(" ID: ");
	IDLbl.setHorizontalAlignment(SwingConstants.RIGHT);
	IDLbl.setBackground(Color.WHITE);
	JLabel lblIDUnos = new JLabel(""+zadatak.getRadniZadatak_id());
	lblIDUnos.setHorizontalAlignment(SwingConstants.LEFT);
	lblIDUnos.setOpaque(true);
	lblIDUnos.setForeground(Color.BLACK);
	lblIDUnos.setBackground(Color.WHITE);
	centralniPanel.add(IDLbl);
	centralniPanel.add(lblIDUnos);
	
	JLabel vrstaRadnogZadatkaLbl = new JLabel(" Vrsta radnog zadatka: ");
	vrstaRadnogZadatkaLbl.setHorizontalAlignment(SwingConstants.RIGHT);
	JLabel lblVrstaRadnogZadatkaUnos = new JLabel(""+zadatak.getVrstaZadatka());
	lblVrstaRadnogZadatkaUnos.setOpaque(true);
	lblVrstaRadnogZadatkaUnos.setBackground(Color.WHITE);
	centralniPanel.add(vrstaRadnogZadatkaLbl);
	centralniPanel.add(lblVrstaRadnogZadatkaUnos);
	
	JLabel klijentLbl = new JLabel(" Klijent: ");
	klijentLbl.setHorizontalAlignment(SwingConstants.RIGHT);
	JLabel lblKlijentUnos = new JLabel(""+zadatak.getKlijent().getNaziv());
	lblKlijentUnos.setBackground(Color.WHITE);
	lblKlijentUnos.setOpaque(true);
	centralniPanel.add(klijentLbl);
	centralniPanel.add(lblKlijentUnos);
			
	JLabel krajnjiDatumLbl = new JLabel(" Krajnji datum za izvršenje: ");
	krajnjiDatumLbl.setHorizontalAlignment(SwingConstants.RIGHT);
	JLabel lblKrajnjiDatumUnos = new JLabel(""+zadatak.getKrajnjiDatumIzvrsenja());
	lblKrajnjiDatumUnos.setBackground(Color.WHITE);
	lblKrajnjiDatumUnos.setOpaque(true);
	centralniPanel.add(krajnjiDatumLbl);
	centralniPanel.add(lblKrajnjiDatumUnos);
	
	JLabel maksimalniBrojServiseraLbl = new JLabel(" Maksimalni broj servisera: ");
	maksimalniBrojServiseraLbl.setHorizontalAlignment(SwingConstants.RIGHT);
	JLabel lblMaksimalniBrojServiseraUnos = new JLabel(""+zadatak.getBrojServisera());
	lblMaksimalniBrojServiseraUnos.setBackground(Color.WHITE);
	lblMaksimalniBrojServiseraUnos.setOpaque(true);
	centralniPanel.add(maksimalniBrojServiseraLbl);
	centralniPanel.add(lblMaksimalniBrojServiseraUnos);		
	
	JLabel statusODodjeljenostiLbl = new JLabel(" Status o dodijeljenosti: ");
	statusODodjeljenostiLbl.setHorizontalAlignment(SwingConstants.RIGHT);
	JLabel lblStatusODodjeljenostiUnos = new JLabel(""+zadatak.getStatusDodjeljenosti());
	lblStatusODodjeljenostiUnos.setBackground(Color.WHITE);
	lblStatusODodjeljenostiUnos.setOpaque(true);
	centralniPanel.add(statusODodjeljenostiLbl);
	centralniPanel.add(lblStatusODodjeljenostiUnos);
	
	JLabel statusOIzvrenostiLbl = new JLabel(" Status o izvršenosti: ");
	statusOIzvrenostiLbl.setHorizontalAlignment(SwingConstants.RIGHT);
	JLabel lblStatusOIzvrenostiUnos = new JLabel(""+zadatak.getStatusIzvrsenosti());
	lblStatusOIzvrenostiUnos.setBackground(Color.WHITE);
	lblStatusOIzvrenostiUnos.setOpaque(true);
	centralniPanel.add(statusOIzvrenostiLbl);
	centralniPanel.add(lblStatusOIzvrenostiUnos);
	
	RadniZadaciRacunovodstvoControler r = new RadniZadaciRacunovodstvoControler();
	JLabel serviserLbl = new JLabel(" Serviser(i): ");
	serviserLbl.setHorizontalAlignment(SwingConstants.RIGHT);
	JLabel lblServiserUnos = new JLabel(""+r.getNazivServisera(zadatak));
	lblServiserUnos.setBackground(Color.WHITE);
	lblServiserUnos.setOpaque(true);
	centralniPanel.add(serviserLbl);
	centralniPanel.add(lblServiserUnos);
		
	JLabel opisLbl = new JLabel(" Opis: ");
	opisLbl.setHorizontalAlignment(SwingConstants.RIGHT);
	centralniPanel.add(opisLbl);
		
	JPanel juzniPanel = new JPanel();
	juzniPanel.setBorder(BorderFactory.createEmptyBorder(2, 1, 2, 1));
	juzniPanel.setLayout(new GridLayout(1,2,1,1));
	JLabel lblPrazna=new JLabel("");
	juzniPanel.add(lblPrazna);
	
	
	
	getContentPane().add(centralniPanel, BorderLayout.CENTER);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	centralniPanel.add(scrollPane);
	
	JTextArea textAreaOpis = new JTextArea();
	textAreaOpis.setText(""+zadatak.getOpis());
	textAreaOpis.setRows(10);
	textAreaOpis.setEditable(false);
	textAreaOpis.setColumns(1);
	scrollPane.setViewportView(textAreaOpis);
	getContentPane().add(juzniPanel, BorderLayout.SOUTH);
	}
	@Override
	public void dispose() {
	// TODO Auto-generated method stub
	unistiInstancu();
	super.dispose();
}
}
