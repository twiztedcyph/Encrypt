
package encrypt;

/**
 *
 * @author Cypher
 */
public class Encrypt
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Vigenere v = new Vigenere("testing");
        
        System.out.println(v.encipher("fortheloveofmoney"));
    }
}
