import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FStack<Double> fStack = new FStack<>();
        FList<Double> fList = new FList<>();
        IStack<Double> stack = null;
        ICalculadora<Double> calculadora = null;

        System.out.println("Bienvenido al programa de calculadora postfix.");
        System.out.println("Por favor, selecciona la implementación del Stack que deseas utilizar:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");

        String opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                stack = fStack.getStack("ARRAYLIST");
                break;
            case "2":
                stack = fStack.getStack("VECTOR");
                break;
            case "3":
                System.out.println("Has seleccionado Lista. Por favor, selecciona el tipo de Lista que deseas utilizar:");
                System.out.println("1. Lista simplemente encadenada");
                System.out.println("2. Lista doblemente encadenada");

                String opcionLista = scanner.nextLine();

                switch (opcionLista) {
                    case "1":
                    stack = (IStack<Double>) fList.getList("SINGLYLINKEDLIST");
                        break;
                    case "2":
                    stack = (IStack<Double>) fList.getList("DOUBLYLINKEDLIST");
                    break;
                    default:
                        System.out.println("Opción no válida. Saliendo del programa.");
                        System.exit(0);
                }
                break;
            default:
                System.out.println("Opción no válida. Saliendo del programa.");
                System.exit(0);
        }

        calculadora = new Calculadora<>(stack);

        System.out.println("Por favor, introduce la ruta del archivo .txt con la expresión postfix:");

        String rutaArchivo = scanner.nextLine();

        try {
            File archivo = new File(rutaArchivo);
            Scanner lectorArchivo = new Scanner(archivo);
            while (lectorArchivo.hasNextLine()) {
                String linea = lectorArchivo.nextLine();
                String[] datos = calculadora.convertir(linea);
                Double resultado = calculadora.calcular(datos);
                System.out.println("El resultado de la expresión es: " + resultado);
            }
            lectorArchivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo. Saliendo del programa.");
            System.exit(0);
        }

        scanner.close();
    }
}