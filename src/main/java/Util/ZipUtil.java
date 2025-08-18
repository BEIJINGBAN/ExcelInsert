package Util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.util.List;

public class ZipUtil {
    private static final Logger log = LogManager.getLogger(ZipUtil.class);

    //压缩后加密
    public static String zipEncrypt(String filePath, String savePath ,String passWord,String fileName,String soleId){
        try{
            //Tran_企业编号_业务系统标识_交易日期_唯一编号.zip
            savePath = savePath + fileName+"_"+soleId+".zip";
            List<File> files = FileUtil.loopFiles(filePath);
            FileUtil.touch(savePath);
            try(ZipFile zipFile = new ZipFile(savePath)){
                ZipParameters zipParameters = new ZipParameters();
                //压缩算法
                zipParameters.setCompressionMethod(CompressionMethod.DEFLATE);
                zipParameters.setCompressionLevel(CompressionLevel.FASTER);
                zipParameters.setEncryptFiles(true);
                zipParameters.setEncryptionMethod(EncryptionMethod.AES);
                zipParameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256);
                zipFile.setCharset(CharsetUtil.CHARSET_GBK);
                zipFile.setPassword(passWord.toCharArray());

                zipFile.addFiles(files,zipParameters);
            }
            log.info("压缩成功，地址为: "+savePath);
            return savePath;
        }catch (Exception e){
            log.error("压缩出错，问题： "+e);
            return "";
        }
    }
    //压缩后加密
    public static String zipEncrypt(String filePath, String savePath ,String passWord,String fileName){
        try{
            //Tran_企业编号_业务系统标识_交易日期_唯一编号.zip
            savePath = savePath + fileName+".zip";
            List<File> files = FileUtil.loopFiles(filePath);
            FileUtil.touch(savePath);
            try(ZipFile zipFile = new ZipFile(savePath)){
                ZipParameters zipParameters = new ZipParameters();
                //压缩算法
                zipParameters.setCompressionMethod(CompressionMethod.DEFLATE);
                zipParameters.setCompressionLevel(CompressionLevel.FASTER);
                zipParameters.setEncryptFiles(true);
                zipParameters.setEncryptionMethod(EncryptionMethod.AES);
                zipParameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256);
                zipFile.setCharset(CharsetUtil.CHARSET_GBK);
                zipFile.setPassword(passWord.toCharArray());

                zipFile.addFiles(files,zipParameters);
            }
            log.info("压缩成功，地址为: "+savePath);
            return savePath;
        }catch (Exception e){
            log.error("压缩出错，问题： "+e);
            return "";
        }
    }
}
