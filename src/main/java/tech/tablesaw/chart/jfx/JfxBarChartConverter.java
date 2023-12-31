package tech.tablesaw.chart.jfx;

import static tech.tablesaw.chart.jfx.ConverterUtil.*;

import javafx.scene.chart.*;
import tech.tablesaw.chart.ChartDirection;
import tech.tablesaw.chart.ChartType;

public class JfxBarChartConverter {

  public static XYChart<?,?> convert(tech.tablesaw.chart.BarChart chart) {

    Axis<?> xAxis = new CategoryAxis();
    Axis<?> yAxis = new NumberAxis();

    XYChart<?,?> fxChart;
    if (ChartType.STACKED == chart.getChartType()) {
      if (ChartDirection.HORIZONTAL.equals(chart.getDirection())) {
        //xAxis.setTickLabelRotation(90); TODO: make this a styling option
        fxChart = new StackedBarChart<>(yAxis, xAxis);
        populateHorizontalSeries(fxChart, chart);
      } else {
        fxChart = new StackedBarChart<>(xAxis, yAxis);
        populateVerticalSeries(fxChart, chart);
      }
    } else {
      if (ChartDirection.HORIZONTAL.equals(chart.getDirection())) {
        //xAxis.setTickLabelRotation(90); // TODO: make this a styling option
        fxChart = new BarChart<>(yAxis, xAxis);
        populateHorizontalSeries(fxChart, chart);
      } else {
        fxChart = new BarChart<>(xAxis, yAxis);
        populateVerticalSeries(fxChart, chart);
      }
    }
    fxChart.setTitle(chart.getTitle());


    return fxChart;
  }
}
