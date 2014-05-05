package RacunovodstvoGUI;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

public class pocetnaRacunovodstvoGUI extends JFrame {

	public pocetnaRacunovodstvoGUI() {
		setTitle("Meni ra�unovodstvo");
		getContentPane().setBackground(Color.WHITE);
		
		JMenuBar glavniMenuBar = new JMenuBar();
		setJMenuBar(glavniMenuBar);
		
		JMenu mojRacunMenu = new JMenu("Moj ra�un");
		glavniMenuBar.add(mojRacunMenu);
		JMenuItem promijeniSifruItem = new JMenuItem("Promijeni �ifru");
		promijeniSifruItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JFrame frmPromjenaifre = new JFrame();
							promjenaSifreGUI window = new promjenaSifreGUI(frmPromjenaifre);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mojRacunMenu.add(promijeniSifruItem);
		JMenuItem odjavaItem = new JMenuItem("Odjavi se");
		odjavaItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() 
				{
					public void run() 
					{
						odjaviSeGUI ex = new odjaviSeGUI();
			             ex.setSize(600, 150);
			             ex.setLocationRelativeTo(null);
			             ex.setVisible(true);
					}
				});
			}
		});
		mojRacunMenu.add(odjavaItem);
		
		JMenu alatiMenu = new JMenu("Alati");
		glavniMenuBar.add(alatiMenu);		
		JMenuItem sistemObavjestavanjaItem = new JMenuItem("Sistem obavje�tavanja");
		sistemObavjestavanjaItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() 
				{
					public void run() 
					{
						sistemObavje�tavanjaGUI ex = new sistemObavje�tavanjaGUI();
						ex.setVisible(true);
					}
				});
			}
		});
		alatiMenu.add(sistemObavjestavanjaItem);
		
		JMenu pomocMenu = new JMenu("Pomo�");
		glavniMenuBar.add(pomocMenu);		
		JMenuItem oNamaItem = new JMenuItem("O nama");
		oNamaItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                oNamaGUI ex = new oNamaGUI();
		                ex.setSize(300, 150);
		                ex.setLocationRelativeTo(null);
		                ex.setVisible(true);
		            }
		        });
			}
		});
		pomocMenu.add(oNamaItem);		
		JMenuItem korisnickoUputstvoItem = new JMenuItem("Korisni�ko upustvo");
		korisnickoUputstvoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Opcija �e ponuditi preuzimanje .pdf dokumenta sa korisni�km uputstvom", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		pomocMenu.add(korisnickoUputstvoItem);
		
		ImageIcon logoIkona = new ImageIcon(getClass().getResource("logo.png"));
		JLabel logoLbl = new JLabel(logoIkona);
		logoLbl.setBackground(Color.WHITE);
		JPanel centralniPanel = new JPanel();
		centralniPanel.setBackground(Color.WHITE);
		centralniPanel.add(logoLbl);
		getContentPane().add(centralniPanel, BorderLayout.CENTER);
		
		JPanel juzniPanel = new JPanel();
		JButton radniZadaciBtn= new JButton("Radni zadaci");
		radniZadaciBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                radniZadaciRacunovodstvoGUI ex = new radniZadaciRacunovodstvoGUI();
		                ex.setSize(1000, 350);
		                ex.setLocationRelativeTo(null);
		                ex.setVisible(true);
		            }
		        });
			}
		});
		JButton izvjestajiBtn = new JButton("Izvje�taji");
		izvjestajiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                kreirajIzvjestajGUI ex = new kreirajIzvjestajGUI();
		                ex.setSize(600, 160);
		                ex.setLocationRelativeTo(null);
		                ex.setVisible(true);
		            }
		        });
			}
		});
		JButton klijentiBtn = new JButton("Klijenti");
		klijentiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		               upravljanjeKlijentimaGUI ex = new upravljanjeKlijentimaGUI();
		                ex.setSize(1000, 350);
		                ex.setLocationRelativeTo(null);
		                ex.setVisible(true);
		            }
		        });
			}
		});
		JButton korinsiciBtn = new JButton("Korisnici");
		korinsiciBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                upravljanjeKorisnicimaGUI ex = new upravljanjeKorisnicimaGUI();
		                ex.setSize(1000, 350);
		                ex.setLocationRelativeTo(null);
		                ex.setVisible(true);
		            }
		        });
			}
		});
		
		juzniPanel.setBorder(BorderFactory.createEmptyBorder(10, 1, 10, 1));
		juzniPanel.setLayout(new GridLayout(1,3,3,3));
		
		juzniPanel.add(radniZadaciBtn);
		juzniPanel.add(izvjestajiBtn);
		juzniPanel.add(klijentiBtn);
		juzniPanel.add(korinsiciBtn);
		getContentPane().add(juzniPanel, BorderLayout.SOUTH);
		
		
		initUI();
	}
	
	public void  initUI() {
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
	

}
