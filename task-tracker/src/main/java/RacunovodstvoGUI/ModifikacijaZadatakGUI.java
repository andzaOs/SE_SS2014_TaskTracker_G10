package RacunovodstvoGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.IOException;
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
import Kontroleri.*;
import Entity.Korisnik;
import Entity.RadniZadatak;
import UtilClasses.Validacija;


@SuppressWarnings("serial")
public class ModifikacijaZadatakGUI extends JFrame {

	private JFrame frmKreiranjeRadnogZadatka;
	private List<Korisnik> selektovaniServiseri = new ArrayList<Korisnik>();
	private RadniZadatak radniZadatak;
	private ModifikacijaZadatakGUI mySelf;
	private Validacija v = new Validacija();
	private Boolean uslov1 = true, uslov2=true, serviserSelektovan = false, klijentOdabran=false, brojServiseraOdabran=false,
			datumIzvrsenjaOdabran=false, vrstaZadatkaOdabrana=false, opisOdabran=false;
	private Date datumIzvrsenja;
	// Konstruktor
	public ModifikacijaZadatakGUI(RadniZadatak radniZadatak) {

		this.radniZadatak=radniZadatak;
		mySelf = this;
		initialize();
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
		ModifikacijaZadatakControler controler1 = new ModifikacijaZadatakControler();
		
		setTitle("Modifikacija radnog zadatka");
		frmKreiranjeRadnogZadatka = new JFrame();
		frmKreiranjeRadnogZadatka.setTitle("Modifikacija radnog zadatka");
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
				   if (Desktop.isDesktopSupported()) {
			    	    try {
			    	        File myFile = new File("FirstPdf.pdf");
			    	        Desktop.getDesktop().open(myFile);
			    	    } catch (IOException ex) {
			    	        // no application registered for PDFs
			    	    }
			    	}
			}
		});
		pomocMenu.add(korisnickoUputstvoItem);

		JPanel centralniPanel = new JPanel();
		centralniPanel.setLayout(new GridLayout(6, 2, 2, 2));

		JLabel vrstaRadnogZadatkaLbl = new JLabel("Vrsta radnog zadatka*:");
		vrstaRadnogZadatkaLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		final JComboBox<String> vrstaZadatkaCmbx = new JComboBox<String>();
		vrstaZadatkaCmbx.setModel(new DefaultComboBoxModel<String>(
				new String[] {"Hardver", "Softver" }));

		vrstaZadatkaCmbx.setSelectedItem(radniZadatak.getVrstaZadatka());
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
		datumIzvrsenjaDP.getJFormattedTextField().setText(radniZadatak.getKrajnjiDatumIzvrsenja().toString());
		datumIzvrsenja=radniZadatak.getKrajnjiDatumIzvrsenja();
		
		
		final JComboBox<String> nazivKlijentaCmbx = new JComboBox<String>();
		//Punimo combobox na osnovu podataka iz baze, a preko kontrolera
		controler1.setKlijenti();
		for (int i = 0; i < controler1.getKlijente().size(); i++)
			nazivKlijentaCmbx.addItem(controler1.getKlijente().get(i).getNaziv());
		nazivKlijentaCmbx.setSelectedItem(radniZadatak.getKlijent().getNaziv());
		centralniPanel.add(nazivKlijentaCmbx);
		centralniPanel.add(krajnjiDatumLbl);
		centralniPanel.add(datumIzvrsenjaDP);

		JLabel opisLbl = new JLabel("Opis:");
		opisLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		centralniPanel.add(opisLbl);

		JScrollPane scrollPane = new JScrollPane();
		centralniPanel.add(scrollPane);

		final JTextArea opisTxt = new JTextArea();
		opisTxt.setText(radniZadatak.getOpis());
		opisTxt.setLineWrap(true);
		opisTxt.setColumns(1);
		scrollPane.setViewportView(opisTxt);

		JLabel maksimalanBrojServiseraLbl = new JLabel(
				"Maksimalni broj servisera*:");
		maksimalanBrojServiseraLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		centralniPanel.add(maksimalanBrojServiseraLbl);

		final JSpinner maksimalanBrojServisera = new JSpinner();
		maksimalanBrojServisera.setModel(new SpinnerNumberModel(new Integer(radniZadatak.getStatusDodjeljenosti()), null, null, new Integer(1)));
		maksimalanBrojServisera.setValue(radniZadatak.getBrojServisera());
		centralniPanel.add(maksimalanBrojServisera);

		JLabel lblPrazna = new JLabel("");
		final JButton dodajBtn = new JButton("Dodijeli serviserima");
		centralniPanel.add(lblPrazna);
		centralniPanel.add(dodajBtn);

		JPanel juzniPanel = new JPanel();
		juzniPanel.setBorder(BorderFactory.createEmptyBorder(2, 1, 2, 1));
		juzniPanel.setLayout(new GridLayout(1, 2, 1, 1));

		JButton modifikujBtn = new JButton("Modifikuj");

		JButton odustaniBtn = new JButton("Odustani");
		juzniPanel.add(odustaniBtn);
		juzniPanel.add(modifikujBtn);

		getContentPane().add(centralniPanel, BorderLayout.CENTER);
		getContentPane().add(juzniPanel, BorderLayout.SOUTH);
		

		
		vrstaZadatkaCmbx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vrstaZadatkaOdabrana=true;
			}
		});

		nazivKlijentaCmbx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				klijentOdabran=true;
			}
		});
		

		opisTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				opisOdabran=true;
			}
		});

		maksimalanBrojServisera.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				brojServiseraOdabran=true;
				if((Integer)maksimalanBrojServisera.getValue()<radniZadatak.getStatusDodjeljenosti())
				{
					Border border = BorderFactory.createLineBorder(Color.RED, 1);
					maksimalanBrojServisera.setBorder(border);
					uslov2=false;
				}
				else
				{
					Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
					maksimalanBrojServisera.setBorder(border);
					uslov2=true;
				}
			}
		});
		
		datumIzvrsenjaDP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				datumIzvrsenja=(Date)datumIzvrsenjaDP.getModel().getValue();
				uslov1 = v.PoredjenjeDatuma(datumIzvrsenja, radniZadatak.getDatumUnosa(), datumIzvrsenjaDP);
				datumIzvrsenjaOdabran=true;
			}
		});

		dodajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Pozivamo novu dijalošku formu u kojoj će korisnik dodijeliti
				// zadatak serviserima
				if(radniZadatak.getStatusDodjeljenosti() < (Integer)maksimalanBrojServisera.getValue())
				{
					OdabirServiseraModifikacijaGUI os = new OdabirServiseraModifikacijaGUI(mySelf, radniZadatak,(Integer)maksimalanBrojServisera.getValue());
					os.setVisible(true);
					os.setSize(1000, 350);
				}
				else
				{
					JOptionPane.showMessageDialog(rootPane,
							"Maksimalan broj servisera je već odabran.",
							"Poruka o uspješnosti operacije",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		modifikujBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(vrstaZadatkaOdabrana!=true && serviserSelektovan!=true && datumIzvrsenjaOdabran!=true
						&& klijentOdabran!=true && opisOdabran!=true && brojServiseraOdabran!=true)
				{
					JOptionPane.showMessageDialog(rootPane,
							"Niste promijenili nijedan podatak o radnom zadatku.",
							"Poruka o uspješnosti operacije",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					if(uslov1!=true || uslov2!=true)
					{
						JOptionPane.showMessageDialog(rootPane,
								"Niste unijeli ispravne vrijednosti u naznačenim poljima.",
								"Poruka o uspješnosti operacije",
								JOptionPane.INFORMATION_MESSAGE);
						
					}
					else
					{
						ModifikacijaZadatakControler controler2 = new ModifikacijaZadatakControler();
						Boolean modifikovanZadatak = controler2.ModifikujRadniZadatak(radniZadatak,(Integer)maksimalanBrojServisera.getValue(), datumIzvrsenja, 
								(Integer)nazivKlijentaCmbx.getSelectedIndex(), opisTxt.getText(), (String)vrstaZadatkaCmbx.getSelectedItem(), getServiserSelektovan(), selektovaniServiseri);
				
						if(modifikovanZadatak)	
						{
							JOptionPane.showMessageDialog(rootPane,
									"Radni zadatak je uspješno modifikovan.",
									"Poruka o uspješnosti operacije",
									JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(rootPane,
									"Možete dodati sljedeći broj servisera: "+controler2.getMaxBrojServiseraZaDodjelu(),
									"Poruka o uspješnosti operacije",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}

			}
		});

		odustaniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}


}
