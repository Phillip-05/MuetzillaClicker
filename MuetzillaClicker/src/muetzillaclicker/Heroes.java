package muetzillaclicker;

public class Heroes implements Runnable {
    private Thread heroes;
    private final String threadName;

    public Heroes(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("Thread running " + threadName);

        // Methods that should be executed HERE


        System.out.println("Thread ended " + threadName);
    }

    public void start() {
        System.out.println("THREAD " + threadName + " STARTED");
        if (heroes == null) {
            heroes = new Thread(this, threadName);
            heroes.start();
        }
    }
}