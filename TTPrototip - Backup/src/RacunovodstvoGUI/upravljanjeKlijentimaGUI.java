package RacunovodstvoGUI;



import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;


public class upravljanjeKlijentimaGUI extends JFrame{
	private JButton pretraziRadniZadatakBtn;
	private JMenuBar menuBar;
	private JMenu mojRacunMenu;
	private JMenuItem promijeniSifruItem;
	private JMenuItem odjaviSeItem;
	private JMenu pomocMenu;
	private JMenuItem korisnickoUputstvoItem;
	private JMenuItem oNamaItem;
	private JScrollPane tabelPane;
	private JTable podaciTbl;
	private JPanel panel;
	private JButton modifikujKlijentaBtn;
	private JButton obrisiKlijentaBtn;
	private JToolBar toolBar;
	private JTextField jmbgTxt;
	private JMenu alatiMenu;
	private JMenuItem sistemObavjestavanjaItem;
	public upravljanjeKlijentimaGUI() {
		
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
				          kreiranjeKlijentaGUI ex = new kreiranjeKlijentaGUI();
				          ex.setSize(400, 200);
				          ex.setLocationRelativeTo(null);
				          ex.setVisible(true);
				      }
				});	
			}
		});
		kreirajKlijentaBtn.setText("Novi klijent");
		toolBar.add(kreirajKlijentaBtn);
		
		pretraziRadniZadatakBtn = new JButton("Pretra\u017Ei");
		ImageIcon traziIkona = new ImageIcon(getClass().getResource("SearchIcon.png"));
		pretraziRadniZadatakBtn.setIcon(traziIkona);
		pretraziRadniZadatakBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel imeLbl = new JLabel("Naziv klijenta:");
		getContentPane().add(imeLbl, "1, 4, right, default");
		
		jmbgTxt = new JTextField();
		getContentPane().add(jmbgTxt, "3, 4, 9, 1, fill, default");
		jmbgTxt.setColumns(10);
		getContentPane().add(pretraziRadniZadatakBtn, "13, 4, right, default");
		
		tabelPane = new JScrollPane();
		getContentPane().add(tabelPane, "1, 6, 15, 17, fill, fill");
		
		podaciTbl = new JTable();
		podaciTbl.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Naziv", "Broj telefona", "Adresa", "E-mail"
			}
		));
		podaciTbl.getColumnModel().getColumn(1).setPreferredWidth(84);
		tabelPane.setViewportView(podaciTbl);
		
		panel = new JPanel();
		getContentPane().add(panel, "1, 24, 15, 1, fill, fill");
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		modifikujKlijentaBtn = new JButton("Modifikuj klijenta");
		panel.add(modifikujKlijentaBtn);
		
		obrisiKlijentaBtn = new JButton("Obri\u0161i klijenta");
		obrisiKlijentaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                izbrisiKlijentaGUI ex = new izbrisiKlijentaGUI();
		                ex.setSize(600, 150);
		                ex.setLocationRelativeTo(null);
		                ex.setVisible(true);
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
							promjenaSifreGUI window = new promjenaSifreGUI(frmPromjenaifre);
							
							
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
						odjaviSeGUI ex = new odjaviSeGUI();
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
						sistemObavještavanjaGUI ex = new sistemObavještavanjaGUI();
						ex.setVisible(true);
					}
				});
			}
		});
		alatiMenu.add(sistemObavjestavanjaItem);
		
		pomocMenu = new JMenu("Pomo\u0107");
		menuBar.add(pomocMenu);
		
		korisnickoUputstvoItem = new JMenuItem("Korisni\u010Dko uputstvo");
		pomocMenu.add(korisnickoUputstvoItem);
		
		oNamaItem = new JMenuItem("O nama");
		oNamaItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                oNamaGUI ex = new oNamaGUI();
		                ex.setSize(300, 150);
		                ex.setLocationRelativeTo(null);
		                ex.setVisible(true);
		            }
		        });
			}
		});
		//testa
		pomocMenu.add(oNamaItem);

	
	
	
	
}
	
}
