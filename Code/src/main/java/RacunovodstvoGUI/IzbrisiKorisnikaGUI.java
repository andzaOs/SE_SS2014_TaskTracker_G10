package RacunovodstvoGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import DAO.KorisnikDAO;
import Entity.Korisnik;
import Kontroleri.KlijentKontroler;
import Kontroleri.KorisnikKontroler;


public class IzbrisiKorisnikaGUI extends JFrame {
	
	
	
	private static IzbrisiKorisnikaGUI instanca;
	
	public static IzbrisiKorisnikaGUI dajInstancu(long id) {
		if(instanca==null) {
			instanca=new IzbrisiKorisnikaGUI(id);
			
		}
		return instanca;
	}
	public static void unistiInstancu() { instanca= null; }
	
	public IzbrisiKorisnikaGUI(final long id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setTitle("Brisanje korisnika");
		
		JLabel daLiSteLbl = new JLabel("Da li ste sigurni da želite izbrisati odabranog korisnika?");
		daLiSteLbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		getContentPane().add(daLiSteLbl, BorderLayout.CENTER);
		
		JPanel juzniPanel = new JPanel();
		juzniPanel.setBorder(BorderFactory.createEmptyBorder(0, 1, 15, 1));
		juzniPanel.setLayout(new GridLayout(1,6,2,2));
		
		JLabel label = new JLabel("");
		juzniPanel.add(label);
		
		JLabel label_2 = new JLabel("");
		juzniPanel.add(label_2);
		JButton odustaniBtn = new JButton("Odustani");
		odustaniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		juzniPanel.add(odustaniBtn);
		JButton obrisiBtn = new JButton("Obriši");
		obrisiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KorisnikKontroler kKontroler = new KorisnikKontroler();
				try {
					if(kKontroler.brisanjeKorisnika(id)) {
						dispose();
						JOptionPane.showMessageDialog(rootPane,
							    "Korisnik je uspješno obrisan.",
							    "Brisanje klijenta",
							    JOptionPane.INFORMATION_MESSAGE);
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(rootPane,
						    "Greška. Pojavio se izuzetak.",
						    "Izuzetak",
						    JOptionPane.ERROR_MESSAGE);
					System.exit(DISPOSE_ON_CLOSE);
				}
			}
		});
		
		juzniPanel.add(obrisiBtn);
		
		JLabel label_3 = new JLabel("");
		juzniPanel.add(label_3);
		
		JLabel lblNewLabel = new JLabel("");
		juzniPanel.add(lblNewLabel);
		
		getContentPane().add(juzniPanel, BorderLayout.SOUTH);
	
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		IzbrisiKorisnikaGUI.unistiInstancu();
		super.dispose();
	}
	
}
