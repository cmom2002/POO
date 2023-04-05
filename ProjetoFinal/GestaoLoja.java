package GestaoLoja;

import java.io.*;

import java.text.DecimalFormat;

import java.util.*;

public class GestaoLoja implements Serializable {

    private final String[] FICHEIRO = {"GestaoLoja/ClientesRegulares.txt", "GestaoLoja/Produtos.txt"};
    private final String[] PRODUTOS = {"Alimentar", "Limpeza", "Mobiliario"};
    private final String[] MES = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outobro", "Novembro", "Dezembro"};
    private final int[] PROMOCOES = {14, 24, 5};

    ArrayList<Produtos> produto;
    ArrayList<Clientes> clientes;
    ArrayList<ContaTotal> conta;
    ArrayList<Venda> carrinho;
    ArrayList<Data> data;
    ArrayList<Clientes> cliente;

    public GestaoLoja() {
        produto = new ArrayList<>();
        clientes = new ArrayList<>();
        conta = new ArrayList<>();
        data = new ArrayList<>();
        cliente = new ArrayList<>();

    }

    public static void main(String[] args) {
        GestaoLoja g = new GestaoLoja();
        System.out.println("\n************ BEM-VINDO AO P€NDIA ************\n          Produtos baratos e do dia          ");
        System.out.println("\n--------------------LOGIN--------------------");

        g.ficheiros();
        g.data();
        g.login();
        g.menu();
    }


    //------------------------------------------------Ler ficheiros de texto------------------------------------------------

    /**
     * This method verify if the file "Clientes.obj" exists.
     * If it's true, it means that the other files exists too, and will read them.
     * If it's false, it will read the text files.
     * This is meant to verify if it's the first program's run.
     */

    private void ficheiros() {
        File f1 = new File("Clientes.obj");
        if (f1.exists()) {
            lerFicheiroObjetos("Clientes.obj");
            lerFicheiroObjetos("Produtos.obj");
            lerFicheiroObjetos("Conta.obj");
        } else {
            ficheiroTexto(FICHEIRO[0], "CLIENTES");
            ficheiroTexto(FICHEIRO[1], "PRODUTOS");
        }
    }

    /**
     * This method reads the two files, line by line, and write them in the respective object's file
     *
     * @param nomeFicheiro The file's name
     * @param tipo         The file's type
     */

    private void ficheiroTexto(String nomeFicheiro, String tipo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeFicheiro))) {
            String linha = br.readLine();
            while (linha != null) {
                if (tipo.equals("CLIENTES")) {
                    ficheiroClientes(linha);
                } else
                    ficheiroProduto(linha);
                linha = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler linha.");
        }
        escreverFicheiroObjetos("Clientes.obj");
        escreverFicheiroObjetos("Produtos.obj");
    }

    /**
     * Separate the file's informations and add them to the clients arrayList
     * If the client is frequent the boolean become true
     *
     * @param linha One line of the client's file
     */

    private void ficheiroClientes(String linha) {
        String[] strsplit = linha.split(" ");
        String nome = strsplit[0];
        String morada = strsplit[1];
        String email = strsplit[2];
        int telefone = Integer.parseInt(strsplit[3]);
        String dataNascimento = strsplit[4];
        String frequentes = strsplit[5];
        switch (frequentes) {
            case "Sim" -> clientes.add(new Clientes(nome, morada, email, telefone, dataNascimento, true));
            case "Não" -> clientes.add(new Clientes(nome, morada, email, telefone, dataNascimento, false));
        }
    }

    /**
     * Separate the file's informations and add them to the products arrayList
     * Verify de product's type and add the information in the respective class
     *
     * @param linha One line of the product's file
     */

    private void ficheiroProduto(String linha) {
        String[] strsplit = linha.split(" ");
        int identificador = Integer.parseInt(strsplit[0]);
        String nome = strsplit[1];
        float preco = Float.parseFloat(strsplit[2]);
        int quantidade = Integer.parseInt(strsplit[3]);
        String type = strsplit[4];
        String promocao;
        int numeroCalorias;
        int gordura;
        int grauToxidade;
        int peso;
        int c, l, a;

        if (quantidade > 0) {
            switch (type) {
                case "Alimentar" -> {
                    numeroCalorias = Integer.parseInt(strsplit[5]);
                    gordura = Integer.parseInt(strsplit[6]);
                    promocao = strsplit[7];
                    produto.add(new Alimentares(identificador, nome, preco, quantidade, numeroCalorias, gordura, promocao, PRODUTOS[0]));
                }
                case "Limpeza" -> {
                    grauToxidade = Integer.parseInt(strsplit[5]);
                    promocao = strsplit[6];
                    produto.add(new Limpeza(identificador, nome, preco, quantidade, grauToxidade, promocao, PRODUTOS[1]));
                }
                case "Mobiliário" -> {
                    peso = Integer.parseInt(strsplit[5]);
                    String dim = strsplit[6];
                    promocao = strsplit[7];
                    String[] strsplit3 = dim.split("x");
                    c = Integer.parseInt(strsplit3[0]);
                    l = Integer.parseInt(strsplit3[1]);
                    a = Integer.parseInt(strsplit3[2]);
                    produto.add(new Mobiliario(identificador, nome, preco, quantidade, peso, c, l, a, promocao, PRODUTOS[2]));
                }
            }
        }
    }

    //----------------------------------------------Ler ficheiros de objetos------------------------------------------------

    /**
     * @param nomeFicheiro The name of the object's file
     */

    public void escreverFicheiroObjetos(String nomeFicheiro) {
        File f = new File(nomeFicheiro);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            if (nomeFicheiro.equals("Clientes.obj"))
                oos.writeObject(clientes);
            else if (nomeFicheiro.equals("Produtos.obj"))
                oos.writeObject(produto);
            else
                oos.writeObject(conta);
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro " + nomeFicheiro);
        }
    }

    /**
     * @param nomeFicheiro The name of the object's file
     */

    public void lerFicheiroObjetos(String nomeFicheiro) {
        File f = new File(nomeFicheiro);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            if (nomeFicheiro.equals("Clientes.obj"))
                clientes = (ArrayList<Clientes>) ois.readObject();
            else if (nomeFicheiro.equals("Produtos.obj"))
                produto = (ArrayList<Produtos>) ois.readObject();
            else
                conta = (ArrayList<ContaTotal>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a abrir ficheiro o caralho.");
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro a converter objeto.");
        }
    }

    //---------------------------------------------------------Login--------------------------------------------------------

    /**
     * Separate the day, month and year
     * Add in date Array List
     */

    private void data() {
        int[] tabela = new int[3];
        String strData;
        do {
            int j = 0;
            System.out.print("Insira a data: ");
            Scanner sc3 = new Scanner(System.in);
            strData = sc3.nextLine();
            String[] strDatasplit = strData.split("/");
            for (String a : strDatasplit) {
                int k = Integer.parseInt(a);
                tabela[j] = k;
                j++;
            }
        } while (!verificar(tabela[0], tabela[1], tabela[2]));

        data.add(new Data(tabela[0], tabela[1], tabela[2]));

    }

    /**
     * Asks the user's email and verify if it exists
     * If doesn't exist, the client isn't frequent and it's created a new user's count
     */

    private void login() {
        String str;
        int i = 0;
        boolean frequente = false;

        System.out.print("Insira o seu e-mail: ");
        Scanner sc2 = new Scanner(System.in);
        str = sc2.nextLine();

        for (Clientes c : clientes) {
            i++;
            if (str.equals(c.getEmail())) {
                System.out.println("\nLogin realizado com sucesso.");
                cliente.add(c);
                frequente = true;
            }
            if (i == clientes.size() && !frequente) {
                System.out.println("\nAinda não tem uma conta criada.");
            }
        }
        if (!frequente)
            criarConta();
    }

    /**
     * Verify if the user's date is valid
     *
     * @param dia The introduced day
     * @param mes The introduced month
     * @param ano The introduced year
     * @return True if the date is valid or false if it isn't
     */

    private boolean verificar(int dia, int mes, int ano) {
        if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) && (dia > 31 || dia < 1)) {
            System.out.println("Insira um dia válido. " + MES[mes - 1] + " só vai até dia 31.");
            return false;

        }
        if (mes == 2 && (dia > 28 || dia < 1)) {
            System.out.println("Insira um dia válido. " + MES[mes - 1] + "só tem 28 dias, exceto se for bissexto");
            if (dia == 29 && ano % 4 == 0) {
                return true;
            }
            return false;
        }
        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia > 30 || dia < 1)) {
            System.out.println("Insira um dia válido. " + MES[mes - 1] + " só vai até dia 30.");
            return false;
        }
        if (mes > 12 || mes < 1) {
            System.out.println("Insira um mês válido.");
            return false;
        }
        if (ano < 2010 || ano > 2022) {
            System.out.println("Insira um ano válido.");
            return false;
        }
        return true;
    }

    /**
     * Creat an new account
     * Put the information in the clients arrayList and in the client arrayList, that only contains the information of the person who is buying
     * Write in the object's file
     */

    private void criarConta() {
        System.out.println("Por favor insira os seguintes dados para realizarmos o seu login:");
        String[] dados = {"nome", "morada", "email", "telefone", "data de nascimento"};
        String[] d = new String[5];
        for (int i = 0; i < d.length; i++) {
            d[i] = dados(dados[i]);
        }
        int telefone = Integer.parseInt(d[3]);
        Clientes c = new Clientes(d[0], d[1], d[2], telefone, d[4], false);
        clientes.add(c);
        cliente.add(c);
        escreverFicheiroObjetos("Clientes.obj");
    }

    /**
     * @param d The login's parameters
     * @return The user´s data
     */

    private String dados(String d) {
        String str;
        System.out.print("Insira o seu " + d + ": ");
        Scanner sc2 = new Scanner(System.in);
        str = sc2.nextLine();
        return str;
    }

//---------------------------------------------------------Menu---------------------------------------------------------

    /**
     * Asks the user what option they want
     * Verify if the option is valid
     */

    private void menu() {
        int n;
        do {
            int count = 0;
            boolean verificar = false;
            do {
                if (count != 0) {
                    System.out.println("Opção inválida, escolha outra.\n");
                }

                System.out.println("\n---------------------MENU---------------------");
                System.out.println("\nEscolha uma opção:\n1- Realizar uma compra;\n2- Consultar as compras realizadas;\n0- Sair;");
                Scanner sc1 = new Scanner(System.in);
                n = sc1.nextInt();

                if (-1 < n && n < 3) {
                    verificar = true;
                }
                count++;

            } while (!verificar);

            switch (n) {
                case 0:
                    break;
                case 1:
                    realizarCompra();
                    break;
                case 2:
                    consultarCompra();
                    break;
            }
        } while (n != 0);
    }

//---------------------------------------------------Realizar uma compra------------------------------------------------

    /**
     * In this method the user choose a product to buy and a quantity
     * Add the product to the car
     * Remove the quantity from the stock
     * Verify if exists a promotion in the date introduced by the user and calculate the price if it does
     * If the product chosen it's already in the car, increase the quantity
     * Print the bill
     * Add the purchase to the Array List "conta"
     * Write in the respective object's files the new information
     */

    private void realizarCompra() {
        carrinho = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("0.00");
        int n;
        boolean confirmar = false;
        int contador = 0;
        float precoTotal = 0;
        boolean verifica = true;
        Venda v = null;
        do {

            int num;
            do {
                System.out.println("Que tipo de produtos deseja comprar?");
                System.out.println("1- Alimentar;\n2- Limpeza;\n3- Mobiliário;\n4- Voltar ao MENU;");
                Scanner sc2 = new Scanner(System.in);
                n = sc2.nextInt();
            }while(n < 1 || n > 4);

            switch (n) {
                case 1 -> imprimeProdutos(PRODUTOS[0]);
                case 2 -> imprimeProdutos(PRODUTOS[1]);
                case 3 -> imprimeProdutos(PRODUTOS[2]);
                case 4 -> menu();
            }

            boolean verifica1 = true, verifica2;
            int i = 0;

            do {
                verifica2 = true;
                if (i != 0) {
                    System.out.println("Esse produto não existe, escolha outro.");
                }
                System.out.print("Escolha um produto: ");
                Scanner sc3 = new Scanner(System.in);
                num = sc3.nextInt();

                for (Produtos p : produto) {
                    if (p.getIdentificador() == num && p.getTipo().equals(PRODUTOS[n - 1])) {
                        if (p.getStock() == 0) {
                            System.out.println("Esse produto já não tem stock existente.");
                            verifica2 = false;
                            i = 0;
                        } else
                            verifica1 = false;
                    }
                }
                if (verifica2)
                    i++;
            } while (verifica1);

            int q;
            System.out.print("Quantidade que quer: ");
            Scanner sc4 = new Scanner(System.in);
            q = sc4.nextInt();
            int quantidadeJunta = 0;

            for (Produtos p : produto) {
                if (p.getIdentificador() == num) {
                    do {
                        if (q < 1) {
                            System.out.println("Insira uma quantidade válida");
                            System.out.print("Insira uma nova quantidade: ");
                            Scanner sc5 = new Scanner(System.in);
                            q = sc5.nextInt();
                        }
                        if (q > p.getStock()) {
                            System.out.println("Desculpe mas so temos díponíveis " + p.getStock() + " unidades de " + p.getNome());
                            System.out.print("Insira uma nova quantidade: ");
                            Scanner sc5 = new Scanner(System.in);
                            q = sc5.nextInt();
                        }
                    } while (q > p.getStock() || q < 1);

                    double preco = 0;
                    if (confirmar) {
                        for (Venda v1 : carrinho) {
                            if (num == v1.getProduto().getIdentificador()) {
                                quantidadeJunta = v1.getQuantidade() + q;
                                v1.setQuantidade(quantidadeJunta);
                                contador++;
                            }
                        }
                    }
                    if (contador == 0) {
                        v = new Venda(p, q, p.precoTransporte());
                        carrinho.add(v);
                        confirmar = true;
                    }

                    for (Data d : data) {
                        if (d.getDia() > PROMOCOES[0] && d.getDia() < PROMOCOES[1] && d.getMes() == PROMOCOES[2])
                            preco = v.preco(q, p);
                        else
                            preco = v.getQuantidade() * v.getProduto().getPreco();
                    }
                    precoTotal += preco;
                    int novaQuantidade = p.getStock() - q;
                    p.setStock(novaQuantidade);
                }
            }

            int m, k;
            do{
                System.out.println("\nDeseja comprar mais alguma coisa?\n1- Sim\n2- Não");
                Scanner sc6 = new Scanner(System.in);
                m = sc6.nextInt();
            }while(m < 1 || m > 2);

            if (m == 2) {
                do {
                    do {
                        System.out.println("Deseja remover algum produto do carrinho?\n1- Sim\n2- Não");
                        Scanner sc7 = new Scanner(System.in);
                        k = sc7.nextInt();
                    }while(k < 1 || k > 2);
                    if (k == 1) {
                        precoTotal = removerProdutoCarrinho(precoTotal);
                    }
                    verifica = false;
                } while (k == 1);
            }

        } while (verifica);

        float precoSemPromocao = 0;
        System.out.println("\n--------------------FATURA--------------------\n\nCliente: " + cliente.get(0).getNome() + "\nData:    " + data.get(0).getDia() + "/" + data.get(0).getMes() + "/" + data.get(0).getAno() + "\n\nNome         Quantidade   Preço     Preço Total");
        for (Venda venda : carrinho) {
            float precoProduto = venda.getQuantidade() * venda.getProduto().getPreco();
            precoSemPromocao += precoProduto;
            System.out.print(venda.getProduto().getNome());
            int comprimento = venda.getProduto().getNome().length();

            for (int i = 0; i <= 12 - comprimento; i++) {
                System.out.print(" ");
            }
            System.out.print(venda.getQuantidade());
            if (venda.getQuantidade() < 10)
                comprimento = 12;
            else if (venda.getQuantidade() < 100)
                comprimento = 11;
            else
                comprimento = 10;
            for (int j = 0; j < comprimento; j++) {
                System.out.print(" ");
            }
            String precoFormatado = df.format(venda.getProduto().getPreco());
            System.out.print(precoFormatado);

            String precoProdutoFormatado = df.format(precoProduto);
            comprimento = precoProdutoFormatado.length();
            for (int j = 0; j < 10 - comprimento; j++) {
                System.out.print(" ");
            }
            System.out.println(precoProdutoFormatado);
        }
        String precoSemPromocaoFormatado = df.format(precoSemPromocao);
        String precoTotalFormatado = df.format(precoTotal);
        System.out.println("\nPreço s/ desconto:   " + precoSemPromocaoFormatado + "€" + "\nPreço c/ desconto:   " + precoTotalFormatado + "€");

        float precoTranporte = tranporte(precoTotal);
        String precoTranporteFormatado = df.format(precoTranporte);

        float precoT = precoTranporte + precoTotal;
        String precoTFormatado = df.format(precoT);

        System.out.println("Transporte:          " + precoTranporteFormatado + "€");
        System.out.println("\nPreço total:         " + precoTFormatado + "€");
        System.out.println("\n\nObrigado por comprar connosco!\nVolte Sempre\n");

        conta.add(new ContaTotal(carrinho, cliente.get(0).getEmail(), data));
        escreverFicheiroObjetos("Produtos.obj");
        escreverFicheiroObjetos("Conta.obj");
    }

    /**
     * Print the product's information, of all products in the asked type, which is received
     * Confirm if the stock is available
     *
     * @param str The product's type
     */

    private void imprimeProdutos(String str) {
        System.out.println("Escolha um produto:");
        for (Produtos p : produto) {
            if (p.getTipo().equals(str) && p.getStock() > 0) {
                System.out.println(p.getIdentificador() + "- " + p.getNome() + " " + p.getPreco() + "€");
            }
        }
    }

    /**
     * If the client is frequent and the price is above 40€, the transporation is free
     * If the client is frequent and the price is smaller 40€, the transporation is 15€
     * If the client isn't frequent, the transporation is 20€
     * Futhermore, increases the transportation price defined in each product's type class
     *
     * @param precoTotal purchase price with the promotions
     * @return The transportation price
     */

    private float tranporte(float precoTotal) {
        float transporte = 0;
        for (Clientes c : clientes) {
            if (c.getEmail().equals(cliente.get(0).getEmail())) {
                if (c.isFrequentes() && precoTotal >= 40)
                    transporte = 0;
                else if (c.isFrequentes() && precoTotal < 40)
                    transporte = 15;
                else
                    transporte = 20;
            }
        }
        for (Venda v : carrinho) {
            transporte += v.getPrecoTransporte();
        }
        return transporte;
    }

//---------------------------------------------------Consultar uma compra-----------------------------------------------

    /**
     * Print all the purchases made by the client
     */

    private void consultarCompra() {
        for (ContaTotal ct : conta) {
            if (ct.getEmail().equals(cliente.get(0).getEmail())) {
                System.out.println(ct);
            }
        }
    }

//---------------------------------------------Remover produto do carrinho----------------------------------------------

    /**
     * Asks the user what product they want to remove and the quantity
     * Verify if the quantity value is valid and if the user isn't trying to remove more product's quantity than bought
     * Decreased the product's price multiplied by the quantity to be removed to the total value
     * Update the product's quantity in the car
     * If the user eliminate all the quantity of chosen product, the product is removed from the Array List and the loop stops
     *
     * @param preco The total purchase price
     * @return The new price without the product the user eliminated
     */

    private float removerProdutoCarrinho(float preco) {
        int produto, q, quantidade;
        for (Venda v : carrinho) {
            System.out.println(v.getProduto().getIdentificador() + "  " + v.getProduto().getNome());
        }
        Venda v = null;
        while (v == null) {
            System.out.print("Que produto deseja remover: ");
            Scanner sc8 = new Scanner(System.in);
            produto = sc8.nextInt();
            int Identificador = produto;
            for (Venda venda : carrinho)
                if (venda.getProduto().getIdentificador() == Identificador)
                    v = venda;
        }
        System.out.print("Quantas unidades deseja remover: ");
        Scanner sc9 = new Scanner(System.in);
        q = sc9.nextInt();
        do {
            if (q < 1) {
                System.out.println("Insira uma quantidade válida.\nInsira uma nova quantidade: ");
                Scanner sc5 = new Scanner(System.in);
                q = sc5.nextInt();
            }
            if (q > v.getQuantidade()) {
                System.out.println("Só tem  " + v.getQuantidade() + " unidades de " + v.getProduto().getNome() + "no seu carrinho.\nInsira uma nova quantidade: ");
                Scanner sc5 = new Scanner(System.in);
                q = sc5.nextInt();
            }
        } while (q > v.getQuantidade() || q < 1);
        quantidade = v.getQuantidade() - q;
        v.setQuantidade(quantidade);
        preco = preco - v.preco(q, v.getProduto());
        if (quantidade == 0)
            carrinho.remove(v);


        return preco;
    }
}