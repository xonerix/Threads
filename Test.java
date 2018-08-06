/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test
{
     // Maximum number of threads in thread pool
    static final int MAX_T = 3;             
 
    public static void main(String[] args)
    {
        // creates five tasks
        Runnable r1 = new Task("Task 1");
        Runnable r2 = new Task("Task 2");
        Runnable r3 = new Task("Task 3");
        Runnable r4 = new Task("Task 4");
        Runnable r5 = new Task("Task 5");      
         
        // creates a thread pool with MAX_T no. of 
        // threads as the fixed pool size(Step 2)
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);  
        
        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5); 
         
        // pool shutdown ( Step 4)
        pool.shutdown();
        
        try 
        {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            Tally.log();
        }
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
}