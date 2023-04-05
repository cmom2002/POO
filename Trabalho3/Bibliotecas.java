package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Bibliotecas {
    private ArrayList<Livro> livros;
    private ArrayList<Requisicao> requisitados;
    private ArrayList<Leitor> leitor;


    public Bibliotecas() {
        livros = new ArrayList<>();
        requisitados = new ArrayList<>();
        leitor =  new ArrayList<>();
    }

    public void adicionar() {
        Livro livro1 = new Livro("O gato que ensinou a gaivota a voar", "Luis Sepúlveda");
        Livro livro2 = new Livro("Cherub", "Robert Muchamore");
        Leitor utente1 = new Leitor(1234, "Carlos Matos");
        Data data1 = new Data(11, 7, 2002);
        Data data2 = new Data(20, 10, 2021);
        Requisicao req1 = new Requisicao(livro1, utente1, data1, data2);

        livros.add(livro1);
        livros.add(livro2);
        requisitados.add(req1);
        leitor.add(utente1);
    }

    public int menu() {
        int num;
        System.out.print("Escolha uma opção:\n1: Livros requisitados numa data\n2: Livros disponíveis\n3: Requisitar um livro\n0: Sair\nOpção: ");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        return num;
    }

    public int verificar(int dia, int mes, int ano) {
        if (mes > 12 || mes < 1) {
            return 0;
        }
        if (ano < 1) {
            return 0;
        }
        if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) && (dia > 31 || dia < 1)) {
            return 0;

        }
        if (mes == 2 && (dia > 28 || dia < 1)) {
            if (dia == 29 && ano % 4 == 0) {
                return 1;
            }
            return 0;
        }
        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia > 30 || dia < 1)) {
            return 0;
        }
        return 1;
    }

    public int verificar2(int[] req, int[] dev) {
        if (dev[2] < req[2])
            return 0;

        if (dev[2] == req[2] && (dev[1] > req[1]))
            return 1;

        if (dev[2] == req[2] && dev[1] == req[1] && dev[0] <= req[0])
            return 0;

        if (dev[2] == req[2] && dev[1] < req[1])
            return 0;
        return 1;
    }

    public void listaRequisitados(Data d) {
       for (int i = 0; i < requisitados.size(); i++) {
            Requisicao req = requisitados.get(i);
            if (req.getDataRequesicao().getDia() == d.getDia() && req.getDataRequesicao().getMes() == d.getMes() && req.getDataRequesicao().getAno() == d.getAno()) {
                System.out.println(req.getLivro().getTitulo() + ", " + req.getLivro().getAutor());
            }
            else{
                System.out.println("Não existe nenhum livro requisitado nessa data.");
            }
        }

    }

    public void listaLivrosDisponiveis() {
        for (Livro disponivel : livros) {
            System.out.print(disponivel);
        }
    }



    public void requisitaLivro(Leitor leitor, Data dataRequesicao, Data dataDevolucao) {
        String liv;
        String aut;

        System.out.print("Nome do livro: ");
        Scanner sc = new Scanner(System.in);
        liv = sc.nextLine();

        System.out.print("Nome do autor: ");
        Scanner sd = new Scanner(System.in);
        aut = sd.nextLine();

        Livro livro = new Livro(liv, aut);
        Requisicao req = new Requisicao(livro, leitor, dataRequesicao, dataDevolucao);
    }
}
