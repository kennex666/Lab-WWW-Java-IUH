CREATE DATABASE BaiTap04_JSP
GO
use BaiTap04_JSP
GO

CREATE TABLE Products(
	id int IDENTITY(1,1),
	name nvarchar(255) NULL,
	image nvarchar(255) NULL,
	price decimal(38, 2)
)
GO