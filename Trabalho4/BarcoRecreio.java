package classes;

public class BarcoRecreio extends Barco{
    private int maxOccupation;

    /**
     * The constructor create a boat with specific attributes
     * and is maximum occupation that is a non-zero random number
     * @param structure The boat's structure
     * @param dimension The boat's dimension
     * @param registration The boat's registration
     */
    public BarcoRecreio(String structure, String dimension, int registration) {
        super(structure, dimension, registration);
        this.maxOccupation = occupation(1, 0);;
        setTypeBarco(typeBarcoRecreio);
    }

    /**
     * This method certificates that the boat's occupation is a non-zero number
     * @return An aleatory number
     */
    public int occupation(int max, int min){
        int i;
        do{
            i = getRandom(max,min);
        }while(i == 0);
        return i;
    }

    public int getMaxOccupation() {
        return maxOccupation;
    }

    public void setMaxOccupation(int maxOccupation) {
        this.maxOccupation = maxOccupation;
    }

    /**
     * @return The type of boat and is attributes
     */
    @Override
    public String toString() {
        String str = "";
        str += "Tipo de Barco: "+ getTypeBarco() + " com " + maxOccupation;

        if (maxOccupation == 1)
            str += " passageiro";
        else
            str += " passageiros";

        return str + super.toString();

    }

}