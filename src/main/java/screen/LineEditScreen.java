package screen;

import javax.swing.*;
import java.awt.*;

import app.MainFrame;
import data.RailwayData;
import model.Line;
import model.Station;

/**
 * 세부 단계 4-a-1: 노선 추가/수정 화면.
 * 기초 버전: 관리자 인증 없이 누구나 노선을 추가할 수 있다.
 * TODO: 수정 모드, 관리자 인증 연동, 역별 상세 정보(역 번호, 승강장 형태 등)는 이후 단계에서 구현
 */
public class LineEditScreen extends JPanel {
    private final JTextField nameField = new JTextField();
    private final JTextField companyField = new JTextField();
    private final JTextField startStationField = new JTextField();
    private final JTextField endStationField = new JTextField();
    private final JTextField operationTypeField = new JTextField();

    private final JTextField newStationField = new JTextField();
    private final DefaultListModel<String> stationListModel = new DefaultListModel<>();
    private final JList<String> stationList = new JList<>(stationListModel);

    public LineEditScreen(MainFrame mainFrame) {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("노선 추가", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24f));
        add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 8, 8));
        formPanel.add(new JLabel("노선 이름"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("회사"));
        formPanel.add(companyField);
        formPanel.add(new JLabel("기점역"));
        formPanel.add(startStationField);
        formPanel.add(new JLabel("종점역"));
        formPanel.add(endStationField);
        formPanel.add(new JLabel("운행 형태"));
        formPanel.add(operationTypeField);

        JPanel stationPanel = new JPanel(new BorderLayout(5, 5));
        stationPanel.setBorder(BorderFactory.createTitledBorder("역 목록"));

        JPanel newStationPanel = new JPanel(new BorderLayout(5, 5));
        newStationPanel.add(newStationField, BorderLayout.CENTER);
        JButton addStationButton = new JButton("역 추가");
        addStationButton.addActionListener(e -> {
            String stationName = newStationField.getText().trim();
            if (!stationName.isEmpty()) {
                stationListModel.addElement(stationName);
                newStationField.setText("");
            }
        });
        newStationPanel.add(addStationButton, BorderLayout.EAST);

        JButton removeStationButton = new JButton("선택한 역 삭제");
        removeStationButton.addActionListener(e -> {
            int selected = stationList.getSelectedIndex();
            if (selected != -1) {
                stationListModel.remove(selected);
            }
        });

        stationPanel.add(newStationPanel, BorderLayout.NORTH);
        stationPanel.add(new JScrollPane(stationList), BorderLayout.CENTER);
        stationPanel.add(removeStationButton, BorderLayout.SOUTH);

        JPanel centerPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        centerPanel.add(formPanel);
        centerPanel.add(stationPanel);
        add(centerPanel, BorderLayout.CENTER);

        JButton saveButton = new JButton("저장");
        saveButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "노선 이름을 입력해 주세요.");
                return;
            }

            Line line = new Line(name);
            line.setCompany(companyField.getText().trim());
            line.setStartStation(startStationField.getText().trim());
            line.setEndStation(endStationField.getText().trim());
            line.setOperationType(operationTypeField.getText().trim());

            for (int i = 0; i < stationListModel.size(); i++) {
                Station station = new Station(stationListModel.get(i));
                line.addStation(station);
                RailwayData.getDefaultRegion().addStation(station);
            }

            RailwayData.getDefaultRegion().addLine(line);
            RailwayData.save();
            mainFrame.refreshLineList();
            mainFrame.refreshStationList();
            clearForm();
            mainFrame.showScreen(MainFrame.LINE_LIST);
        });

        JButton cancelButton = new JButton("취소");
        cancelButton.addActionListener(e -> {
            clearForm();
            mainFrame.showScreen(MainFrame.LINE_LIST);
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(saveButton);
        bottomPanel.add(cancelButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void clearForm() {
        nameField.setText("");
        companyField.setText("");
        startStationField.setText("");
        endStationField.setText("");
        operationTypeField.setText("");
        stationListModel.clear();
    }
}
