package classes;

public class Fragata extends BarcoMarinha{
    private String typeArtillery;

    /**
     * The constructor create a boat with the specific attributes of the boat
     * and a type of artillery, that is chosen by an aleatory number
     * @param structure The boat's structure
     * @param dimension The boat's dimension
     * @param registration The boat's registration
     */
    public Fragata(String structure, String dimension, int registration) {
        super(structure, dimension, registration);
        setTypeBarco(typeBarcoFragata);
        if(getRandom(1,0)== 0)
            this.typeArtillery = "Antiaérea";
        else
            this.typeArtillery = "Antissubmarina";
    }

    public String getTypeArtillery() {
        return typeArtillery;
    }

    public void setTypeArtillery(String typeArtillery) {
        this.typeArtillery = typeArtillery;
    }

    /**
     * @return The type of boat and is attributes
     */
    @Override
    public String toString() {
        return "Tipo de Barco: "+ getTypeBarco() + " " +
                 typeArtillery +
                super.toString();
    }
}