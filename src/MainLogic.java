import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MainLogic {
    private static Scanner myScanner = new Scanner(System.in);
    private static HashMap<String, ArrayList> hashMap = new HashMap<>();
    private ArrayList<DataDao> dataDaoArrayList;
    private DataDao dataDto;
    private int selected = 0;
    private boolean exit;
    private String userName;
    private int removeIndex;

    public void showMenu() {
        System.out.println("Welcome to to-do list");
        System.out.println();
        System.out.println("Press 1 to Exit the program");
        System.out.println("Press 2 to Display to-do list");
        System.out.println("Press 3 to Add item to the list");
        System.out.println("Press 4 to Remove item from the list");

        System.out.println();
        System.out.println("Select an option");
        selected = myScanner.nextInt();
    }

    public void mainIteration() {
        while (!exit) {
            switch (selected) {
                case 1:
                    exit = true;
                    break;
                case 2:
                    showToDoList();
                    break;
                case 3:
                    addItem();
                    break;
                case 4:
                    System.out.println("Which task would you like to delete?");
                    System.out.println("Please enter the task ID (Which you can find by pressing 2 in the main menu)");
                    removeIndex = myScanner.nextInt();
                    removeFromList();
                    break;
                case 5:
                    showMenu();
                    break;
                default:
                    System.out.println("Please enter a valid option");
                    selected = 5;
            }
        }
    }
private void showToDoList() {
        int x = 1;
        try {
            ArrayList<DataDao> arrayListOfDao = hashMap.get(userName);
            for (DataDao dataDtoTask : arrayListOfDao) {
                System.out.println("Task id : " + x);
                System.out.println("Task description: " + dataDtoTask.getToDoDescription());
                System.out.println("Task: " + dataDtoTask.getToDO());
                System.out.println("Start date: " + dataDtoTask.getStartDate());
                System.out.println("End date: " + dataDtoTask.getEndDate());
                System.out.println("------------------------------------------------");
                x++;
            }
        }
        catch(Exception e){
            System.out.println("No data found");
        }
        selected = 5;
    }

    private void addItem() {
        dataDto = new DataDao();
        System.out.println("Enter the task description");
        dataDto.setToDoDescription(myScanner.next());
        System.out.println("Enter the task");
        dataDto.setToDO(myScanner.next());
        System.out.println("Enter the start date");
        dataDto.setStartDate(myScanner.next());
        System.out.println("Enter the end date");
        dataDto.setEndDate(myScanner.next());

        if (hashMap.get(userName) == null) {
            dataDaoArrayList = new ArrayList<>();
        } else {
            dataDaoArrayList = hashMap.get(userName);
        }
        dataDaoArrayList = new ArrayList<>();
        dataDaoArrayList.add(dataDto);
        hashMap.put(userName, dataDaoArrayList);
        selected = 5;
    }
    private void removeFromList() {
        ArrayList<DataDao> arrayListOfDao = hashMap.get(userName);
        try{
            arrayListOfDao.remove(removeIndex -1);
        }
        catch (NullPointerException e){
            System.out.println("No such task was found");
        }
        selected = 5;
    }
    public void login() {
        ArrayList<String> users = new ArrayList<>();
        System.out.println("Do you already have an account?");
        System.out.println("1 = yes, I have an account. 2 = no, I want to create one");
        int hasAccount = myScanner.nextInt();
        if (hasAccount == 1) {
            System.out.println("Enter your User Name");
            this.userName = new Scanner(System.in).next();
        }
        else{
            System.out.println("We will create a new account");
            System.out.println("Enter the user name to be created");
            users.add(myScanner.next());
            System.out.println("Enter the password to be created");
        }
    }
    private void createAccount(){
        System.out.println("Enter your user name");
        this.userName = new Scanner(System.in).next();
    }
}
