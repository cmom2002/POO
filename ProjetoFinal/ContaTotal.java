package GestaoLoja;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Conta total.
 */
public class ContaTotal implements Serializable {
    private ArrayList<Venda> carrinho;
    private String email;
    private ArrayList<Data> data;

    /**
     * Instantiates a new Conta total.
     *
     * @param carrinho the carrinho
     * @param email    the email
     * @param data     the data
     */
    public ContaTotal(ArrayList<Venda> carrinho, String email, ArrayList<Data> data) {
        this.carrinho = carrinho;
        this.email = email;
        this.data = data;
    }

    /**
     * Gets carrinho.
     *
     * @return the carrinho
     */
    public ArrayList<Venda> getCarrinho() {
        return carrinho;
    }

    /**
     * Sets carrinho.
     *
     * @param carrinho the carrinho
     */
    public void setCarrinho(ArrayList<Venda> carrinho) {
        this.carrinho = carrinho;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets data.
     *
     * @return the data
     */
    public ArrayList<Data> getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     */
    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data + "\n" + carrinho ;
    }
}