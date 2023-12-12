/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week07;

/**
 *
 * @author lowji
 */
import java.io.*;
import java.util.*;

public class L07Q01 {
    public static void main(String[] args) {
        
        writeFile();
        
        // Ask user for a course code
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a course code: ");
        String userCourseCode = scanner.nextLine();
        
        readData(userCourseCode);
    }
    
    
    // Write course data to the binary file
    public static void writeFile() {
        try {
            
            // Create an array to store course codes and names
            String[][] courses = {
                {"WXES1116", "Programming I"},
                {"WXES1115", "Data Structure"},
                {"WXES1110", "Operating System"},
                {"WXES1112", "Computing Mathematics I"}
            };
            
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("coursename.dat"));
            for (String[] course : courses) {
                for (String course1 : course) {
                    outStream.writeUTF(course1); // Write course code
                }
            }
            System.out.println("Course data written to coursename.dat.");
            
            outStream.close();
        }catch (IOException e) {
            System.out.println("Course not found");
        }            
    }        
        

    // Read course data from the binary file and find the matching course name
    public static void readData (String userCourseCode) {      
        String courseCode;
        String courseName;
        boolean courseFound = false;
        
        try {
            ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("coursename.dat"));
            while (true) {
                try {
                    courseCode = inStream.readUTF();
                    courseName = inStream.readUTF();

                    if (courseCode.equals(userCourseCode)) {
                        courseFound = true;
                        System.out.println("Course name for code " + userCourseCode + ": " + courseName);
                        break;
                    }
                } catch (EOFException e) {
                    System.out.println("Course is not found");
                    break; // End of file reached
                }
            }
            
            inStream.close();
        } catch (FileNotFoundException | EOFException e) {
        }
         catch (IOException e) {
            e.printStackTrace();
        } 
        
    }
    
}
