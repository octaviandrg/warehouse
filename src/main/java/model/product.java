package model;


/**Modeleaza atrib. tabelului product din data base*/
public class product {
    /**Identificatorul unic al fiecarei comenzi*/
    private int id;
    /**Numele produsului*/
    private String name;
    /**Pretul produsului*/
    private int price;
    /**Cantitatea produsului*/
    private int quantity;

    /**
     * Creeaza un obiect de tipul product
     * @param id id-ul produsului
     * @param name numele
     * @param price pretul
     * @param quantity cantitatea
     */
    public product(int id, String name, int price, int quantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Creeaza un obiect de tipul product
     * @param name numele
     * @param price pretul
     * @param quantity cantitatea
     */
    public product(String name, int price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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
     * Obtine id-ul
     * @return id
     */
    public int getId(){
        return id;
    }

    /**
     * Seteaza id-ul
     * @param id id-ul
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * Obtine numele
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * Obtine pretul
     * @return price
     */
    public int getPrice(){
        return price;
    }

    /**
     * Seteaza numele
     * @param name numele
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Seteaza pretul
     * @param price pretul
     */
    public void setPrice(int price){
        this.price = price;
    }

}
