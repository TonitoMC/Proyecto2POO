public class User {
    protected boolean registered;
    protected Transport transportEmission;
    protected Food foodEmission;
    protected Home homeEmission;
    protected double transportScore;
    protected double foodScore;
    protected double homeScore;
    protected double footPrint;
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
    public boolean getRegistered(){
        return registered;
    }
    public Transport getTransportEmission(){
        return transportEmission;
    }
    public Food getFoodEmission(){
        return foodEmission;
    }
    public Home getHomeEmission(){
        return homeEmission;
    }
    public double getFootprint(){
        return transportScore + foodScore + homeScore;
    }
    public double getFoodScore() {
        return foodScore;
    }
    public double getTransportScore() {
        return transportScore;
    }
    public double getHomeScore() {
        return homeScore;
    }
    public double getFootPrint() {
        return footPrint;
    }
}