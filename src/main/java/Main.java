
import Util.Inseart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;




public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        Inseart.inseart();
    }
}
