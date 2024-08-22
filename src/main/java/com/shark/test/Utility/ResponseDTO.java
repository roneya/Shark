package com.shark.test.Utility;

import lombok.Data;

@Data
public class ResponseDTO {

        private String message;

        private Object data;

        private Boolean success;

        public ResponseDTO(Boolean success, Object data, String message) {
            this.success = success;
            this.data = data;
            this.message = message;
        }

}
