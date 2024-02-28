import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pruebas {

    @Testable
    void pruebaListaSinglyLinked() {
        // Crear una instancia de tu lista simplemente encadenada
        IList<Double> lista = new List_SinglyLinked<>();

        // Leer el archivo de prueba
        File archivo = new File("PruebaSimple.txt");

        try {
            Scanner lectorArchivo = new Scanner(archivo);
            while (lectorArchivo.hasNextLine()) {
                String expresion = lectorArchivo.nextLine();
                String[] datos = expresion.split(" ");

                // Realizar operaciones utilizando la lista
                for (String dato : datos) {
                    if (isNumber(dato)) {
                        lista.addLast(Double.parseDouble(dato));
                    }
                }

                // Verificar resultados
                assertEquals(35.0, lista.getLast());
            }
            lectorArchivo.close();
        } catch (FileNotFoundException e) {
            fail("No se pudo encontrar el archivo de prueba.");
        }
    }

    @Test
    void pruebaListaDoublyLinked() {
        // Crear una instancia de tu lista doblemente encadenada
        IList<Double> lista = new List_DoublyLinked<>();

        // Leer el archivo de prueba
        File archivo = new File("PruebaDoble.txt");

        try {
            Scanner lectorArchivo = new Scanner(archivo);
            while (lectorArchivo.hasNextLine()) {
                String expresion = lectorArchivo.nextLine();
                String[] datos = expresion.split(" ");

                // Realizar operaciones utilizando la lista doblemente encadenada
                for (String dato : datos) {
                    if (isNumber(dato)) {
                        lista.addLast(Double.parseDouble(dato));
                    }
                }

                // Verificar resultados
                assertEquals(3.0, lista.getLast());
            }
            lectorArchivo.close();
        } catch (FileNotFoundException e) {
            fail("No se pudo encontrar el archivo de prueba.");
        }
    }

    @Test
    void pruebaStackArrayList() {
        // Crear una instancia de tu stack basado en ArrayList
        IStack<Double> stack = new Stack_ArrayList<>();

        // Leer el archivo de prueba
        File archivo = new File("PruebaArray.txt");

        try {
            Scanner lectorArchivo = new Scanner(archivo);
            while (lectorArchivo.hasNextLine()) {
                String expresion = lectorArchivo.nextLine();
                String[] datos = expresion.split(" ");

                // Realizar operaciones utilizando el stack basado en ArrayList
                for (String dato : datos) {
                    if (isNumber(dato)) {
                        stack.push(Double.parseDouble(dato));
                    }
                }

                // Verificar resultados
                assertEquals(2.0, stack.peek());
            }
            lectorArchivo.close();
        } catch (FileNotFoundException e) {
            fail("No se pudo encontrar el archivo de prueba.");
        }
    }

    @Test
    void pruebaStackVector() {
        // Crear una instancia de tu stack basado en Vector
        IStack<Double> stack = new Stack_Vector<>();

        // Leer el archivo de prueba
        File archivo = new File("PruebaVector.txt");

        try {
            Scanner lectorArchivo = new Scanner(archivo);
            while (lectorArchivo.hasNextLine()) {
                String expresion = lectorArchivo.nextLine();
                String[] datos = expresion.split(" ");

                // Realizar operaciones utilizando el stack basado en Vector
                for (String dato : datos) {
                    if (isNumber(dato)) {
                        stack.push(Double.parseDouble(dato));
                    }
                }

                // Verificar resultados
                assertEquals(3.0, stack.peek());
            }
            lectorArchivo.close();
        } catch (FileNotFoundException e) {
            fail("No se pudo encontrar el archivo de prueba.");
        }
    }

    // Método para verificar si una cadena es un número
    private boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
