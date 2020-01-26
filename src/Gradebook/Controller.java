package Gradebook;

public class Controller {
    
    private final Model model;
    private final InputOutput io;
    
    Controller(){
    this.model = new Model();
        this.io = new InputOutput();
        this.start();
    }
    
    public void start(){
        do{
            //Display start menu
            io.intro();
            this.Menu();
        }while(io.queryExit());
    }
    
    public void Menu(){
        //display check grades, add grades, edit student grades, calculate a final grade, display all students, and exit.
        boolean Exit = false;
        while(!Exit){
            switch (io.Menu()){
                case 1: //Check grades
                    this.checkGrades();
                    break;
                case 2: // Add grades
                    this.addGrades();
                    break;
                case 3: // Edit student grades
                    this.editGrades();
                    break;
                case 4: // Get a final grade
                    this.calculateFinalGrade();
                    break;
                case 5: // Display all students
                    this.displayAllStudents();
                default:
                    Exit = true;
                    break;
            }
        }
    }
    
    public void addGrades(){
        switch (io.getSearchType()){
            case 1: // by id
                int sID = io.getStudentID();
                
                Student student = model.getStudentByID(sID);
                Assignments assignments = model.getAssignmentsBysID(sID);
                
                if(student != null && assignments != null){
                    String arr[] = io.getAssignmentInputRange().split("-");
                    if(arr.length > 1){
                        for(int i=0; i<=Integer.parseInt(arr[1]); i++){
                            int start = Integer.parseInt(arr[0]);
                            io.showAssignmentCount(start+i);
                            assignments.setScore(start+i, io.getNewGrade());
                        }
                    }else{
                        io.invalidInput();
                    }
                }else{
                    io.invalidStudentID();
                } 
                break;
            case 2: // by name
                String fname = io.getStudentFirstName();
                String lname = io.getStudentLastName();
                
                student = model.getStudentByName(fname, lname);
                assignments = model.getAssignmentsBysID(student.getId());
                
                if(student != null && assignments != null){
                }else{
                    io.invalidStudentName();
                } 
                break;
        } 
    }
    
    public void editGrades(){
        switch (io.getSearchType()){
            case 1: // by id
                int sID = io.getStudentID();
                
                Student student = model.getStudentByID(sID);
                Assignments assignments = model.getAssignmentsBysID(sID);
                
                if(student != null && assignments != null){
                    double newGrade = io.getNewGrade();
                    if(newGrade >= 0 && newGrade <= assignments.getPointWorth()){
                        try {
                            assignments.setScore(io.getAssignmentNo(), newGrade);
                            io.showUpdateSuccess();
                        }catch (Exception e){
                            io.showUpdateFail();
                        }
                    }else{
                         io.invalidInput();
                    }
                }else{
                    io.invalidStudentID();
                } 
                
                break;
            case 2: // by name
                String fname = io.getStudentFirstName();
                String lname = io.getStudentLastName();
                
                student = model.getStudentByName(fname, lname);
                assignments = model.getAssignmentsBysID(student.getId());
                
                if(student != null && assignments != null){
                    double newGrade = io.getNewGrade();
                    if(newGrade >= 0 && newGrade <= assignments.getPointWorth()){
                        try {
                            assignments.setScore(io.getAssignmentNo(), newGrade);
                            io.showUpdateSuccess();
                        }catch (Exception e){
                            io.showUpdateFail();
                        }
                    }else{
                         io.invalidInput();
                    }
                }else{
                    io.invalidStudentID();
                }
                
                break;
        } 
    }
    
    public void checkGrades(){
        switch (io.getSearchType()){
            case 1: // by id
                int sID = io.getStudentID();
                
                Student student = model.getStudentByID(sID);
                Assignments assignments = model.getAssignmentsBysID(sID);
                
                if(student != null && assignments != null){
                    io.displayStudentInfo(student.getId(), student.getFirstName(), student.getLastName());
                    for(int i=0; i<assignments.getAssignmentCount(); i++){
                        io.displayAssignmentScore(i, assignments.getScore(i), assignments.getPointWorth());
                    }
                }else{
                    io.invalidStudentID();
                } 
                break;
            case 2: // by name
                String fname = io.getStudentFirstName();
                String lname = io.getStudentLastName();
                
                student = model.getStudentByName(fname, lname);
                assignments = model.getAssignmentsBysID(student.getId());
                
                if(student != null && assignments != null){
                    io.displayStudentInfo(student.getId(), student.getFirstName(), student.getLastName());
                    for(int i=0; i<assignments.getAssignmentCount(); i++){
                        io.displayAssignmentScore(i, assignments.getScore(i), assignments.getPointWorth());
                    }
                }else{
                    io.invalidStudentName();
                } 
                break;
        }
    }
    
    public void calculateFinalGrade(){
        switch (io.getSearchType()){
            case 1: //search by id
                int sID = io.getStudentID();
                
                Student student = model.getStudentByID(sID);
                Assignments assignments = model.getAssignmentsBysID(sID);

                if(student != null && assignments != null){
                    io.displayStudentInfo(student.getId(), student.getFirstName(), student.getLastName());
                    io.showLetterGrade(assignments.getGrade());
                }else{
                    io.invalidStudentID();
                }
                break;
            case 2: //search by name
                String fname = io.getStudentFirstName();
                String lname = io.getStudentLastName();
                
                student = model.getStudentByName(fname, lname);
                assignments = model.getAssignmentsBysID(student.getId());

                if(student != null && assignments != null){
                    io.displayStudentInfo(student.getId(), student.getFirstName(), student.getLastName());
                    io.showLetterGrade(assignments.getGrade());
                }else{
                    io.invalidStudentName();
                }
                break;
        }            
    }
    
    public void displayAllStudents(){
        for (Student student : model.getStudents()) {
            io.displayStudentInfo(student.getId(), student.getFirstName(), student.getLastName());
        }
    }
}
