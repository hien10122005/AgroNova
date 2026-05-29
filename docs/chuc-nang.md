# Mô tả chức năng ứng dụng

## 1. Tổng quan

Ứng dụng kết nối nông dân và thương lái được thiết kế theo hướng marketplace đơn giản. Nông dân đăng bán nông sản, thương lái tìm kiếm sản phẩm và gửi yêu cầu mua. Khi nông dân chấp nhận yêu cầu, hệ thống tạo giao dịch để hai bên theo dõi.

Phạm vi đã chốt gồm 8 module chính và 1 module dữ liệu nền, khoảng 45-50 chức năng. Hệ thống tập trung vào luồng nghiệp vụ chính: đăng bán nông sản, tìm kiếm, gửi yêu cầu mua, tạo giao dịch, chat cơ bản, đánh giá, dashboard, quản trị và quản lý dữ liệu khu vực.

## 2. Chức năng theo vai trò

### 2.1. Nông dân

Nông dân là người có nông sản cần bán.

Chức năng:

- Đăng ký tài khoản.
- Đăng nhập, đăng xuất.
- Cập nhật hồ sơ cá nhân.
- Đăng bài bán nông sản.
- Upload ảnh sản phẩm.
- Quản lý bài đăng của bản thân.
- Sửa, xóa hoặc ẩn bài đăng.
- Cập nhật trạng thái sản phẩm: còn hàng, hết hàng, tạm ẩn.
- Xem danh sách yêu cầu mua từ thương lái.
- Chấp nhận hoặc từ chối yêu cầu mua.
- Theo dõi danh sách giao dịch.
- Cập nhật trạng thái giao hàng.
- Nhắn tin với thương lái.
- Đánh giá thương lái sau khi giao dịch hoàn thành.
- Xem danh bạ Thương lái (Partner Directory).
- Xem hồ sơ đối tác và kết nối nhanh.
- Xem dashboard bán hàng cá nhân.

### 2.2. Thương lái

Thương lái là người có nhu cầu tìm và mua nông sản.

Chức năng:

- Đăng ký tài khoản.
- Đăng nhập, đăng xuất.
- Cập nhật hồ sơ cá nhân.
- Xem danh sách nông sản đang bán.
- Tìm kiếm nông sản theo tên.
- Lọc nông sản theo loại, khu vực và khoảng giá.
- Xem chi tiết sản phẩm.
- Gửi yêu cầu mua.
- Xem các yêu cầu mua đã gửi.
- Theo dõi trạng thái giao dịch.
- Xác nhận đã nhận hàng.
- Nhắn tin với nông dân.
- Đánh giá nông dân sau khi giao dịch hoàn thành.
- Xem danh bạ Nông dân (Partner Directory).
- Xem hồ sơ đối tác và tìm kiếm nguồn cung nhanh.
- Xem dashboard mua hàng cá nhân.

### 2.3. Admin

Admin là người quản trị hệ thống.

Chức năng:

- Đăng nhập trang quản trị.
- Xem dashboard tổng quan.
- Quản lý người dùng.
- Khóa hoặc mở khóa tài khoản.
- Quản lý danh mục nông sản.
- Quản lý tỉnh/thành phố và quận/huyện.
- Quản lý bài đăng.
- Ẩn hoặc xóa bài đăng vi phạm.
- Quản lý giao dịch.

## 3. Module chức năng

### 3.1. User Module

Quản lý tài khoản và thông tin người dùng.

Chức năng chính:

- Đăng ký, có xác thực email qua OTP.
- Đăng nhập.
- Đăng xuất.
- Phân quyền người dùng.
- Cập nhật hồ sơ.
- Quên mật khẩu (gửi OTP qua email).

### 3.2. Product Module

Quản lý bài đăng nông sản.

Chức năng chính:

- Thêm bài đăng.
- Sửa bài đăng.
- Xóa hoặc ẩn bài đăng.
- Upload ảnh sản phẩm.
- Cập nhật trạng thái sản phẩm.
- Xem danh sách sản phẩm.
- Xem chi tiết sản phẩm.
- Tìm kiếm sản phẩm.
- Lọc theo danh mục, khu vực và giá.
- Quản lý bài đăng của tôi.

### 3.3. Purchase Request Module

Quản lý yêu cầu mua từ thương lái.

Chức năng chính:

- Thương lái gửi yêu cầu mua.
- Thương lái xem yêu cầu đã gửi.
- Nông dân xem yêu cầu nhận được.
- Nông dân chấp nhận yêu cầu.
- Nông dân từ chối yêu cầu.
- Thương lái hủy yêu cầu khi yêu cầu chưa được xử lý.

Trạng thái yêu cầu mua:

| Trạng thái | Ý nghĩa |
|---|---|
| cho_phan_hoi | Chờ nông dân phản hồi |
| da_chap_nhan | Đã được chấp nhận |
| da_tu_choi | Đã bị từ chối |
| da_huy | Đã bị hủy bởi thương lái |

### 3.4. Transaction Module

Quản lý quá trình giao dịch sau khi yêu cầu mua được chấp nhận.

Chức năng chính:

- Tạo giao dịch từ yêu cầu mua đã được chấp nhận.
- Xem danh sách giao dịch.
- Xem chi tiết giao dịch.
- Cập nhật trạng thái đang giao hàng.
- Xác nhận đã nhận hàng.
- Hoàn thành giao dịch.
- Hủy giao dịch.

Trạng thái giao dịch:

| Trạng thái | Ý nghĩa |
|---|---|
| cho_giao_hang | Chờ giao hàng |
| dang_giao | Đang giao hàng |
| hoan_thanh | Hoàn thành |
| da_huy | Đã hủy |

### 3.5. Chat Module

Hỗ trợ trao đổi giữa nông dân và thương lái.

Chức năng chính:

- Gửi tin nhắn văn bản.
- Xem lịch sử tin nhắn.
- Chat theo giao dịch.

Không làm trong bản chính:

- Gửi hình ảnh trong chat.
- Trạng thái đang nhập.
- Thu hồi tin nhắn.
- Đã xem nâng cao.

### 3.6. Review Module

Đánh giá uy tín người dùng sau giao dịch.

Chức năng chính:

- Chấm sao từ 1 đến 5.
- Viết nhận xét.
- Xem điểm đánh giá trung bình.

### 3.7. Dashboard Module

Hiển thị thống kê tổng quan cho từng vai trò. Module này chỉ làm ở mức đơn giản, không xuất file báo cáo và không cần biểu đồ phức tạp.

Chức năng cho nông dân:

- Xem tổng số bài đăng.
- Xem số sản phẩm còn hàng và hết hàng.
- Xem số yêu cầu mua đang chờ.
- Xem số giao dịch đang giao.
- Xem số giao dịch hoàn thành.
- Xem tổng doanh thu từ giao dịch hoàn thành.
- Xem danh sách đơn hàng gần đây.
- Xem top nông sản bán nhiều nếu còn thời gian.

Chức năng cho thương lái:

- Xem tổng số yêu cầu mua đã gửi.
- Xem số yêu cầu đang chờ phản hồi.
- Xem số yêu cầu đã được chấp nhận.
- Xem số giao dịch đang giao.
- Xem số giao dịch hoàn thành.
- Xem tổng tiền đã mua.
- Xem danh sách đơn mua gần đây.
- Xem top loại nông sản đã mua nếu còn thời gian.

Chức năng cho admin:

- Xem tổng số người dùng.
- Xem tổng số bài đăng.
- Xem tổng số giao dịch.
- Xem tổng số giao dịch hoàn thành.
- Xem tổng doanh thu hệ thống.

### 3.8. Admin Module

Quản trị dữ liệu và hoạt động hệ thống.

Chức năng chính:

- Quản lý người dùng.
- Khóa hoặc mở khóa tài khoản.
- Quản lý danh mục.
- Quản lý tỉnh/thành phố.
- Quản lý quận/huyện.
- Quản lý bài đăng.
- Quản lý giao dịch.

### 3.9. Location Master Data Module

Quản lý dữ liệu tỉnh/thành phố và quận/huyện dùng chung cho toàn hệ thống. Module này giúp dữ liệu khu vực đồng nhất, tránh tình trạng người dùng nhập sai chính tả hoặc nhập nhiều cách khác nhau.

Chức năng chính:

- Admin thêm, sửa, xóa tỉnh/thành phố.
- Admin thêm, sửa, xóa quận/huyện theo tỉnh/thành phố.
- Nông dân chọn tỉnh/thành phố và quận/huyện bằng dropdown khi cập nhật hồ sơ.
- Nông dân chọn tỉnh/thành phố và quận/huyện bằng dropdown khi đăng bài.
- Thương lái lọc sản phẩm theo tỉnh/thành phố và quận/huyện bằng dropdown.
- Hệ thống lưu `tinh_thanh_pho_id` và `quan_huyen_id` thay vì chỉ lưu tên dạng text.

### 3.10. Partner Directory Module

Kết nối trực tiếp nông dân và thương lái thông qua danh bạ cộng đồng (Cộng đồng Đối tác).

Chức năng chính:

- Xem danh sách nông dân uy tín (dành cho thương lái).
- Xem danh sách thương lái thu mua lớn (dành cho nông dân).
- Tìm kiếm đối tác theo tên hoặc vai trò.
- Lọc đối tác theo khu vực (Tỉnh/Thành phố).
- Xem thông tin tổng quan trên thẻ đối tác (Avatar, Đánh giá sao, Vị trí).
- Nút truy cập nhanh: Xem hồ sơ chi tiết hoặc Nhắn tin trực tiếp.

## 4. Chức năng ưu tiên

### 4.1. Chức năng bắt buộc

- Đăng ký, xác thực email bằng OTP, đăng nhập, phân quyền.
- Quản lý hồ sơ người dùng.
- Đăng bán nông sản.
- Upload ảnh sản phẩm.
- Xem danh sách và chi tiết sản phẩm.
- Tìm kiếm, lọc sản phẩm.
- Gửi yêu cầu mua.
- Chấp nhận hoặc từ chối yêu cầu mua.
- Tạo và theo dõi giao dịch.
- Xem Danh bạ Đối tác (Partner Directory) để chủ động kết nối.
- Dashboard đơn giản cho từng vai trò.
- Admin quản lý người dùng, bài đăng, danh mục và giao dịch.
- Quản lý tỉnh/thành phố và quận/huyện để dùng trong form đăng bài và form lọc.

### 4.2. Chức năng nên làm

- Chat cơ bản.
- Đánh giá sau giao dịch.
- Thông báo đơn giản trong ứng dụng.
- Top sản phẩm bán nhiều hoặc top loại sản phẩm đã mua.

### 4.3. Chức năng mở rộng

- Chat realtime nâng cao.
- Gửi hình ảnh trong chat.
- Báo cáo vi phạm.
- Sản phẩm yêu thích.
- Quản lý giá nông sản thị trường.
- Thanh toán online.
- Bản đồ vị trí vùng nông sản.
- Xuất báo cáo PDF hoặc Excel.
- OTP số điện thoại.
- Đăng nhập Google hoặc Facebook.

## 5. Tổng số module và chức năng

| Module | Số chức năng dự kiến |
|---|---:|
| User Module | 6 |
| Product Module | 10 |
| Purchase Request Module | 6 |
| Transaction Module | 7 |
| Chat Module | 3 |
| Review Module | 3 |
| Dashboard Module | 8 |
| Admin Module | 7 |
| Location Master Data Module | 6 |
| Partner Directory Module | 5 |
| Tổng | 56 |

Nếu tính gộp Location Master Data vào Admin Module và Product Module, số chức năng thực tế có thể trình bày khoảng 45-50 chức năng để báo cáo gọn hơn.
