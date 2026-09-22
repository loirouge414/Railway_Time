package screen;

import javax.swing.*;
import java.awt.*;

import app.MainFrame;

/**
 * 세부 단계 1: 프로그램 실행 시 잠깐 띄우는 대표 화면.
 * 일정 시간 후 자동으로 국가 선택 화면으로 넘어간다.
 */
public class SplashScreen extends JPanel {
    public SplashScreen(MainFrame mainFrame) {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Railway Time", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 32f));
        add(title, BorderLayout.CENTER);

        Timer timer = new Timer(1500, e -> mainFrame.showScreen(MainFrame.COUNTRY_SELECTION));
        timer.setRepeats(false);
        timer.start();
    }
}
