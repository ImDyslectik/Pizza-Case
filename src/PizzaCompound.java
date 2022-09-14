import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PizzaCompound extends PizzaSet {
    protected List<PizzaSet> children = new ArrayList<>();
    public PizzaCompound(){
    }
    public void add(PizzaSet component){
        children.add(component); 
    }
    public LinkedList getContent(){
        LinkedList<String> result = new LinkedList<String>();
        LinkedList<String> data;
        for(PizzaSet child : children){
           data = child.getChoice();
           for (String string : data) {
                result.add(string);
           }
        }

        return result;
    }
    
}
