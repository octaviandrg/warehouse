package dao;

import connection.ConnectionFactory;
import model.client;
import model.orders;
import model.product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Furnizeaza metode pentru interactionarea cu un tabel din baza de date*/
public class abstractDAO<T> {
    /**
     * Tine rostul erorilor intalnite in rularea programului
     */
    protected static final Logger LOGGER = Logger.getLogger(abstractDAO.class.getName());
    /**
     * Clasa genericului
     */
    private final Class<T> type;


    /**
     * Creaza un obiect instanta a clasei abstractDAO
     */
    @SuppressWarnings("unchecked")
    public abstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Creaza obiecte de tipul T cu ajutorul unui result set
     *
     * @param resultSet contine informatii extrase din tabelul corespunzator
     * @return Lista de obiecte de tipul T, fiecare reprezentand o linie din tabel, care se afla in data base
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        try {
            while (resultSet.next()) {
                T instance = type.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    Object value = resultSet.getObject(field.getName());
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }

        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException | SQLException | IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Creaza interogarea de tip SELECT pentru un tabel
     * @param field campurile se doresc a fi selectate
     * @return Obiect al clasei string care contine interogarea
     */
    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     * Creaza interogarea de tip INSERT pentru un tabel
     * @return Obiect al clasei string care contine interogarea
     */
    private String createInsertQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT ");
        sb.append("INTO ");
        sb.append(type.getSimpleName());
        sb.append(" VALUES(");
        for(Field f: type.getDeclaredFields())
            sb.append("?,");
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        return sb.toString();
    }

    /**
     * Creaza interogarea de tip UPDATE pentru un tabel
     * @param field campurile se doresc a fi actualizate
     * @return Obiect al clasei string care contine interogarea
     */
    private String createUpdateQuery(String field){
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(type.getSimpleName());
        sb.append(" SET ");
        for(Field f: type.getDeclaredFields())
            sb.append(f.getName() + "=?,");
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" ");
        sb.append("WHERE " + field + "=?");
        return sb.toString();
    }

    /**
     * Creaza interogarea de tip SELECT *
     * @return Obiect al clasei string care contine interogarea
     */
    private String createSelectAllQuery(){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("* ");
        sb.append("FROM ");
        sb.append((type.getSimpleName()));
        sb.append(";");
        return sb.toString();
    }

    /**
     * Creaza interogarea de tip DELETE pentru un tabel
     * @param field campurile se doresc a fi sterse
     * @return Obiect al clasei string care contine interogarea
     */
    private String createDeleteQuery(String field){
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE ");
        sb.append("FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " = ?");
        return sb.toString();
    }

    /**
     * Creaza un array list de obiecte din clasa T care reprezinta toate datele din tabelul corespunzator
     * @return Lista de obiecte de tipul T
     */
    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAllQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public JTable createTable(List<T> objects) throws IllegalArgumentException, IllegalAccessException {
        ArrayList<String> columnNamesArrayList = new ArrayList<String>();
        for(Field field : objects.get(0).getClass().getDeclaredFields()) {
            field.setAccessible(true);
            columnNamesArrayList.add(field.getName());
        }
        String[] columnNames = new String[columnNamesArrayList.size()];
        columnNames = columnNamesArrayList.toArray(columnNames);
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        Iterator<T> i = objects.iterator();
        while(i.hasNext()) {
            T object = i.next();
            ArrayList<Object> columnDataAsArrayList = new ArrayList<Object>();
            for(Field field : object.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                columnDataAsArrayList.add(field.get(object));
            }
            Object[] columnDataAsArray = new Object[columnDataAsArrayList.size()];
            columnDataAsArray = columnDataAsArrayList.toArray(columnDataAsArray);
            tableModel.addRow(columnDataAsArray);
        }
        return new JTable(tableModel);
    }

    public <T> List<T> getTable(Class<T> type) {
        List<T> result = new ArrayList<>();
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM warehouse." + type.getSimpleName());
            while (resultSet.next()) {
                T instance = type.getDeclaredConstructor().newInstance();
                for (Field field : instance.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    Object value = resultSet.getObject(field.getName());
                    field.set(instance, value);
                }
                result.add(instance);
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return result;
    }



    /**
     * Creaza un array list de obiecte din clasa client care reprezinta toate datele din tabelul corespunzator
     * @return Lista de obiecte de tipul client
     */
    public ArrayList<client> clientList(){
        ArrayList<client> clientList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAllQuery();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            client client;
            while(resultSet.next()){
                client = new client(resultSet.getInt("ID"),resultSet.getString("NAME"),resultSet.getString("EMAIL"),resultSet.getInt("AGE"));
                clientList.add(client);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
            ConnectionFactory.close(resultSet);
        }
        return clientList;
    }



    /**
     * Creaza un array list de obiecte din clasa product care reprezinta toate datele din tabelul corespunzator
     * @return Lista de obiecte de tipul product
     */
    public ArrayList<product> productList(){
        ArrayList<product> productList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAllQuery();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            product product;
            while(resultSet.next()){
                product = new product(resultSet.getInt("ID"),resultSet.getString("NAME"),resultSet.getInt("PRICE"),resultSet.getInt("QUANTITY"));
                productList.add(product);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
            ConnectionFactory.close(resultSet);
        }
        return productList;
    }

    /**
     * Creaza un array list de obiecte din clasa orders care reprezinta toate datele din tabelul corespunzator
     * @return Lista de obiecte de tipul orders
     */
    public ArrayList<orders> ordersList(){
        ArrayList<orders> ordersList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAllQuery();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            orders orders;
            while(resultSet.next()){
                orders = new orders(resultSet.getInt("ID"),resultSet.getInt("IDCLIENT"),resultSet.getInt("IDPRODUCT"),resultSet.getInt("QUANTITY"), resultSet.getInt("PRICE"));
                ordersList.add(orders);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
            ConnectionFactory.close(resultSet);
        }
        return ordersList;
    }

    /**
     * Gaseste obiectul de tipul T din tabelul corespunzator
     * @param id dupa el se face cautarea
     * @return Obiect de tipul T
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Insereaza obiectul t in tabelul corespunzator
     * @param t obiectul care trebuie inserat
     * @return Obiectul de tipul T
     */
    public T insert(T t) {
        Connection dbConnection = null;
        PreparedStatement insertStatement = null;
        int resultSet = 0;
        int i;
        String query = createInsertQuery();
        try{
            i = 1;
            dbConnection = ConnectionFactory.getConnection();
            insertStatement = dbConnection.prepareStatement(query);
            for(Field f: type.getDeclaredFields()){
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(f.getName(), type);
                Method method = propertyDescriptor.getReadMethod();
                Object s = method.invoke(t);
                insertStatement.setObject(i,s);
                i++;
            }
            resultSet = insertStatement.executeUpdate();
            System.out.print("\n");
            return t;
        }catch (SQLException | IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
        }finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return null;
    }

    /**
     * Actualizeaza obiectul t in tabelul corespunzator
     * @param t obiectul care trebuie actualizat
     * @return Obiectul de tipul T
     */
    public T update(T t) {
        Connection dbConnection = null;
        PreparedStatement updateStatement = null;
        int resultSet = 0;
        String query = createUpdateQuery("id");
        try{
            int i = 1;
            dbConnection = ConnectionFactory.getConnection();
            updateStatement = dbConnection.prepareStatement(query);
            for(Field f: type.getDeclaredFields()){
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(f.getName(), type);
                Method method = propertyDescriptor.getReadMethod();
                Object s = method.invoke(t);
                updateStatement.setObject(i,s);
                i++;
            }
            for(Field f: type.getDeclaredFields()){
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(f.getName(), type);
                Method method = propertyDescriptor.getReadMethod();
                Object s = method.invoke(t);
                updateStatement.setObject(i,s);
                break;
            }
            resultSet = updateStatement.executeUpdate();
            return t;
        } catch (SQLException | IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }
        return null;
    }

    /**
     * Sterge obiectul t in tabelul corespunzator
     * @param id respectivului obiect care trebuie sters
     */
    public void delete(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        int resultSet = 0;
        String query = createDeleteQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:delete" + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

}
