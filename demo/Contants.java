package com.mangxing.bat.base;

/**
 * @ 作者 CODE_LYF
 * @ 时间   2019/3/24.
 * 代码人生
 */
public class Contants {

    //注解
    public final static String LYF = "--**测试数据**--";
    //http://192.168.0.185:10001/
    public final static String URL = "http://192.168.0.166";
    //public final static String URL = "http://192.168.0.28";

    //  本地
    //  public final static String APPURL = URL + ":10001/api";
    public final static String APPURL = "https://bat.vip/api/";
    //图片
    // public final static String UPIMGURL = URL + ":10201/uploadImg";

    public final static String UPIMGURL = "https://bat.vip/uploadImg";


    //web
    public final static String WEB_URL = "https://bat.vip/app?id=";
    //网易七鱼61083aa2b9727e7bab804f59ffe7b146

    public final static String QITYKEY = "61083aa2b9727e7bab804f59ffe7b146";
    public static final String QIYU_SOURCEURL = "http://hzad.qiyukf.com/chat/";
    public static final String QIYU_SOURCE_TITLE = "边蝠(9:00-21:00)";
    public static final String QIYU_CUSTOM = "边蝠(9:00-21:00)";//七鱼标题

    /**
     * web页面
     */

    //https://bat.vip/tech
    public final static String WEB_UPURL = "https://bat.vip/tech";

    //从手机选择照片
    public static final int REQUEST_CODE_SELECT = 10011;
    public static final int REQUEST_CODE_PREVIEW = 101;

    //网络接口标记
    public final static int REQUEST_POST_ERROR = 0X0004;
    /**
     * 储存标记
     */
    public final static String SpUserid = "userId";
    public final static String Sptoken = "token";
    public final static String SpPhone = "phone";
    /**
     * 类型标记
     */
    public final static String CODE_TYPE_LOGIN = "2";
    public final static String CODE_TYPE_REGIST = "2";
    public final static String CODE_TYPE_FORGET = "2";
    public final static String CODE_TYPE_MODIFY = "2";
    public final static String CODE_TYPE_FIRM = "3";
    // paytype  1购买点数,2余额充值，3体现
    public final static String TYPE1_PAY = "1";
    public final static String TYPE2_PAY = "2";

    //认证失败标识

    public final static String AUTH_RESULT = "resultFail";
    //url

    public final static String WEBURL = "appurl";

    public final static String PRODUCTID = "productId";
    public final static String APKURL = "apkdownurl";
    public final static String USERBALANCE = "balance";

    /*
     * 图片标记
     */
    public final static int IMGFIRMZZ = 7878;
    public final static int IMGCARDZ = 7879;
    public final static int IMGCARDF = 7880;
    public final static int IMGCARDS = 7881;


    /*
    接口标记
     */

    public final static int LOGIN_POST_REQUEST = 0x102001;
    public final static String LOGIN_POST_CODE = "0102001";

    public final static int REGIST_POST_REQUEST = 0x102003;
    public final static String REGIST_POST_CODE = "0102003";

    public final static int CODE_POST_REQUEST = 0x102002;
    public final static String CODE_POST_CODE = "0102002";

    public final static int HOME_POST_REQUEST = 0x202003;
    public final static String HOME_POST_CODE = "0202003";

    public final static int RECOM_POST_REQUEST = 0x202004;
    public final static String RECOM_POST_CODE = "0202004";

    public final static int DAI_POST_REQUEST = 0x302001;
    public final static String DAI_POST_CODE = "0302001";
    //我的页面 0102005

    public final static int MINE_POST_REQUEST = 0x102005;
    public final static String MINE_POST_CODE = "0102005";


    public final static int FORGOTPWD_POST_REQUEST = 0x102004;
    public final static String FORGOTPWD_POST_CODE = "0102004";

//0102006

    public final static int WALLET_POST_REQUEST = 0x102006;
    public final static String WALLET_POST_CODE = "0102006";


//0102009

    public final static int MYBILL_POST_REQUEST = 0x102009;
    public final static String MYBILL_POST_CODE = "0102009";

    //0102008

    public final static int TOPUP_POST_REQUEST = 0x102008;
    public final static String TOPUP_POST_CODE = "0102008";
    //0102013

    public final static int USER_POST_REQUEST = 0x102013;
    public final static String USER_POST_CODE = "0102013";

    //0102014
    public final static int FIRM_POST_REQUEST = 0x102014;
    public final static String FIRM_POST_CODE = "0102014";

    //0102015
    public final static int FIRMAUTH_POST_REQUEST = 0x102015;
    public final static String FIRMAUTH_POST_CODE = "0102015";
    //上传图片
    public final static int USERICON_POST_REQUEST = 222;

    //0101010
    public final static int MODIFYICON_POST_REQUEST = 0x101010;
    public final static String MODIFYICON_POST_CODE = "0101010";

    //修改昵称0101021

    public final static int MODIFYNAME_POST_REQUEST = 0x101021;
    public final static String MODIFYNAME_POST_CODE = "0101021";

    //0102012
    public final static int MODIFYPHONE_POST_REQUEST = 0x102012;
    public final static String MODIFYPHONE_POST_CODE = "0102012";

    // 0202002
    public final static int SEARCH_POST_REQUEST = 0x202002;
    public final static String SEARCH_POST_CODE = "0202002";

    //0202009
    public final static int SEARCHHISTORY_POST_REQUEST = 0x202009;
    public final static String SEARCHHISTORY_POST_CODE = "0202009";
    //0202010

    public final static int DELETE_POST_REQUEST = 0x202010;
    public final static String DELETE_POST_CODE = "0202010";

    //0302003
    public final static int CLICK_POST_REQUEST = 0x302003;
    public final static String CLICK_POST_CODE = "0302003";

    //0302002

    public final static int MOREDAI_POST_REQUEST = 0x302002;
    public final static String MOREDAI_POST_CODE = "0302002";

    // 0102011
    public final static int MODIFYPWD_POST_REQUEST = 0x102011;
    public final static String MODIFYPWD_POST_CODE = "0102011";

    // 0102019
    public final static int PAYORDER_POST_REQUEST = 0x102019;
    public final static String PAYORDER_POST_CODE = "0102019";
//0102007

    public final static int ALIPAYORDER_POST_REQUEST = 0x102007;
    public final static String ALIPAYORDER_POST_CODE = "0102007";

    //0502002
    public final static int ABOUTUS_POST_REQUEST = 0x502002;
    public final static String ABOUTUS_POST_CODE = "0502002";

    //0102010
    public final static int APPASSIGN_POST_REQUEST = 0x102010;
    public final static String APPASSIGN_POST_CODE = "0102010";
    //0502001
    public final static int BUYTYPE_POST_REQUEST = 0x502001;
    public final static String BUYTYPE_POST_CODE = "0502001";

    //0102020

    public final static int YUERPAY_POST_REQUEST = 0x102020;
    public final static String YUERPAY_POST_CODE = "0102020";
    // 0102021
    public final static int QUICKLOGIN_POST_REQUEST = 0x102021;
    public final static String QUICKLOGIN_POST_CODE = "0102021";

    // 0102016
    public final static int FACEAUTH_POST_REQUEST = 0x102016;
    public final static String FACEAUTH_POST_CODE = "0102016";


}
