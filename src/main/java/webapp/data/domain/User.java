package webapp.data.domain;


import webapp.data.Role;

public class User {


    private final int id;
    private final String fName;
    private final String lName;
    private final String email;
    private final String password;
    private final String salt;
    private Role role;

    private User(UserBuilder builder){
        this.id=builder.id;
        this.fName=builder.fName;
        this.lName=builder.lName;
        this.email=builder.email;
        this.password=builder.password;
        this.salt=builder.salt;
        this.role=builder.role;
    }

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public String getSalt() {
        return salt;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public static class UserBuilder {

        private int id;
        private String fName;
        private String lName;
        private String email;
        private String password;
        private String salt;
        private Role role;

        public UserBuilder id (int id){
            this.id=id;
            return this;
        }

        public UserBuilder fName (String fName){
            this.fName=fName;
            return this;
        }

        public UserBuilder lName (String lName){
            this.lName=lName;
            return this;
        }

        public UserBuilder email (String email){
            this.email=email;
            return this;
        }


        public UserBuilder password (String password){
            this.password=password;
            return this;
        }

        public UserBuilder salt (String salt){
            this.salt=salt;
            return this;
        }

        public UserBuilder role (Role role){
            this.role=role;
            return this;
        }

        public  User build(){
            User user = new User(this);
            return user;
        }


    }

}
