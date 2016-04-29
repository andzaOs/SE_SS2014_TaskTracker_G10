package UtilClasses;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;




public class KorisnickoUputstvo implements java.io.Serializable{
	
	
	public void dobaviUputstvo() {
		String fileAddress="src" + File.separator + "main" + File.separator + "resources" + File.separator + "UputstvoRacunovodstvo.pdf";
        try {
            if ((new File(fileAddress)).exists()) {
        	
    	        if (Desktop.isDesktopSupported()) { 
  	              try { 
  	                  File myFile = new File(fileAddress); 
  	                  Desktop.getDesktop().open(myFile); 
  	              } catch (IOException ex) { 
  	                  // no application registered for PDFs 
  	              } 
    	        }
       	
            } else {
                System.out.println("Dokument nije pronađen");
            }
            System.out.println("Done");
        } catch (Exception e) {
            System.out.println(":: -----Exception---- ::\n"+e);
        }
	}
	
	public void dobaviUputstvoServiseri() {
		String fileAddress="src" + File.separator + "main" + File.separator + "resources" + File.separator + "UputstvoServiseri.pdf";
        try {
            if ((new File(fileAddress)).exists()) {

    	        if (Desktop.isDesktopSupported()) { 
    	              try { 
    	                  File myFile = new File(fileAddress); 
    	                  Desktop.getDesktop().open(myFile); 
    	              } catch (IOException ex) { 
    	                  // no application registered for PDFs 
    	              } 
      	        }
            	
            	
            } else {
                System.out.println("Dokument nije pronađen");
            }
            System.out.println("Done");
        } catch (Exception e) {
            System.out.println(":: -----Exception---- ::\n"+e);
        }
	}
	
}
