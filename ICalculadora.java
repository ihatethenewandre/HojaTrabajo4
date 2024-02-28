public interface ICalculadora<T> {
    void suma(IStack<T> stack);
    void resta(IStack<T> stack);
    void producto(IStack<T> stack);
    void division(IStack<T> stack);
    T calcular(String[] datos);
    String[] convertir(String texto);
    void addNumber(IStack<T> stack, T n);
    boolean isNumber(String s);
}