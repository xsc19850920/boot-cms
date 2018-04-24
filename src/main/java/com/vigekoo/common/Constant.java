package com.vigekoo.common;

/**
 * @author sxia
 * @Description: TODO(常量)
 * @date 2017-6-23 15:07
 */
public class Constant {
	
	//阿里云API的外网域名
    public static final String ENDPOINT = "oss-cn-shanghai.aliyuncs.com";
    //阿里云API的密钥Access Key ID
    public static final String ACCESS_KEY_ID = "LTAIu1uBPXzrHMj0";
    //阿里云API的密钥Access Key Secret
    public static final String ACCESS_KEY_SECRET = "1ap41tsh1YXhSlTd25CBhRc4aj3p9V";
    //阿里云API的bucket名称
    public static final String BACKET_NAME = "ujiabb-manager";
    //阿里云API的文件夹名称
    public static final String FOLDER="ujiabb/";
    
    public static final String JPG_EXT = ".jpg";
    
    /**
     * 超级管理员ID
     */
	public static final String SUPER_ADMIN = "1";

    /**
     * utf-8编码
     */
	public static final String ENCODING_UTF_8="UTF-8";

    /**
     * X-Token sys请求的token
     */
    public static  final String X_TOKEN="X-Token";
    /**
     * 菜单类型
     */
    public enum MenuType {
        /**
         * 目录
         */
    	CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 系统配置 状态
     */
    public enum ConfigStatus {
        /**
         * 隐藏
         */
        HIDDEN(0),
        /**
         * 显示
         */
        SHOW(1);

        private int value;

        ConfigStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 用户 状态
     */
    public enum UserStatus {
        /**
         * 禁用
         */
        DISABLE(0),
        /**
         * 正常
         */
        NORMAL(1);

        private int value;

        UserStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


}
