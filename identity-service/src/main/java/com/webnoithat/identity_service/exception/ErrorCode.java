package com.webnoithat.identity_service.exception;

public enum ErrorCode {
    USER_EXISTED(1002, "Người dùng đã tồn tại"),
    USER_NONEXISTED(1005, "Người dùng khong tồn tại"),
	OTHER_EXCEPTION(999, "Lỗi"),
	USERNAME_INVALID(1003, "Tên người dùng phải có ít nhất 3 kí tự"),
	PASSWORD_INVALID(1004, "Mật khẩu phải có ít nhất 8 kí tự"),
	INVALID_KEY(1001,"Sai tên key")
	
	;
	
	
    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
