
package encrypt;

/**
 *
 * @author Cypher
 */
public class Caesar
{
    int shiftAmount;
    private final char[] letters = 
        {
            'a', 'b', 'c', 'd', 'e', 'f', 'g'
                , 'h', 'i', 'j', 'k', 'l', 'm', 'n'
                , 'o', 'p', 'q', 'r', 's', 't', 'u'
                , 'v', 'w', 'x', 'y', 'z'
        };
    
    public Caesar(int shift)
    {
        shiftAmount = shift;
    }
    
    public String encipher(String input)
    {
        // Working
        String output = new String();
        
        for (int i = 0; i < input.length(); i++)
        {
            if ((int)input.charAt(i) == 32)
            {
                output += " ";
            }else
            {
                int charNumber = ((int) input.toLowerCase().charAt(i) - (97 - shiftAmount));
                int newNumber = charNumber % 26;
                output += letters[newNumber];
            }
        }
        return output;
    }
}
