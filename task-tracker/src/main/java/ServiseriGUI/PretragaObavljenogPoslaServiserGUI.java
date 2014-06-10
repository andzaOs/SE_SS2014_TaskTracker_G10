package ServiseriGUI;



import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import Entity.ObavljeniPosao;
import Kontroleri.SessionControler;
import Kontroleri.ControlersServiseri.ObavljeniPosaoControler;
import RacunovodstvoGUI.ONamaGUI;
import RacunovodstvoGUI.PromjenaSifreGUI;
import UtilClasses.DateLabelFormatter;
import UtilClasses.KorisnickoUputstvo;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;


public class PretragaObavljenogPoslaServiserGUI extends JFrame{
	private JLabel pocetniDatumLbl;
	private JTextField pocetniDatumTxt;
	private JLabel krajnjiDatumLbl;
	private JButton pretraziRadniZadatakBtn;
	private JMenuBar menuBar;
	private JMenu mojRacunMenu;
	private JMenuItem promijeniSifruItem;
	private JMenuItem odjaviSeItem;
	private JMenu pomocMenu;
	private JMenuItem korisnikovoUputstvoItemo;
	private JMenuItem oNamaItem;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;
	private JButton prikaziViseBtn;
	private JButton btnPreuzmiRadniZadatak;
	final JDatePanelImpl datePanel ;
	final JDatePickerImpl datumObavljanja ;
	final JTextField nazivKlijenta;
	final JComboBox comboUsluga;
	private long IdRadnika;
	private static List<ObavljeniPosao> posao;
	private static List<ObavljeniPosao> lista;
	final JSpinner spinnSati;
	
	
	 

	
	
	private static  PretragaObavljenogPoslaServiserGUI instanca;
	 
	 
		public static  PretragaObavljenogPoslaServiserGUI dajInstancu() {
			if(instanca==null) {
			instanca=new  PretragaObavljenogPoslaServiserGUI();
			
			}
			return instanca;
		}
		public static void unistiInstancu() { instanca= null; }
	
	public PretragaObavljenogPoslaServiserGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				 if(model.getRowCount()>0){   model.setRowCount(0); }
				 ObavljeniPosaoControler controler=new ObavljeniPosaoControler();
				try {
					controler.pronadji(SessionControler.getIdLog());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				posao=controler.getPosao();
				lista=controler.getLista();
				try {
					if(lista.size()>0){controler.Ispisi(lista, model);}
					else{
					controler.Ispisi(posao,model);}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
				 
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		
		
		setTitle("Historija obavljenog posla");
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("right:default"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		lista=new ArrayList<ObavljeniPosao>();
		posao=new ArrayList<ObavljeniPosao>();
		IdRadnika=1;
		ObavljeniPosaoControler controler=new ObavljeniPosaoControler();
		try {
			controler.pronadji(SessionControler.getIdLog());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lista=controler.getLista();
		posao=controler.getPosao();
		
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "1, 8, 7, 17, fill, fill");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Datum obavljanja", "Utro\u0161eni sati", "Vrsta usluge"
			}
		){public boolean isCellEditable(int row, int column) {
			return false;
		}});
		table.getColumnModel().getColumn(0).setPreferredWidth(128);
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultTableModel model2 = (DefaultTableModel) table.getModel();
		controler.Ispisi(posao, model2);

		
		
		
		JLabel nazivKlijentaLbl = new JLabel("Naziv klijenta:");
		getContentPane().add(nazivKlijentaLbl, "1, 2, right, default");
		
		nazivKlijenta = new JTextField();
		getContentPane().add(nazivKlijenta, "3, 2, fill, default");
		nazivKlijenta.setColumns(10);
		
		JLabel vrstaZadatkaLbl = new JLabel("Vrsta usluge:");
		getContentPane().add(vrstaZadatkaLbl, "5, 2, right, default");
		
		comboUsluga = new JComboBox();
		comboUsluga.setModel(new DefaultComboBoxModel(new String[] {"", "Instalacija OS-a", "Zamjena hard diska", "Instalcija rootera"}));
		getContentPane().add(comboUsluga, "7, 2, fill, default");
		
		pocetniDatumLbl = new JLabel("Datum obavljanja:");
		getContentPane().add(pocetniDatumLbl, "1, 4, right, default");
		
		UtilDateModel model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
	   datumObavljanja = new JDatePickerImpl(datePanel);
		final JDatePickerImpl datumKreiranjaDP = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	    datumObavljanja.setAlignmentY(MAXIMIZED_BOTH);
		getContentPane().add(datumObavljanja, "3, 4, fill, default");
		
		
		krajnjiDatumLbl = new JLabel("Broj sati:");
		getContentPane().add(krajnjiDatumLbl, "5, 4, right, default");
		
		pretraziRadniZadatakBtn = new JButton("Pretraga");
		ImageIcon traziIkona = new ImageIcon(getClass().getResource("SearchIcon.png"));
		pretraziRadniZadatakBtn.setIcon(traziIkona);
		pretraziRadniZadatakBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();
                ObavljeniPosaoControler controler=new ObavljeniPosaoControler();
				 String s=controler.pretraga(nazivKlijenta, datumObavljanja, comboUsluga, spinnSati, model, lista, posao);
				if( s.equals("")){lista=controler.getLista();}
				else{
					JOptionPane.showMessageDialog(rootPane, s, "Obavijest", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		
		spinnSati = new JSpinner();
		spinnSati.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		getContentPane().add(spinnSati, "7, 4");
		getContentPane().add(pretraziRadniZadatakBtn, "7, 6");
		
		
		
		panel = new JPanel();
		getContentPane().add(panel, "1, 26, 7, 1, fill, fill");
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		prikaziViseBtn = new JButton("Prika\u017Ei vi\u0161e");
		prikaziViseBtn.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		prikaziViseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				 ObavljeniPosao izabrani=new ObavljeniPosao();
				    ObavljeniPosaoControler controler=new ObavljeniPosaoControler();
				   String s= controler.prikaziVise(	 table.getSelectedRow(),(DefaultTableModel) table.getModel() );
				   if(s.equals("")){
					   if(lista.size()>0)izabrani=lista.get(table.getSelectedRow());
						else{izabrani=posao.get(table.getSelectedRow());}
					   PrikaziViseObavljenogPoslaGUI window = new PrikaziViseObavljenogPoslaGUI(izabrani);}
				   else{
					   JOptionPane.showMessageDialog(rootPane, s, "Obavijest", JOptionPane.INFORMATION_MESSAGE);
				   }
				}
		});
		panel.add(prikaziViseBtn);
		
		btnPreuzmiRadniZadatak =new JButton("Modifikuj obavljeni posao");
		btnPreuzmiRadniZadatak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int red = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if(red == -1) { 
					JOptionPane.showMessageDialog(rootPane, "Niste ozna�ili red u tabeli.", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
				if(model.getRowCount()>0){
				if(red > model.getRowCount() ) {
					JOptionPane.showMessageDialog(rootPane, "Nije ozna�en ni jedan zadatak.", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
				} 
				else {
					ObavljeniPosao po= new ObavljeniPosao();
					if (lista.size()>0){po=lista.get(red);}
					else{po=posao.get(red);}
				  
					ModifikacijaObavljenogPoslaGUI ex =  new  ModifikacijaObavljenogPoslaGUI(po);
				    ex.setVisible(true);
					
				     
					
				}}
				
				
			
		
				}
			
			}
		});
		panel.add(btnPreuzmiRadniZadatak);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mojRacunMenu = new JMenu("Moj ra\u010Dun");
		menuBar.add(mojRacunMenu);
		
		promijeniSifruItem = new JMenuItem("Promijeni \u0161ifru");
		promijeniSifruItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PromjenaSifreGUI window = new PromjenaSifreGUI();
			}
		});
		mojRacunMenu.add(promijeniSifruItem);
		
		odjaviSeItem = new JMenuItem("Odjavi se");
		odjaviSeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		mojRacunMenu.add(odjaviSeItem);
		
		pomocMenu = new JMenu("Pomo\u0107");
		menuBar.add(pomocMenu);
		
		korisnikovoUputstvoItemo = new JMenuItem("Korisni\u010Dko upustvo");
		korisnikovoUputstvoItemo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KorisnickoUputstvo kp = new KorisnickoUputstvo();
				kp.dobaviUputstvoServiseri();	
			}
		});
		pomocMenu.add(korisnikovoUputstvoItemo);
		
		oNamaItem = new JMenuItem("O nama");
		oNamaItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ONamaGUI window = new ONamaGUI();
				window.setVisible(true);
				window.setSize(350,150);
				window.setLocationRelativeTo(null);
			}
		});
		pomocMenu.add(oNamaItem);

	
	
	
	
}
	@Override
 	public void dispose() {
 		// TODO Auto-generated method stub
 		unistiInstancu();
 		super.dispose();
 	}
}
