package GestaoLoja;

import java.io.Serializable;

/**
 * The type Clientes.
 */
public class Clientes implements Serializable {
    private String nome;
    private String morada;
    private String email;
    private int telefone;
    private String dataNascimento;
    private boolean frequentes;

    /**
     * Instantiates a new Clientes.
     *
     * @param nome           the nome
     * @param morada         the morada
     * @param email          the email
     * @param telefone       the telefone
     * @param dataNascimento the data nascimento
     * @param frequentes     the frequentes
     */
    public Clientes(String nome, String morada, String email, int telefone, String dataNascimento, boolean frequentes) {
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.frequentes = frequentes;
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
     * Gets morada.
     *
     * @return the morada
     */
    public String getMorada() {
        return morada;
    }

    /**
     * Sets morada.
     *
     * @param morada the morada
     */
    public void setMorada(String morada) {
        this.morada = morada;
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
     * Gets telefone.
     *
     * @return the telefone
     */
    public int getTelefone() {
        return telefone;
    }

    /**
     * Sets telefone.
     *
     * @param telefone the telefone
     */
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    /**
     * Gets data nascimento.
     *
     * @return the data nascimento
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Sets data nascimento.
     *
     * @param dataNascimento the data nascimento
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Is frequentes boolean.
     *
     * @return the boolean
     */
    public boolean isFrequentes() {
        return frequentes;
    }

    /**
     * Sets frequentes.
     *
     * @param frequentes the frequentes
     */
    public void setFrequentes(boolean frequentes) {
        this.frequentes = frequentes;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", email='" + email + '\'' +
                ", telefone=" + telefone +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", frequentes=" + frequentes +
                '}';
    }
}