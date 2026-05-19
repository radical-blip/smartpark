To Run the Application:
- Upon extraction if the project, copy the folder named "smartpark" inside the project folder.
- Paste the folder into your user computer data folder(address should be something like this = "c:\users\{COMPUTER_NAME}")
- Make sure you have already installed a JAVA21 JRE and JDK in your machine.
- Open the project folder into your preferred IDE.
- Right-click the file named "SmartparkApplication.java" then select Run/Run java.

To Test the API using POSTMAN:
- In the project folder, import the file named "SmartPark.postman_collection.json" into your POSTMAN collections.
 * Parking Lot Folder
	- Make sure to run the "Register Parking" Request first before any other request in the folder.
	- For the "Get Available" and "Get Vehicles Parked" request, you have to substitute the "lotId" field from any parking lot returned in the response of the "Get Parking Lots" request into the "{lotID}" path variable in both request.

 * Vehicle Folder
	- Make sure to run the "Register Vehicle" Request first before any other request in the folder.
	- Use the license plate you used in the "Register Vehicle" request or any "licensePlate" from the response body of the "Get Registered Vehicles" request.
	- Substitute "lotId" field from any parking lot returned in the response of the "Get Parking Lots" request into the "{lotID}" variable in the body tab of the request for both "Check In" and "Check Out" request.

To Run the unit test:
- Make sure you have already installed a JAVA21 JRE and JDK in your machine.
- Open the project folder into your preferred IDE.
- Right-click the file named "SmartparkApplicationTest.java" then select Run/Run java.

