package 创建和销毁对象;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class 避免重复对象 {
    //反例
    String s = new String("str");
    //改进
    String s2 = "str";
    /*
     *避免无意识的装箱：可以使用 long、int、double 绝不使用 Long、Integer、Double
     */
}

/**
 * 判断一个美国人是否在婴儿潮出生
 */
class AmericanPeople {
    private final Date birthDate;
    /*
     *婴儿潮日期区间
     */
    private static final Date BOOM_START;
    private static final Date BOOM_END;

    static {
        //仅在初始化的时候创建 Calendar、TimeZone、Date实例一次
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }

    AmericanPeople(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isBabyBoomer() {
        return birthDate.compareTo(BOOM_START) >= 0 &&
                birthDate.compareTo(BOOM_END) < 0;
    }
}
