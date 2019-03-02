package userInterface;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import type.*;

public class EntryController {
	
	@FXML private MenuButton Type_define;
	@FXML private MenuItem electric;
	@FXML private MenuItem water;
	
	@FXML private TableView<Type> Entry_table;
	@FXML private TableColumn<Type, String> Date_Col;
	@FXML private TableColumn<Type, Double> Amount_Col;
	@FXML private TableColumn<Type, String> Type_Col;
	
	@FXML private Button addItem_btn;
	
	@FXML
	public void initialize(){
		ObservableList<Type> list = FXCollections.observableArrayList();
		list.add( new Type("01/03/2018", 123.44, "Electric"));
		list.add( new Type("01/03/2018", 323.44, "Rent"));
		Entry_table.setItems(list);


    }
	
	public void enterEntry(ActionEvent action) {
		
	}
	
	public void addElectricType(ActionEvent action) {
		Type_define.setText(electric.getText());
	}
	
	public void addWaterType(ActionEvent action) {
		Type_define.setText(water.getText());
	}
	
}
