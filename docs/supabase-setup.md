# Supabase setup cho AgroNova

## 1. Project đang sử dụng

Do tài khoản Supabase đã đạt giới hạn project free, dự án AgroNova dùng project Supabase hiện có:

| Thuộc tính | Giá trị |
|---|---|
| Project name | hien10122005's Project |
| Project ID | fsgybpviqxcrzywfldab |
| API URL | https://fsgybpviqxcrzywfldab.supabase.co |
| Region | ap-northeast-2 |
| Status | ACTIVE_HEALTHY |

## 2. API key cho Android

Nên dùng publishable key mới:

```text
sb_publishable_DhuWRXHPVSZAmy7tRJRTgA_Q6u2Q7Z9
```

Legacy anon key vẫn tồn tại nhưng chỉ nên dùng khi thư viện Supabase Android yêu cầu định dạng JWT cũ.

## 3. Bảng đã tạo

| STT | Bảng | RLS |
|---|---|---|
| 1 | tinh_thanh_pho | Bật |
| 2 | quan_huyen | Bật |
| 3 | nguoi_dung | Bật |
| 4 | danh_muc_san_pham | Bật |
| 5 | bai_dang_san_pham | Bật |
| 6 | hinh_anh_san_pham | Bật |
| 7 | yeu_cau_mua | Bật |
| 8 | giao_dich | Bật |
| 9 | tin_nhan | Bật |
| 10 | danh_gia | Bật |
| 11 | thong_bao | Bật |

## 4. Dữ liệu mẫu đã seed

Danh mục nông sản:

- Rau củ
- Trái cây
- Lúa gạo
- Cà phê
- Hồ tiêu
- Thủy sản

Tỉnh/thành phố mẫu:

- Tiền Giang
- TP.HCM
- Đắk Lắk
- Lâm Đồng
- Cần Thơ

Quận/huyện mẫu:

- Cai Lậy
- Mỹ Tho
- Thủ Đức
- Bình Chánh
- Buôn Ma Thuột
- Đà Lạt
- Ninh Kiều

## 5. Ghi chú bảo mật

- Tất cả bảng public đã bật Row Level Security.
- Security advisor hiện không còn cảnh báo.
- Helper admin đã được chuyển vào schema `private`.
- Function tạo giao dịch từ yêu cầu mua: `public.tao_giao_dich_tu_yeu_cau_mua(yeu_cau_mua_id_arg uuid)`.

## 6. Bước tiếp theo

Khi làm app Android:

1. Cấu hình API URL và publishable key.
2. Làm đăng ký/đăng nhập với Supabase Auth.
3. Sau khi đăng ký thành công, tạo hồ sơ trong bảng `nguoi_dung`.
4. Load `tinh_thanh_pho` và `quan_huyen` cho dropdown.
5. Load `danh_muc_san_pham` cho form đăng bài.
6. Bắt đầu làm luồng đăng bài, gửi yêu cầu mua và giao dịch.
