package bll;

import bll.validators.Validator;
import bll.validators.clientAgeValidator;
import bll.validators.clientEmailValidator;
import dao.clientDAO;
import model.client;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Clasa corespunzatoare validarii informatiilor introduse si transmiterea lor catre baza de date
 */
public class clientBLL {
    /**
     * Lista de validatoare pentru client
     */
    private List<Validator<client>> validators;

    private clientDAO cDAO;

    /**
     * Constructorul clasei unde se initializeaza validatoarele si clientDAO
     */
    public clientBLL(){
        validators = new ArrayList<Validator<client>>();
        validators.add(new clientEmailValidator());
        validators.add(new clientAgeValidator());
        cDAO = new clientDAO();
    }

    /**
     * Gaseste clientul cu id-ul dat ca si parametru
     * @param id paratemtrul dupa care se cauta clientul in tabel
     * @return Clientul cu id-ul dat ca si parametru
     */
    public client findClientById(int id){
        client c = cDAO.findById(id);
        if (c == null) {
            throw new NoSuchElementException("The client with id " + id + " was not found!");
        }
        return c;
    }

    /**
     * Insereaza in tabelul client
     * @param c clientul care trebuie inserat
     * @return Operatia de insert pe client
     */
    public client insertClient(client c){
        try{
            validators.get(0).validate(c);
            validators.get(1).validate(c);
            return cDAO.insert(c);
        }catch(Exception e){
            return null;
        }
    }

    /**
     * Actualizeaza in tabelul client
     * @param c clientul care trebuie actualizat
     * @return Operatia de update pe client
     */
    public client updateClient(client c){
        try{
            client cl = cDAO.update(c);
            return cl;
        }catch(Exception e){
            throw new NoSuchElementException("This client does not exist!");
        }
    }

    /**
     * Sterge in tabelul client
     * @param id clientul care trebuie sters dupa parametru
     */
    public void deleteClient(int id){
        try{
            cDAO.delete(id);
        }catch(Exception e){
            throw new NoSuchElementException("This client does not exist!");
        }
    }

    /**
     * Gaseste toti clientii din tabela client
     * @return lista in care se afla toti clientii din tabela
     */
    public List<client> findAll(){
        List<client> clients;
        try{
            clients = cDAO.findAll();
        }catch(Exception e){
            throw new NoSuchElementException("There are no clients in the table");
        }
        return clients;
    }
}
