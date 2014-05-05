package ServiserGUI;



import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;


public class pretragaObavljenogPoslaServiserGUI extends JFrame{
	private JTextField vrstaZadatkaTxt;
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
	private JComboBox nazivKlijentaCmbx;
	private JTextField textField;
	private JPanel panel;
	private JButton prikaziViseBtn;
	private JButton btnPreuzmiRadniZadatak;
	public pretragaObavljenogPoslaServiserGUI() {
		
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
		
		JLabel nazivKlijentaLbl = new JLabel("Pretraga prema:");
		getContentPane().add(nazivKlijentaLbl, "1, 2, right, default");
		
		nazivKlijentaCmbx = new JComboBox();
		nazivKlijentaCmbx.setModel(new DefaultComboBoxModel(new String[] {"Naziv klijenta", "Naziv servisera", "Vremenski interval"}));
		getContentPane().add(nazivKlijentaCmbx, "3, 2, fill, default");
		
		JLabel vrstaZadatkaLbl = new JLabel("Vrsta zadatka:");
		getContentPane().add(vrstaZadatkaLbl, "5, 2, right, default");
		
		vrstaZadatkaTxt = new JTextField();
		getContentPane().add(vrstaZadatkaTxt, "7, 2, fill, fill");
		vrstaZadatkaTxt.setColumns(10);
		
		pocetniDatumLbl = new JLabel("Po\u010Detni datum:");
		getContentPane().add(pocetniDatumLbl, "1, 4, right, default");
		
		pocetniDatumTxt = new JTextField();
		getContentPane().add(pocetniDatumTxt, "3, 4, fill, default");
		pocetniDatumTxt.setColumns(10);
		
		krajnjiDatumLbl = new JLabel("Krajnji datum:");
		getContentPane().add(krajnjiDatumLbl, "5, 4, right, default");
		
		pretraziRadniZadatakBtn = new JButton("Pretraga");
		ImageIcon traziIkona = new ImageIcon(getClass().getResource("SearchIcon.png"));
		pretraziRadniZadatakBtn.setIcon(traziIkona);
		pretraziRadniZadatakBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		textField = new JTextField();
		getContentPane().add(textField, "7, 4, fill, default");
		textField.setColumns(10);
		getContentPane().add(pretraziRadniZadatakBtn, "7, 6");
		
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "1, 8, 7, 17, fill, fill");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Datum i vrijeme izvr\u0161enja", "Utro\u0161eni sati", "Vrsta usluge"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(128);
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		getContentPane().add(panel, "1, 26, 7, 1, fill, fill");
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		prikaziViseBtn = new JButton("Prika\u017Ei vi\u0161e");
		panel.add(prikaziViseBtn);
		
		btnPreuzmiRadniZadatak =new JButton("Modifikuj obavljeni posao");
		btnPreuzmiRadniZadatak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnPreuzmiRadniZadatak);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mojRacunMenu = new JMenu("Moj ra\u010Dun");
		menuBar.add(mojRacunMenu);
		
		promijeniSifruItem = new JMenuItem("Promijeni \u0161ifru");
		mojRacunMenu.add(promijeniSifruItem);
		
		odjaviSeItem = new JMenuItem("Odjavi se");
		mojRacunMenu.add(odjaviSeItem);
		
		pomocMenu = new JMenu("Pomo\u0107");
		menuBar.add(pomocMenu);
		
		korisnikovoUputstvoItemo = new JMenuItem("Korisni\u010Dko upustvo");
		pomocMenu.add(korisnikovoUputstvoItemo);
		
		oNamaItem = new JMenuItem("O nama");
		pomocMenu.add(oNamaItem);

	
	
	
	
}
	
}
