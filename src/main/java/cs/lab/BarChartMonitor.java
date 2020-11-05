package cs.lab;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class BarChartMonitor extends JFrame implements Observer {

    private static final Logger logger = Logger.getLogger(BarChartMonitor.class.getName());
    DefaultCategoryDataset dataset=new DefaultCategoryDataset();

    public BarChartMonitor() {
        super("Bar Chart");
    }

    @Override
    public void update(Integer number) {
        dataset.setValue(number, " "," ");
        JFreeChart chart = ChartFactory.createBarChart(
                "Bar Chart",
                "Category",
                "Score",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);

        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);        logger.info("PieChartMonitor has been updated");
    }

}
