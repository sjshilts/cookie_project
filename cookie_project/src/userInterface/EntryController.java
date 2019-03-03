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
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import type.*;
import java.time.LocalDate;
import java.time.Month;


public class EntryController implements Initializable {
	
	@FXML private MenuButton Type_define;
	@FXML private MenuItem electric;
	@FXML private MenuItem water;
	
	@FXML private TableView<Type> Entry_table;
	@FXML private TableColumn<Type, LocalDate> Date_Col;
	@FXML private TableColumn<Type, String> Amount_Col;
	@FXML private TableColumn<Type, String> Type_Col;
	
	@FXML private Button addItem_btn;
	
	@Override
	public void initialize(URL url, ResourceBundle rb){
		Date_Col.setCellValueFactory(new PropertyValueFactory<Type, LocalDate>("Date"));
		Amount_Col.setCellValueFactory(new PropertyValueFactory<Type, String>("Amount"));
		Type_Col.setCellValueFactory(new PropertyValueFactory<Type, String>("Type"));
		
    }
	
	public void enterEntry(ActionEvent action) {
		Entry_table.setItems(getType());
	}
	
	public ObservableList<Type> getType(){
		ObservableList<Type> list = FXCollections.observableArrayList();
		list.add( new Type(LocalDate.of(2018, Month.AUGUST, 12), "$456.56", "Rent"));
		list.add( new Type(LocalDate.of(2018, Month.AUGUST, 12), "$60.56", "Internet"));
		list.add( new Type(LocalDate.of(2018, Month.AUGUST, 12), "$120.54", "Electric"));
		list.add( new Type(LocalDate.of(2018, Month.AUGUST, 12), "$78.45", "Groceries"));
		return list;
	}
	
	public void addElectricType(ActionEvent action) {
		Type_define.setText(electric.getText());
	}
	
	public void addWaterType(ActionEvent action) {
		Type_define.setText(water.getText());
	}
	
}
