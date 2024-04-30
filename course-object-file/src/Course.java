import java.io.Serializable;

public class Course implements Serializable {
    String courseName, courseTitle, creditHour;

    Course () {
        
    }

    Course (String creditHour, String courseName, String courseTitle) {
        this.creditHour = creditHour;
        this.courseName = courseName;
        this.courseTitle = courseTitle;
    }

    public String toString () {
        return "Course Class: \n Course Name: " + this.courseName + " \n Credit Hour: " + this.creditHour + " \n Course Title: " + this.courseTitle;
    }
}
