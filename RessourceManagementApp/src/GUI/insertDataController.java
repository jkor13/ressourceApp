package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Created by Martin on 06.07.2015.
 */
    public class insertDataController {

    @FXML
    private TextField brandnameField;

    @FXML
    private TextField hazardinfoField;

    @FXML
    private TextField renewablelistField;

    @FXML
    private TextField portbnperpartField;

    @FXML
    private TextField manufacnameField;

    @FXML
    private TextField grossweightField;

    @FXML
    private TextField manufaccityField;

    @FXML
    private TextField pidField;

    @FXML
    private TextField netenergyconsumedField;

    @FXML
    private TextField disasinstructionsField;

    @FXML
    private TextField categoryField;

    @FXML
    private TextField recommandationField;

    @FXML
    private TextField netweightField;

    @FXML
    private TextField energysourceField;

    @FXML
    private TextField pTypeField;

    @FXML
    private TextField manufacadressField;

    @FXML
    private TextField materiallistField;

    @FXML
    private TextField dimensionsField;

    @FXML
    private TextField quantitieslistField;

    @FXML
    private TextField netenergyusedField;

    @FXML
    private TextField smarksField;

    @FXML
    private TextField manufacccountryField;
    static ProductRepository repo;


    @FXML
    private void save() {
        String query = "INSERT INTO `products_info`(`p_id`, `p_name`, `p_category`, `p_type`, `p_netweight`, `p_grossweight`, `p_dimensions`, `smarks_remarks`, `smarks_hazardinfo`, `mfac_name`, `mfac_adresse`, `mfac_city`, `mfac_country`, `resdecl_materiallist`, `resdecl_quantitieslist`, `resdecl_portionperpartlist`, `resdecl_renewablelist`, `mfac_energysource`, `mfac_netenergyconsumed`, `recycling_recommendation`, `usage_netenergyconsumed`, `disassemblyinstructions` ) VALUES (";
        query+= ("'" + pidField.getText()+"'," +
             "'" + categoryField.getText()+"'," +
             "'"+ brandnameField.getText()+"'," +
             "'"+ pTypeField.getText()+"',"+
                "'"+Float.parseFloat(netweightField.getText()) +"',"+
                "'"+Float.parseFloat(grossweightField.getText())+"',"+
                "'"+ dimensionsField.getText()+"',"+
                "'"+ smarksField.getText()+"',"+
                "'"+ hazardinfoField.getText()+"',"+
                "'"+ manufacnameField.getText()+"',"+
                "'"+ manufacadressField.getText()+"',"+
                "'"+ manufaccityField.getText()+"',"+
                "'"+ manufacccountryField.getText()+"',"+
                "'"+ materiallistField.getText()+"',"+
                "'"+ quantitieslistField.getText()+"',"+
                "'"+ portbnperpartField.getText()+"',"+
                "'"+ renewablelistField.getText()+"',"+
                "'"+ energysourceField.getText()+"',"+
                "'"+ netenergyconsumedField.getText()+"',"+
                "'"+ netenergyusedField.getText()+"',"+
                "'"+ recommandationField.getText()+"',"+
                "'"+ disasinstructionsField.getText()+"');");
        if(repo.commit(query))
            System.out.println("Correctly inserted this query: " + query);
        else
            System.out.println("Failed doing the query: " + query);

        System.out.println("Clicked save Button!");
    }

    @FXML
    private  void reset(){
        System.out.println("Clicked reset Button");
    }

    static void setRepo(ProductRepository repos){
        repo = repos;
    }
}
