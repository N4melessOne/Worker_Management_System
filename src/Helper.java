public class Helper {

    public static boolean tryParse(String value){
        try{
            int temp = Integer.parseInt(value);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
