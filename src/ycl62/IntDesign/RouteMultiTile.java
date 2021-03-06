package ycl62.IntDesign;

import javafx.scene.chart.XYChart;
import uk.ac.cam.cl.dgk27.weather.RequestType;
import uk.ac.cam.cl.dgk27.weather.Weather;
import uk.ac.cam.cl.dgk27.weather.WeatherAPI;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class RouteMultiTile extends GraphTile {
    private LocalDate start, end;

    public RouteMultiTile(RouteScene parent, int cityID, LocalDate start, LocalDate end){
        super(parent, cityID);
        useWidth(586);
        this.start = start;
        this.end = end;
    }

    @Override
    void getData(){
        double temp;
        String cityName;
        try{
            Weather weather = WeatherAPI.makeRequest(RequestType.Current, cityID)[0];
            temp = convertUnits(weather.getTemp());
            cityName = weather.getCity_name();
        } catch(IOException e) {
            System.out.println("Location ID (" + cityID + ") not found in weather service.");
            temp = 25.0; //Placeholder value
            cityName = "Cambridge";
        }

        title = cityName + ", " + start.format(DateTimeFormatter.ofPattern("dd LLL")) + " - " + end.format(DateTimeFormatter.ofPattern("dd LLL"));

        Random r = new Random(System.currentTimeMillis());
        for(int i = 0; i <= ChronoUnit.DAYS.between(start, end); i++){
            String date = start.plusDays(i).format(DateTimeFormatter.ofPattern("dd/MM"));
            double low = Math.round((temp * (1 - Math.min(Math.max(Math.abs(r.nextGaussian()) / 4, 0.05), 0.5)) - 2) * 10) / 10.0;
            double high = Math.round((temp * (1 + Math.min(Math.max(Math.abs(r.nextGaussian()) / 4, 0.05), 0.5)) + 2) * 10) / 10.0;
            temp *= 1 + Math.min(Math.max(r.nextGaussian() / 15, -0.2), 0.2);
            lows.getData().add(new XYChart.Data(date, low));
            highs.getData().add(new XYChart.Data(date, high));
        }
    }
}