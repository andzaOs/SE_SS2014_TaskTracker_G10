package Kontroleri.ControlersServiseri;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import DAO.KorisnikDAO;
import DAO.RadniZadatakDAO;
import DAO.RasporedjeniZadatakDAO;
import Entity.Korisnik;
import Entity.RadniZadatak;
import Entity.RasporedjeniZadatak;

public class RadniZadaciControler {
	public RadniZadaciControler() {
	}

	private List<RadniZadatak> zadaci;
	private List<RadniZadatak> lista;
	private List<RasporedjeniZadatak> rasporedjeniZadaci;

	public List<RadniZadatak> getZadaci() {
		return zadaci;
	}

	public void setZadaci(List<RadniZadatak> zadaci) {
		this.zadaci = zadaci;
	}

	public List<RadniZadatak> getLista() {
		return lista;
	}

	public void setLista(List<RadniZadatak> lista) {
		this.lista = lista;
	}

	public List<RasporedjeniZadatak> getRasporedjeniZadaci() {
		return rasporedjeniZadaci;
	}

	public void setRasporedjeniZadaci(
			List<RasporedjeniZadatak> rasporedjeniZadaci) {
		this.rasporedjeniZadaci = rasporedjeniZadaci;
	}

	public List<RadniZadatak> nadjiPoKlijentu(List<RadniZadatak> zad,
			String nazivKlijenta) {
		List<RadniZadatak> zadaciPretraga = new ArrayList<RadniZadatak>();
		for (int i = 0; i < zad.size(); i++) {
			if (zad.get(i).getKlijent().getNaziv().equals(nazivKlijenta)) {
				zadaciPretraga.add(zad.get(i));
			}
		}
		return zadaciPretraga;
	}

	public List<RadniZadatak> nadjiPoDatumuIzvrsenja(List<RadniZadatak> zad,
			Date d) {
		List<RadniZadatak> zadaciPretraga = new ArrayList<RadniZadatak>();
		Date datum = new Date();
		Calendar cal = Calendar.getInstance();
		Calendar cal1 = Calendar.getInstance();

		for (int i = 0; i < zad.size(); i++) {
			if (zad.get(i).getKrajnjiDatumIzvrsenja() != null) {

				datum = zad.get(i).getKrajnjiDatumIzvrsenja();
				cal.setTime(datum);
				cal1.setTime(d);
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH);
				int day = cal.get(Calendar.DAY_OF_MONTH);
				int year1 = cal1.get(Calendar.YEAR);
				int month1 = cal1.get(Calendar.MONTH);
				int day1 = cal1.get(Calendar.DAY_OF_MONTH);

				if (year == year1 && month == month1 && day == day1) {

					zadaciPretraga.add(zad.get(i));
				}
			}
		}
		return zadaciPretraga;
	}

	public List<RadniZadatak> nadjiPoDatumuUnosa(List<RadniZadatak> zad, Date d) {
		List<RadniZadatak> zadaciPretraga = new ArrayList<RadniZadatak>();
		Date datum = new Date();
		Calendar cal = Calendar.getInstance();
		Calendar cal1 = Calendar.getInstance();

		for (int i = 0; i < zad.size(); i++) {
			if (zad.get(i).getDatumUnosa() != null) {

				datum = zad.get(i).getDatumUnosa();
				cal.setTime(datum);
				cal1.setTime(d);
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH);
				int day = cal.get(Calendar.DAY_OF_MONTH);
				int year1 = cal1.get(Calendar.YEAR);
				int month1 = cal1.get(Calendar.MONTH);
				int day1 = cal1.get(Calendar.DAY_OF_MONTH);

				if (year == year1 && month == month1 && day == day1) {

					zadaciPretraga.add(zad.get(i));
				}
			}
		}
		return zadaciPretraga;
	}

	public List<RadniZadatak> nadjiPoVrstiZadatka(List<RadniZadatak> zad,
			String vrstaZadatkacombo) {
		List<RadniZadatak> zadaciPretraga = new ArrayList<RadniZadatak>();
		for (int i = 0; i < zad.size(); i++) {
			if (zad.get(i).getVrstaZadatka().equals(vrstaZadatkacombo)) {
				zadaciPretraga.add(zad.get(i));
			}
		}
		return zadaciPretraga;
	}

	public void pronadji(Long IdRadnika) throws Exception {
		try {
			zadaci = new ArrayList<RadniZadatak>();
			lista = new ArrayList<RadniZadatak>();
			RadniZadatakDAO zDAO = new RadniZadatakDAO();
			zadaci = zDAO.getAll();
			for (int i = 0; i < zadaci.size(); i++) {
				if (zadaci.get(i).getVidljivo() == false || zadaci.get(i).getPotpunoDodjeljen()==true || zadaci.get(i).getStatusIzvrsenosti()==true) {
					zadaci.remove(i);
				}
			}

			RasporedjeniZadatakDAO rDAO = new RasporedjeniZadatakDAO();
			rasporedjeniZadaci = rDAO.getAll();
			for (int i = 0; i < rasporedjeniZadaci.size(); i++) {
				if (rasporedjeniZadaci.get(i).getIzvrsilac().getKorisnik_id() == IdRadnika) {
					for (int j = 0; j < zadaci.size(); j++) {
						if (zadaci.get(j).getRadniZadatak_id() == rasporedjeniZadaci
								.get(i).getZadatak().getRadniZadatak_id()) {
							zadaci.remove(j);
						}
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public void ispisi(DefaultTableModel model, List<RadniZadatak> zad)
			throws Exception {
		try {
			if (zad.size() > 0) {

				for (int i = 0; i < zad.size(); i++) {

					String status = new String();
					if (zad.get(i).getStatusIzvrsenosti() == false) {
						status = "neizvrsen";
					} else {
						status = "izvrsen";
					}
					Object[] row = { zad.get(i).getVrstaZadatka(),
							zad.get(i).getKlijent().getNaziv(),
							zad.get(i).getOpis(), status };
					model.addRow(row);
				}
			}

		} catch (Exception e) {
			throw e;
		}
	}

	public String pretraga(JTextField nazivKlijenta,
			JDatePickerImpl datumIzvrsenja, JDatePickerImpl datumKreiranja,
			JComboBox vrstaZadatkacombo, DefaultTableModel model,
			List<RadniZadatak> zad, List<RasporedjeniZadatak> Zadaci,
			List<RadniZadatak> li) {
		lista = li;
		if (nazivKlijenta.getText().equals("")
				&& (Date) datumIzvrsenja.getModel().getValue() == null
				&& (Date) datumKreiranja.getModel().getValue() == null
				&& vrstaZadatkacombo.getSelectedIndex() == 0) {
			return "Niste odabrali kljuc pretrage";
		} else {

			if (model.getRowCount() > 0) {
				model.setRowCount(0);
			}
			if (lista.size() > 0) {

				model.setRowCount(0);
			}

			lista = zad;
			if (nazivKlijenta.getText().equals("")) {
			} else {

				lista = nadjiPoKlijentu(lista, nazivKlijenta.getText());
			}

			if ((Date) datumIzvrsenja.getModel().getValue() != null) {
				lista = nadjiPoDatumuIzvrsenja(lista, (Date) datumIzvrsenja
						.getModel().getValue());
			}
			if ((Date) datumKreiranja.getModel().getValue() != null) {
				lista = nadjiPoDatumuUnosa(lista, (Date) datumKreiranja
						.getModel().getValue());
			}
			if (vrstaZadatkacombo.getSelectedIndex() > 0) {
				lista = nadjiPoVrstiZadatka(lista,
						(String) vrstaZadatkacombo.getSelectedItem());
			}

			if (lista.size() > 0) {

				try {
					ispisi(model, lista);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				return "Niti jedan zadatak nije pronađen u bazi!";

			}
			nazivKlijenta.setText("");
			datumIzvrsenja.getModel().setValue(null);
			datumIzvrsenja.getJFormattedTextField().setText("");
			datumKreiranja.getModel().setValue(null);
			datumKreiranja.getJFormattedTextField().setText("");
			vrstaZadatkacombo.setSelectedIndex(0);

			return "";

		}

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

	public void updateZadatka(Long id) {
		RadniZadatakDAO zDAO = new RadniZadatakDAO();
		RadniZadatak izabrani = zDAO.getById(id);
		int br = izabrani.getStatusDodjeljenosti();
		izabrani.setStatusDodjeljenosti(br + 1);
		if (izabrani.getBrojServisera() == izabrani.getStatusDodjeljenosti()) {
			izabrani.setPotpunoDodjeljen(true);
		}
		RadniZadatakDAO kDAO = new RadniZadatakDAO();
		kDAO.update(izabrani);
	}

	public void createRasporedjenog(Long id, Long IdRadnika) {
		RasporedjeniZadatak pom = new RasporedjeniZadatak();
		RadniZadatakDAO zDAO = new RadniZadatakDAO();
		RadniZadatak izabrani = zDAO.getById(id);
		pom.setStatusPrihvacenosti(true);
		pom.setZadatak(izabrani);
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		pom.setDatumPrihvatanja(sqlDate);
		KorisnikDAO kor = new KorisnikDAO();
		Korisnik radnik = kor.getById(IdRadnika);
		pom.setIzvrsilac(radnik);
		RasporedjeniZadatakDAO rDAO = new RasporedjeniZadatakDAO();
		pom.setVidljivo(true);
		rDAO.create(pom);

	}

	public String preuzmiRadniZadatak(int red, List<RadniZadatak> zad,
			List<RadniZadatak> li, Long IdRadnika) {
		if (red == -1) {
			return "Niste odabrali niti  jedan red tabele!";
		} else {

			Long id;
			RadniZadatak izabrani = new RadniZadatak();
			if (li.size() > 0) {
				id = li.get(red).getRadniZadatak_id();
				izabrani = li.get(red);
			} else {
				id = zad.get(red).getRadniZadatak_id();
				izabrani = zad.get(red);
			}

			if (izabrani.getPotpunoDodjeljen() == false) {
				updateZadatka(id);

				createRasporedjenog(id, IdRadnika);

				return "Uspješno ste preuzeli zadatak";

			} else {
				return "Na zadatku radi vec maksimalan broj servisera";
			}

		}
	}
}
