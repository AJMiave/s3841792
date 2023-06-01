package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Programmes offered by a university
 */
public class Programme {
    /**
     * Name and id of the programme
     */
    private String name;
    private int pID;

    /**
     * Start date of the programme
     */
    private Date startDate;

    /**
     * End date of the programme
     */
    private Date dueDate;

    /**
     * Estimated duration of the course in months
     */
    private int estimatedDuration;

    /**
     * Students allocated to the programme
     */
    private List<Student> enrolled = new ArrayList<Student>();

    private Football footBall;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return pID;
    }

    public void setID(int ID) {
        this.pID = ID;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(int estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public List<Student> getEnrollments() {
        return enrolled;
    }

    
    public boolean removeEnrolledStudent(Student student) {
    	return false;
    	   
    }



    /**
     * Add a new student to the programme
     * @param Student: to enroll  to student in a programme 
     * @return true if the student is successfully enrolled, false otherwise
     */

    public boolean addStudent(Student student) throws IllegalStudentEnrollException {
        Date currentDate = new Date();
        int comparisonResult = currentDate.compareTo(this.getStartDate());
        
        if (comparisonResult > 0) { // if start date has passed
            return false;
        }
        else if (this.enrolled.contains(student)) { // if the student is already enrolled
            throw new IllegalStudentEnrollException("nah you already in bro");
        }
        else if (this.enrolled.size() >= 250) { // if the course is full
            return false;
        }
        this.enrolled.add(student); // enrolls student
        //update the number of courses student is enrolled into
        student.setNumberOfCourses(student.getNumberOfCourses() + 1); 

        this.footBall.addAvailStudent(student);
    	return true;
   
    }




}
