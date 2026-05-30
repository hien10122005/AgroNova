package com.example.agronova.data.model;

public class QuanHuyen {
    public static final String TABLE_NAME = "quan_huyen";

    public static final String COL_ID = "id";
    public static final String COL_TINH_THANH_PHO_ID = "tinh_thanh_pho_id";
    public static final String COL_TEN = "ten";
    public static final String COL_MA = "ma";
    public static final String COL_DANG_HOAT_DONG = "dang_hoat_dong";
    public static final String COL_NGAY_TAO = "ngay_tao";

    private Long id;
    private Long tinhThanhPhoId;
    private String ten;
    private String ma;
    private boolean dangHoatDong;
    private String ngayTao;

    public QuanHuyen() {
    }

    public QuanHuyen(Long id, Long tinhThanhPhoId, String ten, String ma,
                     boolean dangHoatDong, String ngayTao) {
        this.id = id;
        this.tinhThanhPhoId = tinhThanhPhoId;
        this.ten = ten;
        this.ma = ma;
        this.dangHoatDong = dangHoatDong;
        this.ngayTao = ngayTao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTinhThanhPhoId() {
        return tinhThanhPhoId;
    }

    public void setTinhThanhPhoId(Long tinhThanhPhoId) {
        this.tinhThanhPhoId = tinhThanhPhoId;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public boolean isDangHoatDong() {
        return dangHoatDong;
    }

    public void setDangHoatDong(boolean dangHoatDong) {
        this.dangHoatDong = dangHoatDong;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }
}
