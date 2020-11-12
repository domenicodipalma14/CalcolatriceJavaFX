/**
 * Sample Skeleton for 'form.fxml' Controller Class
 */

package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.*;

public class SampleController {
	private double op1 = 0;
	
	final String err = "ERRORE";

	@FXML
	private Button btn0;
	@FXML
	private Button btn1;
	@FXML
	private Button btn2;
	@FXML
	private Button btn3;
	@FXML
	private Button btn4;
	@FXML
	private Button btn5;
	@FXML
	private Button btn6;
	@FXML
	private Button btn7;
	@FXML
	private Button btn8;
	@FXML
	private Button btn9;
	@FXML
	private Button btnPiu;
	@FXML
	private Button btnMeno;
	@FXML
	private Button btnDiviso;
	@FXML
	private Button btnPer;
	@FXML
	private Button btnCalcola;
	@FXML
	private Button btnVirgola;
	@FXML
	private Label label1;
	
	@FXML
	private Button btnCanc;
	
	private String num1="";
	private String num2="";
	private String operazione="";
	private String tot="";
	private String str ="";
	@FXML
	 private void gestoreEvento(ActionEvent e){
		if(e.getSource() == btn0) inserisciNumero("0");
		else if(e.getSource() == btn1) inserisciNumero("1");
		else if(e.getSource() == btn2) inserisciNumero("2");
		else if(e.getSource() == btn3) inserisciNumero("3");
		else if(e.getSource() == btn4) inserisciNumero("4");
		else if(e.getSource() == btn5) inserisciNumero("5");
		else if(e.getSource() == btn6) inserisciNumero("6");
		else if(e.getSource() == btn7) inserisciNumero("7");
		else if(e.getSource() == btn8) inserisciNumero("8");
		else if(e.getSource() == btn9) inserisciNumero("9");
		else if(e.getSource() == btnVirgola) inserisciNumero(",");
		else if(e.getSource() == btnPiu) inserisciOperazione("+");
		else if(e.getSource() == btnMeno) inserisciOperazione("-");
		else if(e.getSource() == btnPer) inserisciOperazione("*");
		else if(e.getSource() == btnDiviso) inserisciOperazione("/");
	}
	
	@FXML
	void calButton(ActionEvent event){
		if(num2.length()!=0 && tot.length()==0){
			
			calcolaRisultato();
		}
		else if(tot.length() != 0){
			op1 = Double.parseDouble(tot);
			calcolaRisultato();
		}
		else label1.setText("INSERIRE PRIMA NUMERI");
		num2 = "";
		operazione = "";
	}
	
	private void checkNum1(String c){
		if(num1.length() == 0){
			if(c.equals(",")) label1.setText("Inserire numero!");
			else {
				num1 = c;
				str = num1;
				label1.setText(str);
				}
		}
		else{
			num1 += c;
			str = num1;
			label1.setText(str);
		}
	}
	
	private void checkNum2(String c){
		if(num2.length()==0){
			if(c.equals(",")) label1.setText(str + "Inserire numero!");
			else{
				num2 = c;
				str +=num2;
				label1.setText(str);
			}
		}
		else {
			num2 += c;
			str = num1 + operazione + num2;
			label1.setText(str);
		}
	}
	private void inserisciNumero(String c){
		if(operazione.length() == 0){
			checkNum1(c);
		}
		else{
			checkNum2(c);
		}
	}
	
	private void inserisciOperazione(String o){
		if(operazione.length() == 0 && str.length()!=0){
			operazione = " " + o + " ";
			str += operazione;
			label1.setText(str);
		}
		else label1.setText(err);
	}
	
	private void calcolaRisultato(){
		StringTokenizer token;
		double op2 = 0;
		double ris = 0;
		int i=0;
		int num=0;
		token =  new StringTokenizer(str, " ");
		num = token.countTokens();
		String arrayToken[];
		arrayToken = new String[num];
		while (token.hasMoreTokens())
		{
			arrayToken[i] = token.nextToken();
		    i++;
		}
		
		op1 = Double.parseDouble(arrayToken[0]);
		op2 = Double.parseDouble(arrayToken[2]);
		
		switch(arrayToken[1]){
		case "+": 
			ris = op1 + op2;
			tot = Double.toString(ris);
			label1.setText(tot);
			break;
		case "-":
			ris = op1 - op2;
			tot = Double.toString(ris);
			label1.setText(tot);
			break;
		case "*":
			ris = op1 * op2;
			tot = Double.toString(ris);
			label1.setText(tot);
			break;
		case "/":
			if(op2 == 0){
				label1.setText(err);
			}
			else {
				ris = op1 / op2;
				tot = Double.toString(ris);
				label1.setText(tot);
			}
			break;
		default: 
			label1.setText(err);
			break;
		}
		
		str = tot;
		num1 = tot;
	}
	
	@FXML
	void cancellaButton(ActionEvent event){
		if(str.length() == 0) {
			label1.setText(err);
			str = "";
			num1 = "";
			num2 = "";
			tot = "";
			operazione = "";
		}
		else {
			int l;
			l = str.length();
			str = removeCharAt(str, l-1);
			label1.setText(str);
			
		}
	}
	
	private  String removeCharAt(String s, int pos) {
		char spazio;
		spazio = s.charAt(pos);
		if(spazio == ' '){
			s = s.substring(0,pos-2);
			operazione = "";
			num2="";
			return s;
		}
		return s.substring(0, pos) + s.substring(pos + 1);
	}
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	btn0.setOnAction(this::gestoreEvento);
    	btn1.setOnAction(this::gestoreEvento);
    	btn2.setOnAction(this::gestoreEvento);
    	btn3.setOnAction(this::gestoreEvento);
    	btn4.setOnAction(this::gestoreEvento);
    	btn5.setOnAction(this::gestoreEvento);
    	btn6.setOnAction(this::gestoreEvento);
    	btn7.setOnAction(this::gestoreEvento);
    	btn8.setOnAction(this::gestoreEvento);
    	btn9.setOnAction(this::gestoreEvento);
    	btn0.setOnAction(this::gestoreEvento);
    	btnVirgola.setOnAction(this::gestoreEvento);
    	btnPiu.setOnAction(this::gestoreEvento);
    	btnMeno.setOnAction(this::gestoreEvento);
    	btnPer.setOnAction(this::gestoreEvento);
    	btnDiviso.setOnAction(this::gestoreEvento);
    	btnCanc.setOnAction(this::cancellaButton);
    	btnCalcola.setOnAction(this::calButton);
    	label1.setText("");
    }
}