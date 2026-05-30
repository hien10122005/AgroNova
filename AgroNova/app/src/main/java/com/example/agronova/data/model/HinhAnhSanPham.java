package com.example.agronova.data.model;

public class HinhAnhSanPham {
    public static final String TABLE_NAME = "hinh_anh_san_pham";

    public static final String COL_ID = "id";
    public static final String COL_BAI_DANG_ID = "bai_dang_id";
    public static final String COL_HINH_ANH_URL = "hinh_anh_url";
    public static final String COL_NGAY_TAO = "ngay_tao";

    private String id;
    private String baiDangId;
    private String hinhAnhUrl;
    private String ngayTao;

    public HinhAnhSanPham() {
    }

    public HinhAnhSanPham(String id, String baiDangId, String hinhAnhUrl, String ngayTao) {
        this.id = id;
        this.baiDangId = baiDangId;
        this.hinhAnhUrl = hinhAnhUrl;
        this.ngayTao = ngayTao;
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

    public String getHinhAnhUrl() {
        return hinhAnhUrl;
    }

    public void setHinhAnhUrl(String hinhAnhUrl) {
        this.hinhAnhUrl = hinhAnhUrl;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }
}
