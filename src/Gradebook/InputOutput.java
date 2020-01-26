package Gradebook;

import java.util.Scanner;

public class InputOutput {
    
    private final Scanner input = new Scanner(System.in);
    
    public void intro(){
        System.out.println("This is a gradebook app for teachers.");
    }
    
    public int getStudentID(){
        System.out.print("ID: ");
        return input.nextInt();
    }
    
    public String getStudentFirstName(){
        System.out.print("Firstname: ");
        return input.next();
    }
    
    public String getStudentLastName(){
        System.out.print("Lastname: ");
        return input.next();
    }
    
    public double getNewGrade(){
        System.out.println("Enter a new score(0-50): ");
        return input.nextDouble();
    }
    
    public int getAssignmentNo(){
        System.out.println("Enter assignment no ");
        return input.nextInt();
    }
    
    public int getSearchType(){
        System.out.println("");
        System.out.println("1) Search by ID \n2) Search by Name \n0) Back to Menu");
        return input.nextInt();
    }
    
    public String getAssignmentInputRange(){
        System.out.println("Enter your assignment rage(e.g 0-4, 2-5): ");
        return input.next();
    }
    
    
    public boolean queryExit(){
        System.out.print("\n1 to continue, or 0 to exit the program : ");
        return input.nextInt() == 1;
    }
    
    
    public int Menu(){
        //display check grades, add grades, edit student grades, calculate a final grade, display all students, and exit.
        System.out.println("\nWelcome:-");
        System.out.println("1) Check Grades \n2) Add Grades \n3) Edit Student Grades \n4) Calculate a final grade \n5) Display all students \n0) Exit");
        return input.nextInt();
    }
    
    public void displayStudentInfo(int id, String fname, String lname){
        System.out.println("|ID: "+id+"\t |Firstname: "+fname+"\t |Lastname: "+lname);
    }
    
    public void displayAssignmentScore(int assignmentNo, double studentScore, double fullScore){
        System.out.println("Assignment "+assignmentNo+":\t "+studentScore+"/"+fullScore);
    }
    
    public void showLetterGrade(String grade){
        System.out.println("|Final Grade: "+grade);
    }

    public void showUpdateSuccess(){
        System.out.println("Successfully updated!");
    }
    
    public void showUpdateFail(){
        System.out.println("There has been an error!");
    }
    
    public void showAssignmentCount(int count){
        System.out.println("Assignment "+count+":-");
    }
    
    public void invalidInput(){
        System.out.println("Invalid input!");
    }
    
    public void invalidStudentName(){
        System.out.println("Invalid name!"); 
    }
    
    public void invalidStudentID(){
        System.out.println("Invalid ID!");
    }
    
}
