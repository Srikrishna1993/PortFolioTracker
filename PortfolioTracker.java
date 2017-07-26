/*
PortfolioTracker-This java file is used to sort the stock values in given textfile in descending order
 */

package portfoliotracker;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Collections;




/**
 *
 * @author SRIKRISHNA
 */
public class PortfolioTracker 
{
   public void readportfoliofile(String portfoliofile)throws FileNotFoundException, IOException
   {
        try
        {
            //Split the portfolio file by comma
            String readcont= new String(Files.readAllBytes(Paths.get(portfoliofile)));
            String[] contents = readcont.split("\\,");
            HashMap<String,Integer> stocksymbols =new HashMap<>();
            int contvalues;
            
            for(String content:contents)
            {
                
                //Match the stock symbols using regular expression and sort the stock values in decreasing order
                 if(content.matches("([A-Z]+)\\s+\\-\\s+(\\d+)"))
                 {
                     //System.out.println("Hit here"+content);
                     Pattern pattern = Pattern.compile("([A-Z]+)\\s+?\\-\\s+?(\\d+)");
                     Matcher match = pattern.matcher(content);
                     if(match.find())
                     {
                         System.out.println("The match values are"+match.group(1));
                         System.out.println("The match values are"+match.group(2));
                     }   
                     contvalues = Integer.parseInt(match.group(2));
                     stocksymbols.put(match.group(1),contvalues);
                     
                 }
                 
                 //Print message when not able to find the stock values
                 else
                 {
                     System.out.println("Stock symbols not found");
                 }
            }
            
            System.out.println(stocksymbols);
    

        }
        catch(FileNotFoundException FE)
        {
            System.out.println("Portfolio file not found");
        }
   }
   
    public static void main(String[] args) throws IOException 
    {
        //Create PortFolio object and access the portfolio method to sort stocks
        PortfolioTracker portfolioobj = new PortfolioTracker();
        String filepath = args[0];
        portfolioobj.readportfoliofile(filepath);
        
    }
    
}
