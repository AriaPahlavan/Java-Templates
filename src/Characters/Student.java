package Characters;

import java.util.Optional;

/**
 * Created by Aria Pahlavan on 1/19/17.
 */
public class Student {
    private String first_name;
    private String last_name;
    private String school;
    private Major major = Major.NONE;
    private Classification classification = Classification.NONE;
    private EducationalLevel educationalLevel = EducationalLevel.NONE;
    private int age;
    private int id;
    private int gpa;
    
    public Student() {}
    
    public Student(String first_name, String last_name, int age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }
    
    public Student setEducationalLevel(EducationalLevel educationalLevel) {
        this.educationalLevel = educationalLevel;
        return this;
    }
    
    public EducationalLevel getEducationalLevel() {
        return educationalLevel;
    }
    
    public String getFirst_name() {
        return first_name;
    }
    
    public Student setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }
    
    public String getLast_name() {
        return last_name;
    }
    
    public Student setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }
    
    public Major getMajor() {
        return major;
    }
    
    public Student setMajor(Major major) {
        this.major = major;
        return this;
    }
    
    public Classification getClassification() {
        return classification;
    }
    
    public Student setClassification(Classification classification) {
        this.classification = classification;
        return this;
    }
    
    public String getSchool() {
        return school;
    }
    
    public Student setSchool(String school) {
        this.school = school;
        return this;
    }
    
    public int getAge() {
        return age;
    }
    
    public Student setAge(int age) {
        this.age = age;
        return this;
    }
    
    public int getId() {
        return id;
    }
    
    public Student setId(int id) {
        this.id = id;
        return this;
    }
    
    public int getGpa() {
        return gpa;
    }
    
    public Student setGpa(int gpa) {
        this.gpa = gpa;
        return this;
    }
    
    @Override
    public String toString() {
        return "Student{\n" +
                       "\tFirst name: " + Optional.ofNullable(first_name).orElse("not available") +
                       "\n \tLast name: " + Optional.ofNullable(last_name).orElse("not available") +
                       "\n \tAge: " + age +
                       "\n \tMajor: " + major.toString() +
                       "\n \tClassification: " + classification.toString() +
                       "\n \tEducation level: " + educationalLevel.toString() +
                       "\n}";
    }
}

