package RacunovodstvoGUI;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class PromjenaSifreGUI {

	
	private JTextField staraSifraTxt;
	private JTextField novaSifraTxt;
	private JTextField potvrdaNoveSifreTxt;

	public PromjenaSifreGUI(JFrame frmPromjenaifre) {
		initialize(frmPromjenaifre);
	}

	
	private void initialize(JFrame frmPromjenaSifre) {
		
		frmPromjenaSifre.setTitle("Promjena šifre");
		frmPromjenaSifre.setBounds(100, 100, 353, 277);
		
		frmPromjenaSifre.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		staraSifraTxt = new JTextField();
		staraSifraTxt.setForeground(Color.LIGHT_GRAY);
		staraSifraTxt.setText("Stara \u0161ifra");
		frmPromjenaSifre.getContentPane().add(staraSifraTxt, "4, 4, 5, 1, fill, default");
		staraSifraTxt.setColumns(10);
		
		novaSifraTxt = new JTextField();
		novaSifraTxt.setText("Nova \u0161ifra");
		novaSifraTxt.setForeground(Color.LIGHT_GRAY);
		novaSifraTxt.setColumns(10);
		frmPromjenaSifre.getContentPane().add(novaSifraTxt, "4, 8, 5, 1, fill, default");
		
		potvrdaNoveSifreTxt = new JTextField();
		potvrdaNoveSifreTxt.setForeground(Color.LIGHT_GRAY);
		potvrdaNoveSifreTxt.setText("Potvrda nove \u0161ifre");
		potvrdaNoveSifreTxt.setColumns(10);
		frmPromjenaSifre.getContentPane().add(potvrdaNoveSifreTxt, "4, 12, 5, 1, fill, default");
		
		final JButton promijeniBtn = new JButton("Promijeni");
		promijeniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(promijeniBtn, "Nije implementirano", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		frmPromjenaSifre.getContentPane().add(promijeniBtn, "4, 16, right, default");
		
		frmPromjenaSifre.setLocationRelativeTo(null);
		frmPromjenaSifre.setVisible(true);
	}

}
