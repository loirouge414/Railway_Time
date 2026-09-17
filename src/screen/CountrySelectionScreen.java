package screen;

import javax.swing.*;
import java.awt.*;

import app.MainFrame;

/**
 * 세부 단계 2: 국가 선택 화면.
 * 왼쪽 버튼(대한민국)만 우선 동작, 오른쪽 버튼은 추후 다른 국가 추가 예정.
 */
public class CountrySelectionScreen extends JPanel {
    public CountrySelectionScreen(MainFrame mainFrame) {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("국가 선택", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));
        add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 40, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(40, 80, 40, 80));

        JButton koreaButton = new JButton("대한민국");
        koreaButton.addActionListener(e -> mainFrame.showScreen(MainFrame.REGION_SELECTION));

        JButton otherButton = new JButton("추가 예정");
        otherButton.setEnabled(false);

        buttonPanel.add(koreaButton);
        buttonPanel.add(otherButton);

        add(buttonPanel, BorderLayout.CENTER);
    }
}
