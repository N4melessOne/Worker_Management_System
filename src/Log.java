
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
    public static Logger logger= Logger.getLogger("logger");;
    FileHandler fh;
    public  Log(String file_name) throws SecurityException, IOException{
        File f = new File(file_name);
        if(!f.exists()){
            f.createNewFile();
        }
        else{
            f.delete();
        }

        fh = new FileHandler(file_name, true);

        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
    }

}
