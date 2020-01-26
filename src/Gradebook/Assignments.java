package Gradebook;

public class Assignments {
    
    private int sID;
    private double pointWorth = 50;
    private String grade = "Needs Grading";
    private double assignmentScores[] = new double[10];
    private double getTotalScore = this.assignmentScores.length * this.pointWorth;
    
    
    // set all default scores to zeros
    /*Assignments(){
        for(int i=0; i<this.assgimentScores.length; i++){
            assgimentScores[i] = 1;
        }
    }*/
    
    public double getScore(int index){
        return this.assignmentScores[index];
    }
    
    public void setScore(int index, double value){
        this.assignmentScores[index] = value;
    }
    
    public int getAssignmentCount(){
        return this.assignmentScores.length;
    }
    
    public double getStudentTotalScore(){
        double temp = 0;
        for(int i=0; i<assignmentScores.length; i++){
            temp += this.assignmentScores[i];
        }
        return temp;
    }
    
    public void calculateGrade(){
        double percentage = (this.getStudentTotalScore()/this.getTotalScore)*100;

        if(percentage >= 95){
            this.grade = "A";
        }else if(percentage >= 90){
            this.grade = "A-";
        }else if(percentage >= 85){
            this.grade = "B+";
        }else if(percentage >= 80){
            this.grade = "B";
        }else if(percentage >= 75){
            this.grade = "B-";
        }else if(percentage >= 70){
            this.grade = "C+";
        }else if(percentage >= 65){
            this.grade = "C";
        }else if(percentage >= 60){
            this.grade = "D";
        }else{
            this.grade = "F";
        }
    }
    
    
    // Setters & Getters
    public int getsID(){
        return this.sID;
    }
   
    public void setsID(int sid){
        this.sID = sid;
    } 

    public double getPointWorth() {
        return this.pointWorth;
    }

    public void setPointWorth(double pointWorth) {
        this.pointWorth = pointWorth;
    }

    public String getGrade() {
        this.calculateGrade();
        return this.grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double[] getAssignmentScores() {
        return this.assignmentScores;
    }

    public void setAssgimentScores(double[] assgimentScores) {
        this.assignmentScores = assgimentScores;
    } 
}
