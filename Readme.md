# **Inventory Management System **

## Overview

### **SpringBoot(Advanced)**

## **Features[Product]**

* ###### **AddProduct** : Addition of a new product
* ###### **GetAllProducts** : Get Allproduct with List with Hateos link.
* ###### **GetProductByID** : Get product details by ID .
* ###### **UpdateProduct** : Updates existing product details by their ID .
* ######  **DeleteProduct** : Deletes a product by ID.

## **Features[Users]**

* ###### **AddUsers** : Addition of a new user.
* ###### **GetUserByEmail** : Get user by their email.
* ###### **GetAllUsers** : Get All Users with List.
* ######  **DeleteUser** : Deletes a User by ID.

## **Prerequisites** 

* ###### JAVA 21 , SpringSecurity , MongoDB 
* ###### Maven
* ###### IDE : IntelliJ IDEA 

## **Build Project**

* ###### Clean Package - `mvn clean package`
* ###### Full Build - `mvn clean install `
* ######  Run Application - `mvn spring-boot:run `

## **Run Poject locally** 

### **MongoDB Compass**

###### * Open mongoDB compass create a collections name : `inventory`
###### * Check folder `database` for document name with `inventory.users.json` and
###### `inventory.product.json` import this in above collection `inventory` . 

## **Download Project Locally** 

###### * Download project folder locally from one-drive.
###### * Open project in IDE and build project .
###### * Run command in Command prompt `mvn spring-boot:run` to run application or 
###### * Goto browser/postman , hit [http:localhost:8182/inventory] for test 

## **API ENDPOINT** 

###### * POST` http://localhost:8182/inventory`
###### * GET `http://localhost:8182/inventory`
###### * GET `http://localhost:8182/inventory/67354e88c88df08576f18a`
###### * UPDATE `http://localhost:8182/inventory/67354e88c88df08576f18a`
###### * DELETE `http://localhost:8182/inventory/67354e88c88df08576f18a`

