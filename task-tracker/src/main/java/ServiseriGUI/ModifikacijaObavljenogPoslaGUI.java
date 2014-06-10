package ServiseriGUI;

//komentar za test commit
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import DAO.ObavljeniPosaoDAO;
import DAO.VrstaUslugeDAO;
import Entity.ObavljeniPosao;
import Entity.VrstaUsluge;
import RacunovodstvoGUI.ONamaGUI;
import RacunovodstvoGUI.OdjaviSeGUI;
import RacunovodstvoGUI.PromjenaSifreGUI;
import UtilClasses.KorisnickoUputstvo;

public class ModifikacijaObavljenogPoslaGUI extends JFrame
{
	/**
	 * 
	 */
	final JComboBox comboUsluga = new JComboBox();
	private static final long serialVersionUID = 1L;
	private static ObavljeniPosao posao;
	private JTextField datum_obavljanja;
	
	private static ModifikacijaObavljenogPoslaGUI instanca;
	 
	 
	public static ModifikacijaObavljenogPoslaGUI  dajInstancu(ObavljeniPosao posao1) {
		if(instanca==null) {
		instanca=new ModifikacijaObavljenogPoslaGUI (posao1);
		
		}
		return instanca;
	}
	public static void unistiInstancu() { instanca= null; }
	
	public ModifikacijaObavljenogPoslaGUI(ObavljeniPosao posao1) 

	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	
		posao=posao1;
		initUI();
		
	}
	
	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public final void initUI() 
	{
		
		//Naziv forme
		setTitle("Modifikacija obavljenog posla");
		
		this.setSize(311, 307);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		//ucitaj usluge
				VrstaUslugeDAO uDAO= new VrstaUslugeDAO();
				final List<VrstaUsluge> usluge;
				usluge=uDAO.getAll();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mojRacunMeni = new JMenu("Moj ra\u010Dun");
		menuBar.add(mojRacunMeni);
		
		JMenuItem promjenaSifreItem = new JMenuItem("Promijeni \u0161ifru");
		promjenaSifreItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmPromjenaifre = new JFrame();
				PromjenaSifreGUI window = new PromjenaSifreGUI();
			}
		});
		mojRacunMeni.add(promjenaSifreItem);
		
		JMenuItem odjaviSeItem = new JMenuItem("Odjavi se");
		odjaviSeItem.addActionListener(new ActionListener() {
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
		mojRacunMeni.add(odjaviSeItem);
		
		JMenu pomocMeni = new JMenu("Pomo\u0107");
		menuBar.add(pomocMeni);
		
		JMenuItem korisnickoUpustvoItem = new JMenuItem("Korisni\u010Dko upustvo");
		korisnickoUpustvoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KorisnickoUputstvo kp = new KorisnickoUputstvo();
				kp.dobaviUputstvoServiseri();					
			}
		});
		pomocMeni.add(korisnickoUpustvoItem);
		
		JMenuItem oNamaItem = new JMenuItem("O nama");
		oNamaItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ONamaGUI window = new ONamaGUI();
				window.setVisible(true);
				window.setSize(350,150);
				window.setLocationRelativeTo(null);
			}
		});
		pomocMeni.add(oNamaItem);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{112, 207, 0};
		gridBagLayout.rowHeights = new int[]{41, 0, 0, 219, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel vrstaUslugeLbl = new JLabel("Vrsta usluge:");
		GridBagConstraints gbc_vrstaUslugeLbl = new GridBagConstraints();
		gbc_vrstaUslugeLbl.insets = new Insets(0, 0, 5, 5);
		gbc_vrstaUslugeLbl.anchor = GridBagConstraints.EAST;
		gbc_vrstaUslugeLbl.gridx = 0;
		gbc_vrstaUslugeLbl.gridy = 0;
		getContentPane().add(vrstaUslugeLbl, gbc_vrstaUslugeLbl);
		
		
		GridBagConstraints gbc_comboUsluga = new GridBagConstraints();
		gbc_comboUsluga.insets = new Insets(0, 0, 5, 0);
		gbc_comboUsluga.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboUsluga.gridx = 1;
		gbc_comboUsluga.gridy = 0;
		getContentPane().add(comboUsluga, gbc_comboUsluga);
		
		JLabel utrosenoVrijemeLbl = new JLabel("Utrošeno vrijeme(h):");
		GridBagConstraints gbc_utrosenoVrijemeLbl = new GridBagConstraints();
		gbc_utrosenoVrijemeLbl.anchor = GridBagConstraints.EAST;
		gbc_utrosenoVrijemeLbl.insets = new Insets(0, 0, 5, 5);
		gbc_utrosenoVrijemeLbl.gridx = 0;
		gbc_utrosenoVrijemeLbl.gridy = 1;
		getContentPane().add(utrosenoVrijemeLbl, gbc_utrosenoVrijemeLbl);
		
		final JSpinner spinnVrijeme = new JSpinner();
		spinnVrijeme.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_spinnVrijeme = new GridBagConstraints();
		gbc_spinnVrijeme.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnVrijeme.insets = new Insets(0, 0, 5, 0);
		gbc_spinnVrijeme.gridx = 1;
		gbc_spinnVrijeme.gridy = 1;
		getContentPane().add(spinnVrijeme, gbc_spinnVrijeme);
		
		JLabel lblDatumObavljanja = new JLabel("Datum obavljanja:");
		GridBagConstraints gbc_lblDatumObavljanja = new GridBagConstraints();
		gbc_lblDatumObavljanja.anchor = GridBagConstraints.EAST;
		gbc_lblDatumObavljanja.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatumObavljanja.gridx = 0;
		gbc_lblDatumObavljanja.gridy = 2;
		getContentPane().add(lblDatumObavljanja, gbc_lblDatumObavljanja);
		
		final JDatePanelImpl datePanel1;
		final JDatePickerImpl datumObavljanja;
		UtilDateModel model1 = new UtilDateModel();
		 datePanel1 = new JDatePanelImpl(model1);
		 datumObavljanja = new JDatePickerImpl(datePanel1);
		datumObavljanja.setAlignmentY(MAXIMIZED_BOTH);
		
	
		GridBagConstraints gbc_datum_obavljanja = new GridBagConstraints();
		gbc_datum_obavljanja.insets = new Insets(0, 0, 5, 0);
		gbc_datum_obavljanja.fill = GridBagConstraints.HORIZONTAL;
		gbc_datum_obavljanja.gridx = 1;
		gbc_datum_obavljanja.gridy = 2;
		getContentPane().add(datumObavljanja, gbc_datum_obavljanja);
		
		
		JLabel opisPoslaLbl = new JLabel("Opis posla:");
		GridBagConstraints gbc_opisPoslaLbl = new GridBagConstraints();
		gbc_opisPoslaLbl.anchor = GridBagConstraints.EAST;
		gbc_opisPoslaLbl.insets = new Insets(0, 0, 5, 5);
		gbc_opisPoslaLbl.gridx = 0;
		gbc_opisPoslaLbl.gridy = 3;
		getContentPane().add(opisPoslaLbl, gbc_opisPoslaLbl);
		final JTextArea opisPoslaTxt = new JTextArea();
		 for(int i=0;i<usluge.size();i++){
	 			comboUsluga.addItem(usluge.get(i));
	 		}
		spinnVrijeme.setValue(posao.getBrojSati());
		 datumObavljanja.getJFormattedTextField().setText(posao.getDatumObavljanja().toString());
	     opisPoslaTxt.setText(posao.getOpisa());
	     ComboBoxModel model = comboUsluga.getModel();
         int size = model.getSize();
         for(int i=0;i<size;i++) {
         if(model.getElementAt(i).toString().equals(posao.getVrstaUsluge().getNaziv())){
        	 comboUsluga.setSelectedItem(model.getElementAt(i));
         }
         }
	     
	    
	    
	    
		
        
		
		
		
		
		JButton evidentirajPosaoBtn = new JButton("Modifikuj obavljeni posao");
		evidentirajPosaoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
					ObavljeniPosao novi=new ObavljeniPosao();
					novi.setPripadajuciZadatak(posao.getPripadajuciZadatak());
					int value = (Integer) spinnVrijeme.getValue();
					novi.setBrojSati(value);
					java.util.Date utilDate = new java.util.Date();
				    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
					novi.setDatumUnosa(sqlDate);
					if((Date) datumObavljanja.getModel().getValue()==null){novi.setDatumObavljanja(posao.getDatumObavljanja());}
					else{
					Date d=(Date) datumObavljanja.getModel().getValue();
					java.sql.Date sqlDate1 = new java.sql.Date(d.getTime());
					novi.setDatumObavljanja(sqlDate1);}
					novi.setOpisa(opisPoslaTxt.getText());
					novi.setVrstaUsluge(usluge.get(comboUsluga.getSelectedIndex()));
					novi.setVidljivo(true);
					novi.setObavljeniPosao_id(posao.getObavljeniPosao_id());
					ObavljeniPosaoDAO oDAO = new  ObavljeniPosaoDAO();
					oDAO.update(novi);
					JOptionPane.showMessageDialog(rootPane, "Uspješno ste modifikovali posao!", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
				
			dispose();
			}
		});
		
		
		GridBagConstraints gbc_opisPoslaTxt = new GridBagConstraints();
		gbc_opisPoslaTxt.insets = new Insets(0, 0, 5, 0);
		gbc_opisPoslaTxt.fill = GridBagConstraints.BOTH;
		gbc_opisPoslaTxt.gridx = 1;
		gbc_opisPoslaTxt.gridy = 3;
		getContentPane().add(opisPoslaTxt, gbc_opisPoslaTxt);
		GridBagConstraints gbc_evidentirajPosaoBtn = new GridBagConstraints();
		gbc_evidentirajPosaoBtn.anchor = GridBagConstraints.NORTHEAST;
		gbc_evidentirajPosaoBtn.gridx = 1;
		gbc_evidentirajPosaoBtn.gridy = 4;
		getContentPane().add(evidentirajPosaoBtn, gbc_evidentirajPosaoBtn);
		
		
		
	
		
		//table.setFillsViewportHeight(true);
			
	
	}
	@Override
 	public void dispose() {
 		// TODO Auto-generated method stub
 		unistiInstancu();
 		super.dispose();
 	}

	
}