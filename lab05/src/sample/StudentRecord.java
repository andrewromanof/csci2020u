package sample;

public class StudentRecord {

    String StudentID;
    double Midterm;
    double Exam;
    double Assignments;
    double Final;
    String Grade;

    public StudentRecord(String StudentID, float Assignments, float Midterm, float Exam) {
        this.StudentID = StudentID;
        this.Assignments = Assignments;
        this.Midterm = Midterm;
        this.Exam = Exam;
        this.Final = ((((Assignments / 100) * 0.2) + ((Midterm / 100) * 0.3) + ((Exam / 100) * 0.5)) * 100);
        if (this.Final > 80) {
            this.Grade = "A";
        }
        else if (this.Final < 80 & this.Final >= 70) {
            this.Grade = "B";
        }
        else if (this.Final < 70 & this.Final >= 60) {
            this.Grade = "C";
        }
        else if (this.Final < 60 & this.Final >= 50) {
            this.Grade = "D";
        }
        else {
            this.Grade = "F";
        }
    }

    public double getFinal() {
        return Final;
    }

    public double getAssignments() {
        return Assignments;
    }

    public double getExam() {
        return Exam;
    }

    public double getMidterm() {
        return Midterm;
    }

    public String getGrade() {
        return Grade;
    }

    public String getStudentID() {
        return StudentID;
    }
}
