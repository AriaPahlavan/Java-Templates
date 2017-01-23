package Characters;

public enum Classification{
    SENIOR,
    JUNIOR,
    SOPHOMORE,
    FRESHMAN,
    NONE;
    
    @Override
    public String toString() {
        String classification = "";
        switch (name()) {
            case "SENIOR":
                classification = "Senior";
                break;
            
            case "JUNIOR":
                classification = "Junior";
                break;
            case "SOPHOMORE":
                classification = "Sophomore";
                break;
            case "FRESHMAN":
                classification = "Freshman";
                break;
            case "NONE":
                classification = "not entered";
                break;
        }
        return classification;
    }
}
