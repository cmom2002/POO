package classes;

import java.util.ArrayList;


public class Estaleiro {
    ArrayList<Barco> boat;

    public static void main(String[] args) {
        Estaleiro marina = new Estaleiro();
        marina.init();
    }

    /**
     * This constructor creates array list boat
     */
    public Estaleiro() {
        boat = new ArrayList<>();
    }

    /**
     * This method create ten boats with a structure, a dimension and a registration
     * I choose the type of the boat with an aleatory number,
     * and then I add the three parameters in the respective class in the array list
     * Print the array list boat
     */
    public void init(){

        String[] structure = {"Semi-rígidos","Rígidos"};

        String[] dimension = {"Pequeno","Médio","Grande"};

        int stc, dim, b;

        for(int i = 1; i < 11; i++ ){
            stc = random(1,0);
            dim = random(2,0);
            b = random(2,0);

            if(b == 0)
                boat.add(new BarcoPesca(structure[stc], dimension[dim], i));

            else if(b == 1)
                boat.add(new BarcoRecreio(structure[stc], dimension[dim], i));

            else{
                if(random(1,0) == 0)
                    boat.add(new Torpedeiro(structure[stc], dimension[dim], i));
                else
                    boat.add(new Fragata(structure[stc], dimension[dim], i));
            }
        }
        System.out.println("Barcos atracados na marina:");
        for(Barco boat: boat){
            System.out.println(boat);
        }
    }

    /**
     * This method return an aleatory number
     * @param max Receive a maximum number
     * @param min Receive a minimum number
     * @return An aleatory number
     */
    public int random(int max, int min){
        return(int)(Math.random() *(max - min + 1));
    }
}