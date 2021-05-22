package academy.learnprogramming;

public enum TrafficLightColor {

    CZERWONY(12000), ZIELONE(10000),ZOLTE(2000);
    private int delay;

    TrafficLightColor(int d ) {
        delay = d;
    }

    int getDelay(){
        return delay;
    }
}
