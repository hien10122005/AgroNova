package com.example.agronova.data.model;

public class NguoiDung {
    public static final String TABLE_NAME = "nguoi_dung";

    public static final String ROLE_NONG_DAN = "nong_dan";
    public static final String ROLE_THUONG_LAI = "thuong_lai";
    public static final String ROLE_ADMIN = "admin";

    public static final String COL_ID = "id";
    public static final String COL_HO_TEN = "ho_ten";
    public static final String COL_SO_DIEN_THOAI = "so_dien_thoai";
    public static final String COL_EMAIL = "email";
    public static final String COL_VAI_TRO = "vai_tro";
    public static final String COL_DIA_CHI = "dia_chi";
    public static final String COL_TINH_THANH_PHO_ID = "tinh_thanh_pho_id";
    public static final String COL_QUAN_HUYEN_ID = "quan_huyen_id";
    public static final String COL_ANH_DAI_DIEN_URL = "anh_dai_dien_url";
    public static final String COL_DANG_HOAT_DONG = "dang_hoat_dong";
    public static final String COL_NGAY_TAO = "ngay_tao";
    public static final String COL_NGAY_CAP_NHAT = "ngay_cap_nhat";

    private String id;
    private String hoTen;
    private String soDienThoai;
    private String email;
    private String vaiTro;
    private String diaChi;
    private Long tinhThanhPhoId;
    private Long quanHuyenId;
    private String anhDaiDienUrl;
    private boolean dangHoatDong;
    private String ngayTao;
    private String ngayCapNhat;

    public NguoiDung() {
    }

    public NguoiDung(String id, String hoTen, String soDienThoai, String email, String vaiTro,
                     String diaChi, Long tinhThanhPhoId, Long quanHuyenId, String anhDaiDienUrl,
                     boolean dangHoatDong, String ngayTao, String ngayCapNhat) {
        this.id = id;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.vaiTro = vaiTro;
        this.diaChi = diaChi;
        this.tinhThanhPhoId = tinhThanhPhoId;
        this.quanHuyenId = quanHuyenId;
        this.anhDaiDienUrl = anhDaiDienUrl;
        this.dangHoatDong = dangHoatDong;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }

    public boolean laNongDan() {
        return ROLE_NONG_DAN.equals(vaiTro);
    }

    public boolean laThuongLai() {
        return ROLE_THUONG_LAI.equals(vaiTro);
    }

    public boolean laAdmin() {
        return ROLE_ADMIN.equals(vaiTro);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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

    public String getAnhDaiDienUrl() {
        return anhDaiDienUrl;
    }

    public void setAnhDaiDienUrl(String anhDaiDienUrl) {
        this.anhDaiDienUrl = anhDaiDienUrl;
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
