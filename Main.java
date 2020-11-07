import java.util.ArrayList;

/**
 * Main class
 * 
 * @author Matthew Kotras
 * @version 11/06/2020
 */
public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Block> blocks = Block.getBlocksFromFile();
        blocks.forEach( (e) -> System.out.println(e));
    }
}