package com.kunke.sanguo.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * <b>类名：</b><br>
 * <br>
 *
 * @author Charles
 * @version 2020/9/26
 */
public class DoubleUtils {
    /**
     * 静态单利禁止实例化
     */
    private DoubleUtils () {}

    /**
     * 加法 a + b
     * @param a
     * @param b
     * @return
     */
    public static Double add(Double a, Double b) {
        if (a == null && b != null) {
            return b;
        } else if (a != null && b == null) {
            return a;
        } else if (a == null && b == null) {
            return 0D;
        }

        BigDecimal a1 = BigDecimal.valueOf(a);
        BigDecimal b1 = BigDecimal.valueOf(b);

        return a1.add(b1).doubleValue();
    }

    /**
     * 减法 a - b
     * @param a
     * @param b
     * @return
     */
    public static Double sub(Double a, Double b) {
        a = a == null ? 0D : a;
        b = b == null ? 0D : b;
        BigDecimal a1 = BigDecimal.valueOf(a);
        BigDecimal b1 = BigDecimal.valueOf(b);

        return a1.subtract(b1).doubleValue();
    }

    /**
     * 乘法 a*b
     * @param a
     * @param b
     * @return
     */
    public static Double mul(Double a, Double b) {
        a = a == null ? 0D : a;
        b = b == null ? 0D : b;

        BigDecimal a1 = BigDecimal.valueOf(a);
        BigDecimal b1 = BigDecimal.valueOf(b);

        return a1.multiply(b1).doubleValue();
    }

    /**
     * 除法 a/b
     * @param a
     * @param b
     * @return
     */
    public static Double divide(Double a, Double b) {
        a = a == null ? 0D : a;
        b = b == null ? 0D : b;
        if (b == 0D) {
            return 0D;
        }

        BigDecimal a1 = BigDecimal.valueOf(a);
        BigDecimal b1 = BigDecimal.valueOf(b);

        return a1.divide(b1, 2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static String toString(Double d) {
        DecimalFormat df = new DecimalFormat( "#.##" );
        return df.format(d);
    }

    public static String format(Double d) {
        DecimalFormat df = new DecimalFormat( "#.##" );
        return df.format(d);
    }

}
