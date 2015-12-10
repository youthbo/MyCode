package se.plushogskolan.ju15.javafx;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.DayOfWeek;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import se.plushogskolan.ju15.beans.Records;
import se.plushogskolan.ju15.model.CalculatorModel;

public class CalculatorWindow extends Application {

	// static final Logger logger =
	// LogManager.getLogger(SpamWindow.class.getName());
	public static ObservableList<Records> RatesData = FXCollections.observableArrayList();

	CalculatorModel calModel = new CalculatorModel();
	String selected1;
	String selected2;
	String selected3;
	String selected4;
	String selected5;
    String selected6;
    String selected7;
	Alert alert = new Alert(AlertType.ERROR);

	private static void loadData() {
		try (BufferedReader bf = new BufferedReader(new FileReader("./rates.csv"))) {
			String line = bf.readLine();
			line = bf.readLine();
			while (line != null) {
				String[] s = line.split(";");
				Records record = new Records(s[0], s[1], s[2], s[3], s[4], s[5]);
				RatesData.add(record);
				line = bf.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Launching application.");
		launch(args);
	}

	public void init() {
		System.out.println("Initializing....");
		loadData();
	}

	@Override
	public void start(Stage myStage) throws Exception {
		System.out.println("Application starts.");
		myStage.setTitle("Rates Calculator");
		FlowPane rootNode = new FlowPane(Orientation.VERTICAL);
		ObservableList<String> options = FXCollections.observableArrayList("EUR", "USD", "GBP", "CHF", "CNY");
		// SEK to other currency
		
		GridPane convert1 = new GridPane();
		TextField number1 = new TextField();
		Label sek1 = new Label("SEK = ");
		Label result1 = new Label("     ");
		
		final ComboBox<String> currencyComboBox1 = new ComboBox<String>(options);

		currencyComboBox1.setPromptText("Currency");
		currencyComboBox1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				selected1 = currencyComboBox1.getSelectionModel().getSelectedItem().toString();
			}
		});

		Button calculate1 = new Button("Calculate");
		calculate1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			  try{
				BigDecimal decimal = new BigDecimal(number1.getText());
				// System.out.println(number1.getText());
				if (selected1.equals("EUR")) {
					result1.setText(decimal.multiply(RatesData.get(0).getSektoeuro()).toString());
				}
				if (selected1.equals("USD")) {
					result1.setText(decimal.multiply(RatesData.get(0).getSektousd()).toString());
				}
				if (selected1.equals("GBP")) {
					result1.setText(decimal.multiply(RatesData.get(0).getSektogbp()).toString());
				}
				if (selected1.equals("CHF")) {
					result1.setText(decimal.multiply(RatesData.get(0).getSektochf()).toString());
				}
				if (selected1.equals("CNY")) {
					result1.setText(decimal.multiply(RatesData.get(0).getSektocny()).toString());
				}
			  }catch(NumberFormatException e){
				  alert("Error: Please input a number!");
			  }catch(NullPointerException e){
				  alert("Please choose a currency");
			  }

			}
		});
		GridPane.setConstraints(number1, 0, 0);
		GridPane.setConstraints(sek1, 1, 0);
		GridPane.setConstraints(result1, 2, 0);
		GridPane.setConstraints(currencyComboBox1, 3, 0);
		GridPane.setConstraints(calculate1, 0, 1);
		convert1.getChildren().addAll(number1, sek1, result1, currencyComboBox1, calculate1);

		// other currency to SEK
		GridPane convert2 = new GridPane();
		TextField number2 = new TextField();
		Label equalto = new Label(" = ");
		Label sek2 = new Label("SEK");
		Label result2 = new Label("     ");

		final ComboBox<String> currencyComboBox2 = new ComboBox<String>(options);

		currencyComboBox2.setPromptText("Currency");
		currencyComboBox2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				selected2 = currencyComboBox2.getSelectionModel().getSelectedItem().toString();
			}
		});

		Button calculate2 = new Button("Calculate");
		calculate2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			 try{
				BigDecimal decimal = new BigDecimal(number2.getText());
				// System.out.println(RatesData.get(0).getDate());
				if (selected2.equals("EUR")) {
					result2.setText(decimal.multiply(RatesData.get(0).getEurotosek()).toString());
				}
				if (selected2.equals("USD")) {
					result2.setText(decimal.multiply(RatesData.get(0).getUsdtosek()).toString());
				}
				if (selected2.equals("GBP")) {
					result2.setText(decimal.multiply(RatesData.get(0).getGbptosek()).toString());
				}
				if (selected2.equals("CHF")) {
					result2.setText(decimal.multiply(RatesData.get(0).getChftosek()).toString());
				}
				if (selected2.equals("CNY")) {
					result2.setText(decimal.multiply(RatesData.get(0).getCnytosek()).toString());
				}
			  }catch(NumberFormatException e){
            	  alert("Error:Please input a number!");
              }catch(NullPointerException e){
				  alert("Please choose a currency");
			  }
              
			}
		});

		GridPane.setConstraints(number2, 0, 0);
		GridPane.setConstraints(currencyComboBox2, 1, 0);
		GridPane.setConstraints(equalto, 2, 0);
		GridPane.setConstraints(result2, 3, 0);
		GridPane.setConstraints(sek2, 4, 0);
		GridPane.setConstraints(calculate2, 0, 1);
		convert2.getChildren().addAll(number2, currencyComboBox2, equalto, result2, sek2, calculate2);

		// year average,highest,lowest
		GridPane yearpane = new GridPane();
		Label yearaverage = new Label("Year Average:");
		Label yearaverageresult = new Label("");
		Label yearhigh = new Label("Highest:");
		Label yearhighresult = new Label("");
		Label yearlow = new Label("Lowest:");
		Label yearlowresult = new Label("");
		Label inputyear = new Label("Please input the year:");
		TextField inputyearfield = new TextField("2015");
		inputyearfield.setPrefWidth(80);
		final ComboBox<String> currencycombobox3 = new ComboBox<String>(options);
		currencycombobox3.setPromptText("Currency");
		currencycombobox3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				selected3 = currencycombobox3.getSelectionModel().getSelectedItem().toString();
			}
		});

		Button calculate3 = new Button("Calculate");
		calculate3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				int year = 2015;
				try{
					year=Integer.parseInt(inputyearfield.getText());
				}catch(NumberFormatException e){
					alert("Error: Please input a number!");
				}
				// System.out.println(RatesData.get(0).getDate());
				try{
				  yearaverageresult.setText(calModel.getYearAverage(selected3, year).toString());
                  yearhighresult.setText(calModel.getYearHigh(selected3, year).toString());
                  yearlowresult.setText(calModel.getYearLow(selected3, year).toString());
				}catch(ArithmeticException e){
					alert("Exception: The given year or month is not in data.");
				}catch(NullPointerException e){
					  alert("Please choose a currency");
				}
                //yearhighresult.setTextFill(value);
			}
		});

		GridPane.setConstraints(yearaverage, 0, 0);
		GridPane.setConstraints(yearaverageresult, 1, 0);
		GridPane.setConstraints(yearhigh, 2, 0);
		GridPane.setConstraints(yearhighresult, 3, 0);
		GridPane.setConstraints(yearlow, 4, 0);
		GridPane.setConstraints(yearlowresult, 5, 0);

		GridPane.setConstraints(inputyear, 0, 1);
		GridPane.setConstraints(inputyearfield, 1, 1);
		GridPane.setConstraints(currencycombobox3, 3, 1);
		GridPane.setConstraints(calculate3, 0, 2);
		yearpane.getChildren().addAll(yearaverage, yearaverageresult, yearhigh,yearhighresult,yearlow,yearlowresult,
				inputyear, inputyearfield, currencycombobox3,calculate3);

		// month average
		GridPane monthpane = new GridPane();
		Label monthaverage = new Label("Month Average:");
		Label monthaverageresult = new Label("");
		Label monthhigh = new Label("Highest:");
		Label monthhighresult = new Label("");
		Label monthlow = new Label("Lowest:");
		Label monthlowresult = new Label("");
		Label inputyear1 = new Label("Please input the year:");
		TextField inputyearfield1 = new TextField("2015");
		inputyearfield1.setPrefWidth(80);
		Label inputmonth = new Label("Please input the month:");
		//TextField inputmonthfield = new TextField(String.valueOf(LocalDate.now().getMonthValue()));
		TextField inputmonthfield = new TextField("11");
		inputmonthfield.setPrefWidth(80);
		final ComboBox<String> currencycombobox4 = new ComboBox<String>(options);
		currencycombobox4.setPromptText("Currency");
		currencycombobox4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// System.out.println(RatesData.get(0).getDate());
				selected4 = currencycombobox4.getSelectionModel().getSelectedItem().toString();

			}
		});

		Button calculate4 = new Button("Calculate");
		calculate4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				int year = 2015;
			    int month = 11;
				try{
				  year = Integer.parseInt(inputyearfield1.getText());
				  month = Integer.parseInt(inputmonthfield.getText());
				}catch(Exception e){
					alert("Error: Please input a number");
				}
				// System.out.println(RatesData.get(0).getDate());
				try{
				  monthaverageresult.setText(calModel.getMonthAverage(selected4, year, month).toString());
                  monthhighresult.setText(calModel.getMonthHigh(selected4, year, month).toString());
                  monthlowresult.setText(calModel.getMonthLow(selected4, year, month).toString());
				}catch(ArithmeticException e){
					alert("Exception: The given year or month is not in data");
				}catch(NullPointerException e){
					  alert("Please choose a currency");
			    }
			}
		});

		GridPane.setConstraints(monthaverage, 0, 0);
		GridPane.setConstraints(monthaverageresult, 1, 0);
		GridPane.setConstraints(monthhigh, 2, 0);
		GridPane.setConstraints(monthhighresult, 3, 0);
		GridPane.setConstraints(monthlow, 4, 0);
		GridPane.setConstraints(monthlowresult, 5, 0);

		GridPane.setConstraints(inputyear1, 0, 1);
		GridPane.setConstraints(inputyearfield1, 1, 1);
		GridPane.setConstraints(inputmonth, 0, 2);
		GridPane.setConstraints(inputmonthfield, 1, 2);
		GridPane.setConstraints(currencycombobox4, 3, 1);
		GridPane.setConstraints(calculate4, 0, 3);
		monthpane.getChildren().addAll(monthaverage, monthaverageresult,monthhigh,monthhighresult,monthlow,
				monthlowresult,inputyear1, inputyearfield1, inputmonth,inputmonthfield, currencycombobox4, calculate4);
		
		//period average
		GridPane periodpane = new GridPane();
		Label periodaverage = new Label("Period Average:");
		Label periodaverageresult = new Label("");
		Label periodhigh = new Label("Highest:");
		Label periodhighresult = new Label("");
		Label periodlow = new Label("Lowest:");
		Label periodlowresult = new Label("");
		Label inputperiod1 = new Label("Please input the first date:");
		TextField inputperiodfield1 = new TextField("2015-11-30");
		inputperiodfield1.setPrefWidth(100);
		Label inputperiod2 = new Label("Please input the last date:");
		TextField inputperiodfield2 = new TextField("2015-11-30");
		inputperiodfield2.setPrefWidth(100);
		final ComboBox<String> currencycombobox5 = new ComboBox<String>(options);
		currencycombobox5.setPromptText("Currency");
		currencycombobox5.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// System.out.println(RatesData.get(0).getDate());
				selected5 = currencycombobox5.getSelectionModel().getSelectedItem().toString();

			}
		});

		Button calculate5 = new Button("Calculate");
		calculate5.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String from = inputperiodfield1.getText();
				String to = inputperiodfield2.getText();
				try{
				  LocalDate fromdate = LocalDate.parse(from);
				  LocalDate todate = LocalDate.parse(to);
				  if (fromdate.isAfter(todate)){ 
					  alert("Error:The first date is after the last date.");
					  periodaverageresult.setText("");
					  periodhighresult.setText("");
					  periodlowresult.setText("");
				  }
				  else{
				    periodaverageresult.setText(calModel.getAverage(selected5,fromdate ,todate).toString());
                    periodhighresult.setText(calModel.getHighMark(selected5, fromdate, todate).toString());
			        periodlowresult.setText(calModel.getLowMark(selected5, fromdate, todate).toString());
				  }
				}catch(DateTimeException e){
					alert("Error: Invalid date.");
				}catch(NullPointerException e){
					  alert("Please choose a currency");
				}
			}
		});

		GridPane.setConstraints(periodaverage, 0, 0);
		GridPane.setConstraints(periodaverageresult, 1, 0);
		GridPane.setConstraints(periodhigh, 2, 0);
		GridPane.setConstraints(periodhighresult, 3, 0);
		GridPane.setConstraints(periodlow, 4, 0);
		GridPane.setConstraints(periodlowresult, 5, 0);

		GridPane.setConstraints(inputperiod1, 0, 1);
		GridPane.setConstraints(inputperiodfield1, 1, 1);
		GridPane.setConstraints(inputperiod2, 0, 2);
		GridPane.setConstraints(inputperiodfield2, 1, 2);
		GridPane.setConstraints(currencycombobox5, 3, 1);
		GridPane.setConstraints(calculate5, 0, 3);
		periodpane.getChildren().addAll(periodaverage, periodaverageresult,periodhigh,periodhighresult,periodlow,periodlowresult,inputperiod1, inputperiodfield1,
				inputperiod2, inputperiodfield2, currencycombobox5, calculate5);
		
		//find the biggest difference 2 days and period
		GridPane diffpane = new GridPane();
		Label twodaysdiff = new Label("2 Days max difference:");
		Label twodaysresult = new Label("");
		Label periodsdiff = new Label("Period's max difference:");
		Label periodsresult = new Label("");
		
		Label inputperiod3 = new Label("Input the first date:");
		TextField inputperiodfield3 = new TextField("2015-11-30");
		inputperiodfield3.setPrefWidth(100);
		Label inputperiod4 = new Label("Input the last date:");
		TextField inputperiodfield4 = new TextField("2015-11-30");
		inputperiodfield4.setPrefWidth(100);
		

		Button calculate6 = new Button("Calculate");
		calculate6.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String from = inputperiodfield3.getText();
				String to = inputperiodfield4.getText();
				try{
				  LocalDate fromdate = LocalDate.parse(from);
				  LocalDate todate = LocalDate.parse(to);
				  if (fromdate.isAfter(todate)){ 
					  alert("Error:The first date is after the last date.");
					  twodaysresult.setText("");
					  periodsresult.setText("");
				  }
				  else{
				    twodaysresult.setText(calModel.getMaxDeltaCurrency(fromdate ,todate).toString());
                    periodsresult.setText(calModel.getMaxVolatilityCurrency(fromdate, todate).toString());
				  }
				}catch(DateTimeException e){
					alert("Error: Invalid date.");
				}
			}
		});

		GridPane.setConstraints(twodaysdiff, 0, 0);
		GridPane.setConstraints(twodaysresult, 1, 0);
		GridPane.setConstraints(periodsdiff, 2, 0);
		GridPane.setConstraints(periodsresult, 3, 0);	

		GridPane.setConstraints(inputperiod3, 0, 1);
		GridPane.setConstraints(inputperiodfield3, 1, 1);
		GridPane.setConstraints(inputperiod4, 2, 1);
		GridPane.setConstraints(inputperiodfield4, 3, 1);
		GridPane.setConstraints(calculate6, 0, 3);
		diffpane.getChildren().addAll(twodaysdiff, twodaysresult,periodsdiff,periodsresult,inputperiod3, inputperiodfield3,
				inputperiod4, inputperiodfield4, calculate6);
		
		//weekday's average
		GridPane dayspane = new GridPane();
		Label daysaverage = new Label("Weekday's Average:");
		Label daysaverageresult = new Label("");
		Label inputperiod5 = new Label("Input the first date:");
		TextField inputperiodfield5 = new TextField("2015-11-30");
		inputperiodfield5.setPrefWidth(100);
		Label inputperiod6 = new Label("Input the last date:");
		TextField inputperiodfield6 = new TextField("2015-11-30");
		inputperiodfield6.setPrefWidth(100);
		Label selectday = new Label("Choose a day:");
		Label selectcurr = new Label("Choose a currency:");
		final ComboBox<String> currencycombobox6 = new ComboBox<String>(options);
		currencycombobox6.setPromptText("Currency");
		currencycombobox6.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// System.out.println(RatesData.get(0).getDate());
				selected6 = currencycombobox6.getSelectionModel().getSelectedItem().toString();

			}
		});
		ObservableList<String> dayoptions = 
			    FXCollections.observableArrayList(
			        "Monday",
			        "Tuesday",
			        "Wednesday","Thursday","Friday","Saturday","Sunday"
			    );
		final ComboBox<String> weekdaycombobox = new ComboBox<String>(dayoptions);
		weekdaycombobox.setPromptText("DayOfWeek");
		weekdaycombobox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// System.out.println(RatesData.get(0).getDate());
				selected7 = weekdaycombobox.getSelectionModel().getSelectedItem().toString();

			}
		});

		Button calculate7 = new Button("Calculate");
		calculate7.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String from = inputperiodfield5.getText();
				String to = inputperiodfield6.getText();
				try{
				  LocalDate fromdate = LocalDate.parse(from);
				  LocalDate todate = LocalDate.parse(to);
				  DayOfWeek weekday = null;
					switch (selected7) {
					case "Monday":
						weekday = DayOfWeek.MONDAY;
						break;
					case "Tuesday":
						weekday = DayOfWeek.TUESDAY;
						break;
					case "Wednesday":
						weekday = DayOfWeek.WEDNESDAY;
						break;
					case "Thursday":
						weekday = DayOfWeek.THURSDAY;
						break;
					case "Friday":
						weekday = DayOfWeek.FRIDAY;
						break;
					case "Saturday":
						weekday = DayOfWeek.SATURDAY;
						break;
					case "Sunday":
						weekday = DayOfWeek.SUNDAY;
						break;
				  
				  }
				  if (fromdate.isAfter(todate)){ 
					  alert("Error:The first date is after the last date.");
					  daysaverageresult.setText("");
					  
				  }
				  else{
					try{
				      daysaverageresult.setText(calModel.getAverage(selected6, fromdate, todate, weekday).toString());
					}catch(ArithmeticException e){
						alert("There is no selected week day in given period.");
					}
				  }
				}catch(DateTimeException e){
					alert("Error: Invalid date.");
				}catch(NullPointerException e){
                    if (selected7!=null)
					  alert("Please choose a currency");
                    else alert("Please choose a day");
				}
			}
		});

		GridPane.setConstraints(daysaverage, 0, 0);
		GridPane.setConstraints(daysaverageresult, 1, 0);

		GridPane.setConstraints(inputperiod5, 0, 1);
		GridPane.setConstraints(inputperiodfield5, 1, 1);
		GridPane.setConstraints(inputperiod6, 0, 2);
		GridPane.setConstraints(inputperiodfield6, 1, 2);
		GridPane.setConstraints(selectday, 3, 1);
		GridPane.setConstraints(weekdaycombobox, 4, 1);
		GridPane.setConstraints(selectcurr, 3, 2);
		GridPane.setConstraints(currencycombobox6, 4, 2);
		GridPane.setConstraints(calculate7, 0, 3);
		dayspane.getChildren().addAll(daysaverage, daysaverageresult,inputperiod5, inputperiodfield5,
				inputperiod6, inputperiodfield6, selectday,weekdaycombobox,selectcurr,currencycombobox6, calculate7);
		
		
		rootNode.getChildren().addAll(convert1,convert2,yearpane, monthpane,periodpane,diffpane,dayspane);
		rootNode.setVgap(20);
	    

		Scene myScene = new Scene(rootNode, 600, 800);
       
		// Set the scene on the stage.
		myStage.setScene(myScene);
		// Show the stage and its scene.
		myStage.show();

	}

	private void alert(String s){
		alert.setContentText(s);
		alert.showAndWait();
	}
}
