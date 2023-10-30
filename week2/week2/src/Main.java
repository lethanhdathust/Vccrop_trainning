import exercise2_2.factory_pattern.furniture_factory.ModernFurnitureCompany;

public class Main {
    public static void main(String[] args) {
        ModernFurnitureCompany m = new ModernFurnitureCompany();
        var a = m.createChair();
        System.out.println(a);

    }
}