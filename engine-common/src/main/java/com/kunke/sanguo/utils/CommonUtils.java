package com.kunke.sanguo.utils;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 公共方法类
 */
public class CommonUtils {
    private CommonUtils() {}

    /**
     * 手机号隐藏方法
     * @param mobile
     * @return
     */
    public static String hideMobile(String mobile) {
        if (StringUtils.isBlank(mobile)) {
            return "***********";
        }
        Integer len = mobile.length();
        String perFix = mobile.substring(0, 3);
        String endFix = mobile.substring(len - 4, len);

        return perFix + "****" + endFix;
    }

    /**
     * 订单号生成
     * @return
     */
    public static String getOrderCode() {
        String companyPrefix = "OR-";
        return companyPrefix + getTimestampMidStr() + "-" + randomHexString(4);
    }

    /**
     * 提货单号生成
     * @return
     */
    public static String getImportBatchCode() {
        return getTimestampMidStr() + "-" + randomHexString(4);
    }

    /**
     * 提货单号生成
     * @return
     */
    public static String getPurchaseCode() {
        String companyPrefix = "PU-";
        return companyPrefix + getTimestampMidStr() + "-" + randomHexString(4);
    }

    /**
     * 提货单号生成
     * @return
     */
    public static String getOtherSaleCode() {
        String companyPrefix = "O-SALE-";
        return companyPrefix + getTimestampMidStr() + "-" + randomHexString(4);
    }

    /**
     * 提货单号生成
     * @return
     */
    public static String getTransferCode() {
        String companyPrefix = "TRAN-GOODS-";
        return companyPrefix + getTimestampMidStr() + "-" + randomHexString(4);
    }

    /**
     * 提货单号生成
     * @return
     */
    public static String getPurchaseGoodsCode() {
        String companyPrefix = "PUG-";
        return companyPrefix + getTimestampMidStr() + "-" + randomHexString(4);
    }

    public static String hideEmail(String email) {
        if (StringUtils.isBlank(email)) {
            return "***********";
        }
        Integer len = email.length();
        String perfix = email.substring(0, 4);
        String endfix = email.substring(email.indexOf("@"), len);

        return perfix + "****" + endfix;
    }

    public static String joinIntegerList(List<Integer> lists) {
        List<String> ret = Lists.newArrayList();
        for (Integer line: lists) {
            ret.add(line.toString());
        }
        return StringUtils.join(ret, ",");
    }

    public static String likeParamHandle(String param) {
        if (StringUtils.isBlank(param)) {
            return null;
        }
        return "%" + param + "%";
    }

    public static Boolean listIsEmpty(List<?> list) {
        return list == null || list.size() == 0;

    }

    public static Boolean listIsNotEmpty(List<?> list) {
        return !listIsEmpty(list);
    }

    /**
     * 获取16进制随机数
     * @param len
     * @return
     */
    public static String randomHexString(int len)  {
        try {
            StringBuffer result = new StringBuffer();
            for(int i=0;i<len;i++) {
                result.append(Integer.toHexString(new Random().nextInt(16)));
            }
            return result.toString().toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getTimestampMidStr() {
        Long timestamp = System.currentTimeMillis();
        String dataPattern = String.valueOf(timestamp / 1000L);

        return dataPattern;
    }

    /**
     * 获取四位十六进制权限码
     * @return
     */
    public static String getHandleCode() {
        final Integer len = 6;
        String code =  randomHexString(len);

        return code;
    }

    /**
     * 计算百分比 返回 0 ~ 100
     * @param deno 分母
     * @param nume 分子
     */
    public static String percentCalc(Double deno, Double nume) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        Double a = deno;
        Double b = nume;
        Double result = b / a;
        String resStr = numberFormat.format(result);
        Float resF = Float.valueOf(resStr);
        resF = resF * 100f;
        Integer resInt = Integer.valueOf(resF.intValue());

        return resInt.toString();
    }

    /**
     * 计算百分比 返回 0 ~ 100
     * @param deno 分母
     * @param nume 分子
     */
    public static Integer percentCalcForInt(Integer deno, Integer nume) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        Double a = Double.valueOf(deno.toString());
        Double b = Double.valueOf(nume.toString());
        Double result = b / a;
        String resStr = numberFormat.format(result);
        Float resF = Float.valueOf(resStr);
        resF = resF * 100f;
        Integer resInt = Integer.valueOf(resF.intValue());

        return resInt;
    }

    public static String addSeparator(String num) {
        int length = num.length();
        ArrayList list = new ArrayList();
        while (length > 3) {
            list.add(num.substring(length - 3, length));
            length = length - 3;
        }
        // 将前面小于三位的数字添加到ArrayList中
        list.add(num.substring(0, length));
        StringBuffer buffer = new StringBuffer();
        // 倒序拼接
        for (int i = list.size() - 1; i > 0; i--) {
            buffer.append(list.get(i) + ",");
        }
        buffer.append(list.get(0));
        return buffer.toString();
    }

    /**
     * 表格显示转义数字
     * @param number
     * @return
     */
    public static Integer tableNumberShow(Integer number) {
        if (number < 10000) {
            return 0;
        } else {
            return number / 10000;
        }
    }

    public static void main(String[] args) {
        String pass = "18588413909";
        System.out.println(pass.substring(5));
    }
}
