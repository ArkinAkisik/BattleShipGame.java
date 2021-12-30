
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{

    int hitPoints;
    int missPoints;
    int playerNumber;

    public Player(int playerNumber)
    {
        playerNumber=this.playerNumber;
    }
    public int getMissPoints()
    {
        return missPoints;
    }
    public int getHitPoints()
    {
        return hitPoints;
    }
    public void addHitPoint()
    {
        hitPoints++;
    }
    public void addMissPoint()
    {
        missPoints++;
    }
}
