package com.abstractfactory.furnitureShop.models.factoryImpl;

import com.abstractfactory.furnitureShop.interfaces.Furniture;
import com.abstractfactory.furnitureShop.interfaces.categories.bed.Bed;
import com.abstractfactory.furnitureShop.interfaces.categories.chairs.Chair;
import com.abstractfactory.furnitureShop.interfaces.categories.sofa.Sofa;
import com.abstractfactory.furnitureShop.interfaces.categories.table.Table;
import com.abstractfactory.furnitureShop.interfaces.factory.FurnitureFactory;
import com.abstractfactory.furnitureShop.models.categories.almirah.AntiqueAlmirahImpl;
import com.abstractfactory.furnitureShop.models.categories.bed.AntiqueBedImpl;
import com.abstractfactory.furnitureShop.models.categories.chair.AntiqueChairImpl;
import com.abstractfactory.furnitureShop.models.categories.sofa.AntiqueSofaImpl;
import com.abstractfactory.furnitureShop.models.categories.table.AntiqueTableImpl;

public class AntiqueFurnitureFactory implements FurnitureFactory {

    public AntiqueFurnitureFactory() {
        System.out.println("Welcome to Antique Furniture Factory! 🫡");
    }
    @Override
    public Furniture createChair() {
        return new AntiqueChairImpl();
    }

    @Override
    public Furniture createSofa() {
        return new AntiqueSofaImpl();
    }

    @Override
    public Furniture createTable() {
        return new AntiqueTableImpl();
    }

    @Override
    public Furniture createBed() {
        return new AntiqueBedImpl();
    }

    @Override
    public Furniture createAlmirah() {
        return new AntiqueAlmirahImpl();
    }
}
