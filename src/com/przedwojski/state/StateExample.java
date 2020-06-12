package com.przedwojski.state;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Client
public class StateExample {
    public static void main(String[] args) {
        System.out.println();

        Task task = new Task();
        task.changeState(new InProgress());
        task.changeState(new Done());
        task.changeState(new Published());
        task.changeState(new InReview());
    }
}

// Context
class Task {
    private State state = new Todo();

    void changeState(State newState) {
        if (state.canTransitionTo(newState)) {
            this.state = newState;
            System.out.println(String.format("Task status changed: %s -> %s.", state, newState));
        } else {
            System.err.println(String.format("Illegal status change: %s -> %s. Aborted.", state, newState));
        }
    }
}

// State Interface
abstract class State {
    boolean canTransitionTo(State newState) {
        return getPossibleTransitions().contains(newState.getClass());
    }

    abstract List<Class<? extends State>> getPossibleTransitions();

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

// Concrete States
class Todo extends State {
    @Override
    List<Class<? extends State>> getPossibleTransitions() {
        return Arrays.asList(InProgress.class, InReview.class, Done.class);
    }
}

class InProgress extends State {
    @Override
    List<Class<? extends State>> getPossibleTransitions() {
        return Arrays.asList(Todo.class, InReview.class, Done.class);
    }
}

class InReview extends State {
    @Override
    List<Class<? extends State>> getPossibleTransitions() {
        return Arrays.asList(Todo.class, InProgress.class, Done.class);
    }
}

class Done extends State {
    @Override
    List<Class<? extends State>> getPossibleTransitions() {
        return Arrays.asList(Todo.class, InProgress.class, InReview.class, Published.class);
    }
}

class Published extends State {
    @Override
    List<Class<? extends State>> getPossibleTransitions() {
        return Collections.emptyList();
    }
}
