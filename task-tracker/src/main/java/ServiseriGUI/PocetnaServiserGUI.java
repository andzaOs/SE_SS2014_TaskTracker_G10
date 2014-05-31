package ServiseriGUI;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import RacunovodstvoGUI.ONamaGUI;
import RacunovodstvoGUI.PromjenaSifreGUI;
import UtilClasses.KorisnickoUputstvo;



public class PocetnaServiserGUI extends JFrame {
	

	private static PocetnaServiserGUI  instanca;
	 
	 
	 		public static PocetnaServiserGUI  dajInstancu() {
	 			if(instanca==null) {
	  			instanca=new PocetnaServiserGUI ();
	  			
	 			}
	 			return instanca;
	 		}
	 		public static void unistiInstancu() { instanca= null; }

	public PocetnaServiserGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Meni serviser");
		getContentPane().setBackground(Color.WHITE);
		
		
		JMenuBar menuMenuBar = new JMenuBar();
		setJMenuBar(menuMenuBar);
		
		JMenu mojRaunMenu = new JMenu("Moj ra\u010Dun");
		menuMenuBar.add(mojRaunMenu);
		
		JMenuItem promijeniSifruItem = new JMenuItem("Promijeni \u0161ifru");
		promijeniSifruItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JFrame frmPromjenaifre = new JFrame();
							PromjenaSifreGUI window = new PromjenaSifreGUI();
							
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mojRaunMenu.add(promijeniSifruItem);
		
		JMenuItem odjaviSeItem = new JMenuItem("Odjavi se");
		odjaviSeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mojRaunMenu.add(odjaviSeItem);
		
		JMenu pomocMenu = new JMenu("Pomo\u0107");
		menuMenuBar.add(pomocMenu);
		
		JMenuItem oNamaItem = new JMenuItem("O nama");
		oNamaItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ONamaGUI window = new ONamaGUI();
				window.setVisible(true);
				window.setSize(350,150);
				window.setLocationRelativeTo(null);
				}
		});
		pomocMenu.add(oNamaItem);
		
		JMenuItem korisnickoUputstvoItem = new JMenuItem("Korisni\u010Dko upustvo");
		korisnickoUputstvoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KorisnickoUputstvo kp = new KorisnickoUputstvo();
				kp.dobaviUputstvoServiseri();	
			}
		});
		pomocMenu.add(korisnickoUputstvoItem);
		
		JPanel juzniPanel = new JPanel();
		JButton mojiRadniZadaciBtn= new JButton("Moji radni zadaci");
		mojiRadniZadaciBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		               PretragaMojihRadnihZadatakaGUI ex =  PretragaMojihRadnihZadatakaGUI.dajInstancu();
		                ex.setSize(1000, 350);
		                ex.setLocationRelativeTo(null);
		                ex.setVisible(true);
		            }
		        });
			}
		});
		
		juzniPanel.setBorder(BorderFactory.createEmptyBorder(10, 1, 10, 1));
		juzniPanel.setLayout(new GridLayout(1,3,3,3));
		
		juzniPanel.add(mojiRadniZadaciBtn);
		getContentPane().add(juzniPanel, BorderLayout.SOUTH);
		
		JButton radniZadaciBtn = new JButton("Radni zadaci");
		radniZadaciBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		               PretragaRadnihZadatakaServiserGUI ex =  PretragaRadnihZadatakaServiserGUI.dajInstancu();
		                ex.setSize(1000, 350);
		                ex.setLocationRelativeTo(null);
		                ex.setVisible(true);
		            }
		        });
			}
		});
		juzniPanel.add(radniZadaciBtn);
		
		JButton obavljeniPosaoBtn = new JButton("Obavljeni posao");
		obavljeniPosaoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                PretragaObavljenogPoslaServiserGUI ex = PretragaObavljenogPoslaServiserGUI.dajInstancu();
		                ex.setSize(1000, 350);
		                ex.setLocationRelativeTo(null);
		                ex.setVisible(true);
		            }
		        });
			}
		});
		juzniPanel.add(obavljeniPosaoBtn);
		
		ImageIcon izlazIkona = new ImageIcon(getClass().getResource("logo.png"));
		JLabel izlazToolbarDugme = new JLabel(izlazIkona);
		izlazToolbarDugme.setBackground(Color.WHITE);
		JPanel toolbar = new JPanel();
		toolbar.setBackground(Color.WHITE);
		toolbar.add(izlazToolbarDugme);
		getContentPane().add(toolbar, BorderLayout.CENTER);
		
		
		initUI();
	}
	
	public void  initUI() {
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
	

	@Override
 	public void dispose() {
 		// TODO Auto-generated method stub
 		unistiInstancu();
 		super.dispose();
 	}

}
