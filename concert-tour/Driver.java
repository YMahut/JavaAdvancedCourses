public class Driver{
    public static void run(){
        Concert c1 = new Concert("Orange Scene", 40000, 5);
        Concert c2 = new Concert("Gasv¾rket", 5000, 6);
        Concert c3 = new Concert("Vega", 2000, 5);
        
        Tour t = new Tour();
        t.addConcert(c1);
        t.addConcert(c2);
        t.addConcert(c3);
        
        t.print();
        System.out.println(t.getBigConcerts(6000));
        
    }
}
