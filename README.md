## List of Microservices Identified
	- orderService
	- dishService
	- restaurantService
	- userService
	- feedbackService
##  orderService
#### Models
 - order
    - orderId- String - primary key
    - restaurantName-  string - required
    - food - List< dish > - requried
    - isReady - Boolean - required
    - orderPlacedAT - LocalDateTime
 - dish
    - dishId- string- primary key
    - dishName- String - required
    - dishPrice- string -required
    - dishDetails -string - required
    - dishImage -string required
#### Endpoints
 
 - /api/v1/order - Post - create order
 - /api/vi/order -Post - add dish
 - /api/v1/order - delete - delete dish
 - /api/v1/order - GET - Get Order
 - /api/v1/order - Update - update orderstatus
 
##  DishService
#### Models
- dish
    - dishId- string- primary key 
    - dishName- String - required
    - dishPrice- string required
    - dishDetails -string -required
    - dishImage -string -required

 

#### Endpoints
- /api/v1/restaurantHome - Post - create dish
 - /api/v1/restaurantHome - Update - update dish
 - /api/v1/restaurantHome - delete - delete dish

 - /api/v1/restaurantMenu - GET - Get dish
 

## RestaurantService
#### Models
- Restaurant
    - restaurantId-int- primary key
    - restaurantName-string- required
    - restaurantCategory- string -required
    - restaurantLocation- string -required
    - restaurentImage- String -required
#### Endpoints
- /api/v1/registerRestaurant - Post - Add restaurant
## UserService
#### Models
 - User
    - userId-int- primary key
    - fname-string- required
    - lname- string- required
    - email-string- required
    - password -string- required
    - Address -string -required
    - Mobile- string 
    - role - string (customer-owner-admin)

#### Endpoints
 - /api/v1/Customer/register - Post - Add customer
 - /api/v1/Customer/login - post - login customer
 - /api/vi/Admin/login - post- login admin
## feedbackService
#### Models
 
    
 - Feedback
    - feedbackId- string- primary key
    - restaurantId -string -required
    - title- String -required
    - description- string - required
    - rating -string -required
#### Endpoints
 
 - /api/v1/feedbacks - Post - create feedback
 - /api/vi/feedbacks -get- get feedback 