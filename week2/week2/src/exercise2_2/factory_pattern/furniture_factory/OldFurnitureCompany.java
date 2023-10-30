package exercise2_2.factory_pattern.furniture_factory;

import exercise2_2.factory_pattern.chair.OldChair;
import exercise2_2.factory_pattern.desk.OldDesk;
import exercise2_2.factory_pattern.furniture_interfaces.Chair;
import exercise2_2.factory_pattern.furniture_interfaces.Desk;

public class OldFurnitureCompany implements FurnitureCompany {
    @Override
    public Chair createChair() {
        return new OldChair();
    }

    @Override
    public Desk createDesk() {
        return new OldDesk();
    }
}
