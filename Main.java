/**
 * This program is a carbon footprint calculator, takes in information from a User and calculates their monthly carbon
 * emissions in KGs of CO2 emitted monthly. Allows for users to register using a Username and Password to be able to
 * update their information, stores data in CSV file.
 * @author Jose Merida
 * @version 1.0
 * @since 13-11-2023
 */
public class Main {
    /**
     * Initiates program by creating View, Model and Controller.
     */
    public static void main(String[] args) {
        View mainView = new View();
        Model mainModel = new Model();
        new Controller(mainView, mainModel);
    }
}