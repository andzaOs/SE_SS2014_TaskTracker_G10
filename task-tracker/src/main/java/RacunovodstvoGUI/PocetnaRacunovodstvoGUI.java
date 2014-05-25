package RacunovodstvoGUI;

import java.awt.BorderLayout;
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

import UtilClasses.KorisnickoUputstvo;

public class PocetnaRacunovodstvoGUI extends JFrame {

	public PocetnaRacunovodstvoGUI() {
		setTitle("Meni računovodstvo");
		getContentPane().setBackground(Color.WHITE);
		
		JMenuBar glavniMenuBar = new JMenuBar();
		setJMenuBar(glavniMenuBar);
		
		JMenu mojRacunMenu = new JMenu("Moj račun");
		glavniMenuBar.add(mojRacunMenu);
		JMenuItem promijeniSifruItem = new JMenuItem("Promijeni šifru");
		promijeniSifruItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							
							PromjenaSifreGUI window = new PromjenaSifreGUI();
							
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
						OdjaviSeGUI ex = new OdjaviSeGUI();
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
		JMenuItem sistemObavjestavanjaItem = new JMenuItem("Sistem obavještavanja");
		sistemObavjestavanjaItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() 
				{
					public void run() 
					{
						SistemObavjestavanjaGUI ex = new SistemObavjestavanjaGUI();
						ex.setVisible(true);
					}
				});
			}
		});
		alatiMenu.add(sistemObavjestavanjaItem);
		
		JMenu pomocMenu = new JMenu("Pomoć");
		glavniMenuBar.add(pomocMenu);		
		JMenuItem oNamaItem = new JMenuItem("O nama");
		oNamaItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                ONamaGUI ex = new ONamaGUI();
		                ex.setSize(300, 150);
		                ex.setLocationRelativeTo(null);
		                ex.setVisible(true);
		            }
		        });
			}
		});
		pomocMenu.add(oNamaItem);		
		JMenuItem korisnickoUputstvoItem = new JMenuItem("Korisni\u010Dko uputstvo");
		korisnickoUputstvoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KorisnickoUputstvo kp = new KorisnickoUputstvo();
				kp.dobaviUputstvo();
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
		/*radniZadaciBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                RadniZadaciRacunovodstvoGUI ex = new RadniZadaciRacunovodstvoGUI();
		                ex.setSize(1000, 350);
		                ex.setLocationRelativeTo(null);
		                ex.setVisible(true);
		            }
		        });
			}
		});*/
		JButton izvjestajiBtn = new JButton("Izvještaji");
		/*izvjestajiBtn.addActionListener(new ActionListener() {
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
		});*/
		JButton klijentiBtn = new JButton("Klijenti");
		klijentiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                UpravljanjeKlijentimaGUI ex = new UpravljanjeKlijentimaGUI();
		                ex.setSize(1000, 350);
		                ex.setLocationRelativeTo(null);
		                ex.setVisible(true);
		            }
		        });
			}
		});
		JButton korinsiciBtn = new JButton("Korisnici");
		/*korinsiciBtn.addActionListener(new ActionListener() {
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
		});*/
		
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
