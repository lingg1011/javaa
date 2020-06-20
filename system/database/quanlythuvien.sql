-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 18, 2020 lúc 04:42 PM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.3.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlythuvien`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietmuontra`
--

CREATE TABLE `chitietmuontra` (
  `chitietmuontra` int(11) NOT NULL,
  `mamuontra` int(11) NOT NULL,
  `masach` int(255) NOT NULL,
  `soluong` int(11) NOT NULL,
  `datra` tinyint(4) NOT NULL DEFAULT 0,
  `ngaytra` date DEFAULT NULL,
  `hantra` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietmuontra`
--

INSERT INTO `chitietmuontra` (`chitietmuontra`, `mamuontra`, `masach`, `soluong`, `datra`, `ngaytra`, `hantra`) VALUES
(2, 2, 10, 2, 1, '2020-05-06', '2020-05-12'),
(3, 3, 10, 2, 1, '2020-05-12', '2020-05-06'),
(4, 1, 10, 1, 0, '2020-05-12', '2020-05-09'),
(5, 1, 18, 1, 1, '2020-05-12', '2020-05-09'),
(6, 4, 10, 5, 0, NULL, '2020-05-21'),
(7, 5, 12, 1, 1, '2020-05-12', '2020-05-13'),
(8, 5, 19, 2, 0, NULL, '2020-05-14'),
(9, 6, 13, 10, 1, '2020-05-12', '2020-05-13'),
(10, 6, 14, 1, 0, NULL, '2020-05-14'),
(11, 7, 15, 1, 1, '2020-05-12', '2020-05-13'),
(12, 7, 19, 1, 0, NULL, '2020-05-13');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `chitietphieunhap` int(11) NOT NULL,
  `maphieunhap` int(11) NOT NULL,
  `masach` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `dongia` int(11) NOT NULL,
  `thanhtien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`chitietphieunhap`, `maphieunhap`, `masach`, `soluong`, `dongia`, `thanhtien`) VALUES
(2, 2, 13, 10, 100000, 1000000),
(11, 5, 12, 2, 100000, 200000),
(12, 6, 12, 3, 100000, 300000),
(13, 6, 13, 1, 100000, 100000),
(14, 6, 13, 2, 100000, 200000),
(15, 6, 11, 1, 100000, 100000),
(16, 6, 10, 1, 100000, 100000),
(17, 6, 10, 1, 100000, 100000),
(18, 6, 13, 1, 100000, 100000),
(19, 7, 13, 2, 100000, 200000),
(20, 8, 14, 2, 140000, 280000),
(21, 2, 31, 5, 50000, 250000),
(22, 9, 10, 2, 100000, 200000),
(23, 6, 10, 1, 100000, 100000),
(24, 10, 19, 2, 30000, 60000),
(25, 2, 20, 1, 100000, 100000),
(26, 10, 23, 1, 100000, 100000),
(27, 2, 18, 5, 120000, 600000),
(29, 3, 14, 6, 140000, 840000),
(32, 2, 10, 1, 100000, 100000),
(33, 4, 11, 20, 100000, 2000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieuphat`
--

CREATE TABLE `chitietphieuphat` (
  `chitietphieuphat` int(11) NOT NULL,
  `maphieuphat` int(11) NOT NULL,
  `masach` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `tinhtrang` int(11) NOT NULL,
  `tienphat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietphieuphat`
--

INSERT INTO `chitietphieuphat` (`chitietphieuphat`, `maphieuphat`, `masach`, `soluong`, `tinhtrang`, `tienphat`) VALUES
(1, 1, 10, 1, 2, 50000),
(2, 1, 18, 1, 0, 12000),
(3, 1, 10, 1, 0, 10000),
(4, 2, 10, 2, 1, 200000),
(5, 3, 10, 2, 1, 200000),
(6, 1, 10, 1, 1, 100000),
(7, 6, 10, 10, 1, 1000000),
(8, 7, 10, 1, 2, 50000),
(9, 2, 10, 2, 1, 200000),
(10, 3, 10, 2, 0, 20000),
(11, 5, 10, 1, 1, 100000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `docgia`
--

CREATE TABLE `docgia` (
  `madocgia` int(11) NOT NULL,
  `tendocgia` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `diachi` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sdt` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngaycap` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `docgia`
--

INSERT INTO `docgia` (`madocgia`, `tendocgia`, `diachi`, `sdt`, `ngaycap`) VALUES
(3, 'Nguyễn Thị Kim Phụng', 'Quận 8, TPHCM', '0338992511', '2019-05-17'),
(4, 'Đặng Văn Tiền', 'Quận 7,TPHCM', '0358848532', '2018-12-24'),
(5, 'Nguyễn Thị Bạch', 'Quận Bình Tân,TPHCM', '0399994444', '2019-03-26'),
(6, 'Trần Minh Nghĩa', 'Quận 10 ,TPHCM', '0123228228', '2019-01-30'),
(7, 'Phạm Hồng Biên', 'Quận Bình Tân, TPHCM', '0366161289', '2019-03-10'),
(8, 'Phùng Thị Thùy Khanh', 'Quận 2, TPHCM', '0377374589', '2019-03-11'),
(9, 'Nguyễn Hữu Nam', 'Quận 9,TPHCM', '0331238991', '2019-01-30'),
(10, 'Dương Hoàng Minh Luân', 'Quận Tân Bình, TPHCM', '0388788708', '2019-02-14'),
(11, 'Trương Võ Minh Đăng', 'Quận 5, TPHCM', '0988788721', '2019-01-04'),
(12, 'Nguyễn Thị Thu Thảo', 'Quận Tân Bình,TPHCM', '0356660203', '2019-02-09'),
(13, 'Lê Bảo Di', 'Quận 12,TPHCM', '0367894545', '2019-03-26'),
(14, 'Võ Thị Năm', 'Quận 7, TPHCM', '0399595254', '2019-03-02'),
(15, 'Thái Nghiêu', 'Quận 11,TPHCM', '0399294975', '2019-02-15'),
(16, 'Tô Công Tuyển', 'Quận 10, TPHCM', '0337333733', '2019-03-24'),
(17, 'Nguyễn Thị Ngọc Lan', 'Quận Bình Tân, TPHCM', '0983433589', '2019-03-02'),
(18, 'Nguyễn Thị Phương Lam', 'Quận 5, TPHCM', '0355557845', '2019-02-01'),
(19, 'Khuất Thùy Dương', 'Quận 5,TPHCM', '0356986899', '2019-03-30'),
(20, 'Võ Hoàng Tú', 'Quận 11, TPHCM', '0355554444', '2019-04-20'),
(21, 'Nguyễn Võ Trường Duy', 'Quận 10, TPHCM', '0356969969', '2019-09-09'),
(22, 'Nguyễn Hoàng Huy', 'Quận 7, TPHCM', '0988584569', '2019-05-19'),
(23, 'Trương Thành Tấn', 'Quận 10, TPHCM', '0126966789', '2019-02-15'),
(24, 'Bùi Phát Đạt', 'Quận 7,TPHCM', '0356668888', '2019-06-06'),
(25, 'Phạm Nguyễn Xuân Thảo', 'Quận 12, TPHCM', '0377373737', '2019-01-15'),
(26, 'Nguyễn Thị Thảo Nguyên', 'Quận 12,TPHCM', '0126123123', '2019-04-04'),
(27, 'Nguyễn Hoàng Y', 'Quận 11,TPHCM', '0399691259', '2019-05-02'),
(28, 'Trần Minh Quang', 'Quận 5,TPHCM', '0344445555', '2019-02-10');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacc`
--

CREATE TABLE `nhacc` (
  `mancc` int(11) NOT NULL,
  `tenncc` varchar(33) COLLATE utf8_unicode_ci NOT NULL,
  `diachi` varchar(44) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` varchar(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhacc`
--

INSERT INTO `nhacc` (`mancc`, `tenncc`, `diachi`, `sdt`) VALUES
(1, 'Fahasha', 'ddddđ', '1212121212'),
(2, 'Bộ Giáo Dục', 'âsdasdasd', '1111111'),
(3, 'ÁDAs', 'sdsdsds', 'sdsdsds');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `manv` int(11) NOT NULL,
  `password` varchar(40) COLLATE utf8_unicode_ci NOT NULL DEFAULT '123456',
  `role` int(11) NOT NULL DEFAULT 0,
  `tennv` varchar(24) COLLATE utf8_unicode_ci NOT NULL,
  `ngaysinh` date NOT NULL,
  `sdt` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `diachi` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`manv`, `password`, `role`, `tennv`, `ngaysinh`, `sdt`, `diachi`) VALUES
(5, '123456', 0, 'Trần Bội Thư', '2019-05-12', '0902983100', 'Nhà Bè ,TPHCM'),
(6, '123456', 0, 'Đoàn Thị Kim Ngân', '1997-05-14', '0358848989', 'Bình Phước'),
(7, '123456', 0, 'Phan Đặng Nhật Linh', '1999-09-09', '0367570758', 'Bến Tre'),
(8, '123456', 0, 'Thái Phi Sơn', '1996-01-01', '0123113113', 'Đồng Nai');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nxb`
--

CREATE TABLE `nxb` (
  `manxb` int(11) NOT NULL,
  `tennxb` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `diachi` varchar(44) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(44) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` varchar(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nxb`
--

INSERT INTO `nxb` (`manxb`, `tennxb`, `diachi`, `email`, `sdt`) VALUES
(4, 'Đại Học Quốc Gia TPHCM', 'tphcm', 'tphcm', '1231231'),
(5, 'Kim Đồng', '1111111', '1111111', '111111111'),
(6, 'Tổng Hợp Đồng Nai', '', '', ''),
(7, 'Chính Trị Quốc Gia Sự Thật', '', '', ''),
(8, 'Khoa Học và Kỹ Thuật', '', '', ''),
(9, 'Giáo Dục Việt Nam', '', '', ''),
(10, 'Thông Tin Và Truyền Thông', '', '', ''),
(11, 'Tổng Hợp TPHCM', '', '', ''),
(12, 'Giao Thông Vận Tải', '', '', ''),
(13, 'Lao Động', '', '', ''),
(14, 'Nhà Xuất Bản Bách Khoa HN', '', '', ''),
(15, 'Thanh Niên', '', '', ''),
(16, 'Đại Học Sư Phạm', '', '', ''),
(17, 'Phụ Nữ', '', '', ''),
(18, 'Văn Học', '', '', ''),
(19, 'Tri Thức', '', '', ''),
(20, 'Đại Học Quốc Gia Hà Nội', 'Hà Nội', 'hanoi@gmail.com', '0123123');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieumuontra`
--

CREATE TABLE `phieumuontra` (
  `mamuontra` int(11) NOT NULL,
  `madocgia` int(255) NOT NULL,
  `manhanvien` int(255) NOT NULL,
  `ngaymuon` date NOT NULL,
  `ghichu` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieumuontra`
--

INSERT INTO `phieumuontra` (`mamuontra`, `madocgia`, `manhanvien`, `ngaymuon`, `ghichu`) VALUES
(2, 3, 5, '2020-05-06', NULL),
(3, 3, 7, '2020-05-06', NULL),
(4, 3, 5, '2020-05-12', NULL),
(5, 5, 5, '2020-05-12', NULL),
(6, 13, 5, '2020-05-12', NULL),
(7, 5, 5, '2020-05-12', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `maphieunhap` int(11) NOT NULL,
  `manv` int(11) NOT NULL,
  `mancc` int(11) NOT NULL,
  `ngaynhap` date NOT NULL,
  `tongtien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`maphieunhap`, `manv`, `mancc`, `ngaynhap`, `tongtien`) VALUES
(2, 7, 1, '2020-05-16', 2050000),
(3, 5, 1, '2020-05-11', 840000),
(4, 5, 1, '2020-05-10', 2000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuphat`
--

CREATE TABLE `phieuphat` (
  `maphieuphat` int(11) NOT NULL,
  `mamuontra` int(11) NOT NULL,
  `manv` int(11) NOT NULL,
  `ngaylap` date NOT NULL,
  `tongtien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieuphat`
--

INSERT INTO `phieuphat` (`maphieuphat`, `mamuontra`, `manv`, `ngaylap`, `tongtien`) VALUES
(1, 2, 5, '2020-05-11', 172000),
(2, 3, 5, '2020-05-12', 400000),
(3, 5, 5, '2020-05-12', 220000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sach`
--

CREATE TABLE `sach` (
  `masach` int(11) NOT NULL,
  `tensach` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  `tacgia` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  `nhaxb` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  `theloai` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  `sl` int(255) NOT NULL,
  `slcon` int(255) NOT NULL,
  `dongia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `sach`
--

INSERT INTO `sach` (`masach`, `tensach`, `tacgia`, `nhaxb`, `theloai`, `sl`, `slcon`, `dongia`) VALUES
(10, 'Giáo Trình Tư Tưởng Hồ Chí Minh', 'Nguyễn Minh Tuấn', 'Chính Trị Quốc Gia Sự Thật', 'Chính Trị', 72, 101, 100000),
(11, 'Món Ăn Xứ Huế', 'Võ Hoàng Nhân', 'Phụ Nữ', 'Nấu Ăn', 120, 120, 100000),
(12, 'Tiếng Anh Thông Dụng', 'Hồng Quang-Ngọc Huyên', 'Thanh Niên', 'Giáo Dục', 305, 201, 100000),
(13, 'Lập Trình Java', 'Nguyễn Minh Tuấn', 'Khoa Học Kỹ Thuật', 'Khoa Học', 365, 214, 100000),
(14, 'Món Xưa Vị Nay', 'Võ Hoàng Nhân', 'Phụ Nữ', 'Nấu Ăn', 404, 263, 140000),
(15, 'Xác Suất Thống Kê', 'Phạm Hoàng Quân', 'Giáo Dục Việt Nam', 'Toán Học', 404, 209, 90000),
(16, 'Những Bài Văn Miêu Tả', 'Nguyễn Thị Kim Dung-Lê Thị Mỹ Trinh', 'Tổng Hợp TPHCM', 'Văn Học', 330, 232, 80000),
(17, 'Hệ Điều Hành', 'Trần Trung Dũng-Phạm Tiến Sơn', 'Khoa Học và Kỹ Thuật', 'Khoa Học', 398, 300, 110000),
(18, 'Ba Bà Đi Bán Lợn Con', 'Hà Hoa', 'Tổng Hợp Đồng Nai', 'Truyện Tranh', 405, 260, 120000),
(19, 'Đảo Của Nim', 'Wendy Orr', 'Tổng Hợp TPHCM', 'Truyện Tranh', 300, 199, 30000),
(20, 'Tiền Của Thần Cây', 'Võ Diệu Thanh', 'Tổng Hợp TPHCM', 'Truyện Tranh', 151, 71, 100000),
(21, 'Lập Trình Ứng Dụng Wed với PHP', 'Khuất Thùy Phương', 'Đại Học Quốc Gia TPHCM', 'Khoa Học', 500, 400, 100000),
(22, 'Mạng Máy Tính', 'Mai Văn Cường-Trần Trung Dũng', 'Khoa Học và Kỹ Thuật', 'Khoa Học', 450, 350, 100000),
(23, '1800 Bài Tập Toán Rời Rạc', 'Seymour Lipschutz, Ph.D-Marc Lars Lipson. Ph.D-(Thanh Tâm và Xuân Toại biên dịch)', 'Lao Động', 'Toán Học', 360, 160, 100000),
(24, 'Lại Châm Ngôn', 'Thái Bá Tần', 'Lao Động', 'Văn Học', 200, 50, 100000),
(25, 'Bài Tập Cơ Sở Dữ Liệu', 'Nguyễn Xuân Huy-Lê Hoài Bắc', 'Đại Học Quốc Gia TPHCM', 'Khoa Học', 150, 100, 100000),
(26, 'Những Con Chữ Biết Hát', 'Đỗ Nhật Nam', 'Lao Động', 'Truyện Tranh', 300, 200, 30000),
(27, 'Mùa Tuyết Rơi', 'Trang Trang', 'Lao Động', 'Văn Học', 400, 350, 100000),
(28, 'Ăn Khế Trả Vàng', 'Anh Thiên', 'Tổng Hợp Đồng Nai', 'Truyện Tranh', 447, 247, 50000),
(29, 'Kể Chuyện Các Vị Vua Hiền', 'Nguyễn Việt Hà-Bùi Việt Thanh', 'Kim Đồng', 'Thiếu Nhi', 320, 160, 50000),
(30, 'Sự Tích Thần Tài', 'Lê Minh Hải-Hiếu Minh', 'Kim Đồng', 'Thiếu Nhi', 460, 360, 50000),
(31, 'Số Đỏ', 'Vũ Trọng Phụng', 'Kim Đồng', 'Văn Học', 385, 325, 50000),
(32, 'Chỉ Cần Có Mẹ', 'Lê Liên', 'Kim Đồng', 'Văn Học', 250, 200, 50000),
(33, 'Cẩm Nang Sơ Cứu', 'Nguyễn Thị Thanh Thủy', 'Kim Đồng', 'Khoa Học', 160, 100, 50000),
(34, 'Giáo Trình C++ và Lập Trình Hướng Đối Tượng', 'Phạm Văn Ất-Lê Trường Thông', 'Nhà Xuất Bản Bách Khoa HN', 'Khoa Học', 300, 260, 50000),
(35, 'Giáo Trình Tư Tưởng Hồ Chí Minh 2', 'PGS.TS Nguyễn Đức Hòa', 'Chính Trị Quốc Gia Sự Thật', 'Chính Trị', 250, 190, 100000),
(36, 'Giáo Trình Tư Tưởng Hồ Chí Minh 3', 'PGS.TS Nguyễn Đức Hòa', 'Chính Trị Quốc Gia Sự Thật', 'Chính Trị', 250, 190, 100000),
(37, 'Món Ăn Xứ Huế 2', 'Khuất Thùy Phươngs', 'Phụ Nữ', 'Truyện Tranh', 210, 100, 100000),
(38, 'Truyện Ma', 'Nguyễn Minh Tuấn', 'Đại Học Quốc Gia TPHCM', 'Truyện Tranh', 0, 0, 100000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tacgia`
--

CREATE TABLE `tacgia` (
  `matg` int(11) NOT NULL,
  `tentg` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tacgia`
--

INSERT INTO `tacgia` (`matg`, `tentg`) VALUES
(4, 'Khuất Thùy Phươngs'),
(5, 'Võ Hoàng Nhân'),
(6, 'Trang Trang'),
(7, 'Nguyễn Minh Tuấn'),
(9, 'Đỗ Nhật Nam'),
(10, 'Phạm Hoàng Quân'),
(11, 'Võ Diệu Thanh'),
(12, 'Mai Văn Cường'),
(13, 'Trần Trung Dũng'),
(14, 'Lê Liên'),
(15, 'Lê Minh Hải'),
(16, 'Vũ Trọng Phụng'),
(17, 'Hà Hoa'),
(18, 'Hồ Quang'),
(19, 'Ngọc Huyên'),
(20, 'Anh Thiên'),
(21, 'Hiếu Minh'),
(22, 'Nguyễn Thị Kim Dung'),
(23, 'Lê Thị Mỹ Trinh'),
(24, 'Wendy Orr'),
(25, 'Nguyễn Đức Hòa'),
(26, 'Thái Bá Tần'),
(27, 'Phạm Tiến Sơn'),
(28, 'Nguyễn Xuân Huy'),
(29, 'Lê Hoài Bắc'),
(30, 'Nguyễn Thị Thanh Thúy'),
(31, 'Phạm Văn Ất'),
(32, 'Lê Trường Thông');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `theloai`
--

CREATE TABLE `theloai` (
  `matl` int(11) NOT NULL,
  `tentl` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `theloai`
--

INSERT INTO `theloai` (`matl`, `tentl`) VALUES
(1, 'Chính Trị'),
(2, 'Văn Học'),
(3, 'Khoa Học'),
(4, 'Nấu Ăn'),
(5, 'Toán Học'),
(6, 'Giáo Dục'),
(7, 'Truyện Tranh'),
(8, 'Thiếu Nhi'),
(9, 'Âm Nhạc'),
(10, 'Mỹ Thuật');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tinhtrangsach`
--

CREATE TABLE `tinhtrangsach` (
  `matinhtrang` int(11) NOT NULL,
  `tentinhtrang` varchar(33) COLLATE utf8_unicode_ci NOT NULL,
  `giaphat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tinhtrangsach`
--

INSERT INTO `tinhtrangsach` (`matinhtrang`, `tentinhtrang`, `giaphat`) VALUES
(0, 'Trễ Hạn', 1),
(1, 'Mất Sách', 10),
(2, 'Rách Sách', 5);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietmuontra`
--
ALTER TABLE `chitietmuontra`
  ADD PRIMARY KEY (`chitietmuontra`);

--
-- Chỉ mục cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`chitietphieunhap`);

--
-- Chỉ mục cho bảng `chitietphieuphat`
--
ALTER TABLE `chitietphieuphat`
  ADD PRIMARY KEY (`chitietphieuphat`);

--
-- Chỉ mục cho bảng `docgia`
--
ALTER TABLE `docgia`
  ADD PRIMARY KEY (`madocgia`);

--
-- Chỉ mục cho bảng `nhacc`
--
ALTER TABLE `nhacc`
  ADD PRIMARY KEY (`mancc`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`manv`);

--
-- Chỉ mục cho bảng `nxb`
--
ALTER TABLE `nxb`
  ADD PRIMARY KEY (`manxb`);

--
-- Chỉ mục cho bảng `phieumuontra`
--
ALTER TABLE `phieumuontra`
  ADD PRIMARY KEY (`mamuontra`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`maphieunhap`);

--
-- Chỉ mục cho bảng `phieuphat`
--
ALTER TABLE `phieuphat`
  ADD PRIMARY KEY (`maphieuphat`);

--
-- Chỉ mục cho bảng `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`masach`);

--
-- Chỉ mục cho bảng `tacgia`
--
ALTER TABLE `tacgia`
  ADD PRIMARY KEY (`matg`);

--
-- Chỉ mục cho bảng `theloai`
--
ALTER TABLE `theloai`
  ADD PRIMARY KEY (`matl`);

--
-- Chỉ mục cho bảng `tinhtrangsach`
--
ALTER TABLE `tinhtrangsach`
  ADD PRIMARY KEY (`matinhtrang`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chitietmuontra`
--
ALTER TABLE `chitietmuontra`
  MODIFY `chitietmuontra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  MODIFY `chitietphieunhap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT cho bảng `chitietphieuphat`
--
ALTER TABLE `chitietphieuphat`
  MODIFY `chitietphieuphat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `docgia`
--
ALTER TABLE `docgia`
  MODIFY `madocgia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT cho bảng `nhacc`
--
ALTER TABLE `nhacc`
  MODIFY `mancc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `manv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `nxb`
--
ALTER TABLE `nxb`
  MODIFY `manxb` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT cho bảng `phieumuontra`
--
ALTER TABLE `phieumuontra`
  MODIFY `mamuontra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `maphieunhap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `phieuphat`
--
ALTER TABLE `phieuphat`
  MODIFY `maphieuphat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `sach`
--
ALTER TABLE `sach`
  MODIFY `masach` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT cho bảng `tacgia`
--
ALTER TABLE `tacgia`
  MODIFY `matg` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT cho bảng `theloai`
--
ALTER TABLE `theloai`
  MODIFY `matl` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `tinhtrangsach`
--
ALTER TABLE `tinhtrangsach`
  MODIFY `matinhtrang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
