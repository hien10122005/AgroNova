package com.example.agronova.data.model;

public class DanhMuc {
    public static final String TABLE_NAME = "danh_muc_san_pham";

    public static final String COL_ID = "id";
    public static final String COL_TEN = "ten";
    public static final String COL_MO_TA = "mo_ta";
    public static final String COL_DANG_HOAT_DONG = "dang_hoat_dong";
    public static final String COL_NGAY_TAO = "ngay_tao";
    public static final String COL_NGAY_CAP_NHAT = "ngay_cap_nhat";

    private Long id;
    private String ten;
    private String moTa;
    private boolean dangHoatDong;
    private String ngayTao;
    private String ngayCapNhat;

    public DanhMuc() {
    }

    public DanhMuc(Long id, String ten, String moTa, boolean dangHoatDong,
                   String ngayTao, String ngayCapNhat) {
        this.id = id;
        this.ten = ten;
        this.moTa = moTa;
        this.dangHoatDong = dangHoatDong;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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

    public String getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(String ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }
}
