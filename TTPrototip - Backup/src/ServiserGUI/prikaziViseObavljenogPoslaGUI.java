package ServiserGUI;


import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class prikaziViseObavljenogPoslaGUI {

	private JFrame frmPrijavaKorisnika;
	private JTable tabelaTbl;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public prikaziViseObavljenogPoslaGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrijavaKorisnika = new JFrame();
		frmPrijavaKorisnika.getContentPane().setBackground(Color.WHITE);
		frmPrijavaKorisnika.setTitle("Prikaz obavljenog posla");
		frmPrijavaKorisnika.setBounds(100, 100, 407, 247);
		frmPrijavaKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrijavaKorisnika.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
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
				RowSpec.decode("default:grow"),}));
		
		JLabel idLbl = new JLabel("ID: 12345");
		frmPrijavaKorisnika.getContentPane().add(idLbl, "1, 2");
		
		JLabel imeIPrezimeLbl = new JLabel("Ime i prezime servisera: Miki Maus");
		frmPrijavaKorisnika.getContentPane().add(imeIPrezimeLbl, "1, 4");
		
		JLabel DatumObavljenogPoslaLbl = new JLabel("Datum i vrijeme izvr\u0161enja : 24.5.2013. 15:00");
		frmPrijavaKorisnika.getContentPane().add(DatumObavljenogPoslaLbl, "1, 6");
		
		JLabel VrstaRadnogZadatkaLbl = new JLabel("Vrsta radnog zadatka: softver");
		frmPrijavaKorisnika.getContentPane().add(VrstaRadnogZadatkaLbl, "1, 8");
		
		JLabel NazivKlijentaLbl = new JLabel("Naziv klijenta: Bosmal");
		frmPrijavaKorisnika.getContentPane().add(NazivKlijentaLbl, "1, 10");
		
		JScrollPane scrollPane = new JScrollPane();
		frmPrijavaKorisnika.getContentPane().add(scrollPane, "1, 12, fill, fill");
		
		tabelaTbl = new JTable();
		tabelaTbl.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Vrsta usluge", "Utro\u0161eni sati:"
			}
		));
		scrollPane.setViewportView(tabelaTbl);
	}
}
