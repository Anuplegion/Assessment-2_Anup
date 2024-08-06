
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
            
            switch(choice){
                case 1: //Option to read file
                scanner.nextLine(); 
                //If the file is somewhere else, give full directory path, else only give file name if its in the same folder as code.
                System.out.print("Enter the complete path of your file or only name if on same folder: ");
                String fileName = scanner.nextLine(); //Read the file name entered above and store in fileName
                //Call loadfile method with fileName passed as argument.
                studentMarksManager.LoadFile(fileName);
                case 2: //Option to calculate total marks
                studentMarksManager.calculateTotalMarks();
                break;
                case 3: //Option to print top and bottom students
                
                break;
                case 4: //Option to print students below a certain threshold
                    System.out.print("enter the threshold: "); //user enters threshold
                    double threshold = scanner.nextDouble(); // Read the threshold
                    //cAll studentMarksThreshold method with input value as passed argument
                    studentMarksManager.studentsMarksThreshold(threshold);
                    break;
                case 5: //Option to exit program
                    System.out.println("Thank you for using the program.");
                    System.exit(0);
                    
                default: //Handle invalid choices
                    System.out.println("Invalid choice, please select from 1-5");
            }
            
        }
    }
}
