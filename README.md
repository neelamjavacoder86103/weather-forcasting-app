#Rest api get weather details based on Zipcode
curl --location 'http://localhost:8080/weather/10002'


Below is Response
{
    "zipcode": "10002",
    "calculationTime": "2024-03-04T22:31:52",
    "weatherState": {
        "id": 803,
        "name": "Clouds",
        "description": "broken clouds",
        "iconId": "04d",
        "weatherConditionEnum": "CLOUDS_BROKEN",
        "weatherIconUrl": "http://openweathermap.org/img/w/04d.png"
    },
    "temperature": {
        "value": 56.35,
        "maxTemperature": 61.95,
        "minTemperature": 51.03,
        "feelsLike": 55.08,
        "unit": "°F"
    },
    "atmosphericPressure": {
        "value": 1029.0,
        "seaLevelValue": null,
        "groundLevelValue": null,
        "unit": "hPa"
    },
    "humidity": {
        "value": 72,
        "unit": "%"
    },
    "wind": {
        "speed": 9.22,
        "degrees": 80.0,
        "gust": null,
        "unit": "miles/hour"
    },
    "rain": null,
    "snow": null,
    "clouds": {
        "value": 75,
        "unit": "%"
    },
    "location": {
        "id": 0,
        "name": "New York",
        "countryCode": "US",
        "sunriseTime": "2024-03-04T16:54:43",
        "sunsetTime": "2024-03-05T04:20:43",
        "zoneOffset": "-05:00",
        "coordinate": {
            "latitude": 40.7152,
            "longitude": -73.9877
        }
    },
    "dataFromCache": true
}
