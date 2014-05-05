package RacunovodstvoGUI;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;


public class sistemObavještavanjaGUI extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public sistemObavještavanjaGUI() 

	{
		initUI();
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public final void initUI() 
	{
		
		//Naziv forme
		setTitle("Podešavanje automatskog obavještavanja i opominjanja korisnika");
		
		this.setSize(404, 296);
		setLocationRelativeTo(null);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mojRacunMenu = new JMenu("Moj ra\u010Dun");
		menuBar.add(mojRacunMenu);
		
		JMenuItem promijeniSifruItem = new JMenuItem("Promijeni \u0161ifru");
		mojRacunMenu.add(promijeniSifruItem);
		
		JMenuItem odjaviSeItem = new JMenuItem("Odjavi se");
		mojRacunMenu.add(odjaviSeItem);
		
		JMenu pomocMenu = new JMenu("Pomo\u0107");
		menuBar.add(pomocMenu);
		
		JMenuItem korisnikoUpustvoItem = new JMenuItem("Korisni\u010Dko upustvo");
		pomocMenu.add(korisnikoUpustvoItem);
		
		JMenuItem oNamaItem = new JMenuItem("O nama");
		pomocMenu.add(oNamaItem);
		getContentPane().setLayout(new MigLayout("", "[][][170.00,grow]", "[][3.00][28.00][grow][]"));
		
		JLabel krajnjiRokZaUnosLbl = new JLabel("Krajnji rok za unos obavljenog posla:");
		getContentPane().add(krajnjiRokZaUnosLbl, "cell 0 0");
		
		JSpinner spinner = new JSpinner();
		getContentPane().add(spinner, "cell 1 0");
		
		JLabel danaLbl = new JLabel("dana");
		getContentPane().add(danaLbl, "cell 2 0");
		
		JLabel krajnjiRokZaPreuzimanjeLbl = new JLabel("Krajnji rok za preuzimanje zadatka:");
		getContentPane().add(krajnjiRokZaPreuzimanjeLbl, "cell 0 1");
		
		JSpinner spinner_1 = new JSpinner();
		getContentPane().add(spinner_1, "cell 1 1");
		
		JLabel ldana1Lbl = new JLabel("dana");
		getContentPane().add(ldana1Lbl, "cell 2 1");
		
		JLabel sadrajOpomeneLbl = new JLabel("Sadr\u017Eaj opomene:");
		getContentPane().add(sadrajOpomeneLbl, "cell 0 2");
		
		JLabel sadrajObavijestiLbl = new JLabel("Sadr\u017Eaj obavijesti:");
		getContentPane().add(sadrajObavijestiLbl, "cell 2 2");
		
		JTextArea sadrzajTxt = new JTextArea();
		getContentPane().add(sadrzajTxt, "cell 0 3,grow");
		
		JTextArea obavijestiTxt = new JTextArea();
		getContentPane().add(obavijestiTxt, "cell 2 3,grow");
		
		JButton spremiBtn = new JButton("Spremi");
		getContentPane().add(spremiBtn, "cell 2 4,alignx right");
		
		
		
	
		
		//table.setFillsViewportHeight(true);
			
	
	}


	
}