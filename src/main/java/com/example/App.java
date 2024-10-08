package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        /*
         * ¿Que es una colección
         * Es un contenedor que permite agrupar elementos de
         * distinto tipo como si fuese una única unidad
         * ¿Para que se utilizan las colecciones?
         * Para almacenar, recuperar, manipular y comunicar
         * datos agrupados.
         * 
         * El Framework de colecciones es un conjunto de Interfaces,
         * con métodos que permiten tratar a todas las colecciones
         * de la misma forma.
         * 
         * La Interface List es una de las colecciones más utilizadas
         * permite almacenar elementos duplicados, al igual que todas las demás
         * interfases es Genérica.
         * 
         * ¿Que es la genericidad? Es lo que permite generar e implementar
         * clases e interfaces que trabajen con tipos de datos diferentes,
         * pero en cada momento solo pueden trabajar con un solo tipo de
         * dato, o datos relacionados.
         * // Por lo general un desarrolllador no implementa metodos ni elementos
         * (clases,
         * // records, etc), sino que debe saber utilizarlos. Solamente los
         * desarrolladores
         * // que se dediquen a implementar bibliotecas (librerias) son los que tendran
         * que
         * // dominar la Genericidad a otro nivel.
         * //¿Que ventajas nos ofrece la genericidad? Que los errores se detectan
         * // muy facilmente en tiempo de compilacion, en lugar de ejecucion donde
         * // seria mucho mas dificil de detectar.
         * 
         */

 /*
         * Declaración de colecciones
         * Lista o colección de elementos donde cada elemento es de tipo String
         * !Importante¡ En el diamante no puede ir ningún tipo de dato primitivo
         * (int, double, float, number) sino su correspondiente envoltorio objeto
         * (Integer, Double, Float)
         */
        // Lista o colección de elementos donde cada elemento es de tipo String
        List<String> nombres;

        // Lista de numeros
        List<Integer> numeros;

        // Lista de personas
        List<Persona> personas;

        // Coleccion que admite elementos de tipo persona y todos los que hereden de
        // Persona
        // por ejemplo Estudiante, Trabajador, etc
        // https://docs.oracle.com/javase/tutorial/extra/generics/index.html (Generics
        // documentación oficial)

        /* Breve explicación, un poco más profunda de la genericidad */
        // La siguiente colección admite elementos de cualquier tipo, pero se
        // desaconseja
        // crear colecciones totalmente genéricas porque cuesta trabajo manejar la
        // colección posteriormente
        List<?> elementos;

        /*
         * ¿Que es lo que aconseja entonces?
         * Acotar por encima o por debajo el tipo, es decir,
         * establecer un limite
         * 
         * Por tanto si queremos tener una colección que admita
         * Persona y todos los subtipos de Persona.
         */
        List<? super Persona> elementosVarios;

        // Importante
        // No permite almacenar elementos porque crea una lista inmutable
        // ¿Para que sirve? Para pasarlo como parámetro a determinados métodos
        List<? extends Persona> elementVar2;

        // ¿Como agregar elementos a una colección?
        // Comenzando por la colección de nombres
        // Primero: a partir de un array existente
        String[] arrayNombres = {"Marcos", "Juan", "Antonio"};

        /* ¿Como convertir el array anterior en una lista de nombres? */
        nombres = Arrays.asList(arrayNombres);

        System.out.println("Lista de nombres");
        System.out.println(nombres);

        /*
         * ¿Que desventaja tiene crear una lista a partir de un array?
         * Que la lista resultante es de tamaño fijo, es decir, que
         * No le puedes agregar elementos con el método add posteriormente
         */
        // nombres.add("Iván");

        /*
         * Otra forma de agregar elemento a una colección es
         * utilizando métodos estáticos de la propia interface
         * lo cual crea una lista inmutable, es decir, de tamaño
         * fijo y que además no se puede ni modificar sus elementos
         */
        // List<>String nombres2 = List.of("Rubén","Iván");

        /*
         * Por último, crear una lista a partir de una
         * clase que implemente los métodos de la interface,
         * ArrayList por ejemplo, y este tipo de lista
         * si se puede modificar
         */
        // List<>String nombres3 = new ArrayList<>();
        // nombres3.add("Iván");
        // nombres3.add("Antonio");

        /*
         * Crear una lista de Personas
         * 
         * 1. A partir de un array
         */
        // Persona persona1;
        // Persona persona2;
        // Persona persona3;
        // persona1 = Persona.builder()
        // .nombre("Marcos")
        // .genero(Genero.HOMBRE)
        // .build();
        // persona2 = Persona.builder()
        // .nombre("Juan")
        // .genero(Genero.HOMBRE)
        // .build();
        // persona3 = Persona.builder()
        // .nombre("Antonio")
        // .genero(Genero.HOMBRE)
        // .build();
        Persona[] personasArray = {
            Persona.builder()
            .nombre("Marcos")
            .genero(Genero.HOMBRE)
            .build(),
            Persona.builder()
            .nombre("Juan")
            .genero(Genero.HOMBRE)
            .build(),
            Persona.builder()
            .nombre("Antonio")
            .genero(Genero.HOMBRE)
            .build()
        };

        personas = Arrays.asList(personasArray);

        // Crear una lista de personas modificable
        List<Persona> personas2 = new ArrayList<>();

        personas2.add(Persona.builder()
                .nombre("Marcos")
                .genero(Genero.HOMBRE)
                .build());

        personas2.add(Persona.builder()
                .nombre("Juan")
                .genero(Genero.HOMBRE)
                .build());

        personas2.add(Persona.builder()
                .nombre("Elli")
                .genero(Genero.MUJER)
                .build());

        personas2.add(Persona.builder()
                .nombre("Maria")
                .genero(Genero.MUJER)
                .build());

        /*
         * Agregar elementos varios a la lista de
         * elementosVarios.
         */
        elementosVarios = new ArrayList<>();

        /* Agregar una persona */
        elementosVarios.add(Persona.builder()
                .nombre("Marcos")
                .genero(Genero.HOMBRE)
                .build());

        /* Agregar un trabajador */
        elementosVarios.add(Empleado.builder()
                .nombre("Antonio")
                .genero(Genero.HOMBRE)
                .departamento(Departamento.INFORMÁTICA)
                .salario(3500.78)
                .build());

        /* Agregar un estudiante */
        elementosVarios.add(
                Estudiante.builder()
                        .nombre("Ruben")
                        .genero(Genero.HOMBRE)
                        .totalAsignaturas(10)
                        .beca(10500.00)
                        .build());
        Estudiante.builder()
                .nombre("Marcos")
                .genero(Genero.HOMBRE)
                .totalAsignaturas(11)
                .beca(11500.00)
                .build();
        Estudiante.builder()
                .nombre("Juan")
                .genero(Genero.HOMBRE)
                .totalAsignaturas(9)
                .beca(9500.00)
                .build();

        // * Recorrer una colección TRAVERSING COLLECTION */
        // 1. Utilizando un iterador (Interface iterator)
        // es la única forma de eliminar un elemento de la colección mientras se recorre
        // 2. Utilizando un for mejorado
        // 3. La forma recomendada es utilizando operaciones de agregado (
        // métodos de la clase Stream, las expresiones Lambda, y los métodos por
        // referencia)

        /* Utilizando un iterador (interface iterator) vamos a recorrer la colección de personas2 
         * para eliminar las personas del género HOMBRE
         */
        Iterator<Persona> i = personas2.iterator();

        System.out.println("Listado de personas 2, original");
        System.out.println(personas2);
        while (i.hasNext()) {
            if (i.next().getGenero().equals(Genero.HOMBRE)) {
                i.remove();
            }

        }
        System.out.println("Personas del género MUJER resultantes");
        System.out.println(personas2);

        /* Ejercicio º 1: Recorrer la colección de personas2 y mostrar las personas del género hombre que además tengan 
          * un nombre menor o igual de 5 caracteres utilizando un iterador
         */
        Iterator<Persona> i2 = personas2.iterator();

        System.out.println("Listado de personas 2, ejercicio1");
        while (i2.hasNext()) {
            Persona persona = i2.next();
            if (persona.getGenero().equals(Genero.HOMBRE) && persona.getNombre().length() <= 5) {
                System.out.println(persona);
            }
        }

        /*Utilizando la sentencia for mejorada, recorrer la lista elementosVarios
           * y calcular el promedio de las becas otorgadas a los estudiantes
           * 
           * Vamos a emplear Pattern matching, surgido a partir de Java 11
         */

         /* se usa super y no extend xq extend genera una lista inmutable */
        double sumatoriaBecas = 0;
        int studentCounter = 0;
        double promedioBecas = 0;

        for ( Object obj : elementosVarios) {
                //¿como saber el tipo del objeto extraido de la coleccion?
                // Utilizando el operador instanceof y también Pattern Matching.
                if (obj instanceof Estudiante estudiante) {
                        sumatoriaBecas += estudiante.getBeca();
                        studentCounter++;
                } else if (obj instanceof Empleado empleado) {
                        
                } else {
                        
                }
        }


    }

}
