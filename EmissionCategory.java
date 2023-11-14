/**
 * EmissionCategory interface for carbon footprint calculator, implemented by Transport Food and Home classes. All
 * the different categories must be able to calculate a carbon footprint value and make a String for writing attributes
 * in the CSV file
 * @author Jose Merida
 * @version 1.0
 * @since 13-11-2023
 */
public interface EmissionCategory {
    /**
     * Calculates carbon footprint emissions for specific category
     * @return The carbon footprint for the category in monthly KGs of CO2
     */
    double getFootprint();
    /**
     * Makes a String for writing attributes in CSV file
     * @return String with different attributes separated by comma.
     */
    String getString();
}