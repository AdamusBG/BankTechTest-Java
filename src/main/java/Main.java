import Entities.Account;

public class Main {
    public static void main(String[] args) {
        Account myAccount = new Account();

        myAccount.deposit("01/03/2021", 1000);
        myAccount.withdraw("01/03/2021", 27.34);
        myAccount.withdraw("02/03/2021", 30.00);
        myAccount.deposit("03/03/2021", 150.00);

        myAccount.statement();

        // uncomment the below to see example of incorrect date message
        // myAccount.withdraw("41/03/2021", 20.00);

        // uncomment the below to see example of amount must be positive message
        // myAccount.withdraw("03/03/2021" -100);

        // uncomment the below to see example of not enough balance method
        // myAccount.withdraw("03/03/2021" 5000);
    }
}
