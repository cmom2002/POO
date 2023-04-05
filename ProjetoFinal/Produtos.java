package GestaoLoja;

import java.io.Serializable;

/**
 * The type Produtos.
 */
public class Produtos implements Serializable {
    private int identificador;
    private String nome;
    private String tipoPromocao;
    private float preco;
    private int stock;
    private String tipo;
    /**
     * The Preco transporte.
     */
    protected float precoTransporte;

    /**
     * Instantiates a new Produtos.
     *
     * @param id           the id
     * @param name         the name
     * @param preco        the preco
     * @param stock        the stock
     * @param tipo         the tipo
     * @param tipoPromocao the tipo promocao
     */
    public Produtos(int id, String name, float preco, int stock, String tipo, String tipoPromocao) {
        this.identificador = id;
        this.nome = name;
        this.preco = preco;
        this.stock = stock;
        this.tipo = tipo;
        this.tipoPromocao = tipoPromocao;
    }

    /**
     * Gets identificador.
     *
     * @return the identificador
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * Sets identificador.
     *
     * @param identificador the identificador
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    /**
     * Gets nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets nome.
     *
     * @param nome the nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Gets tipo promocao.
     *
     * @return the tipo promocao
     */
    public String getTipoPromocao() {
        return tipoPromocao;
    }

    /**
     * Sets tipo promocao.
     *
     * @param tipoPromocao the tipo promocao
     */
    public void setTipoPromocao(String tipoPromocao) {
        this.tipoPromocao = tipoPromocao;
    }

    /**
     * Gets preco.
     *
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * Sets preco.
     *
     * @param preco the preco
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     * Gets stock.
     *
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets stock.
     *
     * @param stock the stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Gets tipo.
     *
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Sets tipo.
     *
     * @param tipo the tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Preco transporte float.
     *
     * @return the float
     */
    public float precoTransporte(){
        precoTransporte = 0;
        return precoTransporte;
    }
    @Override
    public String toString() {
        return "Produto " + tipo +
                "\nIdentificador: " + identificador +
                "\nNome: " + nome +
                "\nPreco: " + preco + "€" +
                "\nStock: " + stock + "\n";
    }
}