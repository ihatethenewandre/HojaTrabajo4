import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.NoSuchElementException;

public class Calculadora<T extends Number> implements ICalculadora<T> {
    private IStack<T> stack;

    public Calculadora(IStack<T> stack) {
        this.stack = stack;
    }

    @Override
    public void suma(IStack<T> stack) {
        if (stack.size() < 2) {
            throw new IllegalStateException("Not enough elements in stack.");
        }
        T num1 = stack.pop();
        T num2 = stack.pop();

        Double resultado = num1.doubleValue() + num2.doubleValue();
        stack.push((T) resultado);
    }

    @Override
    public void resta(IStack<T> stack) {
        if (stack.size() < 2) {
            throw new IllegalStateException("Not enough elements in stack.");
        }
        T num1 = stack.pop();
        T num2 = stack.pop();

        Double resultado = num2.doubleValue() - num1.doubleValue();
        stack.push((T) resultado);
    }

    @Override
    public void producto(IStack<T> stack) {
        if (stack.size() < 2) {
            throw new IllegalStateException("Not enough elements in stack.");
        }
        T num1 = stack.pop();
        T num2 = stack.pop();

        Double resultado = num1.doubleValue() * num2.doubleValue();
        stack.push((T) resultado);
    }

    @Override
    public void division(IStack<T> stack) {
        if (stack.size() < 2) {
            throw new IllegalStateException("Not enough elements in stack.");
        }
        T num1 = stack.pop();
        T num2 = stack.pop();

        if (num1.doubleValue() == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }

        Double resultado = num2.doubleValue() / num1.doubleValue();
        stack.push((T) resultado);
    }

    @Override
    public T calcular(String[] datos) {
        for (String dato : datos) {
            if (isNumber(dato)) {
                addNumber(stack, (T) Double.valueOf(dato));
            } else {
                switch (dato) {
                    case "+":
                        suma(stack);
                        break;
                    case "-":
                        resta(stack);
                        break;
                    case "*":
                        producto(stack);
                        break;
                    case "/":
                        division(stack);
                        break;
                }
            }
        }
        if (stack.empty()) {
            throw new IllegalStateException("Calculation error.");
        }
        return stack.pop();
    }

    @Override
    public String[] convertir(String texto) {
        String[] datosInfix = texto.split(" ");
        List<String> datosPostfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (String dato : datosInfix) {
            if (isNumber(dato)) {
                datosPostfix.add(dato);
            } else if (dato.equals("(")) {
                stack.push(dato);
            } else if (dato.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    datosPostfix.add(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek().equals("(")) {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedencia(dato) <= precedencia(stack.peek())) {
                    datosPostfix.add(stack.pop());
                }
                stack.push(dato);
            }
        }

        while (!stack.isEmpty()) {
            datosPostfix.add(stack.pop());
        }

        return datosPostfix.toArray(new String[0]);
    }

    private int precedencia(String operador) {
        switch (operador) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            default:
                return -1;
        }
    }

    @Override
    public void addNumber(IStack<T> stack, T n) {
        stack.push(n);
    }

    @Override
    public boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}