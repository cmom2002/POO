package GestaoLoja;

import java.io.Serializable;

/**
 * The type Limpeza.
 */
public class Limpeza extends Produtos implements Serializable {
    private int grauToxicidade;

    /**
     * Instantiates a new Limpeza.
     *
     * @param identificador  the identificador
     * @param nome           the nome
     * @param preco          the preco
     * @param stock          the stock
     * @param grauToxicidade the grau toxicidade
     * @param tipoPromocao   the tipo promocao
     * @param tipoProduto    the tipo produto
     */
    public Limpeza(int identificador, String nome, float preco, int stock, int grauToxicidade, String tipoPromocao, String tipoProduto) {
        super(identificador, nome, preco, stock,tipoProduto, tipoPromocao);
        this.grauToxicidade = grauToxicidade;
    }

    /**
     * Gets grau toxicidade.
     *
     * @return the grau toxicidade
     */
    public int getGrauToxicidade() {
        return grauToxicidade;
    }

    /**
     * Sets grau toxicidade.
     *
     * @param grauToxicidade the grau toxicidade
     */
    public void setGrauToxicidade(int grauToxicidade) {
        this.grauToxicidade = grauToxicidade;
    }

    @Override
    public float precoTransporte(){
        precoTransporte = 0;
        return precoTransporte;
    }
    @Override
    public String toString() {
        return super.toString()  +
                "GrauToxicidade: " + grauToxicidade + "\n";
    }
}