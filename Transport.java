/**
 * Transport Class for carbon footprint calculator, used to store information and calculate carbon footprint emissions
 * for the Transport category
 * @author Jose Merida
 * @version 1.0
 * @since 13-11-2023
 */
public class Transport implements EmissionCategory{
    private int carMoney;
    private int bikeMoney;
    private int flightHours;
    /**
     * Constructor for Transport class, sets initial values for attributes
     * @param carMoney money spent by user on gas for a car / month
     * @param bikeMoney money spent by user on gas for a bike / month
     * @param flightHours time spent on flights by user in the past year
     */
    public Transport(int carMoney, int bikeMoney, int flightHours){
        this.carMoney = carMoney;
        this.bikeMoney = bikeMoney;
        this.flightHours = flightHours;
    }
    /**
     * Creates a string of attributes separated by commas, used to write information into CSV file
     * @return String of attributes separated by commas
     */
    public String getString(){
        return carMoney + "," + bikeMoney + "," + flightHours + ",";
    }
    /**
     * Calculates carbon footprint for the Transport Object / category based on attributes
     * @return Carbon emissions in KGs of CO2 emitted monthly
     */
    public double getFootprint(){
        return (carMoney * 8.89) + (bikeMoney * 8.1772) + (flightHours * 92);
    }
}
