package userInterface;

import javafx.event.ActionEvent;
import javafx.scene.chart.PieChart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart.Data;

public class Controller {
	
	@FXML PieChart outflowPieChart;

    public void pressButton(ActionEvent click){
        
        ObservableList<Data> list = FXCollections.observableArrayList(
        		new PieChart.Data("Food",50),
        		new PieChart.Data("Bills",60),
        		new PieChart.Data("Rent",70),
        		new PieChart.Data("Luxeries",20)
        		);
        outflowPieChart.setData(list);
    }


}
