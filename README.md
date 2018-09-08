### Endpoints

| Method | Url | Description | RequestBody | 
| ------ | --- | ---------- |------------ |
| POST    |/order/new  | add new order with status CREATED | order JSON|
| POST    |/order/validate| validate existing order - change status to PAID | order id - integer|

### Example of order JSON
`{
	"order": {
		"totalPrice": 2.2,
		"totalPriceCurrency": "PLN"
	},
	"customer": {
		"name": "Stefan",
		"surname": "Kowalski",
		"pesel": "75110521456"
	},
	"shippingAddress": {
		"city": "Grójec",
		"street": "Główna",
		"houseNr": 125,
		"apartmentNr": 54
	},
	"itemList": [
		{
			"name": "Banana",
			"description": "This is a banana",
			"barcode": "BBB",
			"price": 2.15,
			"quantity": 5,
			"price_currency": "PLN"
		},
		{
			"name": "Coconut",
			"description": "This is a coconut",
			"barcode": "CCC",
			"price": 12.86,
			"quantity": 1,
			"price_currency": "PLN"
		}
		]
}`