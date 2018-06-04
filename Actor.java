package ctamsbetav2;

import java.util.*;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 * Actor is one of the two child-classes
 * of UserAccount. It holds the names and
 * passwords of all actors.
 *
 * @author Craig White
 * @version 2.0
 * @since 2018-04-13
 */
public class Actor extends UserAccount
{
    private Audition audition = null;

    /**
     * Class constructor specifying name and password.
     *
     * @param name
     * @param password
     */
    public Actor(String name, String password)
    {
        super(name, password);
    }

    /**
     * Setter
     * @param audition
     */
    public void setAudition(Audition audition)
    {
        this.audition = audition;
    }

    /**
     * Getter
     * @return auditions which is the ArrayList that holds
     *         all of the auditions the actor is applying for.
     */
    public Audition getAudition()
    {
        return this.audition;
    }
}
