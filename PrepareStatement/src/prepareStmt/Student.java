package prepareStmt;

import java.util.List;

public class Student {
    private int roll;
    private String name;
    private String city;

    // Default constructor
    public Student() {}

    // Parameterized constructor
    public Student(int roll, String name, String city) {
        this.roll = roll;
        this.name = name;
        this.city = city;
    }

    // Getter and Setter for Roll
    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    // Getter and Setter for Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for City
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student [Roll=" + roll + ", Name=" + name + ", City=" + city + "]";
    }

	public static void add(List<Student> s) {
		// TODO Auto-generated method stub
		Student.add(s);

	}
}
