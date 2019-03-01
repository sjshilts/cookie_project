package userInterface;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.*;
import javafx.stage.Stage;
import type.*;

public class EntryController {
	
	@FXML MenuButton Type_define;
	
	@FXML MenuItem electric;
	@FXML MenuItem water;
	
	@FXML
	public void initialize(){


    }
	
	public void addElectricType(ActionEvent action) {
		Type_define.setText(electric.getText());
	}
	
	public void addWaterType(ActionEvent action) {
		Type_define.setText(water.getText());
	}
}
