package RacunovodstvoGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

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
import javax.swing.JSpinner;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import UtilClasses.Validacija;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.util.List;

import DAO.KlijentDAO;
import DAO.KorisnikDAO;
import DAO.RadniZadatakDAO;
import DAO.TipKorisnikaDAO;
import Entity.Klijent;
import Entity.Korisnik;
import Entity.RadniZadatak;
import Entity.TipKorisnika;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class KreiranjeZadatkaGUI extends JFrame {
	

	private JFrame frmKreiranjeRadnogZadatka;
	private static List<Klijent> klijenti;
	JComboBox nazivKlijenta;
	Validacija v = new Validacija();
	Boolean uslov1;
	Date now = new Date();
	Date datumIzvrsenja;


	public KreiranjeZadatkaGUI() {
		initialize();
	}

	private void initialize() {
		
		setTitle("Kreiranje novog zadatka");
		frmKreiranjeRadnogZadatka = new JFrame();
		frmKreiranjeRadnogZadatka.setTitle("Kreiranje radnog zadatka");
		frmKreiranjeRadnogZadatka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
							PromjenaSifreGUI window = new PromjenaSifreGUI(frmPromjenaifre);
							
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
				JOptionPane.showMessageDialog(rootPane, "Opcija će ponuditi preuzimanje .pdf dokumenta sa korisničkim uputstvom", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		pomocMenu.add(korisnickoUputstvoItem);
		
		JPanel centralniPanel = new JPanel();
		centralniPanel.setLayout(new GridLayout(9,2,2,2));
		
		JLabel vrstaRadnogZadatkaLbl = new JLabel("Vrsta radnog zadatka*:");
		vrstaRadnogZadatkaLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JComboBox zadatakCmbx = new JComboBox();
		zadatakCmbx.setModel(new DefaultComboBoxModel(new String[] {"Hardware", "Software"}));
		centralniPanel.add(vrstaRadnogZadatkaLbl);
		centralniPanel.add(zadatakCmbx);
		
		JLabel klijentLbl = new JLabel("Klijent*:");
		klijentLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		centralniPanel.add(klijentLbl);
				
		JLabel krajnjiDatumLbl = new JLabel("Krajnji datum za izvršenje*:");
		krajnjiDatumLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		UtilDateModel model = new UtilDateModel();
		final JDatePanelImpl datePanel = new JDatePanelImpl(model);
		final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		datePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				datumIzvrsenja = (Date) datePicker.getModel().getValue();
				uslov1= v.PoredjenjeDatuma(datumIzvrsenja, now, datePanel);
			}
		});
		
		
		
		nazivKlijenta = new JComboBox();
		klijenti = new ArrayList<Klijent>();
		KlijentDAO kDAO=new KlijentDAO();
		klijenti=kDAO.getAll();
		for(int i=0; i<klijenti.size(); i++)
		nazivKlijenta.addItem(klijenti.get(i).getNaziv());
		centralniPanel.add(nazivKlijenta);
		centralniPanel.add(krajnjiDatumLbl);
		centralniPanel.add(datePicker);
		
		JLabel maksimalanBrojServiseraLbl = new JLabel("Maksimalni broj servisera*:");
		maksimalanBrojServiseraLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		centralniPanel.add(maksimalanBrojServiseraLbl);
		
		JLabel statusODodjeljenostiLbl = new JLabel("Status o dodijeljenosti:");
		statusODodjeljenostiLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JComboBox dodjeljenostCmbx = new JComboBox();
		dodjeljenostCmbx.setModel(new DefaultComboBoxModel(new String[] {"Nedodijeljen", "Dodijeljen"}));
		
		final JSpinner maksimalanBrojServisera = new JSpinner();
		centralniPanel.add(maksimalanBrojServisera);
		centralniPanel.add(statusODodjeljenostiLbl);
		centralniPanel.add(dodjeljenostCmbx);
		
		JLabel statusOIzvsenostiLbl = new JLabel("Status o izvršenosti:");
		statusOIzvsenostiLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JComboBox izvrsenostCmbx = new JComboBox();
		izvrsenostCmbx.setModel(new DefaultComboBoxModel(new String[] {"Nije izvršen", "Procesiranje ", "Izvršen"}));
		centralniPanel.add(statusOIzvsenostiLbl);
		centralniPanel.add(izvrsenostCmbx);
		
		
		JLabel serviserLbl = new JLabel("Serviser(i):");
		serviserLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JComboBox izaberiServiseraCmbx = new JComboBox<Object>();
		izaberiServiseraCmbx.setModel(new DefaultComboBoxModel(new String[] {"Izaberi..", "Miki Maus", "Popaj", "Shrek"}));
		centralniPanel.add(serviserLbl);
		centralniPanel.add(izaberiServiseraCmbx);
		
		JLabel lblPrazna = new JLabel("");
		JButton dodajBtn = new JButton("Dodaj kolaboratore");
		dodajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 SwingUtilities.invokeLater(new Runnable() {
			            public void run() {
			                OdabirServiseraGUI f = new OdabirServiseraGUI();
			                f.setTitle("Odabir servisera");
			                f.setSize(1000, 350);
			                f.setLocationRelativeTo(null);
			                f.setVisible(true);
			            }
			     });
			}
		});
		centralniPanel.add(lblPrazna);
		centralniPanel.add(dodajBtn);
			
		JLabel opisLbl = new JLabel("Opis:");
		opisLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		centralniPanel.add(opisLbl);
		JTextField opisTxt = new JTextField();
		opisTxt.setColumns(10);
		centralniPanel.add(opisTxt);
		
		
		JPanel juzniPanel = new JPanel();
		juzniPanel.setBorder(BorderFactory.createEmptyBorder(2, 1, 2, 1));
		juzniPanel.setLayout(new GridLayout(1,2,1,1));
		
		// Kreiranje novog radnog zadatka
		JButton kreirajBtn = new JButton("Kreiraj");
		kreirajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(uslov1==true)
				{
				RadniZadatak rz = new RadniZadatak();
				rz.setDatumUnosa(now);
				int maxBrojServisera = (Integer)maksimalanBrojServisera.getValue();
				rz.setBrojServisera(maxBrojServisera);
				Klijent k = new Klijent();
				int index = nazivKlijenta.getSelectedIndex();
				k = klijenti.get(index);
				rz.setKlijent(k);
				rz.setKrajnjiDatumIzvrsenja(datumIzvrsenja);
				rz.setOpis("");
				
				RadniZadatakDAO rzDAO = new RadniZadatakDAO();
				long idZadatak=rzDAO.create(rz);
		    	rz.setRadniZadatak_id(idZadatak);
				}
				else
				{
					JOptionPane.showMessageDialog(rootPane, "Da biste spremili podatke u bazu morate unijeti ispravne podatke.", "Poruka o grešci", JOptionPane.ERROR_MESSAGE);
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
	

public static void main(String args[]) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
           KreiranjeZadatkaGUI ex = new KreiranjeZadatkaGUI();
            ex.setVisible(true);
        	
        }
    });
}

}
