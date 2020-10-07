package be.vdabbeele.Employee.Domain;

public class Employee {
    private static final long serialVersionUID = 1L;

    private int id;
    private String firstName;
    private String lastName;
    private Profession profession;

    public Employee() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
