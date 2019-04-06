package testingSuite;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

import backend.DataInterface;
import backend.GetData;
import backend.TotalAmounts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;
import userInterface.Table;

public class TestDataInterface {

	@Test
	public void testOutflowPieChartData() throws SQLException, IOException {
		ObservableList<Data> data = FXCollections.observableArrayList(
				 new PieChart.Data("Bills", 3567.8),
				 new PieChart.Data("Cost Of Living", 1427.12),
				 new PieChart.Data("Luxuries", 713.56),
				 new PieChart.Data("Savings", 1427.12)
				 );
		TotalAmounts total = new TotalAmounts();
		assertTrue(DataInterface.OutflowPieChartData(total) instanceof ObservableList);
		assertEquals(data, DataInterface.OutflowPieChartData(total));
	}

	@Test
	public void testInflowPieChartData() throws SQLException, IOException {
		ObservableList<Data> data = FXCollections.observableArrayList(
				new PieChart.Data("Paycheck", 3872.48),
				new PieChart.Data("Unearned", 3872.48),
				new PieChart.Data("Other", 3872.48)
				);
		TotalAmounts total = new TotalAmounts();
		assertTrue(DataInterface.InflowPieChartData(total) instanceof ObservableList);
		assertEquals(data, DataInterface.InflowPieChartData(total));
	}

	@Test
	public void testSetInflowChartData() throws SQLException, IOException {
		GetData db = new GetData("jmperttu","thewitchking");
		TotalAmounts total = new TotalAmounts();
		XYChart.Series<String, Double> incomeData = new XYChart.Series<>();
		incomeData.setName("Income");
		incomeData.getData().add(new XYChart.Data<>("January 2019", 0.0));
		incomeData.getData().add(new XYChart.Data<>("Febuary 2019", 0.0));
		incomeData.getData().add(new XYChart.Data<>("March 2019", 0.0));
		incomeData.getData().add(new XYChart.Data<>("April 2019", 0.0));
		incomeData.getData().add(new XYChart.Data<>("May 2018", 0.0));
		incomeData.getData().add(new XYChart.Data<>("June 2018", 0.0));
		incomeData.getData().add(new XYChart.Data<>("July 2018", 0.0));
		incomeData.getData().add(new XYChart.Data<>("August 2018", 0.0));
		incomeData.getData().add(new XYChart.Data<>("September 2018", 0.0));
		incomeData.getData().add(new XYChart.Data<>("October 2018", 0.0));
		incomeData.getData().add(new XYChart.Data<>("November 2018", 0.0));
		incomeData.getData().add(new XYChart.Data<>("December 2018", 0.0));
		
		assertEquals(12, incomeData.getData().size());
		
		for(int i = 0; i < 12; i++) {
			assertEquals(incomeData.getData().get(i), DataInterface.setInflowChartData(db.getInflow(), total).getData().get(i));
		}
	}

	@Test
	public void testSetOutflowChartData() throws SQLException, IOException {
		GetData db = new GetData("jmperttu","thewitchking");
		TotalAmounts total = new TotalAmounts();
		XYChart.Series<String, Double> spendingData = new XYChart.Series<>();
		spendingData.setName("Spending");
		spendingData.getData().add(new XYChart.Data<>("January 2019", 0.0));
		spendingData.getData().add(new XYChart.Data<>("Febuary 2019", 0.0));
		spendingData.getData().add(new XYChart.Data<>("March 2019", 0.0));
		spendingData.getData().add(new XYChart.Data<>("April 2019", 0.0));
		spendingData.getData().add(new XYChart.Data<>("May 2018", 0.0));
		spendingData.getData().add(new XYChart.Data<>("June 2018", 0.0));
		spendingData.getData().add(new XYChart.Data<>("July 2018", 0.0));
		spendingData.getData().add(new XYChart.Data<>("August 2018", 0.0));
		spendingData.getData().add(new XYChart.Data<>("September 2018", 0.0));
		spendingData.getData().add(new XYChart.Data<>("October 2018", 0.0));
		spendingData.getData().add(new XYChart.Data<>("November 2018", 0.0));
		spendingData.getData().add(new XYChart.Data<>("December 2018", 0.0));
		
		assertEquals(12, spendingData.getData().size());
		assertEquals(true, DataInterface.setOutflowChartData(db.getOutflow(), total).getData() instanceof ObservableList );
		assertEquals("January 2019", DataInterface.setOutflowChartData(db.getOutflow(), total).getData().get(0).getXValue());
	}

	@Test
	public void testTableDataOutflow() throws SQLException, IOException {
		TotalAmounts totals = new TotalAmounts();
		ObservableList<Table> data = FXCollections.observableArrayList();
		data.add( new Table("Savings", String.format ("$%.2f", totals.getTotalSavings()), String.format ("%.2f%%", (totals.getTotalSavings()/totals.getTotalInflow()*100)) ));
		data.add( new Table("401K", String.format ("$%.2f", totals.getTotal401K()), String.format ("%.2f%%", (totals.getTotal401K()/totals.getTotalInflow()*100)) ));
		data.add( new Table("Transportation", String.format ("$%.2f", totals.getTotalTransportation()), String.format ("%.2f%%", (totals.getTotalTransportation()/totals.getTotalInflow()*100)) ));
		data.add( new Table("Housing", String.format ("$%.2f", totals.getTotalHousing()), String.format ("%.2f%%", (totals.getTotalHousing()/totals.getTotalInflow()*100)) ));
		data.add( new Table("Luxuries", String.format ("$%.2f", totals.getTotalLuxery()), String.format ("%.2f%%", (totals.getTotalLuxery()/totals.getTotalInflow()*100)) ));
		data.add( new Table("Cost of Living", String.format ("$%.2f", totals.getTotalCostOfLiving()), String.format ("%.2f%%", (totals.getTotalCostOfLiving()/totals.getTotalInflow()*100)) ));
		data.add( new Table("Bills", String.format("$%.2f", totals.getTotalBills()), String.format("%.2f%%", (totals.getTotalBills()/totals.getTotalInflow()*100)) ));
		
		assertEquals(data, DataInterface.tableDataOutflow(totals) );
	}

	@Test
	public void testTableDataInflow() throws SQLException, IOException {
		TotalAmounts totals = new TotalAmounts();
		ObservableList<Table> data = FXCollections.observableArrayList();
		data.add( new Table("Paycheck", String.format ("$%.2f", totals.getTotalPaychecks()), String.format ("%.2f%%", (totals.getTotalPaychecks()/totals.getTotalInflow()*100)) ));
		data.add( new Table("Unearned Income", String.format ("$%.2f", totals.getTotalUnearnedIncome()), String.format ("%.2f%%", (totals.getTotalUnearnedIncome()/totals.getTotalInflow()*100)) ));
		data.add( new Table("Other Income", String.format ("$%.2f", totals.getTotalOtherIncome()), String.format ("%.2f%%", (totals.getTotalOtherIncome()/totals.getTotalInflow()*100)) ));
		
		assertEquals(data, DataInterface.tableDataInflow(totals));
	}

}
