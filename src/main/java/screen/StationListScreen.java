package screen;

import javax.swing.*;
import java.awt.*;
import java.util.Comparator;
import java.util.List;

import app.MainFrame;
import data.RailwayData;
import model.Station;

/**
 * 세부 단계 4-b: 역 목록 화면.
 * 노선 추가 시 입력된 역도 여기에 함께 표시된다 (지역 단위로 공유되는 역 목록).
 * TODO: 검색창, 역 클릭 시 상세 화면 이동은 이후 단계에서 구현
 */
public class StationListScreen extends JPanel {
    private final JPanel listPanel = new JPanel();

    public StationListScreen(MainFrame mainFrame) {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("역 목록", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));

        JButton addButton = new JButton("추가하기");
        addButton.addActionListener(e -> mainFrame.showScreen(MainFrame.STATION_EDIT));

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(title, BorderLayout.CENTER);
        topPanel.add(addButton, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        add(new JScrollPane(listPanel), BorderLayout.CENTER);

        JButton backButton = new JButton("뒤로");
        backButton.addActionListener(e -> mainFrame.showScreen(MainFrame.CATEGORY_SELECTION));
        add(backButton, BorderLayout.SOUTH);

        refresh();
    }

    public void refresh() {
        listPanel.removeAll();
        List<Station> stations = RailwayData.getDefaultRegion().getStations();
        stations.stream()
                .sorted(Comparator.comparing(Station::getName))
                .forEach(station -> {
                    JLabel stationLabel = new JLabel(station.getName());
                    stationLabel.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
                    listPanel.add(stationLabel);
                });
        listPanel.revalidate();
        listPanel.repaint();
    }
}
