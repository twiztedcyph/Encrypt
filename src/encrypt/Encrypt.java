
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
        Caesar c = new Caesar();
        
        System.out.println(c.encipher(12, "Encoded using a caesar shift of twelve."));
        
        System.out.println(c.decipher(0,  "QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD"));
    }
}
