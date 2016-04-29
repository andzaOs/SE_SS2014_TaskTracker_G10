package RacunovodstvoGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class ONamaGUI extends JFrame {
	public ONamaGUI() {
		setTitle("O nama");
		
		JPanel centralniPanel = new JPanel();
		centralniPanel.setLayout(new GridLayout(3,4,2,2));
		
		
		getContentPane().add(centralniPanel, BorderLayout.CENTER);
		
		JLabel oNamaLbl = new JLabel("Softverskog rje\u0161enja Task Tracker v1.0");
		oNamaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		centralniPanel.add(oNamaLbl);
		
		JLabel copyrightsAxisSoftwareLbl = new JLabel("@Copyrights Axis Software Development 2014");
		copyrightsAxisSoftwareLbl.setHorizontalAlignment(SwingConstants.CENTER);
		centralniPanel.add(copyrightsAxisSoftwareLbl);
		
		JPanel juzniPanel = new JPanel();
		juzniPanel.setBorder(BorderFactory.createEmptyBorder(2, 1, 2, 1));
		juzniPanel.setLayout(new GridLayout(1,4,1,1));
		JLabel lblPrazna5 = new JLabel("");
		JLabel lblPrazna6= new JLabel("");
		juzniPanel.add(lblPrazna5);
		JButton ureduBtn = new JButton("Uredu");
		ureduBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		juzniPanel.add(ureduBtn);
		juzniPanel.add(lblPrazna6);
		
		getContentPane().add(juzniPanel, BorderLayout.SOUTH);
	}
	
	

}
