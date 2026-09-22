package model;

/**
 * 관리자 계정 정보 (ID/PW).
 * TODO: 실제 저장/검증 방식(파일, DB 등) 결정 후 인증 로직 구현
 */
public class AdminAccount {
    private final String id;
    private final String password;

    public AdminAccount(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
