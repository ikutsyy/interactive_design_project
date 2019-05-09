//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import eu.hansolo.tilesfx.*;
import eu.hansolo.tilesfx.Tile.*;
import eu.hansolo.tilesfx.addons.Indicator;
import eu.hansolo.tilesfx.chart.ChartData;
import eu.hansolo.tilesfx.chart.RadarChart.Mode;
import eu.hansolo.tilesfx.chart.SunburstChart.TextOrientation;
import eu.hansolo.tilesfx.chart.TilesFXSeries;
import eu.hansolo.tilesfx.colors.Bright;
import eu.hansolo.tilesfx.colors.Dark;
import eu.hansolo.tilesfx.skins.BarChartItem;
import eu.hansolo.tilesfx.skins.LeaderBoardItem;
import eu.hansolo.tilesfx.tools.*;
import eu.hansolo.tilesfx.weather.DarkSky;
import eu.hansolo.tilesfx.weather.DarkSky.Language;
import eu.hansolo.tilesfx.weather.DarkSky.Unit;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.*;

public class Demo extends Application {
    private static final Random RND = new Random();
    private static final double TILE_WIDTH = 150.0D;
    private static final double TILE_HEIGHT = 150.0D;
    private int noOfNodes = 0;
    private BarChartItem barChartItem1;
    private BarChartItem barChartItem2;
    private BarChartItem barChartItem3;
    private BarChartItem barChartItem4;
    private LeaderBoardItem leaderBoardItem1;
    private LeaderBoardItem leaderBoardItem2;
    private LeaderBoardItem leaderBoardItem3;
    private LeaderBoardItem leaderBoardItem4;
    private ChartData chartData1;
    private ChartData chartData2;
    private ChartData chartData3;
    private ChartData chartData4;
    private ChartData chartData5;
    private ChartData chartData6;
    private ChartData chartData7;
    private ChartData chartData8;
    private ChartData smoothChartData1;
    private ChartData smoothChartData2;
    private ChartData smoothChartData3;
    private ChartData smoothChartData4;
    private Tile percentageTile;
    private Tile clockTile;
    private Tile gaugeTile;
    private Tile sparkLineTile;
    private Tile areaChartTile;
    private Tile lineChartTile;
    private Tile highLowTile;
    private Tile timerControlTile;
    private Tile numberTile;
    private Tile textTile;
    private Tile plusMinusTile;
    private Tile sliderTile;
    private Tile switchTile;
    private Tile worldTile;
    private Tile weatherTile;
    private Tile timeTile;
    private Tile barChartTile;
    private Tile customTile;
    private Tile leaderBoardTile;
    private Tile mapTile;
    private Tile radialChartTile;
    private Tile donutChartTile;
    private Tile circularProgressTile;
    private Tile stockTile;
    private Tile gaugeSparkLineTile;
    private Tile radarChartTile1;
    private Tile radarChartTile2;
    private Tile smoothAreaChartTile;
    private Tile countryTile;
    private Tile ephemerisTile;
    private Tile characterTile;
    private Tile flipTile;
    private Tile switchSliderTile;
    private Tile dateTile;
    private Tile calendarTile;
    private Tile sunburstTile;
    private Tile matrixTile;
    private Tile radialPercentageTile;
    private Tile statusTile;
    private Tile barGaugeTile;
    private Tile imageTile;
    private long lastTimerCall;
    private AnimationTimer timer;
    private DoubleProperty value;

    public Demo() {
    }

    public void init() {
        long start = System.currentTimeMillis();
        this.value = new SimpleDoubleProperty(0.0D);
        final Series<String, Number> series1 = new Series();
        series1.setName("Whatever");
        series1.getData().add(new Data("MO", 23));
        series1.getData().add(new Data("TU", 21));
        series1.getData().add(new Data("WE", 20));
        series1.getData().add(new Data("TH", 22));
        series1.getData().add(new Data("FR", 24));
        series1.getData().add(new Data("SA", 22));
        series1.getData().add(new Data("SU", 20));
        final Series<String, Number> series2 = new Series();
        series2.setName("Inside");
        series2.getData().add(new Data("MO", 8));
        series2.getData().add(new Data("TU", 5));
        series2.getData().add(new Data("WE", 0));
        series2.getData().add(new Data("TH", 2));
        series2.getData().add(new Data("FR", 4));
        series2.getData().add(new Data("SA", 3));
        series2.getData().add(new Data("SU", 5));
        final Series<String, Number> series3 = new Series();
        series3.setName("Outside");
        series3.getData().add(new Data("MO", 8));
        series3.getData().add(new Data("TU", 5));
        series3.getData().add(new Data("WE", 0));
        series3.getData().add(new Data("TH", 2));
        series3.getData().add(new Data("FR", 4));
        series3.getData().add(new Data("SA", 3));
        series3.getData().add(new Data("SU", 5));

        for(int i = 0; i < Country.values().length; ++i) {
            double value = (double)RND.nextInt(10);
            Color color;
            if (value > 8.0D) {
                color = Tile.RED;
            } else if (value > 6.0D) {
                color = Tile.ORANGE;
            } else if (value > 4.0D) {
                color = Tile.YELLOW_ORANGE;
            } else if (value > 2.0D) {
                color = Tile.GREEN;
            } else {
                color = Tile.BLUE;
            }

            Country.values()[i].setColor(color);
        }

        TimeSection timeSection = TimeSectionBuilder.create().start(LocalTime.now().plusSeconds(20L)).stop(LocalTime.now().plusHours(1L)).color(Tile.GRAY).highlightColor(Tile.RED).build();
        timeSection.setOnTimeSectionEntered((e) -> {
            System.out.println("Section ACTIVE");
        });
        timeSection.setOnTimeSectionLeft((e) -> {
            System.out.println("Section INACTIVE");
        });
        DarkSky darkSky = new DarkSky("YOUR DARKSKY API KEY", Unit.CA, Language.ENGLISH, 51.911858D, 7.632815D);
        this.barChartItem1 = new BarChartItem("Gerrit", 47.0D, Tile.BLUE);
        this.barChartItem2 = new BarChartItem("Sandra", 43.0D, Tile.RED);
        this.barChartItem3 = new BarChartItem("Lilli", 12.0D, Tile.GREEN);
        this.barChartItem4 = new BarChartItem("Anton", 8.0D, Tile.ORANGE);
        this.barChartItem1.setFormatString("%.1f kWh");
        this.leaderBoardItem1 = new LeaderBoardItem("Gerrit", 47.0D);
        this.leaderBoardItem2 = new LeaderBoardItem("Sandra", 43.0D);
        this.leaderBoardItem3 = new LeaderBoardItem("Lilli", 12.0D);
        this.leaderBoardItem4 = new LeaderBoardItem("Anton", 8.0D);
        this.chartData1 = new ChartData("Item 1", 24.0D, Tile.GREEN);
        this.chartData2 = new ChartData("Item 2", 10.0D, Tile.BLUE);
        this.chartData3 = new ChartData("Item 3", 12.0D, Tile.RED);
        this.chartData4 = new ChartData("Item 4", 13.0D, Tile.YELLOW_ORANGE);
        this.chartData5 = new ChartData("Item 5", 13.0D, Tile.BLUE);
        this.chartData6 = new ChartData("Item 6", 13.0D, Tile.BLUE);
        this.chartData7 = new ChartData("Item 7", 13.0D, Tile.BLUE);
        this.chartData8 = new ChartData("Item 8", 13.0D, Tile.BLUE);
        this.smoothChartData1 = new ChartData("Item 1", RND.nextDouble() * 25.0D, Tile.BLUE);
        this.smoothChartData2 = new ChartData("Item 2", RND.nextDouble() * 25.0D, Tile.BLUE);
        this.smoothChartData3 = new ChartData("Item 3", RND.nextDouble() * 25.0D, Tile.BLUE);
        this.smoothChartData4 = new ChartData("Item 4", RND.nextDouble() * 25.0D, Tile.BLUE);
        this.percentageTile = TileBuilder.create().skinType(SkinType.PERCENTAGE).prefSize(150.0D, 150.0D).title("Percentage Tile").unit("%").description("Test").maxValue(60.0D).build();
        this.clockTile = TileBuilder.create().skinType(SkinType.CLOCK).prefSize(150.0D, 150.0D).title("Clock Tile").text("Whatever text").dateVisible(true).locale(Locale.US).running(true).build();
        this.gaugeTile = TileBuilder.create().skinType(SkinType.GAUGE).prefSize(150.0D, 150.0D).title("Gauge Tile").unit("V").threshold(75.0D).build();
        this.sparkLineTile = TileBuilder.create().skinType(SkinType.SPARK_LINE).prefSize(150.0D, 150.0D).title("SparkLine Tile").unit("mb").gradientStops(new Stop[]{new Stop(0.0D, Tile.GREEN), new Stop(0.5D, Tile.YELLOW), new Stop(1.0D, Tile.RED)}).strokeWithGradient(true).build();
        this.areaChartTile = TileBuilder.create().skinType(SkinType.SMOOTHED_CHART).prefSize(150.0D, 150.0D).title("SmoothedChart Tile").chartType(ChartType.AREA).smoothing(true).tooltipTimeout(1000.0D).tilesFxSeries(new TilesFXSeries[]{new TilesFXSeries(series1, Tile.BLUE, new LinearGradient(0.0D, 0.0D, 0.0D, 1.0D, true, CycleMethod.NO_CYCLE, new Stop[]{new Stop(0.0D, Tile.BLUE), new Stop(1.0D, Color.TRANSPARENT)}))}).build();
        this.lineChartTile = TileBuilder.create().skinType(SkinType.SMOOTHED_CHART).prefSize(150.0D, 150.0D).title("SmoothedChart Tile").smoothing(false).series(new Series[]{series2, series3}).build();
        this.highLowTile = TileBuilder.create().skinType(SkinType.HIGH_LOW).prefSize(150.0D, 150.0D).title("HighLow Tile").unit("€").description("Test").text("Whatever text").referenceValue(6.7D).value(8.2D).build();
        this.timerControlTile = TileBuilder.create().skinType(SkinType.TIMER_CONTROL).prefSize(150.0D, 150.0D).title("TimerControl Tile").text("Whatever text").secondsVisible(true).dateVisible(true).timeSections(new TimeSection[]{timeSection}).running(true).build();
        this.numberTile = TileBuilder.create().skinType(SkinType.NUMBER).prefSize(150.0D, 150.0D).title("Number Tile").text("Whatever text").value(13.0D).unit("mb").description("Test").textVisible(true).build();
        this.textTile = TileBuilder.create().skinType(SkinType.TEXT).prefSize(150.0D, 150.0D).title("Text Tile").text("Whatever text").description("May the force be with you\n...always").descriptionAlignment(Pos.TOP_LEFT).textVisible(true).build();
        this.plusMinusTile = TileBuilder.create().skinType(SkinType.PLUS_MINUS).prefSize(150.0D, 150.0D).maxValue(30.0D).minValue(0.0D).title("PlusMinus Tile").text("Whatever text").description("Test").unit("°C").build();
        this.sliderTile = TileBuilder.create().skinType(SkinType.SLIDER).prefSize(150.0D, 150.0D).title("Slider Tile").text("Whatever text").description("Test").unit("°C").barBackgroundColor(Tile.FOREGROUND).build();
        this.switchTile = TileBuilder.create().skinType(SkinType.SWITCH).prefSize(150.0D, 150.0D).title("Switch Tile").text("Whatever text").build();
        this.switchTile.setOnSwitchPressed((e) -> {
            System.out.println("Switch pressed");
        });
        this.switchTile.setOnSwitchReleased((e) -> {
            System.out.println("Switch released");
        });
        this.worldTile = TileBuilder.create().prefSize(300.0D, 150.0D).skinType(SkinType.WORLDMAP).title("WorldMap Tile").text("Whatever text").textVisible(false).build();
        this.weatherTile = TileBuilder.create().skinType(SkinType.WEATHER).prefSize(150.0D, 150.0D).title("YOUR CITY NAME").text("Whatever text").darkSky(darkSky).build();
        this.timeTile = TileBuilder.create().skinType(SkinType.TIME).prefSize(150.0D, 150.0D).title("Time Tile").text("Whatever text").duration(LocalTime.of(1, 22)).description("Average reply time").textVisible(true).build();
        this.barChartTile = TileBuilder.create().skinType(SkinType.BAR_CHART).prefSize(150.0D, 150.0D).title("BarChart Tile").text("Whatever text").barChartItems(new BarChartItem[]{this.barChartItem1, this.barChartItem2, this.barChartItem3, this.barChartItem4}).decimals(0).build();
        this.customTile = TileBuilder.create().skinType(SkinType.CUSTOM).prefSize(150.0D, 150.0D).title("Custom Tile").text("Whatever text").graphic(new Button("Click Me")).roundedCorners(false).build();
        this.leaderBoardTile = TileBuilder.create().skinType(SkinType.LEADER_BOARD).prefSize(150.0D, 150.0D).title("LeaderBoard Tile").text("Whatever text").leaderBoardItems(new LeaderBoardItem[]{this.leaderBoardItem1, this.leaderBoardItem2, this.leaderBoardItem3, this.leaderBoardItem4}).build();
        this.mapTile = TileBuilder.create().skinType(SkinType.MAP).prefSize(150.0D, 150.0D).title("Map").text("Some text").description("Description").currentLocation(new Location(51.91178D, 7.63379D, "Home", TileColor.MAGENTA.color)).pointsOfInterest(new Location[]{new Location(51.914405D, 7.635732D, "POI 1", TileColor.RED.color), new Location(51.912529D, 7.631752D, "POI 2", TileColor.BLUE.color), new Location(51.923993D, 7.628906D, "POI 3", TileColor.YELLOW_ORANGE.color)}).mapProvider(MapProvider.TOPO).build();
        this.radialChartTile = TileBuilder.create().skinType(SkinType.RADIAL_CHART).prefSize(150.0D, 150.0D).title("RadialChart").text("Some text").textVisible(false).chartData(new ChartData[]{this.chartData1, this.chartData2, this.chartData3, this.chartData4}).build();
        this.donutChartTile = TileBuilder.create().skinType(SkinType.DONUT_CHART).prefSize(150.0D, 150.0D).title("DonutChart").text("Some text").textVisible(false).chartData(new ChartData[]{this.chartData1, this.chartData2, this.chartData3, this.chartData4}).build();
        this.circularProgressTile = TileBuilder.create().skinType(SkinType.CIRCULAR_PROGRESS).prefSize(150.0D, 150.0D).title("CircularProgress").text("Some text").unit("%").build();
        this.stockTile = TileBuilder.create().skinType(SkinType.STOCK).prefSize(150.0D, 150.0D).title("Stock").minValue(0.0D).maxValue(1000.0D).averagingPeriod(100).build();
        this.gaugeSparkLineTile = TileBuilder.create().skinType(SkinType.GAUGE_SPARK_LINE).prefSize(150.0D, 150.0D).title("GaugeSparkLine").animated(true).textVisible(false).averagingPeriod(25).autoReferenceValue(true).barColor(Tile.YELLOW_ORANGE).barBackgroundColor(Color.rgb(255, 255, 255, 0.1D)).sections(new Section[]{new Section(0.0D, 33.0D, Tile.LIGHT_GREEN), new Section(33.0D, 67.0D, Tile.YELLOW), new Section(67.0D, 100.0D, Tile.LIGHT_RED)}).sectionsVisible(true).highlightSections(true).strokeWithGradient(true).gradientStops(new Stop[]{new Stop(0.0D, Tile.LIGHT_GREEN), new Stop(0.33D, Tile.LIGHT_GREEN), new Stop(0.33D, Tile.YELLOW), new Stop(0.67D, Tile.YELLOW), new Stop(0.67D, Tile.LIGHT_RED), new Stop(1.0D, Tile.LIGHT_RED)}).build();
        this.radarChartTile1 = TileBuilder.create().skinType(SkinType.RADAR_CHART).prefSize(150.0D, 150.0D).minValue(0.0D).maxValue(50.0D).title("RadarChart Sector").unit("Unit").radarChartMode(Mode.SECTOR).gradientStops(new Stop[]{new Stop(0.0D, Color.TRANSPARENT), new Stop(1.0E-5D, Color.web("#3552a0")), new Stop(0.0909D, Color.web("#456acf")), new Stop(0.27272D, Color.web("#45a1cf")), new Stop(0.36363D, Color.web("#30c8c9")), new Stop(0.45454D, Color.web("#30c9af")), new Stop(0.50909D, Color.web("#56d483")), new Stop(0.72727D, Color.web("#9adb49")), new Stop(0.81818D, Color.web("#efd750")), new Stop(0.90909D, Color.web("#ef9850")), new Stop(1.0D, Color.web("#ef6050"))}).text("Test").chartData(new ChartData[]{this.chartData1, this.chartData2, this.chartData3, this.chartData4, this.chartData5, this.chartData6, this.chartData7, this.chartData8}).tooltipText("").animated(true).build();
        this.radarChartTile2 = TileBuilder.create().skinType(SkinType.RADAR_CHART).prefSize(150.0D, 150.0D).minValue(0.0D).maxValue(50.0D).title("RadarChart Polygon").unit("Unit").radarChartMode(Mode.POLYGON).gradientStops(new Stop[]{new Stop(0.0D, Color.TRANSPARENT), new Stop(1.0E-5D, Color.web("#3552a0")), new Stop(0.0909D, Color.web("#456acf")), new Stop(0.27272D, Color.web("#45a1cf")), new Stop(0.36363D, Color.web("#30c8c9")), new Stop(0.45454D, Color.web("#30c9af")), new Stop(0.50909D, Color.web("#56d483")), new Stop(0.72727D, Color.web("#9adb49")), new Stop(0.81818D, Color.web("#efd750")), new Stop(0.90909D, Color.web("#ef9850")), new Stop(1.0D, Color.web("#ef6050"))}).text("Test").chartData(new ChartData[]{this.chartData1, this.chartData2, this.chartData3, this.chartData4, this.chartData5, this.chartData6, this.chartData7, this.chartData8}).tooltipText("").animated(true).build();
        this.smoothAreaChartTile = TileBuilder.create().skinType(SkinType.SMOOTH_AREA_CHART).prefSize(150.0D, 150.0D).minValue(0.0D).maxValue(40.0D).title("SmoothAreaChart").unit("Unit").text("Test").chartData(new ChartData[]{this.smoothChartData1, this.smoothChartData2, this.smoothChartData3, this.smoothChartData4}).tooltipText("").animated(true).build();
        this.countryTile = TileBuilder.create().skinType(SkinType.COUNTRY).prefSize(150.0D, 150.0D).minValue(0.0D).maxValue(40.0D).title("Country").unit("Unit").country(Country.DE).tooltipText("").animated(true).build();
        this.ephemerisTile = TileBuilder.create().skinType(SkinType.EPHEMERIS).prefSize(150.0D, 150.0D).title("Ephemeris").currentLocation(new Location(51.911515D, 7.6340026D, "Hiltrup")).text("Hiltrup").build();
        this.characterTile = TileBuilder.create().skinType(SkinType.CHARACTER).prefSize(150.0D, 150.0D).title("Character").titleAlignment(TextAlignment.CENTER).description("G").build();
        this.flipTile = TileBuilder.create().skinType(SkinType.FLIP).prefSize(150.0D, 150.0D).characters(Helper.TIME_0_TO_5).flipTimeInMS(500L).flipText(" ").build();
        this.switchSliderTile = TileBuilder.create().skinType(SkinType.SWITCH_SLIDER).prefSize(150.0D, 150.0D).title("SwitchSlider").text("Test").build();
        this.dateTile = TileBuilder.create().skinType(SkinType.DATE).prefSize(150.0D, 150.0D).build();
        ZonedDateTime now = ZonedDateTime.now();
        List<ChartData> calendarData = new ArrayList(10);
        calendarData.add(new ChartData("Item 1", now.minusDays(1L).toInstant()));
        calendarData.add(new ChartData("Item 2", now.plusDays(2L).toInstant()));
        calendarData.add(new ChartData("Item 3", now.plusDays(10L).toInstant()));
        calendarData.add(new ChartData("Item 4", now.plusDays(15L).toInstant()));
        calendarData.add(new ChartData("Item 5", now.plusDays(15L).toInstant()));
        calendarData.add(new ChartData("Item 6", now.plusDays(20L).toInstant()));
        calendarData.add(new ChartData("Item 7", now.plusDays(7L).toInstant()));
        calendarData.add(new ChartData("Item 8", now.minusDays(1L).toInstant()));
        calendarData.add(new ChartData("Item 9", now.toInstant()));
        calendarData.add(new ChartData("Item 10", now.toInstant()));
        this.calendarTile = TileBuilder.create().skinType(SkinType.CALENDAR).prefSize(150.0D, 150.0D).chartData(calendarData).build();
        TreeNode tree = new TreeNode(new ChartData("ROOT"));
        TreeNode first = new TreeNode(new ChartData("1st", 8.3D, Tile.BLUE), tree);
        TreeNode second = new TreeNode(new ChartData("2nd", 2.2D, Tile.ORANGE), tree);
        TreeNode third = new TreeNode(new ChartData("3rd", 1.4D, Tile.PINK), tree);
        TreeNode fourth = new TreeNode(new ChartData("4th", 1.2D, Tile.LIGHT_GREEN), tree);
        new TreeNode(new ChartData("Jan", 3.5D), first);
        new TreeNode(new ChartData("Feb", 3.1D), first);
        new TreeNode(new ChartData("Mar", 1.7D), first);
        new TreeNode(new ChartData("Apr", 1.1D), second);
        new TreeNode(new ChartData("May", 0.8D), second);
        new TreeNode(new ChartData("Jun", 0.3D), second);
        new TreeNode(new ChartData("Jul", 0.7D), third);
        new TreeNode(new ChartData("Aug", 0.6D), third);
        new TreeNode(new ChartData("Sep", 0.1D), third);
        new TreeNode(new ChartData("Oct", 0.5D), fourth);
        new TreeNode(new ChartData("Nov", 0.4D), fourth);
        new TreeNode(new ChartData("Dec", 0.3D), fourth);
        this.sunburstTile = TileBuilder.create().skinType(SkinType.SUNBURST).prefSize(150.0D, 150.0D).title("SunburstTile").textVisible(false).sunburstTree(tree).sunburstBackgroundColor(Tile.BACKGROUND).sunburstTextColor(Tile.BACKGROUND).sunburstUseColorFromParent(true).sunburstTextOrientation(TextOrientation.TANGENT).sunburstAutoTextColor(true).sunburstUseChartDataTextColor(true).sunburstInteractive(true).build();
        this.matrixTile = TileBuilder.create().skinType(SkinType.MATRIX).prefSize(150.0D, 150.0D).title("MatrixTileSkin").text("Any Text").textVisible(false).animated(true).matrixSize(8, 50).chartData(new ChartData[]{this.chartData1, this.chartData2, this.chartData3, this.chartData4, this.chartData5, this.chartData6, this.chartData7, this.chartData8}).build();
        this.radialPercentageTile = TileBuilder.create().skinType(SkinType.RADIAL_PERCENTAGE).prefSize(150.0D, 150.0D).maxValue(1000.0D).title("RadialPercentageSkin").description("Product 1").textVisible(false).chartData(new ChartData[]{this.chartData1, this.chartData2, this.chartData3}).animated(true).referenceValue(100.0D).value(this.chartData1.getValue()).descriptionColor(Tile.GRAY).barColor(Tile.BLUE).decimals(0).build();
        Indicator leftGraphics = new Indicator(Tile.RED);
        leftGraphics.setOn(true);
        Indicator middleGraphics = new Indicator(Tile.YELLOW);
        middleGraphics.setOn(true);
        Indicator rightGraphics = new Indicator(Tile.GREEN);
        rightGraphics.setOn(true);
        this.statusTile = TileBuilder.create().skinType(SkinType.STATUS).prefSize(150.0D, 150.0D).title("Status Tile").description("Notifications").leftText("CRITICAL").middleText("WARNING").rightText("INFORMATION").leftGraphics(leftGraphics).middleGraphics(middleGraphics).rightGraphics(rightGraphics).text("Text").build();
        this.barGaugeTile = TileBuilder.create().skinType(SkinType.BAR_GAUGE).prefSize(150.0D, 150.0D).minValue(0.0D).maxValue(100.0D).startFromZero(true).threshold(80.0D).thresholdVisible(true).title("BarGauge Tile").unit("F").text("Whatever text").gradientStops(new Stop[]{new Stop(0.0D, Bright.BLUE), new Stop(0.1D, Bright.BLUE_GREEN), new Stop(0.2D, Bright.GREEN), new Stop(0.3D, Bright.GREEN_YELLOW), new Stop(0.4D, Bright.YELLOW), new Stop(0.5D, Bright.YELLOW_ORANGE), new Stop(0.6D, Bright.ORANGE), new Stop(0.7D, Bright.ORANGE_RED), new Stop(0.8D, Bright.RED), new Stop(1.0D, Dark.RED)}).strokeWithGradient(true).animated(true).build();
        this.imageTile = TileBuilder.create().skinType(SkinType.IMAGE).prefSize(150.0D, 150.0D).title("Image Tile").image(new Image(Demo.class.getResourceAsStream("HanSolo.png"))).imageMask(ImageMask.ROUND).text("Whatever text").textAlignment(TextAlignment.CENTER).build();
        this.lastTimerCall = System.nanoTime();
        this.timer = new AnimationTimer() {
            public void handle(long now) {
                if (now > Demo.this.lastTimerCall + 3500000000L) {
                    Demo.this.percentageTile.setValue(Demo.RND.nextDouble() * Demo.this.percentageTile.getRange() * 1.5D + Demo.this.percentageTile.getMinValue());
                    Demo.this.gaugeTile.setValue(Demo.RND.nextDouble() * Demo.this.gaugeTile.getRange() * 1.5D + Demo.this.gaugeTile.getMinValue());
                    Demo.this.sparkLineTile.setValue(Demo.RND.nextDouble() * Demo.this.sparkLineTile.getRange() * 1.5D + Demo.this.sparkLineTile.getMinValue());
                    Demo.this.highLowTile.setValue(Demo.RND.nextDouble() * 10.0D);
                    series1.getData().forEach((data) -> {
                        data.setYValue(Demo.RND.nextInt(100));
                    });
                    series2.getData().forEach((data) -> {
                        data.setYValue(Demo.RND.nextInt(30));
                    });
                    series3.getData().forEach((data) -> {
                        data.setYValue(Demo.RND.nextInt(10));
                    });
                    Demo.this.chartData1.setValue(Demo.RND.nextDouble() * 50.0D);
                    Demo.this.chartData2.setValue(Demo.RND.nextDouble() * 50.0D);
                    Demo.this.chartData3.setValue(Demo.RND.nextDouble() * 50.0D);
                    Demo.this.chartData4.setValue(Demo.RND.nextDouble() * 50.0D);
                    Demo.this.chartData5.setValue(Demo.RND.nextDouble() * 50.0D);
                    Demo.this.chartData6.setValue(Demo.RND.nextDouble() * 50.0D);
                    Demo.this.chartData7.setValue(Demo.RND.nextDouble() * 50.0D);
                    Demo.this.chartData8.setValue(Demo.RND.nextDouble() * 50.0D);
                    ((BarChartItem)Demo.this.barChartTile.getBarChartItems().get(Demo.RND.nextInt(3))).setValue(Demo.RND.nextDouble() * 80.0D);
                    ((LeaderBoardItem)Demo.this.leaderBoardTile.getLeaderBoardItems().get(Demo.RND.nextInt(3))).setValue(Demo.RND.nextDouble() * 80.0D);
                    Demo.this.circularProgressTile.setValue(Demo.RND.nextDouble() * 120.0D);
                    Demo.this.stockTile.setValue(Demo.RND.nextDouble() * 50.0D + 500.0D);
                    Demo.this.gaugeSparkLineTile.setValue(Demo.RND.nextDouble() * 100.0D);
                    Demo.this.countryTile.setValue(Demo.RND.nextDouble() * 100.0D);
                    Demo.this.smoothChartData1.setValue(Demo.this.smoothChartData2.getValue());
                    Demo.this.smoothChartData2.setValue(Demo.this.smoothChartData3.getValue());
                    Demo.this.smoothChartData3.setValue(Demo.this.smoothChartData4.getValue());
                    Demo.this.smoothChartData4.setValue(Demo.RND.nextDouble() * 25.0D);
                    Demo.this.characterTile.setDescription(Helper.ALPHANUMERIC[Demo.RND.nextInt(Helper.ALPHANUMERIC.length - 1)]);
                    Demo.this.flipTile.setFlipText(Helper.TIME_0_TO_5[Demo.RND.nextInt(Helper.TIME_0_TO_5.length - 1)]);
                    Demo.this.radialPercentageTile.setValue(Demo.this.chartData1.getValue());
                    if (Demo.this.statusTile.getLeftValue() > 1000.0D) {
                        Demo.this.statusTile.setLeftValue(0.0D);
                    }

                    if (Demo.this.statusTile.getMiddleValue() > 1000.0D) {
                        Demo.this.statusTile.setMiddleValue(0.0D);
                    }

                    if (Demo.this.statusTile.getRightValue() > 1000.0D) {
                        Demo.this.statusTile.setRightValue(0.0D);
                    }

                    Demo.this.statusTile.setLeftValue(Demo.this.statusTile.getLeftValue() + (double)Demo.RND.nextInt(4));
                    Demo.this.statusTile.setMiddleValue(Demo.this.statusTile.getMiddleValue() + (double)Demo.RND.nextInt(3));
                    Demo.this.statusTile.setRightValue(Demo.this.statusTile.getRightValue() + (double)Demo.RND.nextInt(3));
                    Demo.this.barGaugeTile.setValue(Demo.RND.nextDouble() * 100.0D);
                    Demo.this.lastTimerCall = now;
                }

            }
        };
        System.out.println("Initialization: " + (System.currentTimeMillis() - start) + "ms");
    }

    public void start(Stage stage) {
        long start = System.currentTimeMillis();
        FlowGridPane pane = new FlowGridPane(8, 5, new Node[]{this.percentageTile, this.clockTile, this.gaugeTile, this.sparkLineTile, this.areaChartTile, this.lineChartTile, this.timerControlTile, this.numberTile, this.textTile, this.highLowTile, this.plusMinusTile, this.sliderTile, this.switchTile, this.timeTile, this.barChartTile, this.customTile, this.leaderBoardTile, this.worldTile, this.mapTile, this.radialChartTile, this.donutChartTile, this.circularProgressTile, this.stockTile, this.gaugeSparkLineTile, this.radarChartTile1, this.radarChartTile2, this.smoothAreaChartTile, this.countryTile, this.ephemerisTile, this.characterTile, this.flipTile, this.switchSliderTile, this.dateTile, this.calendarTile, this.sunburstTile, this.matrixTile, this.radialPercentageTile, this.statusTile, this.barGaugeTile, this.imageTile});
        pane.setHgap(5.0D);
        pane.setVgap(5.0D);
        pane.setAlignment(Pos.CENTER);
        pane.setCenterShape(true);
        pane.setPadding(new Insets(5.0D));
        pane.setBackground(new Background(new BackgroundFill[]{new BackgroundFill(Color.web("#101214"), CornerRadii.EMPTY, Insets.EMPTY)}));
        PerspectiveCamera camera = new PerspectiveCamera();
        camera.setFieldOfView(10.0D);
        Scene scene = new Scene(pane);
        scene.setCamera(camera);
        stage.setTitle("TilesFX");
        stage.setScene(scene);
        stage.show();
        System.out.println("Rendering     : " + (System.currentTimeMillis() - start) + "ms");
        this.calcNoOfNodes(pane);
        System.out.println("Nodes in Scene: " + this.noOfNodes);
        this.timer.start();
        this.mapTile.addPoiLocation(new Location(51.85D, 7.75D, "Test"));
        this.mapTile.removePoiLocation(new Location(51.85D, 7.75D, "Test"));
        this.radialPercentageTile.showNotifyRegion(true);
    }

    public void stop() {
        this.timer.stop();
        this.clockTile.setRunning(false);
        this.timerControlTile.setRunning(false);
        System.exit(0);
    }

    private void calcNoOfNodes(Node node) {
        if (node instanceof Parent && ((Parent)node).getChildrenUnmodifiable().size() != 0) {
            ObservableList<Node> tempChildren = ((Parent)node).getChildrenUnmodifiable();
            this.noOfNodes += tempChildren.size();
            Iterator var3 = tempChildren.iterator();

            while(var3.hasNext()) {
                Node n = (Node)var3.next();
                this.calcNoOfNodes(n);
            }
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}