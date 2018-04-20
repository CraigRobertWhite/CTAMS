import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 * Audition is a constructor class that
 * creates the auditions for CTAMS.
 *
 * @author Craig White
 * @version 2.0
 * @since 2018-04-13
 */
class Audition
{
    private Actor actor;
    private Event event = null;
    private String part = null;
    private int rating = -1;

    /**
     * Class constructor specifying actor, event, and part for
     * the audition.
     *
     * @param actor
     * @param event
     * @param part
     */
    public Audition(Actor actor, Event event, String part)
    {
        this.actor = actor;
        this.event = event;
        this.part = part;

    }

    public Actor getActor()
    {
        return actor;
    }

    public Event getEvent()
    {
        return event;
    }

    public String getPart()
    {
        return part;
    }

    public int getRating()
    {
        return this.rating;
    }

    public void setRating(int rating)
    {
        this.rating = rating;
    }

    @Override
    public String toString()
    {
        return "Name: " + actor.getName() + " Event: " + event.getName() + " Part: " + part;
    }
}
