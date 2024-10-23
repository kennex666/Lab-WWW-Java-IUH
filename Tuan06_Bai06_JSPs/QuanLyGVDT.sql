CREATE DATABASE QuanLyGiangVienDeTai
GO

use QuanLyGiangVienDeTai
GO

CREATE TABLE GiangVien(
	MaGV NVARCHAR(20) PRIMARY KEY,
	TenGV NVARCHAR(100) NOT NULL,
	LinhVucNghienCuu NVARCHAR(250),
	SoDienThoai NVARCHAR(50)
)

CREATE TABLE DeTai(
	MaDT NVARCHAR(20) PRIMARY KEY,
	TenDT NVARCHAR(100) NOT NULL,
	NamDangKy int,
	MoTaDeTai NVARCHAR(250),
	MaGV NVARCHAR(20) REFERENCES GiangVien(MaGV) ON DELETE CASCADE ON UPDATE CASCADE
)

GO
-- Insert dữ liệu vào bảng GIANGVIEN với NVARCHAR
INSERT INTO GIANGVIEN (MaGV, TenGV, LinhVucNghienCuu, SoDienThoai) VALUES 
(N'GV001', N'Nguyễn Bùi Thanh Hòa', N'Khoa học cơ bản', '0909123456'),
(N'GV002', N'Hồ Huỳnh Thùy An', N'Công nghệ thông tin', '0918456894'),
(N'GV003', N'Lê Hoàng Hóa', N'Kỹ thuật phần mềm', '0983453576'),
(N'GV004', N'Trần Bảo Châu', N'Hệ thống thông tin', '0914324578'),
(N'GV005', N'Nguyễn Lê Giao', N'Khoa học máy tính', '0978123453'),
(N'GV006', N'Hoàng Thị Ngọc Ánh', N'Điện tử công nghiệp', '0988765434');
GO
-- Insert dữ liệu vào bảng DETAI với NVARCHAR
INSERT INTO DETAI (MaDT, TenDT, NamDangKy, MoTa, MaGV) VALUES 
(N'DT0001', N'Tìm hiểu Mikrotik Router', 2016, N'Tìm hiểu Mikrotik Router và xây dựng Demo hệ thống Hotspot Gateway cho dịch vụ Internet LAN Wifi có chứng thực trình bày các nội dung về công nghệ Wireless LAN', N'GV002'),
(N'DT0002', N'Xây dựng website thương mại điện tử', 2015, N'Thiết kế và xây dựng website thương mại điện tử cho công ty X', N'GV004'),
(N'DT0003', N'Xây dựng hệ thống quản lý hệ thống siêu thị Coop Mart', 2015, N'Nhiệm vụ của đề tài là trình bày, phân tích và thiết kế phần mềm về tổ chức siêu thị, xác định hiện trạng và phạm vi của hệ thống.', N'GV003'),
(N'DT0004', N'Xây dựng phần mềm quản lý nhân sự, tiền lương', 2015, N'Phân tích, thiết kế, xây dựng phần mềm quản lý nhân sự, tiền lương cho công ty Y', N'GV004'),
(N'DT0005', N'Xây dựng ứng dụng quản lý thư viện', 2015, N'Phân tích, thiết kế, xây dựng phần mềm quản lý thư viện cho trường cao đẳng', N'GV004');
GO

SELECT * FROM GiangVien
SELECT * FROM DeTai