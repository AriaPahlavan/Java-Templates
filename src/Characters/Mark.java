package Characters;

/**
 * Created by Aria Pahlavan on 1/19/17.
 */
public class Mark {
    
    private int id;
    
    private Student student;
    
    private Integer value = 0;
    
    private Major major;
    
    public int getId() {
        return id;
    }
    
    public Student getStudent() {
        return student;
    }
    
    public Integer getValue() {
        return value;
    }
    
    public Major getMajor() {
        return major;
    }
    
    public Mark(int id, Student student, Integer value, Major major) {
        this.id = id;
        this.student = student;
        this.value = value;
        this.major = major;
    }
}
