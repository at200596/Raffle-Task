package raffletask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.ArrayList;

public class RaffleTask {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<String> tickets = new ArrayList<>();

    public static void main(String[] args) {
        raffleSelect();
    }

    public static void raffleSelect() {

        try {
            System.out.println();
            System.out.println("Welcome to the Raffle \n Please make a selection");
            System.out.println("1: \"Purchase\" \n 2: \"Check\" \n 3: \"End\"");

            int menuSelection = Integer.parseInt(input.readLine());

            switch (menuSelection) {
                case (1):
                    rafflePurchase();
                    break;

                case (2):
                    raffleCheck();
                    break;

                case (3):
                    endOfRaffle();
                    break;

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void rafflePurchase() {

        try {

            Random rand = new Random();
            int count = 1;

            System.out.println("You have chosen to purchase a ticket");
            System.out.println("Please enter your first name");
            String name = input.readLine();

            int randomNumber = rand.nextInt(400);

            tickets.add(name + "," + randomNumber);

            System.out.println(tickets);

            System.out.println("Your raffle ticket number is: " + randomNumber);

            raffleSelect();
        } catch (Exception e) {
            System.out.println(e);
        }
        return;

    }

    public static void raffleCheck() {

        try {

            System.out.println("You have chosen to check your raffle ticket");
            System.out.println("What is your name?");
            String checkName = input.readLine();

            System.out.println("What is your raffle ticket number");
            String checkNumber = input.readLine();

//            raffleCheck(tickets);
            int ticketsLength = tickets.size();

            for (int i = 0; i < ticketsLength; i++) {
                String nameAndTickets = tickets.get(i);
                String[] names = nameAndTickets.split(",");

                if (checkName.equals(names[0])) {

                    if (checkNumber.equals(names[1])) {
                        System.out.println("Your raffle number is " + names[1]);

                        int raffleNumber = Integer.parseInt(names[1]);

                        boolean prime = true;
                        for (int j = 2; j <= raffleNumber / 2; j++) {
                            if ((raffleNumber % j) == 0) {
                                System.out.println("Your number is not prime");
                                System.out.println("You have not won the raffle");
                                System.out.println("Better luck next time!");
                            }else{
                                System.out.println("Your number is prime!");
                                System.out.println("You have won the raffle!");
                                System.out.println("Well done!");
                            }
                            raffleSelect();
                            }
                        
                        }
                    }
                }

            }catch(Exception e){
            System.out.println(e);
        }
        }
    

    public static void endOfRaffle() {
        System.out.println();
        System.out.println("Thank you for playing the raffle");
        System.exit(0);

    }

}
