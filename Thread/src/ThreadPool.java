import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit tasks to the thread pool
        for (int i = 1; i <= 5; i++) {
            Task task = new Task("Task " + i);
            executor.submit(task);
        }

        // Shutdown the executor
        executor.shutdown();
    }
}

// Task class that implements Runnable
class Task implements Runnable {
    private String taskName;

    public Task(String name) {
        this.taskName = name;
    }

    @Override
    public void run() {
        System.out.println("Executing " + this.taskName + " in thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); // Simulating some task execution time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(taskName + " completed");
    }
}
