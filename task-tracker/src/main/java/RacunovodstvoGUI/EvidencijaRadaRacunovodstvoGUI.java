package RacunovodstvoGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import Entity.ObavljeniPosao;
import Kontroleri.EvidencijaRadaRacunovodstvoControler;
import UtilClasses.DateLabelFormatter;
import UtilClasses.KorisnickoUputstvo;
import UtilClasses.Validacija;

import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class EvidencijaRadaRacunovodstvoGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ime="";
	private String prezime="";
	private String jmbg="";
	private Date pocetniDatum = null, krajnjiDatum = null;
	private Boolean klijentOdabran = false, vrstaUslugeOdabrana = false;
	private int indexKlijent, indexVrstaUsluge;
	private JTable tabela;
	private static EvidencijaRadaRacunovodstvoGUI instanca;
	
	public EvidencijaRadaRacunovodstvoGUI() {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			initialize();
		}
	public static  EvidencijaRadaRacunovodstvoGUI dajInstancu() {
			if(instanca==null) {
 			instanca=new EvidencijaRadaRacunovodstvoGUI();
 			
			}
			return instanca;
		}
		public static void unistiInstancu() { instanca= null; }
		
	public void initialize() {
		setTitle("Pregled evidencije rada");
		final EvidencijaRadaRacunovodstvoControler controler1 = new EvidencijaRadaRacunovodstvoControler();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mojRacunMenu = new JMenu("Moj račun");
		menuBar.add(mojRacunMenu);

		JMenuItem promijeniSifruItem = new JMenuItem("Promijeni šifru");
		promijeniSifruItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							@SuppressWarnings("unused")
							JFrame frmPromjenaifre = new JFrame();
							@SuppressWarnings("unused")
							PromjenaSifreGUI window = new PromjenaSifreGUI();
						} catch (Exception e) {
							JOptionPane.showMessageDialog(rootPane,
									"Pojavila se greška. Pokušajte ponovo.",
									"Poruka o grešci", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
			}
		});
		mojRacunMenu.add(promijeniSifruItem);

		JMenuItem odjaviSeItem = new JMenuItem("Odjavi se");
		odjaviSeItem.addActionListener(new ActionListener() {
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
		mojRacunMenu.add(odjaviSeItem);

		JMenu alatiMenu = new JMenu("Alati");
		menuBar.add(alatiMenu);

		JMenuItem SistemObavjestavanjaItem = new JMenuItem(
				"Sistem obavještavanja");
		SistemObavjestavanjaItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						SistemObavjestavanjaGUI ex = new SistemObavjestavanjaGUI();
						ex.setVisible(true);
					}
				});
			}
		});
		alatiMenu.add(SistemObavjestavanjaItem);

		JMenu pomocMenu = new JMenu("Pomoć");
		menuBar.add(pomocMenu);

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

		JMenuItem korisnikoUpustvoItem = new JMenuItem("Korisničko uputstvo");
		korisnikoUpustvoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					KorisnickoUputstvo kp = new KorisnickoUputstvo();
					kp.dobaviUputstvo();
			}
		});
		pomocMenu.add(korisnikoUpustvoItem);

		JPanel centralniPanel = new JPanel();
		centralniPanel.setLayout(new GridLayout(2, 1, 0, 0));

		final JPanel filterPanel1 = new JPanel();
		final JPanel filterPanel2 = new JPanel();
		filterPanel1.setLayout(new GridLayout(1, 6, 1, 1));
		filterPanel2.setLayout(new GridLayout(1, 6, 1, 1));

		JLabel imePrezimeLbl = new JLabel("Ime i prezime servisera:");
		imePrezimeLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel vrstaUslugeLbl = new JLabel("Vrsta zadatka");
		vrstaUslugeLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel periodLbl = new JLabel("Za period od:");
		periodLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel datumIzvrsenjaLbl = new JLabel("do:");
		datumIzvrsenjaLbl.setHorizontalAlignment(SwingConstants.RIGHT);

		final JTextField imePrezimeTxt = new JTextField();
		UtilDateModel model = new UtilDateModel();
		final JDatePanelImpl datePanel = new JDatePanelImpl(model);
		final JDatePickerImpl pocetniDatumDP = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		pocetniDatumDP.setAlignmentY(MAXIMIZED_BOTH);
		UtilDateModel model1 = new UtilDateModel();
		final JDatePanelImpl datePanel1 = new JDatePanelImpl(model1);
		final JDatePickerImpl krajniDatumDP = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		krajniDatumDP.setAlignmentY(MAXIMIZED_BOTH);

		filterPanel1.add(imePrezimeLbl);
		filterPanel1.add(imePrezimeTxt);
		JLabel jmbgLbl = new JLabel("JMBG servisera:");
		filterPanel1.add(jmbgLbl);
		jmbgLbl.setHorizontalAlignment(SwingConstants.RIGHT);

		final JTextField jmbgTxt;
		jmbgTxt = new JTextField();
		filterPanel1.add(jmbgTxt);
		jmbgTxt.setColumns(10);
		filterPanel1.add(vrstaUslugeLbl);
		filterPanel2.add(periodLbl);
		filterPanel2.add(pocetniDatumDP);
		filterPanel2.add(datumIzvrsenjaLbl);
		filterPanel2.add(krajniDatumDP);
		JLabel nazivLbl = new JLabel("Naziv klijenta:");
		filterPanel2.add(nazivLbl);
		nazivLbl.setHorizontalAlignment(SwingConstants.RIGHT);

		final JPanel filterPanel3 = new JPanel();
		filterPanel3.setLayout(new GridLayout(1, 6, 1, 1));
		final JCheckBox chckbxNeizvrsen = new JCheckBox(
				"Zadatak u procesiranju");
		chckbxNeizvrsen.setHorizontalAlignment(SwingConstants.RIGHT);
		filterPanel3.add(chckbxNeizvrsen);

		final JCheckBox chckbxIzvrsen = new JCheckBox("Izvršen zadatak");
		chckbxIzvrsen.setHorizontalAlignment(SwingConstants.RIGHT);
		filterPanel3.add(chckbxIzvrsen);

		JLabel prazno4Lbl = new JLabel("");
		filterPanel3.add(prazno4Lbl);

		JLabel praznoLbl = new JLabel("");
		filterPanel3.add(praznoLbl);

		JLabel prazno1Lbl = new JLabel("");
		filterPanel3.add(prazno1Lbl);

		@SuppressWarnings("serial")
		final DefaultTableModel modelTabela = new DefaultTableModel(){
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		tabela = new JTable(modelTabela);
		modelTabela.addColumn("Vrsta zadatka");
		modelTabela.addColumn("Opis zadatka");
		modelTabela.addColumn("Klijent");
		modelTabela.addColumn("Serviser");
		modelTabela.addColumn("Vrsta usluge");
		modelTabela.addColumn("Utrošeno sati");
		ListSelectionModel cellSelectionModel = tabela.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
		JScrollPane tabelaPane = new JScrollPane(tabela);
		
		
		try {
			IspisiSve(controler1.PronadjiSvePoslove(), modelTabela);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(rootPane,
					"Pojavila se greška. Pokušajte ponovo.",
					"Poruka o grešci", JOptionPane.ERROR_MESSAGE);
		}

		final JButton pretraziBtn = new JButton("Pretraga");

		ImageIcon traziIkona = new ImageIcon(getClass().getResource(
				"SearchIcon.png"));
		pretraziBtn.setIcon(traziIkona);

		filterPanel3.add(pretraziBtn);

		final JPanel sjeverniPanel = new JPanel();
		sjeverniPanel.setLayout(new GridLayout(3, 1, 2, 2));

		sjeverniPanel.add(filterPanel1);

		final JComboBox<String> vrstaUslugeCmb = new JComboBox<String>();
		try {
			controler1.setKlijenti();
			controler1.setVrsteUsluge();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(rootPane,
					"Pojavila se greška. Pokušajte ponovo.",
					"Poruka o grešci", JOptionPane.ERROR_MESSAGE);
		}
		
		for (int i = 0; i < controler1.getVrsteUsluge().size(); i++)
			vrstaUslugeCmb.addItem(controler1.getVrsteUsluge().get(i).getNaziv());
		filterPanel1.add(vrstaUslugeCmb);
		sjeverniPanel.add(filterPanel2);

		final JComboBox<String> nazivKlijentaCmb = new JComboBox<String>();
	
		for (int i = 0; i < controler1.getKlijenti().size(); i++)
			nazivKlijentaCmb.addItem(controler1.getKlijenti().get(i).getNaziv());
		filterPanel2.add(nazivKlijentaCmb);
		sjeverniPanel.add(filterPanel3);

		centralniPanel.add(tabelaPane);
		centralniPanel.setLayout(new GridLayout(1, 1, 0, 0));

		JPanel juzniPanel = new JPanel();

		juzniPanel.setBorder(BorderFactory.createEmptyBorder(2, 1, 2, 1));
		juzniPanel.setLayout(new GridLayout(1, 3, 1, 1));

		JLabel prazno3Lbl = new JLabel("");
		juzniPanel.add(prazno3Lbl);

		JLabel prazno2Lbl = new JLabel("");
		juzniPanel.add(prazno2Lbl);

		getContentPane().add(sjeverniPanel, BorderLayout.NORTH);
		getContentPane().add(centralniPanel, BorderLayout.CENTER);
		getContentPane().add(juzniPanel, BorderLayout.SOUTH);

		JLabel label = new JLabel("");
		juzniPanel.add(label);
		JButton ureduBtn = new JButton("Uredu");
		ureduBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		juzniPanel.add(ureduBtn);
		

		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
			pretraziBtn.isSelected();
			}
		});
		
		vrstaUslugeCmb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				indexVrstaUsluge=vrstaUslugeCmb.getSelectedIndex();
				vrstaUslugeOdabrana=true;
			}
		});
		

		nazivKlijentaCmb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indexKlijent=nazivKlijentaCmb.getSelectedIndex();
				klijentOdabran=true;
			}
		});
		

		chckbxNeizvrsen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxIzvrsen.isSelected()) {
					chckbxNeizvrsen.setSelected(false);
					JOptionPane.showMessageDialog(rootPane,
							"Možete odabrati samo jednu opciju.",
							"Poruka o grešci", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		chckbxIzvrsen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNeizvrsen.isSelected()) {
					chckbxIzvrsen.setSelected(false);
					JOptionPane.showMessageDialog(rootPane,
							"Možete odabrati samo jednu opciju.",
							"Poruka o grešci", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		imePrezimeTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				String string = imePrezimeTxt.getText();
				String[] naziv = string.split("\\s+");
				
				ime = naziv[0];
				if(naziv.length>1)
					{
						prezime = naziv[1];
						if(naziv.length>2)
							for(int i=2; i<naziv.length; i++) prezime+=" "+naziv[i];
						
					}

			}
		});

		jmbgTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Validacija v = new Validacija();
				if (v.JMBG(jmbgTxt)) {
					jmbg = jmbgTxt.getText();
				} else {
					jmbgTxt.setText(null);
					JOptionPane.showMessageDialog(rootPane,
							"Unesite ispravan JMBG.", "Poruka o grešci",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		pocetniDatumDP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pocetniDatum = (Date) pocetniDatumDP.getModel().getValue();
			}
		});

		krajniDatumDP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				krajnjiDatum = (Date) krajniDatumDP.getModel().getValue();
			}
		});


		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				modelTabela.setRowCount(0);
				try {
						IspisiSve(controler1.PronadjiSvePoslove(), modelTabela);
					} catch (Exception e2) {
					JOptionPane.showMessageDialog(rootPane,
							"Pojavila se greška. Pokušajte ponovo.",
							"Poruka o grešci", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		

		pretraziBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				modelTabela.setRowCount(0);
				System.out.println(chckbxNeizvrsen.isSelected()+" "+ime+" "+prezime+" "+jmbg+" "+klijentOdabran+" "+indexKlijent+" "+chckbxIzvrsen.isSelected()+" "+vrstaUslugeOdabrana+" "+indexVrstaUsluge+" "+pocetniDatum+" "+krajnjiDatum);
				if(ime=="" && prezime=="" && jmbg=="" && vrstaUslugeOdabrana==false && klijentOdabran ==false
						&& pocetniDatum==null && krajnjiDatum==null && chckbxIzvrsen.isSelected()==false
						&& chckbxNeizvrsen.isSelected()==false)
				{
					JOptionPane.showMessageDialog(rootPane,
							"Morate odabrati barem jedan kriterij pretrage.",
							"Poruka o grešci", JOptionPane.ERROR_MESSAGE);
				}
				
				else
				{
					EvidencijaRadaRacunovodstvoControler controler2 = new EvidencijaRadaRacunovodstvoControler();
					Boolean pronadjeni;
					try {
						pronadjeni = controler2.PronadjiObavljenePoslove(chckbxNeizvrsen.isSelected(), ime, prezime, jmbg, klijentOdabran, indexKlijent, chckbxIzvrsen.isSelected(), vrstaUslugeOdabrana, indexVrstaUsluge, pocetniDatum, krajnjiDatum);
					System.out.println(pronadjeni);
					if(pronadjeni==true)
					{
						IspisiSve(controler2.getObavljeniPosao(), modelTabela);
					
					}
					else
					{
						JOptionPane.showMessageDialog(rootPane,
								"Ne postoji obavljeni posao u bazi podataka.",
								"Poruka o grešci", JOptionPane.INFORMATION_MESSAGE);
					}
				
					} catch (Exception e) {
						JOptionPane.showMessageDialog(rootPane,
								"Pojavila se greška. Pokušajte ponovo.",
								"Poruka o grešci", JOptionPane.ERROR_MESSAGE);
					}
					}
				
				ime="";
				prezime="";
				jmbg="";
				imePrezimeTxt.setText("");
				jmbgTxt.setText("");
				pocetniDatum=null;
				krajnjiDatum = null;
				pocetniDatumDP.getJFormattedTextField().setText("");
				krajniDatumDP.getJFormattedTextField().setText("");
				chckbxIzvrsen.setSelected(false);
				chckbxNeizvrsen.setSelected(false);
				nazivKlijentaCmb.setSelectedIndex(0);
				vrstaUslugeCmb.setSelectedIndex(0);
				vrstaUslugeOdabrana=false;
				klijentOdabran=false;
				
			}

		});
	}
	
	public void IspisiSve(List<ObavljeniPosao> poslovi, DefaultTableModel modelTabela)
	{
		for(int i=0; i<poslovi.size(); i++)
		modelTabela.addRow(new Object[]{poslovi.get(i).getPripadajuciZadatak().getZadatak().getVrstaZadatka(),poslovi.get(i).getPripadajuciZadatak().getZadatak().getOpis(), 
				poslovi.get(i).getPripadajuciZadatak().getZadatak().getKlijent().getNaziv(), poslovi.get(i).getPripadajuciZadatak().getIzvrsilac().getIme()+" "+poslovi.get(i).getPripadajuciZadatak().getIzvrsilac().getPrezime(), 
				poslovi.get(i).getVrstaUsluge().getNaziv(), poslovi.get(i).getBrojSati()});
	
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		unistiInstancu();
		super.dispose();
	}
	
}
