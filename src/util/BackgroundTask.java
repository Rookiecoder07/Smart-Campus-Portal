package util;

import java.util.concurrent.*;

public class BackgroundTask {

    public static void run(Runnable task) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(() -> {
            try {
                task.run();
            } catch (Exception e) {
                System.out.println("Thread Error: " + e.getMessage());
            }
        });
        service.shutdown();
    }
}
