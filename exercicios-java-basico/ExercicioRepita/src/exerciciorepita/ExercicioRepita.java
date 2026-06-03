/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exerciciorepita;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ExercicioRepita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n, s = 0, p = 0, i = 0,a = 0, c = 0;
        do {
            n = Integer.parseInt(JOptionPane.showInputDialog(null, "<html>Digite um numero: <br><em>(valor 0 interrompe)</em></html>"));
            if (n != 0){ 
                c++;
                s += n;
                if (n % 2 == 0){
                    p ++;
                }else{
                    i ++;
                }
                if (n > 100){
                    a ++;
                }
            }
        }while(n != 0);
        int m = (c == 0) ? 0 : s / c;
        JOptionPane.showMessageDialog(null, "<html>Resultado Final<br><hr>" + 
                "<br>Total valores: " + s +
                "<br>Total pares: " + p +
                "<br>Total impares: " + i +
                "<br>Acima de 100: " + a +
                "<br>Media valores: " + m +
                "</html>");
    }
}
