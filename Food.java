public class Food implements EmissionCategory{
    private int meatPortions;
    private int chickenPortions;
    private int porkPortions;
    private int fishPortions;
    private int dairyPortions;
    public Food(int meatPortions, int chickenPortions, int porkPortions, int fishPortions, int dairyPortions){
        this.meatPortions = meatPortions;
        this.chickenPortions = chickenPortions;
        this.porkPortions = porkPortions;
        this.fishPortions = fishPortions;
        this.dairyPortions = dairyPortions;
    }
    public double getFootprint() {
        double dairyProportion = 0.5;
        return 4*(8.46 * meatPortions + 0.84 * chickenPortions + 1.05 * porkPortions + 1.16 * fishPortions + 0.576 * dairyPortions);
    }
    public int getMeatPortions(){
        return meatPortions;
    }
    public int getChickenPortions(){
        return chickenPortions;
    }
    public int getPorkPortions(){
        return porkPortions;
    }
    public int getFishPortions(){
        return fishPortions;
    }
    public int getDairyPortions(){
        return dairyPortions;
    }
    public String getString(){
        return meatPortions + "," + chickenPortions + "," + porkPortions + "," + fishPortions + "," + dairyPortions + ",";
    }
}