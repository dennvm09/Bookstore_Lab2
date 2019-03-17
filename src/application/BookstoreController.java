package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BookstoreController {
	
	
	@FXML
	private TabPane tabBookstore;
	@FXML
	private Tab tabBaseCase;
	@FXML
	private TextArea txtEntrada;
	@FXML
	private TextArea txtSalida;
	@FXML
	private Button  btEjecutar;
	//////////////////////
	@FXML
	private Tab tabOtherCase;
	@FXML
	private TextField txtCashiers;
	@FXML
	private TextField txtStands;
	@FXML
	private Label lblStand;
	@FXML
	private Label lblBook;
	@FXML
	private TextField txtISBN;
	@FXML
	private TextField txtPrice;
	@FXML
	private TextField txtQuantity;
	@FXML
	private Button btSave;
	@FXML
	private Button btRegister;
	/////////////////////
	
	private int qBooks = 1;
	private int books = 0;
	private int qStands = 1;
	private int stands = 0;
	
	private String resultado;
	
	
	
	
	
	public void init() {}
	
	@FXML
	public void sendBaseCase(ActionEvent e) {
		
		String casoBase = txtEntrada.getText();
		String ruta = "src/files/baseCase.txt";
		File archivo = new File(ruta);
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
			bw.write(casoBase);
			bw.close();
		} catch (IOException m) {
			// TODO Auto-generated catch block
			m.printStackTrace();
		}
		txtSalida.setText("Hola, ya funciona.");
	}
	
	
	
	public void process1(ActionEvent e) {
		
		String idStand = JOptionPane.showInputDialog(null, "Ingrese el ID del stand: ");
		lblStand.setText(idStand);
		books = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de libros: "));
		lblBook.setText(String.valueOf(qBooks));
		
	}
	
	
	public void preguntar() {
		String idStand = JOptionPane.showInputDialog(null, "Ingrese el ID del stand: ");
		lblStand.setText(idStand);
		books = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de libros: "));
		lblBook.setText(String.valueOf(qBooks));
		
		btRegister.setDisable(false);
	}
	
	
	public void auxProcess1(ActionEvent e) {
		qStands = Integer.parseInt(txtStands.getText());
		
		while(qStands < stands) {
				preguntar();
				stands++;
		}
		
		if(qStands > stands) {
			System.out.println("Se han registrado todas las estanterías.");
		}
		
	}
	
	public void process2(ActionEvent e) {
		if(qBooks < books) {
			qBooks++;
			lblBook.setText(String.valueOf(qBooks));
			System.out.println(qBooks);
		}else {
			System.out.println("Stands 1: "+stands);
			System.out.println("Voy a deshabilitar");

			btRegister.setDisable(true);
			
//			stands++;
			System.out.println("Deshabilito el botón.");
			System.out.println("qStands vale: "+qStands);
			System.out.println("Stands: "+stands);
			
			if(stands <= qStands) {
				stands++;
				qBooks = 1;
				books = 0;
				System.out.println("Voy a preguntar again.");
				preguntar();
			}
			
			
			if(stands > qStands) {
				System.out.println("Se han registrado todas las estanterías.");
			}
			
			System.out.println("Caso stand: "+stands+1);

			
			 
		}
	}

	 
	
}
