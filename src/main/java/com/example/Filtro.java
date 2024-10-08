package com.example;

import java.util.function.Predicate;

public class Filtro implements Predicate<Object>{

    @Override
    public boolean test(Object obj) {
        return (obj instanceof Empleado empleado && empleado.getGenero().equals(Genero.MUJER));
    }

}
