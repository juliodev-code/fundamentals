package org.example.isp;

public class InterfaceSegregationPrinciple {

    //we declare the different capabilities that out classes can implement
    public interface Printer {
        void print(Document doc);
    }

    public interface Scanner {
        void scan(Document doc);
    }

    public interface Fax {
        void fax(Document doc);
    }

    //we define the class which the functionality will be installed
    public class Document {
        private final String content;

        public Document(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }
    }

    //an example using a single functionality
    public class SimplePrinter implements Printer {
        @Override
        public void print(Document doc) {
            System.out.println("Printing: " + doc.getContent());
        }
    }

    //an example using a multiple functionalities
    public class MultiFunctionMachine implements Printer, Scanner, Fax {
        @Override
        public void print(Document doc) {
            System.out.println("Printing: " + doc.getContent());
        }

        @Override
        public void scan(Document doc) {
            System.out.println("Scanning: " + doc.getContent());
        }

        @Override
        public void fax(Document doc) {
            System.out.println("Faxing: " + doc.getContent());
        }
    }


}
