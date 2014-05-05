package RacunovodstvoGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class odjaviSeGUI extends JFrame {
	
	
	
	public odjaviSeGUI() {
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
		juzniPanel.add(odustaniBtn);
		JButton obrisiBtn = new JButton("Odjavi se");
		obrisiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Nije implementirano", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		juzniPanel.add(obrisiBtn);
		
		JLabel label_3 = new JLabel("");
		juzniPanel.add(label_3);
		
		JLabel lblNewLabel = new JLabel("");
		juzniPanel.add(lblNewLabel);
		
		getContentPane().add(juzniPanel, BorderLayout.SOUTH);
	
	}

	
	
}
