package start;

import presentation.ControllerView;

/**
 * Clasa principala, din care se lanseaza interfata grafica
 */
public class MainClass{
    /**
     * Functia principala
     * @param args argumentele din linia de comanda
     */
    public static void main(String[] args) throws IllegalAccessException {
        ControllerView frame = new ControllerView();
        frame.setVisible(true);
    }
}
