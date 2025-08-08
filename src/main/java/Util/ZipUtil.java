package Util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;


import java.io.File;
import java.util.List;

public class ZipUtil {
    //压缩后加密
    public static String zipEncrypt(String filePath, String savePath ,String passWord,String fileType, String entCode, String tranTime, String tranType, String opCode){
        try{
            savePath = savePath + fileType+"_"+entCode+"_"+tranTime+"_"+tranType+"_"+opCode+".zip";
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
            System.out.println("压缩成功，地址为: "+savePath);
            return savePath;
        }catch (Exception e){
            System.out.println("压缩出错，问题： "+e);
            return "";
        }
    }
}
