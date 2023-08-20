package com.abstractfactory.furnitureShop.interfaces.factory;

import com.abstractfactory.furnitureShop.interfaces.Furniture;
import com.abstractfactory.furnitureShop.interfaces.categories.bed.Bed;
import com.abstractfactory.furnitureShop.interfaces.categories.chairs.Chair;
import com.abstractfactory.furnitureShop.interfaces.categories.sofa.Sofa;
import com.abstractfactory.furnitureShop.interfaces.categories.table.Table;

public interface FurnitureFactory{
    Furniture createChair();
    Furniture createSofa();
    Furniture createTable();
    Furniture createBed();

    Furniture createAlmirah();
}
