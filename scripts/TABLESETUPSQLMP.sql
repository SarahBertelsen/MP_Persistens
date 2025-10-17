USE DMA-CSD-V251_10669007

CREATE table [Product] (
ProductId int IDENTITY (1000,1) PRIMARY KEY NOT NULL,
[Name] varchar(100) NOT NULL,
ProductType varchar (100) NOT NULL,
SalePrice money NOT NULL
)
CREATE table MusicProduct (
ProductId int NOT NULL FOREIGN KEY REFERENCES [Product] (ProductId),
[Format] varchar(100) NOT NULL,
Artist varchar(100) NOT NULL
)
CREATE table ClothingProduct (
ProductId int NOT NULL FOREIGN KEY REFERENCES [Product] (ProductId),
Size varchar (100) NOT NULL,
Colour varchar(100) NOT NULL
)
CREATE table EquipmentProduct (
ProductId int NOT NULL FOREIGN KEY REFERENCES [Product] (ProductId),
Material varchar (100) NOT NULL,
Style varchar (100) NOT NULL
)
CREATE table GunReplicaProduct(
ProductId int NOT NULL FOREIGN KEY REFERENCES [Product] (ProductId),
Calibre varchar (100) NOT NULL,
Material varchar (100) NOT NULL
)
CREATE Table WareHouse (
WareHouseId int IDENTITY (1000,1) PRIMARY KEY NOT NULL,
[Name] varchar(50) NOT NULL,
Description varchar (1000) NOT NULL
)
CREATE table Stock (
StockId int IDENTITY (1000,1) PRIMARY KEY NOT NULL,
WareHouseId int NOT NULL FOREIGN KEY REFERENCES Warehouse (WareHouseId),
AvailableQty int NOT NULL,
ReservedQty int NOT NULL,
MinStock int NOT NULL
)
CREATE table ProductSalePrice (
ProductId int NOT NULL FOREIGN KEY REFERENCES [Product] (ProductId),
ProductSalePriceId int IDENTITY (1000,1) PRIMARY KEY NOT NULL,
[Timestamp] Date UNIQUE NOT NULL,
Price money Not NULL
)
CREATE table Freight (
FreightId int IDENTITY (1000,1) PRIMARY KEY NOT NULL,
Method varchar (100) NOT NULL,
BaseCost money NOT NULL,
FreeThreshold money NOT NULL,
DeliveryStatus varchar (100) NOT NULL,
DeliveryDate varchar (13) NOT NULL,
)
CREATE table Discount (
DiscountId int IDENTITY (1000,1) PRIMARY KEY NOT NULL,
[Type] money NOT NULL,
DiscountAmount money NOT NULL,
DiscountThreshold money NOT NULL
)
CREATE Table InVoice (
InvoiceId int IDENTITY (1000,1) PRIMARY KEY NOT NULL,
PaymentDate date NOT NULL,
Vat float NOT NULL,
TotalAmount money
)
CREATE table City (
Zipcode varchar (4) PRIMARY KEY NOT NULL,
CityName varchar (100) NOT NULL
)
CREATE table Customer (
CustomerId int IDENTITY (1000,1) PRIMARY KEY NOT NULL,
FName varchar (100) NOT NULL,
LName varchar (100) NOT NULL,
[Address] varchar (200) NOT NULL,
Zipcode varchar (4) NOT NULL FOREIGN KEY REFERENCES City(Zipcode),
PhoneNo varchar(11) NOT NULL
)
CREATE TABLE SaleOrder (
SaleOrderId int IDENTITY (1000,1) PRIMARY KEY NOT NULL,
FreightId int NOT NULL FOREIGN KEY REFERENCES Freight(FreightId),
DiscountId int NOT NULL FOREIGN KEY REFERENCES Discount(DiscountId),
CustomerId int NOT NULL FOREIGN KEY REFERENCES Customer(CustomerId),
[Date] Date NOT NULL,
)
CREATE table OrderLineItem (
OrderLineId int IDENTITY (1,1) PRIMARY KEY NOT NULL,
SaleOrder int NOT NULL FOREIGN KEY REFERENCES SaleOrder(SaleOrderId),
ProductId int NOT NULL FOREIGN KEY REFERENCES [Product](ProductId),
Quantity int NOT NULL
)