package org.example.srp;

/**
 * The Rule: A class should have only one reason to change(Every class should have a responsibility).
 * The Smell: You have a User class that handles database logic, email notifications, and password validation.
 * The Java Fix: Break them into separate services.
 */
public class SingleResponsibilityPrinciple {

    //Only business logic
    public class Invoice {
        private double amount;
        public Invoice(double amount){
            this.amount = amount;
        }
        public double calculateTax(){
            return this.amount * 0.16;
        }
        public double getAmount(){
            return this.amount;
        }
    }

    //Persistence Class - Only saves data
    public class InvoiceRepository{
        public void save(Invoice invoice){
            System.out.println("Saving invoice to database...");
        }
    }

    //Presentation Class - only handles data
    public class InvoicePrinter {
        public void print(Invoice invoice){
            System.out.println("Printing invoice with amount = " + invoice.getAmount());
        }
    }

}
