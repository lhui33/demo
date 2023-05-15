package com.kunke.sanguo.utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * <b>类名：</b><br>
 * <br>
 *
 * @author Charles
 * @version 2020/10/12
 */
public class MonitorUtils {
    private MonitorUtils() {}

    /**
     * 获取业务过期时间
     *
     * @param serviceTime 业务时间
     * @param monitorTime 当前监控时间
     * @return 业务过期时间
     */
    public static Integer getServicePassHours(Date serviceTime, Date monitorTime, Integer beginHour, Integer endHour) {
        // 计算三部分组成，业务时间当前的计算，早于要求时间段算0小时，位于时间段内算ServiceTime-BeginTime，晚于要求时间段算整个时间段差
        // 第二部分间隔日数 刨除业务时间日与监控时间日只差 day * (Begin - End)
        // 第三段 监控日计算，时间段外不触发监控，时间段内 算 monitorTime - Begin
        Integer finalInterval = 0;
        Integer intervalDay = 0;
        try {
            intervalDay = getTimeInterval(monitorTime, serviceTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer serviceHour = DateUtil.getHourOfDay(serviceTime);
        Integer monitorHour = DateUtil.getHourOfDay(monitorTime);
        // 业务日，时差计算 ****************begin*****************
        // 业务时间大于结束时间，时差为0
        int serviceInterval = 0;
        // 业务时间小于结束时间
        if (serviceHour < endHour && serviceHour > beginHour) {
            // 非整点推后一小时
            if (DateUtil.getMinute(serviceTime) != 0) {
                serviceInterval = endHour - serviceHour + 1;
            } else {
                serviceInterval = endHour - serviceHour;
            }
            // 业务时间小于开始时间
        } else if (serviceHour < beginHour) {
            serviceInterval = endHour - beginHour;
        }
        // ****************************end*********************
        // 监控时差计算 小于开始时间，按照开始时间计算
        int monitorInterval = monitorHour - beginHour <= 0 ? beginHour : monitorHour - beginHour;

        // 当天监控差计算 监控差 - 业务差
        if (intervalDay < 0) {
            if (serviceHour < beginHour) {
                serviceHour = beginHour;
            }
            finalInterval = monitorHour - serviceHour;
            // 隔天监控差计算 业务差 + 监控差
        } else if (intervalDay == 0) {
            finalInterval = monitorInterval + serviceInterval;
            // 多天监控差计算 业务差 + 监控差 + 间隔天差
        } else {
            int dayInterval = intervalDay * (endHour - beginHour);
            finalInterval = monitorInterval + serviceInterval + dayInterval;
        }

        return finalInterval;
    }

    /**
     * 获取截止日期时长监控
     * @param deadlineTime
     * @param monitorTime
     * @param beginHour
     * @param endHour
     * @return
     */
    public static Integer getDeadlineHours(Date deadlineTime, Date monitorTime, Integer beginHour, Integer endHour) {
        // 计算三部分组成，截止时间当前的计算，早于要求时间段算0小时，位于时间段内算ServiceTime ~ BeginTime，晚于要求时间段算整个时间段差
        // 第二部分间隔日数 刨除业务时间日与监控时间日只差 day * (Begin - End)
        // 第三段 监控日计算，时间段外不触发监控，时间段内 算 monitorTime - Begin
        Integer finalInterval = 0;
        Integer intervalDay = 0;
        try {
            // 截止日监控，业务时间一般大于当前时间，反向调用
            intervalDay = getTimeInterval(deadlineTime, monitorTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer deadlineHour = DateUtil.getHourOfDay(deadlineTime);
        Integer monitorHour = DateUtil.getHourOfDay(monitorTime);
        // 截止日，时差计算 ****************begin*****************
        // 截止时间大于结束时间，时差为0
        int deadlineInterval = 0;
        // 截止时间小于结束时间
        if (deadlineHour < endHour && deadlineHour > beginHour) {
            deadlineInterval = deadlineHour - beginHour;
            // 截止时间大于结束始时间
        } else if (deadlineHour >= endHour) {
            deadlineInterval = endHour - beginHour;
        }
        // ****************************end*********************
        // 监控时差计算 小于开始时间，按照开始时间计算
        int monitorInterval = endHour - monitorHour <= 0 ? 0 : endHour - monitorHour;

        // 当天监控差计算 监控差 - 业务差
        if (intervalDay < 0) {
            if (deadlineHour < beginHour) {
                deadlineHour = beginHour;
            }
            finalInterval = deadlineHour - monitorHour;
            // 隔天监控差计算 业务差 + 监控差
        } else if (intervalDay == 0) {
            finalInterval = monitorInterval + deadlineInterval;
            // 多天监控差计算 业务差 + 监控差 + 间隔天差
        } else {
            int dayInterval = intervalDay * (endHour - beginHour);
            // 三段时间相加
            finalInterval = monitorInterval + deadlineInterval + dayInterval;
        }

        return finalInterval;
    }

    /**
     * 计算业务与监控时间间隔 -1 代表当天，0代表隔天 >0 代表存在天差
     *
     * @param monitorTime 监控时间
     * @param serviceTime 业务时间
     * @return
     */
    private static int getTimeInterval(Date monitorTime, Date serviceTime) throws ParseException {
        Integer monitorHour = DateUtil.getHour(monitorTime);
        Integer monitorMinute = DateUtil.getMinute(monitorTime);
        Integer monitorSecond = DateUtil.getSecond(monitorTime);
        // 将hh:mm:ss 对齐进行时间戳计算, 业务时间一定晚于监控时间
        String calculateTimeStr = DateUtil.dateToString(serviceTime, "yyyy-MM-dd")
                + " " + monitorHour
                + ":" + monitorMinute
                + ":" + monitorSecond;
        Date calculateTime = DateUtil.stringToDate(calculateTimeStr, "yyyy-MM-dd HH:mm:ss");
        int days = (int) ((monitorTime.getTime() - calculateTime.getTime()) / (1000 * 3600 * 24));
        // 减去隔天差
        return days - 1;
    }

    /**
     * 计算剩余工作日
     * @param beginHour
     * @param endHour
     * @param surplusHour
     * @return
     */
    public static String getSurplusDay(Integer beginHour, Integer endHour, Integer surplusHour) {
        Integer dayHours = endHour - beginHour;
        DecimalFormat df = new DecimalFormat("0.0");

        Float surplusDay = (float) surplusHour/dayHours;
        Float zero = 0F;

        if (zero.compareTo(surplusDay) <= 0) {
            return "已到期";
        } else {
            return "还剩" + df.format(surplusDay) + "个工作日";
        }
    }
}
