package tiles;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import util.AutoSizeText;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import settings.Settings;
import skeletons.WeatherScene;
import uk.ac.cam.cl.dgk27.stateful.StateManager;
import util.ImageColorer;

import java.text.NumberFormat;


public class HeaderTile extends Tile{
    private static int headerSize = 40;
    private double temperature;
    private String iconCode = "00d";
    private String city = "_placeholder_";
    private AutoSizeText cityLabel;
    private String date = "_pl_";
    private AutoSizeText dateLabel;
    private AutoSizeText temperatureLabel;
    private Image conditionImage;
    private ImageView conditionView;
    private NumberFormat nf;

    private HBox cityPaddingLeft;
    private HBox cityPaddingRight;


    private Button menuButton;
    private Button searchButton;

    private BorderPane pane;
    private ImageView menuIconView;
    private ImageView searchImage;



    public HeaderTile(WeatherScene parent) {
        super(parent);

        pane = new BorderPane();
        this.setPrefSize(600,225);
        
        pane.setPrefSize(600,225);

        pane.setBackground(new Background(new BackgroundFill(Settings.getSecondary(),null,null)));

        pane.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 5;" + "-fx-border-insets: 0;"
                + "-fx-border-radius: 0;" + "-fx-border-color: "+ Settings.colorString(Settings.getTertiary())+";");

        //Construct header bar

        HBox topBar = new HBox();
        pane.setTop(topBar);

        topBar.setSpacing(16);

        //Add menu button
        menuButton = new Button();

        Image menuIcon = new Image("/icons/hamburger.png");
        menuIconView = new ImageView(menuIcon);

        menuIconView.setPreserveRatio(true);
        menuIconView.setFitHeight(headerSize);

        menuButton.setGraphic(ImageColorer.recolor(menuIconView, Settings.getPrimary()));
        menuButton.setStyle("-fx-focus-color: transparent;");
        menuButton.setPadding(new Insets(0, 0, 0, 0));
        menuButton.setBackground(new Background(new BackgroundFill(Settings.getSecondary(),null,null)));

        menuButton.setOnAction(e->{
            StateManager.switchTo("Settings");
        });

        topBar.getChildren().add(menuButton);

        //Add city label
        cityLabel = new AutoSizeText(city,Settings.getPrimary());
        cityLabel.setSize(300,headerSize);
        cityLabel.setTextAlignment(TextAlignment.CENTER);
        cityPaddingLeft = new HBox();
        cityPaddingRight = new HBox();
        cityPaddingLeft.setMinWidth(140-cityLabel.getLayoutBounds().getWidth()/2);
        cityPaddingRight.setMinWidth(140-cityLabel.getLayoutBounds().getWidth()/2);
        HBox.setHgrow(cityPaddingLeft, Priority.ALWAYS);
        HBox.setHgrow(cityPaddingRight, Priority.ALWAYS);

        topBar.getChildren().addAll(cityPaddingLeft,cityLabel,cityPaddingRight);

        //Add search button
        searchButton = new Button();

        searchImage = new ImageView(new Image("/icons/location.png"));
        searchImage.setPreserveRatio(true);
        searchImage.setFitHeight(headerSize);

        searchButton.setGraphic(ImageColorer.recolor(searchImage,Settings.getPrimary()));
        searchButton.setStyle("-fx-focus-color: transparent;");
        searchButton.setPadding(new Insets(0, 0, 0, 0));
        searchButton.setBackground(new Background(new BackgroundFill(Settings.getSecondary(),null,null)));

        searchButton.setOnAction(e->{
            StateManager.switchTo("SearchToMain");
        });

        topBar.getChildren().add(searchButton);

        //Add date text
        dateLabel = new AutoSizeText(date,Settings.getPrimary());
        dateLabel.setSize(100,headerSize);
        dateLabel.setTextAlignment(TextAlignment.RIGHT);
        topBar.getChildren().add(dateLabel);


        //Create center box

        HBox center = new HBox();
        center.setSpacing(100);
        center.setPadding(new Insets(0,40,4,4));

        //Create icon
        iconCode = parent.getCondition();
        //String iconUrl = "http://openweathermap.org/img/w/" + iconCode + ".png";
        conditionImage = new Image("/icons/chance0.png");
        conditionView = new ImageView(conditionImage);
        conditionView.setFitWidth(200);
        conditionView.setViewport(new Rectangle2D(100,100,100,100));
        conditionView.setPreserveRatio(true);
        center.getChildren().add(conditionView);


        //Create temperature display
        nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(1);
        nf.setMaximumFractionDigits(1);


        temperatureLabel = new AutoSizeText("Temp",Settings.getPrimary());
        temperatureLabel.setSize(200,185-headerSize);
        center.getChildren().add(temperatureLabel);
        center.setAlignment(Pos.CENTER_LEFT);


        pane.setCenter(center);

        update();
        this.getChildren().add(pane);

    }

    @Override
    public void update() {
        temperature = ((WeatherScene) parent).getTemperature();
        city  = ((WeatherScene) parent).getLocation();
        date = ((WeatherScene) parent).getDate();

        iconCode = ((WeatherScene) parent).getCondition();
        String iconUrl = "icons/weatherIcons/" + iconCode + ".png";
        conditionImage = new Image(iconUrl);
        conditionView.setImage(conditionImage);
        conditionView.setViewport(new Rectangle2D(0, 0,
                conditionImage.getWidth(),conditionImage.getHeight()));
        conditionView.setPreserveRatio(true);
        conditionView.setFitWidth(150);


        cityLabel.setText(city);
        dateLabel.setText(date);

        if(Settings.isCelsius()){
            temperatureLabel.setText(nf.format(temperature)+"??C");
        }
        else{
            temperatureLabel.setText(nf.format(temperature*9.0/5.0+32.0)+"??F");
        }
        cityLabel.resizeText();
        cityPaddingLeft.setMinWidth(150-cityLabel.getLayoutBounds().getWidth()/2);
        cityPaddingRight.setMinWidth(150-cityLabel.getLayoutBounds().getWidth()/2);

        dateLabel.resizeText();
        temperatureLabel.resizeText();

        //Set colors:
        menuButton.setGraphic(ImageColorer.recolor(menuIconView, Settings.getSecondary()));
        searchButton.setGraphic(ImageColorer.recolor(searchImage, Settings.getSecondary()));
        pane.setBackground(new Background(new BackgroundFill(Settings.getSecondary(),null,null)));
        temperatureLabel.setFill(Settings.getPrimary());
        cityLabel.setFill(Settings.getPrimary());
        dateLabel.setFill(Settings.getPrimary());
        pane.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 5;" + "-fx-border-insets: 0;"
                + "-fx-border-radius: 0;" + "-fx-border-color: "+ Settings.colorString(Settings.getTertiary())+";");



        menuButton.setStyle("-fx-background-color: "+Settings.colorString(Settings.getPrimary())+";"+
                "-fx-padding: 0;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 3;" + "-fx-border-insets: -1;"
                + "-fx-border-radius: 0;" + "-fx-border-color: "+ Settings.colorString(Settings.getTertiary())+";");

        searchButton.setStyle("-fx-background-color: "+Settings.colorString(Settings.getPrimary())+";"+
                "-fx-padding: 0;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 3;" + "-fx-border-insets: -1;"
                + "-fx-border-radius: 0;" + "-fx-border-color: "+ Settings.colorString(Settings.getTertiary())+";");

        menuButton.setOnMousePressed(e -> {
            menuButton.setStyle("-fx-background-color: "+Settings.colorString(Settings.getFadedPrimary())+";"+
                    "-fx-text-fill: "+Settings.colorString(Settings.getSecondary())+";"+
                    "-fx-padding: 0;" + "-fx-border-style: solid inside;"
                    + "-fx-border-width: 3;" + "-fx-border-insets: -1;"
                    + "-fx-border-radius: 0;" + "-fx-border-color: "+ Settings.colorString(Settings.getTertiary())+";");
        });
        menuButton.setOnMouseReleased(e -> {
            menuButton.setStyle("-fx-background-color: "+Settings.colorString(Settings.getPrimary())+";"+
                    "-fx-text-fill: "+Settings.colorString(Settings.getSecondary())+";"+
                    "-fx-padding: 0;" + "-fx-border-style: solid inside;"
                    + "-fx-border-width: 3;" + "-fx-border-insets: -1;"
                    + "-fx-border-radius: 0;" + "-fx-border-color: "+ Settings.colorString(Settings.getTertiary())+";");
        });

        searchButton.setOnMousePressed(e -> {
            searchButton.setStyle("-fx-background-color: "+Settings.colorString(Settings.getFadedPrimary())+";"+
                    "-fx-text-fill: "+Settings.colorString(Settings.getSecondary())+";"+
                    "-fx-padding: 0;" + "-fx-border-style: solid inside;"
                    + "-fx-border-width: 3;" + "-fx-border-insets: -1;"
                    + "-fx-border-radius: 0;" + "-fx-border-color: "+ Settings.colorString(Settings.getTertiary())+";");
        });
        searchButton.setOnMouseReleased(e -> {
            searchButton.setStyle("-fx-background-color: "+Settings.colorString(Settings.getPrimary())+";"+
                    "-fx-text-fill: "+Settings.colorString(Settings.getSecondary())+";"+
                    "-fx-padding: 0;" + "-fx-border-style: solid inside;"
                    + "-fx-border-width: 3;" + "-fx-border-insets: -1;"
                    + "-fx-border-radius: 0;" + "-fx-border-color: "+ Settings.colorString(Settings.getTertiary())+";");
        });

        searchButton.setGraphic(ImageColorer.recolor(searchImage,Settings.getSecondary()));

    }
}
