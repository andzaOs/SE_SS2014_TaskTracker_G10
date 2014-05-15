package RacunovodstvoGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Entity.RadniZadatak;

public class OdabirServiseraGUI extends JFrame{
	
	
	class AkcijaPrikaziVise implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
		}
	}
	
	class AkcijaZavrsi implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
		}
	}
	
	class AkcijaNazad implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
		}
	}
	
	public OdabirServiseraGUI() {
        OdaberiServiseraUI();
	}
	
	public final void OdaberiServiseraUI() {
		
			    
				JLabel naslov = new JLabel ("Odaberite servisera/e za selektirani zadatak:");
				
				String imenaKolona[] = {"Ime", "Prezime", "Broj dodijeljenih zadataka"};

				String podaci[][] =
				{
					{ "Miki", "Maus", "2" },
					{ "Miki", "Maus", "2" },
					{ "Miki", "Maus", "2" },
					{ "Miki", "Maus", "2" }
				};
				
				JTable tabela = new JTable (podaci, imenaKolona);
				JScrollPane tabelaPane = new JScrollPane(tabela);
	
				
				
				
				JPanel juzniPanel = new JPanel();
				JButton Nazad = new JButton("<< Nazad");
				Nazad.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				JButton Vise = new JButton("Prikaži više");
				Vise.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									PrikaziDetaljnoKorisnikaGUI window = new PrikaziDetaljnoKorisnikaGUI();
									
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
				});
				JButton Zavrsi = new JButton("Završi dodjelu");
				Zavrsi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(rootPane, "Nije implementirano", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
					}
				});
				
				
				juzniPanel.setBorder(BorderFactory.createEmptyBorder(10, 1, 10, 1));
				juzniPanel.setLayout(new GridLayout(1,3,3,3));
				
				juzniPanel.add(Nazad);
				juzniPanel.add(Vise);
				juzniPanel.add(Zavrsi);
				
				getContentPane().add(naslov, BorderLayout.NORTH);
				getContentPane().add(tabelaPane, BorderLayout.CENTER);
				getContentPane().add(juzniPanel, BorderLayout.SOUTH);
}
	
	
	
}
