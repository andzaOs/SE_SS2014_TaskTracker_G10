package ServiserGUI;



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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;


public class pretragaRadnihZadatakaServiserGUI extends JFrame{
	private JTextField textField;
	private JTextField krajnjiDatumTxt;
	private JLabel datumKreiranjaLbl;
	private JTextField datumKreiranjaTxt;
	private JLabel lblVrstaRadnogZadatka;
	private JButton pretraziRadniZadatakBtn;
	private JMenuBar menuMenuBar;
	private JMenu mojRacunMenu;
	private JMenuItem promijeniSifruItem;
	private JMenuItem odjaviSeItem;
	private JMenu pomocMenu;
	private JMenuItem korisnickoUputstvoItem;
	private JMenuItem oNamaItem;
	private JComboBox vrstaRadnogZadatkaCmbx;
	private JButton prikaziViseBtn;
	private JButton preuzmiRadniZadatakBtn;
	private JScrollPane scrollPane;
	private JTable tabelaTbl;
	public pretragaRadnihZadatakaServiserGUI() {
		
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
		
		JLabel nazivKlijentaLbl = new JLabel("Naziv klijenta:");
		getContentPane().add(nazivKlijentaLbl, "1, 2, right, default");
		
		textField = new JTextField();
		getContentPane().add(textField, "3, 2, fill, default");
		textField.setColumns(10);
		
		JLabel krajnjiDatumLbl = new JLabel("Krajnji datum izvr\u0161enja:");
		getContentPane().add(krajnjiDatumLbl, "5, 2, right, default");
		
		krajnjiDatumTxt = new JTextField();
		getContentPane().add(krajnjiDatumTxt, "7, 2, fill, fill");
		krajnjiDatumTxt.setColumns(10);
		
		datumKreiranjaLbl = new JLabel("Datum kreiranja:");
		getContentPane().add(datumKreiranjaLbl, "1, 4, right, default");
		
		datumKreiranjaTxt = new JTextField();
		getContentPane().add(datumKreiranjaTxt, "3, 4, fill, default");
		datumKreiranjaTxt.setColumns(10);
		
		lblVrstaRadnogZadatka = new JLabel("Vrsta radnog zadatka:");
		getContentPane().add(lblVrstaRadnogZadatka, "5, 4, right, default");
		
		vrstaRadnogZadatkaCmbx= new JComboBox();
		vrstaRadnogZadatkaCmbx.setModel(new DefaultComboBoxModel(new String[] {"Hardver", "Softver"}));
		getContentPane().add(vrstaRadnogZadatkaCmbx, "7, 4, fill, default");
		
		pretraziRadniZadatakBtn = new JButton("Pretraga");
		ImageIcon traziIkona = new ImageIcon(getClass().getResource("SearchIcon.png"));
		pretraziRadniZadatakBtn.setIcon(traziIkona);
		pretraziRadniZadatakBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().add(pretraziRadniZadatakBtn, "7, 6");
		
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "1, 8, 7, 17, fill, fill");
		
		tabelaTbl = new JTable();
		tabelaTbl.setModel(new DefaultTableModel(
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
				"Vrsta", "Klijent", "Opis"
			}
		));
		scrollPane.setViewportView(tabelaTbl);
		
		prikaziViseBtn = new JButton("Prika\u017Ei vi\u0161e");
		getContentPane().add(prikaziViseBtn, "1, 26, 6, 1");
		
		preuzmiRadniZadatakBtn = new JButton("Preuzmi radni zadatak");
		getContentPane().add(preuzmiRadniZadatakBtn, "7, 26");
		
		menuMenuBar = new JMenuBar();
		setJMenuBar(menuMenuBar);
		
		mojRacunMenu = new JMenu("Moj ra\u010Dun");
		menuMenuBar.add(mojRacunMenu);
		
		promijeniSifruItem = new JMenuItem("Promijeni \u0161ifru");
		mojRacunMenu.add(promijeniSifruItem);
		
		odjaviSeItem = new JMenuItem("Odjavi se");
		mojRacunMenu.add(odjaviSeItem);
		
		pomocMenu = new JMenu("Pomo\u0107");
		menuMenuBar.add(pomocMenu);
		
		korisnickoUputstvoItem = new JMenuItem("Korisni\u010Dko upustvo");
		pomocMenu.add(korisnickoUputstvoItem);
		
		oNamaItem = new JMenuItem("O nama");
		pomocMenu.add(oNamaItem);

	
	
	
	
}
	
	
}
