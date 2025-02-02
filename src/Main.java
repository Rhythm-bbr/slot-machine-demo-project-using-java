import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int balance = 100;
        String playAgain;
        int updatedAmountOne;
        int updated;
        String[] chose;
        int x;
        int count = 0;

        System.out.println("***************************");
        System.out.println(" The slot machine game");
        do {
            System.out.println("***************************");
            System.out.print("How much money do you want to bet : ");
            int bet = input.nextInt();
            System.out.println("***************************");

            do {
                if (bet > balance) {
                    System.out.println("Your balance amount is less then your bet amount \n    BET LESS PLEASE");
                    System.out.println("***************************");
                    System.out.print("How much money do you want to bet : ");
                    bet = input.nextInt();
                } else {
                    x = balance -= bet;
                    System.out.println(x);
                    break;
                }
            } while (bet < balance);

            System.out.println("spinning................... \nspinning........... \nspinning......");
            String[] storage = {"A", "B", "C"};
            chose = new String[3];

            for (int i = 0; i < storage.length; i++) {
                chose[i] = storage[random.nextInt(storage.length)];
            }
            System.out.println(chose[0] + " | " + chose[1] + " | " + chose[2]);

            if (chose[0].equals(chose[1]) && chose[1].equals(chose[2])) {
                updatedAmountOne = (bet * 5)- bet;
                int updatedBalance = balance += updatedAmountOne;
                System.out.println("You WON " + updatedAmountOne + "$");
                System.out.println("Updated Balance : " + updatedBalance + "$");
            }
            else if (chose[0].equals(chose[1]) || chose[1].equals(chose[2])) {
                updated =  (bet * 3) - bet;
                int updatedB = balance += updated;
                System.out.println("You Won " + updated + "$");
                System.out.println("updated Balance : " + updatedB + "$");
            }
            else {
                System.out.println("You lose");
                System.out.println("Your balance : " + balance + "$");
            }

            System.out.println("***************************");
            System.out.print("I think it's a lucky day\nWanna play again ?? :  ");
            Scanner scanner = new Scanner(System.in);

            playAgain = scanner.nextLine();
            System.out.println("***************************");

            do{
                if(!(playAgain.equalsIgnoreCase("no")) && !(playAgain.equalsIgnoreCase("yes"))){
                    System.out.print("Not sure what do you want please specify yes or no properly \n\nWanna try again ?? :  ");
                    playAgain = scanner.nextLine();
                }
            }while(!(playAgain.equalsIgnoreCase("no")) && !(playAgain.equalsIgnoreCase("yes")));
            count++;
        }while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Thank you for playing \n you played " + count + " times");
        System.out.println("Your final Balance is : " + balance + "$");
    }
}
