package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.ModelTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class FoodViewController implements Initializable {
	@FXML
	private TableView<ModelTable> FoodTable;
	@FXML
	private TableColumn<ModelTable, String> Food;
	@FXML
	private TableColumn<ModelTable, Integer> Count;
	@FXML
	private Button AddBtn;
	@FXML
	private Button Btn_reset;
	@FXML
	private Button out_Btn;

	ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

	@FXML
	void out_Clicked(ActionEvent event) {
		Stage loginStage = new Stage();
		Stage primaryStage = (Stage) AddBtn.getScene().getWindow();
		Parent root;
		try {
			JOptionPane.showMessageDialog(null, "?α׾ƿ? ?Ϸ?.");
			root = FXMLLoader.load(getClass().getResource("/View/LoginView.fxml"));
			Scene scene = new Scene(root);
			loginStage.setTitle("?α???");
			loginStage.setScene(scene);
			loginStage.show();
			primaryStage.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	// Event Listener on Button.onAction
	@FXML
	public void ranClicked(ActionEvent event) {
		// TODO Autogenerated
		try {

			Stage roulStage = new Stage();
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/View/Roulette.fxml"));
			Scene scene = new Scene(root);
			roulStage.setTitle("??÷ ??...");
			roulStage.setScene(scene);
			roulStage.show();

			Connection conn = application.DBConnection.getConnection();

			String sql1 = "UPDATE food SET COUNT = COUNT+1 WHERE FOOD LIKE '";
			String sql2 = oblist.get((int) (Math.random() * oblist.size())).getFood();
			String sql3 = "'";
			String sql4 = sql1 + sql2 + sql3;

			conn.createStatement().executeQuery(sql4);
			Thread.sleep(2000);
			JOptionPane.showMessageDialog(null, sql2 + " ??÷!");
			roulStage.close();

			oblist.removeAll(oblist);

			ResultSet rs = conn.createStatement().executeQuery("select * from FOOD order by COUNT desc"); // ???????? ?ۼ??ϴ?
																											// ???Դϴ?.
			while (rs.next()) {
				oblist.add(new ModelTable(rs.getString("food"), rs.getInt("count")));
			}
			Food.setCellValueFactory(new PropertyValueFactory<>("food"));
			Count.setCellValueFactory(new PropertyValueFactory<>("count"));

			FoodTable.setItems(oblist);

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void btn_AddClicked1(ActionEvent event) {
		Stage addStage = new Stage();
		Stage primaryStage = (Stage) AddBtn.getScene().getWindow();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/View/AddFoodView.fxml"));
			Scene scene = new Scene(root);
			addStage.setTitle("?Ĵ? ?߰?");
			addStage.setScene(scene);
			addStage.show();
			primaryStage.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void reClicked(ActionEvent event) {
		try {
			Connection conn = application.DBConnection.getConnection();
			String sql = "UPDATE FOOD SET COUNT =";
			sql = sql + '0';

			conn.createStatement().executeQuery(sql);
			oblist.get(0);

			JOptionPane.showMessageDialog(null, "?ʱ?ȭ ?Ϸ?.");

			oblist.removeAll(oblist);
			ResultSet rs = conn.createStatement().executeQuery("select * from FOOD order by COUNT desc"); // ???????? ?ۼ??ϴ?
																											// ???Դϴ?.
			while (rs.next()) {
				oblist.add(new ModelTable(rs.getString("food"), rs.getInt("count")));
			}
			Food.setCellValueFactory(new PropertyValueFactory<>("food"));
			Count.setCellValueFactory(new PropertyValueFactory<>("count"));

			FoodTable.setItems(oblist);

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {
			Connection conn = application.DBConnection.getConnection(); // ???????? DBconnection Ŭ???????? ?????ͺ??̽? ?????? ?ҷ??ɴϴ?.
			ResultSet rs = conn.createStatement().executeQuery("select * from FOOD order by COUNT desc"); // ???????? ?ۼ??ϴ?
																											// ???Դϴ?.
			while (rs.next()) {
				oblist.add(new ModelTable(rs.getString("food"), rs.getInt("count")));
			}
			conn.close();
			Food.setCellValueFactory(new PropertyValueFactory<>("food"));
			Count.setCellValueFactory(new PropertyValueFactory<>("count"));

			FoodTable.setItems(oblist);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
