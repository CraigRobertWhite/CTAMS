package ctamsbetav2;

import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 * UserAccount is the parent-class of Director and Actor
 * which means it holds the base methods that can be
 * used for objects of both classes.
 *
 * @author Craig White
 * @version 2.0
 * @since 2018-04-13
 */
public class UserAccount
{
    private String name;
    private String password;

    /**
     * Class constructor specifying name and password.
     *
     * @param name
     * @param password
     */
    public UserAccount(String name, String password)
    {
        this.name = name;
        this.password = password;
    }

    /**
     * Getter
     * @return String person's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Getter
     * @return String person's password
     */
    public String getPassword()
    {
        return password;
    }
}
