package com.vigekoo.common.utils;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class BOSUtil {

    public static String MD5(String s) {
        String r = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(s.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            r = buf.toString();
        } catch (Exception e) {
        }
        return r;
    }

    public static HashMap<String, Object> getCMDParams(String command, JSONObject cmdparam) {
        SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        a.setLenient(false);

        String sipKey = "ylkj@ujiabb.com";
        String tt = a.format(new Date());
        String m = MD5("admin");
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("sip_appkey", sipKey);
        params.put("sip_timestamp", tt);
        params.put("sip_sign", MD5(sipKey + tt + m));
        JSONObject transactions = new JSONObject();
        transactions.put("id", 112);
        transactions.put("command", command);
        transactions.put("params", cmdparam);
        JSONArray ja = new JSONArray();
        ja.add(transactions);
        params.put("transactions", ja.toString());
        return params;
    }

   /* public static void main(String args[]) {
        String orderId = "900009876544";
        String productCode = "HHHFBB0028";
        String productQty = "12";
        String memo = "";
        String nickname = "小刘";
        String address = "连山路120号";
        String tel = "13500100001";
        JSONObject cmdparam = new JSONObject();
        cmdparam.put("table", 23182);
        cmdparam.put("DOCNO", JSONArray.parse("[\"" + orderId + "\"]"));
        cmdparam.put("BILLDATE", JSONArray.parse("[\"" + DateUtil.getCurrDateStr(DateUtil.DEFAULT_SHORT_DATE_FORMAT_YYYYMMDD) + "\"]"));
        cmdparam.put("PRODUCTCODE", JSONArray.parse("[\"" + productCode + "\"]"));
        cmdparam.put("PRODUCTQTY", JSONArray.parse("[" + productQty +"]"));
        cmdparam.put("ORDERDES", JSONArray.parse("[\"" + memo + "\"]"));
        cmdparam.put("DESTNAME", JSONArray.parse("[\"" + nickname + "\"]"));
        cmdparam.put("DESTPHONE", JSONArray.parse("[\"" + tel + "\"]"));
        cmdparam.put("DESTADDRESS", JSONArray.parse("[\"" + address + "\"]"));
        HashMap<String, Object> hm = getCMDParams("ObjectCreate", cmdparam);
        OKHttpUtils http = new OKHttpUtils();
        String responseCreateOrder = http.get("http://106.14.57.1:120/servlets/binserv/Rest", hm, null);
        if (StringUtils.isNotBlank(responseCreateOrder)) {
            JSONArray ja = null;
            try {
                ja = JSONArray.parseArray(responseCreateOrder);
            } catch (Exception e) {
            }
            
            if (ja != null && ja.size() > 0) {
                JSONObject jo = ja.getJSONObject(0);
                String code = ConvertUtil.objectToString(jo.get("code"));
                String objectid = ConvertUtil.objectToString(jo.getString("objectid"));
                if ("0".equals(code) && StringUtils.isNotBlank(objectid)) {
                    
                    JSONObject cmdparamSubmitOrder = new JSONObject();
                    cmdparamSubmitOrder.put("table", 23182);
                    cmdparamSubmitOrder.put("id", objectid);
                    HashMap<String, Object> hmSubmitOrder = getCMDParams("ObjectSubmit", cmdparamSubmitOrder);
                    http.get("http://106.14.57.1:120/servlets/binserv/Rest", hmSubmitOrder, null);
                }
            }
        }

    }*/
    
  
}
