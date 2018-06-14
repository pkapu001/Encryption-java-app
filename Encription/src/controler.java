import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sun.glass.ui.Window;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class controler implements Initializable {

	String code="";
	String error = "";
	ArrayList<morse> mkey = new ArrayList<>();
	String regex= "[0-9\\s]+";
	int key=0;
	boolean started = false;
	
	@FXML
	private Button close ;
	
	@FXML
	private Button min ;
	
	@FXML
	private Button max ;
	
	@FXML
	private Button e_m_b;
	
	@FXML
	private Button d_m_b;
	
	@FXML
	private HBox titlebar ;
	
	@FXML
    private Label error_tb;
	
    @FXML
    private TextArea msg_tb;

    @FXML
    private TextArea n_msg_tb;

    @FXML
    private Button reset_b;
    
    @FXML
    private Button e_nl_b;

    @FXML
    private Button e_at_b;
    
    @FXML
    private Button e_c_b;    

    @FXML
    private Button d_nl_b;

    @FXML
    private Button d_at_b;
    
    @FXML
    private Button d_c_b;
    
    @FXML
    private Button info;
    
    @FXML
    private RadioButton er;
    
    @FXML
    private RadioButton dr;
    
    @FXML
    private ToggleGroup group1;

    @FXML
    private AnchorPane ebox;
    
    @FXML
    private AnchorPane mainbox;

    @FXML
    private AnchorPane dbox;
    
    @FXML
    private AnchorPane ibox;
    
    @FXML
    private TextField e_key_tb ;

    @FXML
    private TextField d_key_tb;
    
    @FXML
    void close_action(ActionEvent event) {
    	System.exit(0);
    	System.out.println("shuld close");
    }
    
    @FXML
    void min_action(ActionEvent event) {
    	Main.window.setIconified(true);
    	
    }
    
    Boolean ismax=false;
    Double xoffset,yoffset;
    @FXML
    void max_action(ActionEvent event) {
    	if (ismax==false) {
    		xoffset=Main.window.getX();
			yoffset=Main.window.getY();
    		Main.window.setMaximized(true);
		
			System.out.println(Main.window.getX()+ "  "+Main.window.getY());
			ismax=true;
		} else {
			Main.window.setWidth(1200);
			Main.window.setHeight(325);
			Main.window.setX(xoffset);
			Main.window.setY(yoffset);
			System.out.println(Main.window.getX()+ "  "+Main.window.getY());
			ismax=false;
		}
    	
    	
    	
    }
    
    @FXML
    void hold(MouseEvent event) {
    	
    	xoffset=Main.window.getX() - event.getScreenX();
		yoffset=Main.window.getY() - event.getScreenY();
		titlebar.setCursor(Cursor.CLOSED_HAND);

    }
    @FXML
    void release(MouseEvent event) {
    	titlebar.setCursor(Cursor.DEFAULT);
    }
    
    @FXML
    void move(MouseEvent event) {
    	Main.window.setX(event.getScreenX() +xoffset);
    	Main.window.setY(event.getScreenY() + yoffset);
    	

    }

    
    @FXML
    void close_info(MouseEvent event) {
    		ibox.setVisible(false);
    		ibox.setDisable(true);
    		mainbox.setEffect(null);
    }
    
    @FXML
    void open_info(MouseEvent event) {
    		ibox.setVisible(true);
    		ibox.setDisable(false);
    		mainbox.setEffect(new GaussianBlur(55));
    }
    
    
    @FXML
    void e_m(ActionEvent event) {
    	if(!code.equals("")) {
        	code=morse.e_morse(code, mkey);
        	n_msg_tb.setText(code);
        	started=true;
        	msg_tb.setDisable(true);
        	e_m_b.setDisable(true);
        	d_m_b.setDisable(false);

        	}
    	
    }
    
    @FXML
    void d_m(ActionEvent event) {
    	if(!code.equals("")) {
        	code=morse.d_morse(code, mkey);
        	n_msg_tb.setText(code);
        	started=true;
        	msg_tb.setDisable(true);
        	d_m_b.setDisable(true);
        	e_m_b.setDisable(false);
        	}
    	
    }
    
    @FXML
    void d_nl(ActionEvent event) {
    	if(!code.equals("")&& code.matches(regex) ) {  
    	code=decription.n_l(code);
    	n_msg_tb.setText(code);
    	started=true;
    	msg_tb.setDisable(true);
    	}
    }

    @FXML
    void d_at(ActionEvent event) {
    	System.out.println("dat");
    	if(!code.equals("")) {
    	code=encription.atbash(code);
    	n_msg_tb.setText(code);
    	started=true;
    	msg_tb.setDisable(true);
    	}
    }

    @FXML
    void d_c(ActionEvent event) {
    	if(!code.equals("")) {
    	code=decription.ceasar(key, code);
    	n_msg_tb.setText(code);
    	started=true;
    	msg_tb.setDisable(true);
    	}
    }

    @FXML
    void d_c_key_tb(ActionEvent event) {
    	if(!code.equals("")){
    	code=decription.ceasar(key, code);
    	n_msg_tb.setText(code);
    	started=true;
    	msg_tb.setDisable(true);
    	}
    }

    @FXML
    void dr_action(ActionEvent event) {
    	
    	ebox.setVisible(false);
    	ebox.setDisable(true);
    	
    	dbox.setDisable(false);
    	dbox.setVisible(true);

    }

    @FXML
    void e_at(ActionEvent event) {
    	if(!code.equals("")) {
    	code=encription.atbash(code);
    	n_msg_tb.setText(code);
    	started=true;
    	msg_tb.setDisable(true);
    	}
    }

    @FXML
    void e_c(ActionEvent event) {
    	if(!code.equals("")) {
    	code=encription.ceasar(key,code);
    	n_msg_tb.setText(code);
    	started=true;
    	msg_tb.setDisable(true);
    	}
    }

    @FXML
    void e_c_key_tb(ActionEvent event) {
    	if(!code.equals("")) {
    	code=encription.ceasar(key,code);
    	n_msg_tb.setText(code);
    	started=true;
    	msg_tb.setDisable(true);
    	}
    }

    @FXML
    void e_nl(ActionEvent event) {
    	if(!code.equals("")) {
    	code=encription.n_l(code);
    	n_msg_tb.setText(code);
    	started=true;
    	msg_tb.setDisable(true);
    	}
    }

    @FXML
    void er_action(ActionEvent event) {
    	ebox.setVisible(true);
    	ebox.setDisable(false);
    	
    	dbox.setDisable(true);
    	dbox.setVisible(false);
    }

    @FXML
    void reset(ActionEvent event) {
    	
    	er.setSelected(false);
    	dr.setSelected(false);
    	
    	code="";
    	msg_tb.clear();
    	msg_tb.setDisable(false);
    	n_msg_tb.clear();
    	ebox.setVisible(false);
    	ebox.setVisible(false);
    	e_c_b.setDisable(true);
    	d_c_b.setDisable(true);
    	started=false;
    	
    	

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		e_c_b.setDisable(true);
		
		error_tb.textProperty().bindBidirectional(new SimpleStringProperty(error));
		
		try {
			morse.load(mkey);
			//String temp=e_key_tb.getText();
			e_key_tb.textProperty().addListener((obs, oldText, newText) ->{ 
	           
				String regex = "\\d+";
				if(newText.matches(regex)&& Integer.parseInt(newText)>0 && Integer.parseInt(newText)<27 ) 
			{
								key=Integer.parseInt(newText);
								error = "";
								e_c_b.setDisable(false);		
				}else {
					e_c_b.setDisable(true);
					error="ERROR : Ceaser key should be number between 0 and 27";
					System.out.println(error);
					key=0;
				}
				error_tb.textProperty().bindBidirectional(new SimpleStringProperty(error));
			});
			
			d_key_tb.textProperty().addListener((obs, oldText, newText) ->{ 
		           // System.out.println("Text changed from "+ oldText +" to "+newText);
		            //n_msg_tb.setText(newText);
					String regex = "\\d+";
					if(newText.matches(regex)&& Integer.parseInt(newText)>0 && Integer.parseInt(newText)<27) {
									
										key=Integer.parseInt(newText);
										error = "";
										d_c_b.setDisable(false);
									
											
					}else {
						d_c_b.setDisable(true);
						error="ERROR : Ceaser key should be number between 0 and 27";
						key=0;
					}
					error_tb.textProperty().bindBidirectional(new SimpleStringProperty(error));
				});
			
			msg_tb.textProperty().addListener((obs, oldText, newText) ->{ 
				

					if(newText.equals("") && !started)
					{
						e_c_b.setDisable(true);
						e_nl_b.setDisable(true);
						e_at_b.setDisable(true);
						e_m_b.setDisable(true);
						
						d_c_b.setDisable(true);
						d_nl_b.setDisable(true);
						d_at_b.setDisable(true);
						d_m_b.setDisable(true);
					}else {
						e_c_b.setDisable(false);
						e_nl_b.setDisable(false);
						e_at_b.setDisable(false);
						e_m_b.setDisable(false);
						
						d_c_b.setDisable(false);
						d_nl_b.setDisable(false);
						d_at_b.setDisable(false);
						d_m_b.setDisable(false);
					}
		           
					if(!started)
						code=msg_tb.getText();

				});
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	 
		
	

}

