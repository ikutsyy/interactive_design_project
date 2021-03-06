package ycl62.IntDesign;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import settings.Settings;
import uk.ac.cam.cl.dgk27.stateful.State;
import uk.ac.cam.cl.dgk27.stateful.StateManager;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateRangeScene extends State {
    private StackPane mainPanel;
    private DatePickerTile p1, p2;
    private Label warning;
    private ButtonsTile buttons;
    
    public DateRangeScene(String name){
        super(name);
    }
    
    @Override
    protected void initialise(){
        p1 = new DatePickerTile(this, "From", LocalDate.now());
        p2 = new DatePickerTile(this, "To", LocalDate.now().plusDays(1));
        EventHandler<MouseEvent> handler = e -> {
            long d = ChronoUnit.DAYS.between(getStart(), getEnd()) + 1;
            if(d > 0){
                warning.setText(d == 1 ? "1 day" : d + " days");
            } else {
                warning.setText("Invalid date range");
            }
            update();
        };
        p1.setOnMouseMoved(handler);
        p2.setOnMouseMoved(handler);
        
        warning = new Label("2 days");
        warning.setFont(Font.font(Settings.getFontString(), 30));
        
        buttons = new ButtonsTile(this);
        buttons.setAddAction(e -> {
            if(!getStart().until(getEnd()).isNegative()){
                ((RouteScene) StateManager.get("Route")).addCity();
                StateManager.switchTo("Route");
            }
        });
        buttons.setBackAction(e -> StateManager.switchTo("Search"));
        
        HBox hBox = new HBox();
        hBox.getChildren().addAll(p1, p2);
        
        mainPanel = new StackPane(hBox, warning, buttons);
        mainPanel.setCenterShape(true);
        mainPanel.setPadding(new Insets(60.0, 0, 30.0, 0));
        StackPane.setAlignment(hBox, Pos.CENTER);
        StackPane.setAlignment(warning, Pos.TOP_CENTER);
        StackPane.setAlignment(buttons, Pos.BOTTOM_CENTER);
        scene = new Scene(mainPanel);
    }
    
    @Override
    protected void enable(){
    }
    
    @Override
    protected void disable(){
    }
    
    @Override
    public void update(){
        p1.update();
        p2.update();
        buttons.update();
        warning.setStyle("-fx-text-fill: " + Settings.colorString(Settings.getPrimary()) + ";");
        mainPanel.setBackground(new Background(new BackgroundFill(Settings.getSecondary(), null, null)));
    }
    
    public LocalDate getStart(){
        return p1.getDate();
    }
    
    public LocalDate getEnd(){
        return p2.getDate();
    }
}
