# GymnasticsGainz

GymnasticsGainz is a Java-based workout planning application that helps users create exercise routines tailored to their fitness goals. Whether you're looking to build muscle, maintain your current physique, or peak for a competition, GymnasticsGainz has you covered.

![GymnasticsGainz Screenshot](screenshot.png)

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

1. Clone the repository to your local machine (or download the ZIP file):

   ```bash
   git clone https://github.com/yourusername/GymnasticsGainz.git
Navigate to the project directory:

bash
Copy code
cd GymnasticsGainz
Compile and run the application:

bash
Copy code
./gradlew run
Usage
Launch the GymnasticsGainz application.

Select your desired difficulty level: Deload, Maintain, Build-up, or Peak.

Click the "Generate Workout" button to create a workout routine.

View the generated exercises in the table, and click on an exercise to see its details.

Customize the exercise database as needed.

Customizing Exercise Database
You can customize the exercise database by editing the CSV file located in the src/main/java/com/gymnasthub/gymnasticsgainz directory. Add, modify, or remove exercises as necessary.

The CSV file follows this format:

css
Copy code
Exercise Name, Muscle Group, Body Part, Exercise Direction, Exercise Equipment, Exercise Difficulty, Sets, Repetitions
Contributing
Contributions are welcome! If you'd like to contribute to GymnasticsGainz, please follow these steps:

Fork the repository.

Create a new branch for your feature or bug fix:

bash
Copy code
git checkout -b feature/your-feature-name
or

bash
Copy code
git checkout -b bugfix/your-bug-fix-name
Make your changes and commit them:

bash
Copy code
git commit -m "Your commit message here"
Push your changes to your forked repository:

bash
Copy code
git push origin feature/your-feature-name
or

bash
Copy code
git push origin bugfix/your-bug-fix-name
Open a pull request (PR) to the original repository, explaining the changes you've made.

Your PR will be reviewed, and once approved, your changes will be merged.

License
This project is licensed under the MIT License. See the LICENSE file for details.
