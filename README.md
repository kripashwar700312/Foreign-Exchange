
# Foreign Exchange

Foreign Exchange is a project created to accept the exchange currency deals and analyze them.
One can send deal request through API provided following:

## API Documentation

**Request URL**: /deals

**Request Method**: POST

**Request Parameters**:

| Parameter            | Type          | Required  |
| :------------------- |:------------- | :---------|
| dealId               | String        | YES       |
| fromCurrencyISOCode  | String        | YES       |
| toCurrencyISOCode    | String        | YES       |
| orderDate            | String        | YES       |
| dealAmount           | Double        | YES       |

**Response Parameters**:
| Parameter     | Type         |
| :------------ |:-------------|
| httpStatus    | HttpStatus   |
| success       | boolean      |
| message       | String       |  
| data          | Object       |

#### Sample Request and Response:
##### 1. Request with all valid parameters and deal doesn't exists in system
**Request**:
{
    "dealId":"D1",
    "fromCurrencyISOCode":"USD",
    "toCurrencyISOCode":"NPR",
    "orderDate":"2021-03-22 10:10:10",
    "dealAmount":200.1
}
**Response**:
{
    "httpStatus": "CREATED",
    "success": true,
    "message": "Successfully accepted deal.",
    "data": null
}
##### 2. Request with all valid parameters and deal exists in system
**Request**:
{
    "dealId":"D1",
    "fromCurrencyISOCode":"USD",
    "toCurrencyISOCode":"NPR",
    "orderDate":"2021-03-22 10:10:10",
    "dealAmount":200.1
}
**Response**:
{
    "httpStatus": "NOT_ACCEPTABLE",
    "success": false,
    "message": "Deal with id D2 already exists.",
    "data": null
}
##### 3. Request with null and empty values in request parameters
**Request**:
{
    "dealId":"",
    "fromCurrencyISOCode":"USD",
    "toCurrencyISOCode":"NPR",
    "orderDate":"2021-03-22 10:10:10"
}
**Response**:
{
    "httpStatus": "BAD_REQUEST",
    "success": false,
    "message": "Validation error",
    "timestamp": "24-04-2021 11:48:36",
    "apiErrors": [
        {
            "field": "dealId",
            "rejectedValue": "",
            "message": "dealId cannot be empty"
        },
        {
            "field": "dealAmount",
            "rejectedValue": null,
            "message": "dealAmount cannot be null"
        }
    ]
}
##### 4. Request with invalid request body
**Request**:
{
    "dealId":"D1",
    "fromCurrencyISOCode":"USD",
    "toCurrencyISOCode":"NPR",
    "orderDate":"2021-03-22 10:10:10",
    "dealAmount":200.1,
}
**Response**:
{
    "httpStatus": "BAD_REQUEST",
    "success": false,
    "message": "Malformed JSON request",
    "timestamp": "24-04-2021 11:50:14",
    "apiErrors": []
}