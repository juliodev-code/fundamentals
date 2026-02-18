/*
* DIP is the rule that says: "High-level modules (the 'Boss' classes)
* should not depend on low-level modules (the 'Worker' classes).
* Both should depend on Abstractions (Interfaces)."
* */

// The Abstraction (The Socket)
public interface PaymentProcessor {
    void pay();
}

public class Store {
    private final PaymentProcessor processor;

    // Dependency Injection: We "plug in" the dependency via the constructor
    public Store(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void purchase() {
        processor.pay();
    }
}