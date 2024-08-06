
import java.io.BufferedReader; // Import BufferedReader for reading text from files
import java.io.FileReader; // Import FileReader for file reading operations
import java.io.IOException; // Import IOException for handling file reading errors
import java.util.List; //Import List for handling Lists
import java.util.ArrayList; //Import Arraylist for dynamic array functionality possibility

public class StudentMarksManager {
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

            // Let user know file is read
            System.out.println("File is read successfully");
            
            // Read the first two lines of the file
            String unitName = bufferedReader.readLine(); // Read the unit name
            bufferedReader.readLine(); // Read and ignore the header line
            
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
     bufferedReader.close(); // Close the BufferedReader
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
    public void calculateTotalMarks(){
        System.out.println("Calculating total marks of students."); //To show program is running
        for (Student student : students) { // Iterate over each student in the list
            System.out.println("Student Name: " + student.getName());
            System.out.println("Student ID: " + student.studentID);
            System.out.println("\t Mark 1: " + student.getMark1()); // print mark 1 
            System.out.println("\t Mark 2: " + student.getMark2()); // print amrk 2
            System.out.println("\t Mark 3: " + student.getMark3()); // print mark 3
            System.out.println("Total Mark: " + student.getTotalMark()); // Print total marks for the student
            System.out.println();
            System.out.println("--------------------------------"); //separator fo
        }
    }
    
    //Method to sort list by using Bubble Sort
    private void bubbleSort(List<Student> studentList){
         int n = studentList.size(); // Get the size of the list
        for (int i = 0; i < n - 1; i++) { // Outer loop for Bubble Sort
            for (int j = 0; j < n - i - 1; j++) { // Inner loop for comparing adjacent elements
                if (studentList.get(j).getTotalMark() > studentList.get(j + 1).getTotalMark()) { // Compare total marks
                    // Swap the elements if they are in the wrong order
                    Student temp = studentList.get(j);
                    studentList.set(j, studentList.get(j + 1));
                    studentList.set(j + 1, temp);
                }
            }
        }
    }
    // Method to print students whose total marks are below a certain threshold
    public void studentsMarksThreshold(double threshold) {
        System.out.println("Printing students with total marks below the threshold: " + threshold);
        for (Student student : students) { // Iterate over each student in the list
            if (student.getTotalMark() < threshold) { // Check if the student's total mark is below the threshold
                System.out.println("Student Name: " + student.getName());
                System.out.println("Student ID: " + student.studentID);
                System.out.println("\t Mark 1: " + student.getMark1()); // print mark 1 
                System.out.println("\t Mark 2: " + student.getMark2()); // print amrk 2
                System.out.println("\t Mark 3: " + student.getMark3()); // print mark 3
                System.out.println("Total Mark: " + student.getTotalMark()); // Print details for students below the threshold
                System.out.println();
                System.out.println("--------------------------------"); //separator fo
            }
        }
    }
    //Method to print top 5 and bottom 5 students based on total marks
    public void topandbottomStudentMarks(){
        //Sort all students by using bubble sort
        bubbleSort(students);
        
        //Get top 5 students
        System.out.println("Students with highest marks: ");
        for (int i = 0; i < 5; i++) {  // Loop through the code 5 times
            Student student = students.get(students.size() - i - 1);// Get the student from the end of the list (highest total marks) based on the current index
            System.out.printf("\t %d: %s\n", (i + 1), student.getName()); //print rank (i + 1) and student name
            System.out.println("\t Mark 1: " + student.getMark1()); // print mark 1 
            System.out.println("\t Mark 2: " + student.getMark2()); // print amrk 2
            System.out.println("\t Mark 3: " + student.getMark3()); // print mark 3
            System.out.println("\t Total Mark: " + student.getTotalMark()); // print total mark
            System.out.println("--------------------------------"); //separator for space between results
    }
     //Get Bottom 5 students
     System.out.println("Students with lowest marks: ");
        for (int i = 0; i < 5; i++) { //loop 5 times
            Student student = students.get(i); // Get the student from the beginning of the list (lowest total marks) based on the current index
            System.out.printf("\t %d: %s\n", (i + 1), student.getName()); //print rank (i + 1) and student name
            System.out.println("\t Mark 1: " + student.getMark1()); // print mark 1 
            System.out.println("\t Mark 2: " + student.getMark2()); // print amrk 2
            System.out.println("\t Mark 3: " + student.getMark3()); // print mark 3
            System.out.println("\t Total Mark: " + student.getTotalMark()); // print total mark
            System.out.println("--------------------------------"); //Separator for space between numbers
        }     
}
    
    
}


