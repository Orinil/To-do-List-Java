public class Main {

    private static MainLogic mainLogic;

    public static void main(String[] args) {
        mainLogic = new MainLogic();
        //mainLogic.createNewAccount();
        mainLogic.login();
        mainLogic.showMenu();
        mainLogic.mainIteration();
    }
}