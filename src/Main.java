import java.util.*;
import java.util.concurrent.TimeUnit;


public class Main {
    static int usrH = 100;
    static int usrA = 20;
    static int enmH = 100;
    static int enmA = 10;

    public static void main(String[] args) {
        //prints
        System.out.println("Hello world! \nwhat is your name?");
        
        // defines scanner
        System.out.print("INPUT: ");
        Scanner scn = new Scanner(System.in);
        String name = scn.nextLine(); // pauses code
        
        // prints the story
        System.out.println("Hello " + name + "! \nOh no! An enemy blocks your path! What do you do? \n=========================================");
        battle("Weak Enemy");
    }

    public static void battle(String name){
        // boring dialoge nobody cares
        System.out.println("Your options are a (attack) or r (run) \n========================================= \nYour Health: " + usrH + " | Your Attack: " + usrA);
        System.out.println(name + "'s Health: " + enmH + " | " + name + "'s Attack: " + enmA + "\n=========================================");
        
        // the fun part (your attack)
        Scanner scn = new Scanner(System.in);
        System.out.print("INPUT: ");
        String chosenInput = scn.nextLine(); // pauses code

        if (chosenInput.equals("a")) { // you chose attack
            System.out.println("You chose attack! \n========================================= \npress 1 for a low blow (attack + 50%, but 50% chance to fail) \npress 2 for a high blow (attack + 0%, but 0% chance to fail) \n=========================================");
            System.out.print("INPUT: ");
            String chosenAttack = scn.nextLine(); // pauses code
            if (chosenAttack.equals("1")){
                double rand_doub1 = Math.random();
                if (rand_doub1 >= 0.5){
                    System.out.println("It hits!");
                    updateHealth(0, 30);
                } else {
                    System.out.println("It fails!");
                    updateHealth(0, 0);
                }
            } if (chosenAttack.equals("2")){
                updateHealth(0, 20);
            }
        } if (chosenInput.equals("r")) { // you chose run
            double rand_doub1 = Math.random();
            if (rand_doub1 >= 0.5){
                System.out.println("It works! \nYou swallow your pride and escape unharmed");
            } if (rand_doub1 <= 0.5) {
                System.out.println("It fails!");
            }
        }

        // wow that was a lot, now the enemy's attack 
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("\n \n \n========================================= \nThe enemy readies an attack!");
        double rand_doub2 = Math.random();
        if (rand_doub2 >= 0.5){
            System.out.println("It hits!");
            updateHealth(enmA, 0);
        } else if (rand_doub2 <= 0.2){
            System.out.println("It hits! And it crits!");
            updateHealth(enmA+20, 0);
        } else {
            System.out.println("It fails!");
            updateHealth(0, 0);
        }
        
        if (usrH <= 0 || enmH <= 0){
            
        }
        battle(name);
    }

    public static void updateHealth(int h, int h2){
        System.out.println("=========================================");
        usrH -= h;
        System.out.println("Your Health: " + usrH + "| Your Attack: " + 20);
        enmH -= h2;
        System.out.println("Enemy's Health: " + enmH + " | Enemy's' Attack: " + 10);
        System.out.println("=========================================");
    }
}
