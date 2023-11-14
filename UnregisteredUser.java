/**
 * RegisteredUser Class for carbon footprint calculator, used to store and manage data related to an UnregisteredUser.
 * This class is a subclass of User, constructor requires less parameters and "registered" attribute is always false.
 * @author Jose Merida
 * @version 1.0
 * @since 13-11-2023
 */
public class UnregisteredUser extends User{
    /**
     * Constructor for UnregisteredUser
     * @param transportEmission Transport object for the UnregisteredUser
     * @param foodEmission Food object for the UnregisteredUser
     * @param homeEmission Home object for the UnregisteredUser
     */
    public UnregisteredUser(Transport transportEmission, Food foodEmission, Home homeEmission) {
        super(transportEmission, foodEmission, homeEmission, false);
    }
}