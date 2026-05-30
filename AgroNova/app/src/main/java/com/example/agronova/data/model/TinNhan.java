package com.example.agronova.data.model;

public class TinNhan {
    public static final String TABLE_NAME = "tin_nhan";

    public static final String COL_ID = "id";
    public static final String COL_GIAO_DICH_ID = "giao_dich_id";
    public static final String COL_NGUOI_GUI_ID = "nguoi_gui_id";
    public static final String COL_NGUOI_NHAN_ID = "nguoi_nhan_id";
    public static final String COL_NOI_DUNG = "noi_dung";
    public static final String COL_DA_DOC = "da_doc";
    public static final String COL_NGAY_TAO = "ngay_tao";

    private String id;
    private String giaoDichId;
    private String nguoiGuiId;
    private String nguoiNhanId;
    private String noiDung;
    private boolean daDoc;
    private String ngayTao;

    public TinNhan() {
    }

    public TinNhan(String id, String giaoDichId, String nguoiGuiId, String nguoiNhanId,
                  String noiDung, boolean daDoc, String ngayTao) {
        this.id = id;
        this.giaoDichId = giaoDichId;
        this.nguoiGuiId = nguoiGuiId;
        this.nguoiNhanId = nguoiNhanId;
        this.noiDung = noiDung;
        this.daDoc = daDoc;
        this.ngayTao = ngayTao;
    }

    public boolean duocGuiBoi(String nguoiDungId) {
        return nguoiGuiId != null && nguoiGuiId.equals(nguoiDungId);
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

    public String getNguoiGuiId() {
        return nguoiGuiId;
    }

    public void setNguoiGuiId(String nguoiGuiId) {
        this.nguoiGuiId = nguoiGuiId;
    }

    public String getNguoiNhanId() {
        return nguoiNhanId;
    }

    public void setNguoiNhanId(String nguoiNhanId) {
        this.nguoiNhanId = nguoiNhanId;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
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
