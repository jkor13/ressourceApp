package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by Martin
 */

public class extendedDataController {

    @FXML
    private Label energysourceLabel;

    @FXML
    private Label categoryLabel;

    @FXML
    private Label manufacCountryLabel;

    @FXML
    private Label ressourcesLabel;

    @FXML
    private Label renewResourcesLabel;

    @FXML
    private Label dimensionsLabel;

    @FXML
    private Label manufacCityLabel;

    @FXML
    private Label disassemblyInstrLabel;

    @FXML
    private Label manufacAdressLabel;

    @FXML
    private Label hazardLabel;

    @FXML
    private Label manufacNameLabel;

    @FXML
    private Label quantitiesPerParttLabel;

    @FXML
    private Label netenergyconsumedLabel;

    @FXML
    private Label quantitiesLabel;

    @FXML
    private Label recommandationLabel;

    @FXML
    private Label netweightLabel;

    @FXML
    private Label brandnameLabel;

    @FXML
    private Label pidLabel;

    @FXML
    private Label netenergyUsedLabel;

    @FXML
    private Label grossweightLabel;

    @FXML
    private Label securityremarksLabel;

    @FXML
    private Label pTypeLabel;

    private static Product product;

    static void setProduct(Product p){
        product = p;
    }
    private void setItems(){
        energysourceLabel.setText(product.getEnergysource());
        pTypeLabel.setText(product.getaTyp());
        securityremarksLabel.setText(product.getSmarks());
        grossweightLabel.setText(String.valueOf(product.getGrossweight()));
        netenergyconsumedLabel.setText(product.getNetenergyconsumed());
        netenergyUsedLabel.setText(product.getNetenergyused());
        pidLabel.setText(product.getaID());
        brandnameLabel.setText(product.getaName());
        netweightLabel.setText(String.valueOf(product.getNetweight()));
        recommandationLabel.setText(product.getRecommandation());
        categoryLabel.setText(product.getCategory());
        hazardLabel.setText(product.getHazardinfo());
        quantitiesLabel.setText(product.getQuantitieslist());
        quantitiesPerParttLabel.setText(product.getPnperpart());
        manufacNameLabel.setText(product.getMfac_name());
        manufacCountryLabel.setText(product.getMfac_adress());
        manufacAdressLabel.setText(product.getMfac_adress());
        dimensionsLabel.setText(product.getDimensions());
        manufacCityLabel.setText(product.getMfac_adress());
        disassemblyInstrLabel.setText("N/A");
        ressourcesLabel.setText(product.getMateriallist());
        renewResourcesLabel.setText(product.getRenewablelist());

    }

    @FXML
    private void initialize(){
        setItems();
    }
}
