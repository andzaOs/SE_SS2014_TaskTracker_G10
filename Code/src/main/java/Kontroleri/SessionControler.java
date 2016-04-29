package Kontroleri;

import javax.swing.JFrame;

import RacunovodstvoGUI.PocetnaRacunovodstvoGUI;

public class SessionControler {
	private static long idLog;
	private static SessionControler instanca;
	public SessionControler(long id) {
		idLog=id;
	}
	public static SessionControler dajInstancu(long id) {
		if(instanca==null) {
			instanca=new SessionControler(id);
		}
		return instanca;
	}
	public static void unistiInstancu() { instanca= null; }
	public static long getIdLog() {
		return idLog;
	}
}
