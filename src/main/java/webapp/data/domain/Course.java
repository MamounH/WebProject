package webapp.data.domain;

public class Course {

    private final int id;
    private final String name;
    private final int instructorId;
    private final String instructorName;

    private Course(CourseBuilder builder){
        this.id=builder.id;
        this.instructorId=builder.instructorId;
        this.name=builder.name;
        this.instructorName=builder.instructorName;
    }

    public static class CourseBuilder {

        private int id;
        private String name;
        private int instructorId;
        private String instructorName;

        public CourseBuilder id (int id){
            this.id=id;
            return this;
        }

        public CourseBuilder name (String name){
            this.name=name;
            return this;
        }


        public CourseBuilder instructorId (int instructorId){
            this.instructorId=instructorId;
            return this;
        }


        public CourseBuilder instructorName (String instructorName){
            this.instructorName=instructorName;
            return this;
        }


        public  Course build(){
            Course course = new Course(this);
            return course;
        }


    }




    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

}
