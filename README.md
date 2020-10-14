Premium calculation can be invoked via rest api.

Send HTTP POST request to: http://localhost:8080/premium

Example of request body:
```json
{
  "number": "POLICY1",
  "status": "REGISTERED",
  "policyObjects": [{
    "name": "HOUSE",
    "subObjects": [{
      "name": "TV",
      "sumInsured": 100,
      "riskType": "FIRE"
    }, {
      "name": "Chair",
      "sumInsured": 8,
      "riskType": "THEFT"
    }]
  }]
}
```

Note:

All fields are mandatory, although policy can have an empty array of objects and object can have an empty array of sub-objects.