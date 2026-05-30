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

## Cau truc du an

```text
AgroNova
|-- app
|   `-- src/main
|       |-- java/com/example/agronova
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
`-- gradle.properties
```

## Y nghia cac package chinh

`data/model`

Chua cac lop du lieu tuong ung voi bang Supabase:

- `NguoiDung`
- `DanhMuc`
- `SanPham`
- `HinhAnhSanPham`
- `YeuCauMua`
- `DonHang`
- `TinNhan`
- `DanhGia`
- `ThongBao`
- `TinhThanh`
- `QuanHuyen`

`data/network`

Chua cau hinh ket noi Supabase. Hien tai co `SupabaseClientProvider`, du kien dung de quan ly URL, API key va client goi API.

`data/repository`

Chua lop thao tac du lieu voi Supabase. Activity khong nen goi truc tiep database, ma nen goi thong qua repository.

`ui`

Chua cac Activity theo tung nhom chuc nang:

- `auth`: Dang nhap, dang ky, quen mat khau, xac thuc OTP.
- `farmer`: Man hinh cua nong dan.
- `buyer`: Man hinh cua thuong lai.
- `admin`: Man hinh quan tri.
- `order`: Giao dich va yeu cau mua.
- `chat`: Tin nhan va danh ba doi tac.
- `profile`: Ho so nguoi dung.
- `review`: Danh gia dich vu.

`adapter`

Chua cac adapter du kien dung cho RecyclerView:

- `SanPhamAdapter`
- `DonHangAdapter`
- `TinNhanAdapter`
- `NguoiDungAdapter`
- `YeuCauMuaAdapter`
- `DanhGiaAdapter`
- `DanhMucAdapter`
- `ThongBaoAdapter`
- `BaiDangAdapter`

`utils`

Chua cac lop tien ich dung chung nhu hang so, dinh dang du lieu va validate form.

## Thiet ke co so du lieu

Du an du kien su dung cac bang Supabase/PostgreSQL sau:

| Bang | Mo ta |
|---|---|
| `nguoi_dung` | Thong tin nguoi dung va vai tro |
| `danh_muc_san_pham` | Danh muc nong san |
| `bai_dang_san_pham` | Bai dang ban nong san |
| `hinh_anh_san_pham` | Anh cua bai dang san pham |
| `yeu_cau_mua` | Yeu cau mua tu thuong lai |
| `giao_dich` | Giao dich sau khi yeu cau mua duoc chap nhan |
| `tin_nhan` | Tin nhan trong giao dich |
| `danh_gia` | Danh gia nguoi dung sau giao dich |
| `thong_bao` | Thong bao cho nguoi dung |
| `tinh_thanh_pho` | Du lieu tinh/thanh pho |
| `quan_huyen` | Du lieu quan/huyen |

Tai lieu chi tiet nam trong thu muc:

```text
E:\Do_An_Tong\App Nong San\docs
```

## Trang thai hien tai

Da co:

- Cau truc package theo huong tach tang `ui`, `data`, `adapter`, `utils`.
- Layout XML cho cac man hinh chinh.
- Activity theo tung nhom chuc nang.
- Model Java cho cac bang chinh trong Supabase.
- Khung repository, adapter va network provider.

Can lam tiep:

- Cai dat logic that cho `Repository`.
- Cau hinh Supabase URL va publishable/anon key.
- Viet adapter RecyclerView that cho danh sach san pham, giao dich, tin nhan.
- Gan du lieu tu repository vao Activity.
- Bo sung validate form dang nhap, dang ky, dang ban san pham.
- Kiem tra va cai dat RLS policy tren Supabase.
- Doi `app_name` va `rootProject.name` tu mac dinh sang AgroNova neu can dong bo ten hien thi.

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

## Tac gia

Du an do an ung dung quan ly va ket noi nong san AgroNova.
