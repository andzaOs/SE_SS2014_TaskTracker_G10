package RacunovodstvoGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class odabirServiseraGUI extends JFrame{
	
	
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
	
	public odabirServiseraGUI() {
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
				JButton Vise = new JButton("Prikaži više");
				JButton Zavrsi = new JButton("Završi dodjelu");
				
				
				juzniPanel.setBorder(BorderFactory.createEmptyBorder(10, 1, 10, 1));
				juzniPanel.setLayout(new GridLayout(1,3,3,3));
				
				juzniPanel.add(Nazad);
				juzniPanel.add(Vise);
				juzniPanel.add(Zavrsi);
				
				add(naslov, BorderLayout.NORTH);
				add(tabelaPane, BorderLayout.CENTER);
				add(juzniPanel, BorderLayout.SOUTH);
}
	
	
	
}
