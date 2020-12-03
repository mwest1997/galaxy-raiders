## Summary

  The android app that I will developing is based on the game Space Invaders. But instead of just having the regular game, there will be multiple levels each with different tasks at hand to complete to be able to unlock different ships and weapons. The ships will have no advantage over others, purely cosmetic. The weapons will be upgradeable by completing separate tasks to help the player defeat the massive hoards of enemies.

  The user will have to sign in upon opening the game for the first time. Users are asked to sign in so that all of their stats can be saved in between sessions. Things that will be saved for the users will include their high score, the ship and weapon they are currently using, as well as the level they are currently on in the campaign mode. It is also used so that there is an option for multiple users to be able to play on the same device at different times. The user will then be met by the home screen, which will be themed to fit the game. From here, they will be able to choose between the campaign mode and the survival mode. Campaign will be a story based mode which will have multiple levels for the user to complete. Survival mode is an infinite singular level where the user just tries to get a high score based on the amount of enemies defeated. Meanwhile, back on the homescreen, the user can go into the settings and change the ship as well as the weapons based on their own preferences. Compete with your friends to see who has the highest score!

## Intended users

* People who are completionists.

	> As someone who is a completionist, being able to unlock different ships with many different challenges brings longevity to the game and keeps me interested.
	
* People who enjoy casually playing games to pass the time.

	> As someone who likes to play games during my free time, having a game like this in my pocket would be a great way to pass the time.

## Functionality

* A campaign mode with different levels that progressively get harder.

* The further you go, the more enemies come at you, and the bigger they are, the more health they have.

* The final level will have a boss that has a lot of health and sends other enemies at you.

* A survival mode that you unlock after you beat the campaign that lasts infinitely where you just try to get a high score of kills.

* Ships and weapons that can be unlocked during the game by performing tasks.

* Weapons will have different uses for different situations.

## Current State

  Currently, the app builds and runs, but does not do much. It has multiple screens with different buttons all with a specific purpose but most buttons do not have a role yet. The game does not play yet due to time restrictions and making animations work.

### Not functional
  
* The game itself

* Buttons having no functionality

* Database returning games

### Stretch Goals

* Implementing the campaign mode because survival seems to be an easier approach to having a running game 

## Persistent data

* Saving progress on the campaign mode.

* Saving the ship you have selected as well as the weapon.

* Saving the top 5 high-scores on the survival mode.
    
## Device/external services

* Possibly the ability to share high-scores to social media. 
	
	* [Facebook](https://www.facebook.com/)
	
	* The app will be able to take your most recent score, and post it on your FaceBook profile.
	
	* This app will absolutely still be usable if the service is inaccessible.

* Using the tilt function to make the ship move left or right

    * [Android Gyroscope Sensor](https://source.android.com/devices/sensors/sensor-types#gyroscope)

	* The app will be able to use the tilt function to make the ship steer to the left, as well as to the right depending on which way you tilt the phone. Left to go left, and right to go right!
	
	* You will not be able to use the app if the service is inaccessible. You may be able to launch the game, but its main functions would not be able to work.

* Making the background a little darker if the lighting in the room is low, and brighter if the light is high.

    * [Android Light Sensor](https://source.android.com/devices/sensors/sensor-types#light)

	* The app will be able to use the light sensor to sense how much light exists within the room, and change the color of the background so that if you are playing in the dark, the game is not too bright and will not hurt your eyes.
	
	* You will still be able to use the app if the service is inaccessible.

* Usage of Google Sign-in to store user data between devices

	* [Google Sign-in API](https://developers.google.com/identity/sign-in/web/sign-in)
	
	* The app will use the google sign-in API to store saved data across multiple devices.
	
	* I would assume that the app would still be accessible without access to this service, and just be able to store data on the phone, but only for one user.
## Stretch goals/possible enhancements 

A stretched goal would possibly be adding different types of weapons to the game. Having to program the different physics of each weapon could possibly be very time consuming and adding too many could be a problem. Sharing to social media may also be a stretch goal. Possible enhancements could include more obstacles during the campaign. I.E. asteroids to dodge to stay alive.

## [Wireframe](wireframe.md)

## [Entity Relationship Diagram](erd.md)

## [Galaxy Raiders DDL](ddl.md)

## [DAO Interfaces](dao.md)

## [Database](database.md)

## [Repositories](repository.md)

## [Javadoc](api/index.html)

## [Copyrights & Licenses](notice.md)

## [Build Instructions](README.md)

## [Basic User Instructions](instructions.md)