CREATE DATABASE QUANLYDANHMUC;
GO

use QUANLYDANHMUC
GO

CREATE TABLE DanhMuc(
	maDM NVARCHAR(50) PRIMARY KEY,
	tenDanhMuc NVARCHAR(50) NOT NULL,
	nguoiQuanLy NVARCHAR(100),
	ghiChu NVARCHAR(500)

)

CREATE TABLE TinTuc(
	maTT NVARCHAR(50) PRIMARY KEY,
	tieuDe NVARCHAR(100) NOT NULL,
	noiDungTT NVARCHAR(256),
	lienKet NVARCHAR(255),
	maDM NVARCHAR(50) REFERENCES DanhMuc(maDM) ON DELETE CASCADE ON UPDATE CASCADE
)

GO

INSERT INTO DanhMuc (maDM, tenDanhMuc, nguoiQuanLy, ghiChu) VALUES
( N'A01', N'Bóng đá', N'Dương Thái Bảo', N'Không' ),
( N'A02', N'Bóng chuyền', N'Dương Thái Bảo', N'Không' )


INSERT INTO TinTuc (maTT, tieuDe, noiDungTT, lienKet, maDM) VALUES
( N'A0001', N'Bóng đá thế giới', N'Không có nội dung gì nhưng vẫn ghi cho dài dài xíu để test................', N'http://dtbao.io.vn/', N'A01' ),
( N'A0002', N'Bóng chuyền thế giới', N'Không có nội dung gì nhưng vẫn ghi cho dài dài xíu để test................', N'http://dtbao.io.vn/', N'A02' )

GO
 
SELECT * FROM DanhMuc
SELECT * FROM TinTuc

DELETE FROM TinTuc WHERE maTT = N'A0001'