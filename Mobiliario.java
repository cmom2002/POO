package GestaoLoja;

import java.io.Serializable;

/**
 * The type Mobiliario.
 */
public class Mobiliario extends Produtos implements Serializable {
    private int peso;
    private int comprimento;
    private int largura;
    private int altura;

    /**
     * Instantiates a new Mobiliario.
     *
     * @param identificador the identificador
     * @param nome          the nome
     * @param preco         the preco
     * @param stock         the stock
     * @param peso          the peso
     * @param comprimento   the comprimento
     * @param largura       the largura
     * @param altura        the altura
     * @param tipoPromocao  the tipo promocao
     * @param tipoProduto   the tipo produto
     */
    public Mobiliario(int identificador, String nome, float preco, int stock, int peso, int comprimento, int largura, int altura, String tipoPromocao, String tipoProduto) {
        super(identificador, nome, preco, stock, tipoProduto, tipoPromocao);
        this.peso = peso;
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
    }

    /**
     * Gets peso.
     *
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * Sets peso.
     *
     * @param peso the peso
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * Gets comprimento.
     *
     * @return the comprimento
     */
    public int getComprimento() {
        return comprimento;
    }

    /**
     * Sets comprimento.
     *
     * @param comprimento the comprimento
     */
    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    /**
     * Gets largura.
     *
     * @return the largura
     */
    public int getLargura() {
        return largura;
    }

    /**
     * Sets largura.
     *
     * @param largura the largura
     */
    public void setLargura(int largura) {
        this.largura = largura;
    }

    /**
     * Gets altura.
     *
     * @return the altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * Sets altura.
     *
     * @param altura the altura
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public float precoTransporte() {
        precoTransporte = 0;
        if(peso > 15){
            precoTransporte = 10;
        }

        return precoTransporte;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Peso:" + peso +
                "\nDimensao: " + comprimento + "x"
                + largura + "x" + altura +
                "\n";
    }
}
