import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class representing a base with layers of blocks
 * 
 * @author Matthew Kotras
 * @version 11/06/2020
 */
public class Block
{
    private static final String blockListFileName = "blockList.txt";

    private String name;
    private int orderCount;
    private int cost;
    private String resource;

    public Block(String name, int orderCount, int cost, String resource)
    {
        this.name = name;
        this.orderCount = orderCount;
        this.cost = cost;
        this.resource = resource;
    }

    public String getName()
    {
        return this.name;
    }
    public int getOrderCount()
    {
        return this.orderCount;
    }
    public int getCost()
    {
        return this.cost;
    }
    public String getResource()
    {
        return this.resource;
    }

    public String toString()
    {
        return String.format("name: %s | quantity : %s | cost: %s %s", 
                             this.name, this.orderCount, this.cost, this.resource);
    }

    public static ArrayList<Block> getBlocksFromFile()
    {
        ArrayList<Block> blockList = new ArrayList<>();
        try
        {
            File f = new File(Block.blockListFileName);
            Scanner scan = new Scanner(f);
            while(scan.hasNextLine())
            {
                String[] tokens = scan.nextLine().split(",");
                blockList.add( new Block ( tokens[0], Integer.parseInt(tokens[1]), 
                                           Integer.parseInt(tokens[2]), tokens[3] ) );
            }
            return blockList;
        }
        catch(FileNotFoundException e)
        {
            
        }
        return new ArrayList<Block>();
    }
}