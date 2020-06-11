# Visitor

#### Type
Behavioral Pattern

#### Goal
Say there are existing elements that we don't want to modify (too much), but we want to introduce new behaviors to them.
For instance, there are classes representing different types of buildings. We want each of them to do something
without introducing the behavior directly into the classes.

For that we introduce the `Visitor` interface. Classes implementing this interface will operate on the building
objects. Each `Visitor` adds one type of behavior. Because we have different classes of buildings, the `Visitor` logic
will be different, e.g. `visitor.doForHouse()`, `visitor.doForApartment()`, `visitor.doForSkyscraper()`. If the
language supports overloading (like Java), the method name can be the same, but accepting different parameter types.

To know which behavior implementation to use, the building classes will have `accept(Visitor visitor)` methods,
where they "accept" a `Visitor`.

#### Structure
Main actors:

- `Visitor Interface`
- `Concrete Visitor`
- `Element Interface`
- `Concrete Element`
- `Client`

// TODO description
