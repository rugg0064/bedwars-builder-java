
/**
 * Main class
 * 
 * @author Matthew Kotras
 * @version 11/06/2020
 */
public class Test
{

    public static void main(String[] args)
    {
        for(int i = 1; i < 10; i++)
        {
            System.out.printf("%2d | %d%n", i, Base.blocksInLayer(i));
        }
    }
}