package userInterface;

// HEAD
import javafx.scene.chart.PieChart; 
import java.util.ArrayList;
import java.util.Calendar;

import backend.TotalAmounts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart.Data;
import type.*;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class DataInterface { 
	
	/* Creates the data for the inflow pie chart
	 * 
	 */ 
	public static ObservableList<Data> OutflowPieChartData(ArrayList<Outflow> list) throws SQLException, IOException{
		
		TotalAmounts totals = new TotalAmounts();
		totals.addOutflow(list); 
//		branch 'master' of https://github.com/sjshilts/cookie_project.git
		
		 ObservableList<Data> data = FXCollections.observableArrayList(
				 new PieChart.Data("Bills", totals.getTotalBills()),
				 new PieChart.Data("Cost Of Living", totals.getTotalCostOfLiving()),
				 new PieChart.Data("Luxuries", totals.getTotalLuxery()),
				 new PieChart.Data("Savings", totals.getTotalSavings())
				 );
		 
		 return data;
	}
	
	public static ObservableList<Data> InflowPieChartData(ArrayList<Inflow> list) throws SQLException, IOException{
		
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
	public static XYChart.Series<String, Double> setInflowChartData(ArrayList<Inflow> list) throws SQLException, IOException{
		LocalDate currentDate = LocalDate.now();
		XYChart.Series<String, Double> incomeData = new XYChart.Series<>();
		incomeData.setName("Income");
		TotalAmounts totals = new TotalAmounts();
		totals.addInflow(list);
		int year = currentDate.getYear();
		int month = currentDate.getMonthValue();
		
		switch (month) {
		case 1:
			incomeData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			year = year - 1;
			incomeData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		case 2:
			incomeData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			year = year - 1;
			incomeData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		case 3:
			incomeData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			year = year - 1;
			incomeData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		case 4:
			incomeData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			year = year - 1;
			incomeData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		case 5:
			incomeData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			year = year - 1;
			incomeData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		case 6:
			incomeData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			year = year - 1;
			incomeData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		case 7:
			incomeData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			year = year - 1;
			incomeData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		case 8:
			incomeData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			year = year - 1;
			incomeData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		case 9:
			incomeData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			year = year - 1;
			incomeData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		case 10:
			incomeData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			year = year - 1;
			incomeData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		case 11:
			incomeData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			year = year - 1;
			incomeData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		case 12:
			incomeData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			incomeData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		}

		
		
		for(int i = 0; i < list.size(); i++) {
			LocalDate pastDate = currentDate.minusDays( currentDate.getDayOfMonth() + 1);
			if( list.get(i).getDate().before( Date.valueOf(currentDate) ) && list.get(i).getDate().after( Date.valueOf(pastDate.minusYears(1))  ) ) {
				
				month = list.get(i).getDate().getMonth();
				
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
	public static XYChart.Series<String, Double> setOutflowChartData(ArrayList<Outflow> list) throws SQLException, IOException{
		LocalDate currentDate = LocalDate.now();
		XYChart.Series<String, Double> spendingData = new XYChart.Series<>();
		spendingData.setName("Spending");
		TotalAmounts totals = new TotalAmounts();
		totals.addOutflow(list);
		
		int year = currentDate.getYear();
		int month = currentDate.getMonthValue();
		
		switch (month) {
		case 1:
			spendingData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			year = year - 1;
			spendingData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		case 2:
			spendingData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			year = year - 1;
			spendingData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		case 3:
			spendingData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			year = year - 1;
			spendingData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		case 4:
			spendingData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			year = year - 1;
			spendingData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		case 5:
			spendingData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			year = year - 1;
			spendingData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		case 6:
			spendingData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			year = year - 1;
			spendingData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		case 7:
			spendingData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			year = year - 1;
			spendingData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		case 8:
			spendingData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			year = year - 1;
			spendingData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		case 9:
			spendingData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			year = year - 1;
			spendingData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		case 10:
			spendingData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			year = year - 1;
			spendingData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		case 11:
			spendingData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			year = year - 1;
			spendingData.getData().add(new XYChart.Data<>("December " + year, 0.0));
		case 12:
			spendingData.getData().add(new XYChart.Data<>("January " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("Febuary " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("March " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("April " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("May " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("June " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("July " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("August " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("September " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("October " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("November " + year, 0.0));
			spendingData.getData().add(new XYChart.Data<>("December " + year, 0.0));
			break;
		}
		
		for(int i = 0; i < list.size(); i++) {
			LocalDate pastDate = currentDate.minusDays( currentDate.getDayOfMonth() + 1);
			if( list.get(i).getDate().before( Date.valueOf(currentDate) ) && list.get(i).getDate().after( Date.valueOf(pastDate.minusYears(1))  ) ) {
				
				month = list.get(i).getDate().getMonth();
				
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
	public static ObservableList<Table> tableDataOutflow(ArrayList<Inflow> in, ArrayList<Outflow> out) throws SQLException, IOException{
		ObservableList<Table> data = FXCollections.observableArrayList();
		TotalAmounts totals = new TotalAmounts();
		totals.addInflow(in);
		totals.addOutflow(out);
		data.add( new Table("Savings", String.format ("$%.2f", totals.getTotalSavings()), String.format ("%.2f%%", (totals.getTotalSavings()/totals.getTotalInflow()*100)) ));
		data.add( new Table("401K", String.format ("$%.2f", totals.getTotal401K()), String.format ("%.2f%%", (totals.getTotal401K()/totals.getTotalInflow()*100)) ));
		data.add( new Table("Transportation", String.format ("$%.2f", totals.getTotalGas()), String.format ("%.2f%%", (totals.getTotalGas()/totals.getTotalInflow()*100)) ));
		data.add( new Table("Housing", String.format ("$%.2f", totals.getTotalHousing()), String.format ("%.2f%%", (totals.getTotalHousing()/totals.getTotalInflow()*100)) ));
		data.add( new Table("Luxuries", String.format ("$%.2f", totals.getTotalLuxery()), String.format ("%.2f%%", (totals.getTotalLuxery()/totals.getTotalInflow()*100)) ));
		data.add( new Table("Cost of Living", String.format ("$%.2f", totals.getTotalCostOfLiving()), String.format ("%.2f%%", (totals.getTotalCostOfLiving()/totals.getTotalInflow()*100)) ));
		data.add( new Table("Bills", String.format("$%.2f", totals.getTotalBills()), String.format("%.2f%%", (totals.getTotalBills()/totals.getTotalInflow()*100)) ));
		
		return data;
	}
	
	public static ObservableList<Table> tableDataInflow(ArrayList<Inflow> in, ArrayList<Outflow> out)throws SQLException, IOException {
		ObservableList<Table> data = FXCollections.observableArrayList();
		TotalAmounts totals = new TotalAmounts();
		totals.addInflow(in);
		totals.addOutflow(out);
		data.add( new Table("Paycheck", String.format ("$%.2f", totals.getTotalPaychecks()), String.format ("%.2f%%", (totals.getTotalPaychecks()/totals.getTotalInflow()*100)) ));
		data.add( new Table("Unearned Income", String.format ("$%.2f", totals.getTotalUnearnedIncome()), String.format ("%.2f%%", (totals.getTotalUnearnedIncome()/totals.getTotalInflow()*100)) ));
		data.add( new Table("Other Income", String.format ("$%.2f", totals.getTotalOtherIncome()), String.format ("%.2f%%", (totals.getTotalOtherIncome()/totals.getTotalInflow()*100)) ));
		
		return data;
	}
	
}
