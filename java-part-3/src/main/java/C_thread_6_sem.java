import java.util.concurrent.Semaphore;

class Car implements Runnable {

    // 주차장 자리 3개 = 허가권 3개
    private static final Semaphore parkingLot = new Semaphore(3);

    private final String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        boolean acquired = false;

        try {
            System.out.println(name + " : 주차 자리를 기다리는 중...");

            parkingLot.acquire(); // 주차권 받기, 없으면 대기
            acquired = true;

            System.out.println(name + " : 주차 완료! (남은 자리 : " + parkingLot.availablePermits() + ")");

            Thread.sleep(2000); // 2초 동안 주차 중

            System.out.println(name + " : 출차합니다.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            if (acquired) {
                parkingLot.release(); // 주차권 반납
            }
        }
    }
}

public class C_thread_6_sem {
    public static void main(String[] args) {
        // 차 6대가 한꺼번에 주차 시도
        for (int i = 1; i <= 6; i++) {
            new Thread(new Car("Car-" + i)).start();
        }
    }
}