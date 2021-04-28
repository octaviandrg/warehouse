package bll.validators;

import model.product;

public class productPriceValidator implements Validator<product>{
    private static final int MIN_PRICE = 5;
    /**
     * Verifica daca produseul p respecta conditia de pret minim
     * @param p produsul care se verifica
     */
    @Override
    public void validate(product p) {
        if(p.getPrice() < MIN_PRICE){
            throw new IllegalArgumentException("The Product Price min is not respected!");
        }

    }
}
