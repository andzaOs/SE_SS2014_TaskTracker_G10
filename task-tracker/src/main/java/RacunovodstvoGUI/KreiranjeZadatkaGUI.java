package RacunovodstvoGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import Entity.Korisnik;
import Kontroleri.KreiranjeZadatkaControler;
import UtilClasses.KorisnickoUputstvo;
import UtilClasses.Validacija;


@SuppressWarnings("serial")
public class KreiranjeZadatkaGUI extends JFrame {

	private JFrame frmKreiranjeRadnogZadatka;
	private List<Korisnik> selektovaniServiseri = new ArrayList<Korisnik>();
	private KreiranjeZadatkaGUI mySelf;
	private Validacija v = new Validacija();
	private Boolean uslov1 = false, serviserSelektovan = false, klijentOdabran=false;
	private Date datumIzvrsenja = null;
	private int maxBrojServisera = 1, indexKlijent;
	private String opis = "", vrstaZadatka = "";

	// Konstruktor
	public KreiranjeZadatkaGUI() {
		initialize();
		mySelf = this;
	}

	// Metoda potrebna za postavljanje liste servisera preko forme Odabir
	// servisera
	public void setServiseri(List<Korisnik> serviseri) {
		this.selektovaniServiseri = serviseri;
	}

	// Metoda potrebna za provjeru da li je korisnik odabrao servisere putem
	// forme Odabir servisera
	public void setServiserSelektovan(Boolean serviserSelektovan) {
		this.serviserSelektovan = serviserSelektovan;
	}

	public Boolean getServiserSelektovan() {
		return this.serviserSelektovan;
	}

	private void initialize() {
		//Kontroler nam je potreban radi testiranja
		KreiranjeZadatkaControler controler1 = new KreiranjeZadatkaControler();
		
		final Border crveno = BorderFactory.createLineBorder(Color.RED, 1);
		final Border bezBoje = BorderFactory.createLineBorder(Color.GRAY, 1);
		final Date now = new Date();
		
		setTitle("Kreiranje radnog zadatka");
		frmKreiranjeRadnogZadatka = new JFrame();
		frmKreiranjeRadnogZadatka.setTitle("Kreiranje radnog zadatka");
		frmKreiranjeRadnogZadatka
				.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar glavniMenuBar = new JMenuBar();
		setJMenuBar(glavniMenuBar);

		JMenu mojRacunMenu = new JMenu("Moj račun");
		glavniMenuBar.add(mojRacunMenu);
		JMenuItem promijeniSifruItem = new JMenuItem("Promijeni šifru");
		promijeniSifruItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					@SuppressWarnings("unused")
					public void run() {
						try {
							JFrame frmPromjenaifre = new JFrame();
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
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
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
		JMenuItem sistemObavjestavanjaItem = new JMenuItem(
				"Sistem obavještavanja");
		sistemObavjestavanjaItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
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
		centralniPanel.setLayout(new GridLayout(6, 2, 2, 2));

		JLabel vrstaRadnogZadatkaLbl = new JLabel("Vrsta radnog zadatka*:");
		vrstaRadnogZadatkaLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		final JComboBox<String> vrstaZadatkaCmbx = new JComboBox<String>();
		vrstaZadatkaCmbx.setModel(new DefaultComboBoxModel<String>(
				new String[] {"Odaberite vrstu", "Hardver", "Softver" }));
		centralniPanel.add(vrstaRadnogZadatkaLbl);
		centralniPanel.add(vrstaZadatkaCmbx);

		JLabel klijentLbl = new JLabel("Klijent*:");
		klijentLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		centralniPanel.add(klijentLbl);

		JLabel krajnjiDatumLbl = new JLabel("Krajnji datum za izvršenje*:");
		krajnjiDatumLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		UtilDateModel model = new UtilDateModel();
		final JDatePanelImpl datePanel = new JDatePanelImpl(model);
		final JDatePickerImpl datumIzvrsenjaDP = new JDatePickerImpl(datePanel);
		final JComboBox<String> nazivKlijentaCmbx = new JComboBox<String>();
		//Punimo combobox na osnovu podataka iz baze, a preko kontrolera
		controler1.setKlijenti();
		for (int i = 0; i < controler1.getKlijente().size(); i++)
			nazivKlijentaCmbx.addItem(controler1.getKlijente().get(i).getNaziv());
		
		centralniPanel.add(nazivKlijentaCmbx);
		centralniPanel.add(krajnjiDatumLbl);
		centralniPanel.add(datumIzvrsenjaDP);

		JLabel opisLbl = new JLabel("Opis:");
		opisLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		centralniPanel.add(opisLbl);

		JScrollPane scrollPane = new JScrollPane();
		centralniPanel.add(scrollPane);

		final JTextArea opisTxt = new JTextArea();
		opisTxt.setLineWrap(true);
		opisTxt.setColumns(1);
		scrollPane.setViewportView(opisTxt);

		JLabel maksimalanBrojServiseraLbl = new JLabel(
				"Maksimalni broj servisera*:");
		maksimalanBrojServiseraLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		centralniPanel.add(maksimalanBrojServiseraLbl);

		final JSpinner maksimalanBrojServisera = new JSpinner();
		maksimalanBrojServisera.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		centralniPanel.add(maksimalanBrojServisera);

		JLabel lblPrazna = new JLabel("");
		final JButton dodajBtn = new JButton("Dodijeli serviserima");
		centralniPanel.add(lblPrazna);
		centralniPanel.add(dodajBtn);

		JPanel juzniPanel = new JPanel();
		juzniPanel.setBorder(BorderFactory.createEmptyBorder(2, 1, 2, 1));
		juzniPanel.setLayout(new GridLayout(1, 2, 1, 1));

		// Kreiranje novog radnog zadatka
		JButton kreirajBtn = new JButton("Kreiraj");

		JButton odustaniBtn = new JButton("Odustani");
		juzniPanel.add(odustaniBtn);
		juzniPanel.add(kreirajBtn);

		getContentPane().add(centralniPanel, BorderLayout.CENTER);
		getContentPane().add(juzniPanel, BorderLayout.SOUTH);
		

		vrstaZadatkaCmbx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vrstaZadatka = (String)vrstaZadatkaCmbx.getSelectedItem();
				vrstaZadatkaCmbx.setBorder(bezBoje);
			}
		});

		nazivKlijentaCmbx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				indexKlijent = (int)nazivKlijentaCmbx.getSelectedIndex();
				klijentOdabran=true;
				nazivKlijentaCmbx.setBorder(bezBoje);
			}
		});
		

		opisTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				opis = opisTxt.getText();
			}
		});

		maksimalanBrojServisera.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				maxBrojServisera = (Integer) maksimalanBrojServisera
						.getValue();
				if(maxBrojServisera>0)maksimalanBrojServisera.setBorder(bezBoje);
				else maksimalanBrojServisera.setBorder(crveno);
				
			}
		});
		
		datumIzvrsenjaDP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				datumIzvrsenja = (Date) datumIzvrsenjaDP.getModel().getValue();
				// Provjeravamo da li je krajnji datum za izvršenje manji od
				// datuma kreiranja radnog zadatka
				uslov1 = v.PoredjenjeDatuma(datumIzvrsenja, now, datumIzvrsenjaDP);
			}
		});

		dodajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Pozivamo novu dijalošku formu u kojoj će korisnik dodijeliti
				// zadatak serviserima
				
				OdabirServiseraGUI os = new OdabirServiseraGUI(mySelf,null,null, (Integer)maksimalanBrojServisera.getValue());
				os.setVisible(true);
				os.setSize(1000, 350);
			}
		});

		kreirajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				KreiranjeZadatkaControler controler2 = new KreiranjeZadatkaControler();
				
				if (uslov1 == true && vrstaZadatka!="" && klijentOdabran!=false) 
				{
					
					controler2.KreirajRadniZadatak(maxBrojServisera, datumIzvrsenja, indexKlijent, opis, vrstaZadatka, getServiserSelektovan(), selektovaniServiseri);
					
					JOptionPane.showMessageDialog(rootPane,
							"Radni zadatak je uspješno kreiran.",
							"Poruka o uspješnosti operacije",
							JOptionPane.INFORMATION_MESSAGE);
					
					vrstaZadatkaCmbx.setSelectedIndex(0);
					vrstaZadatka="";
					nazivKlijentaCmbx.setSelectedIndex(0);
					klijentOdabran=false;
					maksimalanBrojServisera.setValue(0);
					maxBrojServisera=0;
					datumIzvrsenjaDP.getJFormattedTextField().setText("");
					datumIzvrsenja=null;
					opisTxt.setText("");
					opis="";
				}

				else 
				{
					if(indexKlijent==0) nazivKlijentaCmbx.setBorder(crveno);
					if(maxBrojServisera==0) maksimalanBrojServisera.setBorder(crveno);
					if(datumIzvrsenja==null) datumIzvrsenjaDP.setBorder(crveno);
					if(vrstaZadatka=="") vrstaZadatkaCmbx.setBorder(crveno);
					
					JOptionPane
							.showMessageDialog(
									rootPane,
									"Da biste spremili podatke u bazu morate unijeti vrijednosti u označena polja.",
									"Poruka o grešci",
									JOptionPane.ERROR_MESSAGE);
				}


			}
		});

		odustaniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
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
