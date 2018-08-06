/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author michaelbeltz
 */
public class Tally 
{
    private static Map<String, Integer> tally = new HashMap<String, Integer>();
    
    public synchronized static void set(String thread)
    {
        int i = 1;
        
        if (tally.containsKey(thread))
        {
            i = tally.get(thread);
            i ++;
        }
        
        tally.put(thread, i);
    }
    
    public static void log()
    {
        for (Map.Entry<String, Integer> entry : tally.entrySet()) 
        {
            String key = entry.getKey();
            Object value = entry.getValue();
            
            System.out.println(key + "  " + value);
        }
    }
}
