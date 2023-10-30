package exercise2_2.factory_pattern.chair;

import exercise2_2.factory_pattern.furniture_interfaces.Chair;

public class OldChair implements Chair {
    public OldChair() {
        System.out.println("This is the old chair");
    }
}
