package bll.validators;

import model.client;

import static java.lang.System.exit;


public class clientAgeValidator implements Validator<client>{
    private static final int MIN_AGE = 5;

    /**
     * Verifica daca clientul c respecta restrictia de varsta
     * @param c clientul care se verifica
     */
    @Override
    public void validate(client c) {
        if(c.getAge() < MIN_AGE){
            throw new IllegalArgumentException("The Client Age min is not respected!");
        }
    }
}
