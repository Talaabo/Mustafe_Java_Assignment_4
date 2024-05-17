package utility;

import java.util.Scanner;

public class Validator {
  
  public Validator() {
    // Constructor
  }

  public int selValidation(Ink ink, Scanner input, int min, int max) {
    boolean valid = false;
    int choice = 0;
    while (!valid) {
      ink.printMenu();
      try {
        choice = input.nextInt();
        if (choice >= min && choice <= max) {
          valid = true;
        } else {
          System.out.println("Selection out of range!");
        }
      } catch (Exception e) {
        System.out.println("Please read the menu and make a valid selection!");
        valid = false;
        input.nextLine(); // Clear the input buffer
      }
    }
    return choice;
  }

  public double fundValidation(Ink ink, Scanner input, double balance) {
    double amount = 0;
    boolean valid = false;
    while (!valid) {
      ink.printAddFunds(balance);
      try {
        amount = input.nextDouble();
        if (amount > 0) {
          valid = true;
        } else {
          System.out.println("Enter a positive number!");
        }
      } catch (Exception e) {
        System.out.println("Please enter a valid amount!");
        valid = false;
        input.nextLine(); // Clear the input buffer
      }
    }
    return amount;
  }

  public double depositValidation(Ink ink, Scanner input) {
    double depositAmount = 0;
    boolean valid = false;
    while (!valid) {
      ink.printAddFunds(0); // Assuming balance is 0 at the start
      try {
        depositAmount = input.nextDouble();
        if (depositAmount > 0) {
          valid = true;
        } else {
          System.out.println("Deposit amount must be greater than 0.");
        }
      } catch (Exception e) {
        System.out.println("Please enter a valid deposit amount!");
        valid = false;
        input.nextLine(); // Clear the input buffer
      }
    }
    return depositAmount;
  }

  public double withdrawValidation(Ink ink, Scanner input, double balance) {
    double withdrawAmount = 0;
    boolean valid = false;
    while (!valid) {
      ink.printWithdrawFunds(balance); // Use printWithdrawFunds to display withdrawal message
      try {
        withdrawAmount = input.nextDouble();
        if (withdrawAmount > 0 && withdrawAmount <= balance) {
          valid = true;
        } else if (withdrawAmount > balance) {
          System.out.println("Withdraw amount exceeds current balance!");
        } else {
          System.out.println("Enter a positive number!");
        }
      } catch (Exception e) {
        System.out.println("Please enter a valid amount!");
        valid = false;
        input.nextLine(); // Clear the input buffer
      }
    }
    return withdrawAmount;
  }
}