package classes;

public class Barco {
    private String typeBarco;
    private String structure;
    private String dimension;
    private int registration;

    protected static final String typeBarcoPesca = "Pesca";
    protected static final String typeBarcoRecreio = "Recreio";
    protected static final String typeBarcoTorpedeiro = "Torpedeiro";
    protected static final String typeBarcoFragata = "Fragata";

    /**
     * The constructor create a boat with a specific structure, dimension and registration
     * @param structure The boat's structure
     * @param dimension The boat's dimension
     * @param registration The boat's registration
     */
    public Barco(String structure, String dimension, int registration) {
        this.structure = structure;
        this.dimension = dimension;
        this.registration = registration;
    }

    public String getTypeBarco() {
        return typeBarco;
    }

    public void setTypeBarco(String typeBarco) {
        this.typeBarco = typeBarco;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public int getRegistration() {
        return registration;
    }

    public void setRegistration(int registration) {
        this.registration = registration;
    }

    /**
     * This method return an aleatory number
     * @param max Receive a maximum number
     * @param min Receive a minimum number
     * @return An aleatory number
     */
    public int getRandom(int max, int min){
        return(int)(Math.random() *(max - min + 1));
    }

    /**
     * @return The boat's attributes
     */
    @Override
    public String toString() {
        return  " ---> Estrutura: " + structure +
                " || Dimensão: " + dimension +
                " || Matrícula: B" + registration +
                ";";
    }
}