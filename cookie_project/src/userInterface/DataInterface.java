package userInterface;

import javafx.event.ActionEvent;
import javafx.scene.chart.PieChart;
import java.util.ArrayList;
import java.util.Calendar;

import backend.TotalAmounts;
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
	
	/* Creates the data for the inflow pie chart
	 * 
	 */
	public static ObservableList<Data> OutflowPieChartData(ArrayList<Outflow> list){
		
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
	
	public static ObservableList<Data> InflowPieChartData(ArrayList<Inflow> list){
		
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
	public static XYChart.Series<String, Double> setInflowChartData(ArrayList<Inflow> list){
		LocalDate currentDate = LocalDate.now();
		XYChart.Series<String, Double> incomeData = new XYChart.Series<>();
		incomeData.setName("Income");
		TotalAmounts totals = new TotalAmounts();
		totals.addInflow(list);
		
		incomeData.getData().add(new XYChart.Data<>("January", 0.0));
		incomeData.getData().add(new XYChart.Data<>("Febuary", 0.0));
		incomeData.getData().add(new XYChart.Data<>("March", 0.0));
		incomeData.getData().add(new XYChart.Data<>("April", 0.0));
		incomeData.getData().add(new XYChart.Data<>("May", 0.0));
		incomeData.getData().add(new XYChart.Data<>("June", 0.0));
		incomeData.getData().add(new XYChart.Data<>("July", 0.0));
		incomeData.getData().add(new XYChart.Data<>("August", 0.0));
		incomeData.getData().add(new XYChart.Data<>("September", 0.0));
		incomeData.getData().add(new XYChart.Data<>("October", 0.0));
		incomeData.getData().add(new XYChart.Data<>("November", 0.0));
		incomeData.getData().add(new XYChart.Data<>("December", 0.0));
		
		
		for(int i = 0; i < list.size(); i++) {
			if( list.get(i).getDate().before( Date.valueOf(currentDate) ) && list.get(i).getDate().after( Date.valueOf(currentDate.minusYears(1))  ) ) {
				
				int month = list.get(i).getDate().getMonth();
				
				switch(month) {
				case 1: 
					incomeData.getData().get(1).setYValue( list.get(i).getAmount() + incomeData.getData().get(1).getYValue());
					break;
				case 2:
					incomeData.getData().get(2).setYValue( list.get(i).getAmount() + incomeData.getData().get(2).getYValue());
					break;
				case 3:
					incomeData.getData().get(3).setYValue( list.get(i).getAmount() + incomeData.getData().get(3).getYValue());
					break;
				case 4: 
					incomeData.getData().get(4).setYValue( list.get(i).getAmount() + incomeData.getData().get(4).getYValue());
					break;
				case 5:
					incomeData.getData().get(5).setYValue( list.get(i).getAmount() + incomeData.getData().get(5).getYValue());
					break;
				case 6:
					incomeData.getData().get(6).setYValue( list.get(i).getAmount() + incomeData.getData().get(6).getYValue());
					break;
				case 7:
					incomeData.getData().get(7).setYValue( list.get(i).getAmount() + incomeData.getData().get(7).getYValue());
					break;
				case 8:
					incomeData.getData().get(8).setYValue( list.get(i).getAmount() + incomeData.getData().get(8).getYValue());
					break;
				case 9:
					incomeData.getData().get(9).setYValue( list.get(i).getAmount() + incomeData.getData().get(9).getYValue());
					break;
				case 10:
					incomeData.getData().get(10).setYValue( list.get(i).getAmount() + incomeData.getData().get(10).getYValue());
					break;
				case 11:
					incomeData.getData().get(11).setYValue( list.get(i).getAmount() + incomeData.getData().get(11).getYValue());
					break;
				case 12:
					incomeData.getData().get(12).setYValue( list.get(i).getAmount() + incomeData.getData().get(12).getYValue());
					break;
				
				}
			}
			
		}
		return incomeData;
		
	}
	
	@SuppressWarnings("deprecation")
	public static XYChart.Series<String, Double> setOutflowChartData(ArrayList<Outflow> list){
		LocalDate currentDate = LocalDate.now();
		XYChart.Series<String, Double> spendingData = new XYChart.Series<>();
		spendingData.setName("Spending");
		TotalAmounts totals = new TotalAmounts();
		totals.addOutflow(list);
		
		spendingData.getData().add(new XYChart.Data<>("January", 0.0));
		spendingData.getData().add(new XYChart.Data<>("Febuary", 0.0));
		spendingData.getData().add(new XYChart.Data<>("March", 0.0));
		spendingData.getData().add(new XYChart.Data<>("April", 0.0));
		spendingData.getData().add(new XYChart.Data<>("May", 0.0));
		spendingData.getData().add(new XYChart.Data<>("June", 0.0));
		spendingData.getData().add(new XYChart.Data<>("July", 0.0));
		spendingData.getData().add(new XYChart.Data<>("August", 0.0));
		spendingData.getData().add(new XYChart.Data<>("September", 0.0));
		spendingData.getData().add(new XYChart.Data<>("October", 0.0));
		spendingData.getData().add(new XYChart.Data<>("November", 0.0));
		spendingData.getData().add(new XYChart.Data<>("December", 0.0));
		
		
		for(int i = 0; i < list.size(); i++) {
			if( list.get(i).getDate().before( Date.valueOf(currentDate) ) && list.get(i).getDate().after( Date.valueOf(currentDate.minusYears(1))  ) ) {
				
				int month = list.get(i).getDate().getMonth();
				
				switch(month) {
				case 1: 
					spendingData.getData().get(1).setYValue( list.get(i).getAmount() + spendingData.getData().get(1).getYValue());
					break;
				case 2:
					spendingData.getData().get(2).setYValue( list.get(i).getAmount() + spendingData.getData().get(2).getYValue());
					break;
				case 3:
					spendingData.getData().get(3).setYValue( list.get(i).getAmount() + spendingData.getData().get(3).getYValue());
					break;
				case 4: 
					spendingData.getData().get(4).setYValue( list.get(i).getAmount() + spendingData.getData().get(4).getYValue());
					break;
				case 5:
					spendingData.getData().get(5).setYValue( list.get(i).getAmount() + spendingData.getData().get(5).getYValue());
					break;
				case 6:
					spendingData.getData().get(6).setYValue( list.get(i).getAmount() + spendingData.getData().get(6).getYValue());
					break;
				case 7:
					spendingData.getData().get(7).setYValue( list.get(i).getAmount() + spendingData.getData().get(7).getYValue());
					break;
				case 8:
					spendingData.getData().get(8).setYValue( list.get(i).getAmount() + spendingData.getData().get(8).getYValue());
					break;
				case 9:
					spendingData.getData().get(9).setYValue( list.get(i).getAmount() + spendingData.getData().get(9).getYValue());
					break;
				case 10:
					spendingData.getData().get(10).setYValue( list.get(i).getAmount() + spendingData.getData().get(10).getYValue());
					break;
				case 11:
					spendingData.getData().get(11).setYValue( list.get(i).getAmount() + spendingData.getData().get(11).getYValue());
					break;
				case 12:
					spendingData.getData().get(12).setYValue( list.get(i).getAmount() + spendingData.getData().get(12).getYValue());
					break;
				
				}
			}
			
		}
		return spendingData;
		
	}
	public static ObservableList<Table> tableData(ArrayList<Inflow> in, ArrayList<Outflow> out){
		ObservableList<Table> data = FXCollections.observableArrayList();
		TotalAmounts totals = new TotalAmounts();
		totals.addInflow(in);
		totals.addOutflow(out);
		
		data.add( new Table("Paychecks",totals.getTotalPaychecks(), (int) (totals.getTotalPaychecks()/totals.getTotalInflow()*100) ));
		data.add( new Table("Savings",totals.getTotalSavings(), (int) (totals.getTotalSavings()/totals.getTotalInflow()*100) ));
		data.add( new Table("Transportation",totals.getTotalGas(), (int) (totals.getTotalGas()/totals.getTotalInflow()*100) ));
		data.add( new Table("Housing",totals.getTotalHousing(), (int) (totals.getTotalHousing()/totals.getTotalInflow()*100) ));
		data.add( new Table("Luxuries",totals.getTotalLuxery(), (int) (totals.getTotalLuxery()/totals.getTotalInflow()*100) ));
		data.add( new Table("Cost of Living",totals.getTotalCostOfLiving(), (int) (totals.getTotalCostOfLiving()/totals.getTotalInflow()*100) ));
		data.add( new Table("Groceries",totals.getTotalGroceries(), (int) (totals.getTotalGroceries()/totals.getTotalInflow()*100) ));
		data.add( new Table("Electricity",totals.getTotalElectric(), (int) (totals.getTotalElectric()/totals.getTotalInflow()*100) ));
		
		
		return data;
	}
	
}
