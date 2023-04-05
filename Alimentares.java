package GestaoLoja;

import java.io.Serializable;

/**
 * The type Alimentares.
 */
public class Alimentares extends Produtos implements Serializable {
    private int numeroCalorias;
    private int gordura;

    /**
     * Instantiates a new Alimentares.
     *
     * @param identificador  the identificador
     * @param nome           the nome
     * @param preco          the preco
     * @param stock          the stock
     * @param numeroCalorias the numero calorias
     * @param gordura        the gordura
     * @param tipoPromocao   the tipo promocao
     * @param tipoProduto    the tipo produto
     */
    public Alimentares(int identificador, String nome, float preco, int stock, int numeroCalorias, int gordura, String tipoPromocao, String tipoProduto) {
        super(identificador, nome, preco, stock, tipoProduto, tipoPromocao);
        this.numeroCalorias = numeroCalorias;
        this.gordura = gordura;
    }

    /**
     * Gets numero calorias.
     *
     * @return the numero calorias
     */
    public int getNumeroCalorias() {
        return numeroCalorias;
    }

    /**
     * Sets numero calorias.
     *
     * @param numeroCalorias the numero calorias
     */
    public void setNumeroCalorias(int numeroCalorias) {
        this.numeroCalorias = numeroCalorias;
    }

    /**
     * Gets gordura.
     *
     * @return the gordura
     */
    public int getGordura() {
        return gordura;
    }

    /**
     * Sets gordura.
     *
     * @param gordura the gordura
     */
    public void setGordura(int gordura) {
        this.gordura = gordura;
    }

    @Override
    public float precoTransporte(){
        precoTransporte = 0;
        return precoTransporte;
    }

    @Override
    public String toString() {
        return super.toString()  +
                "NumeroCalorias: " + numeroCalorias + "/100 gramas" +
                "\nGordura: " + gordura + "%" +
                "\n";
    }
}