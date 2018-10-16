package com.shadder.cart.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalCache {

    private static Map<Long, Product> productMap = new HashMap<>();

    private static Map<Long, CartItem> cartMap = new HashMap<>();

    private static Map<Long, Product> favoriteMap = new HashMap<>();

    private static Map<Long, Product> browseListMap = new HashMap<>();

    static {
        productMap.put(1l, new Product(1l, "HTML/CSS", "HTML+CSS基础课程", "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 219));
        productMap.put(2l, new Product(2l, "HTML/CSS", "HTML+CSS基础课程", "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 219));
        productMap.put(3l, new Product(3l, "JAVA", "JAVA基础课程-基本语法", "介绍java基本语法特性及编写规范", "初级", 219));
        productMap.put(4l, new Product(4l, "JAVA", "JAVA基础课程-JDBC", "介绍JDBC方式连接数据库", "初级", 219));
        productMap.put(5l, new Product(5l, "JAVA", "JAVA基础课程—Socket", "介绍Java网络编程Socket", "初级", 219));
        productMap.put(6l, new Product(6l, "HTML/CSS", "HTML+CSS基础课程", "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 219));
        productMap.put(7l, new Product(7l, "HTML/CSS", "HTML+CSS基础课程", "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 219));
        productMap.put(8l, new Product(8l, "HTML/CSS", "HTML+CSS基础课程", "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 219));
        productMap.put(9l, new Product(9l, "HTML/CSS", "HTML+CSS基础课程", "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 219));
        productMap.put(10l, new Product(10l, "HTML/CSS", "HTML+CSS基础课程", "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 219));
        productMap.put(11l, new Product(11l, "HTML/CSS", "HTML+CSS基础课程", "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 219));
        productMap.put(12l, new Product(12l, "HTML/CSS", "HTML+CSS基础课程", "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 219));
        productMap.put(13l, new Product(13l, "HTML/CSS", "HTML+CSS基础课程", "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 219));
        productMap.put(14l, new Product(14l, "HTML/CSS", "HTML+CSS基础课程", "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 219));
        productMap.put(15l, new Product(15l, "HTML/CSS", "HTML+CSS基础课程", "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 219));
        productMap.put(16l, new Product(16l, "HTML/CSS", "HTML+CSS基础课程", "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 219));
        productMap.put(17l, new Product(17l, "HTML/CSS", "HTML+CSS基础课程", "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 219));
        productMap.put(18l, new Product(18l, "HTML/CSS", "HTML+CSS基础课程", "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 219));
        productMap.put(19l, new Product(19l, "HTML/CSS", "HTML+CSS基础课程", "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 219));
        productMap.put(20l, new Product(20l, "HTML/CSS", "HTML+CSS基础课程", "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 219));
        productMap.put(21l, new Product(21l, "HTML/CSS", "HTML+CSS基础课程", "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 219));
        productMap.put(22l, new Product(22l, "HTML/CSS", "HTML+CSS基础课程", "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 219));
        productMap.put(23l, new Product(23l, "HTML/CSS", "HTML+CSS基础课程", "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 219));
        productMap.put(24l, new Product(24l, "HTML/CSS", "HTML+CSS基础课程", "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 219));
        productMap.put(25l, new Product(25l, "HTML/CSS", "HTML+CSS基础课程", "HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义", "初级", 219));
    }

    public static List<Product> getProducts() {
        return new ArrayList<>(productMap.values());
    }

    public static int getProductSize() {
        return productMap.size();
    }

    public static Product getProduct(Long productId) {
        return productMap.get(productId);
    }

    public static List<CartItem> getCartItems() {
        return new ArrayList<>(cartMap.values());
    }

    public static CartItem getCartItem(Long productId) {
        return cartMap.get(productId);
    }

    public static void addCartItem(Product product) {
        if (!cartMap.containsKey(product.getId())) {
            cartMap.put(product.getId(), new CartItem(product.getId(), product.getId(), product.getName(),
                    product.getPrice(), 1, product.getPrice()));
        } else {
            cartMap.get(product.getId()).incrementCount();
        }
    }

    public static void incrementCartItem(Long cartId) {
        cartMap.get(cartId).incrementCount();
    }

    public static void decrementCartItem(Long cartId) {
        boolean result = cartMap.get(cartId).decrementCount();
        if (result) {
            cartMap.remove(cartId);
        }
    }

    public static void removeCartItem(Long productId) {
        cartMap.remove(productId);
    }

    public static void addFavorite(Long productId) {
        favoriteMap.put(productId, productMap.get(productId));
    }

    public static void removeFavorite(Long productId) {
        favoriteMap.remove(productId);
    }

    public static List<Product> getFavorites() {
        return new ArrayList<>(favoriteMap.values());
    }

    public static void addBrowseProduct(Long productId) {
        browseListMap.put(productId, getProduct(productId));
    }

    public static void delBrowseProduct(Long productId) {
        browseListMap.remove(productId);
    }

    public static List<Product> getBrowseProducts() {
        return new ArrayList<>(browseListMap.values());
    }

    public static List<Product> getPageProducts(int page, int size) {
        int start = (page - 1) * size;
        int end = Math.min(page * size, productMap.size());
        return getProducts().subList(start, end);
    }

    public static List<Product> getPageProducts(int page, int size, List<Product> products) {
        int start = (page - 1) * size;
        int end = Math.min(page * size, products.size());
        return products.subList(start, end);
    }

    public static List<Product> getSearchProducts(String keyword) {
        List<Product> resultProduct = new ArrayList<>();
        if (keyword != null && !keyword.equals("")) {
            productMap.values().forEach(product -> {
                if (product.getName().contains(keyword)) {
                    resultProduct.add(product);
                }
            });
        }

        return resultProduct;
    }
}
