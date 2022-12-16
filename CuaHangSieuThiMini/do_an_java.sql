-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 28, 2022 lúc 07:47 AM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 8.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Cơ sở dữ liệu: `do_an_java`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi_tiet_ct_khuyen_mai`
--

CREATE TABLE `chi_tiet_ct_khuyen_mai` (
  `ma_ctkm` int(10) UNSIGNED NOT NULL,
  `ma_mon` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tien_giam` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chi_tiet_ct_khuyen_mai`
--

INSERT INTO `chi_tiet_ct_khuyen_mai` (`ma_ctkm`, `ma_mon`, `tien_giam`) VALUES
(1, 'MA01', 4000),
(1, 'MA03', 10000),
(1, 'MA05', 1000),
(1, 'MA06', 1000),
(1, 'MA07', 3000),
(1, 'MA10', 100),
(1, 'MA11', 3000),
(2, 'MA03', 1000),
(2, 'MA04', 300),
(2, 'MA06', 500),
(2, 'MA08', 600);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi_tiet_don_dat`
--

CREATE TABLE `chi_tiet_don_dat` (
  `ma_don_dat` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_mon` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ten_mon` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `so_luong` int(11) NOT NULL,
  `gia` int(11) NOT NULL,
  `thanh_tien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chi_tiet_don_dat`
--

INSERT INTO `chi_tiet_don_dat` (`ma_don_dat`, `ma_mon`, `ten_mon`, `so_luong`, `gia`, `thanh_tien`) VALUES
('DDH01', 'MA02', 'Mì 3 miền', 3, 100000, 300000),
('DDH01', 'MA03', 'Cafe Trung Nguyên', 2, 50000, 100000),
('DDH01', 'MA04', 'Cafe Việt :))', 3, 4000, 12000),
('DDH01', 'MA05', 'Pánh mì ngọt', 1, 6000, 6000),
('DDH01', 'MA06', 'pánh Mì Hàn QUốc', 3, 12000, 36000),
('DDH01', 'MA07', 'Pánh mì bơ', 2, 5000, 10000),
('DDH01', 'MA11', '7Up', 3, 10000, 30000),
('DDH02', 'MA05', 'Pánh mì ngọt', 1, 6000, 6000),
('DDH02', 'MA06', 'pánh Mì Hàn QUốc', 1, 12000, 12000),
('DDH02', 'MA07', 'Pánh mì bơ', 1, 5000, 5000),
('DDH03', 'MA03', 'Cafe Trung Nguyên', 1, 50000, 50000),
('DDH03', 'MA04', 'Cafe Việt :))', 1, 4000, 4000),
('DDH04', 'MA03', 'Cafe Trung Nguyên', 1, 50000, 50000),
('DDH05', 'MA07', 'Pánh mì bơ', 1, 5000, 5000),
('DDH05', 'MA11', '7Up', 6, 10000, 60000),
('DDH06', 'MA03', 'Cafe Trung Nguyên', 2, 50000, 100000),
('DDH06', 'MA04', 'Cafe Việt :))', 2, 4000, 8000),
('DDH07', 'MA07', 'Pánh mì bơ', 6, 5000, 30000),
('DDH08', 'MA12', 'Coca', 3, 12000, 36000),
('DDH09', 'MA03', 'Cafe Trung Nguyên', 10, 50000, 500000),
('DDH09', 'MA04', 'Cafe Việt :))', 10, 4000, 40000),
('DDH10', 'MA11', '7Up', 8, 10000, 80000),
('DDH10', 'MA12', 'Coca', 20, 12000, 240000),
('DDH11', 'MA05', 'Pánh mì ngọt', 15, 6000, 90000),
('DDH11', 'MA06', 'pánh Mì Hàn QUốc', 23, 12000, 276000),
('DDH11', 'MA07', 'Pánh mì bơ', 35, 5000, 175000),
('DDH12', 'MA01', 'Mì hảo hảo', 5, 10000, 50000),
('DDH12', 'MA02', 'Mì 3 miền', 5, 100000, 500000),
('DDH12', 'MA08', 'KoKoMi', 8, 4000, 32000),
('DDH12', 'MA09', 'Hảo 100', 6, 4000, 24000),
('DDH12', 'MA10', 'Omachi', 6, 7000, 42000),
('DDH13', 'MA05', 'Pánh mì ngọt', 1, 6000, 6000),
('DDH13', 'MA06', 'pánh Mì Hàn QUốc', 1, 12000, 12000),
('DDH13', 'MA07', 'Pánh mì bơ', 1, 5000, 5000),
('DDH14', 'MA12', 'Coca', 2, 14000, 28000),
('DDH15', 'MA12', 'Coca', 2, 14000, 28000),
('DDH16', 'MA05', 'Pánh mì ngọt', 1, 6000, 6000),
('DDH16', 'MA06', 'pánh Mì Hàn QUốc', 1, 12000, 12000),
('DDH16', 'MA07', 'Pánh mì bơ', 1, 5000, 5000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi_tiet_hoa_don`
--

CREATE TABLE `chi_tiet_hoa_don` (
  `ma_hoa_don` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_mon` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ten_mon` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `so_luong` int(11) NOT NULL,
  `gia_mon` int(10) UNSIGNED NOT NULL,
  `thanh_tien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chi_tiet_hoa_don`
--

INSERT INTO `chi_tiet_hoa_don` (`ma_hoa_don`, `ma_mon`, `ten_mon`, `so_luong`, `gia_mon`, `thanh_tien`) VALUES
('HD01', 'MA11', '7Up', 1, 10000, 10000),
('HD01', 'MA12', 'Coca', 1, 12000, 12000),
('HD02', 'MA12', 'Coca', 2, 12000, 24000),
('HD03', 'MA01', 'Mì hảo hảo', 1, 10000, 10000),
('HD03', 'MA02', 'Mì 3 miền', 1, 100000, 100000),
('HD04', 'MA11', '7Up', 1, 10000, 10000),
('HD04', 'MA12', 'Coca', 1, 12000, 12000),
('HD05', 'MA01', 'Mì hảo hảo', 1, 10000, 10000),
('HD05', 'MA02', 'Mì 3 miền', 1, 100000, 100000),
('HD05', 'MA12', 'Coca', 1, 14000, 14000),
('HD06', 'MA02', 'Mì 3 miền', 1, 100000, 100000),
('HD06', 'MA08', 'KoKoMi', 1, 4000, 4000),
('HD06', 'MA09', 'Hảo 100', 1, 4000, 4000),
('HD06', 'MA10', 'Omachi', 1, 7000, 7000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi_tiet_ncc_loai_mon`
--

CREATE TABLE `chi_tiet_ncc_loai_mon` (
  `ma_ncc` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_loai` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chi_tiet_ncc_loai_mon`
--

INSERT INTO `chi_tiet_ncc_loai_mon` (`ma_ncc`, `ma_loai`) VALUES
('NCC01', 'LM01'),
('NCC01', 'LM02'),
('NCC01', 'LM03'),
('NCC01', 'LM04'),
('NCC02', 'LM01'),
('NCC02', 'LM02'),
('NCC02', 'LM04'),
('NCC02', 'LM05'),
('NCC03', 'LM02'),
('NCC03', 'LM04');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chuong_trinh_khuyen_mai`
--

CREATE TABLE `chuong_trinh_khuyen_mai` (
  `ma_ctkm` int(10) UNSIGNED NOT NULL,
  `ten_ctkm` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngay_bat_dau` date NOT NULL,
  `ngay_ket_thuc` date NOT NULL,
  `trang_thai` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chuong_trinh_khuyen_mai`
--

INSERT INTO `chuong_trinh_khuyen_mai` (`ma_ctkm`, `ten_ctkm`, `ngay_bat_dau`, `ngay_ket_thuc`, `trang_thai`) VALUES
(1, 'CTT1', '2022-05-01', '2022-05-31', 0),
(2, 'CTT2', '2022-06-01', '2022-06-30', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `don_dat_hang`
--

CREATE TABLE `don_dat_hang` (
  `ma_don_dat` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ma_ncc` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngay_dat` date NOT NULL,
  `tong_tien_dat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `don_dat_hang`
--

INSERT INTO `don_dat_hang` (`ma_don_dat`, `ma_ncc`, `ngay_dat`, `tong_tien_dat`) VALUES
('DDH01', 'NCC01', '2022-05-21', 382000),
('DDH02', 'NCC01', '2022-05-21', 23000),
('DDH03', 'NCC02', '2022-05-21', 54000),
('DDH04', 'NCC01', '2022-05-21', 50000),
('DDH05', 'NCC03', '2022-05-21', 65000),
('DDH06', 'NCC02', '2022-05-24', 108000),
('DDH07', 'NCC01', '2022-05-24', 30000),
('DDH08', 'NCC03', '2022-05-24', 36000),
('DDH09', 'NCC02', '2022-05-25', 540000),
('DDH10', 'NCC03', '2022-05-25', 320000),
('DDH11', 'NCC01', '2022-05-25', 541000),
('DDH12', 'NCC01', '2022-05-25', 648000),
('DDH13', 'NCC01', '2022-05-28', 23000),
('DDH14', 'NCC01', '2022-05-28', 28000),
('DDH15', 'NCC01', '2022-05-28', 28000),
('DDH16', 'NCC02', '2022-05-28', 23000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoa_don`
--

CREATE TABLE `hoa_don` (
  `ma_hoa_don` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngay_xuat` date NOT NULL,
  `ma_nhan_vien` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ma_thanh_vien` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tong_tien` int(10) UNSIGNED NOT NULL,
  `tien_giam` int(10) UNSIGNED NOT NULL,
  `tien_con_lai` int(10) UNSIGNED NOT NULL,
  `ma_phieu_giam_gia` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `diem` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoa_don`
--

INSERT INTO `hoa_don` (`ma_hoa_don`, `ngay_xuat`, `ma_nhan_vien`, `ma_thanh_vien`, `tong_tien`, `tien_giam`, `tien_con_lai`, `ma_phieu_giam_gia`, `diem`) VALUES
('HD01', '2022-05-26', 'NV02', 'null', 22000, 0, 22000, 'null', 0),
('HD02', '2022-05-26', 'NV02', 'TV01', 52000, 5000, 47000, 'null', 5000),
('HD03', '2022-05-26', 'NV01', 'null', 110000, 0, 110000, 'null', 0),
('HD04', '2022-05-26', 'NV02', 'null', 22000, 0, 22000, 'null', 0),
('HD05', '2022-05-28', 'NV02', 'null', 124000, 0, 124000, 'null', 0),
('HD06', '2022-05-28', 'NV02', 'null', 115000, 5000, 110000, 'PGG04', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loai_thuc_an`
--

CREATE TABLE `loai_thuc_an` (
  `ma_loai` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ten_loai` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `loai_thuc_an`
--

INSERT INTO `loai_thuc_an` (`ma_loai`, `ten_loai`) VALUES
('LM02', 'Bánh mì'),
('LM01', 'Cafe'),
('LM04', 'Giải Khát'),
('LM03', 'Mì gói'),
('LM06', 'Pánh ngọt'),
('LM05', 'Trà');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mon_an`
--

CREATE TABLE `mon_an` (
  `ma_mon` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ten_mon` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `so_luong` int(11) NOT NULL,
  `gia` int(11) NOT NULL,
  `gia_giam` int(11) NOT NULL,
  `ma_loai` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `mon_an`
--

INSERT INTO `mon_an` (`ma_mon`, `ten_mon`, `so_luong`, `gia`, `gia_giam`, `ma_loai`) VALUES
('MA01', 'Mì hảo hảo', 12, 10000, 0, 'LM03'),
('MA02', 'Mì 3 miền', 10, 100000, 0, 'LM03'),
('MA03', 'Cafe Trung Nguyên', 12, 50000, 0, 'LM01'),
('MA04', 'Cafe Việt :))', 12, 4000, 0, 'LM01'),
('MA05', 'Pánh mì ngọt', 14, 6000, 0, 'LM02'),
('MA06', 'pánh Mì Hàn QUốc', 23, 12000, 0, 'LM02'),
('MA07', 'Pánh mì bơ', 38, 5000, 0, 'LM02'),
('MA08', 'KoKoMi', 6, 4000, 0, 'LM03'),
('MA09', 'Hảo 100', 5, 4000, 0, 'LM03'),
('MA10', 'Omachi', 5, 7000, 0, 'LM03'),
('MA11', '7Up', 6, 10000, 0, 'LM04');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhan_vien`
--

CREATE TABLE `nhan_vien` (
  `ma_nhan_vien` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ten_nhan_vien` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngay_sinh` date NOT NULL,
  `sdt` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mail` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tai_khoan` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhan_vien`
--

INSERT INTO `nhan_vien` (`ma_nhan_vien`, `ten_nhan_vien`, `ngay_sinh`, `sdt`, `mail`, `tai_khoan`) VALUES
('NV01', 'Huỳnh Trung Kiên', '2002-09-17', '0354182079', 'HuynhKien27894869@gmail.com', 8),
('NV02', 'Hoàng Thị Mỹ Diệu', '2004-07-12', '0987654321', 'HDieu123@gmail.com', 2),
('NV03', 'KJ', '2002-05-10', '0123456789', 'de@gmail.com', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nha_cung_cap`
--

CREATE TABLE `nha_cung_cap` (
  `ma_ncc` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ten_ncc` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dia_chi` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nha_cung_cap`
--

INSERT INTO `nha_cung_cap` (`ma_ncc`, `ten_ncc`, `dia_chi`) VALUES
('NCC01', 'Công ty TNHH 1', 'HCM city'),
('NCC02', 'Công ty TNHH 2', 'HaNoi city'),
('NCC03', 'Công ty 2 thành viên', 'HCM city'),
('NCC04', 'Công ty nước giải khát', 'HCM city');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phan_quyen`
--

CREATE TABLE `phan_quyen` (
  `ma_quyen` int(10) UNSIGNED NOT NULL,
  `quyen` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phan_quyen`
--

INSERT INTO `phan_quyen` (`ma_quyen`, `quyen`) VALUES
(1, 'admin'),
(2, 'staff');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieu_giam_gia`
--

CREATE TABLE `phieu_giam_gia` (
  `ma_phieu_giam_gia` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ten_phieu_giam_gia` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `giam` int(10) UNSIGNED NOT NULL,
  `ngay_bat_dau` date NOT NULL,
  `ngay_ket_thuc` date NOT NULL,
  `trang_thai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieu_giam_gia`
--

INSERT INTO `phieu_giam_gia` (`ma_phieu_giam_gia`, `ten_phieu_giam_gia`, `giam`, `ngay_bat_dau`, `ngay_ket_thuc`, `trang_thai`) VALUES
('PGG01', 'GGT55k', 5000, '2022-05-04', '2022-05-31', 0),
('PGG03', 'GIAMNGUOIMOI5K', 5000, '2022-05-04', '2022-05-27', 0),
('PGG04', 'GIAMNHANH5K', 5000, '2022-05-10', '2022-05-31', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tai_khoan`
--

CREATE TABLE `tai_khoan` (
  `ma_tai_khoan` int(10) UNSIGNED NOT NULL,
  `ten_tai_khoan` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mat_khau` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '1',
  `phan_quyen` int(10) UNSIGNED NOT NULL,
  `trang_thai` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tai_khoan`
--

INSERT INTO `tai_khoan` (`ma_tai_khoan`, `ten_tai_khoan`, `mat_khau`, `phan_quyen`, `trang_thai`) VALUES
(1, 'helloa', '1', 2, 1),
(2, 'dieu', '1', 1, 0),
(3, 'hehe', '1', 1, 0),
(4, 'kj', '1', 1, 0),
(6, 'aq', '1', 2, 0),
(7, 'bkien', '1', 2, 0),
(8, 'ty', '1', 1, 1),
(9, 'dee', '2', 2, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thanh_vien`
--

CREATE TABLE `thanh_vien` (
  `ma_thanh_vien` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mat_khau` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ten_thanh_vien` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngay_sinh` date NOT NULL,
  `sdt` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mail` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `diem` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `thanh_vien`
--

INSERT INTO `thanh_vien` (`ma_thanh_vien`, `mat_khau`, `ten_thanh_vien`, `ngay_sinh`, `sdt`, `mail`, `diem`) VALUES
('TV01', '1', 'Huỳnh Trung Kiên', '2002-09-17', '0354182079', 'hh2h@gmail.com', 5200),
('TV02', 'asdas', 'sadasd', '2022-05-09', '123456789', 'sdfsf', 0),
('TV03', '1', 'kkk', '2004-05-12', '0354123654', 'kjkj@gmail.com', 13600);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chi_tiet_ct_khuyen_mai`
--
ALTER TABLE `chi_tiet_ct_khuyen_mai`
  ADD PRIMARY KEY (`ma_ctkm`,`ma_mon`),
  ADD KEY `fk_ctkm_mon` (`ma_mon`);

--
-- Chỉ mục cho bảng `chi_tiet_don_dat`
--
ALTER TABLE `chi_tiet_don_dat`
  ADD PRIMARY KEY (`ma_don_dat`,`ma_mon`);

--
-- Chỉ mục cho bảng `chi_tiet_hoa_don`
--
ALTER TABLE `chi_tiet_hoa_don`
  ADD PRIMARY KEY (`ma_hoa_don`,`ma_mon`);

--
-- Chỉ mục cho bảng `chi_tiet_ncc_loai_mon`
--
ALTER TABLE `chi_tiet_ncc_loai_mon`
  ADD PRIMARY KEY (`ma_ncc`,`ma_loai`),
  ADD UNIQUE KEY `ma_ncc` (`ma_ncc`,`ma_loai`),
  ADD KEY `fk_ct_ncc_loai_loai` (`ma_loai`);

--
-- Chỉ mục cho bảng `chuong_trinh_khuyen_mai`
--
ALTER TABLE `chuong_trinh_khuyen_mai`
  ADD PRIMARY KEY (`ma_ctkm`);

--
-- Chỉ mục cho bảng `don_dat_hang`
--
ALTER TABLE `don_dat_hang`
  ADD PRIMARY KEY (`ma_don_dat`),
  ADD KEY `fk_ddh_ncc` (`ma_ncc`);

--
-- Chỉ mục cho bảng `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD PRIMARY KEY (`ma_hoa_don`),
  ADD KEY `fk_hd_nv` (`ma_nhan_vien`);

--
-- Chỉ mục cho bảng `loai_thuc_an`
--
ALTER TABLE `loai_thuc_an`
  ADD PRIMARY KEY (`ma_loai`),
  ADD UNIQUE KEY `ten_loai` (`ten_loai`);

--
-- Chỉ mục cho bảng `mon_an`
--
ALTER TABLE `mon_an`
  ADD PRIMARY KEY (`ma_mon`),
  ADD UNIQUE KEY `ma_mon` (`ma_mon`),
  ADD KEY `fk_mn_lma` (`ma_loai`);

--
-- Chỉ mục cho bảng `nhan_vien`
--
ALTER TABLE `nhan_vien`
  ADD PRIMARY KEY (`ma_nhan_vien`),
  ADD KEY `fk_tk_nv` (`tai_khoan`);

--
-- Chỉ mục cho bảng `nha_cung_cap`
--
ALTER TABLE `nha_cung_cap`
  ADD PRIMARY KEY (`ma_ncc`),
  ADD UNIQUE KEY `ma_ncc` (`ma_ncc`);

--
-- Chỉ mục cho bảng `phan_quyen`
--
ALTER TABLE `phan_quyen`
  ADD PRIMARY KEY (`ma_quyen`);

--
-- Chỉ mục cho bảng `phieu_giam_gia`
--
ALTER TABLE `phieu_giam_gia`
  ADD PRIMARY KEY (`ma_phieu_giam_gia`),
  ADD UNIQUE KEY `ten_phieu_giam_gia` (`ten_phieu_giam_gia`);

--
-- Chỉ mục cho bảng `tai_khoan`
--
ALTER TABLE `tai_khoan`
  ADD PRIMARY KEY (`ma_tai_khoan`) USING BTREE,
  ADD UNIQUE KEY `ten_tai_khoan` (`ten_tai_khoan`),
  ADD KEY `fk_tk_pq` (`phan_quyen`);

--
-- Chỉ mục cho bảng `thanh_vien`
--
ALTER TABLE `thanh_vien`
  ADD PRIMARY KEY (`ma_thanh_vien`),
  ADD UNIQUE KEY `sdt` (`sdt`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `phan_quyen`
--
ALTER TABLE `phan_quyen`
  MODIFY `ma_quyen` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `tai_khoan`
--
ALTER TABLE `tai_khoan`
  MODIFY `ma_tai_khoan` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chi_tiet_ct_khuyen_mai`
--
ALTER TABLE `chi_tiet_ct_khuyen_mai`
  ADD CONSTRAINT `fk_ctkm_km` FOREIGN KEY (`ma_ctkm`) REFERENCES `chuong_trinh_khuyen_mai` (`ma_ctkm`),
  ADD CONSTRAINT `fk_ctkm_mon` FOREIGN KEY (`ma_mon`) REFERENCES `mon_an` (`ma_mon`);

--
-- Các ràng buộc cho bảng `chi_tiet_don_dat`
--
ALTER TABLE `chi_tiet_don_dat`
  ADD CONSTRAINT `fk_ctdd_ddh` FOREIGN KEY (`ma_don_dat`) REFERENCES `don_dat_hang` (`ma_don_dat`);

--
-- Các ràng buộc cho bảng `chi_tiet_hoa_don`
--
ALTER TABLE `chi_tiet_hoa_don`
  ADD CONSTRAINT `fk_cthd_hoadon` FOREIGN KEY (`ma_hoa_don`) REFERENCES `hoa_don` (`ma_hoa_don`);

--
-- Các ràng buộc cho bảng `chi_tiet_ncc_loai_mon`
--
ALTER TABLE `chi_tiet_ncc_loai_mon`
  ADD CONSTRAINT `fk_ct_ncc_loai_loai` FOREIGN KEY (`ma_loai`) REFERENCES `loai_thuc_an` (`ma_loai`),
  ADD CONSTRAINT `fk_ct_ncc_loai_ncc` FOREIGN KEY (`ma_ncc`) REFERENCES `nha_cung_cap` (`ma_ncc`);

--
-- Các ràng buộc cho bảng `don_dat_hang`
--
ALTER TABLE `don_dat_hang`
  ADD CONSTRAINT `fk_ddh_ncc` FOREIGN KEY (`ma_ncc`) REFERENCES `nha_cung_cap` (`ma_ncc`);

--
-- Các ràng buộc cho bảng `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD CONSTRAINT `fk_hd_nv` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `nhan_vien` (`ma_nhan_vien`);

--
-- Các ràng buộc cho bảng `mon_an`
--
ALTER TABLE `mon_an`
  ADD CONSTRAINT `fk_mn_lma` FOREIGN KEY (`ma_loai`) REFERENCES `loai_thuc_an` (`ma_loai`);

--
-- Các ràng buộc cho bảng `nhan_vien`
--
ALTER TABLE `nhan_vien`
  ADD CONSTRAINT `fk_tk_nv` FOREIGN KEY (`tai_khoan`) REFERENCES `tai_khoan` (`ma_tai_khoan`);

--
-- Các ràng buộc cho bảng `tai_khoan`
--
ALTER TABLE `tai_khoan`
  ADD CONSTRAINT `fk_tk_pq` FOREIGN KEY (`phan_quyen`) REFERENCES `phan_quyen` (`ma_quyen`);
COMMIT;
