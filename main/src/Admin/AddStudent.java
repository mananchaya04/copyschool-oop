package Admin;

public class AddStudent {
    private String id;
    private String name;
    private String surname;
    private String birth;
    private String section;
    private String password;

    public AddStudent(String id,String password){
        this.id = id;
        this.password = password;
    }
    public AddStudent(String id,String name,String surname,String birth,String section){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.section = section;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
    public void setSection(String course) {
        this.section = course;
    }

    public String getBirth() {
        return birth;
    }
    public String getSection() {
        return section;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getPassword() {
        return password;
    }
}

