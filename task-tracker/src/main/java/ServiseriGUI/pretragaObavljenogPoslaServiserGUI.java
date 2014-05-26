package ServiseriGUI;



import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import DAO.ObavljeniPosaoDAO;
import DAO.RasporedjeniZadatakDAO;
import UtilClasses.DateLabelFormatter;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import Entity.ObavljeniPosao;
import Entity.RadniZadatak;
import Entity.RasporedjeniZadatak;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;


public class pretragaObavljenogPoslaServiserGUI extends JFrame{
	private JLabel pocetniDatumLbl;
	private JTextField pocetniDatumTxt;
	private JLabel krajnjiDatumLbl;
	private JButton pretraziRadniZadatakBtn;
	private JMenuBar menuBar;
	private JMenu mojRacunMenu;
	private JMenuItem promijeniSifruItem;
	private JMenuItem odjaviSeItem;
	private JMenu pomocMenu;
	private JMenuItem korisnikovoUputstvoItemo;
	private JMenuItem oNamaItem;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;
	private JButton prikaziViseBtn;
	private JButton btnPreuzmiRadniZadatak;
	final JDatePanelImpl datePanel ;
	final JDatePickerImpl datumObavljanja ;
	final JTextField nazivKlijenta;
	final JComboBox comboUsluga;
	private long IdRadnika;
	private static List<ObavljeniPosao> posao;
	private static List<ObavljeniPosao> lista;
	final JSpinner spinnSati;
	
	
	 
	private List<ObavljeniPosao> nadjiPoKlijentu (List<ObavljeniPosao> poslovi){
		List<ObavljeniPosao> posaoPretraga=new ArrayList<ObavljeniPosao>();
		for(int i=0; i<poslovi.size(); i++){
			if( poslovi.get(i).getPripadajuciZadatak().getZadatak().getKlijent().getNaziv().equals(nazivKlijenta.getText())){
				posaoPretraga.add(poslovi.get(i));
			}}
		
			return posaoPretraga;}
	private List<ObavljeniPosao> nadjiPoUsluzi (List<ObavljeniPosao> poslovi){
		List<ObavljeniPosao> posaoPretraga=new ArrayList<ObavljeniPosao>();
		for(int i=0; i<poslovi.size(); i++){
			if(poslovi.get(i).getVrstaUsluge().getNaziv().equals((String)comboUsluga.getSelectedItem())){posaoPretraga.add(poslovi.get(i));}
			}
			return posaoPretraga;}
	
	private List<ObavljeniPosao> nadjiPoSatima (List<ObavljeniPosao> poslovi){
		List<ObavljeniPosao> posaoPretraga=new ArrayList<ObavljeniPosao>();
		for(int i=0; i<poslovi.size(); i++){
			if(poslovi.get(i).getBrojSati()==(Integer)spinnSati.getValue()){posaoPretraga.add(poslovi.get(i));}
			}
			return posaoPretraga;}
	
	private List<ObavljeniPosao> nadjiPoDatumuObavljanja (List<ObavljeniPosao> poslovi){
		List<ObavljeniPosao> posloviPretraga=new ArrayList<ObavljeniPosao>();
		Date datum=new Date();
		Calendar cal = Calendar.getInstance();
		Calendar cal1 = Calendar.getInstance();
	    
		for(int i=0; i<poslovi.size(); i++){
			
			if(poslovi.get(i).getDatumObavljanja()  !=null ){

			    datum=poslovi.get(i).getDatumObavljanja();
				Date d=(Date) datumObavljanja.getModel().getValue();
			    cal.setTime(datum);
			    cal1.setTime(d);
			    int year = cal.get(Calendar.YEAR);
			    int month = cal.get(Calendar.MONTH);
			    int day = cal.get(Calendar.DAY_OF_MONTH);
			    int year1 = cal1.get(Calendar.YEAR);
			    int month1 = cal1.get(Calendar.MONTH);
			    int day1 = cal1.get(Calendar.DAY_OF_MONTH);
			    
			    
			    if(year==year1 && month==month1 && day==day1){
			    	
		
				posloviPretraga.add(poslovi.get(i));}
			}}
			return posloviPretraga;}
	
	private void pronadji(){
		if(lista.size()>0) lista.clear();
		if(posao.size()>0) posao.clear();
		
		ObavljeniPosaoDAO zDAO=new ObavljeniPosaoDAO();
		List<ObavljeniPosao> sviposlovi= new ArrayList<ObavljeniPosao>();
		IdRadnika=1;
		sviposlovi=zDAO.getAll();
		if(sviposlovi.size()>0){
			for(int i=0;i<sviposlovi.size();i++){
				Long br= sviposlovi.get(i).getPripadajuciZadatak().getIzvrsilac().getKorisnik_id();
				if(br.equals(IdRadnika)){
					
					if (sviposlovi.get(i).getPripadajuciZadatak().getZadatak().getVidljivo()==true && sviposlovi.get(i).getPripadajuciZadatak().getZadatak().getStatusIzvrsenosti()==false){	posao.add(sviposlovi.get(i));
					}
					
					
				}
				}
		
			}
		
		
	}
	
	private void Ispisi(){
		if(posao.size()>0){
			
			for(int i=0; i<posao.size(); i++){
				    
				
					Object[] row = { posao.get(i).getDatumObavljanja()  ,(Integer)posao.get(i).getBrojSati() ,posao.get(i).getVrstaUsluge().getNaziv()};
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(row);

					
				}
			 }
		
	}
	
	
	private static  pretragaObavljenogPoslaServiserGUI instanca;
	 
	 
		public static  pretragaObavljenogPoslaServiserGUI dajInstancu() {
			if(instanca==null) {
			instanca=new  pretragaObavljenogPoslaServiserGUI();
			
			}
			return instanca;
		}
		public static void unistiInstancu() { instanca= null; }
	
	public pretragaObavljenogPoslaServiserGUI() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				 if(model.getRowCount()>0){   model.setRowCount(0); }
				 pronadji();
				 Ispisi();
				 
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		
		
		setTitle("Historija obavljenog posla");
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("right:default"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		lista=new ArrayList<ObavljeniPosao>();
		posao=new ArrayList<ObavljeniPosao>();
		IdRadnika=1;
		pronadji();
		
		scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, "1, 8, 7, 17, fill, fill");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Datum obavljanja", "Utro\u0161eni sati", "Vrsta usluge"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(128);
		scrollPane.setViewportView(table);
		Ispisi();

		
		
		
		JLabel nazivKlijentaLbl = new JLabel("Naziv klijenta:");
		getContentPane().add(nazivKlijentaLbl, "1, 2, right, default");
		
		nazivKlijenta = new JTextField();
		getContentPane().add(nazivKlijenta, "3, 2, fill, default");
		nazivKlijenta.setColumns(10);
		
		JLabel vrstaZadatkaLbl = new JLabel("Vrsta usluge:");
		getContentPane().add(vrstaZadatkaLbl, "5, 2, right, default");
		
		comboUsluga = new JComboBox();
		comboUsluga.setModel(new DefaultComboBoxModel(new String[] {"", "Instalacija OS-a", "Zamjena hard diska", "Instalcija rootera"}));
		getContentPane().add(comboUsluga, "7, 2, fill, default");
		
		pocetniDatumLbl = new JLabel("Datum obavljanja:");
		getContentPane().add(pocetniDatumLbl, "1, 4, right, default");
		
		UtilDateModel model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
	   datumObavljanja = new JDatePickerImpl(datePanel);
		final JDatePickerImpl datumKreiranjaDP = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	    datumObavljanja.setAlignmentY(MAXIMIZED_BOTH);
		getContentPane().add(datumObavljanja, "3, 4, fill, default");
		
		
		krajnjiDatumLbl = new JLabel("Broj sati:");
		getContentPane().add(krajnjiDatumLbl, "5, 4, right, default");
		
		pretraziRadniZadatakBtn = new JButton("Pretraga");
		ImageIcon traziIkona = new ImageIcon(getClass().getResource("SearchIcon.png"));
		pretraziRadniZadatakBtn.setIcon(traziIkona);
		pretraziRadniZadatakBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				 if(model.getRowCount()>0){   model.setRowCount(0);}
				
					if(nazivKlijenta.getText().equals("")  && (Date) datumObavljanja.getModel().getValue()==null && comboUsluga.getSelectedIndex()==0 && spinnSati.getValue()==null ){
						JOptionPane.showMessageDialog(rootPane, "Niste odabrali kljuc pretrage", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
					}
					else{
					
						if(lista.size()>0){
							
						    model.setRowCount(0);
						    lista.clear();
						}
						
	               
	                        
						
						
						lista=posao;
						if(nazivKlijenta.getText().equals("")){}
						else{
							
						lista= nadjiPoKlijentu(lista);
						}
						
						if((Date) datumObavljanja.getModel().getValue()!=null){ lista=nadjiPoDatumuObavljanja(lista);}
						if(comboUsluga.getSelectedIndex()>0){lista=nadjiPoUsluzi(lista);}
						if((Integer)spinnSati.getValue()>0){lista=nadjiPoSatima(lista);}
						
					
						if(lista.size()>0){
						
							for(int i=0; i<lista.size(); i++){
								    
								
									Object[] row = { lista.get(i).getDatumObavljanja()  ,(Integer)lista.get(i).getBrojSati() ,lista.get(i).getVrstaUsluge().getNaziv()};
									
									model.addRow(row);
		
									
								}}
						else{
							JOptionPane.showMessageDialog(rootPane, "Niti jedan obavljeni posao nije pronađen u bazi!", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
							
							
						}
									
							}
			}
		});
		
		spinnSati = new JSpinner();
		spinnSati.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		getContentPane().add(spinnSati, "7, 4");
		getContentPane().add(pretraziRadniZadatakBtn, "7, 6");
		
		
		
		panel = new JPanel();
		getContentPane().add(panel, "1, 26, 7, 1, fill, fill");
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		prikaziViseBtn = new JButton("Prika\u017Ei vi\u0161e");
		prikaziViseBtn.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		prikaziViseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int red = table.getSelectedRow();
				
				if(red == -1) { 
					JOptionPane.showMessageDialog(rootPane, "Niste ozna�ili red u tabeli.", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
				if(model.getRowCount()>0){
				if(red > model.getRowCount() ) {
					JOptionPane.showMessageDialog(rootPane, "Nije ozna�en ni jedan obavljeni posao.", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
				} 
				else {
					ObavljeniPosao izabrani=new ObavljeniPosao();
					if(lista.size()>0)izabrani=lista.get(red);
					else{izabrani=posao.get(red);}
					prikaziViseObavljenogPoslaGUI window = new prikaziViseObavljenogPoslaGUI(izabrani);
				}}
					
				
				

			}}
		});
		panel.add(prikaziViseBtn);
		
		btnPreuzmiRadniZadatak =new JButton("Modifikuj obavljeni posao");
		btnPreuzmiRadniZadatak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int red = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if(red == -1) { 
					JOptionPane.showMessageDialog(rootPane, "Niste ozna�ili red u tabeli.", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
				if(model.getRowCount()>0){
				if(red > model.getRowCount() ) {
					JOptionPane.showMessageDialog(rootPane, "Nije ozna�en ni jedan zadatak.", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
				} 
				else {
					ObavljeniPosao po= new ObavljeniPosao();
					if (lista.size()>0){po=lista.get(red);}
					else{po=posao.get(red);}
				  
					modifikacijaObavljenogPoslaGUI ex =  modifikacijaObavljenogPoslaGUI.dajInstancu(po);
				    ex.setVisible(true);
					
				     
					
				}}
				
				
			
		
				}
			
			}
		});
		panel.add(btnPreuzmiRadniZadatak);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mojRacunMenu = new JMenu("Moj ra\u010Dun");
		menuBar.add(mojRacunMenu);
		
		promijeniSifruItem = new JMenuItem("Promijeni \u0161ifru");
		promijeniSifruItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmPromjenaifre = new JFrame();
				promjenaSifreGUI window = new promjenaSifreGUI(frmPromjenaifre);
			}
		});
		mojRacunMenu.add(promijeniSifruItem);
		
		odjaviSeItem = new JMenuItem("Odjavi se");
		odjaviSeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		mojRacunMenu.add(odjaviSeItem);
		
		pomocMenu = new JMenu("Pomo\u0107");
		menuBar.add(pomocMenu);
		
		korisnikovoUputstvoItemo = new JMenuItem("Korisni\u010Dko upustvo");
		korisnikovoUputstvoItemo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Opcija �e ponuditi preuzimanje .pdf dokumenta sa korisni�km uputstvom", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		pomocMenu.add(korisnikovoUputstvoItemo);
		
		oNamaItem = new JMenuItem("O nama");
		oNamaItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oNamaGUI window = new oNamaGUI();
				window.setVisible(true);
				window.setSize(350,150);
				window.setLocationRelativeTo(null);
			}
		});
		pomocMenu.add(oNamaItem);

	
	
	
	
}
	@Override
 	public void dispose() {
 		// TODO Auto-generated method stub
 		unistiInstancu();
 		super.dispose();
 	}
}
