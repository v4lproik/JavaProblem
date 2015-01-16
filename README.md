# Java Exercise

## Introduction
***

This repository has been constructed for developers to demonstrate how they would tackle adding new functionality to a legacy codebase whilst protecting the existing functionality within the code.

The idea by performing this exercise you will be able to demonstrate several aspects of your coding practice:

* Ability to use GIT source control
* Ability to import and start working with an unknown Java project
* Ability to add new features to a legacy code-base
* Suggest improvements to code structure

## Problem Statement
***
In this made-up scenario we have a supermarket customer who buy and sell only the finest goods.  Unfortunately their goods are constantly degrading in quality as they approach their sell by date.  They have a Java application in place that updates their inventory for price and quality as the items age.  We have been engaged to help them develop it further with a new enhancement.

Your task is to implement the new feature *without* breaking the existing business logic specified here. 
	
We're aware the codebase is 'sub-optimal' (to say the least) so would like you to describe or demonstrate how you would improve the solution as well
	
	
## Business Rules / Requirements
***
First an introduction to the system:
*	All items have a SellIn value ‘int’ which denotes the number of days we have left to sell the item
*	All items have a Quality value ‘int’ which denotes how valuable the item is
*	At the end of each day our system lowers both ‘int’ values for every item.  This is triggered by an invocation of the ‘updateQuality()’ method.
There are some strict business rules, which need to be maintained:
*	Once the sell by date has passed, Quality degrades twice as fast (i.e. the int is decremented by 2 instead of 1)
*	The Quality of an item is never negative
*	The Quality of an item is never more than 50; except for “Sulfuras” which can be 80.
Certain item categories have special behaviours, again which need to be maintained:
*	"Aged Brie" actually increases in Quality the older it gets
*	"Sulfuras" never has to be sold or decreases in Quality
*	"Backstage Passes", like aged brie, increases in Quality as it's SellIn value reduces (i.e as it gets closer to the concert). Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but Quality drops to 0 after the concert

The supermarket has recently signed a supplier of Organic Bananas. 
This requires an update to the system:
*	The "Organic Bananas" item degrade in Quality twice as fast as normal items

Changes can be made to the updateQuality method and add any new code as long as everything still works correctly.  
However you cannot alter the Item class as it belongs to a mythical third-party who won’t let us make modifications to the class they provide.

## Code Operation
***
When deployed the updateQuality() method gets called nightly to update all the inventory's SellIn and Quality values.  In this harness it is invoked from the main method.  Feel free to modify this to run as many night cycles you require.
	
## Instructions
***
We're not imposing a maximum or minimum time limit on this challenge but previous experience suggests allowing for around an hour to complete.

1. Clone this repository
2. Create your own GitHub/BitBucket repository and commit the base project to it
3. At regular intervals commit and push your changes so we can see logical progress & steps you took through the problem
4. Add a text file (ideally in Markdown format) to the root of the repository detailing the changes you made and explanations for the steps you took.  Feel free to include any assumptions you made during the exercise too.
5. Notify us that you have completed the exercise