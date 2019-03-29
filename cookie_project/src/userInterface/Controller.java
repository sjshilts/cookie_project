package userInterface;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedAreaChart;

import java.io.File;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.chart.XYChart;

public class Controller implements Initializable{
	
	@FXML PieChart outflowPieChart;
	
	@FXML PieChart inflowPieChart;
	
	@FXML Label account_amount;
	@FXML Button Entry;
	@FXML Button logOutBttn;
	@FXML Button userSettingsBttn;
	
	@FXML ImageView MoneyIcon;
	
	@FXML private AreaChart<?,?> costSpending;
	@FXML private CategoryAxis time;
	@FXML private NumberAxis amounts;
	
	@FXML private TableView<Table> Entry_table;
	@FXML private TableColumn<Table, Integer> Percent_Col;
	@FXML private TableColumn<Table, Double> Amount_Col;
	@FXML private TableColumn<Table, String> Type_Col;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
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
			totals = new TotalAmounts();
			totals.setInflow(db.getInflow());
			totals.setOutflow(db.getOutflow());
			Entry_table.setItems( DataInterface.tableData(db.getInflow(), db.getOutflow()));
			numberAsString = String.format ("%.2f", totals.getTotal());
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
        costSpending.getData().add(dataIncome);
        costSpending.getData().add(dataSpending);
        
        
        outflowPieChart.setData(in);
        inflowPieChart.setData(out);
        account_amount.setText(numberAsString);

    }
	
	public void newEntry(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("dataEntry.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("Data Entry");
		stage.getIcons().add(new Image("/images/cookie_icon.png"));
		stage.setScene(scene);
		stage.show();
		
		Stage stageClose = (Stage) Entry.getScene().getWindow();
		stageClose.close();
		
		stage.setOnCloseRequest(e -> stageClose.show() );
	}
	
	public void logOut(ActionEvent event) {
		
		Stage stageClose = (Stage) logOutBttn.getScene().getWindow();
		stageClose.close();
		File file = new File("src/userInterface/AccountNumber.txt");
		file.delete();
		System.exit(1);
	}


}
