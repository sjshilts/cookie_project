package userInterface;

import javafx.event.ActionEvent;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import type.*;

public class Controller {
	
	@FXML PieChart outflowPieChart;
	
	@FXML PieChart inflowPieChart;
	
	@FXML TableView<Integer> table;
	
	@FXML TableColumn table_amount;
	
	@FXML Label account_amount;
	
	
	public void initialize(){
        
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
        String amount = "$";
        
        outflowPieChart.setData(in);
        inflowPieChart.setData(out);
        account_amount.setText("$ " + "125,896.53");

    }


}
