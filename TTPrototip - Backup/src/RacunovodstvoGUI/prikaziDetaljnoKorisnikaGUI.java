package RacunovodstvoGUI;



import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class prikaziDetaljnoKorisnikaGUI {

	private JFrame frmPrijavaKorisnika;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prikaziDetaljnoKorisnikaGUI window = new prikaziDetaljnoKorisnikaGUI();
					window.frmPrijavaKorisnika.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public prikaziDetaljnoKorisnikaGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrijavaKorisnika = new JFrame();
		frmPrijavaKorisnika.getContentPane().setBackground(Color.WHITE);
		frmPrijavaKorisnika.setTitle("Prikaz korisnika");
		frmPrijavaKorisnika.setBounds(100, 100, 180, 201);
		frmPrijavaKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblId = new JLabel("Ime i prezime: Miki Maus");
		frmPrijavaKorisnika.getContentPane().add(lblId, "2, 2");
		
		JLabel lblImeIPrezime = new JLabel("Broj li\u010Dne karte: 023451");
		frmPrijavaKorisnika.getContentPane().add(lblImeIPrezime, "2, 4");
		
		JLabel lblDatumObavljenogPosla = new JLabel("JMBG: 2910985234876");
		frmPrijavaKorisnika.getContentPane().add(lblDatumObavljenogPosla, "2, 6");
		
		JLabel lblVrstaRadnogZadatka = new JLabel("Datum zapo\u0161ljenja: 23.4.2011.");
		frmPrijavaKorisnika.getContentPane().add(lblVrstaRadnogZadatka, "2, 8");
		
		JLabel lblNazivKlijenta = new JLabel("Tip korisnika: serviser");
		frmPrijavaKorisnika.getContentPane().add(lblNazivKlijenta, "2, 10");
		
		JLabel lblEmailMikimausgmailcom = new JLabel("E-mail: miki.maus@gmail.com");
		frmPrijavaKorisnika.getContentPane().add(lblEmailMikimausgmailcom, "2, 12");
		
		JLabel lblBrojTelefona = new JLabel("Broj telefona: 0603345654");
		frmPrijavaKorisnika.getContentPane().add(lblBrojTelefona, "2, 14");
		
		JLabel lblAdresaZmajaOd = new JLabel("Adresa: Zmaja od Bosne br.4");
		frmPrijavaKorisnika.getContentPane().add(lblAdresaZmajaOd, "2, 16");
	}
}
