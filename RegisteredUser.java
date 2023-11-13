public class RegisteredUser extends User{
    private String username;
    private String password;
    private int lastScore;
    public RegisteredUser(Transport transportEmission, Food foodEmission, Home homeEmission, String username, String password) {
        super(transportEmission, foodEmission, homeEmission, true);
        this.username = username;
        this.password = password;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public void setTransport(Transport transport){
        transportEmission = transport;
    }
    public void setHome(Home home){
        homeEmission = home;
    }
    public void setFood(Food food){
        foodEmission = food;
    }
}