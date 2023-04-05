package classes;

public class BarcoPesca extends Barco {
    private String typePesca;

    /**
     * The constructor create a boat with the specific attributes of the boat
     * @param structure The boat's structure
     * @param dimension The boat's dimension
     * @param registration The boat's registration
     */
    public BarcoPesca(String structure, String dimension, int registration) {
        super(structure, dimension, registration);
        setTypeBarco(typeBarcoPesca);
        typePesca();
    }

    /**
     * Sets the type of fishing, that is chosen by an aleatory number
     */
    public void typePesca(){
        if(getRandom(1,0) == 0)
            this.typePesca = "Cana";
        else
            this.typePesca = "Rede";
    }

    public String getTypePesca() {
        return typePesca;
    }

    public void setTypePesca(String typePesca) {
        this.typePesca = typePesca;
    }

    /**
     * @return The type of boat and is attributes
     */
    @Override
    public String toString() {

        return "Tipo de Barco: "+getTypeBarco()+
                " de " + typePesca +
                super.toString();
    }
}