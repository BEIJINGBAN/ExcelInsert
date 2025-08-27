
import Util.Inseart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;




public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        String localUrl ="D:/anyCode/java/Audit_Once/ExcelInsert/src/main/test/NEW_门店资料_ 副本.xlsx";
        Inseart.inseart(localUrl);
    }
}
