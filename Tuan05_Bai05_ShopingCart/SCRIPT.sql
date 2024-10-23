/* 
	Script này sử dụng cho Microsoft SQL Server
	Chạy script nhanh: 
		(Bước 01) CTRL + A
		(Bước 02) ALT + X

	FOR DEBUG:
		USE master
		DROP DATABASE DuongThaiBao_21037621_Bai05T05
		GO
*/
CREATE DATABASE DuongThaiBao_21037621_Bai05T05
GO

USE DuongThaiBao_21037621_Bai05T05
GO

CREATE TABLE Products(
	MaSP NVARCHAR(50) PRIMARY KEY,
	TenSP NVARCHAR(255),
	SoLuong INT,
	Gia DECIMAL,
	ImgPath NVARCHAR(255),
)
GO

INSERT INTO Products(maSP, TenSP, SoLuong, Gia, ImgPath) VALUES('pro01', N'Lược sử loài người', 10, 150000, 'image01.png')
INSERT INTO Products(maSP, TenSP, SoLuong, Gia, ImgPath) VALUES('pro02', N'Sword Art Online: Tập 01', 20, 200000, 'image02.png')
INSERT INTO Products(maSP, TenSP, SoLuong, Gia, ImgPath) VALUES('pro03', N'Conan - Thám tử lừng danh: Tập 01', 99, 70000, 'image03.png')
INSERT INTO Products(maSP, TenSP, SoLuong, Gia, ImgPath) VALUES('pro04', N'Tôi vẽ', 120, 192000, 'image04.png')
INSERT INTO Products(maSP, TenSP, SoLuong, Gia, ImgPath) VALUES('pro05', N'Bí mật của may mắn', 19, 191200, 'image05.png')
INSERT INTO Products(maSP, TenSP, SoLuong, Gia, ImgPath) VALUES('pro06', N'Thỏ bảy màu - Truyện tranh', 30, 203000, 'image06.png')
INSERT INTO Products(maSP, TenSP, SoLuong, Gia, ImgPath) VALUES('pro07', N'Thỏ bảy màu - Truyện tranh 2', 32, 273000, 'image07.png')
INSERT INTO Products(maSP, TenSP, SoLuong, Gia, ImgPath) VALUES('pro08', N'Thỏ bảy màu - Truyện tranh 3', 11, 22000, 'image08.png')
GO


CREATE TABLE Bill(
	id INT IDENTITY(1,1) PRIMARY KEY,
	FullName NVARCHAR(50),
	Address NVARCHAR(255),
	Price DECIMAL,
	Payment NVARCHAR(255),
)
GO

SELECT * FROM Bill