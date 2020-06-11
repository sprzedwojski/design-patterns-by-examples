package com.przedwojski.visitor;

import java.util.Arrays;
import java.util.List;

// Client
public class VisitorExample {
    public static void main(String[] args) {
        System.out.println(); // Empty line for better readability of the result
        List<Device> devices =
                Arrays.asList(
                        new Television("123TRE", 50),
                        new Laptop("987UJK", 13, "Intel Core i7", "Apple"));
        Visitor visitor = new ExportVisitor();

        for (Device device : devices) {
            device.accept(visitor);

            // visitor.visit(device);
            // Cannot resolve method visit(Device) - that's why
            // we need the accept() method on the Element
        }
    }
}

// Visitor Interface
interface Visitor {
    void visit(Television television);

    void visit(Laptop laptop);
}

// Concrete Visitor
class ExportVisitor implements Visitor {
    @Override
    public void visit(Television tv) {
        String messageTemplate = "Television S/N: %s, size in inches: %s";
        String message = String.format(messageTemplate, tv.serialNumber, tv.sizeInches);
        System.out.println(message);
    }

    @Override
    public void visit(Laptop laptop) {
        String messageTemplate =
                "Laptop manufacturer: %s, S/N: %s, size in inches: %s, processor: %s";
        String message =
                String.format(
                        messageTemplate,
                        laptop.manufacturer,
                        laptop.serialNumber,
                        laptop.sizeInches,
                        laptop.processor);
        System.out.println(message);
    }
}

// Element Interface
interface Device {
    void accept(Visitor visitor);
}

// Concrete Element
class Television implements Device {
    final String serialNumber;
    final int sizeInches;

    public Television(String serialNumber, int sizeInches) {
        this.serialNumber = serialNumber;
        this.sizeInches = sizeInches;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Concrete Element
class Laptop implements Device {
    final String serialNumber;
    final int sizeInches;
    final String processor;
    final String manufacturer;

    public Laptop(String serialNumber, int sizeInches, String processor, String manufacturer) {
        this.serialNumber = serialNumber;
        this.sizeInches = sizeInches;
        this.processor = processor;
        this.manufacturer = manufacturer;
    }

    // Needed for the Double Dispatch mechanism - knowing which Visitor method to invoke
    // https://refactoring.guru/design-patterns/visitor-double-dispatch
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
