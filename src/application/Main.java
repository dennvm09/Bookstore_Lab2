package application;
	
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;

import hash_Linny.HashTableLinny;
import javafx.application.Application;
import javafx.stage.Stage;
import list_Linny.LinnyNodo;
import model.Book;
import model.BookStore;
import model.Shelves;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	
	private static BookStore bookStore;
	
	public Main() {
		bookStore = new BookStore("Bookstore");
	}
	
	public static BookStore getBookStore() {
		return bookStore;
	}
	
	
	
	
	
	public static void mostrarCasoBase() {
		
		File archivo = new File("src/files/baseCase.txt");
		int lineas = 0;
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			
			String linea;
			
			int casos = Integer.parseInt(br.readLine());
			int cajeros = 0; 
			int stands = 0;
			
			
			System.out.println(casos);
			while((linea = br.readLine()) != null) {
				lineas++;
				System.out.println(linea);
				
				if(lineas > 3) {
					System.out.println("Entré a la condición");
					String[] stand = linea.split(" ");
					
					String id = stand[0];
					int cantidad = Integer.parseInt(stand[1]);
					
					bookStore.getShelves().setFirstNodo(new LinnyNodo<Shelves>(new Shelves(id.charAt(0))));
					
					for(int i = 0; i < cantidad; i++) {
					
						System.out.println("Entré al for");
						String[] book = linea.split(" ");
						
						int isbn = Integer.parseInt(book[0]);
						double price = Double.parseDouble(book[1]);
						int quantity = Integer.parseInt(book[2]);
						
						 bookStore.getShelves().setFirstNodo(new LinnyNodo<Shelves>(new Shelves(id.charAt(0))));
						
						Shelves s = bookStore.getShelves().getFirstNodo().getInfo();
						
						
//						HashTableLinny<Integer, Book> h = null;
//						h.insert(isbn, new Book(isbn, quantity, price, id.charAt(0)));
						
						s.getBooks().insert(isbn, new Book(isbn, quantity, price, id.charAt(0)));
						
						System.out.println("Inserté el libro");
						
						System.out.println("Libro 1 agregado: hay "+s.getBooks().search(331).getValue().getQuantity());
						
						
						
					}

				}
			}
			
			
			
			
			/**System.out.println("Entré al while");
			cajeros = Integer.parseInt(br.readLine());
			stands = Integer.parseInt(br.readLine());
			System.out.println("Casos : "+casos);
			System.out.println("Cajeros : "+cajeros);
			System.out.println("Stands : "+stands);
			
			for(int i = 0; i < casos; i++) {
				
				System.out.println("Entré al for");
				
			}*/
			
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	public static void casoBase() {
		int lineas = 0;
		int cases = 0;
		int cashiers = 0;
		int stands = 0;
		
		
		
		File archivo = new File("src/files/baseCase.txt");
		
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			
			String linea = null;
			
			
			String[] book = linea.split(" ");
			cases = Integer.parseInt(br.readLine());
			System.out.println("casos : "+cases);
			
			while((linea = br.readLine()) != null) {
				
				
				
			}
			
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void totalCashiers(int cashiers) {
		
	}
	
	public static void totalStands() {}
	
	
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			TabPane root = (TabPane)FXMLLoader.load(getClass().getResource("Bookstore.fxml"));
			root.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
