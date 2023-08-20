import com.abstractfactory.furnitureShop.FurnitureShop;
import com.abstractfactory.furnitureShop.interfaces.Furniture;
import com.abstractfactory.furnitureShop.interfaces.factory.FurnitureFactory;

public class Main {
    public static void main(String[] args) {
        FurnitureShop furnitureShop = new FurnitureShop();
        FurnitureFactory antiqueFurnitureFactory = furnitureShop.getFurnitureFactory("antique");
        Furniture antiqueChair = antiqueFurnitureFactory.createChair();
        Furniture antiqueSofa = antiqueFurnitureFactory.createSofa();
        Furniture antiqueTable = antiqueFurnitureFactory.createTable();
        Furniture antiqueBed = antiqueFurnitureFactory.createBed();
        Furniture antiqueAlmirah = antiqueFurnitureFactory.createAlmirah();

        FurnitureFactory modernFurnitureFactory = furnitureShop.getFurnitureFactory("modern");
        Furniture modernChair = modernFurnitureFactory.createChair();
        Furniture modernSofa = modernFurnitureFactory.createSofa();
        Furniture modernTable = modernFurnitureFactory.createTable();
        Furniture modernBed = modernFurnitureFactory.createBed();
        Furniture modernAlmirah = modernFurnitureFactory.createAlmirah();

        FurnitureFactory smartFurnitureFactory = furnitureShop.getFurnitureFactory("smart");
        Furniture smartChair = smartFurnitureFactory.createChair();
        Furniture smartSofa = smartFurnitureFactory.createSofa();
        Furniture smartTable = smartFurnitureFactory.createTable();
        Furniture smartBed = smartFurnitureFactory.createBed();
        Furniture smartAlmirah = smartFurnitureFactory.createAlmirah();
    }
}