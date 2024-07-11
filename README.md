# RESTful Spring Application with Postgres for Students Management Deployed on AWS EC2

Checkout the [Swagger UI](http://ec2-35-159-175-214.eu-central-1.compute.amazonaws.com:8080/swagger-ui.html) (deployed on AWS EC2 using Docker Hub).<br>
Instructions for user creation and authentication (to access the API) below.

The app exposes API to:
- Register and authenticate as a user in the system with JWT authentication (JWT authentication controller).
- Create, read, update, and delete (CRUD) students in the Postgres DB (students controller).
- Add grades for students in different courses (students grades controller).
- Upload a student's image to AWS S3.
- Send SMS to all the students in the DB with a POST request. The request creates a thread to handle sending the SMS to all the students (via [sms4free](https://www.sms4free.co.il/)).
- Send an email to a given address (via [SendGrid's API](https://app.sendgrid.com/guide/integrate/langs/java)).
<br>
Containerized with Docker, uploaded to Docker Hub, and deployed on an AWS EC2 instance using Docker.

# Instructions for User Creation and Authentication
## Open the [Swagger UI](http://ec2-35-159-175-214.eu-central-1.compute.amazonaws.com:8080/swagger-ui.html) web page:
<br><br>
![image](https://github.com/roeishc/basic-spring/assets/95538414/5a830e1b-5089-45e1-8543-b0c8403ff012)
<br><br>
## Create a user by:
1. Expanding jwt-authentication-controller.
2. Opening the /user POST request.
3. Filling in the userRequest body (hint: click the example to the right to populate the text field with default values).
4. Clicking "Try it out!".

<img width="740" alt="image" src="https://github.com/roeishc/basic-spring/assets/95538414/d371a2b9-3703-4a3f-9203-a00f26483d90">

## Notice the response:
Copy the value of the "token" attribute (all the way til its end on the right):

![image](https://github.com/roeishc/basic-spring/assets/95538414/870599f5-7e20-4132-9639-5ee52ef213b5)

## Authorize by:
1. Click "Authorize" at the top of the screen.
2. Type "Bearer \<your token\>".
3. Click Authorize.

<img width="737" alt="image" src="https://github.com/roeishc/basic-spring/assets/95538414/fe47ae37-5660-4322-90da-c90568183355">

<br><br>

The web page will be refreshed and you can now access all the APIs in the other controllers.
