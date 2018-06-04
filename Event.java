package ctamsbetav2;

import java.util.*;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 * Event is a class that constructs
 * the events for CTAMS.
 *
 * @author Craig White
 * @version 2.0
 * @since 2018-04-13
 */
public class Event
{
    private String name;
    private String eventDay;
    private String eventMonth;
    private String eventYear;
    private String auditionDay;
    private String auditionMonth;
    private String auditionYear;
    private ArrayList<String> parts;

    /**
     *
     * @param name
     * @param eventDay
     * @param eventMonth
     * @param eventYear
     * @param auditionDay
     * @param auditionMonth
     * @param auditionYear
     * @param parts
     */
    public Event(String name, String eventDay, String eventMonth, String eventYear, String auditionDay, String auditionMonth, String auditionYear, ArrayList<String> parts)
    {
        this.name = name;
        this.eventDay = eventDay;
        this.eventMonth = eventMonth;
        this.eventYear = eventYear;
        this.auditionDay = auditionDay;
        this.auditionMonth = auditionMonth;
        this.auditionYear = auditionYear;
        this.parts = parts;
    }

    /**
     *
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     *
     * @return
     */
    public String getEventDay()
    {
        return eventDay;
    }

    /**
     *
     * @return
     */
    public String getEventMonth()
    {
        return eventMonth;
    }

    /**
     *
     * @return
     */
    public String getEventYear()
    {
        return eventYear;
    }

    /**
     *
     * @return
     */
    public String getAuditionDay()
    {
        return auditionDay;
    }

    /**
     *
     * @return
     */
    public String getAuditionMonth()
    {
        return auditionMonth;
    }

    /**
     *
     * @return
     */
    public String getAuditionYear()
    {
        return auditionYear;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getParts()
    {
        return parts;
    }

    /**
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     *
     * @param eventDay
     */
    public void setEventDay(String eventDay)
    {
        this.eventDay = eventDay;
    }

    /**
     *
     * @param eventMonth
     */
    public void setEventMonth(String eventMonth)
    {
        this.eventMonth = eventMonth;
    }

    /**
     *
     * @param eventYear
     */
    public void setEventYear(String eventYear)
    {
        this.eventYear = eventYear;
    }

    /**
     *
     * @param auditionDay
     */
    public void setAuditionDay(String auditionDay)
    {
        this.auditionDay = auditionDay;
    }

    /**
     *
     * @param auditionMonth
     */
    public void setAuditionMonth(String auditionMonth)
    {
        this.auditionMonth = auditionMonth;
    }

    /**
     *
     * @param auditionYear
     */
    public void setAuditionYear(String auditionYear)
    {
        this.auditionYear = auditionYear;
    }

    /**
     *
     * @param parts
     */
    public void setParts(ArrayList<String> parts)
    {
        this.parts = parts;
    }
}
