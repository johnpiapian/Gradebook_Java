package Gradebook;

public class Model {
    
    //Names
    private final String[] names = {
        "Pamula Farr","Alan Giroir","Royal Behrman","John Clymer","Cristal Boyster",
        "Lael Fielden","Katherina Zajac","Earline Merrell","Erica Spilman","Damion Ensey",
        "Emmanuel Nodal","Magaret Flom","Karole Bryant","Stepanie Askew","Emil Keeton",
        "Eneida Liddle","Nola Carmichael","Page Lant","Shanel Bostwick","Florencia Biondi",
        "Louanne Selke","Shantay Capuano","Elizbeth Beaver","Kellie Fly","Karly Burbage",
        "Edmund Altman","Michaela Deppen","Taylor Pritchard","Janell Tietz","Raisa Callan"
    };
    
    //data storage
    private Student[] students = new Student[names.length];
    private Assignments[] assignmentsArr = new Assignments[students.length];
    
    
    Model(){
        generateNames();
    }
    
    public void generateNames(){
        for(int i=0; i < names.length; i++){
            
            String name[] = names[i].split(" ");
            String firstName = name[0];
            String lastName = name[1];
            students[i] = new Student(i+1, firstName, lastName);
            
            assignmentsArr[i] = new Assignments();
            assignmentsArr[i].setsID(students[i].getId());
        }
    }
    
    public int validateStudentID(int sid){
        int index = -1;
        for (int i=0; i<students.length; i++){
            if(students[i].getId() == sid){
                index = i;
            }
        }
        return index;
    }
    
    public int validateStudentName(String fname, String lname){
        //index position
        int index = -1;
        //Check if student is valid
        for (Student student : students){
            if (student.getFirstName().equals(fname) && student.getLastName().equals(lname)) {
                index = validateStudentID(student.getId());
            }
        }
        return index;
    }
    
    public int getAssignmentIndexbyStudentID(int sid){
        int index = -1;
        for (int i=0; i<assignmentsArr.length; i++){
            if(assignmentsArr[i].getsID() == sid){
                index = i;
            }
        }
        return index;
    }
    
    public Assignments getAssignmentsBysID(int sid){
        Assignments assignments = null;
        for (Assignments cAssignments : assignmentsArr){
            if(cAssignments.getsID() == sid){
                assignments = cAssignments;
            }
        }
        return assignments;
    }
    
    public Student getStudentByID(int sid){
        Student student = null; 
        for (Student cStudent : students){
            if(cStudent.getId() == sid){
                student = cStudent;
            }
        }
        return student;
    }
    
    public Student getStudentByName(String fname, String lname){
        Student student = null;
        for (Student cStudent : students){
            if (cStudent.getFirstName().equals(fname) && cStudent.getLastName().equals(lname)) {
                student = cStudent;
            }
        }
        return student;
    }
    
    
    //Setters & Getters
    public Student[] getStudents() {
        return students;
    }
    
    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Assignments[] getAssignmentsArr() {
        return assignmentsArr;
    }

    public void setAssignmentsArr(Assignments[] assignmentsArr) {
        this.assignmentsArr = assignmentsArr;
    }
    
    public void changeGrade(int pos, char grade){
        //students[pos].setGrade(grade);
    }
    
    
}
