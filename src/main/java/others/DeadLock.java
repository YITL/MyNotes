package others;

public class DeadLock {

    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
    }

    private static class Thread1 implements Runnable{

        @Override
        public void run() {
            synchronized (obj1) {
                System.out.println("Thread1 get obj1");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (obj2) {
                    System.out.println("Thead2 get obj2");
                }
            }
        }
    }

    private static class Thread2 implements Runnable{

        @Override
        public void run() {
            synchronized (obj2) {
                System.out.println("Thread2 get obj2");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (obj1) {
                    System.out.println("Thread2 get obj1");
                }
            }
        }
    }

}
