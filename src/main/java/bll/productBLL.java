package bll;

import bll.validators.Validator;
import bll.validators.productPriceValidator;
import dao.productDAO;
import model.product;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Clasa corespunzatoare validarii informatiilor introduse si transmiterea lor catre baza de date
 */
public class productBLL {
    /**
     * Lista de validatoare pentru product
     */
    private List<Validator<product>> validators;
    private productDAO pDAO;

    /**
     * Constructorul clasei unde se initializeaza validatoarele si productDAO
     */
    public productBLL(){
        validators = new ArrayList<Validator<product>>();
        validators.add(new productPriceValidator());
        pDAO = new productDAO();
    }

    /**
     * Gaseste produsul cu id-ul dat ca si parametru
     * @param id paratemtrul dupa care se cauta produsul in tabel
     * @return Produsul cu id-ul dat ca si parametru
     */
    public product findProductById(int id){
        product p = pDAO.findById(id);
        if (p == null) {
            throw new NoSuchElementException("The product with id " + id + " was not found!");
        }
        return p;
    }

    /**
     * Insereaza in tabelul product
     * @param p produsul care trebuie inserat
     * @return Operatia de insert pe product
     */
    public product insertProduct(product p){
        try{
            validators.get(0).validate(p);
            return pDAO.insert(p);
        }catch(Exception e){
            return null;
        }
    }

    /**
     * Actualizeaza in tabelul product
     * @param p produsul care trebuie actualizat
     * @return Operatia de update pe product
     */
    public product updateProduct(product p){
        try{
            product pr = pDAO.update(p);
            return pr;
        }catch(Exception e){
            throw new NoSuchElementException("This product does not exist!");
        }
    }

    /**
     * Sterge in tabelul product
     * @param id produsul care trebuie sters dupa parametru
     * @return Operatia de delete pe product
     */
    public void deleteProduct(int id){
        try{
            pDAO.delete(id);
        }catch(Exception e){
            throw new NoSuchElementException("This product does not exist!");
        }
    }

    /**
     * Gaseste toate produsele din tabela product
     * @return lista in care se afla toate produsele din tabela
     */
    public List<product> findAll(){
        List<product> products = new ArrayList<product>();
        try{
            products = pDAO.findAll();
        }catch(Exception e){
            throw new NoSuchElementException("There are no products in the table");
        }
        return products;
    }
}
