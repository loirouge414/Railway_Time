package screen;

import javax.swing.*;
import java.awt.*;

import app.MainFrame;

/**
 * 세부 단계 4-a: 노선 목록 화면.
 * TODO: 실제 노선 목록 표시 및 각 노선 클릭 시 이동, 추가/수정 버튼은 이후 단계에서 구현
 */
public class LineListScreen extends JPanel {
    public LineListScreen(MainFrame mainFrame) {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("노선 목록", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));
        add(title, BorderLayout.NORTH);

        JButton backButton = new JButton("뒤로");
        backButton.addActionListener(e -> mainFrame.showScreen(MainFrame.CATEGORY_SELECTION));
        add(backButton, BorderLayout.SOUTH);
    }
}
