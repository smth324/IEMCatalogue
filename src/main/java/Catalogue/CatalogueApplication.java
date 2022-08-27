package Catalogue;

import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import javafx.scene.control.ButtonType;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import javafx.scene.control.Alert;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.control.TableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class CatalogueApplication extends Application {

    @Override
    public void start(Stage window) {
        ObservableList<IEM> list = FXCollections.observableArrayList();
        try {
            Files.lines(Paths.get("Data.txt")).forEach(row -> {
                String[] parts = row.split("%20");
                IEM temp = new IEM(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8], Double.valueOf(parts[9]), parts[10].replace("%50", "\n").replace("%60", "\r"));
                list.add(temp);
            });
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error file not found");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));
        grid.setPrefSize(1200, 600);
        Label labelName = new Label("Name:");
        TextField name = new TextField();
        grid.add(labelName, 3, 1);
        grid.add(name, 4, 1);
        Label labelBass = new Label("Bass:");
        TextField bass = new TextField();
        grid.add(labelBass, 3, 2);
        grid.add(bass, 4, 2);
        Label labelMids = new Label("Mids:");
        TextField mids = new TextField();
        grid.add(labelMids, 3, 3);
        grid.add(mids, 4, 3);
        Label labelTreble = new Label("Treble:");
        TextField treble = new TextField();
        grid.add(labelTreble, 3, 4);
        grid.add(treble, 4, 4);
        Label labelCategory = new Label("Category:");
        TextField category = new TextField();
        grid.add(labelCategory, 5, 1);
        grid.add(category, 6, 1);
        Label labelBuild = new Label("Build:");
        TextField build = new TextField();
        grid.add(labelBuild, 5, 2);
        grid.add(build, 6, 2);
        Label labelInclusions = new Label("Inclusions:");
        TextField inclusions = new TextField();
        grid.add(labelInclusions, 5, 3);
        grid.add(inclusions, 6, 3);
        Label labelTechnicalities = new Label("Technicalities:");
        TextField technicalities = new TextField();
        grid.add(labelTechnicalities, 5, 4);
        grid.add(technicalities, 6, 4);
        Label labelOverAll = new Label("Overall:");
        TextField overall = new TextField();
        grid.add(labelOverAll, 7, 1);
        grid.add(overall, 8, 1);
        Label labelPrice = new Label("Price:");
        TextField price = new TextField();
        grid.add(labelPrice, 7, 2);
        grid.add(price, 8, 2);
        Label labelReview = new Label("Review:");
        TextArea review = new TextArea();
        review.setWrapText(true);
        grid.add(labelReview, 3, 5);
        grid.add(review, 4, 5, 5, 1);
        Button add = new Button("Done");
        grid.add(add, 4, 6);
        Button back = new Button("Go Back");
        grid.add(back, 0, 0);
        Scene scene2 = new Scene((Parent) grid);
        BorderPane pane = new BorderPane();
        pane.setPrefSize(1170, 600);
        pane.setPadding(new Insets(10, 10, 10, 10));
        FlowPane searchBar = new FlowPane();
        Label words = new Label("Search: ");
        TextField searchField = new TextField();
        searchField.setPrefWidth(995);
        Button addNew = new Button("Add Devices");
        addNew.setOnAction(event -> window.setScene(scene2));
        searchBar.getChildren().addAll(words, searchField, addNew);
        pane.setTop(searchBar);
        double size = 91;
        TableView<IEM> table = new TableView();
        TableColumn<IEM, String> column1 = (TableColumn<IEM, String>) new TableColumn("Name");
        column1.setCellValueFactory(new PropertyValueFactory("name"));
        column1.setPrefWidth(150);
        column1.setResizable(false);
        TableColumn<IEM, String> column2 = (TableColumn<IEM, String>) new TableColumn("Bass");
        column2.setCellValueFactory(new PropertyValueFactory("bass"));
        column2.setPrefWidth(size);
        column2.setResizable(false);
        TableColumn<IEM, String> column3 = (TableColumn<IEM, String>) new TableColumn("Mids");
        column3.setCellValueFactory(new PropertyValueFactory("mids"));
        column3.setPrefWidth(size);
        column3.setResizable(false);
        TableColumn<IEM, String> column4 = (TableColumn<IEM, String>) new TableColumn("Treble");
        column4.setCellValueFactory(new PropertyValueFactory("treble"));
        column4.setPrefWidth(size);
        column4.setResizable(false);
        TableColumn<IEM, String> column5 = (TableColumn<IEM, String>) new TableColumn("Category");
        column5.setCellValueFactory(new PropertyValueFactory("category"));
        column5.setPrefWidth(size);
        column5.setResizable(false);
        TableColumn<IEM, String> column6 = (TableColumn<IEM, String>) new TableColumn("Build");
        column6.setCellValueFactory(new PropertyValueFactory("build"));
        column6.setPrefWidth(size);
        column6.setResizable(false);
        TableColumn<IEM, String> column7 = (TableColumn<IEM, String>) new TableColumn("Inclusions");
        column7.setCellValueFactory(new PropertyValueFactory("inclusions"));
        column7.setPrefWidth(size);
        column7.setResizable(false);
        TableColumn<IEM, String> column8 = (TableColumn<IEM, String>) new TableColumn("Technicalities");
        column8.setCellValueFactory(new PropertyValueFactory("technicalities"));
        column8.setPrefWidth(size);
        column8.setResizable(false);
        TableColumn<IEM, String> column9 = (TableColumn<IEM, String>) new TableColumn("Overall");
        column9.setCellValueFactory(new PropertyValueFactory("overall"));
        column9.setPrefWidth(size);
        column9.setResizable(false);
        TableColumn<IEM, Double> column10 = (TableColumn<IEM, Double>) new TableColumn("Price");
        column10.setCellValueFactory(new PropertyValueFactory("price"));
        column10.setPrefWidth(size);
        column10.setResizable(false);
        TableColumn delete = new TableColumn("Actions");
        delete.setCellFactory(col -> new TableCell<IEM, Button>() {
            {
                Button clearBtn = new Button("Delete");
                clearBtn.setOnAction(event -> {
                    IEM toDelete = getTableView().getItems().get(getIndex());
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Delete?");
                    alert.setHeaderText("You are about to delete IEM");
                    alert.setContentText("Do you want to continue");
                    Optional<ButtonType> option = alert.showAndWait();
                    if (option.get() == ButtonType.OK) {
                        list.remove(toDelete);
                        try {
                            PrintWriter clearer = new PrintWriter("Data.txt");
                            clearer.write("");
                            clearer.close();
                            PrintWriter printer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("Data.txt", true), StandardCharsets.UTF_8));
                            list.forEach(item -> {
                                printer.println(
                                        item.getName() + "%20" + item.getBass() + "%20" + item.getMids() + "%20" + item.getTreble() + "%20" + item.getBuild()
                                        + "%20" + item.getCategory() + "%20" + item.getInclusions() + "%20" + item.getTechnicalities() + "%20" + item.getOverall()
                                                + "%20" + String.valueOf(item.getPrice()) + "%20" + item.getReview().replace("\n", "%50").replace("\r", "%60")
                                );
                            });
                            printer.close();
                        } catch (FileNotFoundException e) {
                            Alert alert2 = new Alert(Alert.AlertType.ERROR);
                            alert2.setTitle("Error file not found");
                            alert2.setHeaderText(e.getMessage());
                            alert2.show();
                        }
                    }
                });
                Button moreBtn = new Button("More");
                moreBtn.setOnAction(event -> {
                    Stage infoPage = new Stage();
                    BorderPane info = new BorderPane();
                    info.setPadding(new Insets(10, 10, 10, 10));
                    info.setPrefSize(600, 900);
                    VBox container = new VBox();
                    container.setPrefHeight(800.0);
                    info.setTop(new Label(getTableView().getItems().get(getIndex()).getName()));
                    Text bassInfo = new Text("Bass: " + getTableView().getItems().get(getIndex()).getBass());
                    Text midsInfo = new Text("Mids: " + getTableView().getItems().get(getIndex()).getMids());
                    Text trebleInfo = new Text("Treble: " + getTableView().getItems().get(getIndex()).getTreble());
                    Text buildInfo = new Text("Build: " + getTableView().getItems().get(getIndex()).getBuild());
                    Text categoryInfo = new Text("Category: " + getTableView().getItems().get(getIndex()).getCategory());
                    Text inclusionsInfo = new Text("Inclusions: " + getTableView().getItems().get(getIndex()).getInclusions());
                    Text technicalitiesInfo = new Text("Technicalities: " + getTableView().getItems().get(getIndex()).getTechnicalities());
                    Text overallInfo = new Text("Overall: " + getTableView().getItems().get(getIndex()).getOverall());
                    Text priceInfo = new Text("Price: " + String.valueOf(getTableView().getItems().get(getIndex()).getPrice()));
                    TextArea reviewInfo = new TextArea("Review: " + getTableView().getItems().get(getIndex()).getReview().replace("%50", "\n").replace("%60", "/r"));
                    reviewInfo.setEditable(false);
                    reviewInfo.setWrapText(true);
                    reviewInfo.setPrefHeight(700.0);
                    container.getChildren().addAll(bassInfo, midsInfo, trebleInfo, buildInfo, categoryInfo, inclusionsInfo, technicalitiesInfo, overallInfo, priceInfo, reviewInfo);
                    info.setCenter(container);
                    infoPage.setTitle(getTableView().getItems().get(getIndex()).getName());
                    Scene infoScene = new Scene(info);
                    infoPage.setScene(infoScene);
                    infoPage.show();
                });
                Button editBtn = new Button("Edit");
                editBtn.setOnAction(event -> {
                    window.setScene(scene2);
                    name.setText(getTableView().getItems().get(getIndex()).getName());
                    bass.setText(getTableView().getItems().get(getIndex()).getBass());
                    mids.setText(getTableView().getItems().get(getIndex()).getMids());
                    treble.setText(getTableView().getItems().get(getIndex()).getTreble());
                    review.setText(getTableView().getItems().get(getIndex()).getReview());
                    build.setText(getTableView().getItems().get(getIndex()).getBuild());
                    category.setText(getTableView().getItems().get(getIndex()).getCategory());
                    technicalities.setText(getTableView().getItems().get(getIndex()).getTechnicalities());
                    inclusions.setText(getTableView().getItems().get(getIndex()).getInclusions());
                    overall.setText(getTableView().getItems().get(getIndex()).getOverall());
                    price.setText(String.valueOf((getTableView().getItems().get(getIndex())).getPrice()));
                });
                HBox box = new HBox();
                box.getChildren().addAll(clearBtn, moreBtn, editBtn);
                setGraphic(box);
            }
        });
        delete.setResizable(false);
        delete.prefWidthProperty().bind(table.widthProperty().subtract(column1.widthProperty()).subtract(column2.widthProperty()).subtract(column3.widthProperty()).subtract(column4.widthProperty()).subtract(column5.widthProperty()).subtract(column6.widthProperty()).subtract(column7.widthProperty()).subtract(column8.widthProperty()).subtract(column9.widthProperty()).subtract(column10.widthProperty()).subtract(2));
        table.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9, column10, delete);
        table.setItems(list);
        pane.setCenter(table);
        Scene scene3 = new Scene(pane);
        back.setOnAction(event -> {
            window.setScene(scene3);
            name.clear();
            bass.clear();
            mids.clear();
            treble.clear();
            price.clear();
            overall.clear();
            inclusions.clear();
            technicalities.clear();
            category.clear();
            build.clear();
            review.clear();
        });
        add.setOnAction(event -> {
            if (name.getText().equals("") || bass.getText().equals("") || mids.getText().equals("") || treble.getText().equals("") || review.getText().equals("") || category.getText().equals("") || overall.getText().equals("") || String.valueOf(price.getText()).equals("") || technicalities.getText().equals("") || inclusions.getText().equals("") || build.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Incomplete Information");
                alert.setHeaderText("Please fill out the necessary information");
                alert.show();
            }
            try {
                Double.parseDouble(price.getText());
            } catch (NumberFormatException e) {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("Invalid Input");
                alert2.setHeaderText("Price must be number");
                alert2.show();
            }
            IEM adding = new IEM(name.getText(), bass.getText().toUpperCase(), mids.getText().toUpperCase(), treble.getText().toUpperCase(), build.getText().toUpperCase(), category.getText().toUpperCase(), inclusions.getText().toUpperCase(), technicalities.getText().toUpperCase(), overall.getText().toUpperCase(), (double) Double.valueOf(price.getText()), review.getText().replace("%50", "\n").replace("%60", "\r"));
            for (IEM x : list) {
                if (x.getName().toUpperCase().equals(name.getText().toUpperCase())) {
                    Alert alert3 = new Alert(Alert.AlertType.CONFIRMATION);
                    alert3.setTitle("Duplicate");
                    alert3.setHeaderText("IEM already exists");
                    alert3.setContentText("Do you want to replace the existing IEM?");
                    Optional<ButtonType> option = alert3.showAndWait();
                    if (option.get() == ButtonType.CANCEL) {
                        return;
                    }
                    if (option.get() == ButtonType.OK) {
                        list.remove(x);
                        try {
                            PrintWriter clearer = new PrintWriter("Data.txt");
                            clearer.write("");
                            clearer.close();
                            PrintWriter printer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("Data.txt", true), StandardCharsets.UTF_8));
                            list.forEach(item
                                    -> printer.println(
                                            item.getName()
                                            + "%20" + item.getBass().toUpperCase() + "%20" + item.getMids().toUpperCase() + "%20" + item.getTreble().toUpperCase() + "%20" + item.getBuild().toUpperCase()
                                            + "%20" + item.getCategory().toUpperCase() + "%20" + item.getInclusions().toUpperCase() + "%20" + item.getTechnicalities().toUpperCase()
                                            + "%20" + item.getOverall().toUpperCase() + "%20" + String.valueOf(item.getPrice()) + "%20" + item.getReview().replace("\n", "%50").replace("\r", "%60")
                                    ));
                            printer.println(
                                    name.getText().toUpperCase()
                                    + "%20" + bass.getText().toUpperCase() + "%20" + mids.getText().toUpperCase() + "%20" + treble.getText().toUpperCase() + "%20" + build.getText().toUpperCase()
                                    + "%20" + category.getText().toUpperCase() + "%20" + inclusions.getText().toUpperCase() + "%20" + technicalities.getText().toUpperCase() + "%20" + overall.getText().toUpperCase()
                                    + "%20" + String.valueOf(price.getText()) + "%20" + review.getText().replace("\n", "%50").replace("\r", "%60")
                            );
                            printer.close();
                        } catch (FileNotFoundException e) {
                            Alert alert4 = new Alert(Alert.AlertType.ERROR);
                            alert4.setTitle("Error file not found");
                            alert4.setHeaderText(e.getMessage());
                            alert4.show();
                        }
                        name.clear();
                        bass.clear();
                        mids.clear();
                        treble.clear();
                        review.clear();
                        build.clear();
                        inclusions.clear();
                        category.clear();
                        technicalities.clear();
                        list.add(adding);
                        table.setItems(list);
                        return;
                    }
                }
            }
            try {
                PrintWriter saver = new PrintWriter(new OutputStreamWriter(new FileOutputStream("Data.txt", true), StandardCharsets.UTF_8));
                saver.println(
                        name.getText()
                        + "%20" + bass.getText().toUpperCase() + "%20" + mids.getText().toUpperCase() + "%20" + treble.getText().toUpperCase() + "%20" + build.getText().toUpperCase()
                        + "%20" + category.getText().toUpperCase() + "%20" + inclusions.getText().toUpperCase() + "%20" + technicalities.getText().toUpperCase() + "%20" + overall.getText().toUpperCase()
                        + "%20" + String.valueOf(price.getText()) + "%20" + review.getText().replace("\n", "%50").replace("\r", "%60")
                );
                saver.close();
            } catch (FileNotFoundException e2) {
                System.out.println(e2.getMessage());
                Alert alert5 = new Alert(Alert.AlertType.WARNING);
                alert5.setTitle("");
                alert5.setHeaderText("Please fill out the necessary information");
                alert5.show();
            }
            name.clear();
            bass.clear();
            mids.clear();
            treble.clear();
            review.clear();
            build.clear();
            inclusions.clear();
            category.clear();
            technicalities.clear();
            overall.clear();
            price.clear();
            list.add(adding);
            table.setItems(list);
        });
        searchField.textProperty().addListener((observed, oldValue, newValue) -> table.setItems(FXCollections.observableList(list.stream().filter(n -> n.getName().toLowerCase().contains(searchField.getText().toLowerCase())).toList())));
        window.setTitle("IEM Catalogue");
        window.setScene(scene3);
        window.show();
        window.setResizable(false);
    }

    public static void main(String[] args) {
        launch(CatalogueApplication.class
        );
    }
}
