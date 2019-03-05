package userInterface;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import type.*;
import javafx.scene.chart.XYChart;
import java.util.ResourceBundle;

public class Controller implements Initializable{
	
	@FXML PieChart outflowPieChart;
	
	@FXML PieChart inflowPieChart;
	
	@FXML TableView<Integer> table;
	
	@FXML TableColumn table_amount;
	
	@FXML Label account_amount;
	@FXML Button entry;
	
	@FXML private BarChart<?,?> costSpending;
	@FXML private CategoryAxis time;
	@FXML private NumberAxis amounts;
	@Override
	public void initialize(URL url, ResourceBundle rb){
        
        ObservableList<PieChart.Data> in = FXCollections.observableArrayList(
        		new PieChart.Data("Food",50),
        		new PieChart.Data("Bills",60),
        		new PieChart.Data("Rent",70),
        		new PieChart.Data("Luxeries",20)
        		);
        
        ObservableList<PieChart.Data> out = FXCollections.observableArrayList(
        		new PieChart.Data("Paycheck",80),
        		new PieChart.Data("Unearned",12),
        		new PieChart.Data("Other",20)
        		);
        
        ObservableList<Data> tableData = FXCollections.observableArrayList(

        		);
        
        XYChart.Series dataIncome = new XYChart.Series<>();
        dataIncome.setName("Income");
        dataIncome.getData().add(new XYChart.Data<>("January", 545.43));
        dataIncome.getData().add(new XYChart.Data<>("Febuary", 618.3));
        costSpending.getData().addAll(dataIncome);
        
        XYChart.Series dataSpending = new XYChart.Series<>();
        dataSpending.setName("Spending");
        dataSpending.getData().add(new XYChart.Data<>("January", 394.54));
        dataSpending.getData().add(new XYChart.Data<>("Febuary", 456.78));
        costSpending.getData().addAll(dataSpending);
        
        outflowPieChart.setData(in);
        inflowPieChart.setData(out);
        account_amount.setText("$ " + "696,969.53");

    }
	
	public void newEntry(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("dataEntry.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("Data Entry");
		stage.setScene(scene);
		stage.show();
		
		
	}


}
