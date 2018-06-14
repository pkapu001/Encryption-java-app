



import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public  class Main extends Application{

	
		public static Stage window = new Stage();
		@Override
		public void start(Stage primaryStage) throws Exception {
			Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
			//root.minHeight(width)
			window=primaryStage;
			Scene scene = new Scene(root, 1200, 370);
			scene.setFill(Color.TRANSPARENT);
			scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.setScene(scene);
			//primaryStage.setResizable(false);
			primaryStage.setTitle("ENCRIPT OR DECRIPT");
			
			primaryStage.setMinWidth(1200);
			primaryStage.setMinHeight(364);
			
			primaryStage.show();
			//System.out.println(primaryStage.getWidth() +"  "+primaryStage.getHeight());
			
			String s = " ---- .--- | -.-- \n.- abc ";
			//s.replace("|", " ");
			//s.replace("\n, newChar)
			String[] ss= s.split(" ");
			for(String temp : ss)
			{
			//	System.out.println( temp.equals("\n") + temp +"  " + temp.charAt(1));
			}
			
		}
		
		public static void main(String[] args) throws FileNotFoundException {
			//System.out.println(decription.n_l("010203"));
			Application.launch(args);
			
			

		}
		
}
