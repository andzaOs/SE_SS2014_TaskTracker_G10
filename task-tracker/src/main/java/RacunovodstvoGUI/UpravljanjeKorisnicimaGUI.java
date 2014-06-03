package RacunovodstvoGUI;



import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAO.KorisnikDAO;
import Entity.Korisnik;
import Kontroleri.KorisnikKontroler;
import UtilClasses.KorisnickoUputstvo;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class UpravljanjeKorisnicimaGUI extends JFrame{
		
	private JTextField imeTxt;
	private JButton pretraziBtn;
	private JMenuBar glavniMenuBar;
	private JMenu mojRacunMenu;
	private JMenuItem promijeniSifruItem;
	private JMenuItem odjaviSeItem;
	private JMenu pomocMenu;
	private JMenuItem korisnickoUputstvoItem;
	private JMenuItem oNamaItem;
	private JScrollPane tabelaPane;
	private JTable podaciTbl;
	private JPanel juzniPanel;
	private JButton modifikujBtn;
	private JButton obrisiBtn;
	private JToolBar glavniToolBar;
	private JLabel prezimeLbl;
	private JTextField prezimeTxt;
	private JLabel jmbgLbl;
	private JTextField jmbgTxt;
	private JMenu alatiMenu;
	private JMenuItem sistemObavjetavanjaItem;
	private JButton btnPrikaiVie;

	private JTable table;
	private static UpravljanjeKorisnicimaGUI instanca;
	public UpravljanjeKorisnicimaGUI() {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			initialize();
		}
		public static UpravljanjeKorisnicimaGUI dajInstancu() {
			if(instanca==null) {
 			instanca=new UpravljanjeKorisnicimaGUI();
 			
			}
			return instanca;
		}
	public static void unistiInstancu() { instanca= null; }
	
	

	

	public void initialize() {
		
	setTitle("Upravljanje korisnicima");
	getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("right:default"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
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
	
	
		
 final String imenaKolona[]=  {"Ime", "Prezime", "JMBG", "Korisničko ime", "E-mail", "Tip Korisnika"};		
 
 final DefaultTableModel tableModel = new DefaultTableModel(imenaKolona, 0){
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	

final KorisnikKontroler kKontroler = new KorisnikKontroler();	
try{
	kKontroler.napuniTabelu(tableModel);
}
catch (Exception e)
{
	
}
final JTable podaciTbl = new JTable(tableModel);
	
	addWindowFocusListener(new WindowFocusListener() {
		public void windowGainedFocus(WindowEvent e) {
		tableModel.setRowCount(0);
			podaciTbl.setModel(tableModel);
			try {
			kKontroler.napuniTabelu(tableModel);
			}
			catch (Exception ex)
			{}
		}
		public void windowLostFocus(WindowEvent e) {
			
		}
	});
		
		glavniToolBar = new JToolBar();
		getContentPane().add(glavniToolBar, "1, 2");
		ImageIcon dodajIkona = new ImageIcon(getClass().getResource("AddIcon.png"));
		JButton kreiraKorisnikajBtn = new JButton(dodajIkona);
		kreiraKorisnikajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
				     public void run() {
				          KreiranjeKorisnikaGUI ex = KreiranjeKorisnikaGUI.dajInstancu();
				          ex.setSize(400, 500);
				          ex.setLocationRelativeTo(null);
				          ex.setVisible(true);
				      }
				});				
			}
		});
		kreiraKorisnikajBtn.setText("Novi korisnik");
		glavniToolBar.add(kreiraKorisnikajBtn);
		
		JLabel imeLbl = new JLabel("Ime:");
		getContentPane().add(imeLbl, "1, 4, right, default");
		
		imeTxt = new JTextField();
		getContentPane().add(imeTxt, "3, 4, fill, fill");
		imeTxt.setColumns(10);
		
		pretraziBtn = new JButton("Pretraži");
		ImageIcon traziIkona = new ImageIcon(getClass().getResource("SearchIcon.png"));
		pretraziBtn.setIcon(traziIkona);
		pretraziBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableModel.setRowCount(0);
				podaciTbl.setModel(tableModel);
				try {
					kKontroler.napuniTabeluFiltrirano(tableModel, imeTxt.getText(), prezimeTxt.getText(), jmbgTxt.getText());
				}
				catch (Exception e)
				{}
				imeTxt.setText("");
				prezimeTxt.setText("");
				jmbgTxt.setText("");
				
			}
			
		});
		
		
		prezimeLbl = new JLabel("Prezime:");
		getContentPane().add(prezimeLbl, "5, 4, right, default");
		
		prezimeTxt = new JTextField();
		getContentPane().add(prezimeTxt, "7, 4, fill, default");
		prezimeTxt.setColumns(10);
		
		jmbgLbl = new JLabel("JMBG");
		getContentPane().add(jmbgLbl, "9, 4, right, default");
		
		jmbgTxt = new JTextField();
		getContentPane().add(jmbgTxt, "11, 4, fill, default");
		jmbgTxt.setColumns(10);
		getContentPane().add(pretraziBtn, "13, 4, right, default");
	
		tabelaPane = new JScrollPane();
		getContentPane().add(tabelaPane, "1, 6, 15, 17, fill, fill");
		
	
		
		tabelaPane.setViewportView(podaciTbl); 
			
		
		juzniPanel = new JPanel();
		getContentPane().add(juzniPanel, "1, 24, 15, 1, fill, fill");
		juzniPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		modifikujBtn = new JButton("Modifikuj korisnika");
		modifikujBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
	 		        	if((podaciTbl.getSelectedRowCount())==0) {
		            		JOptionPane.showMessageDialog(rootPane, "Označite korisnika!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
		            	}
	 		        	else {
	 		        		int i = podaciTbl.convertRowIndexToModel(podaciTbl.getSelectedRow());
	 		        		kKontroler.otvoriModifikaciju(i);
	 		        	}
	 		        }
				});		
			}
		});
		
		
		btnPrikaiVie = new JButton("Prikaži više");
		btnPrikaiVie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							if((podaciTbl.getSelectedRowCount())==0) {
			            		JOptionPane.showMessageDialog(rootPane, "Označite korisnika!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
			            	}
		 		        	else {
		 		        		int i = podaciTbl.convertRowIndexToModel(podaciTbl.getSelectedRow());
		 		        		kKontroler.prikaziVise(i);
		 		        	}
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		juzniPanel.add(btnPrikaiVie);
		juzniPanel.add(modifikujBtn);
		
		obrisiBtn = new JButton("Obriši korisnika");
		obrisiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		            	if((podaciTbl.getSelectedRowCount())==0) {
		            		JOptionPane.showMessageDialog(rootPane, "Označite korisnika!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
		            	}
	 		        	else {
	 		        		int i = podaciTbl.convertRowIndexToModel(podaciTbl.getSelectedRow());
	 		        		kKontroler.otvoriBrisanje(i);
	 		        	}
		            }
		        });
			}
		});
		juzniPanel.add(obrisiBtn);
		

		glavniMenuBar = new JMenuBar();
		setJMenuBar(glavniMenuBar);
		
		mojRacunMenu = new JMenu("Moj račun");
		glavniMenuBar.add(mojRacunMenu);
		
		promijeniSifruItem = new JMenuItem("Promijeni šifru");
		promijeniSifruItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							PromjenaSifreGUI window = new PromjenaSifreGUI();
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
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
		
		alatiMenu = new JMenu("Alati");
		glavniMenuBar.add(alatiMenu);
		
		sistemObavjetavanjaItem = new JMenuItem("Sistem obavještavanja");
		sistemObavjetavanjaItem.addActionListener(new ActionListener() {
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
		alatiMenu.add(sistemObavjetavanjaItem);
		
		pomocMenu = new JMenu("Pomoć");
		glavniMenuBar.add(pomocMenu);
		
		oNamaItem = new JMenuItem("O nama");
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
		
		korisnickoUputstvoItem = new JMenuItem("Korisničko uputstvo");
		korisnickoUputstvoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KorisnickoUputstvo kp = new KorisnickoUputstvo();
				kp.dobaviUputstvo();
			}
		});
		pomocMenu.add(korisnickoUputstvoItem);

}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		UpravljanjeKorisnicimaGUI.unistiInstancu();
		super.dispose();
	}
   
}

