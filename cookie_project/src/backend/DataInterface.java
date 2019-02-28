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
	public ObservableList<Data> OutflowPieChartData(ArrayList<Outflow> list){
		
		TotalAmounts totals = new TotalAmounts();
		totals.addOutflow(list);
		
		 ObservableList<Data> data = FXCollections.observableArrayList(
				 new PieChart.Data("Bills", totals.getTotalBills()),
				 new PieChart.Data("Cost Of Living", totals.getTotalCostOfLiving()),
				 new PieChart.Data("Luxuries", totals.getTotalLuxery()),
				 new PieChart.Data("Savings", totals.getTotalSavings())
				 );
		 
		 return data;
	}
	
	public ObservableList<Data> InflowPieChartData(ArrayList<Inflow> list){
		
		TotalAmounts totals = new TotalAmounts();
		totals.addInflow(list);
		
		ObservableList<Data> data = FXCollections.observableArrayList(
				new PieChart.Data("Paycheck", totals.getTotalPaychecks()),
				new PieChart.Data("Unearned", totals.getTotalUnearnedIncome()),
				new PieChart.Data("Other", totals.getTotalOtherIncome())
				);
	
		return data;
	}

}
