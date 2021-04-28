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

    /**Creeaza un obiect instanta a clasei product*/
    public product(int id, String name, int price, int quantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**Creeaza un obiect instanta a clasei product*/
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
     * @param quantity
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
     * @param id
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
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Seteaza pretul
     * @param price
     */
    public void setPrice(int price){
        this.price = price;
    }

}
