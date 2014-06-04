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
import javax.swing.SwingConstants;

import Kontroleri.KorisnikKontroler;
import Kontroleri.SessionControler;
import ba.unsa.etf.si.tim10.task_tracker.LoginGUI;


public class OdjaviSeGUI extends JFrame {
	
	
	
	public OdjaviSeGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Odjava");
		
		JLabel daLiSteLbl = new JLabel("Da li ste sigurni da se \u017Eelite odjaviti?");
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
		JButton odjavaBtn = new JButton("Odjavi se");
		odjavaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KorisnikKontroler kKontr = new KorisnikKontroler();
				kKontr.odjaviKorisnika();
			}
		});
		juzniPanel.add(odjavaBtn);
		
		JLabel label_3 = new JLabel("");
		juzniPanel.add(label_3);
		
		JLabel lblNewLabel = new JLabel("");
		juzniPanel.add(lblNewLabel);
		
		getContentPane().add(juzniPanel, BorderLayout.SOUTH);
	
	}

	
	
}
