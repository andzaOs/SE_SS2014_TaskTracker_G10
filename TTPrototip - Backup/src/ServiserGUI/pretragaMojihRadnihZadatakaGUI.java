package ServiserGUI;



import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;


public class pretragaMojihRadnihZadatakaGUI extends JFrame{
	private JTextField textField;
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
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private JTable table;
	private JCheckBox chckbxNepreuzeti;
	private JCheckBox chckbxPreuzeti;
	private JPanel panel;
	private JButton prikaziViseBtn;
	private JButton prihvatiZadatakBtn;
	private JButton oznaciKaoIzvrsenBtn;
	private JButton evidentirajPosaoBtn;
	public pretragaMojihRadnihZadatakaGUI() {
		
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
		
		JLabel nazivKlijentaLbl = new JLabel("Naziv klijenta:");
		getContentPane().add(nazivKlijentaLbl, "1, 2, right, default");
		
		textField = new JTextField();
		getContentPane().add(textField, "3, 2, fill, default");
		textField.setColumns(10);
		
		JLabel datumKreiranjaLbl = new JLabel("Krajnji datum izvr\u0161enja:");
		getContentPane().add(datumKreiranjaLbl, "5, 2, right, default");
		
		textField_1 = new JTextField();
		getContentPane().add(textField_1, "7, 2, fill, fill");
		textField_1.setColumns(10);
		
		datumKreiranjaLbl_1 = new JLabel("Datum kreiranja:");
		getContentPane().add(datumKreiranjaLbl_1, "1, 4, right, default");
		
		textField_2 = new JTextField();
		getContentPane().add(textField_2, "3, 4, fill, default");
		textField_2.setColumns(10);
		
		vrstaRadnogzadatkaLbl = new JLabel("Vrsta radnog zadatka:");
		getContentPane().add(vrstaRadnogzadatkaLbl, "5, 4, right, default");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Hardver", "Softver"}));
		getContentPane().add(comboBox, "7, 4, fill, default");
		
		pretraziRadniZadatakBtn = new JButton("Pretraga");
		ImageIcon traziIkona = new ImageIcon(getClass().getResource("SearchIcon.png"));
		pretraziRadniZadatakBtn.setIcon(traziIkona);
		pretraziRadniZadatakBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		chckbxNepreuzeti = new JCheckBox("Neprihva\u0107eni");
		getContentPane().add(chckbxNepreuzeti, "1, 6");
		
		chckbxPreuzeti = new JCheckBox("Prihva\u0107eni");
		getContentPane().add(chckbxPreuzeti, "3, 6");
		getContentPane().add(pretraziRadniZadatakBtn, "7, 6");
		
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "1, 8, 7, 17, fill, fill");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Softver", "Bosnalijek", "Instalacija OS", "Neprihva\u0107en"},
				{"Softver", "Bosmal", "Konfiguracija rutera", "Prihva\u0107en"},
				{"Hardver", "Bosmal", "Zamjena grafi\u010Dke", "Izvr\u0161en"},
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
				"Vrsta", "Naziv klijenta", "Opis", "Status"
			}
		));
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		getContentPane().add(panel, "1, 26, 7, 1, fill, fill");
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		prikaziViseBtn = new JButton("Prika\u017Ei vi\u0161e");
		prikaziViseBtn.addActionListener(new ActionListener() {
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
		panel.add(prikaziViseBtn);
		
		prihvatiZadatakBtn = new JButton("Prihvati zadatak");
		panel.add(prihvatiZadatakBtn);
		
		oznaciKaoIzvrsenBtn = new JButton("Ozna\u010Di kao izvr\u0161en");
		panel.add(oznaciKaoIzvrsenBtn);
		
		evidentirajPosaoBtn = new JButton("Evidentiraj posao");
		evidentirajPosaoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() 
				{
					public void run() 
					{
						evidentiranjeObavljenogPoslaGUI ex = new evidentiranjeObavljenogPoslaGUI();
						ex.setVisible(true);
					}
				});
			}
		});
		panel.add(evidentirajPosaoBtn);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mojRacunMeni = new JMenu("Moj ra\u010Dun");
		menuBar.add(mojRacunMeni);
		
		promjeniSifruItem = new JMenuItem("Promijeni \u0161ifru");
		mojRacunMeni.add(promjeniSifruItem);
		
		odjaviSeItem = new JMenuItem("Odjavi se");
		mojRacunMeni.add(odjaviSeItem);
		
		pomocMeni = new JMenu("Pomo\u0107");
		menuBar.add(pomocMeni);
		
		korisnickoUpustvoItem = new JMenuItem("Korisni\u010Dko upustvo");
		pomocMeni.add(korisnickoUpustvoItem);
		
		oNamaItem = new JMenuItem("O nama");
		pomocMeni.add(oNamaItem);

	
	
	
	
}
	
	
}
