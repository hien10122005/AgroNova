# Ví dụ thực tế

Tài liệu này mô tả một vòng đời giao dịch hoàn chỉnh trong ứng dụng, có sử dụng dữ liệu tỉnh/thành phố và quận/huyện để đồng nhất dữ liệu khu vực.

## 1. Nhân vật ví dụ

| Nhân vật | Vai trò | Mô tả |
|---|---|---|
| Anh Ba | Nông dân | Trồng sầu riêng tại Tiền Giang |
| Chị Lan | Thương lái | Thu mua nông sản tại TP.HCM |
| Admin Hùng | Admin | Quản lý hệ thống |

## 2. Admin chuẩn bị dữ liệu nền

Admin Hùng tạo danh mục nông sản:

| ID | Tên danh mục |
|---|---|
| 1 | Trái cây |
| 2 | Rau củ |
| 3 | Lúa gạo |
| 4 | Cà phê |
| 5 | Hồ tiêu |

Admin Hùng tạo dữ liệu khu vực:

```text
tinh_thanh_pho:
- Tiền Giang
- TP.HCM

quan_huyen:
- Cai Lậy, thuộc Tiền Giang
- Thủ Đức, thuộc TP.HCM
```

Các dữ liệu này sẽ được dùng trong dropdown khi người dùng cập nhật hồ sơ, đăng bài và lọc sản phẩm.

## 3. Đăng ký tài khoản — có OTP email

Anh Ba đăng ký tài khoản nông dân:

```text
Họ tên: Nguyễn Văn Ba
Số điện thoại: 0987654321
Email: ba.nguyen@gmail.com
Vai trò: Nông dân
Tỉnh/thành phố: Tiền Giang
Quận/huyện: Cai Lậy

[ĐĂNG KÝ] → Gửi OTP đến email ba.nguyen@gmail.com
```

Anh Ba mở Gmail, thấy mã OTP: **847291**

```text
Nhập OTP: [8][4][7][2][9][1]

[XÁC THỰC] → OTP đúng → Tạo tài khoản thành công
```

Chị Lan đăng ký tài khoản thương lái:

```text
Họ tên: Trần Thị Lan
Số điện thoại: 0912345678
Email: lan.tran@gmail.com
Vai trò: Thương lái
Tỉnh/thành phố: TP.HCM
Quận/huyện: Thủ Đức

[ĐĂNG KÝ] → Gửi OTP → Nhập OTP → Xác thực
```

Hệ thống xử lý:
1. Gửi mã OTP 6 số đến email qua Supabase Auth (`signInWithOtp`).
2. Người dùng nhập OTP, hệ thống xác thực (`verifyOtp`).
3. Nếu đúng, tạo tài khoản Auth + lưu `tinh_thanh_pho_id`, `quan_huyen_id` vào bảng `nguoi_dung`.
4. Nếu sai, yêu cầu nhập lại hoặc gửi lại mã mới.

## 4. Nông dân đăng bán nông sản

Anh Ba đăng bài bán sầu riêng.

```text
Tên sản phẩm: Sầu riêng Ri6 loại 1
Danh mục: Trái cây
Số lượng: 500
Đơn vị: kg
Giá bán: 75000
Tỉnh/thành phố: Tiền Giang
Quận/huyện: Cai Lậy
Ngày thu hoạch: 2026-06-05
Mô tả: Sầu riêng Ri6 chín tự nhiên, trái đều, giao trong ngày.
Trạng thái: dang_ban
```

Hệ thống xử lý:

1. Lưu thông tin vào bảng `bai_dang_san_pham`.
2. Lưu `tinh_thanh_pho_id` và `quan_huyen_id` theo dropdown đã chọn.
3. Upload ảnh vào Supabase Storage.
4. Lưu link ảnh vào bảng `hinh_anh_san_pham`.
5. Hiển thị bài đăng trong danh sách sản phẩm.

## 5. Thương lái tìm kiếm sản phẩm

Chị Lan mở danh sách nông sản và lọc:

```text
Từ khóa: sầu riêng
Danh mục: Trái cây
Tỉnh/thành phố: Tiền Giang
Quận/huyện: Cai Lậy
Khoảng giá: 60000 - 90000
```

Hệ thống trả về bài đăng "Sầu riêng Ri6 loại 1" của Anh Ba.

## 6. Thương lái gửi yêu cầu mua

Chị Lan xem chi tiết sản phẩm và gửi yêu cầu mua.

```text
Sản phẩm: Sầu riêng Ri6 loại 1
Số lượng muốn mua: 300 kg
Giá đề xuất: 73000 / kg
Ghi chú: Có thể lấy hàng trong 2 ngày tới.
Trạng thái: cho_phan_hoi
```

Hệ thống xử lý:

1. Lưu yêu cầu vào bảng `yeu_cau_mua`.
2. Gửi thông báo đơn giản cho Anh Ba.
3. Hiển thị yêu cầu trong màn hình "Yêu cầu mua nhận được" của nông dân.

## 7. Nông dân xử lý yêu cầu mua

Anh Ba mở yêu cầu mua của Chị Lan và chọn "Chấp nhận".

Hệ thống xử lý:

1. Cập nhật yêu cầu mua sang `da_chap_nhan`.
2. Tạo một giao dịch mới trong bảng `giao_dich`.
3. Trạng thái giao dịch ban đầu là `cho_giao_hang`.

Thông tin giao dịch:

```text
Người bán: Nguyễn Văn Ba
Người mua: Trần Thị Lan
Sản phẩm: Sầu riêng Ri6 loại 1
Số lượng: 300 kg
Đơn giá: 73000
Tổng tiền: 21900000
Trạng thái: cho_giao_hang
```

## 8. Chat và hoàn thành giao dịch

Hai bên trao đổi trong màn hình chat:

```text
Anh Ba: Tôi có thể giao hàng vào sáng mai.
Chị Lan: Dạ được, anh giao về Thủ Đức giúp em.
Anh Ba: Tôi sẽ cập nhật trạng thái khi bắt đầu giao.
```

Anh Ba cập nhật:

```text
cho_giao_hang -> dang_giao
```

Chị Lan nhận hàng và xác nhận:

```text
dang_giao -> hoan_thanh
```

## 9. Đánh giá sau giao dịch

Chị Lan đánh giá Anh Ba:

```text
Số sao: 5
Nhận xét: Hàng đúng mô tả, giao đúng hẹn.
```

Anh Ba đánh giá Chị Lan:

```text
Số sao: 5
Nhận xét: Thanh toán nhanh, trao đổi rõ ràng.
```

## 10. Dashboard

Dashboard nông dân:

| Chỉ số | Giá trị |
|---|---:|
| Tổng bài đăng | 1 |
| Sản phẩm còn hàng | 1 |
| Yêu cầu mua đang chờ | 0 |
| Giao dịch đang giao | 0 |
| Giao dịch hoàn thành | 1 |
| Doanh thu | 21.900.000 |

Dashboard thương lái:

| Chỉ số | Giá trị |
|---|---:|
| Yêu cầu mua đã gửi | 1 |
| Yêu cầu đang chờ | 0 |
| Yêu cầu đã chấp nhận | 1 |
| Giao dịch đang giao | 0 |
| Giao dịch hoàn thành | 1 |
| Tổng tiền đã mua | 21.900.000 |

Dashboard admin:

| Chỉ số | Giá trị |
|---|---:|
| Tổng người dùng | 3 |
| Tổng nông dân | 1 |
| Tổng thương lái | 1 |
| Tổng bài đăng | 1 |
| Tổng giao dịch | 1 |
| Giao dịch hoàn thành | 1 |
| Tổng doanh thu hệ thống | 21.900.000 |

## 11. Kết luận luồng demo

Luồng demo thể hiện đầy đủ chức năng cốt lõi:

- Admin quản lý danh mục và tỉnh/huyện.
- Người dùng đăng ký và chọn khu vực bằng dropdown.
- Nông dân đăng bán nông sản.
- Thương lái tìm kiếm, lọc theo tỉnh/huyện và gửi yêu cầu mua.
- Nông dân chấp nhận yêu cầu.
- Hệ thống tạo giao dịch.
- Hai bên chat theo giao dịch.
- Cập nhật trạng thái giao dịch.
- Đánh giá sau giao dịch.
- Dashboard theo từng vai trò.
