package screen;

import javax.swing.*;
import java.awt.*;

import app.MainFrame;
import data.RailwayData;
import model.Station;

/**
 * 역 추가 화면 (노선과 무관하게 지역에 역을 바로 추가).
 * 기초 버전: 관리자 인증 없이 누구나 역을 추가할 수 있다.
 * TODO: 한국어/영어 이름, 역 번호, 승강장 형태, 환승 노선 등 상세 정보는 이후 단계에서 구현
 */
public class StationEditScreen extends JPanel {
    private final JTextField nameField = new JTextField();

    public StationEditScreen(MainFrame mainFrame) {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("역 추가", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));
        add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(1, 2, 8, 8));
        formPanel.add(new JLabel("역 이름"));
        formPanel.add(nameField);
        add(formPanel, BorderLayout.CENTER);

        JButton saveButton = new JButton("저장");
        saveButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "역 이름을 입력해 주세요.");
                return;
            }

            RailwayData.getDefaultRegion().addStation(new Station(name));
            RailwayData.save();
            mainFrame.refreshStationList();
            clearForm();
            mainFrame.showScreen(MainFrame.STATION_LIST);
        });

        JButton cancelButton = new JButton("취소");
        cancelButton.addActionListener(e -> {
            clearForm();
            mainFrame.showScreen(MainFrame.STATION_LIST);
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(saveButton);
        bottomPanel.add(cancelButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void clearForm() {
        nameField.setText("");
    }
}
