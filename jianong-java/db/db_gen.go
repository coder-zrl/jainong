package main

import (
	"gorm.io/driver/mysql"
	"gorm.io/gorm"
	"time"
)

type Product struct {
	ID            uint    `gorm:"primarykey;comment:产品编号"`
	Name          string  `gorm:"type:varchar(50);comment:产品名称"`
	Unit          string  `gorm:"type:varchar(50);comment:产品计数单位"`
	Level         string  `gorm:"type:varchar(50);comment:产品等级"`
	Origin        string  `gorm:"type:varchar(50);comment:产品产地"`
	Freight       float64 `gorm:"type:decimal(50);comment:产品运费"`
	PurchasePrice float64 `gorm:"type:decimal(50);comment:产品进价"`
	WrapPage      string  `gorm:"type:varchar(50);comment:产品包装物"`
}

func (Product) TableName() string {
	return "product"
}

type ProductStorage struct {
	ID               uint      `gorm:"primarykey;comment:产品入库编号"`
	ProductID        uint      `gorm:"type:varchar(50);comment:产品编号"`
	ProductName      string    `gorm:"type:varchar(50);comment:产品名称"`
	PurchasePrice    float64   `gorm:"type:decimal(50);comment:产品进价"`
	TotalJinNumber   float64   `gorm:"type:float(50);comment:入库总斤数"`
	Amount           float64   `gorm:"type:decimal(50);comment:金额"`
	CheckOne         string    `gorm:"type:varchar(50);comment:校验人"`
	Handler          string    `gorm:"type:varchar(50);comment:经手人"`
	StorageTime      time.Time `gorm:"type:datetime;comment:入库时间"`
	GeographicalName string    `gorm:"type:varchar(50);comment:片名"`
	FarmerID         string    `gorm:"type:varchar(50);comment:农户"`
}

func (ProductStorage) TableName() string {
	return "product_storage"
}

type ProductOutbound struct {
	ID               uint      `gorm:"primarykey;comment:产品出库编号"`
	ProductID        uint      `gorm:"type:varchar(50);comment:产品编号"`
	ProductName      string    `gorm:"type:varchar(50);comment:产品名称"`
	PurchasePrice    float64   `gorm:"type:decimal(50);comment:产品进价"`
	TotalJinNumber   float64   `gorm:"type:float(50);comment:出库总斤数"`
	Amount           float64   `gorm:"type:decimal(50);comment:金额"`
	Handler          string    `gorm:"type:varchar(50);comment:经手人"`
	OutboundTime     time.Time `gorm:"type:datetime;comment:出库时间"`
	GeographicalName string    `gorm:"type:varchar(50);comment:片名"`
	FarmerID         string    `gorm:"type:varchar(50);comment:农户"`
	ReceivingParty   string    `gorm:"type:varchar(50);comment:收货方：中心一、中心二"`
}

func (ProductOutbound) TableName() string {
	return "product_outbound"
}

type ProductInventory struct {
	ID              uint   `gorm:"primarykey;comment:产品盘存编号"`
	ProductID       uint   `gorm:"type:varchar(50);comment:产品编号"`
	ProductName     string `gorm:"type:varchar(50);comment:产品名称"`
	InventoryNumber string `gorm:"type:varchar(50);comment:库存数量"`
	PhysicalNumber  string `gorm:"type:varchar(50);comment:盘点数量"`
	InventoryStatus string `gorm:"type:varchar(50);comment:产品盘存状态：盘盈、盘亏"`
}

func (ProductInventory) TableName() string {
	return "product_inventory"
}

type Supplies struct {
	ID            uint    `gorm:"primarykey;comment:物资编号"`
	Name          string  `gorm:"type:varchar(50);comment:物资名称"`
	Unit          string  `gorm:"type:varchar(50);comment:物资计数单位"`
	PurchasePrice float64 `gorm:"type:varchar(50);comment:物资进价"`
	SellPrice     float64 `gorm:"type:decimal(50);comment:物资售价"`
}

func (Supplies) TableName() string {
	return "supplies"
}

type SuppliesStorage struct {
	ID                uint    `gorm:"primarykey;comment:物资入库编号"`
	SuppliesID        uint    `gorm:"type:varchar(50);comment:物资编号"`
	SuppliesName      float64 `gorm:"type:varchar(50);comment:物资名称"`
	SuppliesSellPrice float64 `gorm:"type:decimal(50);comment:物资单价"`
	SuppliesNumber    float64 `gorm:"type:decimal(50);comment:物资数量"`
}

func (SuppliesStorage) TableName() string {
	return "supplies_torage"
}

type SuppliesOutbound struct {
	ID                uint    `gorm:"primarykey;comment:出库编号"`
	FarmerID          uint    `gorm:"type:varchar(50);comment:农户编号"`
	FarmerName        string  `gorm:"type:varchar(50);comment:农户名称"`
	SuppliesID        uint    `gorm:"type:varchar(50);comment:物资编号"`
	SuppliesName      float64 `gorm:"type:varchar(50);comment:物资名称"`
	SuppliesSellPrice float64 `gorm:"type:decimal(50);comment:物资单价"`
	SuppliesNumber    float64 `gorm:"type:decimal(50);comment:物资数量"`
}

func (SuppliesOutbound) TableName() string {
	return "supplies_outbound"
}

type Farmer struct {
	ID          uint    `gorm:"primarykey;comment:农户编号"`
	Name        string  `gorm:"type:varchar(50);comment:农户名称"`
	Address     string  `gorm:"type:varchar(50);comment:农户住址"`
	PhoneNumber string  `gorm:"type:varchar(50);comment:联系电话"`
	SownArea    float64 `gorm:"type:varchar(50);comment:播种面积"`
}

func (Farmer) TableName() string {
	return "farmer"
}

type Customer struct {
	ID          uint   `gorm:"primarykey;comment:顾客编号"`
	Name        string `gorm:"type:varchar(50);comment:顾客名称"`
	Address     string `gorm:"type:varchar(50);comment:顾客住址"`
	PhoneNumber string `gorm:"type:varchar(50);comment:顾客电话"`
}

func (Customer) TableName() string {
	return "customer"
}

type Institution struct {
	ID          uint   `gorm:"primarykey;comment:机构编号"`
	Name        string `gorm:"type:varchar(50);comment:机构名称"`
	Type        string `gorm:"type:varchar(50);comment:机构类型：生产基地、批发中心、收购点"`
	Address     string `gorm:"type:varchar(50);comment:机构地址"`
	PhoneNumber string `gorm:"type:varchar(50);comment:联系电话"`
}

func (Institution) TableName() string {
	return "institution"
}

type Document struct {
	ID            uint      `gorm:"primarykey;comment:单据编号"`
	Type          string    `gorm:"type:varchar(50);comment:单据类型：付款单、收款单"`
	ProductName   string    `gorm:"type:varchar(50);comment:产品名称"`
	ProductNumber string    `gorm:"type:varchar(50);comment:产品数量"`
	CreatAt       time.Time `gorm:"type:datetime;comment:创建时间"`
}

func (Document) TableName() string {
	return "document"
}

func main() {
	dsn := "root:123456@tcp(47.103.198.84:3306)/jianong?charset=utf8mb4&parseTime=True&loc=Local"
	db, err := gorm.Open(mysql.Open(dsn), &gorm.Config{})
	if err != nil {
		panic(err)
	}

	// 迁移 schema，自动生成表
	db.AutoMigrate(&Product{})
	db.AutoMigrate(&ProductStorage{})
	db.AutoMigrate(&ProductOutbound{})
	db.AutoMigrate(&ProductInventory{})
	db.AutoMigrate(&Supplies{})
	db.AutoMigrate(&SuppliesStorage{})
	db.AutoMigrate(&SuppliesOutbound{})
	db.AutoMigrate(&Farmer{})
	db.AutoMigrate(&Customer{})
	db.AutoMigrate(&Institution{})
	db.AutoMigrate(&Document{})
}
