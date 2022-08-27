GET http://localhost:8080/api/v1

[
    {
        "id": 1,
        "title": "first use",
        "description": "first time used",
        "content": "played 1"
    },
    {
        "id": 5,
        "title": "first useaaaaaaaa",
        "description": "first time used",
        "content": "played 1"
    },
    {
        "id": 6,
        "title": "first useaaaaaaaavcxzvzvz",
        "description": "first time used",
        "content": "played 1"
    },
    {
        "id": 7,
        "title": "first useaaaaaaaavcsafafaxzvzvz",
        "description": "first tiafafme used",
        "content": "played 12"
    }
]

POST http://localhost:8080/api/v1
{
    "id": 9,
    "title": "after crud update2",
    "description": "1234",
    "content": "trying multiple operations"
}

DELETE http://localhost:8080/api/v1/1
Post entity deleted successfully.