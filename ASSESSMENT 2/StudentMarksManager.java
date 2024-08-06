
import java.io.BufferedReader; // Import BufferedReader for reading text from files
import java.io.FileReader; // Import FileReader for file reading operations
import java.io.IOException; // Import IOException for handling file reading errors
import java.util.List; //Import List for handling Lists
import java.util.ArrayList; //Import Arraylist for dynamic array functionality possibility

public class StudentMarksManager{
    private List<Student> students; // Initialize list that stores all student objects
    
    public StudentMarksManager(){
        students = new ArrayList<>(); //Initialize the students list
    }
    
    //Method to read student data from a file
    //Method takes filename as argument and passes it to get the file.
    public void LoadFile(String fileName){
        try{
            
        }
        catch(IOException e){
            //Catch block to handle any errors that occurs with file importing.
            System.out.println("Error reading the file: " + e.getMessage()); // Print the error into message.
        }
    }
    }

