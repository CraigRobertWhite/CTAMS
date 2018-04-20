import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 * Director is one of the two child-classes
 * of UserAccount. It holds the names and
 * passwords of all directors.
 *
 * @author Craig White
 * @version 2.0
 * @since 2018-04-13
 */
public class Director extends UserAccount
{

    /**
     * Class constructor specifying name and password.
     *
     * @param name
     * @param password
     */
    public Director(String name, String password)
    {
        super(name, password);
    }
}
