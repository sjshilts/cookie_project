package backend;

import javafx.event.ActionEvent;
import javafx.scene.chart.PieChart;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart.Data;
import type.*;

public class DataInterface {
	
	/* Creates the data for the inflow pie chart
	 * 
	 */
	public ObservableList<Data> InflowPieChartData(ArrayList<Outflow> list){
		
		ArrayList<Inflow> empty = null;
		TotalAmounts totals = new TotalAmounts(empty, list);
		
		 ObservableList<Data> data = FXCollections.observableArrayList(
				 new PieChart.Data("Bills", totals.getTotalBills()),
				 new PieChart.Data("Cost Of Living", totals.getTotalCostOfLiving()),
				 new PieChart.Data("Luxuries", totals.getTotalLuxery()),
				 new PieChart.Data("Savings", totals.getTotalSavings())
				 );
		 
		 return data;
	}

}
