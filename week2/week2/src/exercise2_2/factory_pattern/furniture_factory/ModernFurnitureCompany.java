package exercise2_2.factory_pattern.furniture_factory;

import exercise2_2.factory_pattern.chair.ModernChair;
import exercise2_2.factory_pattern.desk.ModernDesk;
import exercise2_2.factory_pattern.furniture_interfaces.Chair;
import exercise2_2.factory_pattern.furniture_interfaces.Desk;

public class ModernFurnitureCompany implements FurnitureCompany {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Desk createDesk() {
        return new ModernDesk();
    }


}
