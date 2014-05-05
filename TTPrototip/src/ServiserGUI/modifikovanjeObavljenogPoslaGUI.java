package ServiserGUI;




import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class modifikovanjeObavljenogPoslaGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTable table;
	
	public modifikovanjeObavljenogPoslaGUI() 

	{
		initUI();
	}
	public final void initUI() 
	{
	//Naziv forme
			setTitle("Modifikovanje obavljenog posla");
			
			this.setSize(528, 296);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			JMenu mojRacunMeni = new JMenu("Moj ra\u010Dun");
			menuBar.add(mojRacunMeni);
			
			JMenuItem promjeniSifruItem = new JMenuItem("Promijeni \u0161ifru");
			mojRacunMeni.add(promjeniSifruItem);
			
			JMenuItem odjaviSeItem = new JMenuItem("Odjavi se");
			mojRacunMeni.add(odjaviSeItem);
			
			JMenu pomocMeni = new JMenu("Pomo\u0107");
			menuBar.add(pomocMeni);
			
			JMenuItem korisnickoUpustvoItem = new JMenuItem("Korisni\u010Dko upustvo");
			pomocMeni.add(korisnickoUpustvoItem);
			
			JMenuItem oNamaItem = new JMenuItem("O nama");
			pomocMeni.add(oNamaItem);
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{207, 0};
			gridBagLayout.rowHeights = new int[]{92, 0, 100, 0, 0};
			gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			getContentPane().setLayout(gridBagLayout);
			
			JButton spasiPromjeneBtn = new JButton("Spasi promjene");
			spasiPromjeneBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 0;
			getContentPane().add(scrollPane, gbc_scrollPane);
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{"Instalacija OS", "2"},
					{"Instalacija antivirusa", "0.5"},
					{"Konfiguracija rutera", "0.5"},
				},
				new String[] {
					"Vrsta usluge", "Utro\u0161eni sati"
				}
			));
			scrollPane.setViewportView(table);
			
			JLabel opisPoslaLbl = new JLabel("Opis posla:");
			GridBagConstraints gbc_opisPoslaLbl = new GridBagConstraints();
			gbc_opisPoslaLbl.anchor = GridBagConstraints.WEST;
			gbc_opisPoslaLbl.insets = new Insets(0, 0, 5, 0);
			gbc_opisPoslaLbl.gridx = 0;
			gbc_opisPoslaLbl.gridy = 1;
			getContentPane().add(opisPoslaLbl, gbc_opisPoslaLbl);
			
			JTextArea opisPoslaTxt = new JTextArea();
			opisPoslaTxt.setText("Korisnik je zahtijevao dodatne usluge koje su une\u0161ene u sistem. ");
			GridBagConstraints gbc_opisPoslaTxt = new GridBagConstraints();
			gbc_opisPoslaTxt.insets = new Insets(0, 0, 5, 0);
			gbc_opisPoslaTxt.fill = GridBagConstraints.BOTH;
			gbc_opisPoslaTxt.gridx = 0;
			gbc_opisPoslaTxt.gridy = 2;
			getContentPane().add(opisPoslaTxt, gbc_opisPoslaTxt);
			GridBagConstraints gbc_spasiPromjeneBtn = new GridBagConstraints();
			gbc_spasiPromjeneBtn.anchor = GridBagConstraints.NORTHEAST;
			gbc_spasiPromjeneBtn.gridx = 0;
			gbc_spasiPromjeneBtn.gridy = 3;
			getContentPane().add(spasiPromjeneBtn, gbc_spasiPromjeneBtn);
	}
	
	public static void main(String args[]) 
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				modifikovanjeObavljenogPoslaGUI ex = new modifikovanjeObavljenogPoslaGUI();
				ex.setVisible(true);
			}
		});
	}
			
}
