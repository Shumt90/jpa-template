# Getting Started

Запустить ProductExampleApplication и перейти в [Swagger](http://localhost:8080/swagger-ui.html)

### Работа с каталогом:

Получить каталоги верхнего уровня:

``
http://localhost:8080/api/catalogs?page=0&size=20
``

Получить подкаталоги:

``
http://localhost:8080/api/catalogs?catalogId=2b3877ae-c8b8-4c04-b58e-548bf8e24780&page=0&size=20
``

Получить продукты в каталоге:

``
http://localhost:8080/api/products?catalogId=06f14ce2-43a8-4b9c-980b-6128076dc124&page=0&size=10
``

 Остальное очевидно по свагеру. 