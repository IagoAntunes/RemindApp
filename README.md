![thumbnail](https://github.com/IagoAntunes/RemindApp/blob/master/app/src/main/res/drawable/github/img_thumb.png)

# :purple_heart::yellow_heart: GuessingGame

:purple_heart::yellow_heart: Remind App

This project is a medication reminder application built using Kotlin and Jetpack Compose. The main objective of the application is to help users manage their medication schedules by providing timely reminders for taking their prescribed medicines. 
The app allows users to add new prescriptions, set specific times for medication intake, and define recurrence patterns (daily, weekly, monthly).

## :iphone: FrontEnd (App)

## Introduction

In this application, you will be able to:

- User Authentication: Users can log in to access their personalized medication schedules.
- Medication Management: Users can add, edit, and delete medication entries.
- Time Picker Integration: Users can select specific times for medication reminders using a time picker.
- Snackbar Notifications: The app provides feedback to users through snackbar notifications for various actions like adding a new prescription or handling errors.
- Navigation: The app uses Jetpack Navigation to manage different screens, such as login, home, and new prescription screens.

Below, you will find instructions for installation, usage, and more details about this project.

## Installation

To install this project, follow the steps below:

1. Clone the repository:
    ```sh
    git clone https://github.com/IagoAntunes/RemindApp.git
    ```

## :wrench: Technologies and Tools

### Technologies
- Android
- Kotlin
- JetpackCompose

### Tools
- [hilt](https://developer.android.com/training/dependency-injection/hilt-android?hl=pt-br) - Dependency Injection.
- [navigation-compose](https://developer.android.com/develop/ui/compose/navigation?hl=pt-br) - Navigation

## 🎨 Layout

<div style="display: flex; flex-wrap: wrap; gap: 10px;">
  <img src="https://github.com/IagoAntunes/RemindApp/blob/master/app/src/main/res/drawable/github/splash_page.png" style="width: 160px;" alt="Splash">
  <img src="https://github.com/IagoAntunes/RemindApp/blob/master/app/src/main/res/drawable/github/login_page.png" style="width: 160px;" alt="Login">
  <img src="https://github.com/IagoAntunes/RemindApp/blob/master/app/src/main/res/drawable/github/home_page.png" style="width: 160px;" alt="Home">
  <img src="https://github.com/IagoAntunes/RemindApp/blob/master/app/src/main/res/drawable/github/list_recipe_page.png" style="width: 160px;" alt="ListRecipe">
  <img src="https://github.com/IagoAntunes/RemindApp/blob/master/app/src/main/res/drawable/github/create_recipe_page.png" style="width: 160px;" alt="CreateRecipe">
</div>


## Architecture
  
This project uses Clean Architecture to organize the code in a modular and decoupled way, facilitating system maintenance and evolution. The folder structure is organized as follows:

### Folder Structure

```
guessinggame
│
├── core
│
├── modules
|

```

- **core:** Contains the code and rules shared between the app's features.
- **modules** Contains the code for each feature.

```
module
│
├── domain
│
├── external
|
├── infra
│
└── presentation
```
- **domain:** Contains repository abstractions and models (entities) representing the application's core data.

- **external:** Responsible for implementing external data sources and data access objects (DAOs).

- **infra:** This layer is responsible for the implementation of the repository interfaces defined in the domain layer. It acts as a bridge between the external data sources and the domain layer.

- **presentation:** Contains the code related to the user interface (UI) and controllers.
