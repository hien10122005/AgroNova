package com.example.agronova.data.model;

import java.math.BigDecimal;

public class YeuCauMua {
    public static final String TABLE_NAME = "yeu_cau_mua";

    public static final String STATUS_CHO_PHAN_HOI = "cho_phan_hoi";
    public static final String STATUS_DA_CHAP_NHAN = "da_chap_nhan";
    public static final String STATUS_DA_TU_CHOI = "da_tu_choi";
    public static final String STATUS_DA_HUY = "da_huy";

    public static final String COL_ID = "id";
    public static final String COL_BAI_DANG_ID = "bai_dang_id";
    public static final String COL_THUONG_LAI_ID = "thuong_lai_id";
    public static final String COL_NONG_DAN_ID = "nong_dan_id";
    public static final String COL_SO_LUONG_MUON_MUA = "so_luong_muon_mua";
    public static final String COL_GIA_DE_XUAT = "gia_de_xuat";
    public static final String COL_GHI_CHU = "ghi_chu";
    public static final String COL_TRANG_THAI = "trang_thai";
    public static final String COL_NGAY_TAO = "ngay_tao";
    public static final String COL_NGAY_CAP_NHAT = "ngay_cap_nhat";

    private String id;
    private String baiDangId;
    private String thuongLaiId;
    private String nongDanId;
    private BigDecimal soLuongMuonMua;
    private BigDecimal giaDeXuat;
    private String ghiChu;
    private String trangThai;
    private String ngayTao;
    private String ngayCapNhat;

    public YeuCauMua() {
    }

    public YeuCauMua(String id, String baiDangId, String thuongLaiId, String nongDanId,
                     BigDecimal soLuongMuonMua, BigDecimal giaDeXuat, String ghiChu,
                     String trangThai, String ngayTao, String ngayCapNhat) {
        this.id = id;
        this.baiDangId = baiDangId;
        this.thuongLaiId = thuongLaiId;
        this.nongDanId = nongDanId;
        this.soLuongMuonMua = soLuongMuonMua;
        this.giaDeXuat = giaDeXuat;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }

    public boolean choPhanHoi() {
        return STATUS_CHO_PHAN_HOI.equals(trangThai);
    }

    public boolean daChapNhan() {
        return STATUS_DA_CHAP_NHAN.equals(trangThai);
    }

    public boolean daTuChoi() {
        return STATUS_DA_TU_CHOI.equals(trangThai);
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

    public String getBaiDangId() {
        return baiDangId;
    }

    public void setBaiDangId(String baiDangId) {
        this.baiDangId = baiDangId;
    }

    public String getThuongLaiId() {
        return thuongLaiId;
    }

    public void setThuongLaiId(String thuongLaiId) {
        this.thuongLaiId = thuongLaiId;
    }

    public String getNongDanId() {
        return nongDanId;
    }

    public void setNongDanId(String nongDanId) {
        this.nongDanId = nongDanId;
    }

    public BigDecimal getSoLuongMuonMua() {
        return soLuongMuonMua;
    }

    public void setSoLuongMuonMua(BigDecimal soLuongMuonMua) {
        this.soLuongMuonMua = soLuongMuonMua;
    }

    public BigDecimal getGiaDeXuat() {
        return giaDeXuat;
    }

    public void setGiaDeXuat(BigDecimal giaDeXuat) {
        this.giaDeXuat = giaDeXuat;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
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
}
