package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "roll_no")
    private int rollNo;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_score")
    private String scores;
    @Embedded
    private Subjects sub;

    public Student() {
        
    }

    public Student(int rollNo, String studentName, String scores, Subjects sub) {
        this.rollNo = rollNo;
        this.studentName = studentName;
        this.scores = scores;
        this.sub = sub;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public Subjects getSub() {
        return sub;
    }

    public void setSub(Subjects sub) {
        this.sub = sub;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getScores() {
        return scores;
    }

    public void setScores(String scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Student{" + "rollNo=" + rollNo + ", studentName=" + studentName + ", scores=" + scores + '}';
    }

}
