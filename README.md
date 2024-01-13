<a href="GymnasticsGainz"><img src="src/main/resources/Images/img2.png" align="right" height="250" width="250" ></a>
# GymnasticsGainz

GymnasticsGainz is a Java-based desktop workout generating application that helps coaches create conditioning routines tailored to their season goals. Whether you're looking to build strength, maintain your current performance, or peak for a competition, GymnasticsGainz has you covered. 
GymnasticsGainz aims to provide an automated solution to take the monotony out of handwriting conditioning plans each day, and adding variety for athletes.

The generator picks 10 exercises per workout using the following criteria:

 * 2 upper body pushing exercises,
 * 2 upper body pulling exercises,
 * 1 lower body pushing exercises,
 * 1 lower body pulling exercises,
 * 3 core exercises.
   
The project utilizes a simple and easy to use JavaFX UI and is deployed using Gradle. Currently the exercise data set is limited to a test set generated using AI. However, future work will aim to incorporate a proper exercise data set.  Additional work will also give users the ability to view, and select alternate exercises, as well as adding criteria for determining generated exercise selection.  



## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Customizing Exercise Database](#customizing-exercise-database)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Exercise Generation**: GymnasticsGainz allows users to generate workout routines based on their selected difficulty level (Deload, Maintain, Build-up, or Peak).
- **Exercise Details**: Users can view detailed information about each recommended exercise, including muscle groups targeted, body parts involved, and recommended sets and repetitions.
- **User-Friendly Interface**: The application features an intuitive graphical user interface (GUI) that makes it easy to navigate and interact with.
- **Exercise Database**: GymnasticsGainz uses a CSV-based exercise database, making it simple for users to customize the list of available exercises to meet their unique needs.

## Getting Started

Follow these steps to get GymnasticsGainz up and running on your local machine.

### Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 8 or higher installed on your system.
- Git for cloning the project (optional).

### Installation

1.) Clone the repository to your local machine (or download the ZIP file):
 
      git clone https://github.com/yourusername/GymnasticsGainz.git
   
2.) Navigate to the project directory:

      cd GymnasticsGainz

3.) Compile and run the application:

      ./gradlew run

## Usage
1.)  Launch the GymnasticsGainz application.

2.)  Select your desired difficulty level: Deload, Maintain, Build-up, or Peak.

3.)  Click the "Generate Workout" button to create a workout routine.

4.)  View the generated exercises in the table, and click on an exercise to see its details.



## Customizing Exercise Database
You can customize the exercise database by editing the CSV file located in the src/main/java/com/gymnasthub/gymnasticsgainz directory. Add, modify, or remove exercises as necessary.

The CSV file follows this format:

Exercise Name, Muscle Group, Body Part, Exercise Direction, Exercise Equipment, Exercise Difficulty, Sets, Repetitions

## Contributing
Contributions are welcome! If you'd like to contribute to GymnasticsGainz by adding exercises, features or bug fixes, please follow these steps:


 #### Fork the repository:

1.) Create a new branch for your changes:

      git checkout -b feature/your-change-name


2.) Make your changes and commit them:

      git commit -m "Your commit message here"

3.) Push your changes to your forked repository:

      git push origin feature/your-change-name


4.) Open a pull request to the original repository, explaining the changes you've made.

5.) Your pull request will be reviewed, and if approved, your changes will be merged.

## License
This project is currently unlicensed 
