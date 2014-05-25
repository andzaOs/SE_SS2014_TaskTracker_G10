package RacunovodstvoGUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import Entity.Korisnik;
import Kontroleri.KorisnikKontroler;



public class PromjenaSifreGUI {

	private JFrame frmPromjenaSifre;
	private static JPasswordField staraSifraTxt;
	private static JPasswordField novaSifraTxt;
	private static JPasswordField potvrdaSifreTxt;
	private List<Korisnik> korisnici;


	/**
	 * Create the GUI.
	 */
	public PromjenaSifreGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPromjenaSifre = new JFrame();
		frmPromjenaSifre.setTitle("Promjena šifre");
		frmPromjenaSifre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
	            if(evt.getKeyCode() == KeyEvent.VK_ENTER)
	            {
	               Promjena();
	            }
			}
		});
		frmPromjenaSifre.setResizable(false);
		frmPromjenaSifre.setBounds(100, 100, 302, 180);
		frmPromjenaSifre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPromjenaSifre.getContentPane().setLayout(null);
		
		
		staraSifraTxt = new JPasswordField();
		staraSifraTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
	            if(evt.getKeyCode() == KeyEvent.VK_ENTER)
	            {
	                Promjena();
	            }
			}
		});
		staraSifraTxt.setForeground(Color.GRAY);
		staraSifraTxt.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent arg0) {
				char[] pass = staraSifraTxt.getPassword();  
				String passString = new String(pass); 
				if (passString.equals("Stara šifra")) {
					staraSifraTxt.setEchoChar('*');
					staraSifraTxt.setText(null);
					staraSifraTxt.setForeground(Color.BLACK);
				}
				
			}
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				char[] pass = staraSifraTxt.getPassword();  
				String passString = new String(pass); 
				if (passString.equals("")) {
					staraSifraTxt.setEchoChar((char)0);
					staraSifraTxt.setText("Stara šifra");
					staraSifraTxt.setForeground(Color.GRAY);
				}
				
			}
		});
		staraSifraTxt.setText("Stara šifra");
		staraSifraTxt.setBounds(22, 22, 255, 20);
		frmPromjenaSifre.getContentPane().add(staraSifraTxt);
		staraSifraTxt.setColumns(10);
		
		novaSifraTxt = new JPasswordField("Nova šifra");
		novaSifraTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
	            if(evt.getKeyCode() == KeyEvent.VK_ENTER)
	            {
	                Promjena();
	            }
			}
		});
		novaSifraTxt.setForeground(Color.GRAY);
		novaSifraTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				char[] pass = novaSifraTxt.getPassword();  
				String passString = new String(pass); 
				if (passString.equals("Nova šifra")) {
					novaSifraTxt.setEchoChar('*');
					novaSifraTxt.setText(null);
					novaSifraTxt.setForeground(Color.BLACK);
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				
				char[] pass = novaSifraTxt.getPassword();  
				String passString = new String(pass); 
				if (passString.equals("")) {
					novaSifraTxt.setEchoChar((char)0);
					novaSifraTxt.setText("Nova šifra");
					novaSifraTxt.setForeground(Color.GRAY);
				}
				
			}
		});

		novaSifraTxt.setBounds(22, 53, 255, 20);
		frmPromjenaSifre.getContentPane().add(novaSifraTxt);
		novaSifraTxt.setColumns(10);
		


		potvrdaSifreTxt = new JPasswordField("Potvrda nove šifre");
		potvrdaSifreTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
	            if(evt.getKeyCode() == KeyEvent.VK_ENTER)
	            {
	                Promjena();
	            }
			}
		});
		potvrdaSifreTxt.setForeground(Color.GRAY);
		potvrdaSifreTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				char[] pass = potvrdaSifreTxt.getPassword();  
				String passString = new String(pass); 
				if (passString.equals("Potvrda nove šifre")) {
					potvrdaSifreTxt.setEchoChar('*');
					potvrdaSifreTxt.setText(null);
					potvrdaSifreTxt.setForeground(Color.BLACK);
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				
				char[] pass = potvrdaSifreTxt.getPassword();  
				String passString = new String(pass); 
				if (passString.equals("")) {
					potvrdaSifreTxt.setEchoChar((char)0);
					potvrdaSifreTxt.setText("Potvrda nove šifre");
					potvrdaSifreTxt.setForeground(Color.GRAY);
				}
				
			}
		});

		potvrdaSifreTxt.setBounds(22, 84, 255, 20);
		frmPromjenaSifre.getContentPane().add(potvrdaSifreTxt);
		potvrdaSifreTxt.setColumns(10);
		
		JButton promjenaBtn = new JButton("Promijeni");
		promjenaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Promjena();
			}
		});
		promjenaBtn.setBounds(22, 117, 113, 23);
		frmPromjenaSifre.getContentPane().add(promjenaBtn);
		
		staraSifraTxt.setEchoChar((char)0);
		novaSifraTxt.setEchoChar((char)0);
		potvrdaSifreTxt.setEchoChar((char)0);
		
		frmPromjenaSifre.setVisible(true);
		frmPromjenaSifre.requestFocus();
	}
	
	@SuppressWarnings("deprecation")
	public void Promjena() {
		long id = 5;
		
		if(staraSifraTxt.getText().equals("") || novaSifraTxt.getText().equals("") || potvrdaSifreTxt.getText().equals("") || staraSifraTxt.getText().equals("Stara šifra") || novaSifraTxt.getText().equals("Nova šifra") || potvrdaSifreTxt.getText().equals("Potvrda nove šifre")) {
			JOptionPane.showMessageDialog(frmPromjenaSifre, "Sva polja moraju biti popunjena!", "Upozorenje", JOptionPane.ERROR_MESSAGE);
		}
		else {
			KorisnikKontroler kKontroler = new KorisnikKontroler();
			try {
				if(novaSifraTxt.getText().equals(potvrdaSifreTxt.getText())) {
					if(kKontroler.promjenaSifre(staraSifraTxt, novaSifraTxt, id)) {
						JOptionPane.showMessageDialog(frmPromjenaSifre, "Uspješno promjenjena šifra", "Obavijest", JOptionPane.INFORMATION_MESSAGE);					
					}
					else {
						JOptionPane.showMessageDialog(frmPromjenaSifre, "Netačna stara šifra!", "Greška", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(frmPromjenaSifre, "Netačno ste potvrdili šifru!", "Greška", JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(frmPromjenaSifre,
						    "Greška. Pojavio se izuzetak.",
						    "Izuzetak",
						    JOptionPane.ERROR_MESSAGE);
					System.exit(frmPromjenaSifre.DISPOSE_ON_CLOSE);
			}
		}
	}

	
	
	
}
