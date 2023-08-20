package com.abstractfactory.furnitureShop;

import com.abstractfactory.furnitureShop.interfaces.factory.FurnitureFactory;
import com.abstractfactory.furnitureShop.models.factoryImpl.AntiqueFurnitureFactory;
import com.abstractfactory.furnitureShop.models.factoryImpl.ArtDecoFurnitureFactory;
import com.abstractfactory.furnitureShop.models.factoryImpl.ModernFurnitureFactory;
import com.abstractfactory.furnitureShop.models.factoryImpl.SmartFurnitureFactory;

public class FurnitureShop {
    // furniture shop
    /*
    * TYPES- antique, modern, ArtDeco, smart
    * Categories- Chair, Table, Sofa, Bed
    */
    public FurnitureFactory getFurnitureFactory(String type){
        if(type.equalsIgnoreCase("antique")) {
            return new AntiqueFurnitureFactory();
        }else if(type.equalsIgnoreCase("modern")) {
            return new ModernFurnitureFactory();
        }else if(type.equalsIgnoreCase("artDeco")) {
            return new ArtDecoFurnitureFactory();
        }else if(type.equalsIgnoreCase("smart")) {
            return new SmartFurnitureFactory();
        }else {
            return null;
        }
    }
}
