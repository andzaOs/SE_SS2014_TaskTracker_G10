package ServiseriGUI;



import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
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
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import Entity.RadniZadatak;
import Entity.RasporedjeniZadatak;
import Kontroleri.SessionControler;
import Kontroleri.ControlersServiseri.MojiZadaciControler;
import RacunovodstvoGUI.ONamaGUI;
import RacunovodstvoGUI.PromjenaSifreGUI;
import UtilClasses.DateLabelFormatter;
import UtilClasses.KorisnickoUputstvo;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;


public class PretragaMojihRadnihZadatakaGUI extends JFrame{
	private static List<RadniZadatak> zadaci;
	private static List<RadniZadatak> lista;
	private static List<RasporedjeniZadatak> rasporedjeniZadaci;
	
	private JTextField nazivKlijenta;
	private JTextField textField_1;
	private JLabel datumKreiranjaLbl_1;
	private JTextField textField_2;
	private JLabel vrstaRadnogzadatkaLbl;
	private JButton pretraziRadniZadatakBtn;
	private JMenuBar menuBar;
	private JMenu mojRacunMeni;
	private JMenuItem promjeniSifruItem;
	private JMenuItem odjaviSeItem;
	private JMenu pomocMeni;
	private JMenuItem korisnickoUpustvoItem;
	private JMenuItem oNamaItem;
	private JComboBox vrstaZadatkacombo;
	private JScrollPane scrollPane;
	private JTable table;
	private JCheckBox chckbxNepreuzeti;
	private JCheckBox chckbxPreuzeti;
	private JPanel panel;
	private JButton prikaziViseBtn;
	private JButton prihvatiZadatakBtn;
	private JButton oznaciKaoIzvrsenBtn;
	private JButton evidentirajPosaoBtn;
	final JDatePanelImpl datePanel1;
	final JDatePickerImpl datumIzvrsenja;
	final JDatePanelImpl datePanel ;
	final JDatePickerImpl datumKreiranja ;
	
	

	private static PretragaMojihRadnihZadatakaGUI instanca;
	 
	 
	 		public static PretragaMojihRadnihZadatakaGUI dajInstancu() {
	 			if(instanca==null) {
	  			instanca=new PretragaMojihRadnihZadatakaGUI();
	  			
	 			}
	 			return instanca;
	 		}
	 		public static void unistiInstancu() { instanca= null; }
		
		
	
	public PretragaMojihRadnihZadatakaGUI() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				 if(model.getRowCount()>0){   model.setRowCount(0); }
				 MojiZadaciControler controler=new MojiZadaciControler();
				try {
					controler.pronadji(SessionControler.getIdLog());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				rasporedjeniZadaci=controler.getRasporedjeniZadaci();
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
		
		
		setTitle("Moji radni zadaci");
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("right:default"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(91dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(82dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(105dlu;pref):grow"),},
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
		
		zadaci=new ArrayList<RadniZadatak>();
		lista=new ArrayList<RadniZadatak>();
		rasporedjeniZadaci=new ArrayList<RasporedjeniZadatak>();
		
		 MojiZadaciControler controler=new MojiZadaciControler();
		try {
			controler.pronadji(SessionControler.getIdLog());
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		zadaci=controler.getZadaci();
		lista=controler.getLista();
		rasporedjeniZadaci=controler.getRasporedjeniZadaci();
		
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "1, 8, 7, 17, fill, fill");
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Vrsta", "Naziv klijenta", "Opis", "Status"
			}
		)
		{public boolean isCellEditable(int row, int column) {
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
		
		JLabel datumKreiranjaLbl = new JLabel("Krajnji datum izvr\u0161enja:");
		getContentPane().add(datumKreiranjaLbl, "5, 2, right, default");
		
		
		UtilDateModel model1 = new UtilDateModel();
		 datePanel1 = new JDatePanelImpl(model1);
		 datumIzvrsenja = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		datumIzvrsenja.setAlignmentY(MAXIMIZED_BOTH);
		getContentPane().add(datumIzvrsenja, "7, 2, fill, fill");
		
		
		datumKreiranjaLbl_1 = new JLabel("Datum kreiranja:");
		getContentPane().add(datumKreiranjaLbl_1, "1, 4, right, default");
		
		
		UtilDateModel model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
	   datumKreiranja = new JDatePickerImpl(datePanel);
		final JDatePickerImpl datumKreiranjaDP = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	    datumKreiranja.setAlignmentY(MAXIMIZED_BOTH);
		getContentPane().add(datumKreiranja, "3, 4, fill, default");
		
		
		vrstaRadnogzadatkaLbl = new JLabel("Vrsta radnog zadatka:");
		getContentPane().add(vrstaRadnogzadatkaLbl, "5, 4, right, default");
		
		vrstaZadatkacombo = new JComboBox();
		vrstaZadatkacombo.setModel(new DefaultComboBoxModel(new String[] {"", "Hardver", "Softver"}));
		getContentPane().add(vrstaZadatkacombo, "7, 4, fill, default");
		
		pretraziRadniZadatakBtn = new JButton("Pretraga");
		ImageIcon traziIkona = new ImageIcon(getClass().getResource("SearchIcon.png"));
		pretraziRadniZadatakBtn.setIcon(traziIkona);
	
		
		pretraziRadniZadatakBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
                 MojiZadaciControler controler=new MojiZadaciControler();
				 String s=controler.pretraga(nazivKlijenta, datumIzvrsenja, datumKreiranja, vrstaZadatkacombo, chckbxNepreuzeti, chckbxPreuzeti, model,zadaci,rasporedjeniZadaci,lista);
				if( s.equals("")){lista=controler.getLista();}
				else{
					JOptionPane.showMessageDialog(rootPane, s, "Obavijest", JOptionPane.INFORMATION_MESSAGE);
					
				}
									
				
					
			}
		});
		
		chckbxNepreuzeti = new JCheckBox("Neprihva\u0107eni");
		getContentPane().add(chckbxNepreuzeti, "1, 6");
		
		chckbxPreuzeti = new JCheckBox("Prihva\u0107eni");
		getContentPane().add(chckbxPreuzeti, "3, 6");
		getContentPane().add(pretraziRadniZadatakBtn, "7, 6");
		
		
		
		
		panel = new JPanel();
		getContentPane().add(panel, "1, 26, 7, 1, fill, fill");
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		prikaziViseBtn = new JButton("Prika\u017Ei vi\u0161e");
		prikaziViseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
			                
						
						
						    RadniZadatak izabrani=new RadniZadatak();
						    MojiZadaciControler controler=new MojiZadaciControler();
						   String s= controler.prikaziVise(	 table.getSelectedRow(),(DefaultTableModel) table.getModel() );
						   if(s.equals("")){
							   if(lista.size()>0)izabrani=lista.get(table.getSelectedRow());
								else{izabrani=zadaci.get(table.getSelectedRow());}
							   PrikaziDetaljnoZadatak ex = new PrikaziDetaljnoZadatak(izabrani);}
						   else{
							   JOptionPane.showMessageDialog(rootPane, s, "Obavijest", JOptionPane.INFORMATION_MESSAGE);
						   }
							
							
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		panel.add(prikaziViseBtn);
		
		prihvatiZadatakBtn = new JButton("Prihvati zadatak");
		prihvatiZadatakBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int red = table.getSelectedRow();
				if(red==-1){JOptionPane.showMessageDialog(rootPane, "Niste odabrali niti  jedan red tabele!", "Obavijest", JOptionPane.INFORMATION_MESSAGE);}
				else{
				RadniZadatak izabrani=new RadniZadatak();
				if(lista.size()>0)izabrani=lista.get(red);
				else izabrani=zadaci.get(red);
			
	
				
		      
				
					MojiZadaciControler controler=new MojiZadaciControler();
				if(rasporedjeniZadaci.size()>0){

					
								if(controler.PreuzmiZadatak(izabrani, rasporedjeniZadaci)==true){
									if(chckbxNepreuzeti.isSelected()==true){
										DefaultTableModel model = (DefaultTableModel) table.getModel();
										model.removeRow(red);
										
									}
								JOptionPane.showMessageDialog(rootPane, "Uspješno ste prihvatili zadatak", "Obavijest", JOptionPane.INFORMATION_MESSAGE);

								
							}
							else{JOptionPane.showMessageDialog(rootPane, "Vec radite na ovome zadatku!", "Obavijest", JOptionPane.INFORMATION_MESSAGE);

							
							}
							
							}
								
					
				
					}
					
					
//				}
				
			}
					
				
				
				
				
				
			
		});
		panel.add(prihvatiZadatakBtn);
		
		oznaciKaoIzvrsenBtn = new JButton("Ozna\u010Di kao izvr\u0161en");
		oznaciKaoIzvrsenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int red = table.getSelectedRow();
				//RasporedjeniZadatakDAO tDAO= new RasporedjeniZadatakDAO();
				if(red==-1){JOptionPane.showMessageDialog(rootPane, "Niste odabrali niti  jedan red tabele!", "Obavijest", JOptionPane.INFORMATION_MESSAGE);}
				else{
					List<RadniZadatak>radna= new ArrayList<RadniZadatak>();
					if(lista.size()>0) radna=lista;
					else radna=zadaci;
					if(radna.get(red).getStatusIzvrsenosti()==true){
						JOptionPane.showMessageDialog(rootPane, "Zadatak je vec izvrsen", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						
						
						 MojiZadaciControler controler1=new MojiZadaciControler();
						String s=controler1.oznaciKaoizvrsen(red,radna,rasporedjeniZadaci);
						if(s.equals("")){

						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setValueAt("izvrsen", red, 3);
						JOptionPane.showMessageDialog(rootPane, "Označili ste kao izvršen", "Obavijest", JOptionPane.INFORMATION_MESSAGE);}
						else{
							JOptionPane.showMessageDialog(rootPane, s, "Obavijest", JOptionPane.INFORMATION_MESSAGE);
							
						}
						
						
					}
					
					
			
			}}
		});
		panel.add(oznaciKaoIzvrsenBtn);
		
		evidentirajPosaoBtn = new JButton("Evidentiraj posao");
		evidentirajPosaoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() 
				{
					public void run() 
					{
						int red=table.getSelectedRow();
						if(red==-1){JOptionPane.showMessageDialog(rootPane, "Niste odabrali niti  jedan red tabele!", "Obavijest", JOptionPane.INFORMATION_MESSAGE);}
						else{
						Boolean nadjen = false;
						int in=0;
						List<RadniZadatak> radna=new ArrayList<RadniZadatak>();
						if(lista.size()>0) radna=lista;
						else radna=zadaci;
						if(radna.get(red).getStatusIzvrsenosti()==true){JOptionPane.showMessageDialog(rootPane, "Ovaj zadatak je vec izvrsen!", "Obavijest", JOptionPane.INFORMATION_MESSAGE);}
						else{
						for(int i=0;i<rasporedjeniZadaci.size();i++){
							Long br=rasporedjeniZadaci.get(i).getZadatak().getRadniZadatak_id();
							if(br.equals(radna.get(red).getRadniZadatak_id()) && rasporedjeniZadaci.get(i).getStatusPrihvacenosti()==true ){nadjen=true;
							in=i;
							break;
							}
						}
						if(nadjen==true){
						EvidentiranjeObavljenogPoslaGUI ex =   new EvidentiranjeObavljenogPoslaGUI(rasporedjeniZadaci.get(in));
						ex.setVisible(true);
						}
						else{
							JOptionPane.showMessageDialog(rootPane, "Da biste evidentirali posao, morate prihvatiti zadatak prvo", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
							
						}
						
					}}}
				});
			}
		});
		panel.add(evidentirajPosaoBtn);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mojRacunMeni = new JMenu("Moj ra\u010Dun");
		menuBar.add(mojRacunMeni);
		
		promjeniSifruItem = new JMenuItem("Promijeni \u0161ifru");
		promjeniSifruItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmPromjenaifre = new JFrame();
				PromjenaSifreGUI window = new PromjenaSifreGUI();
			}
		});
		mojRacunMeni.add(promjeniSifruItem);
		
		odjaviSeItem = new JMenuItem("Odjavi se");
		odjaviSeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		mojRacunMeni.add(odjaviSeItem);
		
		pomocMeni = new JMenu("Pomo\u0107");
		menuBar.add(pomocMeni);
		
		korisnickoUpustvoItem = new JMenuItem("Korisni\u010Dko upustvo");
		korisnickoUpustvoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KorisnickoUputstvo kp = new KorisnickoUputstvo();
				kp.dobaviUputstvoServiseri();	
			}
		});
		pomocMeni.add(korisnickoUpustvoItem);
		
		oNamaItem = new JMenuItem("O nama");
		oNamaItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ONamaGUI window = new ONamaGUI();
				window.setVisible(true);
				window.setSize(350,150);
				window.setLocationRelativeTo(null);
			}
		});
		pomocMeni.add(oNamaItem);

	
	
	
	
}
	@Override
	 	public void dispose() {
	 		// TODO Auto-generated method stub
	 		unistiInstancu();
	 		super.dispose();
	 	}
	
	
}
