package main

import (
	"gorm.io/driver/mysql"
	"gorm.io/gorm"
)

type Product struct {
	ID            uint    `gorm:"primarykey;comment:'产品编号'"`
	Name          string  `gorm:"type:varchar(50);comment:'产品名称'"`
	Unit          string  `gorm:"type:varchar(50);comment:'产品计数单位'"`
	Level         string  `gorm:"type:varchar(50);comment:'产品等级'"`
	Origin        string  `gorm:"type:varchar(50);comment:'产品产地'"`
	PurchasePrice float64 `gorm:"type:decimal(50);comment:'产品进价'"`
	WrapPage      string  `gorm:"type:decimal(50);comment:'产品包装物'"`
}

func (Product) TableName() string {
	return "product"
}

type Supplies struct {
	ID            uint    `gorm:"primarykey;comment:'物资编号'"`
	Name          string  `gorm:"type:varchar(50);comment:'物资名称'"`
	Unit          string  `gorm:"type:varchar(50);comment:'物资计数单位'"`
	PurchasePrice float64 `gorm:"type:varchar(50);comment:'物资进价'"`
	SellPrice     float64 `gorm:"type:decimal(50);comment:'物资售价'"`
}

func (Supplies) TableName() string {
	return "supplies"
}

type Farmer struct {
	ID          uint    `gorm:"primarykey;comment:'农户编号'"`
	Name        string  `gorm:"type:varchar(50);comment:'农户名称'"`
	Address     string  `gorm:"type:varchar(50);comment:'农户住址'"`
	PhoneNumber string  `gorm:"type:varchar(50);comment:'联系电话'"`
	SownArea    float64 `gorm:"type:varchar(50);comment:'播种面积'"`
}

func (Farmer) TableName() string {
	return "farmer"
}

type Customer struct {
	ID          uint   `gorm:"primarykey;comment:'顾客编号'"`
	Name        string `gorm:"type:varchar(50);comment:'顾客名称'"`
	Address     string `gorm:"type:varchar(50);comment:'顾客住址'"`
	PhoneNumber string `gorm:"type:varchar(50);comment:'顾客电话'"`
}

func (Customer) TableName() string {
	return "customer"
}

type Institution struct {
	ID          uint   `gorm:"primarykey;comment:'机构编号'"`
	Name        string `gorm:"type:varchar(50);comment:'机构名称'"`
	Type        string `gorm:"type:varchar(50);comment:'机构类型：生产基地、批发中心、收购点'"`
	Address     string `gorm:"type:varchar(50);comment:'机构地址'"`
	PhoneNumber string `gorm:"type:varchar(50);comment:'联系电话'"`
}

//func (Institution) TableName() string {
//	return "institution"
//}
//
//// PaymentOrder 付款单
//type PaymentOrder struct {
//	ID          uint   `gorm:"primarykey;comment:'付款单编号'"`
//	ProductName string `gorm:"type:varchar(50);comment:'产品名称'"`
//	Number      string `gorm:"type:varchar(50);comment:'机构地址'"`
//	PhoneNumber string `gorm:"type:varchar(50);comment:'联系电话'"`
//}
//
//func (PaymentOrder) TableName() string {
//	return "payment_order"
//}
//
//// Voucher 收款单
//type Voucher struct {
//	ID          uint   `gorm:"primarykey;comment:'单据编号'"`
//	Type        string `gorm:"type:varchar(50);comment:'单据类型：收款、付款'"`
//	ProductName string `gorm:"type:varchar(50);comment:'机构地址'"`
//	Number      string `gorm:"type:varchar(50);comment:'机构地址'"`
//	PhoneNumber string `gorm:"type:varchar(50);comment:'联系电话'"`
//}
//
//func (Voucher) TableName() string {
//	return "voucher"
//}

func main() {
	dsn := "root:123456@tcp(127.0.0.1:3306)/jianong?charset=utf8mb4&parseTime=True&loc=Local"
	db, err := gorm.Open(mysql.Open(dsn), &gorm.Config{})
	if err != nil {
		panic(err)
	}

	// 迁移 schema，自动生成表
	db.AutoMigrate(&Product{})
	db.AutoMigrate(&Supplies{})
	db.AutoMigrate(&Farmer{})
	db.AutoMigrate(&Customer{})
	db.AutoMigrate(&Institution{})
}
