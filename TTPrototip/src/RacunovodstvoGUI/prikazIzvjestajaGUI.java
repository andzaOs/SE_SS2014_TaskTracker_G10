package RacunovodstvoGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class prikazIzvjestajaGUI extends JFrame{
	
	
	public prikazIzvjestajaGUI() {
				
			    JPanel sjeverniPanel = new JPanel();
			    sjeverniPanel.setLayout(new GridLayout(2,4,2,2));
			    sjeverniPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				JLabel naslovLbl = new JLabel ("Izvještaj za radnika:");
				naslovLbl.setHorizontalAlignment(SwingConstants.RIGHT);
				JLabel unosLbl = new JLabel ("Miki Maus");
				JLabel prazna1Lbl = new JLabel ("");
				JLabel prazna2Lbl= new JLabel ("");
				JLabel pocetniDatumLbl = new JLabel ("Za period od:");
				pocetniDatumLbl.setHorizontalAlignment(SwingConstants.RIGHT);
				JLabel pocetniDatumUnosLbl = new JLabel ("");
				JLabel krajnjiDatumLbl = new JLabel ("do:");
				krajnjiDatumLbl.setHorizontalAlignment(SwingConstants.RIGHT);
				JLabel krajnjiDatumUnosLbl = new JLabel ("");
				sjeverniPanel.add(naslovLbl);
				sjeverniPanel.add(unosLbl);
				sjeverniPanel.add(prazna1Lbl);
				sjeverniPanel.add(prazna2Lbl);
				sjeverniPanel.add(pocetniDatumLbl);
				sjeverniPanel.add(pocetniDatumUnosLbl);
				sjeverniPanel.add(krajnjiDatumLbl);
				sjeverniPanel.add(krajnjiDatumUnosLbl);
				
				String imenaKolona[] = {"Vrsta posla", "Klijent", "Datum", "Broj sati"};

				String podaci[][] =
				{
					{ "", "", "", "" },
					{ "", "", "", "" },
					{ "", "", "", "" },
					{ "", "", "", "" },
					{ "", "", "", "" },
					{ "", "", "", "" }
				};
				
				JTable podaciTbl = new JTable (podaci, imenaKolona);
				JScrollPane tabelaPane = new JScrollPane(podaciTbl);
	
				
				JPanel juzniPanel = new JPanel();
				JButton nazadBtn = new JButton("<< Nazad");
				JButton exportBtn = new JButton("Exportuj u .pdf");
				
				
				juzniPanel.setBorder(BorderFactory.createEmptyBorder(10, 1, 10, 1));
				juzniPanel.setLayout(new GridLayout(1,3,3,3));
				
				juzniPanel.add(nazadBtn);
				juzniPanel.add(exportBtn);
				
				getContentPane().add(sjeverniPanel, BorderLayout.NORTH);
				getContentPane().add(tabelaPane, BorderLayout.CENTER);
				getContentPane().add(juzniPanel, BorderLayout.SOUTH);
}
	
	
	
}
