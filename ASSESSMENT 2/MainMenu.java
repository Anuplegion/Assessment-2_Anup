
/**
 * Write a description of class MainMenu here.
 *
 * @author Anup Adhikari
 */
import java.util.Scanner;
public class MainMenu
{
   public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
        StudentFile studentFile = new StudentFile();
        
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();
        studentFile.readFromFile(filePath);
    }
}
