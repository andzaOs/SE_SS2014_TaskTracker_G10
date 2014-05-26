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

@SuppressWarnings("serial")
public class OdabirServiseraGUI extends JFrame {

	private KreiranjeZadatkaGUI parent1;
	private RadniZadaciRacunovodstvoGUI parent2;
	private int maxbrojServisera;
	private JTable tabela;
	private RadniZadatak zadatak = new RadniZadatak();

	public OdabirServiseraGUI(KreiranjeZadatkaGUI parent1,RadniZadaciRacunovodstvoGUI parent2, RadniZadatak zadatak, int maxBrojServisera) {
		// Omogućavamo pristup metodama forme KreiranjeZadatkaGUI kao roditelja
		// ove forme
		super("Second Window");
		this.parent1=parent1;
		this.parent2=parent2;
		this.zadatak=zadatak;
		this.maxbrojServisera=maxBrojServisera;
		OdaberiServiseraUI();
	}

	public final void OdaberiServiseraUI() {
		
		final OdabirServiseraControler controler = new OdabirServiseraControler();

		JLabel naslov = new JLabel(
				"Odaberite servisera/e za selektirani zadatak:");

		// Kreiramo tabelu koja sadrži informacije o svim serviserima iz baze
		// podataka
		DefaultTableModel model = new DefaultTableModel();
		tabela = new JTable(model);
		tabela.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		model.addColumn("Ime");
		model.addColumn("Prezime");
		model.addColumn("Broj dodijeljenih zadataka");
		
		if(parent2!=null) controler.setServisere(zadatak);
		else controler.setServisere(null);
		@SuppressWarnings("rawtypes")
		List<List> redoviTabele = new ArrayList<List>();
		redoviTabele.addAll(controler.getRedoviTabele());

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

		JButton Vise = new JButton("Prikaži više");
		Vise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							// Otvaramo prozor koji prikazuje detaljne
							// informacije o selektovanom serviseru
							int indexTabela = tabela.getSelectedRow();
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
									"Brojj servisera koje možete odabrati je: "+maxbrojServisera,
									"Poruka o uspješnosti operacije",
									JOptionPane.ERROR_MESSAGE);
						}
					
					}
					
					else if(parent2!=null)
					{
						Boolean serviseriDodijeljeni;
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

		getContentPane().add(naslov, BorderLayout.NORTH);
		getContentPane().add(tabelaPane, BorderLayout.CENTER);
		getContentPane().add(juzniPanel, BorderLayout.SOUTH);
	}

}
