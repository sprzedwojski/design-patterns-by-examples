package com.przedwojski.strategy;

// Client
public class StrategyExample {

    public static void main(String[] args) {
        System.out.println("\nWelcome to Coffee Maker!");
        String coffeeType = args[0];
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        switch (coffeeType) {
            case "americano":
                coffeeMaker.setCoffeeStrategy(new AmericanoCoffee());
                break;
            case "espresso":
                coffeeMaker.setCoffeeStrategy(new EspressoCoffee());
                break;
            case "cappuccino":
                coffeeMaker.setCoffeeStrategy(new CappuccinoCoffee());
                break;
            default:
                System.err.println("Unknown coffee type.");
                System.exit(1);
        }

        System.out.println("Prepared coffee: " + coffeeMaker.getCoffee());
    }
}

// Context
class CoffeeMaker {
    private CoffeeStrategy coffeeStrategy;

    public void setCoffeeStrategy(CoffeeStrategy coffeeStrategy) {
        this.coffeeStrategy = coffeeStrategy;
    }

    // Execute Strategy
    public CoffeeRecipe getCoffee() {
        return coffeeStrategy.getRecipe();
    }
}

// Strategy Interface
interface CoffeeStrategy {
    CoffeeRecipe getRecipe();
}


// Concrete Strategy
class AmericanoCoffee implements CoffeeStrategy {
    @Override
    public CoffeeRecipe getRecipe() {
        return new CoffeeRecipe(20, 300, 0);
    }
}

// Concrete Strategy
class EspressoCoffee implements CoffeeStrategy {
    @Override
    public CoffeeRecipe getRecipe() {
        return new CoffeeRecipe(20, 100, 0);
    }
}

// Concrete Strategy
class CappuccinoCoffee implements CoffeeStrategy {
    @Override
    public CoffeeRecipe getRecipe() {
        return new CoffeeRecipe(10, 120, 80);
    }
}

class CoffeeRecipe {
    int coffeeAmountInGrams;
    int waterAmountMillilitres;
    int milkAmountMillilitres;

    public CoffeeRecipe(
            int coffeeAmountInGrams, int waterAmountMillilitres, int milkAmountMillilitres) {
        this.waterAmountMillilitres = waterAmountMillilitres;
        this.milkAmountMillilitres = milkAmountMillilitres;
        this.coffeeAmountInGrams = coffeeAmountInGrams;
    }

    @Override
    public String toString() {
        return "CoffeeRecipe{"
                       + "coffeeAmountInGrams="
                       + coffeeAmountInGrams
                       + ", waterAmountMillilitres="
                       + waterAmountMillilitres
                       + ", milkAmountMillilitres="
                       + milkAmountMillilitres
                       + '}';
    }

}
