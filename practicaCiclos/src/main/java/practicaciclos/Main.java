
package practicaciclos;
import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String[] args) {
        
        char menu1 = '\0';
        do {
            menu1=JOptionPane.showInputDialog(null,"El programa contará los numeros pares e impares desde 1 hasta "
                    + "el número de su escogencia."+"\n"+ "Elija la estructura ciclica deseada:"+"\n"+
                    "a. While"+"\n"+
                    "b. Do While"+"\n"+
                    "c. For"+"\n"+
                    "d. Salir").charAt(0);
            
            if (menu1!='d'){ //Validacion de salida del programa
            int userNumber = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "¿Hasta cual número desea hacer el conteo?"));

            int i=1;
            int evenCount=0;
            int unevenCount=0;
            
                switch (menu1){
                    case 'a': //While loop
                        while (i<=userNumber){
                            System.out.println(i);
                            if (i%2 == 0){
                                evenCount++;
                            }
                            if (i%2 == 1){
                                unevenCount++;
                            }
                            i++;
                        }
                    break;

                    case 'b': //Do While loop
                        do{
                            System.out.println(i);
                            if (i%2 == 0){
                                evenCount++;
                            }
                            if (i%2 == 1){
                                unevenCount++;
                            }
                            i++;
                        } while(i<=userNumber);
                    break;

                    case 'c': //For loop
                        for (;i<=userNumber; i++){
                            System.out.println(i);
                            if (i%2 == 0){
                                evenCount++;
                            }
                            if (i%2 == 1){
                                unevenCount++;
                            }
                        }
                    break;
                }
                
                System.out.println("La cantidad de numeros pares es: "+evenCount);
                System.out.println("La cantidad de numeros impares es: "+unevenCount);
            }
        } while (menu1 != 'd');      
    }   
}
