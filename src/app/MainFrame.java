package app;

import javax.swing.*;
import java.awt.*;

import screen.*;
import screen.SplashScreen;

/**
 * 화면 전환을 관리하는 최상위 프레임 (CardLayout).
 * TODO: 각 화면 간 실제 전환 로직(버튼 리스너 등)은 화면 구현 시 연결
 */
public class MainFrame extends JFrame {
    public static final String SPLASH = "SPLASH";
    public static final String COUNTRY_SELECTION = "COUNTRY_SELECTION";
    public static final String REGION_SELECTION = "REGION_SELECTION";
    public static final String CATEGORY_SELECTION = "CATEGORY_SELECTION";
    public static final String LINE_LIST = "LINE_LIST";
    public static final String LINE_EDIT = "LINE_EDIT";
    public static final String STATION_LIST = "STATION_LIST";
    public static final String STATION_DETAIL = "STATION_DETAIL";
    public static final String ADMIN_LOGIN = "ADMIN_LOGIN";
    public static final String EDIT_REQUEST = "EDIT_REQUEST";
    public static final String ADMIN_APPROVAL = "ADMIN_APPROVAL";

    private final CardLayout cardLayout = new CardLayout();
    private final JPanel screens = new JPanel(cardLayout);

    public MainFrame() {
        super("Railway Time");

        screens.add(new SplashScreen(this), SPLASH);
        screens.add(new CountrySelectionScreen(this), COUNTRY_SELECTION);
        screens.add(new RegionSelectionScreen(this), REGION_SELECTION);
        screens.add(new CategorySelectionScreen(this), CATEGORY_SELECTION);
        screens.add(new LineListScreen(this), LINE_LIST);
        screens.add(new LineEditScreen(), LINE_EDIT);
        screens.add(new StationListScreen(this), STATION_LIST);
        screens.add(new StationDetailScreen(), STATION_DETAIL);
        screens.add(new AdminLoginScreen(), ADMIN_LOGIN);
        screens.add(new EditRequestScreen(), EDIT_REQUEST);
        screens.add(new AdminApprovalScreen(), ADMIN_APPROVAL);

        add(screens);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
    }

    public void showScreen(String name) {
        cardLayout.show(screens, name);
    }
}
