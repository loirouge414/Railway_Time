package screen;

import javax.swing.*;
import java.awt.*;

import app.MainFrame;

/**
 * 세부 단계 3: 국가 선택 후, 해당 국가의 지역 선택 화면.
 */
public class RegionSelectionScreen extends JPanel {
    public RegionSelectionScreen(MainFrame mainFrame) {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("지역 선택", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));
        add(title, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        JButton seoulButton = new JButton("수도권");
        seoulButton.addActionListener(e -> mainFrame.showScreen(MainFrame.CATEGORY_SELECTION));
        centerPanel.add(seoulButton);
        add(centerPanel, BorderLayout.CENTER);

        JButton backButton = new JButton("뒤로");
        backButton.addActionListener(e -> mainFrame.showScreen(MainFrame.COUNTRY_SELECTION));
        add(backButton, BorderLayout.SOUTH);
    }
}
