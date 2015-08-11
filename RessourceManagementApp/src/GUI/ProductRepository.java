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
    static final String host = "jdbc:mysql://sql4.freesqldatabase.com:3306/sql483664";
    Product p;


    public ProductRepository(){
        connectDatabase();
    }
    private void connectDatabase(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(host, "sql483664", "rW8*aG4!");
            connection = true;
        } catch(Exception e){
            connection = false;
            System.out.println("Error with connectDatabase()");
            e.printStackTrace();
        }
    }

    public boolean commit(String query){
        try {
            System.out.println("The query: "  + query);
            statement = conn.createStatement();
            if(statement.executeUpdate(query) == 0) {
                return false;
            }
             else {
                System.out.println("Executed insert query: " + query);
                return true;
            }

        } catch (Exception e) {
            System.out.println("ProductRepository: Error with executing the Query!");
            e.printStackTrace();
        }
        return false;
    }

    public boolean getConnection(){
        return connection;
    }
    public String[] search(String pid, String pname){

        String[] results = new String[5];
        String[] temp = new String[5];
        try {
            String query = "SELECT * FROM `products_info` WHERE p_name LIKE '%" + pname + "%' or p_id LIKE '%" +
                    pid +"%';";
            System.out.println("The query: "  + query);
            statement = conn.createStatement();
            result = statement.executeQuery(query);
            while(result.next()){
                //Retrieve by column name
                temp[0] = result.getString("p_id");
                temp[1] = result.getString("p_name");
                temp[2] = result.getString("p_category");
                temp[3] = result.getString("p_type");
                temp[4] = result.getString("mfac_name");
                results = temp;
            }
        } catch (Exception e) {
            System.out.println("ProductRepository: Error with executing the Query!");
            e.printStackTrace();
        }
        System.out.println(results);
        return results;
    }
    public ArrayList<String> search(String prodCat, String prodTyp, String manufacturer, String containingResources ) {
        ArrayList<String> temp = new ArrayList<>();
        ArrayList<String> results = new ArrayList<>();
        try {
            if (prodCat != "" || prodTyp != "" || manufacturer != "" || containingResources != "") {
                String query = "SELECT * FROM `products_info` WHERE p_category LIKE '%" + prodCat + "%' " +
                        "or p_type LIKE '%" + prodTyp + "%' or mfac_name LIKE '%" + manufacturer + "%'" +
                        "or resdecl_materiallist LIKE '%" + containingResources + "%';";
                System.out.println("The query: " + query);
                statement = conn.createStatement();
                result = statement.executeQuery(query);
                while (result.next()) {
                    temp.set(0, result.getString("p_id"));
                    temp.set(1, result.getString("p_name"));
                    temp.set(2, result.getString("p_category"));
                    temp.set(3, result.getString("p_type"));
                    temp.set(4, result.getString("p_netweight"));
                    temp.set(5, result.getString("p_grossweight"));
                    temp.set(6, result.getString("p_dimensions"));
                    temp.set(7, result.getString("p_smarks_remarks"));
                    temp.set(8, result.getString("p_smarks_hazardinfo"));
                    temp.set(9, result.getString("mfac_name"));
                    temp.set(10, result.getString("mfac_adresse"));
                    temp.set(11, result.getString("mfac_city"));
                    temp.set(12, result.getString("mfac_country"));
                    temp.set(13, result.getString("resdecl_materiallist"));
                    temp.set(14, result.getString("resdecl_quantitieslist"));
                    temp.set(15, result.getString("resdecl_portionsperpartlist"));
                    temp.set(16, result.getString("resdecl_renewablelist"));
                    temp.set(17, result.getString("mfac_energysource"));
                    temp.set(18, result.getString("mfac_netenergyconsumed"));
                    temp.set(19, result.getString("recycling_recommendation"));
                    temp.set(20, result.getString("usage_netenergyconsumed"));
                    temp.set(21, result.getString("disassemblyinstructions"));
                    results = temp;
                }
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }return results;
    }

        /**
     *
     * @return ArrayList of Products that contain all values
     */
    public ArrayList<Product> searchCollection(){
        ArrayList<Product> results = new ArrayList<Product>();
        try {
            String query = "SELECT * FROM products_info;";
            statement = conn.createStatement();
            result = statement.executeQuery(query);
            int index = 0;
            while(result.next()){
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
