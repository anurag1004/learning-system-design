package parkinglot.strategies;

import parkinglot.model.slot.Slot;

public class ConsolePrinter implements Printer{

    @Override
    public void print(Slot slot) {
        System.out.printf("| %d |", slot.getId());
    }
}
