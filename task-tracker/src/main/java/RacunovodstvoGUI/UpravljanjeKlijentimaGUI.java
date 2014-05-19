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
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import DAO.KlijentDAO;
import Entity.Klijent;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.WindowAdapter;


public class UpravljanjeKlijentimaGUI extends JFrame{
	private JButton pretraziRadniZadatakBtn;
	private JMenuBar menuBar;
	private JMenu mojRacunMenu;
	private JMenuItem promijeniSifruItem;
	private JMenuItem odjaviSeItem;
	private JMenu pomocMenu;
	private JMenuItem korisnickoUputstvoItem;
	private JMenuItem oNamaItem;
	private JScrollPane tabelPane;
	
	private JPanel panel;
	private JButton modifikujKlijentaBtn;
	private JButton obrisiKlijentaBtn;
	private JToolBar toolBar;
	private JTextField nazivTxt;
	private JMenu alatiMenu;
	private JMenuItem sistemObavjestavanjaItem;
	private List<Klijent> klijenti;
	
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               UpravljanjeKlijentimaGUI ex = new UpravljanjeKlijentimaGUI();
                ex.setSize(1000, 350);
                ex.setLocationRelativeTo(null);
                ex.setVisible(true);
            }
        });
	}
	
	public void napuniTabelu(DefaultTableModel t) {
		
		KlijentDAO kDAO = new KlijentDAO();
 		klijenti = kDAO.getAll(); 
 		for(int i=0; i<klijenti.size(); i++) {
 			if(klijenti.get(i).getVidljivo()) {
				String naziv = klijenti.get(i).getNaziv(); 
				String telefon = klijenti.get(i).getBroj_telefona(); 
				String adresa = klijenti.get(i).getAdresa();
				String mail = klijenti.get(i).getEmail();
				
				Object[] o = {naziv, telefon, adresa, mail};
				
				t.addRow(o);
 			}
 			else {
 				klijenti.remove(i);
 				i=i-1;;
 			}
 		}
	}
	
	public void napuniTabeluFiltrirano(DefaultTableModel t, String n) {
		
		KlijentDAO kDAO = new KlijentDAO();
 		klijenti = kDAO.getByNaziv(n); 
 		
 		for(int i=0; i<klijenti.size(); i++) {
 			if(klijenti.get(i).getVidljivo()) {
				String naziv = klijenti.get(i).getNaziv(); 
				String telefon = klijenti.get(i).getBroj_telefona(); 
				String adresa = klijenti.get(i).getAdresa();
				String mail = klijenti.get(i).getEmail();
				
				Object[] o = {naziv, telefon, adresa, mail};
				
				t.addRow(o);
 			}
 			else {
 				klijenti.remove(i);
 				i=i-1;
 			}
 		
 		}
	}
	
	public UpravljanjeKlijentimaGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		setTitle("Upravljanje klijentima");
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
		
		
	
		
		toolBar = new JToolBar();
		getContentPane().add(toolBar, "1, 2");
		ImageIcon dodajIkona = new ImageIcon(getClass().getResource("AddIcon.png"));
		JButton kreirajKlijentaBtn = new JButton(dodajIkona);
		kreirajKlijentaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
	 		        public void run() {
	 		           KreiranjeKlijentaGUI ex = KreiranjeKlijentaGUI.dajInstancu();
	 		           ex.setSize(250,200);
	 		            ex.setVisible(true);
	 		            ex.setLocationRelativeTo(null);
	 		        	
	 		        }
	 		    });
			}
		});
		kreirajKlijentaBtn.setText("Novi klijent");
		toolBar.add(kreirajKlijentaBtn);
		
		pretraziRadniZadatakBtn = new JButton("Pretra\u017Ei");
		ImageIcon traziIkona = new ImageIcon(getClass().getResource("SearchIcon.png"));
		pretraziRadniZadatakBtn.setIcon(traziIkona);
		
		
		JLabel imeLbl = new JLabel("Naziv klijenta:");
		getContentPane().add(imeLbl, "1, 4, right, default");
		
		nazivTxt = new JTextField();
		getContentPane().add(nazivTxt, "3, 4, 9, 1, fill, default");
		nazivTxt.setColumns(10);
		getContentPane().add(pretraziRadniZadatakBtn, "13, 4, right, default");
		
		tabelPane = new JScrollPane();
		getContentPane().add(tabelPane, "1, 6, 15, 17, fill, fill");
				
		
		
		
		final String imenaKolona[]=  {"Naziv", "Broj telefona", "Adresa", "E-mail"};		
		
		final DefaultTableModel tableModel = new DefaultTableModel(imenaKolona, 0);
		
		napuniTabelu(tableModel);
	
		final JTable podaciTbl = new JTable(tableModel);
		
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				tableModel.setRowCount(0);
				podaciTbl.setModel(tableModel);
				napuniTabelu(tableModel);
			}
			public void windowLostFocus(WindowEvent e) {
				
			}
		});
		
		pretraziRadniZadatakBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableModel.setRowCount(0);
				podaciTbl.setModel(tableModel);
				napuniTabeluFiltrirano(tableModel, nazivTxt.getText());
				nazivTxt.setText("");
			}
		});
		
		podaciTbl.getColumnModel().getColumn(1).setPreferredWidth(84);
		tabelPane.setViewportView(podaciTbl);
		
		panel = new JPanel();
		getContentPane().add(panel, "1, 24, 15, 1, fill, fill");
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		podaciTbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);        
		
		modifikujKlijentaBtn = new JButton("Modifikuj klijenta");
		modifikujKlijentaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
	 		        public void run() {
	 		        	if((podaciTbl.getSelectedRowCount())==0) {
		            		JOptionPane.showMessageDialog(rootPane, "Označite klijenta!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
		            	}
	 		        	else {
		 		        	Klijent selektovani = klijenti.get(podaciTbl.convertRowIndexToModel(podaciTbl.getSelectedRow()));		 		        	
		 		            ModifikovanjeKlijentaGUI ex = ModifikovanjeKlijentaGUI.dajInstancu(selektovani.getKlijent_id());
		 		            ex.setSize(250,200);
		 		            ex.setVisible(true);
		 		            ex.setLocationRelativeTo(null);
	 		        	}
	 		        }
	 		    });
			}
		});
		panel.add(modifikujKlijentaBtn);
		
		obrisiKlijentaBtn = new JButton("Obri\u0161i klijenta");
		obrisiKlijentaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		            	if((podaciTbl.getSelectedRowCount())==0) {
		            		JOptionPane.showMessageDialog(rootPane, "Označite klijenta!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
		            	}
		            	else {
			            	Klijent selektovani = klijenti.get(podaciTbl.convertRowIndexToModel(podaciTbl.getSelectedRow()));
			                IzbrisiKlijentaGUI ex = new IzbrisiKlijentaGUI(selektovani.getKlijent_id());
			                ex.setSize(600, 150);
			                ex.setLocationRelativeTo(null);
			                ex.setVisible(true);
		            	}
		            }
		        });
			}
		});
		panel.add(obrisiKlijentaBtn);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mojRacunMenu = new JMenu("Moj ra\u010Dun");
		menuBar.add(mojRacunMenu);
		
		promijeniSifruItem = new JMenuItem("Promijeni \u0161ifru");
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
		menuBar.add(alatiMenu);
		
		sistemObavjestavanjaItem = new JMenuItem("Sistem obavje\u0161tavanja");
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
		
		pomocMenu = new JMenu("Pomo\u0107");
		menuBar.add(pomocMenu);
		
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
		
		korisnickoUputstvoItem = new JMenuItem("Korisni\u010Dko uputstvo");
		korisnickoUputstvoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Opcija će ponuditi preuzimanje .pdf dokumenta sa korisničkm uputstvom", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		pomocMenu.add(korisnickoUputstvoItem);

	
	
	
	
}
	
}
