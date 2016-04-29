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
import javax.swing.SwingUtilities;

import DAO.PostavkaMailDAO;
import Entity.PostavkaMail;
import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SpinnerNumberModel;


public class SistemObavjestavanjaGUI extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SistemObavjestavanjaGUI() 

	{
		setResizable(false);
		initUI();
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public final void initUI() 
	{
		
		//Naziv forme
		setTitle("Podešavanje automatskog obavještavanja");
		
		this.setSize(428, 296);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new MigLayout("", "[190.00][][170.00,grow]", "[][3.00][28.00][grow][]"));
		
		JLabel krajnjiRokZaUnosLbl = new JLabel("Krajnji rok za unos obavljenog posla:");
		getContentPane().add(krajnjiRokZaUnosLbl, "cell 0 0");
		
		final JSpinner rokUnosSpin = new JSpinner();
		rokUnosSpin.setModel(new SpinnerNumberModel(1, 0, 365, 1));
		getContentPane().add(rokUnosSpin, "cell 1 0");
		
		JLabel danaLbl = new JLabel("dana");
		getContentPane().add(danaLbl, "cell 2 0");
		
		JLabel krajnjiRokZaPreuzimanjeLbl = new JLabel("Krajnji rok za preuzimanje zadatka:");
		getContentPane().add(krajnjiRokZaPreuzimanjeLbl, "cell 0 1");
		
		final JSpinner rokPreuzimanjeSpin = new JSpinner();
		rokPreuzimanjeSpin.setModel(new SpinnerNumberModel(2, 0, 365, 1));
		getContentPane().add(rokPreuzimanjeSpin, "cell 1 1");
		
		JLabel ldana1Lbl = new JLabel("dana");
		getContentPane().add(ldana1Lbl, "cell 2 1");
		
		JLabel sadrajOpomeneLbl = new JLabel("Sadr\u017Eaj opomene:");
		getContentPane().add(sadrajOpomeneLbl, "cell 0 2");
		
		JLabel sadrajObavijestiLbl = new JLabel("Sadr\u017Eaj obavijesti:");
		getContentPane().add(sadrajObavijestiLbl, "cell 1 2");
		
		final JTextArea opomenaTxt = new JTextArea();
		opomenaTxt.setColumns(40);
		opomenaTxt.setLineWrap(true);
		opomenaTxt.setRows(10);
		opomenaTxt.setForeground(Color.BLACK);
		getContentPane().add(opomenaTxt, "cell 0 3");
		
		final JTextArea obavijestTxt = new JTextArea();
		obavijestTxt.setRows(10);
		obavijestTxt.setColumns(40);
		obavijestTxt.setLineWrap(true);
		getContentPane().add(obavijestTxt, "cell 1 3 2 1");
		
		JButton spremiBtn = new JButton("Spremi");
		spremiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					PostavkaMail p = new PostavkaMail();
					p.setRokPreuzimanje( (Integer) rokPreuzimanjeSpin.getValue() );
					p.setRokUnos( (Integer) rokUnosSpin.getValue() );
					p.setOpomena(opomenaTxt.getText());
					p.setObavijest( obavijestTxt.getText() );
					
					PostavkaMailDAO pDAO = new PostavkaMailDAO();
					long id = pDAO.create(p);
					p.setPostavkamail_id(id);	
					
					JOptionPane.showMessageDialog(rootPane, "Promjene su spremljene", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
				
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(rootPane, ex.getMessage() , "Greška", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		getContentPane().add(spremiBtn, "cell 2 4,growx");

		
		
    	PostavkaMail p = new PostavkaMail();
    	PostavkaMailDAO pDAO = new PostavkaMailDAO();
    	p = pDAO.vratiPostavke();
    	
    	obavijestTxt.setText(p.getObavijest());
    	opomenaTxt.setText(p.getOpomena());
    	rokUnosSpin.setValue(p.getRokUnos());
    	rokPreuzimanjeSpin.setValue(p.getRokPreuzimanje());
    	
		
		//table.setFillsViewportHeight(true);
			
	
	}
	
	public static void main(String args[]) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	           SistemObavjestavanjaGUI ex = new SistemObavjestavanjaGUI();
	            ex.setVisible(true);
	        	
	        }
	    });
	}
		
	
}