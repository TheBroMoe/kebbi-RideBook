CMPUT 301 Assignment 1 - RideBook

Name: Mohammad Kebbi

ID: 1496572

Description: RideBook is a simple mobile app to note Bike Ride Details by filling/editing fields such as the title of the ride (Personal touch of mine), the date, time, and other various logistics. Users may also delete rides and view rides in detail. The app also makes sure rides have valid information.

Summary of Java Files:
* `MainActivity.java`: Holds Primary screen for application and is where users may add, edit, or delete rides
* `DetailActivity.java`: Screen for showing full details of a ride
* `RideEditorFragment`: Fragment Used for creating/editing rides
* `Ride.java`: Class Used to encapsulate ride details
* `RideList.java`: Implementation of CustomList Adapter for displaying a list of rides
* `userinterface package`: Contains helper classes used in activity and fragment files

Summary of XML Files:
* `layout/activity_main.xml`: Design of MainActivity Screen
* `layout/activity_ride_detail.xml`: Design of DetailActivity Screen
* `layout/activity_ride_editor.xml`: Design of Fragment dialog used for adding/editing rides
* `layout/content.xml`: Formatting/Design for RideList Items
* `drawable/background.xml`: Implementation of shape used to grade gradient background for app

Acknowledgements: All online resources used for implementation are given in their respective Java files. More documentation and information can be found in the Java Files.

How to run app: Import the application using android studio, then click on the build tab and click `make project` (ctrl-F9) then click the run tab and click `run` (Shift-F10). If build errors occur, make sure to click the build tab and click `clean project` then run the earlier commands again. The application should start with no issues.

Additional Information:
This application was implemented in Android Studio API level 15 and was tested using a Pixel 3 API 29 Emulator
