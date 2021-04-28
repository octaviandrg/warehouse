package presentation;

import bll.clientBLL;
import bll.ordersBLL;
import bll.productBLL;
import dao.clientDAO;
import dao.ordersDAO;
import dao.productDAO;
import model.client;
import model.orders;
import model.product;
import utils.generateBill;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Se creeaza frame-ul principal si se controleaza butoanele
 */
public class ControllerView extends JFrame{

    /**
     * panel principal
     */
    public JPanel contentPane;
    /**
     * zona de scris date
     */
    public JTextField textFieldNameClient;
    /**
     * zona de scris date
     */
    public JTextField textFieldEmailClient;
    /**
     * zona de scris date
     */
    public JTextField textFieldAgeClient;
    /**
     * zona de scris date
     */
    public JTextField textFieldNameUpdate;
    /**
     * zona de scris date
     */
    public JTextField textFieldEmailUpdate;
    /**
     * zona de scris date
     */
    public JTextField textFieldAgeUpdate;
    /**
     * zona de scris date
     */
    public JTextField textFieldIdUpdate;
    /**
     * zona de scris date
     */
    public JTextField textFieldIdDelete;
    /**
     * tabelul cu clienti
     */
    public JTable tableClients;
    /**
     * zona de scris date
     */
    public JTextField textFieldNameAddProduct;
    /**
     * zona de scris date
     */
    public JTextField textFieldPriceAddProduct;
    /**
     * zona de scris date
     */
    public JTextField textFieldQuantityAddProduct;
    /**
     * zona de scris date
     */
    public JTextField textFieldNameUpdateProduct;
    /**
     * zona de scris date
     */
    public JTextField textFieldPriceUpdateProduct;
    /**
     * zona de scris date
     */
    public JTextField textFieldQuantityUpdateProduct;
    /**
     * zona de scris date
     */
    public JTextField textFieldIdUpdateProduct;
    /**
     * zona de scris date
     */
    public JTextField textFieldIdDeleteProduct;
    /**
     * tabelul cu produse
     */
    public JTable tableProducts;
    /**
     * zona de scris date
     */
    public JTextField textFieldIdClientOrder;
    /**
     * zona de scris date
     */
    public JTextField textFieldIdProductOrder;
    /**
     * zona de scris date
     */
    public JTextField textFieldQuantityOrder;
    /**
     * tabelul cu comenzi
     */
    public JTable tableOrders;


    /**
     * Constructorul clasei care este responsabil de instantierea tuturor obeictelor folosite in interfata
     */
    public ControllerView() {
        setTitle("Warehouse");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 792, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));

        final JPanel panelPrincipal = new JPanel();
        contentPane.add(panelPrincipal, "name_118191072359");
        panelPrincipal.setLayout(null);

        JLabel lblMainMenu = new JLabel("MAIN MENU");
        lblMainMenu.setBounds(343, 28, 99, 15);
        panelPrincipal.add(lblMainMenu);

        JButton btnClients = new JButton("CLIENTS");
        btnClients.setBounds(308, 66, 163, 53);
        panelPrincipal.add(btnClients);

        JButton btnProducts = new JButton("PRODUCTS");
        btnProducts.setBounds(308, 132, 163, 55);
        panelPrincipal.add(btnProducts);

        JButton btnOrders = new JButton("ORDERS");
        btnOrders.setBounds(308, 199, 163, 58);
        panelPrincipal.add(btnOrders);

        final JPanel panelClients = new JPanel();
        contentPane.add(panelClients, "name_118282004700");
        panelClients.setLayout(null);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(43, 29, 50, 15);
        panelClients.add(lblName);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(177, 29, 50, 15);
        panelClients.add(lblEmail);

        JLabel lblAge = new JLabel("Age");
        lblAge.setBounds(325, 29, 42, 15);
        panelClients.add(lblAge);

        textFieldNameClient = new JTextField();
        textFieldNameClient.setBounds(12, 50, 114, 19);
        panelClients.add(textFieldNameClient);
        textFieldNameClient.setColumns(10);

        textFieldEmailClient = new JTextField();
        textFieldEmailClient.setBounds(148, 50, 114, 19);
        panelClients.add(textFieldEmailClient);
        textFieldEmailClient.setColumns(10);

        textFieldAgeClient = new JTextField();
        textFieldAgeClient.setBounds(287, 50, 114, 19);
        panelClients.add(textFieldAgeClient);
        textFieldAgeClient.setColumns(10);

        JButton btnAddClient = new JButton("ADD CLIENT");
        btnAddClient.setBounds(428, 44, 117, 25);
        panelClients.add(btnAddClient);

        JLabel lblName_1 = new JLabel("Name");
        lblName_1.setBounds(187, 81, 50, 15);
        panelClients.add(lblName_1);

        JLabel lblEmail_1 = new JLabel("Email");
        lblEmail_1.setBounds(321, 81, 50, 15);
        panelClients.add(lblEmail_1);

        JLabel lblAge_1 = new JLabel("Age");
        lblAge_1.setBounds(469, 81, 42, 15);
        panelClients.add(lblAge_1);

        JLabel lblId = new JLabel("ID");
        lblId.setBounds(55, 81, 26, 15);
        panelClients.add(lblId);

        textFieldNameUpdate = new JTextField();
        textFieldNameUpdate.setColumns(10);
        textFieldNameUpdate.setBounds(151, 97, 114, 19);
        panelClients.add(textFieldNameUpdate);

        textFieldEmailUpdate = new JTextField();
        textFieldEmailUpdate.setColumns(10);
        textFieldEmailUpdate.setBounds(290, 97, 114, 19);
        panelClients.add(textFieldEmailUpdate);

        textFieldAgeUpdate = new JTextField();
        textFieldAgeUpdate.setColumns(10);
        textFieldAgeUpdate.setBounds(431, 97, 114, 19);
        panelClients.add(textFieldAgeUpdate);

        textFieldIdUpdate = new JTextField();
        textFieldIdUpdate.setColumns(10);
        textFieldIdUpdate.setBounds(15, 97, 114, 19);
        panelClients.add(textFieldIdUpdate);

        JButton btnUpdateClient = new JButton("UPDATE CLIENT");
        btnUpdateClient.setBounds(568, 91, 139, 25);
        panelClients.add(btnUpdateClient);

        textFieldIdDelete = new JTextField();
        textFieldIdDelete.setColumns(10);
        textFieldIdDelete.setBounds(12, 142, 114, 19);
        panelClients.add(textFieldIdDelete);

        JLabel lblId_1 = new JLabel("ID");
        lblId_1.setBounds(55, 128, 26, 15);
        panelClients.add(lblId_1);

        JButton btnDeleteClient = new JButton("DELETE CLIENT");
        btnDeleteClient.setBounds(148, 139, 139, 25);
        panelClients.add(btnDeleteClient);

        JLabel lblClientTable = new JLabel("CLIENT TABLE");
        lblClientTable.setBounds(310, 179, 99, 15);
        panelClients.add(lblClientTable);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(43, 217, 647, 311);
        panelClients.add(scrollPane);

        tableClients = new JTable();
        tableClients.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "ID", "NAME", "EMAIL", "AGE"
                }
        ));
        scrollPane.setViewportView(tableClients);

        JButton btnBackToMainMenuClient = new JButton("MAIN MENU");

        btnBackToMainMenuClient.setBounds(578, 139, 117, 25);
        panelClients.add(btnBackToMainMenuClient);

        final JPanel panelProducts = new JPanel();
        contentPane.add(panelProducts, "name_118378876974");
        panelProducts.setLayout(null);

        JLabel lblNewLabel = new JLabel("Name");
        lblNewLabel.setBounds(52, 12, 43, 15);
        panelProducts.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Price");
        lblNewLabel_1.setBounds(169, 12, 43, 15);
        panelProducts.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Quantity");
        lblNewLabel_2.setBounds(295, 12, 70, 15);
        panelProducts.add(lblNewLabel_2);

        textFieldNameAddProduct = new JTextField();
        textFieldNameAddProduct.setBounds(12, 26, 114, 19);
        panelProducts.add(textFieldNameAddProduct);
        textFieldNameAddProduct.setColumns(10);

        textFieldPriceAddProduct = new JTextField();
        textFieldPriceAddProduct.setBounds(142, 26, 114, 19);
        panelProducts.add(textFieldPriceAddProduct);
        textFieldPriceAddProduct.setColumns(10);

        textFieldQuantityAddProduct = new JTextField();
        textFieldQuantityAddProduct.setBounds(276, 26, 114, 19);
        panelProducts.add(textFieldQuantityAddProduct);
        textFieldQuantityAddProduct.setColumns(10);

        JButton btnAddProduct = new JButton("ADD PRODUCT");
        btnAddProduct.setBounds(458, 23, 140, 25);
        panelProducts.add(btnAddProduct);

        JLabel lblNewLabel_3 = new JLabel("Name");
        lblNewLabel_3.setBounds(182, 70, 43, 15);
        panelProducts.add(lblNewLabel_3);

        JLabel lblNewLabel_1_1 = new JLabel("Price");
        lblNewLabel_1_1.setBounds(299, 70, 43, 15);
        panelProducts.add(lblNewLabel_1_1);

        JLabel lblNewLabel_2_1 = new JLabel("Quantity");
        lblNewLabel_2_1.setBounds(425, 70, 70, 15);
        panelProducts.add(lblNewLabel_2_1);

        textFieldNameUpdateProduct = new JTextField();
        textFieldNameUpdateProduct.setColumns(10);
        textFieldNameUpdateProduct.setBounds(142, 84, 114, 19);
        panelProducts.add(textFieldNameUpdateProduct);

        textFieldPriceUpdateProduct = new JTextField();
        textFieldPriceUpdateProduct.setColumns(10);
        textFieldPriceUpdateProduct.setBounds(272, 84, 114, 19);
        panelProducts.add(textFieldPriceUpdateProduct);

        textFieldQuantityUpdateProduct = new JTextField();
        textFieldQuantityUpdateProduct.setColumns(10);
        textFieldQuantityUpdateProduct.setBounds(406, 84, 114, 19);
        panelProducts.add(textFieldQuantityUpdateProduct);

        JButton btnUpdateProduct = new JButton("UPDATE PRODUCT");
        btnUpdateProduct.setBounds(570, 81, 158, 25);
        panelProducts.add(btnUpdateProduct);

        JLabel lblId_2 = new JLabel("ID");
        lblId_2.setBounds(66, 70, 26, 15);
        panelProducts.add(lblId_2);

        textFieldIdUpdateProduct = new JTextField();
        textFieldIdUpdateProduct.setBounds(12, 84, 114, 19);
        panelProducts.add(textFieldIdUpdateProduct);
        textFieldIdUpdateProduct.setColumns(10);

        textFieldIdDeleteProduct = new JTextField();
        textFieldIdDeleteProduct.setColumns(10);
        textFieldIdDeleteProduct.setBounds(12, 140, 114, 19);
        panelProducts.add(textFieldIdDeleteProduct);

        JLabel lblId_2_1 = new JLabel("ID");
        lblId_2_1.setBounds(66, 126, 26, 15);
        panelProducts.add(lblId_2_1);

        JButton btnDeleteProduct = new JButton("DELETE PRODUCT");
        btnDeleteProduct.setBounds(168, 137, 158, 25);
        panelProducts.add(btnDeleteProduct);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(44, 218, 647, 311);
        panelProducts.add(scrollPane_1);

        tableProducts = new JTable();
        tableProducts.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "ID", "NAME", "PRICE", "QUANTITY"
                }
        ));
        scrollPane_1.setViewportView(tableProducts);

        JButton btnBackToMainMenuProduct = new JButton("MAIN MENU");
        btnBackToMainMenuProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnBackToMainMenuProduct.setBounds(592, 137, 117, 25);
        panelProducts.add(btnBackToMainMenuProduct);

        final JPanel panelOrders = new JPanel();
        contentPane.add(panelOrders, "contentPane");
        panelOrders.setLayout(null);

        JLabel lblIdProdus = new JLabel("ID PRODUS");
        lblIdProdus.setBounds(224, 27, 88, 15);
        panelOrders.add(lblIdProdus);

        JLabel lblIdClient = new JLabel("ID CLIENT");
        lblIdClient.setBounds(70, 27, 70, 15);
        panelOrders.add(lblIdClient);

        JLabel lblQuantity = new JLabel("QUANTITY");
        lblQuantity.setBounds(385, 27, 70, 15);
        panelOrders.add(lblQuantity);

        textFieldIdClientOrder = new JTextField();
        textFieldIdClientOrder.setBounds(51, 41, 114, 19);
        panelOrders.add(textFieldIdClientOrder);
        textFieldIdClientOrder.setColumns(10);

        textFieldIdProductOrder = new JTextField();
        textFieldIdProductOrder.setBounds(204, 41, 114, 19);
        panelOrders.add(textFieldIdProductOrder);
        textFieldIdProductOrder.setColumns(10);

        textFieldQuantityOrder = new JTextField();
        textFieldQuantityOrder.setBounds(360, 41, 114, 19);
        panelOrders.add(textFieldQuantityOrder);
        textFieldQuantityOrder.setColumns(10);

        JButton btnCreateOrder = new JButton("CREATE ORDER");
        btnCreateOrder.setBounds(197, 72, 136, 51);
        panelOrders.add(btnCreateOrder);

        JButton btnBackToClient = new JButton("BACK TO CLIENTS");
        btnBackToClient.setBounds(531, 27, 180, 51);
        panelOrders.add(btnBackToClient);

        JButton btnBackToProduct = new JButton("BACK TO PRODUCTS");
        btnBackToProduct.setBounds(531, 90, 180, 51);
        panelOrders.add(btnBackToProduct);

        JScrollPane scrollPane_1_1 = new JScrollPane();
        scrollPane_1_1.setBounds(44, 191, 647, 322);
        panelOrders.add(scrollPane_1_1);

        tableOrders = new JTable();
        tableOrders.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "ID", "IDCLIENT", "IDPRODUCT", "QUANTITY", "PRICE"
                }
        ));
        scrollPane_1_1.setViewportView(tableOrders);

        btnBackToMainMenuClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panelPrincipal.setVisible(true);
                panelProducts.setVisible(false);
                panelClients.setVisible(false);
                panelOrders.setVisible(false);
            }
        });


        btnBackToMainMenuProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panelPrincipal.setVisible(true);
                panelProducts.setVisible(false);
                panelClients.setVisible(false);
                panelOrders.setVisible(false);
            }
        });

        btnClients.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panelPrincipal.setVisible(false);
                panelProducts.setVisible(false);
                panelClients.setVisible(true);
                panelOrders.setVisible(false);
                DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
                model.setRowCount(0);
                show_clients();

            }
        });

        btnProducts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panelPrincipal.setVisible(false);
                panelProducts.setVisible(true);
                panelClients.setVisible(false);
                panelOrders.setVisible(false);
                DefaultTableModel model = (DefaultTableModel) tableProducts.getModel();
                model.setRowCount(0);
                show_products();
            }
        });

        btnOrders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panelPrincipal.setVisible(false);
                panelProducts.setVisible(false);
                panelClients.setVisible(false);
                panelOrders.setVisible(true);
                DefaultTableModel model = (DefaultTableModel) tableOrders.getModel();
                model.setRowCount(0);
                show_orders();
            }
        });

        btnBackToClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panelPrincipal.setVisible(false);
                panelProducts.setVisible(false);
                panelClients.setVisible(true);
                panelOrders.setVisible(false);
                DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
                model.setRowCount(0);
                show_clients();
            }
        });

        btnBackToProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panelPrincipal.setVisible(false);
                panelProducts.setVisible(true);
                panelClients.setVisible(false);
                panelOrders.setVisible(false);
                DefaultTableModel model = (DefaultTableModel) tableProducts.getModel();
                model.setRowCount(0);
                show_products();
            }
        });



        btnAddClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                client c = new client( textFieldNameClient.getText(),textFieldEmailClient.getText(),Integer.parseInt(textFieldAgeClient.getText()));
                clientBLL cBLL = new clientBLL();
                cBLL.insertClient(c);
                DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
                model.addRow(new Object[]{(int)tableClients.getValueAt((tableClients.getRowCount()-1), 0)+1, c.getName(),c.getEmail(),c.getAge()});
            }
        });

        btnUpdateClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                clientBLL cBLL = new clientBLL();
                clientDAO cDAO = new clientDAO();
                ArrayList<client> list = cDAO.clientList();
                int id = Integer.parseInt(textFieldIdUpdate.getText());
                int row = 0;
                int verif = 0;
                for(client client : list){
                    if(client.getId() == id){
                        try {
                            verif = 1;
                            Field idF = client.getClass().getDeclaredField("id");
                            Field nameF = client.getClass().getDeclaredField("name");
                            Field emailF = client.getClass().getDeclaredField("email");
                            Field ageF = client.getClass().getDeclaredField("age");
                            idF.setAccessible(true);
                            nameF.setAccessible(true);
                            emailF.setAccessible(true);
                            ageF.setAccessible(true);
                            nameF.set(client, textFieldNameUpdate.getText());
                            emailF.set(client, textFieldEmailUpdate.getText());
                            ageF.set(client, Integer.parseInt(textFieldAgeUpdate.getText()));
                        } catch (NoSuchFieldException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }else {++row;}
                    cBLL.updateClient(client);
                    if(verif == 1) {
                        DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
                        model.setValueAt(client.getName(), row, 1);
                        model.setValueAt(client.getEmail(), row, 2);
                        model.setValueAt(client.getAge(), row, 3);
                        break;
                    }
                    verif = 0;
                }
            }
        });

        btnDeleteClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                clientBLL cBLL = new clientBLL();
                clientDAO cDAO = new clientDAO();
                ArrayList<client> list = cDAO.clientList();
                int id = Integer.parseInt(textFieldIdDelete.getText());
                int row = 0;
                int verif = 0;
                for (client client : list) {
                    if (client.getId() == id) {
                        cBLL.deleteClient(id);
                        verif = 1;
                    }
                    else{++row;}
                    if(verif == 1) {
                        DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
                        model.removeRow(row);
                        break;
                    }
                }
            }
        });

        btnAddProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                product p = new product( textFieldNameAddProduct.getText(),Integer.parseInt(textFieldPriceAddProduct.getText()),Integer.parseInt(textFieldQuantityAddProduct.getText()));
                productBLL cBLL = new productBLL();
                cBLL.insertProduct(p);
                DefaultTableModel model = (DefaultTableModel) tableProducts.getModel();
                model.addRow(new Object[]{(int)tableProducts.getValueAt((tableProducts.getRowCount()-1), 0)+1, p.getName(),p.getPrice(),p.getQuantity()});

            }
        });

        btnUpdateProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                productBLL pBLL = new productBLL();
                productDAO pDAO = new productDAO();
                ArrayList<product> list = pDAO.productList();
                int id = Integer.parseInt(textFieldIdUpdateProduct.getText());
                int row = 0;
                int verif = 0;
                for(product product : list){
                    if(product.getId() == id){
                        try {
                            verif = 1;
                            Field idF = product.getClass().getDeclaredField("id");
                            Field nameF = product.getClass().getDeclaredField("name");
                            Field priceF = product.getClass().getDeclaredField("price");
                            Field quantityF = product.getClass().getDeclaredField("quantity");
                            idF.setAccessible(true);
                            nameF.setAccessible(true);
                            priceF.setAccessible(true);
                            quantityF.setAccessible(true);
                            nameF.set(product, textFieldNameUpdateProduct.getText());
                            priceF.set(product, Integer.parseInt(textFieldPriceUpdateProduct.getText()));
                            quantityF.set(product, Integer.parseInt(textFieldQuantityUpdateProduct.getText()));
                        } catch (NoSuchFieldException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }else {++row;}
                    pBLL.updateProduct(product);
                    if(verif == 1) {
                        DefaultTableModel model = (DefaultTableModel) tableProducts.getModel();
                        model.setValueAt(product.getName(), row, 1);
                        model.setValueAt(product.getPrice(), row, 2);
                        model.setValueAt(product.getQuantity(), row, 3);
                        break;
                    }
                    verif = 0;
                }
            }
        });

        btnDeleteProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                    productBLL pBLL = new productBLL();
                    productDAO pDAO = new productDAO();
                    ArrayList<product> list = pDAO.productList();
                    int id = Integer.parseInt(textFieldIdDeleteProduct.getText());
                    int row = 0;
                    int verif = 0;
                    for (product product : list) {
                        if (product.getId() == id) {
                            pBLL.deleteProduct(id);
                            verif = 1;
                        }
                        else{++row;}
                        if(verif == 1) {
                            DefaultTableModel model = (DefaultTableModel) tableProducts.getModel();
                            model.removeRow(row);
                            break;
                        }
                    }
                }
        });

        btnCreateOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int idClient = Integer.parseInt(textFieldIdClientOrder.getText());
                int idProduct = Integer.parseInt(textFieldIdProductOrder.getText());
                int quantity = Integer.parseInt(textFieldQuantityOrder.getText());
                ordersBLL oBLL = new ordersBLL();
                productBLL pBLL = new productBLL();
                productDAO pDAO = new productDAO();
                clientBLL cBLL = new clientBLL();
                clientDAO cDAO = new clientDAO();
                ArrayList<product> listProducts = pDAO.productList();
                ArrayList<client> listClients = cDAO.clientList();
                int verif = 0;
                int price = 0;
                client c_aux = null;
                product p_aux = null;
                for(product p : listProducts){
                    if(p.getId() == idProduct){
                        if(p.getQuantity() >= quantity){
                            Field quantityF = null;
                            try {
                                p_aux = p;
                                quantityF = p.getClass().getDeclaredField("quantity");
                                quantityF.setAccessible(true);
                                quantityF.set(p, (int)quantityF.get(p) - quantity);
                                pBLL.updateProduct(p);
                            } catch (NoSuchFieldException | IllegalAccessException e) {
                                e.printStackTrace();
                            }
                            price = quantity * p.getPrice();
                            for(client c : listClients){
                                if (c.getId() == idClient) {
                                    c_aux = c;
                                    verif = 1;
                                    break;
                                }
                            }
                        }
                    }
                    if(verif == 1){
                        orders o = new orders(Integer.parseInt(textFieldIdProductOrder.getText()),Integer.parseInt(textFieldIdClientOrder.getText()),Integer.parseInt(textFieldQuantityOrder.getText()),price);
                        oBLL.insertOrder(o);
                        DefaultTableModel model = (DefaultTableModel) tableOrders.getModel();
                        model.addRow(new Object[]{(int)tableOrders.getValueAt((tableOrders.getRowCount()-1), 0)+1,o.getIdClient(),o.getIdProduct(), o.getQuantity(), o.getPrice()});
                        try {
                            new generateBill((int)tableOrders.getValueAt((tableOrders.getRowCount()-1), 0)+1,c_aux,p_aux,quantity,price);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
            }
        });
    }

    /**
     * Afiseaza datele in tabelul din interfata
     */
    public void show_clients(){
        clientDAO c = new clientDAO();
        ArrayList<client> list = c.clientList();
        DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
        Object[] row = new Object[4];
        for(client cl : list){
            row[0] = cl.getId();
            row[1] = cl.getName();
            row[2] = cl.getEmail();
            row[3] = cl.getAge();
            model.addRow(row);
        }
    }

    /**
     * Afiseaza datele in tabelul din interfata
     */
    public void show_products(){
        productDAO p = new productDAO();
        ArrayList<product> list = p.productList();
        DefaultTableModel model = (DefaultTableModel) tableProducts.getModel();
        Object[] row = new Object[4];
        for(product pl : list){
            row[0] = pl.getId();
            row[1] = pl.getName();
            row[2] = pl.getPrice();
            row[3] = pl.getQuantity();
            model.addRow(row);
        }
    }

    /**
     * Afiseaza datele in tabelul din interfata
     */
    public void show_orders(){
        ordersDAO o = new ordersDAO();
        ArrayList<orders> list = o.ordersList();
        DefaultTableModel model = (DefaultTableModel) tableOrders.getModel();
        Object[] row = new Object[5];
        for(orders ol : list){
            row[0] = ol.getId();
            row[1] = ol.getIdProduct();
            row[2] = ol.getIdClient();
            row[3] = ol.getQuantity();
            row[4] = ol.getPrice();
            model.addRow(row);
        }
    }

    }
