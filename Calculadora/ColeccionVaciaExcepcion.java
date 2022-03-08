package calculadora;

/**
 * Clase para una Excepcion en caso de que la colección de objetos esté vacía.
 * @version 2.0
 * @author Equipo Estructosauros
 * @fecha 06/03/2022
 */
public class ColeccionVaciaExcepcion extends RuntimeException{

    /**
     * Llama a los elementos de la clase RuntimeException.
     */
    public ColeccionVaciaExcepcion() {
        super();
    }
    
    /**
     * Obtiene el mensaje que arroja el RuntimeException.
     * @param message Mensaje de error.
     */
    public ColeccionVaciaExcepcion(String message) {
        super(message);
    } 
    
}
