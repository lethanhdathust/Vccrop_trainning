package Exercise2_2.factory_pattern.furniture_factory;

import Exercise2_2.factory_pattern.chair.OldChair;
import Exercise2_2.factory_pattern.desk.OldDesk;
import Exercise2_2.factory_pattern.furniture_interfaces.Chair;
import Exercise2_2.factory_pattern.furniture_interfaces.Desk;

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
