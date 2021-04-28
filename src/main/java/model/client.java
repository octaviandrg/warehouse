package model;


/**Modeleaza atrib. tabelului client din data base*/
public class client {

    /**Idenficatorul unic al fiecarui client*/
    private  int id;
    /**Numele clientului*/
    private String name;
    /**Email-ul clientului*/
    private  String email;
    /**Varsta clientului*/
    private  int age;

    /**
     * Constructorul clasei client
     * @param id id-ul
     * @param name numele
     * @param email email-ul
     * @param age varsta
     */
    public client(int id, String name, String email, int age){
        this.id = id;
        this.email = email;
        this.name = name;
        this.age = age;
    }

    /**
     * Constructorul clasei client
     * @param name numele
     * @param email email-ul
     * @param age varsta
     */
    public client( String name, String email, int age){
        this.email = email;
        this.name = name;
        this.age = age;
    }

    /**
     * Obtine id-ul clientului
     * @return id-ul
     */
    public  int getId(){
        return id;
    }

    /**
     * Obtine numele clientului
     * @return numele
     */
    public  String getName(){
        return name;
    }

    /**
     * Obtine email-ul clientului
     * @return email-ul
     */
    public   String getEmail(){
        return email;
    }

    /**
     * Obtine varsta clientului
     * @return varsta
     */
    public  int getAge(){
        return age;
    }

    /**
     * Seteaza id-ul clientului cu valoarea specificata de id
     * @param id valoarea id-ului clientului
     */
    public  void setId(int id){
        this.id = id;
    }

    /**
     * Seteaza numele clientului cu valoarea specificata de name
     * @param name numele clientului
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Seteaza email-ul clientului cu valoarea specificata de email
     * @param email email-ul clientului
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * Seteaza varsta clientului cu valoarea specificata de age
     * @param age vartsa clientului
     */
    public  void setAge(int age){
        this.age = age;
    }


}
