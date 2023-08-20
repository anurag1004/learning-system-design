package com.abstractfactory.furnitureShop.models.factoryImpl;

import com.abstractfactory.furnitureShop.interfaces.Furniture;
import com.abstractfactory.furnitureShop.interfaces.categories.bed.Bed;
import com.abstractfactory.furnitureShop.interfaces.categories.chairs.Chair;
import com.abstractfactory.furnitureShop.interfaces.categories.sofa.Sofa;
import com.abstractfactory.furnitureShop.interfaces.categories.table.Table;
import com.abstractfactory.furnitureShop.interfaces.factory.FurnitureFactory;
import com.abstractfactory.furnitureShop.models.categories.almirah.AntiqueAlmirahImpl;
import com.abstractfactory.furnitureShop.models.categories.almirah.ArtDecoAlmirahImpl;
import com.abstractfactory.furnitureShop.models.categories.bed.ArtDecoBedImpl;
import com.abstractfactory.furnitureShop.models.categories.chair.ArtDecoChairImpl;
import com.abstractfactory.furnitureShop.models.categories.sofa.ArtDecoSofaImpl;
import com.abstractfactory.furnitureShop.models.categories.table.ArtDecoTableImpl;

public class ArtDecoFurnitureFactory implements FurnitureFactory {

    public ArtDecoFurnitureFactory() {
        System.out.println("Welcome to Art Deco Furniture Factory! 🫡");
    }
    @Override
    public Furniture createChair() {
        return new ArtDecoChairImpl();
    }

    @Override
    public Furniture createSofa() {
        return new ArtDecoSofaImpl();
    }

    @Override
    public Furniture createTable() {
        return new ArtDecoTableImpl();
    }

    @Override
    public Furniture createBed() {
        return new ArtDecoBedImpl();
    }

    @Override
    public Furniture createAlmirah() {
        return new ArtDecoAlmirahImpl();
    }
}
