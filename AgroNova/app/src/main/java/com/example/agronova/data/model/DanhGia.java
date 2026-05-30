package com.example.agronova.data.model;

public class DanhGia {
    public static final String TABLE_NAME = "danh_gia";

    public static final int MIN_SO_SAO = 1;
    public static final int MAX_SO_SAO = 5;

    public static final String COL_ID = "id";
    public static final String COL_GIAO_DICH_ID = "giao_dich_id";
    public static final String COL_NGUOI_DANH_GIA_ID = "nguoi_danh_gia_id";
    public static final String COL_NGUOI_DUOC_DANH_GIA_ID = "nguoi_duoc_danh_gia_id";
    public static final String COL_SO_SAO = "so_sao";
    public static final String COL_NHAN_XET = "nhan_xet";
    public static final String COL_NGAY_TAO = "ngay_tao";

    private String id;
    private String giaoDichId;
    private String nguoiDanhGiaId;
    private String nguoiDuocDanhGiaId;
    private int soSao;
    private String nhanXet;
    private String ngayTao;

    public DanhGia() {
    }

    public DanhGia(String id, String giaoDichId, String nguoiDanhGiaId,
                   String nguoiDuocDanhGiaId, int soSao, String nhanXet, String ngayTao) {
        this.id = id;
        this.giaoDichId = giaoDichId;
        this.nguoiDanhGiaId = nguoiDanhGiaId;
        this.nguoiDuocDanhGiaId = nguoiDuocDanhGiaId;
        setSoSao(soSao);
        this.nhanXet = nhanXet;
        this.ngayTao = ngayTao;
    }

    public static boolean soSaoHopLe(int soSao) {
        return soSao >= MIN_SO_SAO && soSao <= MAX_SO_SAO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGiaoDichId() {
        return giaoDichId;
    }

    public void setGiaoDichId(String giaoDichId) {
        this.giaoDichId = giaoDichId;
    }

    public String getNguoiDanhGiaId() {
        return nguoiDanhGiaId;
    }

    public void setNguoiDanhGiaId(String nguoiDanhGiaId) {
        this.nguoiDanhGiaId = nguoiDanhGiaId;
    }

    public String getNguoiDuocDanhGiaId() {
        return nguoiDuocDanhGiaId;
    }

    public void setNguoiDuocDanhGiaId(String nguoiDuocDanhGiaId) {
        this.nguoiDuocDanhGiaId = nguoiDuocDanhGiaId;
    }

    public int getSoSao() {
        return soSao;
    }

    public void setSoSao(int soSao) {
        if (!soSaoHopLe(soSao)) {
            throw new IllegalArgumentException("soSao phai nam trong khoang 1..5");
        }
        this.soSao = soSao;
    }

    public String getNhanXet() {
        return nhanXet;
    }

    public void setNhanXet(String nhanXet) {
        this.nhanXet = nhanXet;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }
}
