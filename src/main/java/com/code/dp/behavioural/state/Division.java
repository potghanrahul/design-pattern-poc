package com.code.dp.behavioural.state;

public class Division<N extends Number> implements Operation<N> {
    @Override
    public N calculate(N n, N m) {
        System.out.println("Division.calculate");
        double a = n.doubleValue() / m.doubleValue();
        return (N) Double.valueOf(a);
    }
}
