package org.example.ocp;

import java.util.Arrays;
import java.util.List;

public class OpenClosePrincipleAbstraction {
    //we define the common implementations in every shape implementation
    public abstract static class Shape {
        public abstract double calculateArea();
    }

    //
    public static class Circle extends Shape {
        private double radius;

        public Circle(double radius){
            this.radius = radius;
        }

        @Override
        public double calculateArea(){
            return Math.PI * this.radius * this.radius;
        }
    }

    public static class Rectangle extends Shape {
        private double width;
        private double height;

        public Rectangle(double width, double height){
            this.width = width;
            this.height = height;
        }

        @Override
        public double calculateArea(){
            return width * height;
        }
    }

    public static class AreaCalculator {
        public double calculateTotalArea(List<Shape> shapes){
            double total = 0;
            for(Shape shape: shapes) total += shape.calculateArea();
            return total;
        }
    }

    static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        AreaCalculator calculator = new AreaCalculator();
        double totalArea = calculator.calculateTotalArea(Arrays.asList(circle, rectangle));

        System.out.println("Total area: " + totalArea);
    }
}
