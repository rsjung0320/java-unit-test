package com.nextinno.unittest.aspect.rest;

import lombok.Data;

public class RsaDto {
    @Data
    public static class UpdatePasswd {
        private String id;
        private String passwd;
    }

}
