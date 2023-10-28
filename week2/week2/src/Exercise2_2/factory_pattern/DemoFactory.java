package Exercise2_2.factory_pattern;

import Exercise2_2.factory_pattern.furniture_factory.ModernFurnitureCompany;
import Exercise2_2.factory_pattern.furniture_factory.OldFurnitureCompany;

public class DemoFactory {
    public static void main(String[] args) {
        ModernFurnitureCompany modernFurnitureCompany = new ModernFurnitureCompany();
        modernFurnitureCompany.createChair();
        modernFurnitureCompany.createDesk();
        OldFurnitureCompany oldFurnitureCompany = new OldFurnitureCompany();
        oldFurnitureCompany.createChair();
        oldFurnitureCompany.createDesk();

    }
}
