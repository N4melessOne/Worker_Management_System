package Classes;

public class Helper {

    public int tryparse(String value, int defaultValue){
        try{
            return Integer.parseInt(value);
            } catch (NumberFormatException e)
            {return defaultValue;}
        }
}
