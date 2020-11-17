import java.util.ArrayList;
import java.util.Scanner;

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
        Scanner scan = new Scanner(System.in);
        ArrayList<Block> blocks = Block.getBlocksFromFile();
        Base b = new Base();
        String input = " ";
        for(int i = 0; i < blocks.size(); i++)
        {
            System.out.printf("%2d | %s%n", i, blocks.get(i).getName());
        }
        System.out.println("What to add:");

        inputLoop:
        while( !(input=scan.nextLine()).equals(""))
        {
            try
            {
                int index = Integer.parseInt(input);
                if(index < 0 || index >= blocks.size())
                {
                    System.out.println("Bad input!");
                    continue inputLoop;
                }
                b.addLayer(blocks.get(index));
            }
            catch(NumberFormatException e)
            {
                System.out.println("Bad input!");
                continue inputLoop;
            }
        }
        
        b.getCost();
        
    }
}