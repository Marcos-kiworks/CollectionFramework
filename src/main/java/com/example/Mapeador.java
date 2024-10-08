package com.example;

import java.util.function.ToDoubleFunction;

public class Mapeador implements ToDoubleFunction<Object>{

    @Override
    public double applyAsDouble(Object obj) {
        // A continuación estamos usando un Type casting (casteo),
        // es decir, convirtiendo a un tipo concreto
        return ((Empleado) obj).getSalario();
    }

}
