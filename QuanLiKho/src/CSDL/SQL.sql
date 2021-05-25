create database QLKHO
go

use QLKHO
go
create table NhanVien(
MaNV varchar(8) primary key,
TenNV nvarchar (50) ,
NgaySinh date
 check(datediff(day,dateadd(year,-18,getdate()),NgaySinh)<=0),
DiaChi nvarchar(50) ,
SDT varchar(11) 
constraint  sdt check
(SDT like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' or SDT like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
GioiTinh nvarchar(4)
check (GioiTinh in (N'Nam',N'Nữ')) ,
Email varchar(30) 
check (email like '[a-z]%@%'),
Password varchar(10) 
)
go
Set dateformat dmy
insert into Nhanvien
values ('NV01','Hồ Thị Vân Anh ','11/03/2001','Đức Bố 1','0839581138',N'Nữ','Anh@gmail.com','12345'),
       ('NV02','Hồ Thiện Phước ','22/3/2001','Phú Ninh','0373520613',N'Nam','Phuoc@gmail.com','11111'),
	   ('NV03','Hồ Thái Bình ','20/4/2001','Dak Mil','0123456789',N'Nam','Binh@gmail.com','00000'),
	   ('NV04','Trần Đại ','24/01/2001','Quãng Ngãi','0866146741',N'Nam','Dai@gmail.com','22222'),
	   ('NV05','Nguyễn Thị Thoa ','25/03/2001','Thạch Kiều','0397927870',N'Nữ','Thoa@gmail.com','33333')
go
create table DanhMuc(
MaDM varchar(8) ,
TenDM nvarchar(50) ,
)
go
insert into DanhMuc
Values('DM01','Sách Lập Trình'),
	  ('DM02','Sách Nâng Cao'),
	  ('DM03','Sách Toán')
go
create table SanPham(
MaSach varchar(8) primary key ,
TenSach nvarchar(20) ,
MaDM varchar(8),
Tacgia nvarchar(30) ,
NXB nvarchar(30),
ngayXuatBang date,
Gia money ,
)
go
insert into SanPham
Values ('S01',N'Lập trình Java 2 nữ','DM01',N'Đỗ Phú',N'Kim Đồng','11/3/2019','50000'),
	   ('S02',N'Lập trình C','DM02',N'Hoàng Thị Mỹ Lệ','SPKT','25/3/2020','90000'),
	   ('S03',N'Toán rời rác','DM03',N'Khong biet','HCM','24/01/1995','100000')
go
create table HoaDon(
MaHD varchar(8) primary key,
MaNV varchar(8),
Ngay date ,
TenKH nvarchar (30),
Loai nvarchar(1) ,
FOREIGN KEY (MaNV) REFERENCES Nhanvien(MaNV),
)
go
set dateformat dmy
insert into HoaDon
Values('HD01','NV02','24/5/2019',N'Nguyễn An','N'),
	  ('HD02','NV04','12/9/2020','Nguyên Thúy','N'),
	  ('HD03','NV05','14/5/2018','Nguyễn Hà Anh','X')
go
create table ChiTietHoaDon(
MaHD varchar(8) ,
MaSach varchar(8) ,
SoLuong int 
 check (SoLuong >0 ),
DonGia money
check (DonGia > 0),
FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
FOREIGN KEY (MaSach) REFERENCES SanPham(MaSach),
primary key (MaHD,MaSach),
)
go
insert into ChiTietHoaDon
Values('HD01','S01','20','1'),
	  ('HD02','S03','50','1'),
	  ('HD03','S02','15','1')
go

create procedure [dbo].[insertSanPham_pr](@tensach nvarchar(20),@maDm varchar(8),@tacGia nvarchar(30),@NXB nvarchar(30), @ngayxuatbang varchar(12))
as
begin 
	declare @temp as varchar(10)
	declare @temp2 as varchar(10)

	set @temp2 = (select top 1 MaSach as ma from SanPham)

	set @temp = (select top 1 CAST(substring(MaSach,3,9) as int) as ma from SanPham order by ma desc )
	set @temp = @temp +1
	set @temp = substring(@temp2,1,len(@temp2)-len(@temp) )+@temp 

	SET DATEFORMAT dmy

	insert into SanPham (MaSach,TenSach,MaDM,Tacgia,NXB,ngayXuatBang) 
	values(@temp,@tensach,@maDm,@tacGia,@NXB,@ngayxuatbang)
end
