package ServiserGUI;

//komentar za test commit
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
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;


public class evidentiranjeObavljenogPoslaGUI extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField vrstaUslugeTxt;
	
	public evidentiranjeObavljenogPoslaGUI() 

	{
		initUI();
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public final void initUI() 
	{
		
		//Naziv forme
		setTitle("Evidentiranje obavljenog posla");
		
		this.setSize(311, 307);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mojRacunMeni = new JMenu("Moj ra\u010Dun");
		menuBar.add(mojRacunMeni);
		
		JMenuItem promjenaSifreItem = new JMenuItem("Promijeni \u0161ifru");
		mojRacunMeni.add(promjenaSifreItem);
		
		JMenuItem odjaviSeItem = new JMenuItem("Odjavi se");
		mojRacunMeni.add(odjaviSeItem);
		
		JMenu pomocMeni = new JMenu("Pomo\u0107");
		menuBar.add(pomocMeni);
		
		JMenuItem korisnickoUpustvoItem = new JMenuItem("Korisni\u010Dko upustvo");
		pomocMeni.add(korisnickoUpustvoItem);
		
		JMenuItem oNamaItem = new JMenuItem("O nama");
		pomocMeni.add(oNamaItem);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{112, 207, 0};
		gridBagLayout.rowHeights = new int[]{41, 0, 0, 219, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel vrstaUslugeLbl = new JLabel("Vrsta usluge:");
		GridBagConstraints gbc_vrstaUslugeLbl = new GridBagConstraints();
		gbc_vrstaUslugeLbl.insets = new Insets(0, 0, 5, 5);
		gbc_vrstaUslugeLbl.anchor = GridBagConstraints.EAST;
		gbc_vrstaUslugeLbl.gridx = 0;
		gbc_vrstaUslugeLbl.gridy = 0;
		getContentPane().add(vrstaUslugeLbl, gbc_vrstaUslugeLbl);
		
		vrstaUslugeTxt = new JTextField();
		vrstaUslugeTxt.setText("Instaliranje OS-a");
		GridBagConstraints gbc_vrstaUslugeTxt = new GridBagConstraints();
		gbc_vrstaUslugeTxt.insets = new Insets(0, 0, 5, 0);
		gbc_vrstaUslugeTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_vrstaUslugeTxt.gridx = 1;
		gbc_vrstaUslugeTxt.gridy = 0;
		getContentPane().add(vrstaUslugeTxt, gbc_vrstaUslugeTxt);
		vrstaUslugeTxt.setColumns(10);
		
		JLabel utrosenoVrijemeLbl = new JLabel("Utro\u0161eno vrijeme:");
		GridBagConstraints gbc_utrosenoVrijemeLbl = new GridBagConstraints();
		gbc_utrosenoVrijemeLbl.anchor = GridBagConstraints.EAST;
		gbc_utrosenoVrijemeLbl.insets = new Insets(0, 0, 5, 5);
		gbc_utrosenoVrijemeLbl.gridx = 0;
		gbc_utrosenoVrijemeLbl.gridy = 1;
		getContentPane().add(utrosenoVrijemeLbl, gbc_utrosenoVrijemeLbl);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner.insets = new Insets(0, 0, 5, 0);
		gbc_spinner.gridx = 1;
		gbc_spinner.gridy = 1;
		getContentPane().add(spinner, gbc_spinner);
		
		JButton unesiBtn = new JButton("Unesi vrstu usluge");
		GridBagConstraints gbc_unesiBtn = new GridBagConstraints();
		gbc_unesiBtn.anchor = GridBagConstraints.EAST;
		gbc_unesiBtn.insets = new Insets(0, 0, 5, 0);
		gbc_unesiBtn.gridx = 1;
		gbc_unesiBtn.gridy = 2;
		getContentPane().add(unesiBtn, gbc_unesiBtn);
		
		JLabel opisPoslaLbl = new JLabel("Opis posla:");
		GridBagConstraints gbc_opisPoslaLbl = new GridBagConstraints();
		gbc_opisPoslaLbl.anchor = GridBagConstraints.EAST;
		gbc_opisPoslaLbl.insets = new Insets(0, 0, 5, 5);
		gbc_opisPoslaLbl.gridx = 0;
		gbc_opisPoslaLbl.gridy = 3;
		getContentPane().add(opisPoslaLbl, gbc_opisPoslaLbl);
		
		JButton evidentirajPosaoBtn = new JButton("Evidentiraj obavljeni posao");
		evidentirajPosaoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JTextArea opisPoslaTxt = new JTextArea();
		GridBagConstraints gbc_opisPoslaTxt = new GridBagConstraints();
		gbc_opisPoslaTxt.insets = new Insets(0, 0, 5, 0);
		gbc_opisPoslaTxt.fill = GridBagConstraints.BOTH;
		gbc_opisPoslaTxt.gridx = 1;
		gbc_opisPoslaTxt.gridy = 3;
		getContentPane().add(opisPoslaTxt, gbc_opisPoslaTxt);
		GridBagConstraints gbc_evidentirajPosaoBtn = new GridBagConstraints();
		gbc_evidentirajPosaoBtn.anchor = GridBagConstraints.NORTHEAST;
		gbc_evidentirajPosaoBtn.gridx = 1;
		gbc_evidentirajPosaoBtn.gridy = 4;
		getContentPane().add(evidentirajPosaoBtn, gbc_evidentirajPosaoBtn);
		
		
		
	
		
		//table.setFillsViewportHeight(true);
			
	
	}


	
}