package model;

/**Modeleaza atrib. tabelului orders din data base*/
public class orders {
    /**Identificatorul unic al fiecarei comenzi*/
    private int id;
    /**Identificatorul produsului*/
    private int idProduct;
    /**Identificatorul clientului*/
    private int idClient;
    /**Cantitatea pe care dorim sa o comandam*/
    private int quantity;
    /**Pretul total*/
    private int price;

    /**Creeaza un obiect instanta a clasei orders*/
    public orders( int id, int idProduct, int idClient, int quantity, int price) {
        this.id = id;
        this.idProduct = idProduct;
        this.idClient = idClient;
        this.quantity = quantity;
        this.price = price;
    }

    /**Creeaza un obiect instanta a clasei orders*/
    public orders(int idProduct, int idClient, int quantity, int price) {
        this.idProduct = idProduct;
        this.idClient = idClient;
        this.quantity = quantity;
        this.price = price;
    }


    /**
     * Obtine id-ul comenzii
     * @return id-ul
     */
    public int getId() {
        return id;
    }

    /**
     * Seteaza id-ul comenzii
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtine id-ul produsului
     * @return idProduct
     */
    public int getIdProduct() {
        return idProduct;
    }

    /**
     * Seteaza id-ul produsului
     * @param idProduct
     */
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * Obtine id-ul clientului
     * @return idClient
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Seteaza id-ul clientului
     * @param idClient
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * Obtine cantitatea
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Seteaza cantitatea
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Obtine pretul total
     * @return pret
     */
    public int getPrice() {
        return price;
    }

    /**
     * Seteaza pretul
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }
}
