/**
 * Food Class for carbon footprint calculator, used to store information and calculate carbon footprint emissions
 * for the Food category.
 * @author Jose Merida
 * @version 1.0
 * @since 13-11-2023
 */
public class Food implements EmissionCategory{
    private int meatPortions;
    private int chickenPortions;
    private int porkPortions;
    private int fishPortions;
    private int dairyPortions;
    /**
     * Constructor for Food class, sets initial values for attributes
     * @param meatPortions portions of meat consumed in a week by the User
     * @param chickenPortions portions of chicken consumed in a week by the User
     * @param porkPortions portions of pork consumed in a week by the User
     * @param fishPortions portions of fish consumed in a week by the User
     * @param dairyPortions portions of dairy consumed in a week by the User
     */
    public Food(int meatPortions, int chickenPortions, int porkPortions, int fishPortions, int dairyPortions){
        this.meatPortions = meatPortions;
        this.chickenPortions = chickenPortions;
        this.porkPortions = porkPortions;
        this.fishPortions = fishPortions;
        this.dairyPortions = dairyPortions;
    }
    /**
     * Calculates carbon footprint for the Food Object / category based on attributes
     * @return Carbon emissions in KGs of CO2 emitted monthly
     */
    public double getFootprint() {
        return 4*(8.46 * meatPortions + 0.84 * chickenPortions + 1.05 * porkPortions + 1.16 * fishPortions + 0.576 * dairyPortions);
    }
    /**
     * Creates a string of attributes separated by commas, used to write information into CSV file
     * @return String of attributes separated by commas
     */
    public String getString(){
        return meatPortions + "," + chickenPortions + "," + porkPortions + "," + fishPortions + "," + dairyPortions + ",";
    }
}