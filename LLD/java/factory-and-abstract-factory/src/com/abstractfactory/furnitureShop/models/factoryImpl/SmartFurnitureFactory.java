package com.abstractfactory.furnitureShop.models.factoryImpl;

import com.abstractfactory.furnitureShop.interfaces.Furniture;
import com.abstractfactory.furnitureShop.interfaces.categories.bed.Bed;
import com.abstractfactory.furnitureShop.interfaces.categories.chairs.Chair;
import com.abstractfactory.furnitureShop.interfaces.categories.sofa.Sofa;
import com.abstractfactory.furnitureShop.interfaces.categories.table.Table;
import com.abstractfactory.furnitureShop.interfaces.factory.FurnitureFactory;
import com.abstractfactory.furnitureShop.models.categories.almirah.AntiqueAlmirahImpl;
import com.abstractfactory.furnitureShop.models.categories.almirah.SmartAlmirahImpl;
import com.abstractfactory.furnitureShop.models.categories.bed.ModernBedImpl;
import com.abstractfactory.furnitureShop.models.categories.chair.SmartChairImpl;
import com.abstractfactory.furnitureShop.models.categories.sofa.ModernSofaImpl;
import com.abstractfactory.furnitureShop.models.categories.table.ModernTableImpl;

public class SmartFurnitureFactory implements FurnitureFactory {

    public SmartFurnitureFactory() {
        System.out.println("Welcome to Smart Furniture Factory! 🫡");
    }
    @Override
    public Furniture createChair() {
        return new SmartChairImpl();
    }

    @Override
    public Furniture createSofa() {
        return new ModernSofaImpl();
    }

    @Override
    public Furniture createTable() {
        return new ModernTableImpl();
    }

    @Override
    public Furniture createBed() {
        return new ModernBedImpl();
    }

    @Override
    public Furniture createAlmirah() {
        return new SmartAlmirahImpl();
    }
}
