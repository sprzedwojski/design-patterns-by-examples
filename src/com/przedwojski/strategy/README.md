# Strategy

#### Type
Behavioral Pattern

#### Goal
When there are several ways (algorithms) in which something can be done (calculated),
we can extract those behaviours to separate classes with a common interface.
These classes become Strategies. 

#### Structure
There are 4 main actors:

- `Context`
- `Strategy Interface`
- `Concrete Strategies`
- `Client`

The `Context` operates on the `Strategy Interface`, calling the appropriate execution method(s).
It doesn't decide about which concrete strategy is behind it, it receives it from the `Client`.

The `Client` creates the specific Strategy object and passes it to the `Context`.
It's good if the strategy can be swapped at runtime, therefore the `Client` should be able
to set it on the `Context` e.g. via a setter.

#### Alternative approach
Implement different versions of an algorithm inside a set of anonymous functions, instead
of classes and interfaces.
  