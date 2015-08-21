package GUI;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Martin on 07.07.2015.
 */
public class ProductRepository {

    //Database Information
    private ResultSet result = null;
    private Statement statement = null;
    private Connection conn;
    private boolean connection;
    ArrayList<Product> results;
    static final String host = "jdbc:mysql://sql4.freesqldatabase.com:3306/sql483664";
    Product p;


    public ProductRepository() {
        results = new ArrayList<Product>();
        connectDatabase();
    }

    private void connectDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(host, "sql483664", "rW8*aG4!");
            connection = true;
        } catch (Exception e) {
            connection = false;
            System.out.println("Error with connectDatabase()");
            e.printStackTrace();
        }
    }

    /**Method used to clean its own Collection
     * Allows to use 1 Instance of that class per Object
     */
    public void clear(){
        results.clear();
    }
    public boolean commit(String query) {
        try {
            System.out.println("The query: " + query);
            statement = conn.createStatement();
            if (statement.executeUpdate(query) == 0) {
                return false;
            } else {
                System.out.println("Executed insert query: " + query);
                return true;
            }

        } catch (Exception e) {
            System.out.println("ProductRepository: Error with executing the Query!");
            e.printStackTrace();
        }
        return false;
    }

    public boolean getConnection() {
        return connection;
    }

    public ArrayList<Product> search(String pid, String pname) {
        String[] temp = new String[5];
        try {
            String query = "SELECT * FROM `products_info` WHERE p_name LIKE '%" + pname + "%' or p_id LIKE '%" +
                    pid + "%';";
            System.out.println("The query: " + query);
            statement = conn.createStatement();
            result = statement.executeQuery(query);
            int index = 0;
            while (result.next()) {
                results.add(index, new Product());
                results.get(index).setaID(result.getString("p_id"));
                results.get(index).setaName(result.getString("p_name"));
                results.get(index).setaTyp(result.getString("p_type"));
                results.get(index).setCategory(result.getString("p_category"));
                results.get(index).setNetweight(Float.parseFloat(result.getString("p_netweight")));
                results.get(index).setGrossweight(Float.parseFloat(result.getString("p_grossweight")));
                results.get(index).setDimensions(result.getString("p_dimensions"));
                results.get(index).setSmarks(result.getString("smarks_remarks"));
                results.get(index).setHazardinfo(result.getString("smarks_hazardinfo"));
                results.get(index).setMfac_name(result.getString("mfac_name"));
                results.get(index).setAdress(result.getString("mfac_adresse"));
                results.get(index).setCity(result.getString("mfac_city"));
                results.get(index).setCity(result.getString("mfac_city"));
                results.get(index).setCountry(result.getString("mfac_country"));
                results.get(index).setMateriallist(result.getString("resdecl_materiallist"));
                results.get(index).setQuantitieslist(result.getString("resdecl_quantitieslist"));
                results.get(index).setPnperpart(result.getString("resdecl_portionperpartlist"));
                results.get(index).setRenewablelist(result.getString("resdecl_renewablelist"));
                results.get(index).setEnergysource(result.getString("mfac_energysource"));
                results.get(index).setNetenergyconsumed(result.getString("usage_netenergyconsumed"));
                results.get(index).setNetenergyconsumed(result.getString("mfac_netenergyconsumed"));
                results.get(index).setRecommandation(result.getString("recycling_recommendation"));
                index++;
            }
        } catch (Exception e) {
            System.out.println("ProductRepository: Error with executing the Query!");
            e.printStackTrace();
        }
        System.out.println(results);
        return results;
    }

    /**
     * Martin was here. Method there to execute a custom query
     *
     * @param customQuery custom Query
     * @return
     * @throws SQLException
     */
    public ArrayList<Product> executeQuery(String customQuery) throws SQLException {
        ArrayList<Product> results = new ArrayList<Product>();
        String query = customQuery;
        statement = conn.createStatement();
        result = statement.executeQuery(query);
        int index = 0;
        while (result.next()) {
            results.add(index, new Product());
            results.get(index).setaID(result.getString("p_id"));
            results.get(index).setaName(result.getString("p_name"));
            results.get(index).setaTyp(result.getString("p_type"));
            results.get(index).setCategory(result.getString("p_category"));
            results.get(index).setNetweight(Float.parseFloat(result.getString("p_netweight")));
            results.get(index).setGrossweight(Float.parseFloat(result.getString("p_grossweight")));
            results.get(index).setDimensions(result.getString("p_dimensions"));
            results.get(index).setSmarks(result.getString("smarks_remarks"));
            results.get(index).setHazardinfo(result.getString("smarks_hazardinfo"));
            results.get(index).setMfac_name(result.getString("mfac_name"));
            results.get(index).setAdress(result.getString("mfac_adresse"));
            results.get(index).setCity(result.getString("mfac_city"));
            results.get(index).setCity(result.getString("mfac_city"));
            results.get(index).setCountry(result.getString("mfac_country"));
            results.get(index).setMateriallist(result.getString("resdecl_materiallist"));
            results.get(index).setQuantitieslist(result.getString("resdecl_quantitieslist"));
            results.get(index).setPnperpart(result.getString("resdecl_portionperpartlist"));
            results.get(index).setRenewablelist(result.getString("resdecl_renewablelist"));
            results.get(index).setEnergysource(result.getString("mfac_energysource"));
            results.get(index).setNetenergyconsumed(result.getString("usage_netenergyconsumed"));
            results.get(index).setNetenergyconsumed(result.getString("mfac_netenergyconsumed"));
            results.get(index).setRecommandation(result.getString("recycling_recommendation"));
            index++;
        }

        return results;
    }

    /**
     * @return ArrayList of Products that contain all values
     */
    public ArrayList<Product> searchCollection() {
        ArrayList<Product> results = new ArrayList<Product>();
        try {
            String query = "SELECT * FROM products_info;";
            statement = conn.createStatement();
            result = statement.executeQuery(query);
            int index = 0;
            while (result.next()) {
                results.add(index, new Product());
                results.get(index).setaID(result.getString("p_id"));
                results.get(index).setaName(result.getString("p_name"));
                results.get(index).setaTyp(result.getString("p_type"));
                results.get(index).setCategory(result.getString("p_category"));
                results.get(index).setNetweight(Float.parseFloat(result.getString("p_netweight")));
                results.get(index).setGrossweight(Float.parseFloat(result.getString("p_grossweight")));
                results.get(index).setDimensions(result.getString("p_dimensions"));
                results.get(index).setSmarks(result.getString("smarks_remarks"));
                results.get(index).setHazardinfo(result.getString("smarks_hazardinfo"));
                results.get(index).setMfac_name(result.getString("mfac_name"));
                results.get(index).setAdress(result.getString("mfac_adresse"));
                results.get(index).setCity(result.getString("mfac_city"));
                results.get(index).setCity(result.getString("mfac_city"));
                results.get(index).setCountry(result.getString("mfac_country"));
                results.get(index).setMateriallist(result.getString("resdecl_materiallist"));
                results.get(index).setQuantitieslist(result.getString("resdecl_quantitieslist"));
                results.get(index).setPnperpart(result.getString("resdecl_portionperpartlist"));
                results.get(index).setRenewablelist(result.getString("resdecl_renewablelist"));
                results.get(index).setEnergysource(result.getString("mfac_energysource"));
                results.get(index).setNetenergyconsumed(result.getString("usage_netenergyconsumed"));
                results.get(index).setNetenergyconsumed(result.getString("mfac_netenergyconsumed"));
                results.get(index).setRecommandation(result.getString("recycling_recommendation"));
                index++;
            }

        } catch (Exception e) {
            System.out.println("ProductRepository: Error with executing the Query!");
            e.printStackTrace();
        }
        return results;
    }

}
