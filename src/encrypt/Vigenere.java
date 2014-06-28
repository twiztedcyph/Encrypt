
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
        for (int i = 0; i < key.length(); i++)
        {
            keyNumber[i] = (int) (key.charAt(i) - 97);
        }
        
    }
    
    public String encipher(String input)
    {
        // Working
        String output = new String();
        
        for (int i = 0; i < input.length(); i++)
        {
            caesar = new Caesar(keyNumber[i % keyNumber.length]);
            output += caesar.encipher(String.valueOf(input.charAt(i)));
        }
        
        return output;
    }
}
