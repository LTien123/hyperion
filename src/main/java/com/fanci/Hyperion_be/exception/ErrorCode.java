package com.fanci.Hyperion_be.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    CATEGORY_ID_NOT_FOUND(1001, "category id is not found", HttpStatus.BAD_REQUEST),
    CATEGORY_NAME_NOT_FOUND(1002, "category name is not found", HttpStatus.BAD_REQUEST),
    CATEGORY_NAME_DUPLICATED(1003, "category name id duplicated", HttpStatus.BAD_REQUEST),
    PRODUCT_ID_NOT_FOUND(1004, "product id is not found", HttpStatus.BAD_REQUEST),
    PRODUCT_NAME_DUPLICATED(1005, "product name is duplicated", HttpStatus.BAD_REQUEST),
    INVALID_IMAGE(1006, "image(s) not valid", HttpStatus.UNSUPPORTED_MEDIA_TYPE),
    IO_ERROR(1007, " IO ERROR!!!", HttpStatus.INTERNAL_SERVER_ERROR),
    IMAGE_ID_NOT_FOUND(1008, "image id is not found", HttpStatus.BAD_REQUEST),
    PRODUCT_IMAGE_ID_NOT_FOUND(1009, "product image id not found", HttpStatus.BAD_REQUEST),
    USER_ID_NOT_FOUND(1010, "user id is not found", HttpStatus.BAD_REQUEST),
    EMAIL_DUPLICATED(1011, "email is duplicated", HttpStatus.BAD_REQUEST),
    ROLE_ID_NOT_FOUND(1012, "role id is not found", HttpStatus.BAD_REQUEST),
    USER_NOT_DELETED(1013, "user is not deleted", HttpStatus.BAD_REQUEST),
    ROLE_NAME_DUPLICATED(1014, "role name is duplicated", HttpStatus.BAD_REQUEST),
    USER_ALREADY_DELETED(1015, "user is already deleted", HttpStatus.BAD_REQUEST),
    PASSWORD_NOT_MATCH(1016, "password and re-password are not match", HttpStatus.BAD_REQUEST),
    ORDER_ID_NOT_FOUND(1017, "order id not found", HttpStatus.BAD_REQUEST),
    ORDER_ALREADY_DELETED(1018, "order is already deleted", HttpStatus.BAD_REQUEST),
    ORDER_NOT_DELETED(1019, "order is not deleted", HttpStatus.BAD_REQUEST),
    ORDER_DETAIL_ID_NOT_FOUND(1020, "order detail id is not found", HttpStatus.BAD_REQUEST),
    ADD_NEW_ORDER_DETAIL_NOT_CONSISTENT(1021, "order id are not consistent", HttpStatus.BAD_REQUEST),
    RABBITMQ_SEND_FAILED(1022, "Failed to send message to RabbitMQ", HttpStatus.BAD_REQUEST),
    IMAGE_UPLOAD_FAILED(1023, "image upload failed", HttpStatus.BAD_REQUEST),
    CREATE_FOLDER_FAILED(1024, " create folder failed", HttpStatus.BAD_REQUEST),
    JSON_PARSE_ERROR(1025, "can't handle json", HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED(1026, "UNAUTHENTICATED", HttpStatus.UNAUTHORIZED),
    EMAIL_NOT_FOUND(1027, "email not found", HttpStatus.BAD_REQUEST),
    BLOG_CATEGORY_ID_NOT_FOUND(1028, "blog category is not found", HttpStatus.BAD_REQUEST),
    BLOG_ID_NOT_FOUND(1029, "blog is not found", HttpStatus.BAD_REQUEST),
    BLOG_CAN_NOT_COMPARE(1030, "blog can't compare", HttpStatus.BAD_REQUEST),
    PRODUCT_SUB_CATEGORY_ID_NOT_FOUND(1031, "product sub category id is not found", HttpStatus.BAD_REQUEST),
    PRODUCT_COLOR_ID_NOT_FOUND(1032, "product color id is not found", HttpStatus.BAD_REQUEST),
    PRODUCT_MATERIAL_ID_NOT_FOUND(1033, "product material id is not found", HttpStatus.BAD_REQUEST),
    PRODUCT_HANDLEBAR_ID_NOT_FOUND(1034, "product handlebar id is not found", HttpStatus.BAD_REQUEST),
    PRODUCT_PRICE_NOT_FOUND(1035, "product price not found", HttpStatus.BAD_REQUEST),
    PRODUCT_DETAIL_DUPLICATED(1036, "product detail is duplicated", HttpStatus.BAD_REQUEST),
    PRODUCT_DETAIL_ID_NOT_FOUND(1037,"product detail id not found",HttpStatus.BAD_REQUEST ),
    PRODUCT_NAME_NOT_FOUND(1038,"product name is not found" ,HttpStatus.BAD_REQUEST ),
    PERMISSION_NAME_DUPLICATED(1039, "permission name is duplicared", HttpStatus.BAD_REQUEST),
    PERMISSION_ID_NOT_FOUND(1040, "permission id not found", HttpStatus.BAD_REQUEST),
    USERNAME_DUPLICATED(1041, "username is duplicated", HttpStatus.BAD_REQUEST),
    USERNAME_NOT_FOUND(1042, "username is not found", HttpStatus.BAD_REQUEST),
    PRODUCT_CATEGORY_ID_NOT_FOUND(1043, "product category id not found", HttpStatus.BAD_REQUEST);
    private final int code;
    private final String message;
    private final HttpStatusCode httpStatusCode;

    ErrorCode(int code, String message, HttpStatusCode httpStatusCode) {
        this.code = code;
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }
}
