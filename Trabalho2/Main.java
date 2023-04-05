package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int tam;
        System.out.print ("Insira o tamanho da tabela: ");
        Scanner sc = new Scanner(System.in);
        tam = sc.nextInt();

        if(verifica(tam) == 1){
            constroiTabela(tam);
        }
    }

    public static int verifica(int tam){
        if(tam > 2){
            return 1;
        }
        else{
            return 0;
        }
    }

    public static void constroiTabela(int tam) {
        int[] tab = new int[tam];

        for (int i = 0; i < tam; i++){
            tab[i] = recebeNum(i);
        }

        subTabela(tab);
    }

    public static int recebeNum(int i) {
        System.out.print ("Insira o número "+ (i + 1) +": ");
        int num;
        Scanner sr = new Scanner(System.in);
        num = sr.nextInt();
        return num;
    }

    public static void subTabela(int[] tab){
        int [] tab2 = new int[tab.length];
        int [] subtab = new int[tab.length];

        System.arraycopy(tab, 0, tab2, 0, tab.length);

        int num;
        for(int k = 0; k < tab2.length; k++){
            for (int l = 0; l < tab2.length; l++){

                if(tab2[k] < tab2[l]){
                    num = tab2[k];
                    tab2[k] = tab2[l];
                    tab2[l] = num;
                }
            }
        }

        int a = 0;

        for(int m = 0; m < tab2.length; m++){
            if(tab[m] != tab2[m]){
                subtab[a] = tab[m];
                a++;
            }
        }

        for(int n = 0; n < tab.length; n++){
            for(int o = 0; o < tab.length; o++){

                if(subtab[0] == tab [o] && subtab[a-1] == tab[n]){
                    System.out.print ("Sub-tabela:\n{");

                    for(int p = o; p < n; p++){
                        System.out.print(tab[p] + ", ");
                    }

                    System.out.println (tab[n]+"}\n");
                    System.exit(1);
                }
            }
        }
    }
}