# State 

#### Type
Behavioral Pattern

#### Goal
To be used when an "object" can change its internal state. Related to the concept of the Finite State Machine.
Instead of managing the state with if/else clauses or a switch statement, which gets problematic quickly
when the number of states and the logic behind them increase, we create a new class for each possible state.

The states themselves contain the logic of which transitions to other states are allowed, thus the logic
is well encapsulated. The states may also issue state transitions to the context.

This may look similar to Strategy, but the difference is that different strategies usually don't know
about each other. Whereas here the states do.

#### Structure
Main actors:

- `Client`
- `Context`
- `State Interface`
- `Concrete States`

#### Example
An example can be a `Task` in a task management software (Jira, Trello, etc.). It can be in different
states (Todo, InProgress, Done, etc.) and not all state transitions are allowed, e.g. once something is
Done, it cannot be changed back to Todo.
