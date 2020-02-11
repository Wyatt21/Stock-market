/** @author wyatt
 *@version 12/3/19
 *
 */
public class CompareName implements Comparator<String>
{
    public CompareName()
    {
     
    }
    public int compare(String one, String two)
    {
        return one.compareToIgnoreCase(two);
    }
}
