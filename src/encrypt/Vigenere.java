
package encrypt;

/**
 *
 * @author Cypher
 */
public class Vigenere
{
    private final String key;
    private Caesar caesar;
    private int[] keyNumber;
    
    public Vigenere(String key)
    {
        this.key = key;
        keyNumber = new int[key.length()];
        
        // Turn the key into an int array.
        for (int i = 0; i < key.length(); i++)
        {
            keyNumber[i] = (int) (key.charAt(i) - 97);
        }
        
    }
    
    public String encipher(String input)
    {
        String output = new String();
        
        // Trim leading and trailing whitespace.
        input = input.trim().toLowerCase();
        // This will be used to compensate for spaces.
        int spaceOffset = 0;
        // Itterate over the input.
        for (int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) == 32)
            {
                /*
                 * If the current char is a space then 
                 * preserve it and add to the offset.
                 */
                output += " ";
                spaceOffset++;
            }else
            {
                /*
                 * If the current char is a letter then encipher it using
                 * the caesar cipher with the shift defined by the current
                 * position plus the offest circularized by the modulus of
                 * the size of the key.
                 */
                caesar = new Caesar();
                output += caesar.encipher(
                        keyNumber[(i - spaceOffset) % keyNumber.length] 
                        ,String.valueOf(input.charAt(i)));
            }
        }
        return output;
    }
}
