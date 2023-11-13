import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller implements ActionListener {
    private View mainView;
    private Model mainModel;
    public Controller(View mainView, Model mainModel){
        this.mainView = mainView;
        this.mainModel = mainModel;
        mainView.addActionListener(this);
        mainModel.readCSV();
    }
    public Transport getTransport(){
        return new Transport(mainView.getCarMoney(), mainView.getBikeMoney(), mainView.getFlightHours());
    }
    public Home getHome(){
        return new Home(mainView.getElectricity(), mainView.getGas(), mainView.getHouseMates(), mainView.doesRecycle());
    }
    public Food getFood(){
        return new Food(mainView.getMeatPortions(), mainView.getChickenPortions(), mainView.getPorkPortions(), mainView.getFishPortions(), mainView.getDairyPortions());
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == mainView.getRegisterButton()){
            String signup = mainView.getSignup();
            String[] signupData = signup.split(",");
            ArrayList<String> tempList = new ArrayList<>();
            for (String field : signupData){
                tempList.add(field);
            }
            String username = tempList.get(0);
            String password = tempList.get(1);
            if (mainModel.validateSignup(username)){
                RegisteredUser currentUser = new RegisteredUser(getTransport(), getFood(), getHome(), username, password);
                mainModel.addUser(currentUser);
                mainModel.setCurrentUserName(tempList.get(0));
                displayData(currentUser);
            } else {
                mainView.popUp("Nombre de usuario ya existente, pruebe otro");
            }
        }
        if (e.getSource() == mainView.getLoginButton()){
            String login = mainView.getLogin();
            String[] loginData = login.split(",");
            ArrayList<String> tempList = new ArrayList<>();
            for (String field : loginData) {
                tempList.add(field);
            }
            boolean validLogin = mainModel.validateLogin(tempList.get(0),tempList.get(1));
            if (validLogin){
                mainModel.setCurrentUserName(tempList.get(0));
            }
        }
        if (e.getSource() == mainView.getCalculateButton()){
            if (!mainModel.validateSignup(mainModel.getCurrentUserName())){
                mainModel.updateUser(getTransport(), getFood(), getHome());
                RegisteredUser currentUser = mainModel.getCurrentUser();
                displayData(currentUser);
            } else {
                UnregisteredUser currentUser = new UnregisteredUser(getTransport(), getFood(), getHome());
                mainModel.addUser(currentUser);
                displayData(currentUser);
                mainModel.writeCSV();
            }
        }
    }
    public void displayData(User currentUser){
        mainView.popUp("Tu huella de Carbono: " + Math.round(currentUser.getFootprint()) + " | Promedio: " + Math.round(mainModel.getAverageFootprint())
                + "\nDe comida: " + Math.round(currentUser.getFoodScore()) + " | Promedio: " + Math.round(mainModel.getAverageFoodPrint())
                + "\nDe transporte: " + Math.round(currentUser.getTransportScore()) + " | Promedio: " + Math.round(mainModel.getAverageTransportPrint())
                + "\nEn casa: " + Math.round(currentUser.getHomeScore()) + " | Promedio: " + Math.round(mainModel.getAverageHomePrint()));
    }
}