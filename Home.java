public class Home implements EmissionCategory{
    private int electricityConsumption;
    private int gasConsumption;
    private int houseMates;
    private boolean plasticRecycled;
    public Home(int electricityConsumption, int gasConsumption, int houseMates, boolean plasticRecycled){
        this.electricityConsumption = electricityConsumption;
        this.gasConsumption = gasConsumption;
        this.houseMates = houseMates;
        this.plasticRecycled = plasticRecycled;
    }

    public int getElectricityConsumption() {
        return electricityConsumption;
    }

    public int getGasConsumption() {
        return gasConsumption;
    }

    public int getHouseMates() {
        return houseMates;
    }

    public boolean isPlasticRecycled() {
        return plasticRecycled;
    }
    public String getString(){
        if (plasticRecycled){
            return electricityConsumption + "," + gasConsumption + "," + houseMates + ",y,";
        } else {
            return electricityConsumption + "," + gasConsumption + "," + houseMates + ",n,";
        }
    }
    public double getFootprint() {
        double plasticFactor;
        if (plasticRecycled){
            plasticFactor = 37.36;
        } else{
            plasticFactor = 53.4;
        }
        return ((electricityConsumption * 0.3913 + gasConsumption * 1.35) / houseMates) + plasticFactor;
    }
}