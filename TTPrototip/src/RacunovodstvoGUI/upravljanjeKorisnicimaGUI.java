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


public class upravljanjeKorisnicimaGUI extends JFrame{
		
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
	public upravljanjeKorisnicimaGUI() {
		
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
		
		
	
		
		glavniToolBar = new JToolBar();
		getContentPane().add(glavniToolBar, "1, 2");
		ImageIcon dodajIkona = new ImageIcon(getClass().getResource("AddIcon.png"));
		JButton kreiraKorisnikajBtn = new JButton(dodajIkona);
		kreiraKorisnikajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
				     public void run() {
				          kreiranjeKorisnikaGUI ex = new kreiranjeKorisnikaGUI();
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
		
		pretraziBtn = new JButton("Pretra\u017Ei");
		ImageIcon traziIkona = new ImageIcon(getClass().getResource("SearchIcon.png"));
		pretraziBtn.setIcon(traziIkona);
		pretraziBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		tabelaPane.setViewportView(podaciTbl);
		
		juzniPanel = new JPanel();
		getContentPane().add(juzniPanel, "1, 24, 15, 1, fill, fill");
		juzniPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		modifikujBtn = new JButton("Modifikuj korisnika");
		modifikujBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
				     public void run() {
				          modifikacijaKorisnikaGUI ex = new modifikacijaKorisnikaGUI();
				          ex.setSize(400, 500);
				          ex.setLocationRelativeTo(null);
				          ex.setVisible(true);
				      }
				});		
			}
		});
		juzniPanel.add(modifikujBtn);
		
		obrisiBtn = new JButton("Obri\u0161i korisnika");
		obrisiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                izbrisiKorisnikaGUI ex = new izbrisiKorisnikaGUI();
		                ex.setSize(600, 150);
		                ex.setLocationRelativeTo(null);
		                ex.setVisible(true);
		            }
		        });
			}
		});
		juzniPanel.add(obrisiBtn);
		
		glavniMenuBar = new JMenuBar();
		setJMenuBar(glavniMenuBar);
		
		mojRacunMenu = new JMenu("Moj ra\u010Dun");
		glavniMenuBar.add(mojRacunMenu);
		
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
		mojRacunMenu.add(odjaviSeItem);
		
		alatiMenu = new JMenu("Alati");
		glavniMenuBar.add(alatiMenu);
		
		sistemObavjetavanjaItem = new JMenuItem("Sistem obavje\u0161tavanja");
		sistemObavjetavanjaItem.addActionListener(new ActionListener() {
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
		alatiMenu.add(sistemObavjetavanjaItem);
		
		pomocMenu = new JMenu("Pomo\u0107");
		glavniMenuBar.add(pomocMenu);
		
		korisnickoUputstvoItem = new JMenuItem("Korisni\u010Dko upustvo");
		pomocMenu.add(korisnickoUputstvoItem);
		
		oNamaItem = new JMenuItem("O nama");
		pomocMenu.add(oNamaItem);

}
   
}

