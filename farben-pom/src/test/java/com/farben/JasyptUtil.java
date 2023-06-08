package com.farben;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class JasyptUtil {
    private static final String ALGORITHM_INFO = "PBEWithMD5AndDES";

    private static final String PASSWORD_INFO = "qwert12345";

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();

        //配置文件中配置如下的算法
        standardPBEStringEncryptor.setAlgorithm(ALGORITHM_INFO);
        //配置文件中配置的password
        standardPBEStringEncryptor.setPassword(PASSWORD_INFO);

        String account = "wide";// 连接数据库用户名
        String password = "wide123456";// 连接数据库密码
        //BasicTextEncryptor encryptor = new BasicTextEncryptor();
        //秘钥
        // encryptor.setPassword("ENCKEY");
        //密码进行加密
        String newAccount = standardPBEStringEncryptor.encrypt(account);
        String newPassword = standardPBEStringEncryptor.encrypt(password);
        System.out.println("加密后账号：" + newAccount);
        System.out.println("加密后密码：" + newPassword);

    }

}
