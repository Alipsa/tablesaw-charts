package tech.tablesaw.chart.plotly;

import tech.tablesaw.api.Table;
import tech.tablesaw.chart.Chart;

public class PlotlyConverterUtil {

  public static Table mergeColumns(Chart chart) {
    return Table.create(
        chart.getTitle(),
        chart.getCategorySeries()
    ).addColumns(chart.getValueSeries());
  }
}
