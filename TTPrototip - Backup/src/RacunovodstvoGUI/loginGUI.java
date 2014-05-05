package RacunovodstvoGUI;



import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class loginGUI {

	private JFrame frmPrijavaKorisnika;
	private JTextField txtKorisnikoIme;
	private JTextField txtifra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginGUI window = new loginGUI();
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
	public loginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrijavaKorisnika = new JFrame();
		frmPrijavaKorisnika.setTitle("Prijava korisnika");
		frmPrijavaKorisnika.setBounds(100, 100, 220, 119);
		frmPrijavaKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrijavaKorisnika.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(129dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		txtKorisnikoIme = new JTextField();
		txtKorisnikoIme.setForeground(Color.LIGHT_GRAY);
		txtKorisnikoIme.setText("Korisni\u010Dko ime");
		frmPrijavaKorisnika.getContentPane().add(txtKorisnikoIme, "2, 2, fill, default");
		txtKorisnikoIme.setColumns(10);
		
		txtifra = new JTextField();
		txtifra.setForeground(Color.LIGHT_GRAY);
		txtifra.setText("\u0160ifra");
		txtifra.setColumns(10);
		frmPrijavaKorisnika.getContentPane().add(txtifra, "2, 4");
		
		JButton btnNewButton = new JButton("Prijavi se");
		frmPrijavaKorisnika.getContentPane().add(btnNewButton, "2, 6, left, default");
	}
}
