package Util;

import com.jcraft.jsch.*;

import java.util.Properties;
import java.util.logging.Logger;

public class SftpUtil {

//    private final static Logger  logger = Logger.getLogger(SftpUtil.class);
protected final static int CLIENT_TIMEOUT = 1000 * 20;
    // 登录
    public static ChannelSftp login(String host, int port,String username, String password ) throws Exception {
        Session session;
        try{
            JSch jSch = new JSch();
            session = jSch.getSession(username,host,port);
            session.setTimeout(CLIENT_TIMEOUT);
            session.setPassword(password);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftp = (ChannelSftp) channel;
            return sftp;
        }catch (JSchException e){
           throw new Exception("连接服务器异常");
        }
    }
    //关闭连接
    public static void logout(ChannelSftp sftp){
        if(sftp != null){
            Session session = null;
            try {
                session = sftp.getSession();
                if(sftp.isConnected()){
                    sftp.disconnect();
                }
            }catch (JSchException e){
                System.out.println("获取Session失败 "+e);
            }finally {
                if(session != null){
                    session.disconnect();
                }
            }
        }

    }

    //下载

    //连接


    //数据上传作为文件

    //删除文件

    //查询目录文件

    //列出目录文件

    //递归创建文件夹
}
