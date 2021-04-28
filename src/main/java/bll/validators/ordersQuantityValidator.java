package bll.validators;

import model.orders;

public class ordersQuantityValidator implements Validator<orders>{
    private static final int MIN_QUANTITY = 2;
    /**
     * Verifica daca comanda o respecta restrictia de cantitate
     * @param o comanda care se verifica
     */
    @Override
    public void validate(orders o) {
        if(o.getPrice() < MIN_QUANTITY){
            throw new IllegalArgumentException("The Orders Quantity min is not respected!");
        }
    }
}
