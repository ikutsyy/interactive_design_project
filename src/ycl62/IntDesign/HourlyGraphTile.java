package ycl62.IntDesign;

import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.TileBuilder;
import eu.hansolo.tilesfx.chart.TilesFXSeries;
import javafx.scene.Node;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import scenes.mainscreen.MainScreen;
import settings.Settings;
import skeletons.WeatherScene;
import uk.ac.cam.cl.dgk27.stateful.State;
import uk.ac.cam.cl.dgk27.weather.RequestType;
import uk.ac.cam.cl.dgk27.weather.Weather;
import uk.ac.cam.cl.dgk27.weather.WeatherAPI;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class HourlyGraphTile extends tiles.Tile {
    //private final double[] fives = {-14.0, 94.0, 202.0, 310.0, 417.0, 524.0, 632.0}, sixes = {-3.0, 86.0, 175.0, 264.0, 353.0, 443.0, 532.0, 621.0};
    private final double[] fives = {40.0, 148.0, 256.0, 363.5, 470.5, 578.0}, sixes = {41.5, 130.5, 219.5, 308.5, 398.0, 487.5, 576.5};

    private double WIDTH = 591.0, HEIGHT = 150.0;
    private eu.hansolo.tilesfx.Tile chart;
    private String units;
    //Our API doesn't provide hourly data, so all hourly data has to be estimated
    private double temp;
    private double low;
    private double high;

    String cityName;
    XYChart.Series<Node, Double> lows;
    XYChart.Series<Node, Double> highs;
    String title;

    public HourlyGraphTile(State parent, String cityName){
        super(parent);
        this.cityName = cityName;
        title = "Hourly Highs/Lows";
    }

    void getData(){
        cityName = ((WeatherScene)parent).getLocation();
        temp = ((WeatherScene)parent).getTemperature();
        low = ((WeatherScene)parent).getLow();
        high = ((WeatherScene)parent).getHigh();


        double[] tLows = new double[24];
        double[] tHighs = new double[24];
        String[] times = new String[24];

        for(int i=0;i<24;i++){
            //Low and high are only for times between 7 am and 10 pm
            if(i>8 && i<20){
                tLows[i] = Math.min(low,temp+(0.5-Math.random())*(high-low));
                tHighs[i] = Math.max(high,tLows[i]+Math.random()*(high-low));
            }
            else{
                tLows[i] = temp+(0.5-Math.random())*(high-low);
                tHighs[i] = tLows[i]+Math.random()*(high-low);
            }
            if(i<12){
                times[i]=(i+1)+"am";
            }
            else{
                times[i]=((i)%12+1)+"pm";
            }
            //Add data to graphs
            lows.getData().add(new XYChart.Data(times[i],convertUnits(tLows[i])));
            highs.getData().add(new XYChart.Data(times[i],convertUnits(tHighs[i])));
        }


    }

    @Override
    public void update(){
        lows = new XYChart.Series<>();
        highs = new XYChart.Series<>();
        getData();
        chart = TileBuilder.create()
                .chartType(Tile.ChartType.AREA)
                .skinType(Tile.SkinType.SMOOTHED_CHART)
                .prefSize(WIDTH, HEIGHT)
                .title(title + units)
                .tilesFxSeries(
                        new TilesFXSeries(lows, Settings.getPrimary(), new LinearGradient(0.0, 0.0, 0.0, 1.0, true, CycleMethod.NO_CYCLE, new Stop(0.0, Settings.getPrimary()), new Stop(0.6, Color.TRANSPARENT))),
                        new TilesFXSeries(highs, Settings.getFadedPrimary(), new LinearGradient(0.0, 0.0, 0.0, 1.0, true, CycleMethod.NO_CYCLE, new Stop(0.0, Settings.getFadedPrimary()), new Stop(0.7, Color.TRANSPARENT))))
                .backgroundColor(Settings.getSecondary())
                .foregroundBaseColor(Settings.getPrimary())
                .smoothing(true)
                .dataPointsVisible(true)
                .snapToTicks(true)
                .textSize(Tile.TextSize.BIGGER)
                .decimals(1)
                .tooltipTimeout(1000.0)
                .build();
        if(parent instanceof MainScreen){
            registerForecastListener();
        }
//        CategoryAxis xAxis = new CategoryAxis();
//        NumberAxis yAxis = new NumberAxis(5,30,5);
//        AreaChart chart2 = new AreaChart(xAxis, yAxis);
//        chart2.getData().addAll(lows, highs);
//        chart2.setPrefSize(WIDTH, HEIGHT);
//        chart2.setStyle("-fx-text-fill: "+Settings.colorString(Settings.getPrimary()));

        FlowPane pane = new FlowPane(chart);
        pane.setStyle("-fx-padding: -1;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 5;" + "-fx-border-color: " + Settings.colorString(Settings.getTertiary()) + ";");
        pane.setMaxSize(WIDTH, HEIGHT);
        this.getChildren().add(pane);
    }

    void useWidth(double width){
        WIDTH = width;
    }

    private void registerForecastListener(){
        chart.setOnMouseClicked(e -> {
            double x = e.getSceneX();
            double[] divs;
            if(highs.getData().size() == 5){
                divs = fives;
            } else if(highs.getData().size() == 6){
                divs = sixes;
            } else {
                return;
            }
            for(int i = 0; i < divs.length - 1; i++){
                if(x >= divs[i] && x < divs[i + 1]){
                    ((MainScreen) parent).switchToDate(i);
                    return;
                }
            }
        });
    }

    double convertUnits(double d){
        if(Settings.isCelsius()){
            units = " (°C)";
            return d;
        } else {
            units = " (°F)";
            return d * 9.0 / 5.0 + 32.0;
        }
    }
}
