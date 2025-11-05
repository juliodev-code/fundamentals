package org.example.ocp;

public class OpenClosePrinciplePolymorphism {

    //Using open close principle using "Polymorphism"
    public interface DiscountPolicy {
        double applyDiscount(double amount);
    }

    public class RegularDiscount implements DiscountPolicy {
        @Override
        public double applyDiscount(double amount){
            return amount * 0.05;
        }
    }

    public class PremiumDiscount implements DiscountPolicy {
        @Override
        public double applyDiscount(double amount){
            return amount * 0.10;
        }
    }

    public class VipDiscount implements DiscountPolicy {
        @Override
        public double applyDiscount(double amount){
            return amount * 0.15;
        }
    }

    public class InvoiceService {
        private final DiscountPolicy discountPolicy;

        public InvoiceService(DiscountPolicy discountPolicy){
            this.discountPolicy = discountPolicy;
        }

        public double calculateTotal(double amount){
            double discount = this.discountPolicy.applyDiscount(amount);
            return amount - discount;
        }
    }

}
