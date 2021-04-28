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

    /**
     * Constructorul clasei orders
     * @param id id-ul
     * @param idProduct id-ul produsului
     * @param idClient id-ul clientului
     * @param quantity cantitatea pe care dorim sa o comandam
     * @param price pretul total
     */
    public orders( int id, int idProduct, int idClient, int quantity, int price) {
        this.id = id;
        this.idProduct = idProduct;
        this.idClient = idClient;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Constructorul clasei orders
     * @param idProduct id-ul produsului
     * @param idClient id-ul clientului
     * @param quantity cantitatea pe care dorim sa o comandam
     * @param price pretul total
     */
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
     * @param id id-ul comenzii
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
     * @param idProduct id-ul produsului
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
     * @param idClient id-ul clientului
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
     * @param quantity cantitatea
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
     * @param price pretul
     */
    public void setPrice(int price) {
        this.price = price;
    }
}
