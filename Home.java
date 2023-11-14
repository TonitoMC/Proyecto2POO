/**
 * Home Class for carbon footprint calculator, used to store information and calculate carbon footprint emissiones
 * for the Home category.
 * @author Jose Merida
 * @version 1.0
 * @since 13-11-2023
 */
public class Home implements EmissionCategory{
    private int electricityConsumption;
    private int gasConsumption;
    private int houseMates;
    private boolean plasticRecycled;
    /**
     * Constructor for Home class, sets initial values for attributes
     * @param electricityConsumption monthly electricity consumption of the User in kWH
     * @param gasConsumption monthly gas consumption of the User in lbs
     * @param houseMates number of people in the User's home
     * @param plasticRecycled wheter the user recycles plastic or not
     */
    public Home(int electricityConsumption, int gasConsumption, int houseMates, boolean plasticRecycled){
        this.electricityConsumption = electricityConsumption;
        this.gasConsumption = gasConsumption;
        this.houseMates = houseMates;
        this.plasticRecycled = plasticRecycled;
    }
    /**
     * Creates a string of attributes separated by commas, used to write information into CSV file
     * @return String of attributes separated by commas
     */
    public String getString(){
        if (plasticRecycled){
            return electricityConsumption + "," + gasConsumption + "," + houseMates + ",y,";
        } else {
            return electricityConsumption + "," + gasConsumption + "," + houseMates + ",n,";
        }
    }
    /**
     * Calculates carbon footprint for the Home Object / category based on attributes
     * @return Carbon emission in KGs of CO2 emitted monthly
     */
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