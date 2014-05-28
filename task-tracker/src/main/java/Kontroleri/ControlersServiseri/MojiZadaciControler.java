package Kontroleri.ControlersServiseri;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import DAO.RadniZadatakDAO;
import DAO.RasporedjeniZadatakDAO;
import Entity.RadniZadatak;
import Entity.RasporedjeniZadatak;

public class MojiZadaciControler {
	private List<RadniZadatak> zadaci;
	private List<RadniZadatak> lista;
	private List<RasporedjeniZadatak> rasporedjeniZadaci;

	public MojiZadaciControler() {
	}

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
			JComboBox vrstaZadatkacombo, JCheckBox chckbxNepreuzeti,
			JCheckBox chckbxPreuzeti, DefaultTableModel model,
			List<RadniZadatak> zad, List<RasporedjeniZadatak> Zadaci,
			List<RadniZadatak> li) {
		lista = li;
		if (model.getRowCount() > 0) {
			model.setRowCount(0);
		}

		if (nazivKlijenta.getText().equals("")
				&& (Date) datumIzvrsenja.getModel().getValue() == null
				&& (Date) datumKreiranja.getModel().getValue() == null
				&& vrstaZadatkacombo.getSelectedIndex() == 0
				&& chckbxNepreuzeti.isSelected() == false
				&& chckbxPreuzeti.isSelected() == false) {
			return "Niste odabrali kljuc pretrage";
		} else {

			if (lista.size() > 0) {

				model.setRowCount(0);
				lista.clear();
			}

			if (chckbxNepreuzeti.isSelected() == true) {

				lista = nadjiNeprihvacene(Zadaci);

			}

			if (chckbxPreuzeti.isSelected() == true) {

				lista = nadjiPrihvacene(Zadaci);
			}
			if (chckbxNepreuzeti.isSelected() == false
					&& chckbxPreuzeti.isSelected() == false) {
				lista = zad;
			}

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
			chckbxNepreuzeti.setSelected(false);
			chckbxPreuzeti.setSelected(false);

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

	public String provjeraZaPrihvatiZadatak(int red, RadniZadatak izabrani,
			List<RasporedjeniZadatak> Zadaci, DefaultTableModel model,
			JCheckBox chckbxNepreuzeti) {
		if (izabrani.getPotpunoDodjeljen() == true) {
			return "Ne možete preuzeti ovaj zadatak, na njemu radi već maksimalan broj servisera";
		} else {

			if (Zadaci.size() > 0) {

				if (PreuzmiZadatak(izabrani, Zadaci) == true) {
					if (chckbxNepreuzeti.isSelected() == true) {

						model.removeRow(red);

					}
					return "Uspješno ste prihvatili zadatak";

				} else {
					return "Vec radite na ovome zadatku!";

				}

			}

		}
		return "";
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

	public List<RadniZadatak> nadjiNeprihvacene(List<RasporedjeniZadatak> zad) {
		List<RadniZadatak> zadaciPretraga = new ArrayList<RadniZadatak>();

		for (int i = 0; i < zad.size(); i++) {
			if (zad.get(i).getStatusPrihvacenosti() == false) {

				zadaciPretraga.add(zad.get(i).getZadatak());
			}
		}
		return zadaciPretraga;
	}

	public List<RadniZadatak> nadjiPrihvacene(List<RasporedjeniZadatak> zad) {
		List<RadniZadatak> zadaciPretraga = new ArrayList<RadniZadatak>();

		for (int i = 0; i < zad.size(); i++) {
			if (zad.get(i).getStatusPrihvacenosti() == true) {

				zadaciPretraga.add(zad.get(i).getZadatak());
			}
		}
		return zadaciPretraga;
	}

	public void izvrsiUpdatePreuzimanja(Long id, Long id2) throws Exception {
		try {
			RadniZadatakDAO zDAO = new RadniZadatakDAO();
			RadniZadatak pomocni = zDAO.getById(id);
			int broj = pomocni.getStatusDodjeljenosti();
			pomocni.setStatusDodjeljenosti(broj + 1);
			if (pomocni.getBrojServisera() == pomocni.getStatusDodjeljenosti()) {
				pomocni.setPotpunoDodjeljen(true);
			}
			RadniZadatakDAO tDAO = new RadniZadatakDAO();
			tDAO.update(pomocni);
			RasporedjeniZadatakDAO pDAO = new RasporedjeniZadatakDAO();
			RasporedjeniZadatak rasporedjeni = pDAO.getById(id2);
			rasporedjeni.setStatusPrihvacenosti(true);

			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			rasporedjeni.setDatumPrihvatanja(sqlDate);
			RasporedjeniZadatakDAO rDAO = new RasporedjeniZadatakDAO();
			rDAO.update(rasporedjeni);

		} catch (Exception e) {
			throw e;
		}

	}

	public Boolean PreuzmiZadatak(RadniZadatak izabrani,
			List<RasporedjeniZadatak> li) {

		RasporedjeniZadatakDAO pDAO = new RasporedjeniZadatakDAO();
		Boolean Odradjeno = false;

		for (int i = 0; i < li.size(); i++) {
			Long br = li.get(i).getZadatak().getRadniZadatak_id();

			if (br.equals(izabrani.getRadniZadatak_id())) {

				try {
					izvrsiUpdatePreuzimanja(izabrani.getRadniZadatak_id(), li
							.get(i).getRasporedjeniZadatak_id());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Odradjeno = true;
				break;
			}

		}

		return Odradjeno;
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

	public void pronadji(Long IdRadnika) throws Exception {
		try {
			zadaci = new ArrayList<RadniZadatak>();
			lista = new ArrayList<RadniZadatak>();
			rasporedjeniZadaci = new ArrayList<RasporedjeniZadatak>();
			RasporedjeniZadatakDAO zDAO = new RasporedjeniZadatakDAO();
			List<RasporedjeniZadatak> svirasporedjeniZadaci = new ArrayList<RasporedjeniZadatak>();
			svirasporedjeniZadaci = zDAO.getAll();
			if (svirasporedjeniZadaci.size() > 0) {
				for (int i = 0; i < svirasporedjeniZadaci.size(); i++) {
					Long br = svirasporedjeniZadaci.get(i).getIzvrsilac()
							.getKorisnik_id();
					if (br.equals(IdRadnika)) {

						if (svirasporedjeniZadaci.get(i).getZadatak()
								.getVidljivo() == true
								&& svirasporedjeniZadaci.get(i).getZadatak()
										.getStatusIzvrsenosti() == false) {
							rasporedjeniZadaci
									.add(svirasporedjeniZadaci.get(i));
							zadaci.add(svirasporedjeniZadaci.get(i)
									.getZadatak());
						}

					}
				}

			}
		} catch (Exception e) {
			throw e;
		}

	}

	public void izvrsiUpdateIzvrsenog(Long id) throws Exception {
		try {
			RadniZadatakDAO tDAO = new RadniZadatakDAO();
			RadniZadatak z = tDAO.getById(id);
			RadniZadatakDAO kDAO = new RadniZadatakDAO();
			z.setStatusIzvrsenosti(true);
			kDAO.update(z);
		} catch (Exception e) {
			throw e;
		}

	}

	public String oznaciKaoizvrsen(int red, List<RadniZadatak> radna,
			List<RasporedjeniZadatak> li) {

		for (int i = 0; i < li.size(); i++) {

			if (li.get(i).getZadatak().getRadniZadatak_id() == radna.get(red)
					.getRadniZadatak_id()
					&& li.get(i).getZadatak().getStatusIzvrsenosti() == false) {
				if(li.get(i).getStatusPrihvacenosti()==true) {
			

				Long id = li.get(i).getZadatak().getRadniZadatak_id();
				try {
					izvrsiUpdateIzvrsenog(id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "";

			}
				else {return "Niste prihvatili zadatak!";}	

		}}
		return "";
	}
}
