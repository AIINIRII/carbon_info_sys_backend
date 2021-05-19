package xyz.aiinirii.carboninfosys.enums;

/**
 * @author AIINIRII
 */
public enum PeriodType {
    DAILY(0), WEEKLY(1), MONTHLY(2), SEASONAL(3), ANNUAL(4);

    int val;

    PeriodType(int i) {
        val = i;
    }

    public int getVal() {
        return val;
    }

    public static PeriodType getType(int i) {
        for (PeriodType p : values()) {
            if (p.val == i) {
                return p;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }
}