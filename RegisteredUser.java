/**
 * RegisteredUser Class for carbon footprint calculator, used to store and manage data related to a RegisteredUser.
 * This class is a subclass of user, implements username and password attributes and "registered" attribute of User
 * is always true.
 * @author Jose Merida
 * @version 1.0
 * @since 13-11-2023
 */
public class RegisteredUser extends User{
    private String username;
    private String password;
    /**
     * Constructor for RegisteredUser Class, creates a new RegisteredUser with specified attributes
     * @param transportEmission Transport object for the RegisteredUser
     * @param foodEmission Food object for the RegisteredUser
     * @param homeEmission Home object for the RegisteredUser
     * @param username Username String for RegisteredUser
     * @param password Password String for RegisteredUser
     */
    public RegisteredUser(Transport transportEmission, Food foodEmission, Home homeEmission, String username, String password) {
        super(transportEmission, foodEmission, homeEmission, true);
        this.username = username;
        this.password = password;
    }
    /**
     * Getter method for Username attribute
     * @return String username
     */
    public String getUsername(){
        return username;
    }
    /**
     * Getter method for Password attribute
     * @return String password
     */
    public String getPassword(){
        return password;
    }
    /**
     * Setter method for Transport attribute
     * @param transport The Transport we're replacing the current Transport with
     */
    public void setTransport(Transport transport){
        transportEmission = transport;
    }
    /**
     * Setter method for Home attribute
     * @param home The Home we're replacing the current Home with
     */
    public void setHome(Home home){
        homeEmission = home;
    }
    /**
     * Setter method for Food attribute
     * @param food The Food we're replacing the current Food with
     */
    public void setFood(Food food){
        foodEmission = food;
    }
}