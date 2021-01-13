package lab4.lib;

public interface SleepyHead {
    void sleep() throws WrongSleepCondition;
    void wake() throws WrongSleepCondition;
}

