package model;

/**
 * 일반 사용자가 제출하는 노선/역 추가·수정 요청.
 * TODO: 관리자 승인 흐름과 연결 (AdminApprovalScreen 참고)
 */
public class EditRequest {
    public enum Status {
        PENDING, APPROVED, REJECTED
    }

    private final String requesterName;
    private final String targetName;
    private final String requestedChange;
    private Status status = Status.PENDING;

    public EditRequest(String requesterName, String targetName, String requestedChange) {
        this.requesterName = requesterName;
        this.targetName = targetName;
        this.requestedChange = requestedChange;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public String getTargetName() {
        return targetName;
    }

    public String getRequestedChange() {
        return requestedChange;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
