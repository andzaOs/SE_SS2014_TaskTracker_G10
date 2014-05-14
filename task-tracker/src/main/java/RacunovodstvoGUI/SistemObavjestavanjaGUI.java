package RacunovodstvoGUI;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class SistemObavjestavanjaGUI extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SistemObavjestavanjaGUI() 

	{
		initUI();
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public final void initUI() 
	{
		
		//Naziv forme
		setTitle("Pode�avanje automatskog obavje�tavanja i opominjanja korisnika");
		
		this.setSize(404, 296);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new MigLayout("", "[190.00][][170.00,grow]", "[][3.00][28.00][grow][]"));
		
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
		getContentPane().add(sadrajObavijestiLbl, "cell 1 2");
		
		JTextArea sadrzajTxt = new JTextArea();
		sadrzajTxt.setForeground(Color.BLACK);
		getContentPane().add(sadrzajTxt, "cell 0 3,grow");
		
		JButton spremiBtn = new JButton("Spremi");
		spremiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Nije implementirano", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JTextArea textArea = new JTextArea();
		getContentPane().add(textArea, "cell 1 3 2 1,grow");
		getContentPane().add(spremiBtn, "cell 2 4,growx");
		
		
		
	
		
		//table.setFillsViewportHeight(true);
			
	
	}


	
}