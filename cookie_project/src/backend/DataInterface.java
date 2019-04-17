package backend;

// HEAD
import javafx.scene.chart.PieChart; 
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart.Data;
import type.*;
import userInterface.Table;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class DataInterface { 
	
	/**
	 * 
	 * Creates the data for the outflow pie chart 
	 * @param totals
	 * @return all data for outflow pie chart
	 * @throws SQLException
	 * @throws IOException
	 */
	public static ObservableList<Data> OutflowPieChartData(TotalAmounts totals) throws SQLException, IOException{
		 ObservableList<Data> data = FXCollections.observableArrayList(
				 new PieChart.Data("Bills", totals.getTotalBills()),
				 new PieChart.Data("Cost Of Living", totals.getTotalCostOfLiving()),
				 new PieChart.Data("Luxuries", totals.getTotalLuxery()),
				 new PieChart.Data("Savings", totals.getTotalSavings())
				 );
		 return data;
	}
	
	/**
	 * 
	 * Creates the data for the inflow pie chart
	 * @param totals
	 * @return all data for outflow
	 * @throws SQLException
	 * @throws IOException
	 */
	public static ObservableList<Data> InflowPieChartData(TotalAmounts totals) throws SQLException, IOException{

		
		ObservableList<Data> data = FXCollections.observableArrayList(
				new PieChart.Data("Paycheck", totals.getTotalPaychecks()),
				new PieChart.Data("Unearned", totals.getTotalUnearnedIncome()),
				new PieChart.Data("Other", totals.getTotalOtherIncome())
				);
	
		return data;
	}
	
	/**
	 * 
	 * Sets all data for the area chart for inflow
	 * @param list
	 * @param totals
	 * @return Series of Months and amounts
	 * @throws SQLException
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public static XYChart.Series<String, Double> setInflowChartData(ArrayList<Inflow> list, TotalAmounts totals, LocalDate currentDate) throws SQLException, IOException{
		//LocalDate currentDate = LocalDate.now();
		XYChart.Series<String, Double> incomeData = new XYChart.Series<>();
		incomeData.setName("Income");
		
		// Find the current year and month
		int year = currentDate.getYear();
		int month = currentDate.getMonthValue();
		
		// What month are we in?
		switch (month) {
		case 1:
			// If the current month is January
			// then we want to show January of the current year
			// and then every month after is from the year prior
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

		
		// Puts actual amounts inside the inflow list
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
	
	/**
	 * 
	 * Sets all data for the area chart for outflow
	 * @param list
	 * @param totals
	 * @return Series of Months and amounts
	 * @throws SQLException
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public static XYChart.Series<String, Double> setOutflowChartData(ArrayList<Outflow> list, TotalAmounts totals, LocalDate currentDate) throws SQLException, IOException{
		//LocalDate currentDate = LocalDate.now();
		XYChart.Series<String, Double> spendingData = new XYChart.Series<>();
		spendingData.setName("Spending");
		
		// Find the current date and year
		int year = currentDate.getYear();
		int month = currentDate.getMonthValue();
		
		switch (month) {
		case 1:
			// If the current month is January
			// then we want to show January of the current year
			// and then every month after is from the year prior
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
		
		// Add actual amounts into the list
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
	
	/**
	 * Sets all amounts and percentages for the outflow table for easy viewing
	 * @param totals
	 * @return A list of all data added
	 * @throws SQLException
	 * @throws IOException
	 */
	public static ObservableList<Table> tableDataOutflow(TotalAmounts totals) throws SQLException, IOException{
		ObservableList<Table> data = FXCollections.observableArrayList();
		data.add( new Table("Savings", String.format ("$%.2f", totals.getTotalSavings()), String.format ("%.2f%%", (totals.getTotalSavings()/totals.getTotalInflow()*100)) ));
		data.add( new Table("401K", String.format ("$%.2f", totals.getTotal401K()), String.format ("%.2f%%", (totals.getTotal401K()/totals.getTotalInflow()*100)) ));
		data.add( new Table("Transportation", String.format ("$%.2f", totals.getTotalTransportation()), String.format ("%.2f%%", (totals.getTotalTransportation()/totals.getTotalInflow()*100)) ));
		data.add( new Table("Housing", String.format ("$%.2f", totals.getTotalHousing()), String.format ("%.2f%%", (totals.getTotalHousing()/totals.getTotalInflow()*100)) ));
		data.add( new Table("Luxuries", String.format ("$%.2f", totals.getTotalLuxery()), String.format ("%.2f%%", (totals.getTotalLuxery()/totals.getTotalInflow()*100)) ));
		data.add( new Table("Cost of Living", String.format ("$%.2f", totals.getTotalCostOfLiving()), String.format ("%.2f%%", (totals.getTotalCostOfLiving()/totals.getTotalInflow()*100)) ));
		data.add( new Table("Bills", String.format("$%.2f", totals.getTotalBills()), String.format("%.2f%%", (totals.getTotalBills()/totals.getTotalInflow()*100)) ));
		
		return data;
	}
	
	/**
	 * Sets all amounts and percentages for the inflow table for easy viewing
	 * @param totals
	 * @return A list of all data added
	 * @throws SQLException
	 * @throws IOException
	 */
	public static ObservableList<Table> tableDataInflow(TotalAmounts totals)throws SQLException, IOException {
		ObservableList<Table> data = FXCollections.observableArrayList();
		data.add( new Table("Paycheck", String.format ("$%.2f", totals.getTotalPaychecks()), String.format ("%.2f%%", (totals.getTotalPaychecks()/totals.getTotalInflow()*100)) ));
		data.add( new Table("Unearned Income", String.format ("$%.2f", totals.getTotalUnearnedIncome()), String.format ("%.2f%%", (totals.getTotalUnearnedIncome()/totals.getTotalInflow()*100)) ));
		data.add( new Table("Other Income", String.format ("$%.2f", totals.getTotalOtherIncome()), String.format ("%.2f%%", (totals.getTotalOtherIncome()/totals.getTotalInflow()*100)) ));
		
		return data;
	}
	
}
