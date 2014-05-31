package UtilClasses;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;




public class KorisnickoUputstvo implements java.io.Serializable{
	
	
	public void dobaviUputstvo() {
		String fileAddress="src\\main\\resources\\UputstvoRacunovodstvo.pdf";
        try {
            if ((new File(fileAddress)).exists()) {
                Process process = Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+fileAddress);
                process.waitFor();
            } else {
                System.out.println("Dokument nije pronađen");
            }
            System.out.println("Done");
        } catch (Exception e) {
            System.out.println(":: -----Exception---- ::\n"+e);
        }
	}
	
	public void dobaviUputstvoServiseri() {
		String fileAddress="src\\main\\resources\\UputstvoServiseri.pdf";
        try {
            if ((new File(fileAddress)).exists()) {
                Process process = Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+fileAddress);
                process.waitFor();
            } else {
                System.out.println("Dokument nije pronađen");
            }
            System.out.println("Done");
        } catch (Exception e) {
            System.out.println(":: -----Exception---- ::\n"+e);
        }
	}
	
}
