/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ProjectCalculadora;

import calculadora.Algoritmos;
import calculadora.PilaA;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
 *
 * @author pabel
 */
public class AlgoritmosTest {
    
    public AlgoritmosTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Pruebas del método revisaSintaxis
     */
    /**
    * Caso 1: Operación de suma correcta. 
    */
    @Test
    public void testRevisaSintaxis1() {
        System.out.println("revisaSintaxis");
        String revisa = "6+6";
        boolean expResult = true;
        boolean result = Algoritmos.revisaSintaxis(revisa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
    * Caso 2: Operación con paréntesis no cerrado al final. 
    */
    @Test
    public void testRevisaSintaxis2() {
        System.out.println("revisaSintaxis");
        String revisa = "6+6(";
        boolean expResult = false;
        boolean result = Algoritmos.revisaSintaxis(revisa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
        /**
    * Caso 3: Operación con negativos correcta. 
    */
    @Test
    public void testRevisaSintaxis3() {
        System.out.println("revisaSintaxis");
        String revisa = "-5*8";
        boolean expResult = true;
        boolean result = Algoritmos.revisaSintaxis(revisa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Pruebas del método borrarUltimo.
     */
    
    /**
    * Caso 1: Operación de suma correcta. 
    */
    @Test
    public void testBorrarUltimo1() {
        System.out.println("borrarUltimo");
        String num = "56+5";
        String expResult = "56+";
        String result = Algoritmos.borrarUltimo(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
    * Caso 2: Operación no completa con paréntesis abierto al final. 
    */
    @Test
    public void testBorrarUltimo2() {
        System.out.println("borrarUltimo");
        String num = "4+1(";
        String expResult = "4+1";
        String result = Algoritmos.borrarUltimo(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
    * Caso 3: Intento de borrar uno sin operación previa ingresada.
    */
    @Test
    public void testBorrarUltimo3() {
        System.out.println("borrarUltimo");
        String num = "";
        String expResult = "";
        String result = Algoritmos.borrarUltimo(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
