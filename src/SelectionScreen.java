import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SelectionScreen extends JFrame {
    private final JComboBox<Country> countryBox = new JComboBox<>();
    private final JComboBox<Line> lineBox = new JComboBox<>();
    private final JTextArea resultArea = new JTextArea();

    public SelectionScreen(List<Country> countries) {
        super("Railway Time - 노선 선택");

        for (Country country : countries) {
            countryBox.addItem(country);
        }
        countryBox.addActionListener(e -> updateLineBox());

        lineBox.addActionListener(e -> showSelectedRoute());

        resultArea.setEditable(false);

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("국가/지역:"));
        topPanel.add(countryBox);
        topPanel.add(new JLabel("노선:"));
        topPanel.add(lineBox);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        updateLineBox();
    }

    private void updateLineBox() {
        lineBox.removeAllItems();
        Country selected = (Country) countryBox.getSelectedItem();
        if (selected == null) {
            return;
        }
        for (Line line : selected.getLines()) {
            lineBox.addItem(line);
        }
    }

    private void showSelectedRoute() {
        Line selected = (Line) lineBox.getSelectedItem();
        resultArea.setText(selected == null ? "" : selected.getRouteString());
    }
}
