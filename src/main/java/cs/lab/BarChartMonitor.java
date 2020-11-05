package cs.lab;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
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
import org.jfree.data.general.PieDataset;

public class BarChartMonitor extends JFrame implements Observer {

    private static final Logger logger = Logger.getLogger(BarChartMonitor.class.getName());
    private List<Integer> numbers = new ArrayList<Integer>();

    public BarChartMonitor() {
        super("Bar Chart");
    }


    @Override
    public void update(Integer number) {
        numbers.add(number);
        JFreeChart chart = ChartFactory.createBarChart(
                "Bar Chart"," ","",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,true,
                false);
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "Marks {0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);

        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        logger.info("BarChar has been updated");
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        for (Integer number : this.numbers) dataset.setValue( number,Integer.toString(number), Integer.toString(number));
        return dataset;
    }

}
