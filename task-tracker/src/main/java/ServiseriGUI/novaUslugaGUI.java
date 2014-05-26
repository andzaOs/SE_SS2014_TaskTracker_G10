package ServiseriGUI;

import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class novaUslugaGUI {

	private JFrame frmDodajNovuUslugu;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					novaUslugaGUI window = new novaUslugaGUI();
					window.frmDodajNovuUslugu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public novaUslugaGUI(JComboBox c) {
		
		initialize(c);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final JComboBox c) {
		frmDodajNovuUslugu = new JFrame();
		frmDodajNovuUslugu.setTitle("Dodaj novu uslugu");
		frmDodajNovuUslugu.setBounds(100, 100, 313, 143);
		//frmDodajNovuUslugu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDodajNovuUslugu.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Naziv usluge:");
		lblNewLabel.setBounds(24, 22, 78, 20);
		frmDodajNovuUslugu.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(105, 22, 129, 20);
		frmDodajNovuUslugu.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnDodajUslugu = new JButton("Dodaj uslugu");
		btnDodajUslugu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				c.addItem(textField.getText());
				frmDodajNovuUslugu.dispose();
				   
			}
		});
		btnDodajUslugu.setBounds(105, 53, 129, 23);
		frmDodajNovuUslugu.getContentPane().add(btnDodajUslugu);
		frmDodajNovuUslugu.setLocationRelativeTo(null);
		frmDodajNovuUslugu.setVisible(true);
		
	}
}
