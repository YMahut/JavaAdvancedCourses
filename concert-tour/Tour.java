import java.util.*;
public class Tour{
    private ArrayList<Concert> concerts;
    public Tour(){
        concerts = new ArrayList<Concert>();
    }
    public void addConcert(Concert c){
        concerts.add(c);
    }
    public void print(){
        for(Concert c : concerts){
            System.out.println(c);
        }
    }
    
    public ArrayList<Concert> getBigConcerts(int i){
        ArrayList<Concert> result = new ArrayList<Concert>();
        for (Concert c : concerts){
            if (i < c.getSpectators()) {
                result.add(c);
            }
        }
        return result;
    }
    
}
