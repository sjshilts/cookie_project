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

import backend.DataInterface;
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
import javafx.scene.control.Tooltip;
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
	
	@FXML private TableView<Table> spending_table;
	@FXML private TableColumn<Table, Integer> percent_col_s;
	@FXML private TableColumn<Table, Double> amount_col_s;
	@FXML private TableColumn<Table, String> type_col_s;
	
	@FXML private TableView<Table> income_table;
	@FXML private TableColumn<Table, Integer> percent_col_i;
	@FXML private TableColumn<Table, Double> amount_col_i;
	@FXML private TableColumn<Table, String> type_col_i;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@Override
	public void initialize(URL url, ResourceBundle rb){
		
		 ObservableList<PieChart.Data> in = FXCollections.observableArrayList();
		 ObservableList<PieChart.Data> out = FXCollections.observableArrayList();
		 String numberAsString = null;
		 
		 percent_col_s.setCellValueFactory(new PropertyValueFactory<Table, Integer>("Percent"));
		 amount_col_s.setCellValueFactory(new PropertyValueFactory<Table, Double>("Amount"));
		 type_col_s.setCellValueFactory(new PropertyValueFactory<Table, String>("Type"));
		 
		 percent_col_i.setCellValueFactory(new PropertyValueFactory<Table, Integer>("Percent"));
		 amount_col_i.setCellValueFactory(new PropertyValueFactory<Table, Double>("Amount"));
		 type_col_i.setCellValueFactory(new PropertyValueFactory<Table, String>("Type"));
			
		 XYChart.Series dataIncome = null;
		 XYChart.Series dataSpending = null;
		 TotalAmounts total = null;
		 
		 try{
			 total = new TotalAmounts();
			in = DataInterface.InflowPieChartData(total);
			out = DataInterface.OutflowPieChartData(total);
			
			GetData db = new GetData("sjshilts","sJSdbPass10");
			dataIncome = DataInterface.setInflowChartData(db.getInflow(), total);
			dataSpending = DataInterface.setOutflowChartData(db.getOutflow(), total);
			db.closeConn();
			
			spending_table.setItems( DataInterface.tableDataOutflow( total ));
			income_table.setItems( DataInterface.tableDataInflow( total ));
			
			numberAsString = String.format ("%.2f", total.getTotal());
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
        costSpending.getData().add(dataIncome);
        costSpending.getData().add(dataSpending);
        
        
        outflowPieChart.setData(out);
        inflowPieChart.setData(in);
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
	
	public void logOut(ActionEvent event) throws IOException {
		
		Stage stageClose = (Stage) logOutBttn.getScene().getWindow();
		stageClose.close();
		File file = new File("src/userInterface/AccountNumber.txt");
		file.delete();
		
		Parent root = FXMLLoader.load((getClass().getResource("loginScreen.fxml")));
		Scene scene = new Scene(root);
		Stage stageNew = new Stage();
		stageNew.setTitle("My Money Management...");
		stageNew.getIcons().add(new Image("/images/cookie_icon.png"));
		stageNew.setScene(scene);
		stageNew.show();
		
	}


}
