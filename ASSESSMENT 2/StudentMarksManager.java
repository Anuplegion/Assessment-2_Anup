
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
            //Open and read the data from file
            FileReader fileReader = new FileReader(fileName); // Create FileReader for the specified file
            BufferedReader bufferedReader = new BufferedReader(fileReader); // Wrap FileReader in BufferedReader

            // Read the first two lines of the file
            String unitName = bufferedReader.readLine(); // Read the unit name
            bufferedReader.readLine(); // Read and ignore the header line

            // Print the Unit Name (after removing "Unit Name: ")
            System.out.println("Unit Name: " + unitName.substring(6)); 
            
             // Process each line of the file
            String line;
            while ((line = bufferedReader.readLine()) != null) { // Read until end of file
                if (line.trim().startsWith("#")) { // Skip lines that start with '#'
                    continue; // Skip to the next line so it skips 2 lines in total
                }

                String[] data = line.split(","); // Split the line into an array by comma
                if (data.length >= 6) { // Ensure the array has the correct number of elements
                    String lastName = data[0].trim(); // Extract last name and trim any extra spaces
                    String firstName = data[1].trim(); // Extract first name and trim any extra spaces
                    String studentID = data[2].trim(); // Extract student ID and trim any extra spaces
                    
                    //Parse marks from strings, set default value 0.0 if there is no marks or parsing fails
                    double mark1 = parseDoubleWithDefault(data[3].trim(), 0.0);
                    double mark2 = parseDoubleWithDefault(data[4].trim(), 0.0);
                    double mark3 = parseDoubleWithDefault(data[5].trim(), 0.0);
                     // Create a new student object and add it to the list
                    Student student = new Student(lastName, firstName, studentID, mark1, mark2, mark3);
                    students.add(student);
        }
    }
}
        catch(IOException e){
            //Catch block to handle any errors that occurs with file importing.
            System.out.println("Error reading the file: " + e.getMessage()); // Print the error into message.
        }
    }
    
    //creating parseDoublewithDefault method to make sure empty spaces are handled with 0.0 value.
    private double parseDoubleWithDefault(String str, double defaultValue) {
        try {
            return Double.parseDouble(str); // Attempt to parse the string as a double
        } catch (NumberFormatException e) { // Handle NumberFormatException if parsing fails
            return defaultValue; // Return the default value if parsing fails
        }
    }

    //Method to calculate and print total marks for each student
    
    }


