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

public class PrikaziDetaljnoZadatakGUI extends JFrame{

	private static final long serialVersionUID = 1L;

public PrikaziDetaljnoZadatakGUI(RadniZadatak zadatak, List<String> naziviServisera) {
		
	JPanel centralniPanel = new JPanel();
	centralniPanel.setBackground(Color.WHITE);
	centralniPanel.setLayout(new GridLayout(9,2,2,2));
	
	JLabel IDLbl = new JLabel(" ID:"+zadatak.getRadniZadatak_id());
	IDLbl.setHorizontalAlignment(SwingConstants.LEFT);
	IDLbl.setBackground(Color.WHITE);
	JLabel lblIDUnos = new JLabel("");
	lblIDUnos.setOpaque(true);
	lblIDUnos.setForeground(Color.BLACK);
	lblIDUnos.setBackground(Color.WHITE);
	centralniPanel.add(IDLbl);
	centralniPanel.add(lblIDUnos);
	
	JLabel vrstaRadnogZadatkaLbl = new JLabel(" Vrsta radnog zadatka: "+zadatak.getVrstaZadatka());
	vrstaRadnogZadatkaLbl.setHorizontalAlignment(SwingConstants.LEFT);
	JLabel lblVrstaRadnogZadatkaUnos = new JLabel("");
	lblVrstaRadnogZadatkaUnos.setOpaque(true);
	lblVrstaRadnogZadatkaUnos.setBackground(Color.WHITE);
	centralniPanel.add(vrstaRadnogZadatkaLbl);
	centralniPanel.add(lblVrstaRadnogZadatkaUnos);
	
	JLabel klijentLbl = new JLabel(" Klijent: "+zadatak.getKlijent().getNaziv());
	klijentLbl.setHorizontalAlignment(SwingConstants.LEFT);
	JLabel lblKlijentUnos = new JLabel("");
	lblKlijentUnos.setBackground(Color.WHITE);
	lblKlijentUnos.setOpaque(true);
	centralniPanel.add(klijentLbl);
	centralniPanel.add(lblKlijentUnos);
			
	JLabel krajnjiDatumLbl = new JLabel(" Krajnji datum za izvršenje: "+zadatak.getKrajnjiDatumIzvrsenja());
	krajnjiDatumLbl.setHorizontalAlignment(SwingConstants.LEFT);
	JLabel lblKrajnjiDatumUnos = new JLabel("");
	lblKrajnjiDatumUnos.setBackground(Color.WHITE);
	lblKrajnjiDatumUnos.setOpaque(true);
	centralniPanel.add(krajnjiDatumLbl);
	centralniPanel.add(lblKrajnjiDatumUnos);
	
	JLabel maksimalniBrojServiseraLbl = new JLabel(" Maksimalni broj servisera: "+zadatak.getBrojServisera());
	maksimalniBrojServiseraLbl.setHorizontalAlignment(SwingConstants.LEFT);
	JLabel lblMaksimalniBrojServiseraUnos = new JLabel("");
	lblMaksimalniBrojServiseraUnos.setBackground(Color.WHITE);
	lblMaksimalniBrojServiseraUnos.setOpaque(true);
	centralniPanel.add(maksimalniBrojServiseraLbl);
	centralniPanel.add(lblMaksimalniBrojServiseraUnos);		
	
	JLabel statusODodjeljenostiLbl = new JLabel(" Status o dodijeljenosti: "+zadatak.getStatusDodjeljenosti());
	statusODodjeljenostiLbl.setHorizontalAlignment(SwingConstants.LEFT);
	JLabel lblStatusODodjeljenostiUnos = new JLabel("");
	lblStatusODodjeljenostiUnos.setBackground(Color.WHITE);
	lblStatusODodjeljenostiUnos.setOpaque(true);
	centralniPanel.add(statusODodjeljenostiLbl);
	centralniPanel.add(lblStatusODodjeljenostiUnos);
	
	JLabel statusOIzvrenostiLbl = new JLabel(" Status o izvršenosti: "+zadatak.getStatusIzvrsenosti());
	statusOIzvrenostiLbl.setHorizontalAlignment(SwingConstants.LEFT);
	JLabel lblStatusOIzvrenostiUnos = new JLabel("");
	lblStatusOIzvrenostiUnos.setBackground(Color.WHITE);
	lblStatusOIzvrenostiUnos.setOpaque(true);
	centralniPanel.add(statusOIzvrenostiLbl);
	centralniPanel.add(lblStatusOIzvrenostiUnos);
		
	JLabel serviserLbl = new JLabel(" Serviser(i): "+naziviServisera);
	serviserLbl.setHorizontalAlignment(SwingConstants.LEFT);
	JLabel lblServiserUnos = new JLabel("");
	lblServiserUnos.setBackground(Color.WHITE);
	lblServiserUnos.setOpaque(true);
	centralniPanel.add(serviserLbl);
	centralniPanel.add(lblServiserUnos);
		
	JLabel opisLbl = new JLabel(" Opis: "+zadatak.getOpis());
	centralniPanel.add(opisLbl);
	JLabel lblOpisUnos = new JLabel("");
	lblOpisUnos.setBackground(Color.WHITE);
	lblOpisUnos.setOpaque(true);
	centralniPanel.add(lblOpisUnos);
		
	JPanel juzniPanel = new JPanel();
	juzniPanel.setBorder(BorderFactory.createEmptyBorder(2, 1, 2, 1));
	juzniPanel.setLayout(new GridLayout(1,2,1,1));
	JLabel lblPrazna=new JLabel("");
	juzniPanel.add(lblPrazna);
	
	
	
	getContentPane().add(centralniPanel, BorderLayout.CENTER);
	getContentPane().add(juzniPanel, BorderLayout.SOUTH);
	}
}
