/*
* Warner Nielsen
* Project 02
* 1/23/19
* Garth Sorenson
* CS 2420
* */

import java.util.Scanner;

/*
*   This class combines three different methods from three different problems from the book
*       Exercise #3 pg 189 - Java method only
*       Exercise #19 pg 193
*       Programming Problem #2 pg 195
*   Each of the methods will have their own comments to explain what they do. They will be combined
*   using the single main() method as described below
* */
public class NielWarnProj02 {
    // Menu driven main method in while loop that allows user to select one of three methods to try or quit
    public static void main(String[] args) {
        boolean again = false; // boolean to run the while loop again
        int choice;

        // Welcome message
        System.out.println("Welcome to the Conglomeration of Java Methods Program!");
        System.out.println("Use the menu to make your selection of which \nJava method you would like to run.");

        do {
            // display menu choices
            System.out.println("\nMenu: ");
            System.out.println("\t1 - Run the 'Organizing a Parade' method");
            System.out.println("\t2 - Run the 'Rabbits' method");
            System.out.println("\t3 - Run the 'Double Your Pay' method");
            System.out.println("\t4 - Quit");

            // create new scanner to hold the user choice for which menu option they want to run
            Scanner input = new Scanner(System.in);

            System.out.print("Enter choice: ");
            choice = input.nextInt();

            // switch statement for user choice from menu options, each choice will run a different method
            switch (choice) {
                case 1:
                    int paradeTotal;
                    int numOfParadeCombos;
                    System.out.print("Please enter how many parades you would like to run: ");
                    paradeTotal = input.nextInt();

                    numOfParadeCombos = paradeCombos(paradeTotal);

                    System.out.println("There are " + numOfParadeCombos + " parade combos made from " + paradeTotal + " parades.");
                    break;
                case 2:
                    System.out.println("The problem in the book says to run the rabbit problem for 4 rabbits.");
                    System.out.println("The method prints the recursive process to show how many times it enters the");
                    System.out.println("recursive problem and will return the value for how many babies 4 rabbits will have.\n");

                    rabbit(8, 1);
                    break;
                case 3:
                    int cents;
                    int day;
                    System.out.println("This method will return how much money you could earn on a day (1-30)");
                    System.out.println("during no particular month if the wages from the previous day were doubled.");
                    System.out.print("Please enter an integer (1-30) that represents a day: ");
                    day = input.nextInt();
                    // this while loop here to validate that a user enters an integer between 1 and 30 and allows them to re-enter if not
                    while (day < 1 || day > 30) {
                        System.out.println("Input not valid. Please try again...");
                        System.out.print("Please enter an integer (1-30) that represents a day: ");
                        day = input.nextInt();
                    }
                    cents = jobPayDoubler(day); // output saved to variable cents to be used below

                    // Program prints how many cents user can earn on particular day, it also converts and prints how many dollars that represents
                    System.out.println("On day " + day + " you could earn " + cents + " cents.");
                    System.out.println("That's " + cents/100 + " dollars.");
                    break;
                case 4:
                    again = true;
                    break;
                default:
                    System.out.println("Invalid choice, try again...");
            }
        } while(!again);
    }

    /*
    *   This method will use a recursive solution to solve the 'Organizing a Parade' problem found on pg 161
    *   the parameter is the number of parades to be configured
    *   the output is an int that determines how many parade combos possible
    * */
    public static int paradeCombos(int numOfParades) {
        // If there is less than one Parade, return one
        if (numOfParades < 1) {
            return 1;
        }
        // Otherwise, n-1 > 0 and n - 2 > 0
        else {
            /*  This add the recursive solution of n-1 parades + n - 2 parades
             *  Parade of length 1 returns 2 combos (a float and a band)
             *  Parade of length 2 returns 3 combos (float-float, band-float, float-band)
             */
            return paradeCombos(numOfParades - 1) + paradeCombos(numOfParades - 2);
        }
    }

    /*  rabbit() method used to show population growth of rabbits, when they are born they don't have any offspring
     *  for two cycles, then they have two babies, it gets out of control
     *  the parameters are the number of rabbits to have babies and how many levels deep the method goes recursively
     *  the method returns an int that represents the number of rabbits birthed given n rabbits
     */
    public static int rabbit(int n, int level) {
        String tab = ""; // String tab to handle tabs indentation for each time method is run
        int curRabbit = 0; // this variable is used to keep track of which level of rabbit is being run

        // for loop to keep track of how many tabs a line has according to its level of the recursion
        for (int i = 0; i < level -1; ++i) {
            tab += "\t";
        }

        // print statement to let the user know the method is entering the rabbit() method
        System.out.println(tab + "Enter rabbit:\tn = " + n);
        // base case the returns 1 because a rabbit has to wait two cycles before it has babies
        if (n <= 2) {
            // print statement that says it is leaving the current rabbit() method, its value is 1
            System.out.println(tab + "Leave rabbit:\tn = " + n + "\t value = 1");
            return 1;
        }
        // if n > 2 then it executes rabbit() recursively
        else {
            // the recursive method's value is assigned to the current rabbit variable
            // level is increased by 1 because the method is run one time and increments each time it's run
            curRabbit =  rabbit(n - 1, level + 1) + rabbit(n-2, level + 1);

            System.out.println(tab + "Leave rabbit:\tn = " + n + "\t value = " + (n - 1));
            return curRabbit;
        }
    }

    /*
    *   This method recursively doubles the pay from the previous day in no particular month. The first day
    *   starts with one cent, second day two cents, third day four cents, etc. It takes an int value
    *   to represent the day of the month, and returns the int amount after it's calculated.
    * */
    public static int jobPayDoubler(int day) {
        // if the day is 1 or less it returns one
        if (day <= 1) {
            return 1;
        }
        // otherwise it returns 2 * the recursive method of the day - 1
        else {
            return 2 * jobPayDoubler(day - 1);
        }
    }
}
