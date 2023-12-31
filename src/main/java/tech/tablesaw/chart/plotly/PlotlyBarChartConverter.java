package tech.tablesaw.chart.plotly;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.tablesaw.api.Table;
import tech.tablesaw.chart.BarChart;
import tech.tablesaw.chart.ChartDirection;
import tech.tablesaw.chart.ChartType;
import tech.tablesaw.plotly.api.HorizontalBarPlot;
import tech.tablesaw.plotly.api.VerticalBarPlot;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.components.Layout;

public class PlotlyBarChartConverter {

  private static final Logger log = LogManager.getLogger();

public static Figure convert(BarChart chart) {
    Layout.BarMode barMode = null;
    if (ChartType.GROUPED.equals(chart.getChartType())) {
      barMode = Layout.BarMode.GROUP;
    } else if (ChartType.STACKED.equals(chart.getChartType())) {
      barMode = Layout.BarMode.STACK;
    }
    var categoryColumn = chart.getCategorySeries();
    Table merged = PlotlyConverterUtil.mergeColumns(chart);
    String[] valueNames = merged.rejectColumns(0).columnNames().toArray(new String[0]);
    if (ChartDirection.HORIZONTAL.equals(chart.getDirection())) {
      return HorizontalBarPlot.create(
          merged.name(),
          merged,
          categoryColumn.name(),
          barMode,
          valueNames
      );
    } else {
      return VerticalBarPlot.create(
          merged.name(),
          merged,
          categoryColumn.name(),
          barMode,
          valueNames
      );
    }
  }
}
