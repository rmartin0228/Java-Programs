/*
Rylan Martin - CH2 Required Program - 02.04.2020

This program will give the user a description of the five (5) items we sell, it will prompt the user for how much of each supply they would like to buy, and it will ask for the users GPA to determine whether or not the user is a good student or not.
*/
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //New Scanner
    Scanner storeInput = new Scanner(System.in);

    //Declare Variables
    double costOfPencils; //Cost of Pencils based on amount customer buys
    int amountOfPencils; //Amount of Pencils customer wants
    double costOfPens; //Cost of Pens based on amount customer buys
    int amountOfPens; //Amount of Pens customer wants
    double costOfShirt; //Cost of Shirt based on amount customer buys
    int amountOfShirt; //Amount of Shirts customer wants
    double costOfBook; //Cost of Books based on amount customer buys
    int amountOfBook; //Amount of Books customer wants
    double costOfBackpack; //Cost of Backpack based on amount customer buys
    int amountOfBackpack; //Amount of Backpacks customer wants
    double gpa; //GPA entered by user
    int totalItemsPurchased; //Amount of items purchased by customer
    final double tax = .08125; //Set amount of tax
    double totalCost; //Total cost the entire order
    double amountOff; //Amount to take off totalCost if user is a good student
    double salesTax;

    //Description of store
    System.out.println("Welcome to Rylan's Office Supplies!\nWe sell a plethora of different office supply items for everyone to use! This program will give the user a description of the five (5) items we sell, it will prompt the user for how much of each supply they would like to buy, and it will ask for the users GPA to determine whether or not the user is a good student or not.\n\n");

    //Description of Pencil, Amount of Pencils, and Cost 
    System.out.println("Pencils ($1.00 / pencil)\nOur pencils are some of the best in the business. We offer quality graphite with the slimmest build for some of the best quality in marking, writing, or whatever the case may be!\n\n");
    System.out.print("How many pencils would you like to purchase?: ");
    amountOfPencils = storeInput.nextInt();
    costOfPencils = amountOfPencils * 1.00;

    //Description of Pen, Amount of Pens, and Cost
    System.out.println("\n\nPens ($2.25 / pen)\nOur pens offer high quality ink with a ball-point tip for effortless writing and marking.\n\n");
    System.out.print("How many pens would you like to purchase?: ");
    amountOfPens = storeInput.nextInt();
    costOfPens = amountOfPens * 2.25;

    //Description of Shirt, Amount of Shirts, and Cost
    System.out.println("\n\nShirts ($10.00 / shirt)\nGet some custom \"Rylan's Office Supplies\" t-shirt to rock with any of the other supplies you buy from our store! Our shirts offer a premium fit with some of the best quality out there.\n\n");
    System.out.print("How many shirts would you like to purchase?: ");
    amountOfShirt = storeInput.nextInt();
    costOfShirt = amountOfShirt * 10.00;

    //Description of Book, Amount of Books, and Cost
    System.out.println("\n\nBooks ($24.99 / book)\nHere at Rylan's Office Supplies, we sell all sorts of books for every students need. Our book selection ranges from a multitude of different subjects from Archaeology to Zoo Keeping!\n\n");
    System.out.print("How many books would you like to purchase?: ");
    amountOfBook = storeInput.nextInt();
    costOfBook = amountOfBook * 24.99;

    //Description of Backpack, Amount of Backpacks, and Cost
    System.out.println("\n\nBackpacks ($14.99 / backpack)\nFinally, The backpacks we offer have the highest rating of all of our competitors. Our backpacks can hold everything and some change. They are packed with enough space, yet very stylish and comfortable to wear.\n\n");
    System.out.print("How many backpacks would you like to purchase?: ");
    amountOfBackpack = storeInput.nextInt();
    costOfBackpack = amountOfBackpack * 14.99;

    //Calculate totalItemsPurchased and Print total amount of items being purchased in total
    totalItemsPurchased = amountOfPencils + amountOfPens + amountOfShirt + amountOfBook + amountOfBackpack;  
    System.out.println("\nYou are ordering " + totalItemsPurchased + " items.\n");

    //Calculate totalCost
    totalCost = costOfPencils + costOfPens + costOfShirt + costOfBook + costOfBackpack;

    //Determine if user is a good or bad student based on GPA
    System.out.println("Good News! You may qualify for a 2% discount on your order! The only thing we need to know if your GPA. What is your GPA?: ");
    gpa = storeInput.nextDouble();
    if (gpa >= 2.5) {
      System.out.print("\nCongratulations! You qualify for the discount! We will add it to your order now.");
      amountOff = totalCost * 0.02;
      salesTax = totalCost * tax;
      totalCost = (totalCost - amountOff) + salesTax; //Calculate totalCost with discount and tax
    }
    else {
      System.out.println("\nUnfortunately, you do not qualify for the discount.");
      salesTax = totalCost * tax;
      totalCost += salesTax; //Calculate totalCost with tax only
    }

    //Print total cost of all items together with discount and tax
    System.out.printf("The total cost of your order is: $%.2f", totalCost);
  }
}
