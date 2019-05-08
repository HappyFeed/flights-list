package ui;

import java.util.Comparator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;
import model.Flight;
import model.FlightComparator;
import model.FlightDestinyComparator;
import model.FlightGateComparator;
import model.ScreenFlights;

public class FligthsController {

	private ScreenFlights fligths;
    private Flight firstFlight;
    
    @FXML
    private Button lastPage;

    @FXML
    private Label page;

    @FXML
    private Label time;
    
    @FXML
    private Button nextPage;
	
	@FXML
    private TextField numberOfFlights;

    @FXML
    private Button search;

    @FXML
    private ComboBox<String> searchBy;

    @FXML
    private TextField data;

    @FXML
    private Button date;

    @FXML
    private Button airline;

    @FXML
    private Button flight;

    @FXML
    private Button destiny;

    @FXML
    private Button gate;

    @FXML
    private VBox dates;

    @FXML
    private VBox airlines;

    @FXML
    private VBox flies;

    @FXML
    private VBox destinies;

    @FXML
    private VBox gates;

    @FXML
    void generate(ActionEvent event) {
    	firstFlight=null;
    	clearData();
    	int num = 0;
    	long timeInit=System.currentTimeMillis();
    	try {
    		num = Integer.parseInt(numberOfFlights.getText());
    	}catch(NumberFormatException e) {
    		Alert info = new Alert(AlertType.ERROR);
        	info.setTitle("Flights");
        	info.setHeaderText(null);
        	info.initStyle(StageStyle.UTILITY);
        	info.setContentText("Thats not a number, please introude a number");
        	info.show();
        	
    	} 
    	fligths = new ScreenFlights();  	
    	for (int i = 0; i < num ; i++) {
    		Flight fl = new Flight(fligths.getRandomDate(), fligths.getRandomAirline(), fligths.getRandomCode(), fligths.getRandomDestiny(), fligths.randomChar());
    		if(firstFlight == null) {
    			firstFlight = fl;
    		}else {
    			Flight current = firstFlight;
    			while(current.getNextFlight() != null) {
    				current = current.getNextFlight();
    			}
    			current.setNextFlight(fl);
    			fl.setPreviousFlight(current);
    		}
		}   	
    	long timeFinal=System.currentTimeMillis()-timeInit;
    	time.setText("Time: "+timeFinal);
    	showTable();
    	search.setVisible(true);
    	searchBy.setVisible(true);
    	data.setVisible(true);
    }

    @FXML
    void orderByAirline(ActionEvent event) {
    	long timeInit=System.currentTimeMillis();
    	bubbleSort();
    	clearData();
    	showTable();
    	long timeFinal=System.currentTimeMillis()-timeInit;
    	time.setText("Time: "+timeFinal);
    }

    @FXML
    void orderByDate(ActionEvent event) {

    }
	public void bubbleSort() {
		if(firstFlight != null) {
			
			boolean changed = true;
			while(changed) {
				Flight currentNode = firstFlight;
				changed = false;
				//System.out.println("== NEW ITERATION A ==");
				while(currentNode.getNextFlight() != null) {
					Flight nextNode = currentNode.getNextFlight();
					//System.out.println(currentNode+" ? "+nextNode);
					if(currentNode.compareTo(nextNode)>0) {
						if(currentNode.getPreviousFlight()!=null) {
							currentNode.getPreviousFlight().setNextFlight(nextNode);
						}
						if(nextNode.getNextFlight()!=null) {
							nextNode.getNextFlight().setPreviousFlight(currentNode);
						}
						
						currentNode.setNextFlight(nextNode.getNextFlight());
						nextNode.setPreviousFlight(currentNode.getPreviousFlight());
						currentNode.setPreviousFlight(nextNode);
						nextNode.setNextFlight(currentNode);
						
						
						if(currentNode==firstFlight) {
							firstFlight = nextNode;
						}
						
						changed = true;
						
					}else{
						currentNode = currentNode.getNextFlight();
					}
				}				
			}
		}
	}
	public void bubbleSortFlight() {
		if(firstFlight != null) {
			
			boolean changed = true;
			while(changed) {
				Flight currentNode = firstFlight;
				changed = false;
				//System.out.println("== NEW ITERATION A ==");
				while(currentNode.getNextFlight() != null) {
					Flight nextNode = currentNode.getNextFlight();
					//System.out.println(currentNode+" ? "+nextNode);
					Comparator<Flight> flightComparator = new FlightComparator();
					if(flightComparator.compare(currentNode,nextNode)>0) {
						if(currentNode.getPreviousFlight()!=null) {
							currentNode.getPreviousFlight().setNextFlight(nextNode);
						}
						if(nextNode.getNextFlight()!=null) {
							nextNode.getNextFlight().setPreviousFlight(currentNode);
						}
						
						currentNode.setNextFlight(nextNode.getNextFlight());
						nextNode.setPreviousFlight(currentNode.getPreviousFlight());
						currentNode.setPreviousFlight(nextNode);
						nextNode.setNextFlight(currentNode);
						
						
						if(currentNode==firstFlight) {
							firstFlight = nextNode;
						}
						
						changed = true;
						
					}else{
						currentNode = currentNode.getNextFlight();
					}
				}				
			}
		}
	}
	public void bubbleSortDestiny() {
		if(firstFlight != null) {
			
			boolean changed = true;
			while(changed) {
				Flight currentNode = firstFlight;
				changed = false;
				//System.out.println("== NEW ITERATION A ==");
				while(currentNode.getNextFlight() != null) {
					Flight nextNode = currentNode.getNextFlight();
					//System.out.println(currentNode+" ? "+nextNode);
					Comparator<Flight> flightDestinyComparator = new FlightDestinyComparator();
					if(flightDestinyComparator.compare(currentNode,nextNode)>0) {
						if(currentNode.getPreviousFlight()!=null) {
							currentNode.getPreviousFlight().setNextFlight(nextNode);
						}
						if(nextNode.getNextFlight()!=null) {
							nextNode.getNextFlight().setPreviousFlight(currentNode);
						}
						
						currentNode.setNextFlight(nextNode.getNextFlight());
						nextNode.setPreviousFlight(currentNode.getPreviousFlight());
						currentNode.setPreviousFlight(nextNode);
						nextNode.setNextFlight(currentNode);
						
						
						if(currentNode==firstFlight) {
							firstFlight = nextNode;
						}
						
						changed = true;
						
					}else{
						currentNode = currentNode.getNextFlight();
					}
				}				
			}
		}
	}
	public void bubbleSortGate() {
		if(firstFlight != null) {
			
			boolean changed = true;
			while(changed) {
				Flight currentNode = firstFlight;
				changed = false;
				//System.out.println("== NEW ITERATION A ==");
				while(currentNode.getNextFlight() != null) {
					Flight nextNode = currentNode.getNextFlight();
					//System.out.println(currentNode+" ? "+nextNode);
					Comparator<Flight> flightGateComparator = new FlightGateComparator();
					if(flightGateComparator.compare(currentNode,nextNode)>0) {
						if(currentNode.getPreviousFlight()!=null) {
							currentNode.getPreviousFlight().setNextFlight(nextNode);
						}
						if(nextNode.getNextFlight()!=null) {
							nextNode.getNextFlight().setPreviousFlight(currentNode);
						}
						
						currentNode.setNextFlight(nextNode.getNextFlight());
						nextNode.setPreviousFlight(currentNode.getPreviousFlight());
						currentNode.setPreviousFlight(nextNode);
						nextNode.setNextFlight(currentNode);
						
						
						if(currentNode==firstFlight) {
							firstFlight = nextNode;
						}
						
						changed = true;
						
					}else{
						currentNode = currentNode.getNextFlight();
					}
				}				
			}
		}
	}
	
	@FXML
    void orderByDestiny(ActionEvent event) {
    	long timeInit=System.currentTimeMillis();
    	bubbleSortDestiny();
    	clearData();
    	showTable();
    	long timeFinal=System.currentTimeMillis()-timeInit;
    	time.setText("Time: "+timeFinal);
    }

    @FXML
    void orderByFlight(ActionEvent event) {
    	long timeInit=System.currentTimeMillis();
    	bubbleSortFlight();
    	clearData();
    	showTable(); 
    	long timeFinal=System.currentTimeMillis()-timeInit;
    	time.setText("Time: "+timeFinal);
    }

    @FXML
    void orderByGate(ActionEvent event) {
    	long timeInit=System.currentTimeMillis();
    	bubbleSortGate();
    	clearData();
    	showTable();
    	long timeFinal=System.currentTimeMillis()-timeInit;
    	time.setText("Time: "+timeFinal);
    }

    @FXML
    void searchAction(ActionEvent event) {
    	long timeInit=System.currentTimeMillis();
    	try {
            String kindOfData=searchBy.getValue();
            String datas=data.getText();
            String showData="";
            if(kindOfData.equals("Airline")) {
            	showData=searchFlightByAirline(datas).toString();
            }else if(kindOfData.equals("Flight")) {
            	showData=searchFlightByFlight(datas).toString();
            }if(kindOfData.equals("Destiny")) {
            	showData=searchFlightByDestiny(datas).toString();
            }if(kindOfData.equals("Gate")) {
            	showData=searchFlightByGate(datas).toString();
            }
            showInformation(showData);
        	long timeFinal=System.currentTimeMillis()-timeInit;
        	time.setText("Time: "+timeFinal);
        }catch(NullPointerException npe) {
       		Alert info = new Alert(AlertType.ERROR);
        	info.setTitle("Warning");
        	info.setHeaderText(null);
        	info.initStyle(StageStyle.UTILITY);
        	info.setContentText("Please first choice a value data");
        	info.show();
        }

    }
	public Flight searchFlightByAirline(String n) {
		Flight current = firstFlight;
		Flight returned = null;
		boolean stop = false;
		while(current != null && !stop) {
			if(current.getAirline().equalsIgnoreCase(n)) {
				stop = true;
				returned = current;
			}else {
					current = current.getNextFlight();
			}
		}
		
		return returned;
	}
	public Flight searchFlightByGate(String n) {
		Flight current = firstFlight;
		Flight returned = null;
		boolean stop = false;
		while(current != null && !stop) {
			if(current.getGate().equalsIgnoreCase(n)) {
				stop = true;
				returned = current;
			}else {
					current = current.getNextFlight();
			}
		}
		
		return returned;
	}
	public Flight searchFlightByDestiny(String n) {
		Flight current = firstFlight;
		Flight returned = null;
		boolean stop = false;
		while(current != null && !stop) {
			if(current.getDestiny().equalsIgnoreCase(n)) {
				stop = true;
				returned = current;
			}else {
					current = current.getNextFlight();
			}
		}
		
		return returned;
	}
	public Flight searchFlightByFlight(String n) {
		Flight current = firstFlight;
		Flight returned = null;
		boolean stop = false;
		while(current != null && !stop) {
			if(current.getNumFlight().equalsIgnoreCase(n)) {
				stop = true;
				returned = current;
			}else {
					current = current.getNextFlight();
			}
		}
		
		return returned;
	}
    @FXML
    void initialize() {
       setNodes();
       configureComboBox();
    }
    
     public void setNodes() {
    	date.setDisable(false);
    	airline.setDisable(false);
    	flight.setDisable(false);
    	destiny.setDisable(false);
    	gate.setDisable(false);
    	search.setVisible(false);
    	searchBy.setVisible(false);
    	data.setVisible(false);
 
    }
    public void configureComboBox() {
    	page.setText("1");
    	searchBy.getItems().add("Date");
    	searchBy.getItems().add("Airline");
    	searchBy.getItems().add("Flight");
    	searchBy.getItems().add("Destiny");
    	searchBy.getItems().add("Gate");

    	
    }
    
    public void showTable() {
    	int pages= amountPages();
    	Flight fls= firstFlight;
    	int total=1;
    	for(int j=0;j<pages;j++){  		
    		if(total%14 ==0) {
    	        int avance=0;
    			while( avance<14 && fls != null) {
    	        	fls=fls.getNextFlight();
    	        	avance++;
    	        }
    		}
    		total=0;
    		if(j+1==Integer.parseInt(page.getText())){  	
    	    	for (int i = 0; i <14 && fls!=null; i++) {
    	    		String date =fls.getDate().toString();
    	    		Label d = new Label("\t"+date.substring(0, 20));
    				Label a = new Label("\t"+fls.getAirline());
    				Label f = new Label("\t"+fls.getNumFlight());
    				Label de = new Label("\t"+fls.getDestiny());
    				Label g = new Label("\t"+fls.getGate());							
    				dates.getChildren().add(d);
    				airlines.getChildren().add(a);
    				flies.getChildren().add(f);
    				destinies.getChildren().add(de);
    				gates.getChildren().add(g);
    				fls=fls.getNextFlight();
    				total++;
    		    }
    	    }
		}
    }
    
    public void clearData() {
    	dates.getChildren().clear();
		airlines.getChildren().clear();
		flies.getChildren().clear();
		destinies.getChildren().clear();
		gates.getChildren().clear();
		
    }
    
    @FXML
    void lastPageGo(ActionEvent event) {
        int newPage= Integer.parseInt(page.getText())-1;
        if(newPage>0) {
        	page.setText(newPage+"");
        	clearData();
        	showTable();
        }
    }

    @FXML
    void nextPageGo(ActionEvent event) {
    	int newPage= Integer.parseInt(page.getText())+1; 
    	if(newPage<(amountPages()+2)) {
        	page.setText(newPage+"");
        	clearData();
        	showTable();
        }
    }
    
    public int amountPages() {
    	Flight fls= firstFlight;   	 
        int amount=0;
        while(fls != null) {
        	fls=fls.getNextFlight();
        	amount++;
        }
        int pages=amount/14;
        if(amount%14!=0) {
        	pages++;
        }
        return pages;
    }
    
   public void showInformation(String showData) {
    	Alert info = new Alert(AlertType.INFORMATION);
    	info.setTitle("Information");
    	info.setHeaderText(null);
    	info.initStyle(StageStyle.UTILITY);
    	info.setContentText(showData);
    	info.show();
    	data.setText("");
    }

}
