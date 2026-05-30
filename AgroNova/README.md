# AgroNova

AgroNova la ung dung Android ket noi nong dan va thuong lai trong viec dang ban, tim kiem, gui yeu cau mua va theo doi giao dich nong san.

Du an duoc xay dung cho do an mon hoc, tap trung vao cac nghiep vu chinh:

- Nong dan dang ban nong san va quan ly bai dang.
- Thuong lai xem cho nong san, loc san pham va gui yeu cau mua.
- Hai ben theo doi giao dich va nhan tin trong giao dich.
- Nguoi dung danh gia sau khi giao dich hoan thanh.
- Admin quan ly nguoi dung, bai dang, danh muc, giao dich va du lieu khu vuc.

## Cong nghe su dung

- Android native
- Java
- XML layout
- Material Components
- AppCompat
- ConstraintLayout
- Supabase lam backend
- PostgreSQL tren Supabase
- Gradle Kotlin DSL

## Thong tin Android

| Muc | Gia tri |
|---|---|
| Package/namespace | `com.example.agronova` |
| Module chinh | `:app` |
| Min SDK | 28 |
| Target SDK | 36 |
| Compile SDK | 36.1 |
| Java compatibility | Java 11 |
| App theme | `Theme.MyApplication` |

## Cau truc du an

```text
AgroNova
|-- app
|   `-- src/main
|       |-- AndroidManifest.xml
|       |-- java/com/example/agronova
|       |   |-- MainActivity.java
|       |   |-- adapter
|       |   |-- data
|       |   |   |-- model
|       |   |   |-- network
|       |   |   `-- repository
|       |   |-- ui
|       |   |   |-- admin
|       |   |   |-- auth
|       |   |   |-- buyer
|       |   |   |-- chat
|       |   |   |-- farmer
|       |   |   |-- order
|       |   |   |-- profile
|       |   |   `-- review
|       |   `-- utils
|       `-- res
|           |-- drawable
|           |-- layout
|           |-- menu
|           `-- values
|-- build.gradle.kts
|-- settings.gradle.kts
|-- gradle.properties
|-- gradlew
`-- gradlew.bat
```

## Luong kien truc

Du an duoc chia theo huong tach tang de de mo rong ve sau:

```text
Activity/BottomSheet
    -> Adapter hien thi danh sach
    -> Repository xu ly nghiep vu va goi Supabase
    -> Network provider cau hinh client/API
    -> Model dai dien du lieu tra ve tu database
```

Nguyen tac nen giu:

- `Activity` chi xu ly giao dien, su kien bam nut va dieu huong.
- `Repository` la noi goi Supabase va xu ly du lieu.
- `Model` dai dien bang trong database.
- `Adapter` chi phu trach hien thi danh sach tren RecyclerView.
- `Utils` chua ham dung chung, khong gan voi man hinh cu the.

## Cau truc Java chi tiet

### Entry point

| File | Vai tro |
|---|---|
| `MainActivity.java` | Man hinh khoi dong chinh cua app |

### Auth UI

| File | Layout | Vai tro |
|---|---|---|
| `ui/auth/DangNhapActivity.java` | `activity_dang_nhap.xml` | Dang nhap |
| `ui/auth/DangKyActivity.java` | `activity_dang_ky.xml` | Dang ky tai khoan |
| `ui/auth/QuenMatKhauActivity.java` | `activity_quen_mat_khau.xml` | Quen mat khau |
| `ui/auth/XacThucOtpActivity.java` | `activity_xac_thuc_otp.xml` | Xac thuc OTP |

### Farmer UI

| File | Layout | Vai tro |
|---|---|---|
| `ui/farmer/TrangChuNongDanActivity.java` | `activity_trang_chu_nong_dan.xml` | Dashboard nong dan |
| `ui/farmer/DangBanSanPhamActivity.java` | `activity_dang_san_pham.xml` | Dang ban nong san |
| `ui/farmer/QuanLyBaiDangActivity.java` | `activity_quan_ly_bai_dang.xml` | Quan ly bai dang |
| `ui/farmer/BaiDangCuaToiActivity.java` | `activity_bai_dang_cua_toi.xml` | Danh sach bai dang cua nong dan |

### Buyer UI

| File | Layout | Vai tro |
|---|---|---|
| `ui/buyer/TrangChuThuongLaiActivity.java` | `activity_trang_chu_thuong_lai.xml` | Dashboard thuong lai |
| `ui/buyer/ChoNongSanActivity.java` | `activity_cho_nong_san.xml` | Cho nong san |
| `ui/buyer/ChiTietSanPhamActivity.java` | `activity_chi_tiet_san_pham.xml` | Chi tiet san pham |
| `ui/buyer/GuiYeuCauMuaActivity.java` | `activity_gui_yeu_cau_mua.xml` | Gui yeu cau mua |
| `ui/buyer/BoLocBottomSheet.java` | `bottom_sheet_bo_loc.xml` | Bo loc san pham |

### Admin UI

| File | Layout | Vai tro |
|---|---|---|
| `ui/admin/TrangChuAdminActivity.java` | `activity_trang_chu_quan_tri.xml` | Dashboard quan tri |
| `ui/admin/QuanLyNguoiDungActivity.java` | `activity_quan_ly_nguoi_dung.xml` | Quan ly nguoi dung |
| `ui/admin/QuanTriHeThongActivity.java` | `activity_quan_tri_he_thong.xml` | Quan tri he thong |

### Order UI

| File | Layout | Vai tro |
|---|---|---|
| `ui/order/DanhSachGiaoDichActivity.java` | `activity_danh_sach_giao_dich.xml` | Danh sach giao dich |
| `ui/order/ChiTietGiaoDichActivity.java` | `activity_chi_tiet_giao_dich.xml` | Chi tiet giao dich |
| `ui/order/DanhSachYeuCauMuaActivity.java` | `activity_danh_sach_yeu_cau_mua.xml` | Danh sach yeu cau mua |

### Chat, Profile, Review UI

| File | Layout | Vai tro |
|---|---|---|
| `ui/chat/DanhSachTinNhanActivity.java` | `activity_danh_sach_tin_nhan.xml` | Danh sach hoi thoai |
| `ui/chat/NhanTinActivity.java` | `activity_nhan_tin.xml` | Man hinh nhan tin |
| `ui/chat/DanhBaDoiTacActivity.java` | `activity_danh_ba_doi_tac.xml` | Danh ba doi tac |
| `ui/profile/HoSoNguoiDungActivity.java` | `activity_ho_so_nguoi_dung.xml` | Ho so nguoi dung |
| `ui/review/DanhGiaDichVuActivity.java` | `activity_danh_gia_dich_vu.xml` | Danh gia dich vu |

## Model va bang Supabase

| Model Java | Bang Supabase | Ghi chu |
|---|---|---|
| `NguoiDung` | `nguoi_dung` | Ho so, role, dia chi va trang thai tai khoan |
| `DanhMuc` | `danh_muc_san_pham` | Danh muc nong san |
| `SanPham` | `bai_dang_san_pham` | Bai dang ban nong san |
| `HinhAnhSanPham` | `hinh_anh_san_pham` | Anh cua bai dang |
| `YeuCauMua` | `yeu_cau_mua` | Yeu cau mua tu thuong lai |
| `DonHang` | `giao_dich` | Giao dich sau khi chap nhan yeu cau mua |
| `TinNhan` | `tin_nhan` | Tin nhan trong giao dich |
| `DanhGia` | `danh_gia` | Danh gia nguoi dung |
| `ThongBao` | `thong_bao` | Thong bao |
| `TinhThanh` | `tinh_thanh_pho` | Du lieu tinh/thanh pho |
| `QuanHuyen` | `quan_huyen` | Du lieu quan/huyen |

Trang thai chinh dang duoc khai bao trong model:

- San pham: `dang_ban`, `da_an`, `het_hang`.
- Yeu cau mua: `cho_phan_hoi`, `da_chap_nhan`, `da_tu_choi`, `da_huy`.
- Don hang/giao dich: `cho_giao_hang`, `dang_giao`, `hoan_thanh`, `da_huy`.
- Vai tro nguoi dung: `nong_dan`, `thuong_lai`, `admin`.

## Repository hien co

| Repository | Du kien phu trach |
|---|---|
| `XacThucRepository` | Dang nhap, dang ky, OTP, phien dang nhap |
| `NguoiDungRepository` | Ho so nguoi dung va phan quyen |
| `SanPhamRepository` | Bai dang/san pham nong san |
| `DanhMucRepository` | Danh muc san pham |
| `YeuCauMuaRepository` | Yeu cau mua |
| `DonHangRepository` | Giao dich/don hang |
| `TinNhanRepository` | Tin nhan |
| `DanhGiaRepository` | Danh gia |
| `ThongBaoRepository` | Thong bao |
| `KhuVucRepository` | Tinh/thanh pho va quan/huyen |

Hien tai cac repository moi la khung, can bo sung logic goi Supabase REST API hoac client tuong ung.

## Adapter hien co

| Adapter | Du kien dung cho |
|---|---|
| `SanPhamAdapter` | Danh sach san pham o cho nong san |
| `BaiDangAdapter` | Danh sach bai dang cua nong dan/admin |
| `DonHangAdapter` | Danh sach giao dich |
| `YeuCauMuaAdapter` | Danh sach yeu cau mua |
| `TinNhanAdapter` | Noi dung chat |
| `NguoiDungAdapter` | Quan ly nguoi dung/danh ba |
| `DanhGiaAdapter` | Danh sach danh gia |
| `DanhMucAdapter` | Danh muc nong san |
| `ThongBaoAdapter` | Danh sach thong bao |

Hien tai cac adapter moi la khung, can viet RecyclerView Adapter that.

## Layout XML chinh

### Activity layout

- `activity_chinh.xml`
- `activity_dang_nhap.xml`
- `activity_dang_ky.xml`
- `activity_quen_mat_khau.xml`
- `activity_xac_thuc_otp.xml`
- `activity_trang_chu_nong_dan.xml`
- `activity_trang_chu_thuong_lai.xml`
- `activity_trang_chu_quan_tri.xml`
- `activity_cho_nong_san.xml`
- `activity_chi_tiet_san_pham.xml`
- `activity_dang_san_pham.xml`
- `activity_bai_dang_cua_toi.xml`
- `activity_quan_ly_bai_dang.xml`
- `activity_danh_sach_yeu_cau_mua.xml`
- `activity_gui_yeu_cau_mua.xml`
- `activity_danh_sach_giao_dich.xml`
- `activity_chi_tiet_giao_dich.xml`
- `activity_danh_sach_tin_nhan.xml`
- `activity_nhan_tin.xml`
- `activity_danh_ba_doi_tac.xml`
- `activity_ho_so_nguoi_dung.xml`
- `activity_danh_gia_dich_vu.xml`
- `activity_quan_ly_nguoi_dung.xml`
- `activity_quan_tri_he_thong.xml`

### Reusable/item layout

- `item_san_pham.xml`
- `item_giao_dich.xml`
- `item_yeu_cau_mua.xml`
- `item_tin_nhan_gui.xml`
- `item_tin_nhan_nhan.xml`
- `item_cuoc_tro_chuyen.xml`
- `item_nguoi_dung.xml`
- `item_danh_gia.xml`
- `item_danh_muc.xml`
- `item_thong_bao.xml`
- `item_hinh_anh_san_pham.xml`
- `item_quan_ly_bai_dang.xml`
- `item_thong_ke_trang_chu.xml`
- `bottom_sheet_bo_loc.xml`
- `dialog_dang_tai.xml`

## Tai lieu thiet ke

Tai lieu thiet ke nam ngoai thu muc app, tai:

```text
E:\Do_An_Tong\App Nong San\docs
```

Nhung file quan trong:

- `chuc-nang.md`: mo ta chuc nang.
- `co-so-du-lieu.md`: thiet ke database.
- `thiet-ke-chi-tiet.md`: luong nghiep vu, trang thai va man hinh.
- `supabase-setup.md`: ghi chu cai dat Supabase.
- `ke-hoach-trien-khai.md`: ke hoach lam du an.
- `cong-nghe-su-dung.md`: cong nghe du kien.
- `vi-du-thuc-te.md`: vi du nghiep vu.

## Trang thai hien tai

Da co:

- Cau truc package theo huong tach tang `ui`, `data`, `adapter`, `utils`.
- Layout XML cho cac man hinh chinh.
- Activity theo tung nhom chuc nang.
- Model Java cho cac bang chinh trong Supabase.
- Khung repository, adapter va network provider.
- Manifest da khai bao cac Activity chinh.
- Resource drawable/layout da doi ten sang tieng Viet khong dau.

Can lam tiep:

- Cai dat logic that cho `Repository`.
- Cau hinh Supabase URL va publishable/anon key.
- Them dependency goi API neu dung REST, vi du OkHttp/Gson.
- Viet adapter RecyclerView that cho danh sach san pham, giao dich, tin nhan.
- Gan du lieu tu repository vao Activity.
- Bo sung validate form dang nhap, dang ky, dang ban san pham.
- Doi `app_name` trong `strings.xml` tu `My Application` sang `AgroNova`.
- Doi `rootProject.name` trong `settings.gradle.kts` tu `My Application` sang `AgroNova`.
- Kiem tra va cai dat RLS policy tren Supabase.
- Chay build/lint sau khi moi truong JDK/SDK on dinh.

## Cach chay du an

1. Mo thu muc `AgroNova` bang Android Studio.
2. Cho Gradle sync xong.
3. Kiem tra Android SDK tuong ung voi `compileSdk`.
4. Chay len emulator hoac thiet bi Android that.

Lenh build debug:

```bash
./gradlew :app:assembleDebug
```

Tren Windows:

```powershell
.\gradlew.bat :app:assembleDebug
```

## Ghi chu Supabase

Trong Android app chi nen dung:

- Publishable key, hoac
- Legacy anon key

Khong dua `service_role` key hoac secret key vao ma nguon Android vi cac key nay co quyen cao va khong an toan khi dong goi vao app.

Khi goi du lieu tu app, nen bat Row Level Security cho cac bang chinh va viet policy theo vai tro:

- Nong dan chi sua bai dang cua minh.
- Thuong lai chi tao/huy yeu cau mua cua minh.
- Nguoi dung chi xem giao dich co lien quan den minh.
- Admin co quyen quan ly toan bo du lieu chinh.

## Quy uoc dat ten

- Ten package va file Java dung tieng Viet khong dau hoac tieng Anh ngan gon.
- Ten resource XML dung tieng Viet khong dau, snake_case.
- Ten bang/cot Supabase dung snake_case.
- Activity nen dat theo nghiep vu, vi du `DangNhapActivity`, `ChoNongSanActivity`.
- Model nen gan voi bang du lieu, vi du `SanPham` map voi `bai_dang_san_pham`.

## Tac gia

Du an do an ung dung quan ly va ket noi nong san AgroNova.
