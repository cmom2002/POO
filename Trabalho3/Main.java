package classes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bibliotecas biblioteca = new Bibliotecas();
        biblioteca.adicionar();

        int num;
        num = biblioteca.menu();
        do {

            if(num == 0){
                System.exit(1);
            }
            if (num == 1) {
                String a;
                int[] table = new int[3];
                int i = 0;
                while (biblioteca.verificar(table[0], table[1], table[2]) == 0) {
                    System.out.print("Data: ");
                    Scanner sc = new Scanner(System.in);
                    a = sc.nextLine();
                    String[] strsplit = a.split("/", 3);
                    for (String str : strsplit) {
                        int k = Integer.parseInt(str);
                        table[i] = k;
                        i++;
                    }
                }
                Data data = new Data(table[0], table[1], table[2]);
                biblioteca.listaRequisitados(data);
                System.out.print("\n");
                num = biblioteca.menu();
            }

            if (num == 2) {
                biblioteca.listaLivrosDisponiveis();
                System.out.print("\n");
                num = biblioteca.menu();
            }

            if (num == 3) {
                String lei;
                int n;
                int[] table = {0, 0, 0};
                int[] table1 = {0, 0, 0};
                String dtreq;
                String dtdev;

                System.out.print("Nome do leitor: ");
                Scanner sa = new Scanner(System.in);
                lei = sa.nextLine();

                System.out.print("Número de utente: ");
                Scanner sb = new Scanner(System.in);
                n = sb.nextInt();

                while (biblioteca.verificar(table[0], table[1], table[2]) == 0) {
                    System.out.print("Data de requisição: ");
                    Scanner sc = new Scanner(System.in);
                    dtreq = sc.nextLine();
                    String[] strsplit = dtreq.split("/", 3);
                    int j = 0;
                    for (String a : strsplit) {
                        int k = Integer.parseInt(a);
                        table[j] = k;
                        j++;
                    }
                }

                do {
                    System.out.print("Data de devolução: ");
                    Scanner sd = new Scanner(System.in);
                    dtdev = sd.nextLine();
                    String[] strsplit2 = dtdev.split("/", 3);
                    int p = 0;
                    for (String a : strsplit2) {
                        int k = Integer.parseInt(a);
                        table1[p] = k;
                        p++;
                    }
                } while (biblioteca.verificar(table1[0], table1[1], table1[2]) == 0 && biblioteca.verificar2(table, table1) == 0);

                Data data1 = new Data(table[0], table[1], table[2]);
                Data data2 = new Data(table1[0], table1[1], table1[2]);
                Leitor leitor = new Leitor(n, lei);
                biblioteca.requisitaLivro(leitor, data1, data2);
                System.out.print("\n");
                num = biblioteca.menu();
            }

        } while (num != 0);
    }

}

