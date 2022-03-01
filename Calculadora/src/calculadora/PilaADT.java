package calculadora;

/**
 * Interfaz del comportamiento de las pilas
 * @author Equipo
 * @param <T> 
 */
public interface PilaADT <T> {
    
    public void push(T dato);
    public T pop();
    public boolean isEmpty();
    public T peek();
    
}
