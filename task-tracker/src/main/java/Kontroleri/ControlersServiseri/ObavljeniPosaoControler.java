package Kontroleri.ControlersServiseri;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import DAO.ObavljeniPosaoDAO;
import Entity.ObavljeniPosao;
import Entity.RadniZadatak;

public class ObavljeniPosaoControler {
	public ObavljeniPosaoControler() {
	}

	private static List<ObavljeniPosao> posao;
	private static List<ObavljeniPosao> lista;

	public static List<ObavljeniPosao> getPosao() {
		return posao;
	}

	public static void setPosao(List<ObavljeniPosao> posao) {
		ObavljeniPosaoControler.posao = posao;
	}

	public static List<ObavljeniPosao> getLista() {
		return lista;
	}

	public static void setLista(List<ObavljeniPosao> lista) {
		ObavljeniPosaoControler.lista = lista;
	}

	public List<ObavljeniPosao> nadjiPoKlijentu(List<ObavljeniPosao> poslovi,
			JTextField nazivKlijenta) {
		List<ObavljeniPosao> posaoPretraga = new ArrayList<ObavljeniPosao>();
		for (int i = 0; i < poslovi.size(); i++) {
			if (poslovi.get(i).getPripadajuciZadatak().getZadatak()
					.getKlijent().getNaziv().equals(nazivKlijenta.getText())) {
				posaoPretraga.add(poslovi.get(i));
			}
		}

		return posaoPretraga;
	}

	private List<ObavljeniPosao> nadjiPoUsluzi(List<ObavljeniPosao> poslovi,
			JComboBox comboUsluga) {
		List<ObavljeniPosao> posaoPretraga = new ArrayList<ObavljeniPosao>();
		if(comboUsluga.getSelectedIndex()!=0){
		for (int i = 0; i < poslovi.size(); i++) {
	
			if (poslovi.get(i).getVrstaUsluge().getNaziv()
					.equals(comboUsluga.getSelectedItem().toString())) {
				posaoPretraga.add(poslovi.get(i));
			}
		}}
		return posaoPretraga;
	}

	private List<ObavljeniPosao> nadjiPoSatima(List<ObavljeniPosao> poslovi,
			JSpinner spinnSati) {
		List<ObavljeniPosao> posaoPretraga = new ArrayList<ObavljeniPosao>();
		for (int i = 0; i < poslovi.size(); i++) {
			if (poslovi.get(i).getBrojSati() == (Integer) spinnSati.getValue()) {
				posaoPretraga.add(poslovi.get(i));
			}
		}
		return posaoPretraga;
	}

	private List<ObavljeniPosao> nadjiPoDatumuObavljanja(
			List<ObavljeniPosao> poslovi, JDatePickerImpl datumObavljanja) {
		List<ObavljeniPosao> posloviPretraga = new ArrayList<ObavljeniPosao>();
		Date datum = new Date();
		Calendar cal = Calendar.getInstance();
		Calendar cal1 = Calendar.getInstance();

		for (int i = 0; i < poslovi.size(); i++) {

			if (poslovi.get(i).getDatumObavljanja() != null) {

				datum = poslovi.get(i).getDatumObavljanja();
				Date d = (Date) datumObavljanja.getModel().getValue();
				cal.setTime(datum);
				cal1.setTime(d);
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH);
				int day = cal.get(Calendar.DAY_OF_MONTH);
				int year1 = cal1.get(Calendar.YEAR);
				int month1 = cal1.get(Calendar.MONTH);
				int day1 = cal1.get(Calendar.DAY_OF_MONTH);

				if (year == year1 && month == month1 && day == day1) {

					posloviPretraga.add(poslovi.get(i));
				}
			}
		}
		return posloviPretraga;
	}

	public void pronadji(Long IdRadnika) throws Exception {
		
		try {
			lista=new ArrayList<ObavljeniPosao>();
			posao=new ArrayList<ObavljeniPosao>();
		

			ObavljeniPosaoDAO zDAO = new ObavljeniPosaoDAO();
			List<ObavljeniPosao> sviposlovi = new ArrayList<ObavljeniPosao>();

			sviposlovi = zDAO.getAll();
			if (sviposlovi.size() > 0) {
				for (int i = 0; i < sviposlovi.size(); i++) {
					Long br = sviposlovi.get(i).getPripadajuciZadatak()
							.getIzvrsilac().getKorisnik_id();
					if (br.equals(IdRadnika)) {

						if (sviposlovi.get(i).getPripadajuciZadatak()
								.getZadatak().getVidljivo() == true
								&& sviposlovi.get(i).getPripadajuciZadatak()
										.getZadatak().getStatusIzvrsenosti() == false) {
							posao.add(sviposlovi.get(i));
						}

					}
				}
			}
		} catch (Exception e) {
			throw e;
		}

	}

	public void Ispisi(List<ObavljeniPosao> po, DefaultTableModel model) {
		if (po.size() > 0) {

			for (int i = 0; i < po.size(); i++) {

				Object[] row = { po.get(i).getDatumObavljanja(),
						(Integer) po.get(i).getBrojSati(),
						po.get(i).getVrstaUsluge().getNaziv() };

				model.addRow(row);

			}
		}

	}

	public String pretraga(JTextField nazivKlijenta,
			JDatePickerImpl datumObavljanja, JComboBox comboUsluga,
			JSpinner spinnSati, DefaultTableModel model,
			List<ObavljeniPosao> li, List<ObavljeniPosao> po) {
		if (model.getRowCount() > 0) {
			model.setRowCount(0);
		}
		lista = li;
		if ((Date) datumObavljanja.getModel().getValue() != null){
			Date trenutni =new Date();
			Date d=(Date) datumObavljanja.getModel().getValue();
			if(d.after(trenutni)){return "Ne možete pretraživati posao obavljen u budućnosti, pogrešan datum obavljanja!"; }
		}

		if (nazivKlijenta.getText().equals("")
				&& (Date) datumObavljanja.getModel().getValue() == null
				&& comboUsluga.getSelectedIndex() == 0
				&& spinnSati.getValue() == null) {
			return "Niste odabrali kljuc pretrage";
		} else {

			if (lista.size() > 0) {

				model.setRowCount(0);
				lista.clear();
			}

			lista = po;
			if (nazivKlijenta.getText().equals("")) {
			} else {

				lista = nadjiPoKlijentu(lista, nazivKlijenta);
			}

			if ((Date) datumObavljanja.getModel().getValue() != null) {
				lista = nadjiPoDatumuObavljanja(lista, datumObavljanja);
			}
			if (comboUsluga.getSelectedIndex() > 0) {
				lista = nadjiPoUsluzi(lista, comboUsluga);
			}
			if ((Integer) spinnSati.getValue() > 0) {
				lista = nadjiPoSatima(lista, spinnSati);
			}

			if (lista.size() > 0) {
				Ispisi(lista, model);
			} else {
				return "Niti jedan obavljeni posao nije pronađen u bazi!";

			}

		}

		nazivKlijenta.setText("");
		datumObavljanja.getModel().setValue(null);
		datumObavljanja.getJFormattedTextField().setText("");
		comboUsluga.setSelectedIndex(0);
		return "";

	}

	public String prikaziVise(int red, DefaultTableModel model) {
		if (red == -1) {
			return "Niste ozna�ili red u tabeli.";
		} else {
			if (model.getRowCount() > 0) {
				if (red > model.getRowCount()) {
					return "Nije ozna�en ni jedan zadatak.";
				} else {
					return "";
				}

			}
		}
		return "";
	}

}
