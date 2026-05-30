package com.example.agronova.data.model;

import java.math.BigDecimal;

public class DonHang {
    public static final String TABLE_NAME = "giao_dich";

    public static final String STATUS_CHO_GIAO_HANG = "cho_giao_hang";
    public static final String STATUS_DANG_GIAO = "dang_giao";
    public static final String STATUS_HOAN_THANH = "hoan_thanh";
    public static final String STATUS_DA_HUY = "da_huy";

    public static final String COL_ID = "id";
    public static final String COL_YEU_CAU_MUA_ID = "yeu_cau_mua_id";
    public static final String COL_BAI_DANG_ID = "bai_dang_id";
    public static final String COL_NONG_DAN_ID = "nong_dan_id";
    public static final String COL_THUONG_LAI_ID = "thuong_lai_id";
    public static final String COL_SO_LUONG = "so_luong";
    public static final String COL_DON_GIA = "don_gia";
    public static final String COL_TONG_TIEN = "tong_tien";
    public static final String COL_TRANG_THAI = "trang_thai";
    public static final String COL_NGAY_TAO = "ngay_tao";
    public static final String COL_NGAY_CAP_NHAT = "ngay_cap_nhat";
    public static final String COL_NGAY_HOAN_THANH = "ngay_hoan_thanh";

    private String id;
    private String yeuCauMuaId;
    private String baiDangId;
    private String nongDanId;
    private String thuongLaiId;
    private BigDecimal soLuong;
    private BigDecimal donGia;
    private BigDecimal tongTien;
    private String trangThai;
    private String ngayTao;
    private String ngayCapNhat;
    private String ngayHoanThanh;

    public DonHang() {
    }

    public DonHang(String id, String yeuCauMuaId, String baiDangId, String nongDanId,
                   String thuongLaiId, BigDecimal soLuong, BigDecimal donGia,
                   BigDecimal tongTien, String trangThai, String ngayTao,
                   String ngayCapNhat, String ngayHoanThanh) {
        this.id = id;
        this.yeuCauMuaId = yeuCauMuaId;
        this.baiDangId = baiDangId;
        this.nongDanId = nongDanId;
        this.thuongLaiId = thuongLaiId;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
        this.ngayHoanThanh = ngayHoanThanh;
    }

    public boolean choGiaoHang() {
        return STATUS_CHO_GIAO_HANG.equals(trangThai);
    }

    public boolean dangGiao() {
        return STATUS_DANG_GIAO.equals(trangThai);
    }

    public boolean hoanThanh() {
        return STATUS_HOAN_THANH.equals(trangThai);
    }

    public boolean daHuy() {
        return STATUS_DA_HUY.equals(trangThai);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYeuCauMuaId() {
        return yeuCauMuaId;
    }

    public void setYeuCauMuaId(String yeuCauMuaId) {
        this.yeuCauMuaId = yeuCauMuaId;
    }

    public String getBaiDangId() {
        return baiDangId;
    }

    public void setBaiDangId(String baiDangId) {
        this.baiDangId = baiDangId;
    }

    public String getNongDanId() {
        return nongDanId;
    }

    public void setNongDanId(String nongDanId) {
        this.nongDanId = nongDanId;
    }

    public String getThuongLaiId() {
        return thuongLaiId;
    }

    public void setThuongLaiId(String thuongLaiId) {
        this.thuongLaiId = thuongLaiId;
    }

    public BigDecimal getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(BigDecimal soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
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

    public String getNgayHoanThanh() {
        return ngayHoanThanh;
    }

    public void setNgayHoanThanh(String ngayHoanThanh) {
        this.ngayHoanThanh = ngayHoanThanh;
    }
}
