package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by rico on 22.07.15.
 */
public class Update {

    ProductRepository repo = new ProductRepository();
    private ObservableList<Product> data = FXCollections.observableArrayList();

    @FXML
    private TableView<Product> tableView;
    @FXML
    private TableColumn<Product, String> category;
    @FXML
    private TableColumn<GUI.Product, String> brandname;
    @FXML
    private TableColumn<GUI.Product, String> netweight;
    @FXML
    private TableColumn<GUI.Product, String> grossweight;
    @FXML
    private TableColumn<GUI.Product, String> dimensions;
    @FXML
    private TableColumn<GUI.Product, String> smarks;
    @FXML
    private TableColumn<GUI.Product, String> hazardinfo;
    @FXML
    private TableColumn<GUI.Product, String> name;
    @FXML
    private TableColumn<GUI.Product, String> adress;
    @FXML
    private TableColumn<GUI.Product, String> city;
    @FXML
    private TableColumn<GUI.Product, String> country;
    @FXML
    private TableColumn<GUI.Product, String> materiallist;
    @FXML
    private TableColumn<GUI.Product, String> quantitieslist;
    @FXML
    private TableColumn<GUI.Product, String> pnperpart;
    @FXML
    private TableColumn<GUI.Product, String> renewablelist;
    @FXML
    private TableColumn<GUI.Product, String> energysource;
    @FXML
    private TableColumn<GUI.Product, String> netenergyused;
    @FXML
    private TableColumn<GUI.Product, String> netenergyconsumed;
    @FXML
    private TableColumn<GUI.Product, String> recommandation;



    @FXML
    private void initialize() {
        /**
         * SETTING UP THE CELLS FOR THE TABLE. WORKS EXCEPT FOR A FEW ATTRIBUTES LIKE BRANDNAME
         */
        category.setCellValueFactory(new PropertyValueFactory("category"));
        brandname.setCellValueFactory(new PropertyValueFactory("name"));
        netweight.setCellValueFactory(new PropertyValueFactory("netweight"));
        grossweight.setCellValueFactory(new PropertyValueFactory("grossweight"));
        dimensions.setCellValueFactory(new PropertyValueFactory("dimensions"));
        smarks.setCellValueFactory(new PropertyValueFactory("smarks"));
        hazardinfo.setCellValueFactory(new PropertyValueFactory("hazardinfo"));
        name.setCellValueFactory(new PropertyValueFactory("name"));
        adress.setCellValueFactory(new PropertyValueFactory("adress"));
        city.setCellValueFactory(new PropertyValueFactory("city"));
        country.setCellValueFactory(new PropertyValueFactory("country"));
        materiallist.setCellValueFactory(new PropertyValueFactory("materiallist"));
        quantitieslist.setCellValueFactory(new PropertyValueFactory("quantitieslist"));
        pnperpart.setCellValueFactory(new PropertyValueFactory("pnperpart"));
        renewablelist.setCellValueFactory(new PropertyValueFactory("renewablelist"));
        energysource.setCellValueFactory(new PropertyValueFactory("energysource"));
        netenergyused.setCellValueFactory(new PropertyValueFactory("netenergyused"));
        netenergyconsumed.setCellValueFactory(new PropertyValueFactory("netenergyconsumed"));
        recommandation.setCellValueFactory(new PropertyValueFactory("recommandation"));

        ArrayList<Product> productCollection = repo.searchCollection();

        // THIS CONVERTS THE COLLECTION INTO AN OBSERVABLE COLLECTION
        data.addAll(productCollection.stream().collect(Collectors.toList()));

        tableView.setItems(data);

    }


}
