package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
	    TrafficLightSimulator tl = new TrafficLightSimulator(TrafficLightColor.ZIELONE);

	    Thread thrd = new Thread(tl);
	    thrd.start();

	    for(int i=0; i < 9; i++) {
            System.out.println(tl.getColor());
            tl.waitForChange();
        }

	    tl.cancel();

    }
}
