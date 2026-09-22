package screen;

import javax.swing.*;
import java.awt.*;

import app.MainFrame;
import data.RailwayData;
import model.Line;

/**
 * 세부 단계 4-a: 노선 목록 화면.
 * TODO: 노선 클릭 시 상세 화면 이동, 수정하기 버튼, 관리자 권한 연동은 이후 단계에서 구현
 */
public class LineListScreen extends JPanel {
    private final JPanel listPanel = new JPanel();

    public LineListScreen(MainFrame mainFrame) {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("노선 목록", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));

        JButton addButton = new JButton("추가하기");
        addButton.addActionListener(e -> mainFrame.showScreen(MainFrame.LINE_EDIT));

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
        for (Line line : RailwayData.getDefaultRegion().getLines()) {
            JLabel lineLabel = new JLabel(line.getName());
            lineLabel.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
            listPanel.add(lineLabel);
        }
        listPanel.revalidate();
        listPanel.repaint();
    }
}
