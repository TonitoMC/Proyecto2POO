/**
 * User Class for carbon footprint calculator, this class is a superclass of UnregisteredUser and RegisteredUser. Has
 * common attributes for every User and methods that are used by both subclasses.
 * @author Jose Merida, Sophie Cleaves
 * @version 1.0
 * @since 13-11-2023
 */
public class User {
    protected boolean registered;
    protected Transport transportEmission;
    protected Food foodEmission;
    protected Home homeEmission;
    protected double transportScore;
    protected double foodScore;
    protected double homeScore;
    protected double footPrint;
    /**
     * Constructor for new User
     * @param transportEmission Transport object for the User
     * @param foodEmission Food object for the User
     * @param homeEmission Home object for the User
     * @param registered Whether the user is registered or not (has username and password)
     */
    public User(Transport transportEmission, Food foodEmission, Home homeEmission, boolean registered){
        this.transportEmission = transportEmission;
        this.foodEmission = foodEmission;
        this.homeEmission = homeEmission;
        this.registered = registered;
        this.transportScore = transportEmission.getFootprint();
        this.foodScore = foodEmission.getFootprint();
        this.homeScore = homeEmission.getFootprint();
        this.footPrint = transportScore + foodScore + homeScore;
    }
    /**
     * Getter method for Transport object
     * @return Transport object
     */
    public Transport getTransportEmission(){
        return transportEmission;
    }
    /**
     * Getter method for Food object
     * @return Food object
     */
    public Food getFoodEmission(){
        return foodEmission;
    }
    /**
     * Getter method for Home object
     * @return Home object
     */
    public Home getHomeEmission(){
        return homeEmission;
    }
    /**
     * Calculates a User's carbon footprint
     * @return Monthly carbon emissions in KGs of CO2 / month
     */
    public double getFootprint(){
        return transportScore + foodScore + homeScore;
    }
    /**
     * Calculates a User's food related carbon footprint
     * @return Monthly food related carbon emissions in KGs of CO2 / month
     */
    public double getFoodScore() {
        return foodScore;
    }
    /**
     * Calculates a User's transport related carbon footprint
     * @return Monthly transport related carbon emissions in KGs of CO2 / month
     */
    public double getTransportScore() {
        return transportScore;
    }
    /**
     * Calculates a User's home related carbon footprint
     * @return Monthly home related carbon emissions in KGs of CO2 / month
     */
    public double getHomeScore() {
        return homeScore;
    }
}