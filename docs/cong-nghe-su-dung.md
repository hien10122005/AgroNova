# Công nghệ sử dụng

## 1. Tổng quan công nghệ

Ứng dụng dự kiến được xây dựng trên nền tảng Android, sử dụng Supabase làm backend và PostgreSQL làm hệ quản trị cơ sở dữ liệu.

## 2. Frontend

### Android Studio

Android Studio là môi trường phát triển chính để xây dựng ứng dụng Android.

Lý do lựa chọn:

- Phù hợp với yêu cầu làm ứng dụng di động.
- Hỗ trợ tốt cho Java.
- Có công cụ thiết kế giao diện XML.
- Dễ chạy thử trên máy ảo hoặc thiết bị thật.

### Java

Java được sử dụng để xử lý logic ứng dụng Android.

Lý do lựa chọn:

- Phổ biến trong lập trình Android.
- Dễ học, dễ bảo trì.
- Phù hợp với đồ án cơ sở 2.
- Có nhiều tài liệu và ví dụ.

## 3. Backend

### Supabase

Supabase được sử dụng làm backend chính cho hệ thống.

Supabase cung cấp:

- Authentication: đăng ký, đăng nhập, quản lý phiên người dùng.
- PostgreSQL Database: lưu trữ dữ liệu nghiệp vụ.
- Storage: lưu ảnh đại diện và ảnh sản phẩm.
- Realtime: hỗ trợ cập nhật dữ liệu thời gian thực nếu cần.
- API tự động: truy xuất dữ liệu thông qua REST API.

Lý do nên dùng Supabase:

- Giảm thời gian tự xây dựng backend.
- Có sẵn đăng nhập và phân quyền cơ bản.
- Database PostgreSQL mạnh và dễ thiết kế quan hệ.
- Phù hợp với ứng dụng có upload ảnh, chat và dữ liệu realtime.
- Dễ demo và triển khai cho đồ án sinh viên.

## 4. Database

### PostgreSQL

PostgreSQL là hệ quản trị cơ sở dữ liệu quan hệ được Supabase sử dụng.

Ưu điểm:

- Hỗ trợ quan hệ giữa các bảng rõ ràng.
- Dữ liệu nhất quán.
- Phù hợp với các nghiệp vụ như bài đăng, yêu cầu mua, giao dịch và đánh giá.
- Có thể viết truy vấn thống kê cho dashboard.
- Phù hợp để quản lý dữ liệu dùng chung như tỉnh/thành phố và quận/huyện.

## 5. Storage

### Supabase Storage

Supabase Storage dùng để lưu:

- Ảnh đại diện người dùng.
- Ảnh sản phẩm nông sản.

Gợi ý bucket:

| Bucket | Mục đích |
|---|---|
| avatars | Lưu ảnh đại diện |
| product-images | Lưu ảnh sản phẩm |

Bucket `chat-images` chưa cần làm trong phiên bản chính vì chức năng gửi ảnh trong chat được để ở phần mở rộng.

## 6. Realtime

### Supabase Realtime

Supabase Realtime có thể dùng cho:

- Cập nhật tin nhắn mới.
- Cập nhật trạng thái giao dịch.
- Cập nhật thông báo mới.

Trong bản chính, có thể làm chat bằng cách tải danh sách tin nhắn khi mở màn hình. Sau đó mới nâng cấp realtime nếu còn thời gian. Không nên triển khai đồng thời chat realtime, thông báo realtime và trạng thái đang nhập vì sẽ làm phạm vi đồ án bị quá rộng.

## 7. Dashboard và thống kê

Dashboard được xây dựng bằng các truy vấn tổng hợp trên PostgreSQL. Không cần công cụ BI riêng và không cần xuất báo cáo PDF hoặc Excel ở phiên bản chính.

Các thống kê nên làm:

- Tổng số bài đăng.
- Tổng số yêu cầu mua.
- Tổng số giao dịch.
- Tổng doanh thu từ giao dịch hoàn thành.
- Số giao dịch theo trạng thái.
- Danh sách giao dịch gần đây.

## 8. Công cụ hỗ trợ

| Công cụ | Mục đích |
|---|---|
| Git | Quản lý phiên bản mã nguồn |
| GitHub | Lưu trữ source code |
| Figma | Thiết kế giao diện nếu cần |
| Draw.io | Vẽ use case, ERD, activity diagram |
| Postman | Kiểm thử API nếu cần |

## 9. Nhận xét về việc dùng Supabase

Supabase là lựa chọn tốt cho đề tài này. Nếu tự viết backend bằng Java, Node.js hoặc PHP thì sẽ mất thêm nhiều thời gian cho API, xác thực, upload ảnh và bảo mật. Với Supabase, nhóm có thể tập trung vào giao diện Android, nghiệp vụ mua bán và luồng giao dịch.

Điểm cần lưu ý:

- Cần thiết kế bảng ngay từ đầu cho rõ.
- Cần bật Row Level Security để dữ liệu không bị truy cập sai quyền.
- Cần thống nhất cách lưu role người dùng.
- Cần quản lý đường dẫn ảnh trong Storage cẩn thận.
- Không nên ôm realtime quá sớm; hãy hoàn thành CRUD và giao dịch trước.
- Dashboard nên làm bằng query tổng hợp đơn giản, tránh báo cáo quá phức tạp.
- Khu vực nên lưu bằng `tinh_thanh_pho_id` và `quan_huyen_id` thay vì nhập text để dữ liệu đồng nhất.
