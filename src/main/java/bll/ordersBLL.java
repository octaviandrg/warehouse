package bll;

import bll.validators.Validator;

import bll.validators.ordersQuantityValidator;
import dao.ordersDAO;
import model.orders;


import java.util.ArrayList;
import java.util.List;

/**
 * Clasa corespunzatoare validarii informatiilor introduse si transmiterea lor catre baza de date
 */
public class ordersBLL {
    /**
     * Lista de validatoare pentru orders
     */
    private List<Validator<orders>> validators;
    private ordersDAO oDAO;

    /**
     * Constructorul clasei unde se initializeaza validatoarele si ordersDAO
     */
    public ordersBLL(){
        validators = new ArrayList<Validator<orders>>();
        validators.add( new ordersQuantityValidator());
        oDAO = new ordersDAO();
    }

    /**
     * Insereaza in tabelul order
     * @param o comanda care trebuie inserata
     * @return Operatia de insert pe order
     */
    public orders insertOrder(orders o){
        try{
            validators.get(0).validate(o);
            return oDAO.insert(o);
        }catch(Exception e){
            return null;
        }
    }
}
