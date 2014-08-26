import java.text.Format;
import java.text.SimpleDateFormat;

import javax.swing.JTextArea;


public class Utility {

	static private final String newline = "\n";
	
	public static String timeStamp() {
    	Format formatter = new SimpleDateFormat("[hh:mm:ss] ");
    	return formatter.format(new java.util.Date());
    }
	
	public static void logMessage(JTextArea log, String message) {
	
		log.append(timeStamp() + message + newline);
		log.setCaretPosition(log.getDocument().getLength());
		
	}
	
}
