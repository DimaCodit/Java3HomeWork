import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private CyclicBarrier startBarrier;
    private CountDownLatch endPreparingLatch;
    private CountDownLatch endRaceLatch;
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;

    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier startBarrier, CountDownLatch endPreparingLatch, CountDownLatch endRaceLatch) {
        this.race = race;
        this.speed = speed;
        this.startBarrier = startBarrier;
        this.endPreparingLatch = endPreparingLatch;
        this.endRaceLatch = endRaceLatch;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }
        endPreparingLatch.countDown();
        try {
            startBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        endRaceLatch.countDown();
    }
}