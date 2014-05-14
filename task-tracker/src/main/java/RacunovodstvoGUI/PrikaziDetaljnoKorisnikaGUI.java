package RacunovodstvoGUI;



import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class PrikaziDetaljnoKorisnikaGUI {

	private JFrame frmPrijavaKorisnika;

	public PrikaziDetaljnoKorisnikaGUI() {
		initialize();
	}

	private void initialize() {
		frmPrijavaKorisnika = new JFrame();
		frmPrijavaKorisnika.getContentPane().setBackground(Color.WHITE);
		frmPrijavaKorisnika.setTitle("Prikaz korisnika");
		frmPrijavaKorisnika.setBounds(100, 100, 180, 201);
		
		frmPrijavaKorisnika.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
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
		
		JLabel lblId = new JLabel("Ime i prezime: ");
		frmPrijavaKorisnika.getContentPane().add(lblId, "2, 2");
		
		JLabel lblImeIPrezime = new JLabel("Broj li\u010Dne karte: ");
		frmPrijavaKorisnika.getContentPane().add(lblImeIPrezime, "2, 4");
		
		JLabel lblDatumObavljenogPosla = new JLabel("JMBG: ");
		frmPrijavaKorisnika.getContentPane().add(lblDatumObavljenogPosla, "2, 6");
		
		JLabel lblVrstaRadnogZadatka = new JLabel("Datum zapo\u0161ljenja: ");
		frmPrijavaKorisnika.getContentPane().add(lblVrstaRadnogZadatka, "2, 8");
		
		JLabel lblNazivKlijenta = new JLabel("Tip korisnika: ");
		frmPrijavaKorisnika.getContentPane().add(lblNazivKlijenta, "2, 10");
		
		JLabel lblEmailMikimausgmailcom = new JLabel("E-mail: ");
		frmPrijavaKorisnika.getContentPane().add(lblEmailMikimausgmailcom, "2, 12");
		
		JLabel lblBrojTelefona = new JLabel("Broj telefona: ");
		frmPrijavaKorisnika.getContentPane().add(lblBrojTelefona, "2, 14");
		
		JLabel lblAdresaZmajaOd = new JLabel("Adresa: ");
		frmPrijavaKorisnika.getContentPane().add(lblAdresaZmajaOd, "2, 16");
		
		frmPrijavaKorisnika.setLocationRelativeTo(null);
		frmPrijavaKorisnika.setSize(300,200);
		frmPrijavaKorisnika.setVisible(true);
	}
}
