import java.util.*;


public class Main {
    static int usrH = 100;
    static int usrA = 20;
    static int enmH = 100;
    static int enmA = 10;

    public static void main(String[] args) {
        //prints
        System.out.println("Hello world!");
        System.out.println("what is your name?");
        
        // defines scanner
        System.out.print("INPUT: ");
        Scanner scn = new Scanner(System.in);
        String name = scn.nextLine(); // pauses code
        
        // prints the story
        System.out.println("Hello " + name + "!");
        System.out.println("Oh no! An enemy blocks your path! What do you do?");
        System.out.println("=========================================");
        battle("Weak Enemy");
    }

    public static void battle(String name){
        // boring dialoge nobody cares
        System.out.println("Your options are a (attack) or r (run)");
        System.out.println("=========================================");
        System.out.println("Your Health: " + usrH + "| Your Attack: " + usrA);
        System.out.println(name + "'s Health: " + enmH + " | " + name + "'s Attack: " + enmA);
        System.out.println("=========================================");
        
        // the fun part (your attack)
        Scanner scn = new Scanner(System.in);
        System.out.print("INPUT: ");
        String chosenInput = scn.nextLine(); // pauses code

        if (chosenInput.equals("a")) { // you chose attack
            System.out.println("You chose attack!");
            System.out.println("=========================================");
            System.out.println("press 1 for a low blow (attack + 50%, but 50% chance to fail)");
            System.out.println("press 2 for a high blow (attack + 0%, but 0% chance to fail)");
            System.out.println("=========================================");
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
                System.out.println("It works!");
                System.out.println("You swallow your pride and escape unharmed");
            } else {
                System.out.println("It fails!");
                System.out.println("The enemy attacks you for your cowardice!");
                updateHealth(10, 0);
            }
        }

        // wow that was a lot, now let's do the enemy's attack
        

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
