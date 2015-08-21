package GUI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.Arrays;

public class Main extends Application {
    private ProductRepository repo;
    private Stage window;
    private ArrayList<Product> productSet;

    private String advancedSearchQuery;
    @FXML
    private Label pid;
    @FXML
    private Label pname;
    @FXML
    private Label pcategory;
    @FXML
    private Label ptype;
    @FXML
    private Label manufac;
    @FXML
    private TextField idField;
    @FXML
    private TextField productnameField;
    @FXML
    private Label statusLabel;

    // Variables for advanced search
    @FXML
    private TextField prod_cat_adv_search;
    @FXML
    private TextField prod_type_adv_search;
    @FXML
    private TextField manufacturer_adv_search;
    @FXML
    private TextField containing_res_adv_search;

    private double mouseX;
    private double mouseY;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View/mother.fxml"));

        window = primaryStage;
        window.setTitle("Product Database");
        window.initStyle(StageStyle.UNDECORATED);
        Scene primeScene = new Scene(root);
        primeScene.setFill(Color.TRANSPARENT);
        window.setScene(primeScene);
        window.setResizable(false);
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // record a delta distance for the drag and drop operation.
                mouseX = window.getX() - mouseEvent.getScreenX();
                mouseY = window.getY() - mouseEvent.getScreenY();
            }
        });

        /**
         * This method allows the user to drag the Window around as much as he wishes via mouseclick
         */
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                window.setX(mouseEvent.getScreenX() + mouseX);
                window.setY(mouseEvent.getScreenY() + mouseY);
            }
        });
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
        //new Main().connectDatabase();
    }

    @FXML
    private void openAdvancedSearch() {
        try {
            replaceSceneContext();
        } catch (Exception e) {
            System.out.println("Cannot change stage");
            e.printStackTrace();
        }
    }

    @FXML
    protected void replaceSceneContext() throws Exception {
        Stage window = new Stage();
        Parent root = FXMLLoader.load(Main.class.getResource("View/advancedSearch.fxml"));
        window.setScene(new Scene(root));
        window.show();
    }

    @FXML
    private void openInsertData() throws Exception {
        repo = new ProductRepository();
        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("View/insertData.fxml"));
        insertDataController controller = loader.getController();
        if (controller == null)
            System.out.println("Cant  load controller");
        controller.setRepo(repo);
        Parent root = (AnchorPane) loader.load();
        window.setTitle("New Data");
        window.setScene(new Scene(root));
        window.show();

    }

    @FXML
    private void openList() throws Exception {
        repo = new ProductRepository();
        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("View/table.fxml"));
        Parent root = loader.load();
        window.setTitle("Datenbank Übersicht");
        window.setScene(new Scene(root));
        window.initStyle(StageStyle.UNDECORATED);
        window.show();
    }

    /**
     * Rico hat gespielt :-)
     * @throws Exception
     */
    @FXML
    private void openAdvancedSearchResults() throws Exception {
        repo = new ProductRepository();
        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader();

        buildAdvancedSearchQuery();
        System.out.println("Query:" + advancedSearchQuery);
        ArrayList<Product> result = repo.executeQuery(advancedSearchQuery);

       //TODO: Übergeben (ArrayList) this.productCollection;
        // MARTIN WAR HIER, PROBLEM GELÖST?
        AdvSearch.setResults(result);
        loader.setLocation(Main.class.getResource("View/advsearch.fxml"));
        insertDataController controller = loader.getController();

        if (controller == null)
            System.out.println("Cant  load controller");
        controller.setRepo(repo);
        Parent root = (AnchorPane) loader.load();
        window.setTitle("AdvSearch");
        window.setScene(new Scene(root));
        window.show();
    }

    @FXML
    private void openUpdate() throws Exception {
        repo = new ProductRepository();
        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("View/update.fxml"));
        insertDataController controller = loader.getController();
        if (controller == null)
            System.out.println("Cant  load controller");
        controller.setRepo(repo);
        Parent root = (AnchorPane) loader.load();
        window.setTitle("Datenbank Bearbeiten");
        window.setScene(new Scene(root));
        window.show();
    }


    @FXML
    private void search() {
        //connect to DB
        // --- Extract the Values from the Textfield to build the Query
        ProductRepository newRepo = new ProductRepository();
        if (newRepo.getConnection() == true)
            statusLabel.setText("Executed Query");
        else
            statusLabel.setText("Couldn't Execut Query");
        String pid = idField.getText();
        String productname = productnameField.getText();
        String[] results = newRepo.search(pid, productname);
        this.pid.setText(results[0]);
        this.pname.setText(results[1]);
        this.pcategory.setText(results[2]);
        this.ptype.setText(results[3]);
        this.manufac.setText(results[4]);
    }

    @FXML
    private void reset() {
        idField.setText("");
        productnameField.setText("");
    }

    @FXML
    private void close() {
        try {
            System.out.println("Click");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void closeWindow() {
        Platform.exit();
    }

    /**
     * Martin - Changed some code
     * added buildAdvancedSearchQuery() function
     */
    @FXML
    private void advSearch() {
        try {
            repo = new ProductRepository();
            buildAdvancedSearchQuery();
            System.out.println("Query:" + advancedSearchQuery);
            ArrayList<Product> result = repo.executeQuery(advancedSearchQuery);
            AdvSearch.setResults(result);
        } catch (Exception e) {
            System.out.println("Error with getting advanced search results");
            e.printStackTrace();
        }
    }

    /**
     * Method used to check whether Fields are empty and not and thus
     * builds the query
     */
    private void buildAdvancedSearchQuery() {
        advancedSearchQuery = "SELECT * FROM `products_info` ";
        if (!prod_cat_adv_search.getText().isEmpty())
            advancedSearchQuery += "where p_category like '" + prod_cat_adv_search.getText() + "' ";
        if (!prod_type_adv_search.getText().isEmpty())
            advancedSearchQuery += "and p_type like '%%" + prod_cat_adv_search.getText() + "' ";
        if (!manufacturer_adv_search.getText().isEmpty())
            advancedSearchQuery += "and mfac_name LIKE '%%" + manufacturer_adv_search.getText() + "' ";
        if (!containing_res_adv_search.getText().isEmpty())
            advancedSearchQuery += "and resdecl_materiallist like '" + containing_res_adv_search.getText() + "'";
    }

    @FXML
    private void resetAdvSearch() {
        prod_cat_adv_search.setText("");
        prod_type_adv_search.setText("");
        manufacturer_adv_search.setText("");
        containing_res_adv_search.setText("");
    }
}

