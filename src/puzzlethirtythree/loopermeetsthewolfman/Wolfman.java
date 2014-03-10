package puzzlethirtythree.loopermeetsthewolfman;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Wolfman
{

//        Provide a declaration for i that turns this loop into an infinite loop. This one doesn't require the use of any release 5.0
//        features:
//        while (i != 0 && i == -i) {
//        }

        public static void main(String[] args)
        {

                final long i = Long.MIN_VALUE;
                // or:
                // int i = Integer.MIN_VALUE;
//                short i = Short.MIN_VALUE;
//                while ((i != 0) && (i == (short)-i)) {}
                System.out.println(i + i);
                System.out.println(StrictMath.IEEEremainder(0.534d, 0.535d));
//                while ((i != 0) && (i == -i)) {}
//                System.out.println(i);
//                System.out.println(Integer.toHexString(i));
//                System.out.println(Integer.toHexString(-i));
//                System.out.println(-i);
                final long x = (Long.MIN_VALUE  + 2) / 3;
                final long y = (Long.MIN_VALUE );
                System.out.println(x);
                System.out.println(y);
                System.out.println((x * 3) + Long.MIN_VALUE);
                FutureTask future = new FutureTask(new Callable<Void>() {
                        @Override
                        public Void call() throws Exception
                        {
                                return (Void) new Object();
                        }
                });
                new ThreadPoolExecutor(1, 1, 100L, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(1)).execute(future);
                System.out.println(future.isCancelled());
                System.out.println(future.isDone());
                future.cancel(true);

                for (int j = 0; j < 3; j++)
                {


                }
        }
}
