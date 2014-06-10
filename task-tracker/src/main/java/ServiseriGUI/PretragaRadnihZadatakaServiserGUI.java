package ServiseriGUI;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import Entity.RadniZadatak;
import Entity.RasporedjeniZadatak;
import Kontroleri.SessionControler;
import Kontroleri.ControlersServiseri.RadniZadaciControler;
import RacunovodstvoGUI.ONamaGUI;
import RacunovodstvoGUI.OdjaviSeGUI;
import RacunovodstvoGUI.PromjenaSifreGUI;
import UtilClasses.KorisnickoUputstvo;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;


public class PretragaRadnihZadatakaServiserGUI extends JFrame{
	private static List<RadniZadatak> zadaci;
	private static List<RadniZadatak> lista;
	private static List<RasporedjeniZadatak> rasporedjeniZadaci;
	private long IdRadnika;
	private JTextField nazivKlijenta;
	private JLabel datumKreiranjaLbl;
	private JLabel lblVrstaRadnogZadatka;
	private JButton pretraziRadniZadatakBtn;
	private JMenuBar menuMenuBar;
	private JMenu mojRacunMenu;
	private JMenuItem promijeniSifruItem;
	private JMenuItem odjaviSeItem;
	private JMenu pomocMenu;
	private JMenuItem korisnickoUputstvoItem;
	private JMenuItem oNamaItem;
	private JComboBox vrstaZadatkacombo;
	private JButton prikaziViseBtn;
	private JButton preuzmiRadniZadatakBtn;
	private JScrollPane scrollPane;
	private JTable table;
	final JDatePanelImpl datePanel1;
	final JDatePickerImpl datumIzvrsenja;
    final JDatePanelImpl datePanel ;
	final JDatePickerImpl datumKreiranja ;
	private static PretragaRadnihZadatakaServiserGUI instanca;
	 
	 
	public static PretragaRadnihZadatakaServiserGUI dajInstancu() {
		if(instanca==null) {
		instanca=new PretragaRadnihZadatakaServiserGUI();
		
		}
		return instanca;
	}
	public static void unistiInstancu() { instanca= null; }
	
	
	
		
public PretragaRadnihZadatakaServiserGUI() {
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	addWindowFocusListener(new WindowFocusListener() {
		public void windowGainedFocus(WindowEvent arg0) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			 if(model.getRowCount()>0){   model.setRowCount(0); }
			 RadniZadaciControler controler=new RadniZadaciControler();
			try {
				controler.pronadji(SessionControler.getIdLog());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
			zadaci=controler.getZadaci();
			lista=controler.getLista();
			try {
				if(lista.size()>0){controler.ispisi(model, lista);}
				else{
				controler.ispisi(model, zadaci);}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		}
		public void windowLostFocus(WindowEvent arg0) {
		}
	});
		
		setTitle("Radni zadaci");
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("right:default"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("min:grow"),},
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

		
		IdRadnika=1;
		zadaci=new ArrayList<RadniZadatak>();
		lista=new ArrayList<RadniZadatak>();
		rasporedjeniZadaci=new ArrayList<RasporedjeniZadatak>();
		
		 RadniZadaciControler controler=new RadniZadaciControler();
		try {
			controler.pronadji(SessionControler.getIdLog());
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		zadaci=controler.getZadaci();
		lista=controler.getLista();
	
		
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "1, 8, 7, 17, fill, fill");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Vrsta", "Klijent", "Opis"
			}
		){public boolean isCellEditable(int row, int column) {
			return false;
		}});
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultTableModel model2 = (DefaultTableModel) table.getModel();
	try {
		controler.ispisi(model2, zadaci);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
		JLabel nazivKlijentaLbl = new JLabel("Naziv klijenta:");
		getContentPane().add(nazivKlijentaLbl, "1, 2, right, default");
		
		nazivKlijenta = new JTextField();
		getContentPane().add(nazivKlijenta, "3, 2, fill, default");
		nazivKlijenta.setColumns(10);
		
		JLabel krajnjiDatumLbl = new JLabel("Krajnji datum izvr\u0161enja:");
		getContentPane().add(krajnjiDatumLbl, "5, 2, right, default");
		
		 UtilDateModel model1 = new UtilDateModel();
		 datePanel1 = new JDatePanelImpl(model1);
		 datumIzvrsenja = new JDatePickerImpl(datePanel1);
		datumIzvrsenja.setAlignmentY(MAXIMIZED_BOTH);
		getContentPane().add(datumIzvrsenja, "7, 2, fill, fill");
		
		
		datumKreiranjaLbl = new JLabel("Datum kreiranja:");
		getContentPane().add(datumKreiranjaLbl, "1, 4, right, default");
		
		UtilDateModel model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
	    datumKreiranja = new JDatePickerImpl(datePanel);
		datumKreiranja.setAlignmentY(MAXIMIZED_BOTH);
		getContentPane().add(datumKreiranja, "3, 4, fill, default");
		
		
		lblVrstaRadnogZadatka = new JLabel("Vrsta radnog zadatka:");
		getContentPane().add(lblVrstaRadnogZadatka, "5, 4, right, default");
		
		vrstaZadatkacombo= new JComboBox();
		vrstaZadatkacombo.setModel(new DefaultComboBoxModel(new String[] {"", "Hardver", "Softver"}));
		getContentPane().add(vrstaZadatkacombo, "7, 4, fill, default");
		
		pretraziRadniZadatakBtn = new JButton("Pretraga");
		ImageIcon traziIkona = new ImageIcon(getClass().getResource("SearchIcon.png"));
		pretraziRadniZadatakBtn.setIcon(traziIkona);
		pretraziRadniZadatakBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
                RadniZadaciControler controler=new RadniZadaciControler();
				 String s=controler.pretraga(nazivKlijenta, datumIzvrsenja, datumKreiranja, vrstaZadatkacombo,model,zadaci,rasporedjeniZadaci,lista);
				if( s.equals("")){lista=controler.getLista();}
				else{
					JOptionPane.showMessageDialog(rootPane, s, "Obavijest", JOptionPane.INFORMATION_MESSAGE);
					
				}
				
				if(datumIzvrsenja.getModel().getValue()!=null)datumIzvrsenja.getModel().setValue(null);		
				datumIzvrsenja.getJFormattedTextField().setText("");
			}
		});
		getContentPane().add(pretraziRadniZadatakBtn, "7, 6");
		
		
		
		prikaziViseBtn = new JButton("Prika\u017Ei vi\u0161e");
		prikaziViseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                     RadniZadatak izabrani=new RadniZadatak();
				    RadniZadaciControler controler=new RadniZadaciControler();
				   String s= controler.prikaziVise(	 table.getSelectedRow(),(DefaultTableModel) table.getModel() );
				   if(s.equals("")){
					   if(lista.size()>0)izabrani=lista.get(table.getSelectedRow());
						else{izabrani=zadaci.get(table.getSelectedRow());}
					   PrikaziDetaljnoZadatak ex = new PrikaziDetaljnoZadatak(izabrani);}
				   else{
					   JOptionPane.showMessageDialog(rootPane, s, "Obavijest", JOptionPane.INFORMATION_MESSAGE);
				   }
				
			}
		});
		getContentPane().add(prikaziViseBtn, "1, 26, 6, 1");
		
		preuzmiRadniZadatakBtn = new JButton("Preuzmi radni zadatak");
		preuzmiRadniZadatakBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int red = table.getSelectedRow();

				 RadniZadaciControler controler=new RadniZadaciControler();
				String s=controler.preuzmiRadniZadatak(red,zadaci,lista,SessionControler.getIdLog());
				 JOptionPane.showMessageDialog(rootPane, s, "Obavijest", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		getContentPane().add(preuzmiRadniZadatakBtn, "7, 26");
		
		menuMenuBar = new JMenuBar();
		setJMenuBar(menuMenuBar);
		
		mojRacunMenu = new JMenu("Moj ra\u010Dun");
		menuMenuBar.add(mojRacunMenu);
		
		promijeniSifruItem = new JMenuItem("Promijeni \u0161ifru");
		promijeniSifruItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmPromjenaifre = new JFrame();
				PromjenaSifreGUI window = new PromjenaSifreGUI();
			}
		});
		mojRacunMenu.add(promijeniSifruItem);
		
		odjaviSeItem = new JMenuItem("Odjavi se");
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
		mojRacunMenu.add(odjaviSeItem);
		
		pomocMenu = new JMenu("Pomo\u0107");
		menuMenuBar.add(pomocMenu);
		
		korisnickoUputstvoItem = new JMenuItem("Korisni\u010Dko upustvo");
		korisnickoUputstvoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KorisnickoUputstvo kp = new KorisnickoUputstvo();
				kp.dobaviUputstvoServiseri();	
			}
		});
		pomocMenu.add(korisnickoUputstvoItem);
		
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
