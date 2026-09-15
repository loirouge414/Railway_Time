import javax.swing.SwingUtilities;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Country> countries = RailwayData.sampleData();
        SwingUtilities.invokeLater(() -> new SelectionScreen(countries).setVisible(true));
    }
}
