package screen;

import javax.swing.*;
import java.awt.*;

import app.MainFrame;

/**
 * 세부 단계 4-b: 역 목록 화면.
 * TODO: 실제 역 목록(가나다순)과 검색창, 역 클릭 시 상세 화면 이동은 이후 단계에서 구현
 */
public class StationListScreen extends JPanel {
    public StationListScreen(MainFrame mainFrame) {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("역 목록", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));
        add(title, BorderLayout.NORTH);

        JButton backButton = new JButton("뒤로");
        backButton.addActionListener(e -> mainFrame.showScreen(MainFrame.CATEGORY_SELECTION));
        add(backButton, BorderLayout.SOUTH);
    }
}
