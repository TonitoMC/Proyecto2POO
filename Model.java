import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
public class Model {
    private ArrayList<User> userList;
    private String currentUserName;
    public Model(){
        userList = new ArrayList<User>();
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }
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
    public void writeCSV(){
            ArrayList<RegisteredUser> registeredUserList = getUserList("RegisteredUser");
            ArrayList<UnregisteredUser> unregisteredUserList = getUserList("UnregisteredUser");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("data.csv"))) {
                for (RegisteredUser currentRegisteredUser : registeredUserList) {
                    //Gets Transport, Food and Home objets from currentRegisteredUser
                    String transportString = currentRegisteredUser.getTransportEmission().getString();
                    String foodString = currentRegisteredUser.getFoodEmission().getString();
                    String homeString = currentRegisteredUser.getHomeEmission().getString();

                    bw.write("y," + transportString + foodString + homeString + currentRegisteredUser.getUsername() + "," + currentRegisteredUser.getPassword() + ",");
                    bw.newLine();
                }
                for (UnregisteredUser currentUnregistereduser: unregisteredUserList){
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
    public ArrayList getUserList(String userType) {
        ArrayList<User> tempList = new ArrayList<>();
        for (User currentUser : userList){
            if (currentUser.getClass().getSimpleName().equals(userType)){
                tempList.add(currentUser);
            }
        }
        return tempList;
    }
    public double getAverageFootprint(){
        double sum = 0;
        for (User currentUser : userList){
            sum = sum + currentUser.getFootprint();
        }
        return sum / userList.size();
    }
    public double getAverageTransportPrint(){
        double sum = 0;
        for (User currentUser : userList){
            sum = sum + currentUser.getTransportScore();
        }
        return sum / userList.size();
    }
    public double getAverageFoodPrint(){
        double sum = 0;
        for (User currentUser : userList){
            sum = sum + currentUser.getFoodScore();
        }
        return sum / userList.size();
    }
    public double getAverageHomePrint(){
        double sum = 0;
        for (User currentUser : userList){
            sum = sum + currentUser.getHomeScore();
        }
        return sum / userList.size();
    }
    public void addUser(Transport transportEmission, Food foodEmission, Home homeEmission){
        userList.add(new UnregisteredUser(transportEmission, foodEmission, homeEmission));
    }
    public void addUser (Transport transportEmission, Food foodEmission, Home homeEmission, String username, String password){
        userList.add(new RegisteredUser(transportEmission, foodEmission, homeEmission, username, password));
    }
    public String getCurrentUserName(){
        return currentUserName;
    }
    public void updateUser (Transport transportEmission, Food foodEmission, Home homeEmission){
        ArrayList<RegisteredUser> tempList = getUserList("RegisteredUser");
        for (RegisteredUser currentUser : tempList){
            if (currentUser.getUsername().equals(currentUserName)){
                currentUser.setTransport(transportEmission);
                currentUser.setFood(foodEmission);
                currentUser.setHome(homeEmission);
            }
        }
    }
    public boolean validateSignup(String user){
        ArrayList<RegisteredUser> registeredUserList = getUserList("RegisteredUser");
        for (RegisteredUser currentUser : registeredUserList){
            if (currentUser.getUsername().equals(user)){
                return false;
            }
        }
        return true;
    }
    public void addUser(User user){
        userList.add(user);
    }
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
    public RegisteredUser getCurrentUser(){
        ArrayList<RegisteredUser> registeredUserList = getUserList("RegisteredUser");
        for (RegisteredUser currentUser : registeredUserList){
            if (currentUser.getUsername().equals(currentUserName)){
                return currentUser;
            }
        }
        return null;
    }
}