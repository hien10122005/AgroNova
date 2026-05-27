# Thiết kế chi tiết

## 1. Phạm vi thiết kế

Tài liệu này mô tả chi tiết các trạng thái, luồng nghiệp vụ, màn hình và truy vấn chính của ứng dụng kết nối nông dân và thương lái.

Phạm vi đã chốt:

- Không làm thanh toán online.
- Không làm OTP số điện thoại.
- Không làm đăng nhập Google hoặc Facebook.
- Không làm bản đồ vị trí.
- Không làm chat gửi hình ảnh.
- Không xuất báo cáo PDF hoặc Excel.
- Không làm quản lý giá nông sản thị trường trong bản chính.
- Có làm dữ liệu nền tỉnh/thành phố và quận/huyện để đồng nhất dữ liệu khu vực.

## 2. State Machine

### 2.1. Trạng thái bài đăng

Bảng: `bai_dang_san_pham`

| Trạng thái | Ý nghĩa |
|---|---|
| dang_ban | Bài đăng đang hiển thị |
| da_an | Nông dân đã ẩn bài đăng |
| het_hang | Sản phẩm đã hết hàng |

Luồng trạng thái:

```text
dang_ban -> da_an
dang_ban -> het_hang
da_an -> dang_ban
het_hang -> dang_ban
```

Ghi chú:

- Không dùng trạng thái duyệt bài phức tạp trong bản chính để giảm độ khó.
- Admin vẫn có thể ẩn hoặc xóa bài đăng vi phạm.

### 2.2. Trạng thái yêu cầu mua

Bảng: `yeu_cau_mua`

| Trạng thái | Ý nghĩa |
|---|---|
| cho_phan_hoi | Chờ nông dân phản hồi |
| da_chap_nhan | Nông dân đã chấp nhận |
| da_tu_choi | Nông dân đã từ chối |
| da_huy | Thương lái đã hủy |

Luồng trạng thái:

```text
cho_phan_hoi -> da_chap_nhan
cho_phan_hoi -> da_tu_choi
cho_phan_hoi -> da_huy
```

Quy tắc:

- Chỉ nông dân sở hữu bài đăng mới được chấp nhận hoặc từ chối yêu cầu.
- Chỉ thương lái tạo yêu cầu mới được hủy yêu cầu.
- Chỉ được hủy khi yêu cầu còn ở trạng thái `cho_phan_hoi`.
- Khi yêu cầu chuyển sang `da_chap_nhan`, hệ thống tạo một giao dịch mới.

### 2.3. Trạng thái giao dịch

Bảng: `giao_dich`

| Trạng thái | Ý nghĩa |
|---|---|
| cho_giao_hang | Chờ giao hàng |
| dang_giao | Đang giao hàng |
| hoan_thanh | Hoàn thành |
| da_huy | Đã hủy |

Luồng trạng thái:

```text
cho_giao_hang -> dang_giao -> hoan_thanh
cho_giao_hang -> da_huy
dang_giao -> da_huy
```

Quy tắc:

- Giao dịch được tạo khi yêu cầu mua được chấp nhận.
- Nông dân cập nhật từ `cho_giao_hang` sang `dang_giao`.
- Thương lái xác nhận nhận hàng để chuyển sang `hoan_thanh`.
- Giao dịch `hoan_thanh` không được hủy.
- Chỉ giao dịch `hoan_thanh` mới được đánh giá.

## 3. Luồng nghiệp vụ chính

### 3.0. Luồng đăng ký — có OTP email

1. Người dùng nhập email, mật khẩu, họ tên, vai trò, tỉnh/thành phố, quận/huyện.
2. Hệ thống gửi mã OTP 6 số đến email qua Supabase Auth (`signInWithOtp`).
3. Người dùng mở email, copy mã OTP nhập vào app.
4. Hệ thống xác thực OTP (`verifyOtp`).
5. Nếu OTP đúng, tạo tài khoản trong Supabase Auth.
6. Tạo bản ghi trong bảng `nguoi_dung` với vai trò tương ứng.
7. Chuyển người dùng vào giao diện chính theo role.

Lưu ý: Nếu OTP sai, người dùng có thể yêu cầu gửi lại mã. Mỗi mã OTP có thời hạn 5 phút.

### 3.1. Luồng đăng bán nông sản

1. Nông dân đăng nhập.
2. Chọn thêm bài đăng.
3. Nhập tên sản phẩm, danh mục, số lượng, đơn vị, giá và mô tả.
4. Chọn tỉnh/thành phố và quận/huyện từ dropdown.
5. Upload ảnh sản phẩm.
6. Lưu bài đăng với trạng thái `dang_ban`.
7. Bài đăng hiển thị trong danh sách sản phẩm.

### 3.2. Luồng tìm kiếm và gửi yêu cầu mua

1. Thương lái đăng nhập.
2. Xem danh sách nông sản.
3. Tìm kiếm hoặc lọc theo danh mục, tỉnh/thành phố, quận/huyện, khoảng giá.
4. Xem chi tiết sản phẩm.
5. Nhập số lượng cần mua, giá đề xuất và ghi chú.
6. Gửi yêu cầu mua.
7. Yêu cầu được lưu với trạng thái `cho_phan_hoi`.

### 3.3. Luồng xử lý yêu cầu mua

1. Nông dân mở danh sách yêu cầu mua nhận được.
2. Xem chi tiết yêu cầu.
3. Chấp nhận hoặc từ chối.
4. Nếu từ chối, yêu cầu chuyển sang `da_tu_choi`.
5. Nếu chấp nhận, yêu cầu chuyển sang `da_chap_nhan` và hệ thống tạo giao dịch.

### 3.4. Luồng giao dịch

1. Giao dịch được tạo với trạng thái `cho_giao_hang`.
2. Nông dân chuẩn bị hàng và cập nhật `dang_giao`.
3. Thương lái nhận hàng và xác nhận.
4. Giao dịch chuyển sang `hoan_thanh`.
5. Hai bên có thể đánh giá nhau.

### 3.5. Luồng chat

1. Hai bên mở chi tiết giao dịch.
2. Chọn chức năng chat.
3. Gửi tin nhắn văn bản.
4. Hệ thống lưu tin nhắn vào bảng `tin_nhan`.
5. Màn hình chat hiển thị lịch sử tin nhắn theo giao dịch.

## 4. Danh sách màn hình đề xuất

### 4.1. Màn hình chung

| STT | Màn hình |
|---|---|
| 1 | Đăng nhập |
| 2 | Đăng ký |
| 3 | Hồ sơ cá nhân |
| 4 | Cập nhật hồ sơ |

### 4.2. Màn hình nông dân

| STT | Màn hình |
|---|---|
| 1 | Dashboard nông dân |
| 2 | Danh sách bài đăng của tôi |
| 3 | Thêm bài đăng |
| 4 | Sửa bài đăng |
| 5 | Yêu cầu mua nhận được |
| 6 | Chi tiết yêu cầu mua |
| 7 | Danh sách giao dịch |
| 8 | Chi tiết giao dịch |
| 9 | Chat |
| 10 | Đánh giá thương lái |

### 4.3. Màn hình thương lái

| STT | Màn hình |
|---|---|
| 1 | Dashboard thương lái |
| 2 | Danh sách nông sản |
| 3 | Tìm kiếm và lọc sản phẩm |
| 4 | Chi tiết sản phẩm |
| 5 | Gửi yêu cầu mua |
| 6 | Yêu cầu mua đã gửi |
| 7 | Danh sách giao dịch |
| 8 | Chi tiết giao dịch |
| 9 | Chat |
| 10 | Đánh giá nông dân |

### 4.4. Màn hình admin

| STT | Màn hình |
|---|---|
| 1 | Dashboard admin |
| 2 | Quản lý người dùng |
| 3 | Quản lý danh mục |
| 4 | Quản lý tỉnh/thành phố |
| 5 | Quản lý quận/huyện |
| 6 | Quản lý bài đăng |
| 7 | Quản lý giao dịch |

Tổng số màn hình dự kiến: khoảng 25-30 màn hình.

## 5. Dashboard

### 5.1. Dashboard nông dân

- Tổng số bài đăng.
- Số bài còn hàng.
- Số bài hết hàng.
- Số yêu cầu mua đang chờ.
- Số giao dịch đang giao.
- Số giao dịch hoàn thành.
- Tổng doanh thu.
- Đơn hàng gần đây.

### 5.2. Dashboard thương lái

- Tổng số yêu cầu mua đã gửi.
- Số yêu cầu đang chờ.
- Số yêu cầu đã được chấp nhận.
- Số giao dịch đang giao.
- Số giao dịch hoàn thành.
- Tổng tiền đã mua.
- Đơn mua gần đây.

### 5.3. Dashboard admin

- Tổng người dùng.
- Tổng nông dân.
- Tổng thương lái.
- Tổng bài đăng.
- Tổng giao dịch.
- Tổng giao dịch hoàn thành.
- Tổng doanh thu hệ thống.

## 6. Truy vấn nghiệp vụ chính

- Lấy danh sách sản phẩm đang bán.
- Tìm kiếm sản phẩm theo tên.
- Lọc sản phẩm theo danh mục.
- Lọc sản phẩm theo khu vực.
- Lấy danh sách tỉnh/thành phố đang hoạt động.
- Lấy danh sách quận/huyện theo tỉnh/thành phố.
- Lọc sản phẩm theo khoảng giá.
- Lấy bài đăng của một nông dân.
- Lấy yêu cầu mua của một thương lái.
- Lấy yêu cầu mua gửi đến một nông dân.
- Tạo giao dịch từ yêu cầu mua đã được chấp nhận.
- Lấy giao dịch theo người dùng.
- Tính doanh thu của nông dân.
- Tính tổng tiền mua của thương lái.
- Tính điểm đánh giá trung bình.

## 7. Quy tắc bảo mật dữ liệu

- Người dùng chỉ sửa được hồ sơ của chính mình.
- Nông dân chỉ sửa được bài đăng của chính mình.
- Thương lái chỉ tạo và hủy được yêu cầu mua của chính mình.
- Nông dân chỉ xử lý yêu cầu mua thuộc bài đăng của mình.
- Người dùng chỉ xem được giao dịch có liên quan đến mình.
- Người dùng chỉ xem được tin nhắn trong giao dịch có liên quan đến mình.
- Admin được quyền quản lý toàn bộ dữ liệu chính.

## 8. Location Master Data

### 8.1. Mục đích

Location Master Data là dữ liệu dùng chung cho tỉnh/thành phố và quận/huyện. Tính năng này giúp các form trong hệ thống dùng dropdown thay vì nhập tay, từ đó dữ liệu khu vực thống nhất hơn.

### 8.2. Vai trò sử dụng

| Vai trò | Cách sử dụng |
|---|---|
| Admin | Thêm, sửa, ẩn tỉnh/thành phố và quận/huyện |
| Nông dân | Chọn tỉnh/thành phố, quận/huyện khi cập nhật hồ sơ và đăng bài |
| Thương lái | Lọc sản phẩm theo tỉnh/thành phố, quận/huyện |

### 8.3. Quy tắc

- `quan_huyen.tinh_thanh_pho_id` phải trỏ đến một bản ghi trong `tinh_thanh_pho`.
- Chỉ hiển thị tỉnh/huyện có `dang_hoat_dong = true` trong dropdown.
- Khi chọn tỉnh/thành phố, dropdown quận/huyện chỉ hiển thị dữ liệu thuộc tỉnh/thành phố đó.
- Bài đăng nên lưu `tinh_thanh_pho_id` và `quan_huyen_id`, không chỉ lưu tên tỉnh/huyện dạng text.
