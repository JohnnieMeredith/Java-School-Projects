
/**
 * Write a description of class Airplane here.
 *
 * @author Johnnie Meredith
 * @version 1
 */
public class Airplane
{
Engine eng = new Engine();
Rudder rud = new Rudder();
Wing[] wings = new Wing[2];

/**
 * @param Airplane a another airplane to compare this one with.
 */    
public boolean equals(Airplane a){
    if(this.eng.equals(a.eng) && this.rud.equals(a.rud) && this.wings.equals(a.wings))
        return true;
    else
        return false;
}

}
    