

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * FileChooserDemo.java uses these files:
 *   images/Open16.gif
 *   images/Save16.gif
 */
public class GUI extends JPanel implements ActionListener {
	
    static private final String newline = "\n";
    
    JLabel apikeyLabel, sizeLabel, tourneyNameLabel;
    JTextField apikey, tourneyName;
    JButton openButton, generateButton;
    JTextArea log;
    JFileChooser fc;

    XML tio;
    
    public GUI() {
        super(new BorderLayout());

        //Create the log first, because the action listeners
        //need to refer to it.
        log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        // labels
        apikeyLabel = new JLabel("API KEY: ");
        sizeLabel = new JLabel("Bracket Size: ??");
        tourneyNameLabel = new JLabel("Tournament Name: ");
        
        // textboxes
        apikey = new JTextField();
        tourneyName = new JTextField();
        
        //Create a file chooser
        fc = new JFileChooser();
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Tio Files", "tio", "xml");
        fc.setFileFilter(filter);

        //Create the open button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        openButton = new JButton("Choose TIO File");
        openButton.addActionListener(this);

        //Create the save button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        generateButton = new JButton("Generate Challonge Bracket");
        generateButton.addActionListener(this);

        //For layout purposes, put the inputs in a separate panel
        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));
        inputPanel.setAlignmentY(LEFT_ALIGNMENT);
        
        inputPanel.add(apikeyLabel);
        inputPanel.add(apikey);
        
        inputPanel.add(tourneyNameLabel);
        inputPanel.add(tourneyName);
        
        inputPanel.add(openButton);
        inputPanel.add(generateButton);

        //Add the buttons and the log to this panel.
        add(inputPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.SOUTH);
        
    }

    
    
    public void actionPerformed(ActionEvent e) {

        //Handle open button action.
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(GUI.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                log.append(Utility.timeStamp() + "Opening: " + file.getName() + "." + newline);
                tio = new XML(file, log);
                
            } else {
                log.append(Utility.timeStamp() + "Open command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());

        //Handle generate tournament button action.
        } else if (e.getSource() == generateButton) {
            
        	tio.generate();
        	
        }
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = GUI.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Tio-Challonge Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new GUI());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
    	
    	try {
    	    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
    	        if ("Nimbus".equals(info.getName())) {
    	            UIManager.setLookAndFeel(info.getClassName());
    	            break;
    	        }
    	    }
    	} catch (Exception e) {
    	    // If Nimbus is not available, you can set the GUI to another look and feel.
    	}
    	
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE); 
                createAndShowGUI();
            }
        });
    }
}