package calculadora;

import java.util.ArrayList;

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
     * Invierte los elementos de la pila
     * @param <T> 
     * @param pila ingresa pila a invertir
     */
    
    private static <T> void invierte(PilaA<T> pila){
        ArrayList <T> elementos = new ArrayList(); 
        
        while(!pila.isEmpty())
            elementos.add(pila.pop());
        for(int i=0; i<elementos.size(); i++)
            pila.push(elementos.get(i));        
    }
    
    /**
     * Convierte pila de infija a postfija
     * @param infija Pila sin procesar
     * @return PilaA postfija 
     */
    public static PilaA infijaAPostfija(PilaA infija){
        Object elem;
        char elemChar;
        int prioridad;
        PilaA<Character> pila;
        PilaA postfija;
        
        pila=new PilaA();
        postfija=new PilaA();
        while(!infija.isEmpty()){
            elem=infija.pop();
            if(elem instanceof Double)
                postfija.push((double) elem);
            else{
                elemChar=(char) elem;
                switch (elemChar) {
                    case '(':
                        pila.push(elemChar);
                        break;
                    case ')':
                        while(!pila.isEmpty() && !pila.peek().equals('('))
                            postfija.push(pila.pop());
                        pila.pop();
                        break;
                    default:
                        prioridad=getPrioridad(elemChar);
                        if(prioridad!=-1){
                                while(!pila.isEmpty() && prioridad<=getPrioridad(pila.peek()))
                                        postfija.push(pila.pop());
                                pila.push(elemChar);
                                }
                        break;
                }
            }
        }
        while(!pila.isEmpty())
            postfija.push(pila.pop());
        invierte(postfija);
        return postfija;
    }
    
    /**
     * Convierte String de operacion a pila infija
     * @param operacion transforma la operación a una pila Infija
     * @return PilaA infija 
     */
    public static PilaA operacionAInfija(String operacion){
        PilaA infija;
        int i, j;
        char elem;
        
        infija=new PilaA();
        i=operacion.length()-1;
        while(i>=0){
            elem=operacion.charAt(i);
            j=i;
            while(j>=0&&((operacion.charAt(j)>47&&operacion.charAt(j)<58)||operacion.charAt(j)=='.'))
                j--;
            if(j<i){
                if(j>=0 && (operacion.charAt(j)=='-' && (j==0 || getPrioridad(operacion.charAt(j-1))>0))){
                    infija.push(-Double.parseDouble(operacion.substring(j+1, i+1)));
                    i=j-1;
                }else{
                    infija.push(Double.parseDouble(operacion.substring(j+1, i+1)));
                    i=j;
                }
            }else{
                infija.push(elem);
                i--;
            }
        }
        return infija;
    }
    
    /**
     * Hace los cálculos para que funcione las exponenciales en la computadora
     * @param num Número base
     * @param pow Potencia
     * @return Resultado de elevar num a pow
     */
    private static double exp(double num, int pow){
        double res;
        
        if(num==0)
            res=0;
        else
            if(pow<0)
                res=1/exp(num,-pow);
            else{
                res=1;
                for(int i=1; i<=pow; i++)
                    res*=num;
            }
        return res;
    }
    
    
    /**
     * Checa los valores de la pila postfija
     * @param postfija Pila postfija
     * @return Valores
     */
    public static double evaluaPostfija(PilaA postfija){
        double res, val1, val2;
        PilaA<Double> valores;
        
        res=0;
        valores=new PilaA();
        while(!postfija.isEmpty()){
            if(postfija.peek() instanceof Double)
                valores.push((double) postfija.pop());
            else{
                val1=(double) valores.pop();
                val2=(double) valores.pop();
                switch((char) postfija.pop()){
                    case '+':
                        valores.push(val1+val2);
                        break;
                    case '-':
                        valores.push(val2-val1);
                        break;
                    case '*':
                        valores.push(val1*val2);
                        break;
                    case '/':
                        valores.push(val2/val1);
                        break;
                    case '^':
                        valores.push(exp(val2,(int) val1));
                        break;
                }
            }
        }
        return valores.pop();
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
      * Revisa la sintaxis de la operación.
      * @param revisa Cadena a revisar
      * @return boolean que indica si hay signos, puntos o paréntesis escritos de manera incorrecta o algún caracter no reconocido.
      */
    public static boolean revisaSintaxis(String revisa){
        boolean resp;
        char next;
        int i, j;
        
        resp=true;
        i=0;
        while(i<revisa.length()-1 && resp){
            next=revisa.charAt(i+1);
            switch(revisa.charAt(i)){
                case '+', '*', '/', '^':
                    if(next=='+'||next=='*'||next=='/'||next=='^'||next=='.'||next==')'){
                        resp=false;
                    }
                    break;
                case '-':
                    if(next=='+'||next=='-'||next=='*'||next=='/'||next=='^'||next=='.'||next==')'){
                        resp=false;
                    }
                    break;
                case '.':
                    if(next=='+'||next=='-'||next=='*'||next=='/'||next=='^'||next=='.'||next=='('||next==')')
                        resp=false;
                    else{
                        j=i+1;
                        while(j<revisa.length() && revisa.charAt(j)!='.' && revisa.charAt(j)>47 && revisa.charAt(j)<58)
                            j++;
                        if(j<revisa.length()&&revisa.charAt(j)=='.')
                            resp=false;
                    }
                    break;
                case '(':
                    if(next=='+'||next=='*'||next=='/'||next=='^'||next=='.'||next==')')
                        resp=false;
                    break;
                case ')':
                    if(next=='.'||next=='(')
                        resp=false;
                    break;
                default:
                    if(revisa.charAt(i)<48||revisa.charAt(i)>57)
                           resp=false;
                    break;
            }
            i++;      
        }
        if(!resp){
            next=revisa.charAt(revisa.length()-1);
            if(next=='+'||next=='-'||next=='*'||next=='/'||next=='^'||next=='.'||next=='('||next==')')
                resp=false;
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
        System.out.println("1. 1+7-58/6 " + revisaSintaxis("1+7-58/6")); 
        System.out.println("2.34-5+3 " + revisaSintaxis("34-5+3.0"));
        
        System.out.println("Con los signos puestos incorrectamente");
        System.out.println("1. 4/-5+3( " + revisaSintaxis("34/*5+3("));
        System.out.println("2. 34-5+-3( " +revisaSintaxis("34-5++3("));
        System.out.println("3. 3**4-5+3 " +revisaSintaxis("3**4-5+3"));
        
        System.out.println("Prueba de revisaPunto");
        System.out.println("Con los puntos puestos correctamente");
        System.out.println("1.1*(a+b)  " + revisaSintaxis("1.1*(2+3)")); 
        System.out.println("2. 6+(-1(-5.6(3.4-5)+3.0)) " +revisaSintaxis("6+(-1*(-5*(34-5)+3.0))"));
        
        System.out.println("Con los puntos puestos incorrectamente");
        System.out.println("1. 3.2.4-5+3 " +revisaSintaxis("3.2.4-5+3"));
        System.out.println("2. 3.4.6-5+3 " +revisaSintaxis("3.4.6-5+3"));
        System.out.println("3. .3.4-.5+3 " +revisaSintaxis(".3.4-.5+3"));
        
        
    }
}
