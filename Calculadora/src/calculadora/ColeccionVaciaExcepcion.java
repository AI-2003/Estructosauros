package calculadora;

/**
 * Clase para una Excepcion en caso de que la colección de objetos esté vacía
 * @author Equipo
 */
public class ColeccionVaciaExcepcion extends RuntimeException{

    /**
     * Llama a los elementos de la clase RuntimeException
     */
    public ColeccionVaciaExcepcion() {
        super();
    }
    
    /**
     * Obtiene el mensaje que arroja el RuntimeException
     * @param message Mensaje de error
     */
    public ColeccionVaciaExcepcion(String message) {
        super(message);
    } 
    
}
