package Characters;

public enum EducationalLevel {
    PRE_SCHOOL,
    ELEMENTARY_SCHOOL,
    MIDDLE_SCHOOL,
    HIGH_SCHOOL,
    COLLEGE,
    UNDERGRAD,
    GRAD,
    PHD,
    NONE;
    
    @Override
    public String toString() {
        String educationLevel = "";
        switch (name()) {
            case "PRE_SCHOOL":
                educationLevel = "Pre School";
                break;
            
            case "ELEMENTARY_SCHOOL":
                educationLevel = "Elementary School";
                break;
            case "MIDDLE_SCHOOL":
                educationLevel = "Middle School";
                break;
            case "HIGH_SCHOOL":
                educationLevel = "High School";
                break;
            case "COLLEGE":
                educationLevel = "College";
                break;
    
            case "UNDERGRAD":
                educationLevel = "Undergraduate";
                break;
            case "GRAD":
                educationLevel = "Graduate";
                break;
            case "PHD":
                educationLevel = "PhD";
                break;
            case "NONE":
                educationLevel = "not entered";
                break;
        }
        return educationLevel;
    }
}
