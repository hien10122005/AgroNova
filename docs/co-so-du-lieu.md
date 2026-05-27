# Thiết kế cơ sở dữ liệu

## 1. Tổng quan

Cơ sở dữ liệu sử dụng PostgreSQL trên Supabase. Dữ liệu được thiết kế xoay quanh các nghiệp vụ chính: người dùng, bài đăng nông sản, yêu cầu mua, giao dịch, tin nhắn, đánh giá, thông báo, dashboard, quản trị và dữ liệu khu vực.

Dashboard không cần bảng riêng ở phiên bản đầu. Các số liệu thống kê có thể truy vấn trực tiếp từ các bảng `bai_dang_san_pham`, `yeu_cau_mua`, `giao_dich` và `danh_gia`.

## 2. Danh sách bảng chính

| STT | Bảng | Mục đích |
|---|---|---|
| 1 | nguoi_dung | Lưu thông tin người dùng |
| 2 | danh_muc_san_pham | Lưu danh mục nông sản |
| 3 | bai_dang_san_pham | Lưu bài đăng bán nông sản |
| 4 | hinh_anh_san_pham | Lưu ảnh sản phẩm |
| 5 | yeu_cau_mua | Lưu yêu cầu mua |
| 6 | giao_dich | Lưu giao dịch |
| 7 | tin_nhan | Lưu tin nhắn |
| 8 | danh_gia | Lưu đánh giá người dùng |
| 9 | thong_bao | Lưu thông báo |
| 10 | tinh_thanh_pho | Lưu danh sách tỉnh/thành phố |
| 11 | quan_huyen | Lưu danh sách quận/huyện |
| 12 | san_pham_yeu_thich | Lưu sản phẩm yêu thích, chức năng mở rộng |
| 13 | bao_cao_vi_pham | Lưu báo cáo vi phạm, chức năng mở rộng |

Trong phạm vi đồ án cơ sở 2, nên triển khai trước 11 bảng đầu. Các bảng `san_pham_yeu_thich` và `bao_cao_vi_pham` để phần mở rộng nếu còn thời gian.

## 3. Mô tả bảng

### 3.1. Bảng nguoi_dung

| Cột | Kiểu dữ liệu | Ghi chú |
|---|---|---|
| id | uuid | Khóa chính, liên kết với Supabase Auth |
| ho_ten | text | Họ tên |
| so_dien_thoai | text | Số điện thoại |
| email | text | Email |
| vai_tro | text | nong_dan, thuong_lai, admin |
| dia_chi | text | Địa chỉ |
| tinh_thanh_pho_id | bigint | Tỉnh/thành phố |
| quan_huyen_id | bigint | Quận/huyện |
| anh_dai_dien_url | text | Link ảnh đại diện |
| dang_hoat_dong | boolean | Trạng thái tài khoản |
| ngay_tao | timestamp | Ngày tạo |
| ngay_cap_nhat | timestamp | Ngày cập nhật |

### 3.2. Bảng danh_muc_san_pham

| Cột | Kiểu dữ liệu | Ghi chú |
|---|---|---|
| id | bigint | Khóa chính |
| ten | text | Tên danh mục |
| mo_ta | text | Mô tả |
| dang_hoat_dong | boolean | Có đang sử dụng hay không |
| ngay_tao | timestamp | Ngày tạo |
| ngay_cap_nhat | timestamp | Ngày cập nhật |

Ví dụ danh mục:

- Rau củ.
- Trái cây.
- Lúa gạo.
- Cà phê.
- Hồ tiêu.
- Thủy sản.

### 3.3. Bảng bai_dang_san_pham

| Cột | Kiểu dữ liệu | Ghi chú |
|---|---|---|
| id | uuid | Khóa chính |
| nong_dan_id | uuid | Người đăng bán |
| danh_muc_id | bigint | Danh mục |
| tieu_de | text | Tên bài đăng |
| mo_ta | text | Mô tả |
| so_luong | numeric | Số lượng |
| don_vi | text | Đơn vị: kg, tấn, thùng |
| gia | numeric | Giá bán |
| dia_chi_san_pham | text | Địa chỉ sản phẩm |
| tinh_thanh_pho_id | bigint | Tỉnh/thành phố |
| quan_huyen_id | bigint | Quận/huyện |
| ngay_thu_hoach | date | Ngày thu hoạch |
| trang_thai | text | dang_ban, da_an, het_hang |
| ngay_tao | timestamp | Ngày tạo |
| ngay_cap_nhat | timestamp | Ngày cập nhật |

### 3.4. Bảng hinh_anh_san_pham

| Cột | Kiểu dữ liệu | Ghi chú |
|---|---|---|
| id | uuid | Khóa chính |
| bai_dang_id | uuid | Bài đăng liên quan |
| hinh_anh_url | text | Link ảnh trong Supabase Storage |
| ngay_tao | timestamp | Ngày tạo |

### 3.5. Bảng yeu_cau_mua

| Cột | Kiểu dữ liệu | Ghi chú |
|---|---|---|
| id | uuid | Khóa chính |
| bai_dang_id | uuid | Sản phẩm được yêu cầu mua |
| thuong_lai_id | uuid | Thương lái gửi yêu cầu |
| nong_dan_id | uuid | Nông dân nhận yêu cầu |
| so_luong_muon_mua | numeric | Số lượng muốn mua |
| gia_de_xuat | numeric | Giá đề xuất |
| ghi_chu | text | Ghi chú |
| trang_thai | text | cho_phan_hoi, da_chap_nhan, da_tu_choi, da_huy |
| ngay_tao | timestamp | Ngày tạo |
| ngay_cap_nhat | timestamp | Ngày cập nhật |

### 3.6. Bảng giao_dich

| Cột | Kiểu dữ liệu | Ghi chú |
|---|---|---|
| id | uuid | Khóa chính |
| yeu_cau_mua_id | uuid | Yêu cầu mua liên quan |
| bai_dang_id | uuid | Bài đăng liên quan |
| nong_dan_id | uuid | Người bán |
| thuong_lai_id | uuid | Người mua |
| so_luong | numeric | Số lượng giao dịch |
| don_gia | numeric | Đơn giá |
| tong_tien | numeric | Thành tiền |
| trang_thai | text | cho_giao_hang, dang_giao, hoan_thanh, da_huy |
| ngay_tao | timestamp | Ngày tạo |
| ngay_cap_nhat | timestamp | Ngày cập nhật |
| ngay_hoan_thanh | timestamp | Ngày hoàn thành |

### 3.7. Bảng tin_nhan

| Cột | Kiểu dữ liệu | Ghi chú |
|---|---|---|
| id | uuid | Khóa chính |
| giao_dich_id | uuid | Giao dịch liên quan |
| nguoi_gui_id | uuid | Người gửi |
| nguoi_nhan_id | uuid | Người nhận |
| noi_dung | text | Nội dung tin nhắn |
| da_doc | boolean | Đã đọc hay chưa |
| ngay_tao | timestamp | Thời gian gửi |

### 3.8. Bảng danh_gia

| Cột | Kiểu dữ liệu | Ghi chú |
|---|---|---|
| id | uuid | Khóa chính |
| giao_dich_id | uuid | Giao dịch liên quan |
| nguoi_danh_gia_id | uuid | Người đánh giá |
| nguoi_duoc_danh_gia_id | uuid | Người được đánh giá |
| so_sao | int | Số sao từ 1 đến 5 |
| nhan_xet | text | Nhận xét |
| ngay_tao | timestamp | Ngày tạo |

### 3.9. Bảng thong_bao

| Cột | Kiểu dữ liệu | Ghi chú |
|---|---|---|
| id | uuid | Khóa chính |
| nguoi_dung_id | uuid | Người nhận |
| tieu_de | text | Tiêu đề |
| noi_dung | text | Nội dung |
| loai | text | Loại thông báo |
| da_doc | boolean | Đã đọc hay chưa |
| ngay_tao | timestamp | Ngày tạo |

### 3.10. Bảng tinh_thanh_pho

Lưu danh sách tỉnh/thành phố để dùng chung trong hồ sơ người dùng, bài đăng và bộ lọc sản phẩm.

| Cột | Kiểu dữ liệu | Ghi chú |
|---|---|---|
| id | bigint | Khóa chính |
| ten | text | Tên tỉnh/thành phố |
| ma | text | Mã tỉnh/thành phố nếu có |
| dang_hoat_dong | boolean | Có đang sử dụng hay không |
| ngay_tao | timestamp | Ngày tạo |

### 3.11. Bảng quan_huyen

Lưu danh sách quận/huyện thuộc một tỉnh/thành phố.

| Cột | Kiểu dữ liệu | Ghi chú |
|---|---|---|
| id | bigint | Khóa chính |
| tinh_thanh_pho_id | bigint | Tỉnh/thành phố cha |
| ten | text | Tên quận/huyện |
| ma | text | Mã quận/huyện nếu có |
| dang_hoat_dong | boolean | Có đang sử dụng hay không |
| ngay_tao | timestamp | Ngày tạo |

## 4. Quan hệ giữa các bảng

- Một người dùng có thể tạo nhiều bài đăng.
- Một danh mục có nhiều bài đăng.
- Một bài đăng có nhiều ảnh.
- Một bài đăng có nhiều yêu cầu mua.
- Một yêu cầu mua thuộc về một thương lái và một nông dân.
- Một yêu cầu mua được chấp nhận sẽ tạo một giao dịch.
- Một giao dịch có nhiều tin nhắn.
- Một giao dịch có thể có nhiều đánh giá.
- Một người dùng có nhiều thông báo.
- Một tỉnh/thành phố có nhiều quận/huyện.
- Một người dùng thuộc một tỉnh/thành phố và một quận/huyện.
- Một bài đăng thuộc một tỉnh/thành phố và một quận/huyện.

## 5. Truy vấn thống kê cho dashboard

Dashboard sử dụng các truy vấn tổng hợp từ dữ liệu có sẵn, không cần tạo thêm bảng báo cáo riêng.

### 5.1. Dashboard nông dân

- Tổng số bài đăng của nông dân.
- Số bài đăng còn hàng.
- Số bài đăng hết hàng.
- Số yêu cầu mua đang chờ.
- Số giao dịch đang giao.
- Số giao dịch hoàn thành.
- Tổng doanh thu từ giao dịch hoàn thành.
- Danh sách giao dịch gần đây.
- Top nông sản bán nhiều nếu còn thời gian.

### 5.2. Dashboard thương lái

- Tổng số yêu cầu mua đã gửi.
- Số yêu cầu đang chờ.
- Số yêu cầu đã được chấp nhận.
- Số giao dịch đang giao.
- Số giao dịch hoàn thành.
- Tổng tiền đã mua từ giao dịch hoàn thành.
- Danh sách đơn mua gần đây.
- Top loại nông sản đã mua nếu còn thời gian.

### 5.3. Dashboard admin

- Tổng số người dùng.
- Tổng số nông dân.
- Tổng số thương lái.
- Tổng số bài đăng.
- Tổng số giao dịch.
- Tổng số giao dịch hoàn thành.
- Tổng doanh thu hệ thống.

## 6. Gợi ý chính sách bảo mật Supabase

Khi dùng Supabase, nên bật Row Level Security cho các bảng chính.

Gợi ý:

- Người dùng chỉ được xem và sửa hồ sơ của chính mình.
- Nông dân chỉ được sửa bài đăng của mình.
- Thương lái chỉ được tạo yêu cầu mua bằng tài khoản của mình.
- Nông dân chỉ được xử lý yêu cầu mua gửi đến bài đăng của mình.
- Người dùng chỉ xem được giao dịch có liên quan đến mình.
- Người dùng chỉ xem được thống kê thuộc dữ liệu của mình.
- Admin được quyền xem và quản lý toàn bộ dữ liệu.

## 7. Lợi ích của dữ liệu tỉnh/huyện dùng chung

- Nông dân không phải nhập tay khu vực khi đăng bài.
- Thương lái lọc sản phẩm chính xác hơn.
- Tránh lỗi sai chính tả như "TP HCM", "TP.Hồ Chí Minh", "Hồ Chí Minh".
- Dễ thống kê sản phẩm và giao dịch theo khu vực.
- Admin có thể chủ động thêm, sửa hoặc ẩn tỉnh/huyện khi cần.
