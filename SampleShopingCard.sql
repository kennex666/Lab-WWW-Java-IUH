CREATE DATABASE SampleShopingCart
GO

use SampleShopingCart
GO

CREATE TABLE Products(
	id int identity(1,1),
	name nvarchar(255),
	image nvarchar(1000),
	price 
)