package backend;

import javafx.event.ActionEvent;
import javafx.scene.chart.PieChart;
import java.util.ArrayList;
import java.util.Calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart.Data;
import type.*;
import javafx.scene.chart.XYChart;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DataInterface {
	
	LocalDate currentDate = LocalDate.now();
	
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
	
	@SuppressWarnings("deprecation")
	public XYChart.Series<String, Double> setInflowChartData(ArrayList<Inflow> list){
		XYChart.Series<String, Double> incomeData = new XYChart.Series<>();
		TotalAmounts totals = new TotalAmounts();
		totals.addInflow(list);
		
		for(int i = 0; i < list.size(); i++) {
			if( list.get(i).getDate().after( Date.valueOf(currentDate) ) && list.get(i).getDate().before( Date.valueOf(currentDate.plusYears(1))  ) ) {
				
				
				int month = list.get(i).getDate().getMonth();
				switch(month) {
				case 1: 
				}
			}
			
		}
		return incomeData;
		
	}
	
}
