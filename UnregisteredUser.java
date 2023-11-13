public class UnregisteredUser extends User{

    public UnregisteredUser(Transport transportEmission, Food foodEmission, Home homeEmission) {
        super(transportEmission, foodEmission, homeEmission, false);
    }
}