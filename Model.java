import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
/**
 * Controller Class for carbon footprint calculator, used to read / write data from CSV file and store it inside
 * an ArrayList while the program is running. Is in charge of calculations and data keeping of the program.
 * @author Jose Merida, Kenzo Ochoa, Sophié Cleaves
 * @version 1.0
 * @since 13-11-2023
 */
public class Model {
    private ArrayList<User> userList;
    private RegisteredUser loginUser;

    /**
     * Constructor for Model class, creates new Model and empty ArrayList of users.
     */
    public Model(){
        userList = new ArrayList<User>();
    }
    /**
     * Setter method for loginUser, used whenever a User logs in
     * @param currentUserName username of the user to be set as loginUser
     */
    public void setCurrentUser(String currentUserName) {
        /**
         * Gets an ArrayList of all RegisteredUser and checks whether the usernames match, if they do it sets loginUser
         * to the User.
         */
        ArrayList<RegisteredUser> registeredUserList = getUserList("RegisteredUser");
        for (RegisteredUser currentUser : registeredUserList){
            if (currentUser.getUsername().equals(currentUserName)){
                loginUser = currentUser;
            }
        }
    }
    /**
     * Method used to read data from CSV file into ArrayList userList
     */
    public void readCSV(){
        String line;
        try (
                BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                ArrayList<String> tempList = new ArrayList<>();
                for (String field : data) {
                    tempList.add(field);
                }
                //Creates new Transport object from CSV Values
                int carMoney = Integer.parseInt(tempList.get(1));
                int bikeMoney = Integer.parseInt(tempList.get(2));
                int flightHours = Integer.parseInt(tempList.get(3));
                Transport currentTransport = new Transport(carMoney, bikeMoney, flightHours);

                //Creates new Food object from CSV Values
                int meatPortions = Integer.parseInt(tempList.get(4));
                int chickenPortions = Integer.parseInt(tempList.get(5));
                int porkPortions = Integer.parseInt(tempList.get(6));
                int fishPortions = Integer.parseInt(tempList.get(7));
                int dairyPortions = Integer.parseInt(tempList.get(8));
                Food currentFood = new Food(meatPortions, chickenPortions, porkPortions, fishPortions, dairyPortions);

                //Gets information for House object from CSV Values
                int electricityConsumption = Integer.parseInt(tempList.get(9));
                int gasConsumption = Integer.parseInt(tempList.get(10));
                int houseMates = Integer.parseInt(tempList.get(11));

                //If the user is a Registered User, gets Username and Password & creates object. Else creates unregistered user
                if (Objects.equals(tempList.get(0), "y")){
                    String currentUserName = tempList.get(13);
                    String currentPassword = tempList.get(14);
                    if (tempList.get(12).equals("y")){
                        Home currentHome = new Home(electricityConsumption, gasConsumption, houseMates, true);
                        userList.add(new RegisteredUser(currentTransport, currentFood, currentHome, currentUserName, currentPassword));
                    } else {
                        Home currentHome = new Home(electricityConsumption, gasConsumption, houseMates, false);
                        userList.add(new RegisteredUser(currentTransport, currentFood, currentHome, currentUserName, currentPassword));
                    }
                }else{
                    if (tempList.get(12).equals("y")){
                        Home currentHome = new Home(electricityConsumption, gasConsumption, houseMates, true);
                        userList.add(new UnregisteredUser(currentTransport, currentFood, currentHome));
                    } else {
                        Home currentHome = new Home(electricityConsumption, gasConsumption, houseMates, false);
                        userList.add(new UnregisteredUser(currentTransport, currentFood, currentHome));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Method used to write data from ArrayList userList into CSV file
     */
    public void writeCSV(){
        //Separates userList into two separate lists for UnregisteredUser and RegisteredUser
            ArrayList<RegisteredUser> registeredUserList = getUserList("RegisteredUser");
            ArrayList<UnregisteredUser> unregisteredUserList = getUserList("UnregisteredUser");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("data.csv"))) {
                //Writes data for every RegisteredUser
                for (RegisteredUser currentRegisteredUser : registeredUserList) {
                    String transportString = currentRegisteredUser.getTransportEmission().getString();
                    String foodString = currentRegisteredUser.getFoodEmission().getString();
                    String homeString = currentRegisteredUser.getHomeEmission().getString();

                    bw.write("y," + transportString + foodString + homeString + currentRegisteredUser.getUsername() + "," + currentRegisteredUser.getPassword() + ",");
                    bw.newLine();
                }
                for (UnregisteredUser currentUnregistereduser: unregisteredUserList){
                    //Writes data for every UnregisteredUser
                    String transportString = currentUnregistereduser.getTransportEmission().getString();
                    String foodString = currentUnregistereduser.getFoodEmission().getString();
                    String homeString = currentUnregistereduser.getHomeEmission().getString();

                    bw.write("n," + transportString + foodString + homeString);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    /**
     * Gets an ArrayList of RegisteredUser or UnregisteredUser based on userType specified
     * @param userType "RegisteredUser" or "UnregisteredUser", the class the ArrayList will contain
     * @return ArrayList of objects of the specified class
     */
    public ArrayList getUserList(String userType) {
        ArrayList<User> tempList = new ArrayList<>();
        for (User currentUser : userList){
            if (currentUser.getClass().getSimpleName().equals(userType)){
                tempList.add(currentUser);
            }
        }
        return tempList;
    }

    /**
     * Calculates the average carbon footprint for all users (registered or unregistered) that have used the program
     * @return Average footprint in KGs of CO2 / month
     */
    public double getAverageFootprint(){
        double sum = 0;
        for (User currentUser : userList){
            sum = sum + currentUser.getFootprint();
        }
        return sum / userList.size();
    }
    /**
     * Calculates the average Transport carbon footprint for all users that have used the program
     * @return the average transport related carbon footprint in KGs of CO2 / month
     */
    public double getAverageTransportPrint(){
        double sum = 0;
        for (User currentUser : userList){
            sum = sum + currentUser.getTransportScore();
        }
        return sum / userList.size();
    }
    /**
     * Calculates the average Food carbon footprint for all users that have used the program
     * @return the average food related carbon footprint in KGs of CO2 / month
     */
    public double getAverageFoodPrint(){
        double sum = 0;
        for (User currentUser : userList){
            sum = sum + currentUser.getFoodScore();
        }
        return sum / userList.size();
    }
    /**
     * Calculates the average Home carbon footprint for all users that have used the program
     * @return the average home related carbon footprint in KGs of CO2 / month
     */
    public double getAverageHomePrint(){
        double sum = 0;
        for (User currentUser : userList){
            sum = sum + currentUser.getHomeScore();
        }
        return sum / userList.size();
    }
    /**
     * Getter method for loginUser (the user that is currently logged in)
     * @return loginUser
     */
    public RegisteredUser getLoginUser(){
        return loginUser;
    }
    /**
     * Updates the current loginUser's Transport, Food and Home attributes
     * @param transportEmission Transport to replace loginUser's current Transport
     * @param foodEmission Food to replace loginUser's current Food
     * @param homeEmission Home to replace loginUser's current Home
     */
    public void updateUser (Transport transportEmission, Food foodEmission, Home homeEmission){
        loginUser.setFood(foodEmission);
        loginUser.setHome(homeEmission);
        loginUser.setTransport(transportEmission);
    }
    /**
     * Checks whether a username exists in the database or not
     * @param user the username checked for existence
     * @return true if the username is unique, false if it already exists
     */
    public boolean validateSignup(String user){
        ArrayList<RegisteredUser> registeredUserList = getUserList("RegisteredUser");
        for (RegisteredUser currentUser : registeredUserList){
            if (currentUser.getUsername().equals(user)){
                return false;
            }
        }
        return true;
    }
    /**
     * Adds User to userList
     * @param user User to be added
     */
    public void addUser(User user){
        userList.add(user);
    }
    /**
     * Checks if the username and password match the login credentials for an existing user
     * @param user username credential
     * @param password password credential
     * @return true if the login is valid, false if the login isn't valid
     */
    public boolean validateLogin(String user, String password){
        ArrayList<RegisteredUser> registeredUserList = getUserList("RegisteredUser");
        for (RegisteredUser currentUser : registeredUserList){
            if (currentUser.getUsername().equals(user) && currentUser.getPassword().equals(password)){
                return true;
            } else{
                return false;
        }
        }
        return false;
    }
}