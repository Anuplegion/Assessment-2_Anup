
/**
 * Write a description of class MainMenu here.
 *
 * @author Anup Adhikari
 */
import java.util.Scanner;

public class Main
{
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for reading input
        StudentMarksManager studentMarksManager = new StudentMarksManager(); // Create an instance of StudentMarksManager
        
        while(true){ //infinite loop for the menu until user hits exit
            //Display menu options
            System.out.println("Menu");
            System.out.println("Press 1 to Read from file");
            System.out.println("Press 2 to Calculate total marks");
            System.out.println("Press 3 to Print top and bottom students");
            System.out.println("Press 4 to Print students below threshold");
            System.out.println("Press 5to Exit");
            System.out.println("Enter your choice (1-5): ");
            int choice = scanner.nextInt(); //gives user enter option and takes nuber into choice.
            
            
        }
    }
}
