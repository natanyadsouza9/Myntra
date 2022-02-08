For the Appium project I have created 4 tests.
It includes automation of 2 applications Myntra.com and CureFit

Since I was getting permission error while trying to automate the Myntra native app I automated it via Web view.
I was not able to automate log in scenario with the Myntra APP since it kept asking me for OTP.

Cure Fit app was automated in native app view.

Challenge1 Test with Myntra App.
• Open chrome APP and search for Myntra and click
• Click on Search lens
• Type Nike Shoes Women and search
• Select first displayed item
• Swipe for two times
• Tap on displayed image
• Zoom In and out displayed image and press X
• Tap on Move to Bag
• Select first size and press done
• Assert added item count on the bag icon
• Tap on Bag


Challenge 2  with CureFit.me app
•  Launch app
• Login to the app
• Send app to the background and bring it back
• Check the app state


Challenge 3  with CureFit.me app
•  Launch app
• Login to the app
• Click on left upper side menu icon.(3 lines)
• Tap on Profile Menu
• Tap on Blog submenu
• Assert that the Blog submenu has text Whoops!

Challenge 4  with CureFit.me app
•  Launch app
• Login to the app
• Get the performance data of Battery,cpu,memory,network

