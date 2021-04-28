package bll.validators;

/**
 * Interfata care este responsabila de validarea informatiilor care urmeaza sa fie trimise catre data base
 * @param <T> tipul de validare
 */
public interface Validator<T> {
    /**
     * Metoda care verifica daca datele introduse de catre utilizator respecta formatul
     * @param t obiectul care se valizeaza
     */
    void validate(T t);
}
