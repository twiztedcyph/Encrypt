package encrypt;

/**
 *
 * @author Cypher
 */
public class Caesar
{

    private final char[] letters =
    {
              'a', 'b', 'c', 'd', 'e', 'f', 'g'
            , 'h', 'i', 'j', 'k', 'l', 'm', 'n'
            , 'o', 'p', 'q', 'r', 's', 't', 'u'
            , 'v', 'w', 'x', 'y', 'z'
    };

    public Caesar()
    {
    }

    public String encipher(int shift, String input)
    {
        shift %= 26;
        String output = new String();
        input = input.toLowerCase().trim();

        // Iterate over the whole string.
        for (int i = 0; i < input.length(); i++)
        {
            if ((int) input.charAt(i) == 32)
            {
                // Check for spaces and preserve them.
                output += " ";
            } else if(input.charAt(i) < 97)
            {
                output += input.charAt(i);
            } else
            {
                // If not a space then do the caesar shift.
                int charNumber = ((int) input.toLowerCase().charAt(i)
                        - (97 - shift));
                // Wrap around mod 26
                int newNumber = charNumber % 26;
                // Add the enciphered letter to the output.
                output += letters[newNumber];
            }
        }
        return output;
    }

    public String decipher(int shift, String input)
    {
        String output = new String();
        shift %= 26;
        if (shift == 0)
        {
            // Zero shift. Try all shift values.
            System.out.println("Brute force: " + input);
            for (int i = 1; i < 26; i++)
            {
                for (int j = 0; j < input.length(); j++)
                {
                    if ((int) input.charAt(j) == 32)
                    {
                        // Check for spaces and preserve them.
                        output += " ";
                    } else
                    {
                        // If not a space then do the caesar shift.
                        int charNumber = ((int) input.toLowerCase().charAt(j)
                                - (97) + (26 - i));
                        // Wrap around mod 26
                        int newNumber = charNumber % 26;
                        // Add the enciphered letter to the output.
                        output += letters[newNumber];
                    }
                }
                output += "\n";
            }
        } else if (shift > 0)
        {
            // Decode using the given shift value.

            for (int i = 0; i < input.length(); i++)
            {
                if ((int) input.charAt(i) == 32)
                {
                    // Check for spaces and preserve them.
                    output += " ";
                } else
                {
                    // If not a space then do the caesar shift.
                    int charNumber = ((int) input.toLowerCase().charAt(i)
                            - (97) + (26 - shift));
                    // Wrap around mod 26
                    int newNumber = charNumber % 26;
                    // Add the enciphered letter to the output.
                    output += letters[newNumber];
                }
            }
        } else
        {
            // Error message ftw.
            output += "Incorrect shift value. Must be positive.";
        }
        return output;
    }
}
