# AgroNova - Ứng dụng kết nối nông dân và thương lái

## 1. Giới thiệu đề tài

Đề tài xây dựng ứng dụng Android hỗ trợ kết nối giữa nông dân có nhu cầu bán nông sản và thương lái có nhu cầu tìm kiếm nguồn hàng. Hệ thống cho phép nông dân đăng bán sản phẩm, thương lái tìm kiếm và gửi yêu cầu mua, hai bên trao đổi thông tin, theo dõi giao dịch và đánh giá sau khi hoàn thành.

Ứng dụng hướng đến việc giảm khoảng cách giữa người bán và người mua, hỗ trợ tiêu thụ nông sản nhanh hơn, minh bạch hơn và dễ quản lý hơn.

## 2. Mục tiêu

- Xây dựng hệ thống đăng ký, đăng nhập và phân quyền người dùng, có xác thực email bằng OTP khi đăng ký.
- Cho phép nông dân đăng bán, chỉnh sửa và quản lý bài đăng nông sản.
- Cho phép thương lái tìm kiếm, lọc và gửi yêu cầu mua nông sản.
- Quản lý quy trình giao dịch từ lúc gửi yêu cầu mua đến khi hoàn thành.
- Hỗ trợ nhắn tin cơ bản giữa nông dân và thương lái.
- Hỗ trợ đánh giá uy tín sau giao dịch.
- Cung cấp dashboard thống kê đơn giản cho nông dân, thương lái và admin.
- Cho phép admin quản lý người dùng, danh mục, bài đăng và giao dịch.

## 3. Vai trò người dùng

| Vai trò | Mô tả |
|---|---|
| Nông dân | Người đăng bán nông sản và xử lý yêu cầu mua |
| Thương lái | Người tìm kiếm nông sản và gửi yêu cầu mua |
| Admin | Người quản trị và giám sát toàn bộ hệ thống |

## 4. Phạm vi đã chốt

Hệ thống được chốt ở mức vừa sức cho đồ án cơ sở 2:

- 9 module chính và 1 module dữ liệu nền.
- Khoảng 45-50 chức năng nếu tính gộp phần tỉnh/huyện vào admin và sản phẩm.
- 11 bảng cơ sở dữ liệu chính.
- Không làm các phần quá lớn như thanh toán online, bản đồ, xuất báo cáo PDF/Excel, dự báo giá hoặc chat nâng cao.

## 5. Module chính

| STT | Module | Mục đích |
|---|---|---|
| 1 | User Module | Đăng ký, đăng nhập, phân quyền, hồ sơ |
| 2 | Product Module | Đăng bán, upload ảnh, tìm kiếm, lọc sản phẩm |
| 3 | Purchase Request Module | Gửi và xử lý yêu cầu mua |
| 4 | Transaction Module | Tạo, theo dõi và hoàn thành giao dịch |
| 5 | Chat Module | Nhắn tin văn bản theo giao dịch |
| 6 | Review Module | Chấm sao, nhận xét, điểm uy tín |
| 7 | Dashboard Module | Thống kê tổng quan theo từng vai trò |
| 8 | Partner Directory Module| Khám phá danh bạ và kết nối nhanh đối tác |
| 9 | Admin Module | Quản trị người dùng, danh mục, bài đăng, giao dịch |

## 6. Module dữ liệu nền

| Module | Mục đích |
|---|---|
| Location Master Data | Quản lý tỉnh/thành phố và quận/huyện để người dùng chọn từ dropdown, giúp dữ liệu khu vực đồng nhất |

Module này gồm 2 bảng chính: `tinh_thanh_pho` và `quan_huyen`. Admin quản lý danh sách tỉnh/huyện. Nông dân chọn khu vực khi đăng bài, thương lái chọn khu vực khi lọc sản phẩm.

## 7. Công nghệ dự kiến

| Thành phần | Công nghệ |
|---|---|
| Frontend | Android Studio, Java |
| Backend | Supabase |
| Database | PostgreSQL trên Supabase |
| Authentication | Supabase Auth |
| Storage | Supabase Storage |
| Realtime | Supabase Realtime, dùng sau nếu cần |
| Quản lý mã nguồn | Git, GitHub |

## 8. Cấu trúc tài liệu

```text
App Nong San/
├── README.md
└── docs/
    ├── chuc-nang.md
    ├── co-so-du-lieu.md
    ├── cong-nghe-su-dung.md
    ├── ke-hoach-trien-khai.md
    ├── supabase-setup.md
    ├── thiet-ke-chi-tiet.md
    └── vi-du-thuc-te.md
```

## 9. Nhận xét về Supabase

Supabase là lựa chọn phù hợp cho đề tài này vì cung cấp sẵn authentication, PostgreSQL, storage và realtime. Nhờ đó, nhóm có thể tập trung vào nghiệp vụ ứng dụng thay vì phải tự xây dựng toàn bộ backend từ đầu.

Trong phiên bản chính, nên ưu tiên hoàn thành CRUD, upload ảnh, yêu cầu mua, giao dịch, dashboard và admin trước. Realtime chat hoặc realtime notification chỉ nên nâng cấp sau khi các luồng chính đã ổn định.
