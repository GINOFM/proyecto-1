package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student estudiante = new Student(91913, "Massoni", "Gino Facundo", "ginofacundom@gmail.com", 
            			"https://github.com/GINOFM/proyecto-1", "");
            	SimplePresentationScreen gui = new SimplePresentationScreen(estudiante);
            	gui.setVisible(true);
            }
        });
    }
}