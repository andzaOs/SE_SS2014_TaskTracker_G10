package ServiseriGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Entity.RadniZadatak;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class prikaziDetaljnoZadatak {

	private JFrame frmPrikazZadatka;
	private static RadniZadatak zadatak;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prikaziDetaljnoZadatak window = new prikaziDetaljnoZadatak(zadatak);
					window.frmPrikazZadatka.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	private static prikaziDetaljnoZadatak instanca;
	 
	 
		public static prikaziDetaljnoZadatak dajInstancu(RadniZadatak zadatak1) {
			if(instanca==null) {
			instanca=new prikaziDetaljnoZadatak(zadatak1);
			
			}
			return instanca;
		}
		public static void unistiInstancu() { instanca= null; }
		
	public prikaziDetaljnoZadatak(RadniZadatak zadatak1) {
		zadatak=zadatak1;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrikazZadatka = new JFrame();
		frmPrikazZadatka.setTitle("Prikaz zadatka");
		frmPrikazZadatka.setBounds(100, 100, 257, 264);
		frmPrikazZadatka.setSize(350, 350);
		frmPrikazZadatka.setLocationRelativeTo(null);
		frmPrikazZadatka.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("left:default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("right:default:grow"),},
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblVrstaZadatka = new JLabel("Vrsta Zadatka:");
		frmPrikazZadatka.getContentPane().add(lblVrstaZadatka, "1, 4, right, default");
		
		JLabel zad_vrsta = new JLabel("");
		zad_vrsta.setHorizontalAlignment(SwingConstants.LEFT);
		frmPrikazZadatka.getContentPane().add(zad_vrsta, "3, 4");
		
		JLabel lblKlijent = new JLabel("Klijent:");
		frmPrikazZadatka.getContentPane().add(lblKlijent, "1, 6, right, default");
		
		JLabel zad_klijent = new JLabel("");
		zad_klijent.setHorizontalAlignment(SwingConstants.LEFT);
		frmPrikazZadatka.getContentPane().add(zad_klijent, "3, 6");
		
		JLabel lblBrojServisera = new JLabel("Broj servisera:");
		frmPrikazZadatka.getContentPane().add(lblBrojServisera, "1, 8, right, default");
		
		JLabel zad_brojServisera = new JLabel("");
		frmPrikazZadatka.getContentPane().add(zad_brojServisera, "3, 8");
		
		JLabel lblNewLabel = new JLabel("Satus dodjeljenosti:");
		frmPrikazZadatka.getContentPane().add(lblNewLabel, "1, 10, right, default");
		
		JLabel zad_statusDodjeljenosti = new JLabel("");
		frmPrikazZadatka.getContentPane().add(zad_statusDodjeljenosti, "3, 10");
		
		JLabel lblDatumKreiranja = new JLabel("Datum kreiranja:");
		frmPrikazZadatka.getContentPane().add(lblDatumKreiranja, "1, 12, right, default");
		
		JLabel zad_datumUnosa = new JLabel("");
		zad_datumUnosa.setHorizontalAlignment(SwingConstants.LEFT);
		frmPrikazZadatka.getContentPane().add(zad_datumUnosa, "3, 12");
		
		JLabel lblDatumZaIzvrenje = new JLabel("Datum za izvršenje:");
		frmPrikazZadatka.getContentPane().add(lblDatumZaIzvrenje, "1, 14, right, default");
		
		JLabel zad_datumIzvrsenja = new JLabel("");
		zad_datumIzvrsenja.setHorizontalAlignment(SwingConstants.LEFT);
		frmPrikazZadatka.getContentPane().add(zad_datumIzvrsenja, "3, 14");
		
		JLabel lblNewLabel_1 = new JLabel("Izvršen:");
		frmPrikazZadatka.getContentPane().add(lblNewLabel_1, "1, 16, right, default");
		
		JLabel zad_statusIzvrsenosti = new JLabel("");
		frmPrikazZadatka.getContentPane().add(zad_statusIzvrsenosti, "3, 16");
		
		JLabel lblNewLabel_2 = new JLabel("Potpuno dodjeljen:");
		frmPrikazZadatka.getContentPane().add(lblNewLabel_2, "1, 18, right, default");
		
		JLabel lblNewLabel_4 = new JLabel("");
		frmPrikazZadatka.getContentPane().add(lblNewLabel_4, "3, 18");
		
		JLabel lblNewLabel_3 = new JLabel("Opis:");
		frmPrikazZadatka.getContentPane().add(lblNewLabel_3, "1, 20, right, default");
		
		JLabel zad_opis = new JLabel("");
		zad_opis.setHorizontalAlignment(SwingConstants.LEFT);
		frmPrikazZadatka.getContentPane().add(zad_opis, "3, 20");
		frmPrikazZadatka.setVisible(true);
		
		zad_opis.setText(zadatak.getOpis());
		zad_vrsta.setText(zadatak.getVrstaZadatka());
		zad_klijent.setText(zadatak.getKlijent().getNaziv());
		Integer serviseri=zadatak.getBrojServisera();
		zad_brojServisera.setText(serviseri.toString());
		Integer status=zadatak.getStatusDodjeljenosti();
		zad_statusDodjeljenosti.setText(status.toString()+"/"+serviseri.toString());
		zad_datumUnosa.setText(zadatak.getDatumUnosa().toString());
		zad_datumIzvrsenja.setText(zadatak.getKrajnjiDatumIzvrsenja().toString());
		String izvrsen=new String();
		if(zadatak.getStatusIzvrsenosti()==false) izvrsen="Neizvršen";
		else izvrsen="Izvršen";
		zad_statusIzvrsenosti.setText(izvrsen);
		String dodjeljen= new String();
		if(zadatak.getPotpunoDodjeljen()==true) dodjeljen= "Potpuno dodjeljen";
		else dodjeljen= "Nedodjeljen";
		lblNewLabel_4.setText(dodjeljen);
		
		
		
		
		
		
	
	

	
}
	

	}
