package RacunovodstvoGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Kontroleri.*;
import Entity.RadniZadatak;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


@SuppressWarnings("serial")
public class OdabirServiseraModifikacijaGUI extends JFrame {

	private ModifikacijaZadatakGUI parent1;
	private int maxbrojServisera;
	private JTable tabela1, tabela2;
	private RadniZadatak zadatak = new RadniZadatak();
	private static OdabirServiseraModifikacijaGUI instanca;

	public OdabirServiseraModifikacijaGUI(ModifikacijaZadatakGUI parent1, RadniZadatak zadatak, int maxBrojServisera) {
		// Omogućavamo pristup metodama forme KreiranjeZadatkaGUI kao roditelja
		// ove forme
		super("Second Window");
		this.parent1=parent1;
		this.zadatak=zadatak;
		this.maxbrojServisera=maxBrojServisera;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		OdabirServiseraModifikacijaUI();
	}
	
	public static OdabirServiseraModifikacijaGUI dajInstancu(ModifikacijaZadatakGUI parent1, RadniZadatak zadatak, int maxBrojServisera) {
		if(instanca==null) {
			instanca=new OdabirServiseraModifikacijaGUI(parent1, zadatak, maxBrojServisera);
			
		}
		return instanca;
	}
	public static void unistiInstancu() { instanca= null; }

	public final void OdabirServiseraModifikacijaUI() {
		
		final OdabirServiseraModifikacijaControler controler = new OdabirServiseraModifikacijaControler();
		this.setTitle("Odabir servisera");
		// Kreiramo tabelu koja sadrži informacije o neodabranim serviserima iz baze
		// podataka
		final DefaultTableModel model1 = new DefaultTableModel(){
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		model1.addColumn("Ime");
		model1.addColumn("Prezime");
		model1.addColumn("Broj dodijeljenih zadataka");
		@SuppressWarnings("rawtypes")
		final List<List> redoviTabele1 = new ArrayList<List>();
		
		try {
			controler.setDostupneServisere(zadatak);
			controler.setPostojeceServisere(zadatak);
			redoviTabele1.addAll(controler.getRedoviTabele(1));
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(rootPane,
					"Pojavila se greška. Pokušajte ponovo.",
					"Poruka o grešci", JOptionPane.ERROR_MESSAGE);
		}

		for(int i=0; i<redoviTabele1.size(); i++)
			model1.addRow(new Object[]{redoviTabele1.get(i).get(0),redoviTabele1.get(i).get(1), redoviTabele1.get(i).get(2)});
		
		final DefaultTableModel model2 = new DefaultTableModel(){
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		model2.addColumn("Ime");
		model2.addColumn("Prezime");
		model2.addColumn("Broj dodijeljenih zadataka");		
		
		@SuppressWarnings("rawtypes")
		List<List> redoviTabele2 = new ArrayList<List>();
		try {
			redoviTabele2.addAll(controler.getRedoviTabele(2));
		} 
			 catch (Exception e1) {
					JOptionPane.showMessageDialog(rootPane,
							"Pojavila se greška. Pokušajte ponovo.",
							"Poruka o grešci", JOptionPane.ERROR_MESSAGE);
		}

		for(int i=0; i<redoviTabele2.size(); i++)
			model2.addRow(new Object[]{redoviTabele2.get(i).get(0),redoviTabele2.get(i).get(1), redoviTabele2.get(i).get(2)});
		
		
		tabela1 = new JTable(model1);
		tabela1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		tabela2 = new JTable(model2);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(10, 1, 10, 1));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 0, 0, 0));
		
		JLabel naslov2 = new JLabel("Odabrani serviseri za selektirani zadatak:");
		panel.add(naslov2);
		JScrollPane tabela2Panel = new JScrollPane(tabela2);
		panel.add(tabela2Panel);
		JLabel naslov1 = new JLabel("Odaberite servisera/e za selektirani zadatak:");
		panel.add(naslov1);

		JScrollPane tabela1Panel = new JScrollPane(tabela1);
		panel.add(tabela1Panel);
		
				JPanel juzniPanel = new JPanel();
				

				addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent e) {
						try {
							model1.setRowCount(0);
							model2.setRowCount(0);
							controler.setDostupneServisere(zadatak);
							controler.setPostojeceServisere(zadatak);
							redoviTabele1.addAll(controler.getRedoviTabele(1));
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(rootPane,
									"Pojavila se greška. Pokušajte ponovo.",
									"Poruka o grešci", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				
				JButton Nazad = new JButton("<< Nazad");
				Nazad.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(parent1!=null)
							parent1.setServiseri(controler.getSelektovaniServiseri());
						dispose();

					}
				});
				
						JButton Vise = new JButton("Prikaži više");
						Vise.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								EventQueue.invokeLater(new Runnable() {
									public void run() {
										try {
											// Otvaramo prozor koji prikazuje detaljne
											// informacije o selektovanom serviseru
											int indexTabela = tabela1.getSelectedRow();
											@SuppressWarnings("unused")
											PrikaziDetaljnoKorisnikaGUI window = new PrikaziDetaljnoKorisnikaGUI(
													controler.getSelektovaniServiser(indexTabela));

										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								});
							}
						});
						JButton Zavrsi = new JButton("Završi dodjelu");
						Zavrsi.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// Spremamo selektovane servisere u listu koja se prosljeđuje
								// roditelj - formi
								
								int indexServiseri[] = tabela1.getSelectedRows();
								int selektovaniServiseri = controler.getSelektoviServiseriSize(indexServiseri);
								
								if (selektovaniServiseri > 0) 
								{
									if(parent1!=null)
									{
										
										if(controler.ProvjeriBrojServisera(maxbrojServisera))
										{
										
											parent1.setServiserSelektovan(true);
											JOptionPane
													.showMessageDialog(
															rootPane,
															"Odabranim serviserima je dodijeljen radni zadatak",
															"Poruka o uspješnosti operacije",
															JOptionPane.INFORMATION_MESSAGE);
										}
										else
										{
											JOptionPane
												.showMessageDialog(
													rootPane,
													"Brojj servisera koje možete odabrati je: "+maxbrojServisera,
													"Poruka o uspješnosti operacije",
													JOptionPane.ERROR_MESSAGE);
										}
									
									}
									
								}
								
								else
									JOptionPane
									.showMessageDialog(
											rootPane,
											"Niste selektovali nijedan red u tabeli.",
											"Poruka o uspješnosti operacije",
											JOptionPane.ERROR_MESSAGE);
									

							}
						});
						
								juzniPanel.setBorder(BorderFactory.createEmptyBorder(10, 1, 10, 1));
								juzniPanel.setLayout(new GridLayout(1, 3, 3, 3));
								
										juzniPanel.add(Nazad);
										juzniPanel.add(Vise);
										juzniPanel.add(Zavrsi);
										getContentPane().add(juzniPanel, BorderLayout.SOUTH);
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		unistiInstancu();
		super.dispose();
	}

}
