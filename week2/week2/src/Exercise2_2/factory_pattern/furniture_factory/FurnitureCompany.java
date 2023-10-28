package Exercise2_2.factory_pattern.furniture_factory;

import Exercise2_2.factory_pattern.furniture_interfaces.Chair;
import Exercise2_2.factory_pattern.furniture_interfaces.Desk;

public interface FurnitureCompany {
     Chair createChair();
     Desk createDesk();

//     float caculateTheReal

}
