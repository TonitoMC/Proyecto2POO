public class Transport implements EmissionCategory{
    private int carMoney;
    private int bikeMoney;
    private int flightHours;
    public Transport(int carMoney, int bikeMoney, int flightHours){
        this.carMoney = carMoney;
        this.bikeMoney = bikeMoney;
        this.flightHours = flightHours;
    }

    public int getCarMoney() {
        return carMoney;
    }

    public int getBikeMoney() {
        return bikeMoney;
    }

    public int getFlightHours() {
        return flightHours;
    }
    public String getString(){
        return carMoney + "," + bikeMoney + "," + flightHours + ",";
    }

    public double getFootprint(){
        return (carMoney * 8.89) + (bikeMoney * 8.1772) + (flightHours * 92);
    }
}
