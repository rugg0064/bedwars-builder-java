import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Class representing a base with layers of blocks
 * 
 * @author Matthew Kotras
 * @version 11/06/2020
 */
public class Base
{
    private ArrayList<Block> layers;
    public Base()
    {
        this.layers = new ArrayList<>();
    }

    public int getCost()
    {
        HashMap quantity = new HashMap(1);
        HashMap costs = new HashMap(1);
        for(int i = 0; i < this.layers.size(); i++)
        {
            Block block = this.layers.get(i);
            int count = blocksInLayer(i+1);
            quantity.put(block, count + (quantity.containsKey(block) ? (int)quantity.get(block) : 0) );
            costs.put(block.getResource(), 0);
        }
        
        LinkedList<Block> printOrder = new LinkedList();

        Iterator i = quantity.keySet().iterator();
        while(i.hasNext())
        {
            Block key = (Block) (i.next());
            int count = (int) quantity.get(key);

            int minOrderCount = count / key.getOrderCount();
            if( count % key.getOrderCount() > 0)
            {
                minOrderCount += 1;
            }

            int cost = minOrderCount * key.getCost();
            String resource = key.getResource();
            costs.put(resource, cost + (costs.containsKey(resource) ? (int)costs.get(resource) : 0) );
            printOrder.add(key);
        }

        Iterator k = printOrder.iterator();
        while(k.hasNext())
        {
            System.out.println( ((Block) k.next()).getName());
        }
        System.out.println();

        Iterator j = costs.keySet().iterator();
        while(j.hasNext())
        {
            String key = (String) j.next();
            int cost = (int)(costs.get(key));
            System.out.printf("%s : %d%n", key, cost);
        }

        return 0;
    }

    // amount of blocks in a bottom ring of layer
    public static int blocksInRing(int layer)
    {
        return (4*layer) + 2;
    }

    public static int blocksInLayer(int layer)
    {
        int sum = 0;
        for(int i = layer; i >= 0; i--)
        {
            sum += blocksInRing(layer);
        }
        return sum;
    }

    public ArrayList<Block> getLayers()
    {
        return this.layers;
    }

    public void addLayer(Block block)
    {
        layers.add(block);
    }
}