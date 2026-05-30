package com.example.agronova.data.model;

import java.math.BigDecimal;

public class SanPham {
    public static final String TABLE_NAME = "bai_dang_san_pham";

    public static final String STATUS_DANG_BAN = "dang_ban";
    public static final String STATUS_DA_AN = "da_an";
    public static final String STATUS_HET_HANG = "het_hang";

    public static final String COL_ID = "id";
    public static final String COL_NONG_DAN_ID = "nong_dan_id";
    public static final String COL_DANH_MUC_ID = "danh_muc_id";
    public static final String COL_TIEU_DE = "tieu_de";
    public static final String COL_MO_TA = "mo_ta";
    public static final String COL_SO_LUONG = "so_luong";
    public static final String COL_DON_VI = "don_vi";
    public static final String COL_GIA = "gia";
    public static final String COL_DIA_CHI_SAN_PHAM = "dia_chi_san_pham";
    public static final String COL_TINH_THANH_PHO_ID = "tinh_thanh_pho_id";
    public static final String COL_QUAN_HUYEN_ID = "quan_huyen_id";
    public static final String COL_NGAY_THU_HOACH = "ngay_thu_hoach";
    public static final String COL_TRANG_THAI = "trang_thai";
    public static final String COL_NGAY_TAO = "ngay_tao";
    public static final String COL_NGAY_CAP_NHAT = "ngay_cap_nhat";

    private String id;
    private String nongDanId;
    private Long danhMucId;
    private String tieuDe;
    private String moTa;
    private BigDecimal soLuong;
    private String donVi;
    private BigDecimal gia;
    private String diaChiSanPham;
    private Long tinhThanhPhoId;
    private Long quanHuyenId;
    private String ngayThuHoach;
    private String trangThai;
    private String ngayTao;
    private String ngayCapNhat;

    public SanPham() {
    }

    public SanPham(String id, String nongDanId, Long danhMucId, String tieuDe, String moTa,
                   BigDecimal soLuong, String donVi, BigDecimal gia, String diaChiSanPham,
                   Long tinhThanhPhoId, Long quanHuyenId, String ngayThuHoach,
                   String trangThai, String ngayTao, String ngayCapNhat) {
        this.id = id;
        this.nongDanId = nongDanId;
        this.danhMucId = danhMucId;
        this.tieuDe = tieuDe;
        this.moTa = moTa;
        this.soLuong = soLuong;
        this.donVi = donVi;
        this.gia = gia;
        this.diaChiSanPham = diaChiSanPham;
        this.tinhThanhPhoId = tinhThanhPhoId;
        this.quanHuyenId = quanHuyenId;
        this.ngayThuHoach = ngayThuHoach;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }

    public boolean dangBan() {
        return STATUS_DANG_BAN.equals(trangThai);
    }

    public boolean daAn() {
        return STATUS_DA_AN.equals(trangThai);
    }

    public boolean hetHang() {
        return STATUS_HET_HANG.equals(trangThai);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNongDanId() {
        return nongDanId;
    }

    public void setNongDanId(String nongDanId) {
        this.nongDanId = nongDanId;
    }

    public Long getDanhMucId() {
        return danhMucId;
    }

    public void setDanhMucId(Long danhMucId) {
        this.danhMucId = danhMucId;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public BigDecimal getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(BigDecimal soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public String getDiaChiSanPham() {
        return diaChiSanPham;
    }

    public void setDiaChiSanPham(String diaChiSanPham) {
        this.diaChiSanPham = diaChiSanPham;
    }

    public Long getTinhThanhPhoId() {
        return tinhThanhPhoId;
    }

    public void setTinhThanhPhoId(Long tinhThanhPhoId) {
        this.tinhThanhPhoId = tinhThanhPhoId;
    }

    public Long getQuanHuyenId() {
        return quanHuyenId;
    }

    public void setQuanHuyenId(Long quanHuyenId) {
        this.quanHuyenId = quanHuyenId;
    }

    public String getNgayThuHoach() {
        return ngayThuHoach;
    }

    public void setNgayThuHoach(String ngayThuHoach) {
        this.ngayThuHoach = ngayThuHoach;
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
