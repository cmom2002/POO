package GestaoLoja;

import java.io.Serializable;

/**
 * The type Venda.
 */
public class Venda implements Serializable {
    private Produtos produto;
    private int quantidade;
    private float precoTransporte;

    /**
     * Instantiates a new Venda.
     *
     * @param produto         the produto
     * @param quantidade      the quantidade
     * @param precoTransporte the preco transporte
     */
    public Venda(Produtos produto, int quantidade, float precoTransporte) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoTransporte = precoTransporte;
    }

    /**
     * Gets produto.
     *
     * @return the produto
     */
    public Produtos getProduto() {
        return produto;
    }

    /**
     * Sets produto.
     *
     * @param produto the produto
     */
    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    /**
     * Gets quantidade.
     *
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Sets quantidade.
     *
     * @param quantidade the quantidade
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Gets preco transporte.
     *
     * @return the preco transporte
     */
    public float getPrecoTransporte() {
        return precoTransporte * quantidade;
    }

    /**
     * Sets preco transporte.
     *
     * @param precoTransporte the preco transporte
     */
    public void setPrecoTransporte(float precoTransporte) {
        this.precoTransporte = precoTransporte;
    }

    /**
     * Preco float.
     * Verify if the product has any type of promotion
     * @param quantidade the quantidade
     * @param produto    the produto
     * @return the float
     */
    public float preco(int quantidade, Produtos produto) {
        int novaQuantidade;
        float preco = 0;
        if(produto.getTipoPromocao().equals("Nenhum")){
            preco = produto.getPreco() * quantidade;
        }
        if (produto.getTipoPromocao().equals("LeveMais")) {
            novaQuantidade = quantidade - quantidade / 4;
            preco = produto.getPreco() * novaQuantidade;
        }
        if (produto.getTipoPromocao().equals("PagueMenos")) {
            preco = 0;
            float j = 1;
            for (int i = 1; i <= quantidade; i++) {
                preco += produto.getPreco() * j;
                if (j > 0.5)
                    j -= 0.05;
            }
        }
        return preco;
    }

    @Override
    public String toString() {
        return  "Nome: " + produto.getNome()+
                " | Quantidade: " + quantidade +
                " | Preço: " + produto.getPreco() + "€" +
                " | Preço Total: " + quantidade * (produto.getPreco()) + "€" + "\n\n";
    }
}