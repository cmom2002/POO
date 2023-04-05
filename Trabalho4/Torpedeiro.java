package classes;


public class Torpedeiro extends BarcoMarinha{
    public int numberTorpedoes;

    /**
     * The constructor create a boat with the specific attributes of the boat
     *  and a random number of torpedoes
     * @param structure The boat's structure
     * @param dimension The boat's dimension
     * @param registration The boat's registration
     */
    public Torpedeiro(String structure, String dimension, int registration) {
        super(structure, dimension, registration);
        this.numberTorpedoes = getRandom(6,0);
        setTypeBarco(typeBarcoTorpedeiro);
    }

    public int getNumberTorpedoes() {
        return numberTorpedoes;
    }

    public void setNumberTorpedoes(int numberTorpedoes) {
        this.numberTorpedoes = numberTorpedoes;
    }

    /**
     * @return The type of boat and is attributes
     */
    @Override
    public String toString() {

        String str = "";
        str += "Tipo de Barco: "+ getTypeBarco() + " com " + numberTorpedoes;

        if (numberTorpedoes == 1)
            str += " torpedo";
        else
            str += " torpedos";

        return str + super.toString();

    }
}