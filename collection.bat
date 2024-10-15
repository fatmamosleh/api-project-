start newman run cart.postman_collection.json -e fakestore.postman_environment.json -r htmlextra
start newman run login.postman_collection.json -e fakestore.postman_environment.json -r htmlextra
start newman run Products.postman_collection.json -e fakestore.postman_environment.json -r htmlextra
start newman run user.postman_collection.json -e fakestore.postman_environment.json -r htmlextra
