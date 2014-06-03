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
import javax.swing.table.DefaultTableModel;

import Kontroleri.*;
import Entity.RadniZadatak;

import javax.swing.ListSelectionModel;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings("serial")
public class OdabirServiseraGUI extends JFrame {

	private KreiranjeZadatkaGUI parent1;
	private RadniZadaciRacunovodstvoGUI parent2;
	private int maxbrojServisera;
	private JTable tabela;
	private RadniZadatak zadatak = new RadniZadatak();
	private static OdabirServiseraGUI instanca;
	
	public OdabirServiseraGUI(KreiranjeZadatkaGUI parent1,RadniZadaciRacunovodstvoGUI parent2, RadniZadatak zadatak, int maxBrojServisera) {
		// Omogućavamo pristup metodama forme KreiranjeZadatkaGUI kao roditelja
		// ove forme
		super("Second Window");
		this.parent1=parent1;
		this.parent2=parent2;
		this.zadatak=zadatak;
		this.maxbrojServisera=maxBrojServisera;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		OdaberiServiseraUI();
	}
	
	public static OdabirServiseraGUI dajInstancu(KreiranjeZadatkaGUI parent1,RadniZadaciRacunovodstvoGUI parent2, RadniZadatak zadatak, int maxBrojServisera) {
			if(instanca==null) {
 			instanca=new OdabirServiseraGUI(parent1, parent2, zadatak, maxBrojServisera);
 			
			}
			return instanca;
		}
		public static void unistiInstancu() { instanca= null; }

	public final void OdaberiServiseraUI() {
		
		final OdabirServiseraControler controler = new OdabirServiseraControler();

		JLabel naslov = new JLabel(
				"Odaberite servisera/e za selektirani zadatak:");

		// Kreiramo tabelu koja sadrži informacije o svim serviserima iz baze
		// podataka
		final DefaultTableModel model = new DefaultTableModel(){
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		tabela = new JTable(model);
		tabela.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		model.addColumn("Ime");
		model.addColumn("Prezime");
		model.addColumn("Broj dodijeljenih zadataka");
		@SuppressWarnings("rawtypes")
		final List<List> redoviTabele = new ArrayList<List>();
		
		try {
			controler.setServisere(zadatak);
			redoviTabele.addAll(controler.getRedoviTabele());
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(rootPane,
					"Pojavila se greška. Pokušajte ponovo.",
					"Poruka o grešci", JOptionPane.ERROR_MESSAGE);
		}


		for(int i=0; i<redoviTabele.size(); i++)
			model.addRow(new Object[]{redoviTabele.get(i).get(0),redoviTabele.get(i).get(1), redoviTabele.get(i).get(2)});
		

		JScrollPane tabelaPane = new JScrollPane(tabela);

		JPanel juzniPanel = new JPanel();
		JButton Nazad = new JButton("<< Nazad");
		Nazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(parent1!=null)
					parent1.setServiseri(controler.getSelektovaniServiseri());
				dispose();

			}
		});
		
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try {
					model.setRowCount(0);
					controler.setServisere(zadatak);
					redoviTabele.addAll(controler.getRedoviTabele());
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(rootPane,
							"Pojavila se greška. Pokušajte ponovo.",
							"Poruka o grešci", JOptionPane.ERROR_MESSAGE);
				}
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
							if(tabela.getSelectedRowCount()>0)
							{
							int indexTabela = tabela.getSelectedRow();
							@SuppressWarnings("unused")
							PrikaziDetaljnoKorisnikaGUI window = new PrikaziDetaljnoKorisnikaGUI(
									controler.getSelektovaniServiser(indexTabela));
							}
							else
								JOptionPane
								.showMessageDialog(
										rootPane,
										"Niste odabrali nijednog servisera.",
										"Poruka o grešci",
										JOptionPane.ERROR_MESSAGE);

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
				
				int indexServiseri[] = tabela.getSelectedRows();
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
									"Broj servisera koje možete odabrati je: "+maxbrojServisera,
									"Poruka o uspješnosti operacije",
									JOptionPane.ERROR_MESSAGE);
						}
					
					}
					
					else if(parent2!=null)
					{
						Boolean serviseriDodijeljeni;
						try {
							serviseriDodijeljeni = controler.DodijeliServisere(zadatak);
						
						if(serviseriDodijeljeni==false)
						{
							int brojServisera=zadatak.getBrojServisera()-zadatak.getStatusDodjeljenosti();
							JOptionPane
							.showMessageDialog(
									rootPane,
									"Broj servisera koje možete odabrati je: "+brojServisera,
									"Poruka o uspješnosti operacije",
									JOptionPane.ERROR_MESSAGE);
						}
						else
						{
						JOptionPane
								.showMessageDialog(
										rootPane,
										"Odabranim serviserima je dodijeljen radni zadatak",
										"Poruka o uspješnosti operacije",
										JOptionPane.INFORMATION_MESSAGE);
						}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(rootPane,
									"Pojavila se greška. Pokušajte ponovo.",
									"Poruka o grešci", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				
				else
					JOptionPane
					.showMessageDialog(
							rootPane,
							"Niste odabrali nijednog servisera.",
							"Poruka o uspješnosti operacije",
							JOptionPane.ERROR_MESSAGE);
					

			}
		});

		juzniPanel.setBorder(BorderFactory.createEmptyBorder(10, 1, 10, 1));
		juzniPanel.setLayout(new GridLayout(1, 3, 3, 3));

		juzniPanel.add(Nazad);
		juzniPanel.add(Vise);
		juzniPanel.add(Zavrsi);

		getContentPane().add(naslov, BorderLayout.NORTH);
		getContentPane().add(tabelaPane, BorderLayout.CENTER);
		getContentPane().add(juzniPanel, BorderLayout.SOUTH);
	}
	@Override
	public void dispose() {
		unistiInstancu();
		super.dispose();
	}


}
