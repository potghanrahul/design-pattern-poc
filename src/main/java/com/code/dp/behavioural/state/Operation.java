package com.code.dp.behavioural.state;

public interface Operation<N extends Number> {
    N calculate(N n, N m);
}
