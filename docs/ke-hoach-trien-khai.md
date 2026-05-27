# Kế hoạch triển khai

## 1. Mục tiêu triển khai

Mục tiêu là hoàn thành một ứng dụng Android có thể demo được đầy đủ luồng chính:

1. Nông dân đăng bán nông sản.
2. Thương lái tìm kiếm và gửi yêu cầu mua.
3. Nông dân chấp nhận yêu cầu.
4. Hệ thống tạo giao dịch.
5. Hai bên theo dõi trạng thái giao dịch.
6. Hai bên nhắn tin và đánh giá sau giao dịch.
7. Người dùng xem dashboard tổng quan.
8. Admin quản lý dữ liệu hệ thống.

## 2. Phạm vi phiên bản chính

Phiên bản chính tập trung vào các chức năng cốt lõi:

- Đăng ký, đăng nhập.
- Phân quyền nông dân, thương lái, admin.
- Quản lý hồ sơ.
- Đăng bán nông sản.
- Upload ảnh sản phẩm.
- Tìm kiếm và lọc nông sản.
- Gửi yêu cầu mua.
- Chấp nhận hoặc từ chối yêu cầu mua.
- Tạo và theo dõi giao dịch.
- Chat cơ bản.
- Đánh giá sau giao dịch.
- Dashboard đơn giản cho nông dân, thương lái và admin.
- Admin quản lý người dùng, danh mục, bài đăng và giao dịch.

## 3. Lộ trình 12 tuần

### Tuần 1: Phân tích và thiết kế

- Chốt phạm vi chức năng.
- Vẽ use case diagram.
- Vẽ activity diagram cho luồng mua bán.
- Thiết kế ERD.
- Tạo project Supabase.

Kết quả cần có:

- Tài liệu mô tả chức năng.
- Thiết kế cơ sở dữ liệu.
- Supabase project đã tạo.

### Tuần 2: Khởi tạo dự án

- Tạo project Android.
- Kết nối Android với Supabase.
- Tạo các bảng chính.
- Tạo bảng `tinh_thanh_pho` và `quan_huyen`.
- Tạo bucket lưu ảnh.
- Cấu hình authentication.

Kết quả cần có:

- Ứng dụng chạy được.
- Kết nối được với Supabase.
- Đăng ký, đăng nhập cơ bản.

### Tuần 3: User Module

- Hoàn thiện đăng ký có OTP email, đăng nhập, đăng xuất.
- Tích hợp Supabase Auth: gửi OTP (`signInWithOtp`) và xác thực (`verifyOtp`).
- Xử lý gửi lại OTP và timeout 5 phút.
- Lưu thông tin user vào bảng `nguoi_dung` sau khi OTP được xác thực.
- Phân quyền theo `nong_dan`, `thuong_lai`, `admin`.
- Làm màn hình hồ sơ cá nhân.
- Cập nhật thông tin cá nhân.
- Cho người dùng chọn tỉnh/thành phố và quận/huyện bằng dropdown.

Kết quả cần có:

- Người dùng đăng nhập và vào đúng giao diện theo vai trò.

### Tuần 4-5: Product Module

- Làm màn hình danh sách sản phẩm.
- Làm màn hình chi tiết sản phẩm.
- Làm màn hình thêm bài đăng.
- Upload ảnh sản phẩm lên Supabase Storage.
- Chọn tỉnh/thành phố và quận/huyện bằng dropdown khi đăng bài.
- Sửa, xóa, ẩn bài đăng.
- Cập nhật trạng thái sản phẩm.

Kết quả cần có:

- Nông dân đăng được sản phẩm.
- Thương lái xem được danh sách sản phẩm.

### Tuần 6: Tìm kiếm và lọc

- Tìm kiếm theo tên sản phẩm.
- Lọc theo danh mục.
- Lọc theo tỉnh/thành phố và quận/huyện.
- Lọc theo khoảng giá.
- Sắp xếp sản phẩm mới nhất.

Kết quả cần có:

- Thương lái tìm nguồn hàng thuận tiện.

### Tuần 7-8: Purchase Request và Transaction

- Gửi yêu cầu mua.
- Xem yêu cầu mua đã gửi.
- Nông dân xem yêu cầu mua nhận được.
- Chấp nhận hoặc từ chối yêu cầu.
- Tạo giao dịch khi yêu cầu được chấp nhận.
- Theo dõi trạng thái giao dịch.
- Cập nhật trạng thái đang giao hàng.
- Xác nhận hoàn thành giao dịch.

Kết quả cần có:

- Demo được luồng mua bán từ đầu đến cuối.

### Tuần 9: Chat và Review

- Tạo màn hình chat theo giao dịch.
- Gửi tin nhắn văn bản.
- Xem lịch sử tin nhắn.
- Đánh giá sau khi giao dịch hoàn thành.
- Tính điểm đánh giá trung bình.

Kết quả cần có:

- Hai bên có thể trao đổi và đánh giá trong giao dịch.

### Tuần 10: Dashboard và Admin Module

- Dashboard nông dân.
- Dashboard thương lái.
- Dashboard admin.
- Quản lý người dùng.
- Quản lý danh mục.
- Quản lý tỉnh/thành phố.
- Quản lý quận/huyện.
- Quản lý bài đăng.
- Quản lý giao dịch.
- Khóa hoặc mở khóa tài khoản nếu kịp.

Kết quả cần có:

- Người dùng xem được thống kê cơ bản.
- Admin quản lý được dữ liệu chính của hệ thống.

### Tuần 11: Kiểm thử và hoàn thiện

- Kiểm thử đăng nhập, phân quyền.
- Kiểm thử upload ảnh.
- Kiểm thử luồng yêu cầu mua và giao dịch.
- Kiểm thử quyền truy cập dữ liệu.
- Sửa lỗi giao diện.
- Thêm dữ liệu mẫu.

Kết quả cần có:

- Ứng dụng ổn định để demo.

### Tuần 12: Báo cáo và bảo vệ

- Viết báo cáo.
- Chụp ảnh màn hình ứng dụng.
- Hoàn thiện sơ đồ.
- Làm slide thuyết trình.
- Chuẩn bị kịch bản demo.

Kết quả cần có:

- Báo cáo hoàn chỉnh.
- Slide bảo vệ.
- App demo ổn định.

## 4. Thứ tự ưu tiên khi làm

Nên làm theo thứ tự:

1. Authentication.
2. User profile và role.
3. Product post.
4. Product list và detail.
5. Purchase request.
6. Transaction.
7. Chat.
8. Review.
9. Dashboard.
10. Admin.
11. Notification đơn giản.

## 5. Rủi ro và cách xử lý

| Rủi ro | Cách xử lý |
|---|---|
| Không kịp làm realtime | Làm chat dạng tải lại danh sách tin nhắn trước |
| Upload ảnh lỗi | Test Storage sớm ngay từ tuần 4 |
| Database thiết kế sai | Chốt ERD trước khi code nhiều |
| Dữ liệu khu vực không đồng nhất | Dùng bảng `tinh_thanh_pho`, `quan_huyen` và dropdown thay vì nhập tay |
| Phân quyền khó | Lưu vai trò rõ trong bảng `nguoi_dung` |
| Giao dịch nhiều trạng thái gây rối | Chỉ dùng 4 trạng thái chính |
| Admin quá nhiều màn hình | Làm dashboard và CRUD cơ bản trước |
| Dashboard quá phức tạp | Chỉ làm số liệu tổng quan, không xuất báo cáo |

## 6. Kịch bản demo đề xuất

1. Đăng nhập bằng tài khoản nông dân.
2. Nông dân đăng một sản phẩm mới.
3. Đăng xuất và đăng nhập bằng tài khoản thương lái.
4. Thương lái tìm kiếm sản phẩm.
5. Thương lái xem chi tiết và gửi yêu cầu mua.
6. Đăng nhập lại nông dân.
7. Nông dân chấp nhận yêu cầu mua.
8. Hệ thống tạo giao dịch.
9. Hai bên nhắn tin trong giao dịch.
10. Nông dân cập nhật trạng thái đang giao hàng.
11. Thương lái xác nhận đã nhận hàng.
12. Giao dịch chuyển sang hoàn thành.
13. Hai bên đánh giá sau giao dịch.
14. Nông dân xem doanh thu và đơn hàng gần đây.
15. Thương lái xem lịch sử mua và tổng tiền đã mua.
16. Admin đăng nhập và xem dashboard.

## 7. Chức năng không làm trong phiên bản chính

Các chức năng sau được đưa vào hướng phát triển tương lai:

- Thanh toán online.
- OTP số điện thoại.
- Đăng nhập Google hoặc Facebook.
- Bản đồ vị trí vùng nông sản.
- Chat gửi hình ảnh.
- Trạng thái đã xem hoặc đang nhập trong chat.
- Xuất báo cáo PDF hoặc Excel.
- Báo cáo vi phạm.
- Quản lý giá nông sản thị trường.
- Dự báo giá hoặc gợi ý sản phẩm thông minh.
