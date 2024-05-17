package objects;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Portfolio {

    private Calendar openDate = Calendar.getInstance();
    private Calendar closeDate;
    private double balance;
    private ArrayList<Stock> stocks = new ArrayList<>();

    public Portfolio(double deposit) {
        if (deposit >= 0) {
            this.balance = deposit;
        } else {
            throw new IllegalArgumentException("Deposit amount must be non-negative or greater than 0.");
        }
    }

    public String getOpenDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.format(openDate.getTime());
    }

    public String getCloseDate() {
        if (closeDate != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            return dateFormat.format(closeDate.getTime());
        }
        return "Portfolio has not been closed.";
    }

    public double getBalance() {
        return this.balance;
    }

    public double getNetworth() {
        double totalStockValue = 0.0;
        for (Stock stock : stocks) {
            totalStockValue += stock.getPrice() * stock.getQty();
        }
        return balance + totalStockValue;
    }

    public ArrayList<Stock> getStocks() {
        return this.stocks;
    }
    
        public void setCloseDate() {
        this.closeDate = Calendar.getInstance();
    }

    public void addFunds(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be greater than 0.");
        }
    }

    public void withdrawFunds(double amount) {
       
            balance -= amount; // subtract the amount from the balance
          }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void buyStock(Stock stock, int qty, double purchaseAmount) {
        if (purchaseAmount <= balance) {
            this.balance -= purchaseAmount;
            stock.setQty(qty);
            stocks.add(stock);
        } else {
            throw new IllegalArgumentException("Insufficient balance to buy stocks.");
        }
    }

    public void sellStock(int idx) {
        double price = stocks.get(idx).getPrice();
        int qty = stocks.get(idx).getQty();
        double amount = price * qty;

        this.addFunds(amount);
        stocks.remove(idx);
    }
        public void sellAllStocks() {
            for (Stock stock : stocks) {
                balance += stock.getPrice() * stock.getQty();
            }
            stocks.clear();
            setCloseDate();
        }
            public Stock getStock(int index) {
                if (index >= 0 && index < stocks.size()) {
                    return stocks.get(index);
                } else {
                    throw new IndexOutOfBoundsException("Invalid stock index");
        }  
            }
        }

