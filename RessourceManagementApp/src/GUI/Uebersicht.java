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
 * Created by rico on 21.07.15.
 * EDITED BY MARTIN
 * Changed Dependencies, Logic
 */


public class Uebersicht {

    ProductRepository repo;
    private ArrayList<Product> p;

    private ObservableList<Product> data;


    @FXML
    private TableView<Product> table;
    @FXML
    private TableColumn<Product, String> ID;

    @FXML
    private TableColumn<Product, String> NAME;

    @FXML
    private TableColumn<Product, String> TYP;


    @FXML
    private void initialize() {
        repo = new ProductRepository();
        data  = FXCollections.observableArrayList();
        data.clear();
        p = repo.searchCollection();
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        NAME.setCellValueFactory(new PropertyValueFactory<>("name"));
        TYP.setCellValueFactory(new PropertyValueFactory<>("category"));
        setTableView();
        System.out.println("after setTableView()");
    }

    /**
     * Method used to populate observable Arraylist
     * and set the Table View
     * TODO: ID,TYP and NAME WONT BE SHOWN FOR SOME REASON. OTHER ATTRIBUTES WORK
     */
    private void setTableView(){
        // THIS CONVERTS THE COLLECTION INTO AN OBSERVABLE COLLECTION
        data.addAll(p.stream().collect(Collectors.toList()));
        // DEBUG PURPOSE. CORRECT VALUES ARE BEING READ AND DISPLAYED ON CONSOLE
        for(Product p : data) {
            System.out.println("Added: " + p.getaID() + " " + p.getaTyp() + " " + p.getaName());
        }

        table.setItems(data);



    }



}

