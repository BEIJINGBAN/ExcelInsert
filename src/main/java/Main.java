import Data.Data;
import Util.ExcelUtil;
import Util.NoticeUtil;
import Util.SftpUtil;
import Util.ZipUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        Audit327 audit327 = new Audit327();
        Audit321 audit321 = new Audit321();
        audit327.Audit327();
//        audit321.Audit321();
    }
}
