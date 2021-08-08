package webapp.data.domain;

public class CourseMarks {

    private final int courseId;
    private final String mark;
    private final int studentId;
    public final String courseInstructor ;
    private final String courseName;


    private CourseMarks(CourseMarksBuilder builder){
        this.courseId=builder.courseId;
        this.mark=builder.mark;
        this.studentId=builder.studentId;
        this.courseInstructor=builder.courseInstructor;
        this.courseName=builder.courseName;
    }

    public static class CourseMarksBuilder{

        private int courseId;
        private String mark;
        private int studentId;
        public String courseInstructor;
        private String courseName;

        public CourseMarksBuilder courseId(int id){
            this.courseId=id;
            return this;
        }

        public CourseMarksBuilder mark(String mark){
            this.mark=mark;
            return this;
        }

        public CourseMarksBuilder studentId(int id){
            this.studentId=id;
            return this;
        }

        public CourseMarksBuilder courseInstructor(String name){
            this.courseInstructor=name;
            return this;
        }

        public CourseMarksBuilder courseName(String name){
            this.courseName=name;
            return this;
        }

        public CourseMarks build(){
            CourseMarks courseMarks = new CourseMarks(this);
            return courseMarks;
        }

    }


    public int getCourseId() {
        return courseId;
    }

    public String getMark() {
        return mark;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public String getCourseName() {
        return courseName;
    }



}
