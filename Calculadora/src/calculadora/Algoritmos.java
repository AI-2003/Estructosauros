package calculadora;

/**
 * Clase que contiene todos los algoritmos necesarios para la lógica del programa
 * @version 1.0
 * @author Equipo
 * @fecha  28/02/2022
 */

public class Algoritmos {
    
    /**
     * 
     * @param elem elemento a analizar
     * @return int prioridad del operando
     */
    
    private static int getPrioridad(char elem){
        
        return switch (elem) {
            case '+' -> 1;
            case '-' -> 1;
            case '*' -> 2;
            case '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }
    
    /**
     * Convierte pila de infija a postfija
     * @param infija
     * @return String postfija 
     */
    public static String infijaAPostfija(String infija){
        String postfija;
        char elem;
        int prioridad;
        PilaA pila;
        
        postfija="";
        pila=new PilaA();
        for(int i=0; i<infija.length(); i++){
            elem=infija.charAt(i);
            if(elem>47&&elem<58 || elem=='.')
                postfija+=elem;
            else
                if(elem=='(')
                    pila.push(elem);
                else
                    if(elem==')'){
                        while(!pila.isEmpty() && !pila.peek().equals('('))
                            postfija+=pila.pop();
                        pila.pop();
                    }else{
                        prioridad=getPrioridad(elem);
                        if(prioridad!=-1){
                            while(!pila.isEmpty() && prioridad<=getPrioridad((char) pila.peek()))
                                postfija+=pila.pop();
                            pila.push(elem);
                        }
                    }
        }
        while(!pila.isEmpty())
            postfija+=pila.pop();
        return postfija;
    }  
    
    /**
     * Analiza los paréntesis contenidos en la oración para ayudar con las prioridades
     * @param analiza Cadena a analizar
     * @return booleano en caso de que haya un paréntesis
     */
     public static boolean analizaParentesis (String analiza){
        boolean resp=true;
        PilaA <Character> almacena = new PilaA();
        int contador=0;
        int i=0;
        
           while (i<analiza.length()) {  

                if(analiza.charAt(i)=='(')
                    almacena.push('(');                              

                else 
                    if  (analiza.charAt(i)==')')  
                        if (!almacena.isEmpty())
                            almacena.pop();

                        else {
                            almacena.push(')');
                            break;
                        }
           
                i++;
            }
            if(almacena.isEmpty())
                resp= true; 
             else 
                resp= false;
       
        return resp;
    }
     
     /**
      * Revisa si hay algún signo
      * @param revisa Cadena a revisar
      * @return boolean que indica si hay presencia de signos
      */
    public static boolean revisaSignos(String revisa){
        boolean resp=true;
        char ant;
        int i=0;
        
        while(i<revisa.length()-1 && resp){
            
            if(revisa.charAt(i)=='+'||revisa.charAt(i)=='-'||revisa.charAt(i)=='*'||revisa.charAt(i)=='/')
                i++;
                if(revisa.charAt(i)=='+'||revisa.charAt(i)=='-'||revisa.charAt(i)=='*'||revisa.charAt(i)=='/')
                    resp=false;
            i++;      
        }
        
        return resp;   
    }
    /**
     * En revisión
     * @param revisa
     * @return 
     */
    public static boolean revisaPunto ( String revisa){
        boolean resp=true;
        int i=0,j=0,contador=0;
       
        while(j<revisa.length()&& resp){
            while(i<revisa.length()&& contador<=1){
                if(revisa.charAt(i)!='+'||revisa.charAt(i)!='-'||revisa.charAt(i)!='*'||revisa.charAt(i)!='^'||revisa.charAt(i)!='/')
                    if(revisa.charAt(i)=='.')
                        contador++;
             i++;
                }
            if(contador>1)
             resp=false;
            j=i;
            contador=0;
        }
         
      
        return resp;
        
    }
    
    /**
     * Main para pruebas 
     * @param args 
     */
    public static void main(String[] args) {
        
        System.out.println("Prueba de analizaParentesis");
        System.out.println("Con los paréntesis puestos correctamente");
        System.out.println("1.1(a+b)  " + analizaParentesis("1(a+b)")); 
        System.out.println("2. 6+(-1(-5(34-5)+3)) " +analizaParentesis("6+(-1(-5(34-5)+3.0))"));
        
        System.out.println("Con los paréntesis puestos incorrectamente");
        System.out.println("1. 3)4-5+3( " + analizaParentesis("3)4-5+3("));
        System.out.println("2. 34-5+3( " +analizaParentesis("34-5+3("));
        System.out.println("3. 3)4-5+3 " +analizaParentesis("3)4-5+3--"));
        System.out.println("4. 34-5+3( " +analizaParentesis("34-5+3("));
        
        
        System.out.println("\nPrueba de analiza signo");
        System.out.println("Con los signos puestos correctamente");
        System.out.println("1. 1+7-58/6 " + revisaSignos("1+7-58/6")); 
        System.out.println("2.34-5+3 " + revisaSignos("34-5+3.0"));
        
        System.out.println("Con los signos puestos incorrectamente");
        System.out.println("1. 4/-5+3( " + revisaSignos("34/-5+3("));
        System.out.println("2. 34-5+-3( " +revisaSignos("34-5+-3("));
        System.out.println("3. 3**4-5+3 " +revisaSignos("3**4-5+3"));
        
        System.out.println("Prueba de revisaPunto");
        System.out.println("Con los puntos puestos correctamente");
        System.out.println("1.1(a+b)  " + revisaPunto("1(a+b)")); 
        System.out.println("2. 6+(-1(-5.6(3.4-5)+3.0)) " +revisaPunto("6+(-1(-5(34-5)+3.0))"));
        
        System.out.println("Con los puntos puestos incorrectamente");
        System.out.println("1. 3.2.4-5+3" + revisaPunto("3.2.4-5+3"));
        System.out.println("2. 3.4.6-5+3 " +revisaPunto("3.4.6-5+3"));
        System.out.println("3. .3.4-.5+3 " +revisaPunto(".3.4-.5+3"));
        
        
    }
}
