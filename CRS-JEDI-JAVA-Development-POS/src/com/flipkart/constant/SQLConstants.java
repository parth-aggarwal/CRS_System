package com.flipkart.constant;

public class SQLConstants {
    public static final String USER_ENTRY_QUERY = "INSERT into User values (?,?,?,?,?)";
    public static final String COUNT_USERS_QUERY = "SELECT COUNT(*) FROM User";
    public static final String INSERT_USER_QUERY =  "insert into User values(?,?,?,?,?)";
    public static final String INSERT_ADMIN_QUERY = "insert into Admin values(?,?,?,?)";
    public static final String INSERT_PROFESSOR_QUERY = "insert into Professor values(?,?,?,?,?)";
    public static final String COUNT_USERS_WITH_SPECIFIC_ROLE_QUERY = "SELECT COUNT(*) FROM User WHERE roleId=?";
    public static final String SELECT_UNAPPROVED_STUDENTS_QUERY = "SELECT * FROM Student JOIN User ON Student.studentId = User.userId WHERE Student.statusApproval=0";
    public static final String UPDATE_STUDENT_APPROVAL_STATUS_QUERY = "UPDATE Student SET statusApproval=1 WHERE studentId = ?";
    public static final String FETCH_STUDENT_FOR_GRADECARD_GENERATION_QUERY = "select name, studentId, email, departmentId from Student JOIN User on userId = studentId where gradeCardApproved = 0 and statusApproval = 1;";
    public static final String FETCH_GRADES_QUERY = "select grade, semesterId from RegisteredCourse where studentId = ?";
    public static final String COUNT_GRADECARDS_QUERY = "select count(*) from GradeCard";
    public static final String INSERT_GRADECARD_QUERY = "insert into GradeCard (gradeCardId,studentId,SGPA,semesterId) values(?,?,?,?)";
    public static final String UPDATE_STUDENT_GRADE_STATUS_QUERY = "UPDATE Student set gradeCardApproved = 1, gradeCardId = ? WHERE studentId = ?";
    public static final String INSERT_CATALOGUE_QUERY = "insert into Catalogue values (?,?,?,?)";
    public static final String FETCH_CATALOGUE_QUERY = "select Catalogue.courseId, Course.name, Catalogue.professorId, Catalogue.availableSeats from Catalogue, Course where Catalogue.courseId = Course.courseId";
    public static final String DELETE_FROM_CATALOGUE_QUERY = "delete from Catalogue where courseId = ?";
    public static final String CHECK_IF_COURSE_EXISTS_QUERY = "SELECT COUNT(*) FROM Course WHERE courseId = ?";
    public static final String INSERT_IN_COURSE_QUERY = "INSERT INTO Course VALUES (?, ?)";

}
