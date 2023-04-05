

import java.util.*;

public class exercice1 {
    public static void main(String[] args) {
        int n;
        System.out.print ("Valor de N: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        if (n <= 0){
            System.out.print ("Número inválido.");
        }
        if(repetidos(n)){
            System.out.println ("Número com algarismos repetidos.");
        }
        else{
            desenha(n);
        }
    }
    public static boolean repetidos (int n){
        int algarismo, resto, numero;
        algarismo = n % 10;
        resto = n / 10;

        while(resto != 0){
            while(n / 10 > 0){
                n = n / 10;
                numero = n % 10;

                if(numero == algarismo){
                    return true;
                }
            }
            algarismo = resto % 10;
            n = resto;
            resto = resto / 10;
        }
        return false;
    }
    public static void desenha (int n){
        int maior_algarismo= 0, algarismos, num, num1, count = 0;
        num = n;

        while(num !=0 ){
            num1 = num % 10;
            num = num / 10;
            count++;

            if(maior_algarismo < num1){
                maior_algarismo = num1;
            }
        }
        algarismos = count;

        for (int i = maior_algarismo; i >= 0; i--){
            num = n;
            System.out.print (" ");
            for (int j = algarismos - 1; j >= 0; j--){
                num1 = num / (int)(Math.pow(10, j));
                num = num - num1 * (int)(Math.pow(10, j));

                if(i == 0){
                    System.out.print (num1 + " ");
                }
                else if(i - 1 >= num1){
                    System.out.print ("  ");
                }
                else{
                    System.out.print ("* ");
                }
            }
            System.out.print ("\n");
        }
    }
}
