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

import DAO.KlijentDAO;
import Entity.Klijent;
import Kontroleri.KlijentKontroler;


public class IzbrisiKlijentaGUI extends JFrame {
	private static IzbrisiKlijentaGUI instanca;
		
		public static IzbrisiKlijentaGUI dajInstancu(long id) {
			if(instanca==null) {
 			instanca=new IzbrisiKlijentaGUI(id);
 			
			}
			return instanca;
		}
		public static void unistiInstancu() { instanca= null; }
	
	public IzbrisiKlijentaGUI(final long id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setTitle("Brisanje klijenta");
		
		
		
		JLabel naslovLbl = new JLabel("Da li ste sigurni da \u017Eelite izbrisati odabranog klijenta?");
		naslovLbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		getContentPane().add(naslovLbl, BorderLayout.CENTER);
		
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
				KlijentKontroler kKontroler = new KlijentKontroler();
				try {
					if(kKontroler.brisanjeKlijenta(id)) {
						dispose();
						JOptionPane.showMessageDialog(rootPane,
							    "Klijent je uspješno obrisan.",
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
		unistiInstancu();
		super.dispose();
	}

	
	
}
