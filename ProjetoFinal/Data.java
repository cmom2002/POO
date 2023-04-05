package GestaoLoja;

import java.io.Serializable;

/**
 * The type Data.
 */
public class Data implements Serializable {
    private int dia;
    private int mes;
    private int ano;


    /**
     * Instantiates a new Data.
     *
     * @param dia the dia
     * @param mes the mes
     * @param ano the ano
     */
    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    /**
     * Gets dia.
     *
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * Gets ano.
     *
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * Sets dia.
     *
     * @param dia the dia
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * Sets mes.
     *
     * @param mes the mes
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * Sets ano.
     *
     * @param ano the ano
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Gets mes.
     *
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano ;
    }
}