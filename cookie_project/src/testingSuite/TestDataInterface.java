package testingSuite;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import backend.GetData;
import javafx.collections.ObservableList;
import type.Inflow;
import type.Outflow;
import userInterface.DataInterface;

class TestDataInterface {

	@Test
	void testOutflowPieChartData() throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Outflow> outflow = data.getOutflow();
		assertTrue(DataInterface.OutflowPieChartData(outflow) instanceof ObservableList);
		assertEquals("Bills",DataInterface.OutflowPieChartData(outflow).get(1).getName());
	}

	@Test
	void testInflowPieChartData() throws SQLException, IOException {
		GetData data = new GetData("jmperttu", "thewitchking");
		ArrayList<Inflow> inflow = data.getInflow();
		assertTrue(DataInterface.InflowPieChartData(inflow) instanceof ObservableList);
	}

}
