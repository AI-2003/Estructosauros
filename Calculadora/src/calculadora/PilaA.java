package calculadora;

/**
 * Clase con uso de objetos genéricos que maneja las pilas
 * @author Equipo
 * @param <T> 
 */
public class PilaA <T> implements PilaADT<T>{
    private T[] datosPila;
    private int tope;
    private final int MAXIMO=20;
    
    /**
     * Constructor de la clase PilaA, inicializa los datos de datosPila y el tope
     */
    public PilaA() {
        datosPila= (T[]) new Object[MAXIMO];
        tope = -1; //Indica la pila vacía
    }
    /**
     * Inserta nuevo elemento en el tope de la pila
     * @param dato Tipo genérico del objeto a insertar
     */
    @Override
    public void push(T dato) {
        if(tope==this.datosPila.length-1) //Pila esá llena
            expand();
        tope++;
        datosPila[tope]=dato;
    }
    
    /**
     * Agranda el tamaño de la pila
     */
    private void expand(){
        T[] masGrande = (T[]) new Object[this.datosPila.length*2];
        
        for(int i=0; i<=tope; i++)
            masGrande[i]=datosPila[i];
        datosPila=masGrande;
    }
    
    /**
     * Elimina el elemento al tope de la pila
     * @return Objeto tipo genérico de la nueva pila sin el elemento
     */
    @Override
    public T pop() {
        if(this.isEmpty())
            throw new ColeccionVaciaExcepcion("La pila está vacía");
        T resultado;
        
        resultado=this.datosPila[tope];
        this.datosPila[tope]=null;
        tope--;
        return resultado;
    }
    
    /**
     * Verifica si la pila está vacía
     * @return Booleano que indica si la pila está vacía
     */
    @Override
    public boolean isEmpty() {
        
        return tope==(-1);
    }

    /**
     * Devuelve el elemento hasta arriba de la pila
     * @return Último elemento de la pila
     */
    @Override
    public T peek() {
        if(this.isEmpty())
            throw new ColeccionVaciaExcepcion("La pila está vacía");
        return this.datosPila[tope];
    }
    
    /**
     * Regresa los datos de la pila en una cadena
     * @return String con los datos de la pila
     */
    public String toString(){
        StringBuilder str = new StringBuilder();
        
        for(int i=tope; i<=0; i--)
            str.append(datosPila[i]).append("\n");
        return str.toString();
    }
    
}
