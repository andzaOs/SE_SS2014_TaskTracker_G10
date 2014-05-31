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

import Kontroleri.*;
import Entity.RadniZadatak;


@SuppressWarnings("serial")
public class IzbrisiZadatakGUI extends JFrame {
	
	private RadniZadatak radniZadatak = new RadniZadatak();
	private IzbrisiZadatakGUI mySelf;
	private static IzbrisiZadatakGUI instanca;
	
	public static IzbrisiZadatakGUI dajInstancu(RadniZadatak radniZadatak) {
		if(instanca==null) {
			instanca=new IzbrisiZadatakGUI(radniZadatak);
		}
		return instanca;
	}
	public static void unistiInstancu() { instanca= null; }
	
	public IzbrisiZadatakGUI (RadniZadatak zadatak) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.mySelf=this;
		this.radniZadatak=zadatak;
		IzbrisiZadatakUI();
	}
	
	public void IzbrisiZadatakUI() {
	
		final IzbrisiZadatakControler controler = new IzbrisiZadatakControler();
		setTitle("Brisanje zadatka");
		
		JLabel daLiSteLbl = new JLabel("Da li ste sigurni da \u017Eelite izbrisati odabrani zadatak?");
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
				try {
					controler.Izbrisi(radniZadatak);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(rootPane,
							"Pojavila se greška. Pokušajte ponovo.",
							"Poruka o grešci", JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane
				.showMessageDialog(
						rootPane,
						"Radni zadatak je uspješno obrisan.",
						"Poruka o uspješnosti operacije",
						JOptionPane.INFORMATION_MESSAGE);
				mySelf.setVisible(false);
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
