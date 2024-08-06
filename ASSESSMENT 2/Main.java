
/**
 * Write a description of class Main here.
 *
 * @author Anup Adhikari
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main
{
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for reading input
        StudentMarksManager studentMarksManager = new StudentMarksManager(); // Create an instance of StudentMarksManager
        
        while(true){ //infinite loop for the menu until user hits exit
            //Display menu optionss
            System.out.println("Welcome to Student Manager Program Menu");
            System.out.println("\t (1) Read from file");
            System.out.println("\t (2) Calculate total marks");
            System.out.println("\t (3) Print top and bottom students");
            System.out.println("\t (4) Print students below threshold");
            System.out.println("\t (5) Exit");
            System.out.println("Enter your choice (1-5): ");
            int choice = 0; //initlize choice as 0 before getting input
            
            
            //Input validation to give error if user inputs strings instead of 1-5
            boolean validInput = false; // Initialize Flag to check if input is valid
            
            while (!validInput) { // Loop until valid input is provided
                try {
                    choice = scanner.nextInt(); // Read the choice
                    validInput = true; // Set flag to true if input is valid and proceed
                } catch (InputMismatchException e) { // Catch exception if input is not an integer
                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
                    scanner.next(); // Clear the invalid input
                }
            }
            
            //Process choice from the user
            switch(choice){
                case 1: //Option to read file
                scanner.nextLine(); 
                //If the file is somewhere else, give full directory path, else only give file name if its in the same folder as code.
                System.out.print("Enter the complete path of your file or only name if on same folder: ");
                String fileName = scanner.nextLine(); //Read the file name entered above and store in fileName
                //Call loadfile method with fileName passed as argument.
                studentMarksManager.LoadFile(fileName);
                break;
                case 2: //Option to calculate total marks
                studentMarksManager.calculateTotalMarks();
                break;
                case 3: //Option to print top and bottom students
                studentMarksManager.topandbottomStudentMarks(); //call topand bottom method
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
