package puzzleseventyseven.thelockmessmonster;

/*
        This program runs a little workplace simulation. It starts a worker thread that works—or at least pretends to work—until
        quitting time. Then the program schedules a timer task representing an evil boss who tries to make sure that it's never quitting
        time. Finally, the main thread, representing a good boss, tells the worker when it's quitting time and waits for the worker to
        finish. What does the program print?

        import java.util.*;

        public class Worker extends Thread
        {
                private volatile boolean quittingTime = false;

                public void run()
                {
                        while (!quittingTime)
                                pretendToWork();
                        System.out.println("Beer is good");
                }

                private void pretendToWork()
                {
                        try
                        {
                                Thread.sleep(300); // Sleeping on the job?
                        } catch (InterruptedException ex) { }
                }

                // It's quitting time, wait for worker - Called by good boss
                synchronized void quit() throws InterruptedException
                {
                        quittingTime = true;
                        join();
                }

                // Rescind quitting time - Called by evil boss
                synchronized void keepWorking()
                {
                        quittingTime = false;
                }

                public static void main(String[] args) throws InterruptedException
                {
                        final Worker worker = new Worker();
                        worker.start();
                        Timer t = new Timer(true); // Daemon thread
                        t.schedule(new TimerTask()
                        {
                                public void run() { worker.keepWorking(); }
                        }, 500);
                        Thread.sleep(400);
                        worker.quit();
                }
        }
*/

import java.util.Timer;
import java.util.TimerTask;

public class Worker implements Runnable
{
        private volatile boolean quittingTime;

        public void run()
        {
                while (!quittingTime)
                        pretendToWork();
                System.out.println("Beer is good");
        }

        private void pretendToWork()
        {
                try
                {
                        Thread.sleep(300); // Sleeping on the job?
                } catch (InterruptedException ex) { }
        }

        // It's quitting time, wait for worker - Called by good boss
        synchronized void quit() throws InterruptedException
        {
                quittingTime = true;
        }

        // Rescind quitting time - Called by evil boss
        synchronized void keepWorking()
        {
                quittingTime = false;
        }

        public static void main(String[] args) throws InterruptedException
        {
                final long l = System.currentTimeMillis();
                final Worker worker = new Worker();
                final Thread thread = new Thread(worker);
                thread.start();
                Timer t = new Timer(true); // Daemon thread
                t.schedule(new TimerTask()
                {
                        public void run()
                        {
                                worker.keepWorking();
                        }
                }, 100);
                t.schedule(new TimerTask()
                {
                        public void run()
                        {
                                try
                                {
                                        worker.quit();
                                }
                                catch (InterruptedException e)
                                {
                                        e.printStackTrace();
                                }
                        }
                }, 200);
                Thread.sleep(400);
//                while(!worker.quittingTime)
                thread.join();
                System.out.println((System.currentTimeMillis() - l) / 1000.0d);
        }
}
// First guess: on calling Thread.sleep, the invoking thread relinquishes any locks it may have acquired. <---WRONG!!! it holds on to any monitor it may have
// I was going to say that the main thread does not join and hence might exit before the worker thread finishes,
// but then I saw the call to join in Worker#quit().
// Not familiar with Timer/TimerTask API- whether schedule() will actually start the thread. <---Instantiation starts the thread, scheduling the task starts the task within the thread
// And, by the way, the JVM will exit if all non-daemon threads have finished.
// The placement of the join invocation seems questionable to me. If you can only join when you've acquired the
// monitor on an object, calling join in the quit method is actually okay (????)
// What else do we know about multithreading????? quittingTime is volatile, and only used for "atomic" read/writes,
// so that much appears to be correct.
// What about a thread checking its own interrupted status flag? From what I remember, that's only necessary when a thread
// goes a long time performing many operations - none of which are interruptable
// if the main thread is interrupted during its sleep on line 102, it will never call worker.quit() because it doesn't
// catch the InterruptedException - but rather rethrows
// join's documentation- "waits for THIS thread to die" (emphasis mine). Note that join is not being called on the worker thread,<---- WRONG
// but the main thread.
// Final prediction: it may exit before printing anything on some runs

// What actually happened: deadlock. Where might it be locked??? My guess (before pausing execution): timer task may not have
// even begun if timer thread was not able to acquire worker's monitor
// After pausing and inspecting, main is blocked on call to join() inside quit,timer thread has not even queued that task yet,
// and worker thread continues to sleep
// so i think that the timertask already executed and removed the task from the queue. But why is join() blocking????
// well, there are three threads listed in the debugger but upon further inspection, worker and main have the same thread id and name.
// so are they one and the same thread???? If they are, then that would explain why join is blocking, the worker will never check its quittingTime flag because it's part
// But Thread.activeCount() returns 3.
// I still think the problem is join being called in a synchronized method. It waits for itself to die (which already doesn't make much sense, but it does so in a synchronized
// method - hence holding on to woker's monitor <---- This is exactly where the error in my reasoning lies. Calling join() internally calls wait() which actually releases any acquired locks!!!! This is what allows the timertask/evil boss to repeatedly
// sneak in and set quittingTime to false
// on debuging, the it's noted that the timertask does run

// *********Solution is on line 137********************
// Lesson is to use private lock and not a thread instance as a monitor. In quit(), the worker thread instance is locked by main thread, but then join is called which releases the lock on it. If a separate private object was used to lock,
// once that private lock is acquired, calling join on the worker thread will not interfere

// Solution:
/*
private final Object lock = new Object();
        // It's quitting time, wait for worker - Called by good boss
        void quit() throws InterruptedException {
                synchronized (lock) {
                        quittingTime = true;
                        join();
                }
        }
        // Rescind quitting time - Called by evil boss
        void keepWorking() {
                synchronized (lock) {
                        quittingTime = false;
                }
        }
*/
