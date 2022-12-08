# CSC207 Project: CollegeCook
This repository is created as a course project for **CSC207H1: Software Design Course** in the University of Toronto.  
  Contributors: Yading Feng, Krutika Joshi, Jason Kahn, Jinping Liang, Huayin Luo, Lucia Tan, Brenden Yiping Wang

## Project Introduction

The specification of our software is to build a software that gives recipe suggestions based off on different criteria 
(ie. ingredients, cuisine preferences, time it takes, calories, etc.). Users can create, view, and review 
recipes.

<p align="center">
    <img width="500" src="https://github.com/CSC207-2022F-UofT/course-project-collegecook/blob/main/images/giphy.gif" alt="Menu">
</p>


+ Search and Sort: The program provides the function of filtering recipes for users to conveniently search for recipes they 
are interested in, and sort by a given sort type (average rating, number of ratings, time needed) in ascending or descending order
+ Meal Plan: Users can also add recipes to their weekly meal plans, which include breakfast lunch and dinner options. 
+ Follow Users: Users can also follow and unfollow other users. 
+ User Profile: There is also a profile for every registered user, keeping all their created and reviewed recipes and user information, such as age, height, weight and gender. 
+ User Ranking: The program also allows rankings of users based on their average review rating, number of recipes, and number of followers.

## Clean Architecture and SOLID Principles

The program strictly follows the clean architecture and SOLID Principles. There are UI, controller, presenter, interactor and entity for each feature. Abstract layers (InputBoundary, OutputBoundary, Gateway) are also created between two layers to follow the SOLID Principles.

## Design Pattern

+ **Singleton Design Pattern**: It's used on gateway to control the instantiation of the gateway.
+ **Iterator Design Pattern**: It's used on RecipeList to make it iterable
+ **Strategy Design Pattern**: It's used on sorting recipes and ranking users.
+ **Simple Factory Design Pattern**: It's used on review Database.
+ **Depency Injection Design Pattern**: It's used throughout the program to decrease dependency

## Program Guideline
To run the program, just run ```CollegeCookApp.java```.


