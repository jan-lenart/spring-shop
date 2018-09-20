### Endpoints

| Method | Url | Description | RequestBody | 
| ------ | --- | ---------- |------------ |
| POST    |/orderInfo/new  | add new orderInfo with status CREATED | orderInfo JSON|
| POST    |/orderInfo/validate| validate existing orderInfo - change status to PAID | orderInfo id - integer|

### Example of orderInfo JSON
`{
	"orderInfo": {
		"id": 2,
		"orderDateTime": "2018-09-14T18:38:09.223",
		"totalPriceCurrency": "PLN"
	},
	"customer": {
		"id": 1,
		"name": "Stefan",
		"surname": "Kowalski",
		"pesel": "75110521456"
	},
	"shippingAddress": {
		"id": 1,
		"city": "Grójec",
		"street": "Główna",
		"houseNr": 125,
		"apartmentNr": 54
	},
	"itemList": [
		{
			"id": 1,
			"name": "Banana",
			"description": "It is a banana",
			"barcode": "BBB",
			"price": 2.15,
			"quantity": 5,
			"priceCurrency": "PLN"
		},
		{
			"id": 2,
			"name": "Coconut",
			"description": "It is a coconut",
			"barcode": "CCC",
			"price": 12.86,
			"quantity": 1,
			"priceCurrency": "PLN"
		}
		]
}`