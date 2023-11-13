public class Main {
    public static void main(String[] args) {
        View mainView = new View();
        Model mainModel = new Model();
        new Controller(mainView, mainModel);
    }
}