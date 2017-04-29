package otherFunction.md5;

import java.security.MessageDigest;

/**
 * 瀵瑰瘑鐮佽繘琛屽姞瀵嗗拰楠岃瘉鐨勭被
 */
public class Encryption{

    //鍗佸叚杩涘埗涓嬫暟瀛楀埌瀛楃鐨勬槧灏勬暟缁�
    private final static String[] hexDigits = {"0", "1", "2", "3", "4",
            "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /** * 鎶奿nputString鍔犲瘑     */
    public static String generatePassword(String inputString){
        return encodeByMD5(inputString);
    }

    /**
     * 楠岃瘉杈撳叆鐨勫瘑鐮佹槸鍚︽纭�
     * @param password    鍔犲瘑鍚庣殑瀵嗙爜
     * @param inputString    杈撳叆鐨勫瓧绗︿覆
     * @return    楠岃瘉缁撴灉锛孴RUE:姝ｇ‘ FALSE:閿欒
     */
    public static boolean validatePassword(String password, String inputString){
        if(password.equals(encodeByMD5(inputString))){
            return true;
        } else{
            return false;
        }
    }
    /**  瀵瑰瓧绗︿覆杩涜MD5鍔犲瘑     */
    private static String encodeByMD5(String originString){
        if (originString != null){
            try{
                //鍒涘缓鍏锋湁鎸囧畾绠楁硶鍚嶇О鐨勪俊鎭憳瑕�
                MessageDigest md = MessageDigest.getInstance("MD5");
                //浣跨敤鎸囧畾鐨勫瓧鑺傛暟缁勫鎽樿杩涜鏈�悗鏇存柊锛岀劧鍚庡畬鎴愭憳瑕佽绠�
                byte[] results = md.digest(originString.getBytes());
                //灏嗗緱鍒扮殑瀛楄妭鏁扮粍鍙樻垚瀛楃涓茶繑鍥�
                String resultString = byteArrayToHexString(results);
                return resultString.toUpperCase();
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return null;
    }


    private static String byteArrayToHexString(byte[] b){
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++){
            resultSb.append(byteToHexString(b[i]));
        }  //b.length涓�2 鍙互瀵瑰叾杩愮畻鏀瑰彉鍔犲瘑鍚庡瘑鐮佺殑瀛楃涓暟锛�
        return resultSb.toString();
    }

    /** 灏嗕竴涓瓧鑺傝浆鍖栨垚鍗佸叚杩涘埗褰㈠紡鐨勫瓧绗︿覆     */
    private static String byteToHexString(byte b){
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
}