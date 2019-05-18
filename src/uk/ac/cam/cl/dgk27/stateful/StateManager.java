package uk.ac.cam.cl.dgk27.stateful;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import scenes.mainscreen.MainScreen;
import settings.SettingsScene;
import skeletons.WeatherScene;
import ycl62.IntDesign.RouteScene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StateManager extends Application {
    static Stage primary;
    public static final double WIDTH=612; //Javafx seems to include the windows border in this, the extra 12 pixels correct for that
    public static final double HEIGHT=900;
    
    /**
     * Stores all created states
     */
    private static Map<String, State> states = new HashMap<>();
    
    static boolean addToMap(State s){
        if(states.containsKey(s.name))
            return false;
        states.put(s.name, s);
        return true;
    }
    
    /**
     * @param name The name of the scene to switch to
     */
    public static void switchTo(String name){
        State found = null;
        for(Map.Entry<String, State> e : states.entrySet()){
            System.out.println(e.getKey());
            if(e.getKey().equals(name)){
                found = e.getValue();
            } else{
                e.getValue().disable();
                e.getValue().enabled = false;
            }

        }
        
        if(found != null){
            primary.setScene(found.getScene());
            primary.show();
            found.enable();
            found.enabled = true;
        }
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        primary = primaryStage;
        primaryStage.setTitle("Weather App");
        primaryStage.setResizable(false);
        primaryStage.setHeight(HEIGHT);
        primaryStage.setWidth(WIDTH);
        //primaryStage.getIcons().add(new Image("file:foo.ico"));
        
        switchTo("Main");
    }
    
    public static void main(String[] args) throws IOException{
        //Broke something, couldn't fix it, so here.
        //https://stackoverflow.com/questions/14025718/javafx-toolkit-not-initialized-when-trying-to-play-an-mp3-file-through-mediap/38883432
        JFXPanel fxPanel = new JFXPanel();
        
        // TODO: Add states here
        new YetAnotherSearch("Search");
        new YetAnotherWeatherScene("Weather");
        new MainScreen("Main");
        new RouteScene("Route");
        new SettingsScene("Settings"); // extends State.java
        
        launch(args);
    }
}
