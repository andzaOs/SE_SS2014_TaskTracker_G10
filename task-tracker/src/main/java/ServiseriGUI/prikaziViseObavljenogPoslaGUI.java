package ServiseriGUI;


import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Entity.ObavljeniPosao;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JTextField;

public class prikaziViseObavljenogPoslaGUI {

	private JFrame frmPrijavaKorisnika;
	private static ObavljeniPosao posao;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	private static prikaziViseObavljenogPoslaGUI instanca;
	 
	 
	public static prikaziViseObavljenogPoslaGUI dajInstancu(ObavljeniPosao po) {
		if(instanca==null) {
		instanca=new prikaziViseObavljenogPoslaGUI(po);
		
		}
		return instanca;
	}
	public static void unistiInstancu() { instanca= null; }
	
	public prikaziViseObavljenogPoslaGUI(ObavljeniPosao po) {
		posao=po;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrijavaKorisnika = new JFrame();
		frmPrijavaKorisnika.setTitle("Prikaz obavljenog posla");
		frmPrijavaKorisnika.setBounds(100, 100, 407, 213);
		//frmPrijavaKorisnika.setSize(350, 350);
		frmPrijavaKorisnika.setLocationRelativeTo(null);
		frmPrijavaKorisnika.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
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
		
		JLabel lblServiser = new JLabel("Serviser:");
		frmPrijavaKorisnika.getContentPane().add(lblServiser, "1, 3");
		
		JLabel serviser = new JLabel("");
		frmPrijavaKorisnika.getContentPane().add(serviser, "3, 3");
		
		JLabel lblKlijent = new JLabel("Klijent:");
		frmPrijavaKorisnika.getContentPane().add(lblKlijent, "1, 5");
		
		JLabel klijent = new JLabel("");
		frmPrijavaKorisnika.getContentPane().add(klijent, "3, 5");
		
		JLabel lblVrstaUsluge = new JLabel("Vrsta usluge:");
		frmPrijavaKorisnika.getContentPane().add(lblVrstaUsluge, "1, 7");
		
		JLabel usluga = new JLabel("");
		frmPrijavaKorisnika.getContentPane().add(usluga, "3, 7");
		
		JLabel lblDatumObavljanja = new JLabel("Datum obavljanja:");
		frmPrijavaKorisnika.getContentPane().add(lblDatumObavljanja, "1, 9");
		
		JLabel datum = new JLabel("");
		frmPrijavaKorisnika.getContentPane().add(datum, "3, 9");
		
		JLabel lblBrojSati = new JLabel("Broj sati:");
		frmPrijavaKorisnika.getContentPane().add(lblBrojSati, "1, 11");
		
		JLabel sati = new JLabel("");
		frmPrijavaKorisnika.getContentPane().add(sati, "3, 11");
		frmPrijavaKorisnika.setVisible(true);
		
		serviser.setText(posao.getPripadajuciZadatak().getIzvrsilac().getIme()+posao.getPripadajuciZadatak().getIzvrsilac().getPrezime());
		klijent.setText(posao.getPripadajuciZadatak().getZadatak().getKlijent().getNaziv());
		usluga.setText(posao.getVrstaUsluge().getNaziv());
		datum.setText(posao.getDatumObavljanja().toString());
		Integer pom=posao.getBrojSati();
		sati.setText(pom.toString());
		
		
		JLabel lblOpis = new JLabel("Opis:");
		frmPrijavaKorisnika.getContentPane().add(lblOpis, "1, 13");
		
		JLabel opis = new JLabel("");
		frmPrijavaKorisnika.getContentPane().add(opis, "3, 13");
		opis.setText(posao.getOpisa());
		

		
		
	}
}
