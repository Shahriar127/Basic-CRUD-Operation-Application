package com.shahriar.demo2.util;

public final class UrlConstant {

    private UrlConstant() {}

        private static final String VERSION= "/v1";
        private static final String API= "/api";

        public static class ProductManagement{
            public static final String ROOT = API + VERSION + "/product";
            public static final String CREATE = "/create";
            public static final String UPDATE = "/{id}";
            public static final String DELETE = "/{id}";
            public static final String GET = "/{id}";
            public static final String GET_ALL = "/all";
        }

}