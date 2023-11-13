import javax.swing.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    //Labels
    private JLabel titleLabel;
    private JLabel transportLabel;
    private JLabel homeLabel;
    private JLabel foodLabel;
    private JLabel monthlyGasLabel;
    private JLabel yearlyFlightsLabel;
    private JLabel weeklyFoodLabel;

    //buttons
    private JButton registerButton;
    private JButton loginButton;
    private JButton calculateButton;

    //Transport Entries
    private JTextField carMoneyTextField;
    private JTextField bikeMoneyTextField;
    private JTextField busDistanceTextField;
    private JTextField flightHoursTextField;

    private JLabel homeConsumptionLabel;
    private JLabel housematesAndRecycleLabel;

    //Home entries
    private JTextField electricityConsumptionField;
    private JTextField gasConsumptionField;
    private JTextField houseMatesField;
    private JCheckBox doesRecycleBox;

    private JLabel portionInfoLabel;
    private JLabel dairyPortionLabel;

    //Food entries
    private JTextField meatPortionsField;
    private JTextField chickenPortionsField;
    private JTextField porkPortionsField;
    private JTextField fishPortionsField;
    private JTextField dairyPortionsField;

    //Buttons

    public View(){
        //Sets title, size and closing operation
        this.setTitle("Calculadora de Huella de Carbono");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500,500);
        this.setVisible(true);
        this.setLayout(null);

        //Construction of elements of the GUI
        titleLabel = new JLabel("Huella de Carbono");
        transportLabel = new JLabel("Transporte");
        monthlyGasLabel = new JLabel("Gasto Mensual de Gasolina");
        yearlyFlightsLabel = new JLabel("Tiempo Anual en Vuelos");
        homeLabel = new JLabel("Casa");
        foodLabel = new JLabel("Comida Semanal");
        doesRecycleBox = new JCheckBox("Reciclo el Plastico");

        //Transport entries
        carMoneyTextField = new JTextField("Cantidad entera en Q (Carro)");
        bikeMoneyTextField = new JTextField("Cantidad entera en Q (Moto)");
        flightHoursTextField = new JTextField("Cantidad entera en Horas");

        //Home entries
        electricityConsumptionField = new JTextField("Consumo de Luz en kWH");
        gasConsumptionField = new JTextField("Consumo de Gas en LBs");
        houseMatesField = new JTextField("Numero de Personas");

        homeConsumptionLabel = new JLabel("Consumos Mensuales");
        housematesAndRecycleLabel = new JLabel("Residentes y Reciclaje");
        dairyPortionLabel = new JLabel("1 vaso de leche / 25g de queso");
        //Food entries
        meatPortionsField = new JTextField("Porciones de Carne");
        chickenPortionsField = new JTextField("Porciones de Pollo");
        porkPortionsField = new JTextField("Porciones de Cerdo");
        fishPortionsField = new JTextField("Porciones de Pescado");
        dairyPortionsField = new JTextField("Porciones de Lacteos");

        //Buttons

        loginButton = new JButton("Ingresar");
        registerButton = new JButton("Registrate");
        calculateButton = new JButton("Calcular");
        loginButton.setHorizontalAlignment(0);
        registerButton.setHorizontalAlignment(0);
        calculateButton.setHorizontalAlignment(0);

        portionInfoLabel = new JLabel("1 porcion es la palma de la mano");

        meatPortionsField.setHorizontalAlignment(0);
        chickenPortionsField.setHorizontalAlignment(0);
        porkPortionsField.setHorizontalAlignment(0);
        fishPortionsField.setHorizontalAlignment(0);
        dairyPortionsField.setHorizontalAlignment(0);

        carMoneyTextField.setHorizontalAlignment(0);
        bikeMoneyTextField.setHorizontalAlignment(0);
        flightHoursTextField.setHorizontalAlignment(0);
        monthlyGasLabel.setHorizontalAlignment(0);
        electricityConsumptionField.setHorizontalAlignment(0);
        gasConsumptionField.setHorizontalAlignment(0);
        houseMatesField.setHorizontalAlignment(0);


        //Adding components to the GUI
        add(titleLabel);
        add(foodLabel);
        add(transportLabel);
        add(homeLabel);
        add(carMoneyTextField);
        add(bikeMoneyTextField);
        add(flightHoursTextField);
        add(monthlyGasLabel);
        add(yearlyFlightsLabel);
        add(electricityConsumptionField);
        add(gasConsumptionField);
        add(houseMatesField);
        add(meatPortionsField);
        add(chickenPortionsField);
        add(porkPortionsField);
        add(fishPortionsField);
        add(dairyPortionsField);
        add (doesRecycleBox);
        add (loginButton);
        add (registerButton);
        add (calculateButton);
        add (homeConsumptionLabel);
        add (housematesAndRecycleLabel);
        add (portionInfoLabel);
        add (dairyPortionLabel);

        //Setting bounds and positions of the GUI components
        transportLabel.setBounds(90, 33, 70, 25);
        monthlyGasLabel.setBounds(35,60, 180, 20);
        carMoneyTextField.setBounds(35, 80, 180, 20);
        bikeMoneyTextField.setBounds(35,105,180,20);
        yearlyFlightsLabel.setBounds(55,123,140,25);
        flightHoursTextField.setBounds(35, 145, 180, 20);
        foodLabel.setBounds(73, 200, 100, 25);
        portionInfoLabel.setBounds(30, 215, 200, 40);
        meatPortionsField.setBounds(35, 250, 180, 20);
        chickenPortionsField.setBounds(35,280, 180, 20);
        porkPortionsField.setBounds(35, 310, 180, 20);
        fishPortionsField.setBounds(35, 340, 180, 20);



        dairyPortionLabel.setBounds(37,360, 180, 20);
        dairyPortionsField.setBounds(35, 380, 180, 20);
        homeLabel.setBounds(350, 35, 70, 25);
        electricityConsumptionField.setBounds(275, 80, 180, 20);
        gasConsumptionField.setBounds(275, 105, 180, 20);
        houseMatesField.setBounds(275, 145, 180, 20);
        doesRecycleBox.setBounds(275, 170, 180, 20);
        titleLabel.setBounds(200,10,105,25);
        loginButton.setBounds(320, 245, 100, 25);
        registerButton.setBounds(320, 280, 100, 25);
        calculateButton.setBounds(320, 315, 100, 25);
        homeConsumptionLabel.setBounds(300, 60, 180, 20);
        housematesAndRecycleLabel.setBounds(300, 123, 140, 25);
    }
    public void popUp(String text){
        JOptionPane.showMessageDialog(this, text);
    }

    public void addActionListener(ActionListener listener){
        registerButton.addActionListener(listener);
        loginButton.addActionListener(listener);
        calculateButton.addActionListener(listener);
        doesRecycleBox.addActionListener(listener);
    }
    public JButton getRegisterButton(){
        return registerButton;
    }
    public JButton getLoginButton(){
        return loginButton;
    }
    public JButton getCalculateButton(){
        return calculateButton;
    }
    public int getCarMoney(){
        return Integer.parseInt(carMoneyTextField.getText());
    }
    public int getBikeMoney(){
        return Integer.parseInt(bikeMoneyTextField.getText());
    }
    public int getFlightHours(){
        return Integer.parseInt(flightHoursTextField.getText());
    }
    public int getMeatPortions(){
        return Integer.parseInt(meatPortionsField.getText());
    }
    public int getChickenPortions(){
        return Integer.parseInt(chickenPortionsField.getText());
    }
    public int getPorkPortions(){
        return Integer.parseInt(porkPortionsField.getText());
    }
    public int getFishPortions(){
        return Integer.parseInt(fishPortionsField.getText());
    }
    public int getDairyPortions(){
        return Integer.parseInt(dairyPortionsField.getText());
    }
    public int getElectricity(){
        return Integer.parseInt(electricityConsumptionField.getText());
    }
    public boolean doesRecycle(){
        return doesRecycleBox.isSelected();
    }
    public int getGas(){
        return Integer.parseInt(gasConsumptionField.getText());
    }
    public int getHouseMates(){
        return Integer.parseInt(houseMatesField.getText());
    }
    public String getSignup(){
        JTextField userField = new JTextField();
        JTextField passwordField = new JTextField();
        Object[] fields = {"Nombre de Usuario", userField, "Contrasena",passwordField};
        JOptionPane.showConfirmDialog(null, fields, "Ingrese usuario y contrasena", JOptionPane.OK_CANCEL_OPTION);
        return userField.getText() + "," + passwordField.getText();
    }
    public String getLogin(){
        JTextField userField = new JTextField();
        JTextField passwordField = new JTextField();
        Object[] fields = {"Nombre de Usuario", userField, "Contrasena",passwordField};
        JOptionPane.showConfirmDialog(null, fields, "Ingrese usuario y contrasena", JOptionPane.OK_CANCEL_OPTION);
        return userField.getText() + "," + passwordField.getText();
    }
}
