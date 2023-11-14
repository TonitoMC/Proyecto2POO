import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Controller Class for carbon footprint calculator, manages both Model and View Class for functionality
 * between Model Class and View Class.
 * @author Jose Merida, Sophié Cleaves
 * @version 1.0
 * @since 13-11-2023
 */
public class Controller implements ActionListener {
    private View mainView;
    private Model mainModel;
    /**
     * Constructor for Controller Class. Creates new controller, sets View & model, adds action listener and instructs
     * Model to read data from CSV file.
     * @param mainView The View object to be controlled
     * @param mainModel The Model object to be controlled
     */
    public Controller(View mainView, Model mainModel){
        this.mainView = mainView;
        this.mainModel = mainModel;
        mainView.addActionListener(this);
        mainModel.readCSV();
    }
    /**
     * Gets a Transport object based on the user entries in the GUI text fields
     * @return Transport object with the specified attributes
     */
    public Transport getTransport(){
        return new Transport(mainView.getCarMoney(), mainView.getBikeMoney(), mainView.getFlightHours());
    }
    /**
     * Gets a Home object based on the user entries in the GUI text fields
     * @return Home object with the specified attributes
     */
    public Home getHome(){
        return new Home(mainView.getElectricity(), mainView.getGas(), mainView.getHouseMates(), mainView.doesRecycle());
    }
    /**
     * Gets a Food object based on the user entries in the GUI text fields
     * @return Food object with the specified attributes
     */
    public Food getFood(){
        return new Food(mainView.getMeatPortions(), mainView.getChickenPortions(), mainView.getPorkPortions(), mainView.getFishPortions(), mainView.getDairyPortions());
    }
    /**
     * Processes button presses by the user in the GUI
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e){
        /**
         * Whenever the Register button is pressed, a pop-up window shows in the GUI requesting text input
         * for username and password, a new RegisteredUser is created and added to the Database.
         * Also updates currentUser to the RegisteredUser that has just been created, the text fields MUST be filled
         * out before a new user is Registered.
         */
        if (e.getSource() == mainView.getRegisterButton()){
            /**
             * Creates username and password Strings based on user input from GUI pop-up window.
             */
            String signup = mainView.getSignup();
            String[] signupData = signup.split(",");
            ArrayList<String> tempList = new ArrayList<>();
            for (String field : signupData){
                tempList.add(field);
            }
            String username = tempList.get(0);
            String password = tempList.get(1);
            /**
             * Validates the Signup (Making sure there's no other user with the same Username), creates user, adds it
             * to Database, sets currentUser and displays carbon footprint calculation. If the signup isn't validated
             * shows user a pop-up saying Username is taken.
             */
            if (mainModel.validateSignup(username)){
                RegisteredUser currentUser = new RegisteredUser(getTransport(), getFood(), getHome(), username, password);
                mainModel.addUser(currentUser);
                mainModel.setCurrentUser(tempList.get(0));
                displayData(currentUser);
                mainModel.writeCSV();
            } else {
                mainView.popUp("Nombre de usuario ya existente, pruebe otro");
            }
        }
        /**
         * Whenever the login button is pressed, a pop-up window shows in GUI requesting text input for Username and
         * Password. The log-in credentials are validated and currentUser is set.
         */
        if (e.getSource() == mainView.getLoginButton()){
            /**
             * Creates username and password Strings based on user input from the pop-up window.
             */
            String login = mainView.getLogin();
            String[] loginData = login.split(",");
            ArrayList<String> tempList = new ArrayList<>();
            for (String field : loginData) {
                tempList.add(field);
            }
            /**
             * Validates the login credentials, if they're validated currentUser is updated. Else, creates new popup
             * saying the login credentials are invalid.
             */
            boolean validLogin = mainModel.validateLogin(tempList.get(0),tempList.get(1));
            if (validLogin){
                mainModel.setCurrentUser(tempList.get(0));
            } else{
                mainView.popUp("Credenciales invalidas");
            }
        }
        /**
         * Whenever the Calculate button is pressed, its verified whether the user is logged in or not. If the user
         * is logged in, the values are updated and carbon footprint calculation is shown. Else, a new Unregistered user
         * is created and carbon footprint calculation is shown.
         */
        if (e.getSource() == mainView.getCalculateButton()){
            /**
             * Verifies whether there's a User currently logged in.
             */
            if (mainModel.getLoginUser()!=null){
                /**
                 * Updates the User with data from GUI and updates CSV file.
                 */
                mainModel.updateUser(getTransport(), getFood(), getHome());
                RegisteredUser currentUser = mainModel.getLoginUser();
                displayData(currentUser);
                mainModel.writeCSV();
            } else {
                /**
                 * Creates a new User with data from GUI and updates CSV file.
                 */
                UnregisteredUser currentUser = new UnregisteredUser(getTransport(), getFood(), getHome());
                mainModel.addUser(currentUser);
                displayData(currentUser);
                mainModel.writeCSV();
            }
        }
    }

    /**
     * Tells View to show a new pop-up with carbon footprint calculations for a User as well as the average footprint
     * for the different categories.
     * @param currentUser The user we want to display information about.
     */
    public void displayData(User currentUser){
        mainView.popUp("Tu huella de Carbono: " + Math.round(currentUser.getFootprint()) + " | Promedio: " + Math.round(mainModel.getAverageFootprint())
                + "\nDe comida: " + Math.round(currentUser.getFoodScore()) + " | Promedio: " + Math.round(mainModel.getAverageFoodPrint())
                + "\nDe transporte: " + Math.round(currentUser.getTransportScore()) + " | Promedio: " + Math.round(mainModel.getAverageTransportPrint())
                + "\nEn casa: " + Math.round(currentUser.getHomeScore()) + " | Promedio: " + Math.round(mainModel.getAverageHomePrint()));
    }
}