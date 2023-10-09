import java.util.ArrayList;
public class User {
private int name;
private double homeScore;
private ArrayList<Double> homeValues;
private int foodScore;

private ArrayList<Integer> foodValues;
private int transportScore;
private ArrayList<Integer> transportValues;

public User(ArrayList homeValues, ArrayList transportValues, ArrayList foodValues){
    this.homeValues = homeValues;
    this.foodValues = foodValues;
    this.transportValues = transportValues;
}

public void updateScores(){
    //this.foodScore = (foodValues.get(1));
    this.homeScore = (((homeValues.get(0)*13+homeValues.get(1)*13))/homeValues.get(2));
    this.transportScore= (transportValues.get(0)*1100+transportValues.get(1)*4400+transportValues.get(2));
}
public void showScores(){
    System.out.println("Tu emision en tu hogar es de: " + this.homeScore);
    System.out.println("Tu emision en tu transporte es de: " + this.transportScore);
}

}
