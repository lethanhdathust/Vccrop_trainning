package exercise2_2.factory_pattern.furniture_factory;

import exercise2_2.factory_pattern.furniture_interfaces.Chair;
import exercise2_2.factory_pattern.furniture_interfaces.Desk;

public interface FurnitureCompany {
     Chair createChair();
     Desk createDesk();

//     float caculateTheReal

}
