package com.example.agronova.data.model;

public class ThongBao {
    public static final String TABLE_NAME = "thong_bao";

    public static final String COL_ID = "id";
    public static final String COL_NGUOI_DUNG_ID = "nguoi_dung_id";
    public static final String COL_TIEU_DE = "tieu_de";
    public static final String COL_NOI_DUNG = "noi_dung";
    public static final String COL_LOAI = "loai";
    public static final String COL_DA_DOC = "da_doc";
    public static final String COL_NGAY_TAO = "ngay_tao";

    private String id;
    private String nguoiDungId;
    private String tieuDe;
    private String noiDung;
    private String loai;
    private boolean daDoc;
    private String ngayTao;

    public ThongBao() {
    }

    public ThongBao(String id, String nguoiDungId, String tieuDe, String noiDung,
                   String loai, boolean daDoc, String ngayTao) {
        this.id = id;
        this.nguoiDungId = nguoiDungId;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.loai = loai;
        this.daDoc = daDoc;
        this.ngayTao = ngayTao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNguoiDungId() {
        return nguoiDungId;
    }

    public void setNguoiDungId(String nguoiDungId) {
        this.nguoiDungId = nguoiDungId;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public boolean isDaDoc() {
        return daDoc;
    }

    public void setDaDoc(boolean daDoc) {
        this.daDoc = daDoc;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }
}
