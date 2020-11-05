package cs.lab;

import java.awt.*;
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

public class PieChartMonitor extends JFrame implements Observer{

    private static final Logger logger = Logger.getLogger(PieChartMonitor.class.getName());
    private List<Integer> numbers = new ArrayList<Integer>();

    public PieChartMonitor() throws HeadlessException {
        super("Pie Chart");
    }


    @Override
    public void update(Integer number) {
        numbers.add(number);
        JFreeChart chart = ChartFactory.createPieChart(
                "Pie Chart",
                createDataset(),
                true,
                true,
                false);
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "Marks {0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);

        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        logger.info("PieChartMonitor has been updated");
    }

    private PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset( );
        for (Integer number : this.numbers) dataset.setValue(" ", number);

        return dataset;
    }

}
