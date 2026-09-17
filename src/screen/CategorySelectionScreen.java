package screen;

import javax.swing.*;
import java.awt.*;

import app.MainFrame;

/**
 * 세부 단계 4: 지역 선택 후, 노선/역 선택 화면.
 * 왼쪽 버튼 = 노선 선택(LineListScreen), 오른쪽 버튼 = 역 선택(StationListScreen)
 */
public class CategorySelectionScreen extends JPanel {
    public CategorySelectionScreen(MainFrame mainFrame) {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("노선 / 역 선택", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));
        add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 40, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(40, 80, 40, 80));

        JButton lineButton = new JButton("노선");
        lineButton.addActionListener(e -> mainFrame.showScreen(MainFrame.LINE_LIST));

        JButton stationButton = new JButton("역");
        stationButton.addActionListener(e -> mainFrame.showScreen(MainFrame.STATION_LIST));

        buttonPanel.add(lineButton);
        buttonPanel.add(stationButton);

        add(buttonPanel, BorderLayout.CENTER);

        JButton backButton = new JButton("뒤로");
        backButton.addActionListener(e -> mainFrame.showScreen(MainFrame.REGION_SELECTION));
        add(backButton, BorderLayout.SOUTH);
    }
}
