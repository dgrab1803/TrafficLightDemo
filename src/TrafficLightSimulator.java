package academy.learnprogramming;

public class TrafficLightSimulator implements Runnable {
    private TrafficLightColor tlc;
    boolean stop = false;
    boolean changed = false;

    TrafficLightSimulator(TrafficLightColor init){
        tlc = init;
    }

    TrafficLightSimulator() {
        tlc = TrafficLightColor.CZERWONY;
    }
    public void run(){
        while(!stop) {
            try{
                Thread.sleep(tlc.getDelay());

            }catch (InterruptedException exc){
                System.out.println(exc);
            }
            changeColor();
        }
    }
    synchronized void changeColor() {
        switch (tlc) {
            case CZERWONY:
                tlc = TrafficLightColor.ZIELONE;
                break;
            case ZOLTE:
                tlc = TrafficLightColor.CZERWONY;
                break;
            case ZIELONE:
                tlc = TrafficLightColor.ZOLTE;
        }
        changed = true;
        notify();
    }
    synchronized void waitForChange(){
        try {
            while(!changed)
                wait();
            changed = false;
        }catch (InterruptedException exc){
            System.out.println(exc);
        }
    }
    synchronized TrafficLightColor getColor (){
        return tlc;
    }
    synchronized void cancel() {
        stop = true;
    }

}
