import java.util.List;
/**
 * My implementation of ILispMethodsList
 *
 * @author Johnnie Meredith
 * @version 04/27/2019
 */
public class LispMethodsList<T> implements ILispMethodsList<T>
{
    /** 
     * extract the first item from the list and return it 
     * @param obj a list
     * @return the first item in the list
     */
    public T car(List<T> obj){
        return obj.get(0);
    }

    /**
     * removes the first item from the list, and returns the remaining list
     * @param oList original list
     * @return modified list without the original item
     */
    public List<T> cdr(List<T> oList){
        if(oList.size() == 0){
            return null;
        }
        else
            return oList.subList(1,oList.size());
    }
}
