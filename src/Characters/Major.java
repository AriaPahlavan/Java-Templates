package Characters;

public enum Major {
    MATHEMATICS,
    PHYSICS,
    PSYCHOLOGY,
    NOUROLOGY,
    NURSING,
    LIBERAL_ARTS,
    HISTORY,
    LAWER,
    ELECTRICAL_ENGR,
    CHEMICAL_ENGR,
    COMPUTER_ENGR,
    MECHANICAL_ENGR,
    SOFTWARE_ENGR,
    BIOMEDICAL_ENGR,
    AIROSPACE_ENGR,
    INDUSTRIAL_ENGR,
    CIVIL_ENGR,
    COMPUTER_SCIENCE,
    PETROLEUM_ENGR,
    NONE;
    
    
    @Override
    public String toString() {
        String major = "";
        switch (name()) {
            case "ELECTRICAL_ENGR":
                major = "Electrical Engineering";
                break;
            
            case "MATHEMATICS":
                major = "Mathematics";
                break;
            case "PHYSICS":
                major = "Physics";
                break;
            case "PSYCHOLOGY":
                major = "Psychology";
                break;
            case "NOUROLOGY":
                major = "Neuron science";
                break;
            case "NURSING":
                major = "Nursing";
                break;
            case "LIBERAL_ARTS":
                major = "Liberal Arts";
                break;
            case "HISTORY":
                major = "History";
                break;
            case "LAWER":
                major = "Law School";
                break;
            case "CHEMICAL_ENGR":
                major = "Chemical Engineering";
                break;
            case "COMPUTER_ENGR":
                major = "Computer Engineering";
                break;
            case "MECHANICAL_ENGR":
                major = "Mechanical Engineering";
                break;
            case "SOFTWARE_ENGR":
                major = "Software Engineering";
                break;
            case "BIOMEDICAL_ENGR":
                major = "Biomedical Engineering";
                break;
            case "AIROSPACE_ENGR":
                major = "Airospace Engineering";
                break;
            case "INDUSTRIAL_ENGR":
                major = "Industrial Engineering";
                break;
            case "CIVIL_ENGR":
                major = "Civil Engineering";
                break;
            case "COMPUTER_SCIENCE":
                major = "Computer Science";
                break;
            case "PETROLEUM_ENGR":
                major = "Petroleum Engineering";
                break;
            case "NONE":
                major = "not entered";
                break;
        }
        return major;
    }
}
