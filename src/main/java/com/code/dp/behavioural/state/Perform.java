package com.code.dp.behavioural.state;

/**
 * @param <N>
 * @author Rahul Potghan
 * @apiNote The following class is an example of Open-Closed principle.
 * Means class should be OPEN for extension but CLOSED for modification.
 * State Pattern lets an object alter its behavior when its internal state changes
 */
public class Perform<N extends Number> {
    private Operation<N> operation;

    public Perform(Operation<N> operation) {
        this.operation = operation;
    }

    public void setOperation(Operation<N> operation) {
        this.operation = operation;
    }

    public N doPerform(N op1, N op2) {
        return operation.calculate(op1, op2);
    }
}
