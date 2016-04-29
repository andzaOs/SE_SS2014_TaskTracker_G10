package RacunovodstvoGUI;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Entity.Korisnik;
import Entity.TipKorisnika;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class PrikaziDetaljnoKorisnikaGUI {

	private JFrame frmPrijavaKorisnika;
	private Korisnik selektovaniKorisnik;

	public PrikaziDetaljnoKorisnikaGUI(Korisnik korisnik) {
		selektovaniKorisnik = korisnik;
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
		
		JLabel lblId = new JLabel("Ime i prezime: " + selektovaniKorisnik.getIme()+" "+selektovaniKorisnik.getPrezime());
		frmPrijavaKorisnika.getContentPane().add(lblId, "2, 2");
		
		JLabel lblImeIPrezime = new JLabel("Broj lične karte: "+selektovaniKorisnik.getBr_lk());
		frmPrijavaKorisnika.getContentPane().add(lblImeIPrezime, "2, 4");
		
		JLabel lblDatumObavljenogPosla = new JLabel("JMBG: "+selektovaniKorisnik.getJmbg());
		frmPrijavaKorisnika.getContentPane().add(lblDatumObavljenogPosla, "2, 6");
		
		JLabel lblVrstaRadnogZadatka = new JLabel("Datum zaposlenja: "+selektovaniKorisnik.getDatum_zaposlenja());
		frmPrijavaKorisnika.getContentPane().add(lblVrstaRadnogZadatka, "2, 8");
		String tipKorisnika;
		TipKorisnika t = new TipKorisnika();
		t = selektovaniKorisnik.getTip_korisnika();
		tipKorisnika = t.getNaziv();
		JLabel lblNazivKlijenta = new JLabel("Tip korisnika: "+tipKorisnika);
		frmPrijavaKorisnika.getContentPane().add(lblNazivKlijenta, "2, 10");
		
		JLabel lblEmailMikimausgmailcom = new JLabel("E-mail: "+selektovaniKorisnik.getEmail());
		frmPrijavaKorisnika.getContentPane().add(lblEmailMikimausgmailcom, "2, 12");
		
		JLabel lblBrojTelefona = new JLabel("Broj telefona: "+selektovaniKorisnik.getTelefon());
		frmPrijavaKorisnika.getContentPane().add(lblBrojTelefona, "2, 14");
		
		JLabel lblAdresaZmajaOd = new JLabel("Adresa: "+selektovaniKorisnik.getAdresa());
		frmPrijavaKorisnika.getContentPane().add(lblAdresaZmajaOd, "2, 16");
		
		frmPrijavaKorisnika.setLocationRelativeTo(null);
		frmPrijavaKorisnika.setSize(350,250);
		frmPrijavaKorisnika.setVisible(true);
	}
}
