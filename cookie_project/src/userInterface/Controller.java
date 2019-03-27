package userInterface;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import backend.GetData;
import backend.TotalAmounts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.chart.XYChart;

public class Controller implements Initializable{
	
	@FXML PieChart outflowPieChart;
	
	@FXML PieChart inflowPieChart;
	
	@FXML TableView<Integer> table;
	
	@FXML TableColumn table_amount;
	
	@FXML Label account_amount;
	@FXML Button entry;
	@FXML Button logOutBttn;
	
	@FXML private BarChart<?,?> costSpending;
	@FXML private CategoryAxis time;
	@FXML private NumberAxis amounts;
	
	@FXML private TableView<Table> Entry_table;
	@FXML private TableColumn<Table, Integer> Percent_Col;
	@FXML private TableColumn<Table, Double> Amount_Col;
	@FXML private TableColumn<Table, String> Type_Col;
	
	int accNum;
	
	@Override
	public void initialize(URL url, ResourceBundle rb){
		 GetData db = new GetData("sjshilts","sJSdbPass10");
		 ObservableList<PieChart.Data> in = FXCollections.observableArrayList();
		 ObservableList<PieChart.Data> out = FXCollections.observableArrayList();
		 String numberAsString = null;
		 
		 Percent_Col.setCellValueFactory(new PropertyValueFactory<Table, Integer>("Percent"));
		 Amount_Col.setCellValueFactory(new PropertyValueFactory<Table, Double>("Amount"));
		 Type_Col.setCellValueFactory(new PropertyValueFactory<Table, String>("Type"));
			
		 XYChart.Series dataIncome = null;
		 XYChart.Series dataSpending = null;
		 TotalAmounts totals = null;
		try {
			in = DataInterface.InflowPieChartData(db.getInflow());
			out = DataInterface.OutflowPieChartData(db.getOutflow());
			dataIncome = DataInterface.setInflowChartData(db.getInflow());
			dataSpending = DataInterface.setOutflowChartData(db.getOutflow());
			totals = new TotalAmounts(db.getInflow(), db.getOutflow());
			Entry_table.setItems( DataInterface.tableData(db.getInflow(), db.getOutflow()));
			numberAsString = String.format ("%.2f", db.getBalance());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        costSpending.getData().addAll(dataIncome);
        costSpending.getData().addAll(dataSpending);
        
        
        outflowPieChart.setData(in);
        inflowPieChart.setData(out);
        account_amount.setText("$ " + numberAsString);

    }
	
	public void newEntry(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("dataEntry.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("Data Entry");
		stage.getIcons().add(new Image("/images/cookie_icon.png"));
		stage.setScene(scene);
		stage.show();
		
		
	}
	
	public void logOut(ActionEvent event) {
		
		Stage stageClose = (Stage) logOutBttn.getScene().getWindow();
		stageClose.close();
	}


}
