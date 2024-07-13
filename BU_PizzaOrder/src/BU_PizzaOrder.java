import java.util.Scanner;  // Needed for the Scanner class

/**Lab assignment 3
 * Modified by Bhuwan Upadhyaya
 * Date: 2/3/2024
   This program allows the user to order a pizza.
   * 
   * Before placing an order for pizza the program will ask user following things:
   * Show the user menu about pizza and cost
   * Ask the user about crust type
   * Ask about extra toppings
   * Check if user is eligible for discount
   * Calculate the total price of the pizza
   * place an order
   * 
*/
public class BU_PizzaOrder
{
   public static void main (String[] args)
   {
      // Create a Scanner object to read input.
      Scanner keyboard = new Scanner (System.in);

      String firstName;              // User's first name
      boolean discount = false;      // Flag for discount
      int inches;                    // Size of the pizza
      char crustType;                // For type of crust
      String crust = "Hand-tossed";  // Name of crust
      double cost = 14.99;           // Cost of the pizza
      final double TAX_RATE = .085;  // Sales tax rate
      double tax;                    // Amount of tax
      char choice;                   // User's choice
      String input;                  // User input
      String toppings = "Cheese ";   // List of toppings
      int numberOfToppings = 0;      // Number of toppings

      // Prompt user and get first name.
      System.out.println("Welcome to Mike and Diane's Pizza");
      System.out.print("Enter your first name: ");
      firstName = keyboard.nextLine();

      // Determine if user is eligible for discount by
      // having the same first name as one of the owners.
      // ADD LINES HERE FOR TASK #1
      if(firstName.equalsIgnoreCase("Mike")|| firstName.equalsIgnoreCase("Diane"))
      {
          discount = true;  // if any of the name mathes we set the flag to true
      }

      // Prompt user and get pizza size choice.
      System.out.println("Pizza Size (inches)  Cost");
      System.out.println("       10          $13.99");
      System.out.println("       12          $14.99");
      System.out.println("       14          $16.99");
      System.out.println("       16          $18.99");
      System.out.println("What size pizza would you like?");
      System.out.print("10, 12, 14, or 16 (enter the number only): ");
      inches = keyboard.nextInt();

      // Set price and size of pizza ordered.
      // ADD LINES HERE FOR TASK #2
      if (inches == 10)
      {
          cost = 13.99;
      }
      else if (inches == 12)
      {
          cost = 14.99;
      }
      else if (inches == 14)
      {
          cost = 16.99;
      }
      else if (inches == 16)
      {
          cost = 18.99;
      }
      else
      {
          System.out.println("Invalid input, So a 12 inches pizza will be made for you");
          inches = 12;
          cost = 14.99;
      }

      // Consume the remaining newline character.
      keyboard.nextLine();

      // Prompt user and get crust choice.
      System.out.println("What type of crust " +
                         "do you want? ");
      System.out.print("(H) Hand-tossed, " +
                       "(T) Thin-crust, or " +
                       "(D) Deep-dish " +
                       "(enter H, T, or D): ");
      input = keyboard.nextLine();
      //crustType = input.charAt(0);  
      crustType = Character.toUpperCase(input.charAt(0));  //This line is just altenate to the previous line
      // it will convert the character to upper case no matter what user input is. 

      // Set user's crust choice on pizza ordered.
      // ADD LINES FOR TASK #3
      switch(crustType)
      {
         case 'H':  //if user chooses H
         crust = "Hand-tossed";
         break;
         case 'T':  //if user chooses T
         crust = "Thin-crust";
         break;
         case 'D':  //if user chooses D
         crust = "Deep-dish";
         break;
         default:  //if user chooses other options
         System.out.println("Invalid input. So, hand-tossed crust will be choosen.");
         crust = "Hand-tossed";
         crustType = 'H';
          
      }

      // Prompt user and get topping choices one at a time.
      System.out.println("All pizzas come with cheese.");
      System.out.println("Additional toppings are " +
                         "$1.75 each, choose from:");
      System.out.println("Pepperoni, Sausage, Onion, " +
                         "Mushroom, Anchovies, or Extra Cheese");

      // If one or more toppings are desired,
      // add to topping list and number of toppings.
      System.out.print("Do you want Pepperoni? (Y/N): ");
      input = keyboard.nextLine();
      choice = input.charAt(0);
      if (choice == 'Y' || choice == 'y')
      {
         numberOfToppings += 1;
         toppings = toppings + "Pepperoni ";
      }
      System.out.print("Do you want Sausage? (Y/N): ");
      input = keyboard.nextLine();
      choice = input.charAt(0);
      if (choice == 'Y' || choice == 'y')
      {
         numberOfToppings += 1;
         toppings = toppings + "Sausage ";
      }
      System.out.print("Do you want Onion? (Y/N): ");
      input = keyboard.nextLine();
      choice = input.charAt(0);
      if (choice == 'Y' || choice == 'y')
      {
         numberOfToppings += 1;
         toppings = toppings + "Onion ";
      }
      System.out.print("Do you want Mushroom? (Y/N): ");
      input = keyboard.nextLine();
      choice = input.charAt(0);
      if (choice == 'Y' || choice == 'y')
      {
         numberOfToppings += 1;
         toppings = toppings + "Mushroom ";
      }
      System.out.print("Do you want Anchovies? (Y/N): ");
      input = keyboard.nextLine();
      choice = input.charAt(0);
      if (choice == 'Y' || choice == 'y')
      {
         numberOfToppings += 1;
         toppings = toppings + "Anchovies ";
      }
      System.out.print("Do you want Extra Cheese? (Y/N): ");
      input = keyboard.nextLine();
      choice = input.charAt(0);
      if (choice == 'Y' || choice == 'y')
      {
         numberOfToppings += 1;
         toppings = toppings + "Extra Cheese ";
      }

      // Add additional toppings cost to the cost of pizza.
      cost = cost + (1.75 * numberOfToppings);

      // Display order confirmation.
      System.out.println();
      System.out.println("Your order is as follows: ");
      System.out.println(inches + " inch pizza");
      System.out.println(crust + " crust");
      System.out.println(toppings);

      // Apply discount if user is eligible.
      // ADD LINES FOR TASK #4 HERE
      if(discount == true)
      {
          System.out.println("Congratulations!! You are eligible for $ 2.50 discount.");
          cost = cost - 2.50;
      }

      // EDIT PROGRAM FOR TASK #5
      // SO ALL MONEY OUTPUT APPEARS WITH 2 DECIMAL PLACES
      System.out.printf("The cost of your order is: $ %.2f.\n", cost);

      // Calculate and display tax and total cost.
      tax = cost * TAX_RATE;
      System.out.printf("The tax is: $ %.2f.\n", tax);
      System.out.printf("The total due is: $ %.2f.\n", (tax + cost));

      System.out.println("Your order will be ready " +
                         "for pickup in 42 minutes.");
   }
}