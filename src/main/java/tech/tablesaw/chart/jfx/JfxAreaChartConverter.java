package tech.tablesaw.chart.jfx;

import static tech.tablesaw.chart.jfx.ConverterUtil.populateVerticalSeries;

import javafx.scene.chart.*;

public class JfxAreaChartConverter {


  public static AreaChart<?,?> convert(tech.tablesaw.chart.AreaChart chart) {
    Axis<?> xAxis = new CategoryAxis();
    Axis<?> yAxis = new NumberAxis();
    AreaChart<?,?> fxChart = new AreaChart<>(xAxis, yAxis);
    fxChart.setTitle(chart.getTitle());

    populateVerticalSeries(fxChart, chart);
    return fxChart;
  }




}
