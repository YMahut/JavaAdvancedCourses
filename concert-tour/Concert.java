public class Concert{
    private String venue;
    private int spectators;
    private int rating;
    public Concert(String v, int s, int r){
        venue = v;
        spectators = s;
        rating = r;
    }
    public String toString(){
        return venue + ", " + spectators + " spectators. Rating: " + rating;
    }
    public int getSpectators(){
        return spectators;
    }
}
