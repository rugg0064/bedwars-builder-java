import java.util.ArrayList;

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