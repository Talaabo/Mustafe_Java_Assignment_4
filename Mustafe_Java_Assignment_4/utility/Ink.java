package utility;
import java.util.ArrayList;

import objects.*;

public class Ink {
  
  public Ink() {
    // do nothing
  }

  public void printWelcome() {
    System.out.println("*** Welcome to StockUP beta ***\n");
  }

  public void printGoodday() {
    System.out.println("*** Richer Every Day with stockUP ***\n");
  }

  public void printStock(Stock stock) {
    System.out.printf("Name: %s\nSymbol: %s\nPrice: $%.2f",
      stock.getName(), stock.getSymbol(), stock.getPrice());
    System.out.println("\nHow many units of this stock would you like?? ");
  } // printStock()

  public void printPortfolio(ArrayList<Stock> stocks, double networth, 
    double balance) {
    for(int i = 0; i < stocks.size(); i++) {
      System.out.printf("(%d) Name: %s Symbol: %s Price: $%.2f Qty: %d\n",
        i + 1,
        stocks.get(i).getName(),
        stocks.get(i).getSymbol(),
        stocks.get(i).getPrice(),
        stocks.get(i).getQty());
    } // for
    System.out.printf("Networth: $%.2f\n", networth);
    System.out.printf("Balance: $%.2f\n", balance);
    
  } // printPortfolio()

  public void printMarket(ArrayList<Stock> stocks) {
    for(int i = 0; i < stocks.size(); i++) {
      System.out.printf("(%d) Name: %s Symbol: %s Price: $%.2f\n",
        i + 1,
        stocks.get(i).getName(),
        stocks.get(i).getSymbol(),
        stocks.get(i).getPrice());
    } // for
    System.out.println("Which stock would you like to buy?: ");
  } // printMarket()

  public void printMenu() {
    System.out.println("(1) Show Portfolio");
    System.out.println("(2) Show Stocks");
    System.out.println("(3) Add Funds");
    System.out.println("(4) Withdraw Funds");
    System.out.println("(5) Close Account (Sell All Stocks)");
    System.out.println("(6) stock swap (swap one stock for another)");
    System.out.println("(7) Exit");
  } // printMenu()

  public void printStockDetail(Stock stock) {
    System.out.printf("Name: %s Symbol: %s Price: %d Qty: %d",
      stock.getName(), stock.getSymbol(), 
      stock.getPrice(), stock.getQty());
  }

  public void printAddFunds(double balance) {
    System.out.printf("Current balance: $%.2f\nAmount to add?: ",balance);
  }
  public void printWithdrawFunds(double balance) {
    System.out.printf("Current balance: $%.2f\nAmount to Withdraw?: ", balance);
}

} // class