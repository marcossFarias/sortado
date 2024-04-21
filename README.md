# Sortado


## What is Sortado? 
Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.


## Installation

### Prerequisites

Ensure you have the following installed on your system:
- Java 17
- Intellij IDEA CE

### Get the code
You have two ways to obtain the code for the Sortado project:
- Download the Zip File
  - Visit the Sortado GitHub repository.
  - Click on the “Code” button above the list of files.
  - Choose “Download ZIP” to get a compressed archive of the entire project.
  - Extract the contents of the ZIP file to your desired location.
  
- Clone the Repository Using Git or GitHub CLI:
  - Open your terminal or command prompt.
  - To clone the repository using HTTPS, run the following command:
  - `git clone https://github.com/marcossFarias/sortado.git`
  - To clone the repository using GitHub CLI, run the following command: 
  - `gh repo clone marcossFarias/sortado`
  - Either option will create a local copy of the repository on your machine.


### Open as an IntelliJ IDEA CE Project:
- Launch IntelliJ IDEA CE.
- Choose “Open” from the welcome screen.
- Navigate to the location where you extracted the Sortado project (if you downloaded the ZIP file) or the cloned repository (if you used Git/GitHub CLI).
- Select the project folder and click "Open."
- IntelliJ IDEA maven integration will load the project, and you’ll be ready to start working on Sortado! (note that you may need to install extra dependencies like JBR )
- Go to the "Project structure," then in the "Modules" tab, mark the java folder within the benchmark (/src/benchmark/java) as "Tests".

### Our Test Environment
We are committed to ensuring the reliability of our code.
To this end, we test these steps with each major update.
Our testing environment is a fresh installation of Pop!_OS, the latest version, running on a virtual machine powered by Virt Manager.



## Usage
Currently, the code is designed for basic usage.
In the main function, we generate a collection of arrays with different sizes.
These arrays are then used as parameters for various sorting algorithms.
This process provides a general understanding of the algorithms’ behavior.

For more detailed time metrics, navigate to the ‘benchmarks’ directory and execute the ‘Benchmark Runner’ class.
Please note, if you wish to run individual benchmarks, you will need to install the JMH extension for IntelliJ.

Additionally, the ‘Benchmark Runner’ logs all the terminal command output to a file.
It also generates a CSV file with the final metrics.
This allows you to easily access and analyze the benchmark results at any time.



## Acknowledges
- AI initially generates the comments, docstrings, readme, wiki and other texts in this project. They are then extensively revised and enhanced by our dedicated team for improved clarity and accuracy.
- It’s worth noting that the use of atomic counters appears to have some impact on the timing of tiny arrays (those with fewer than 20 elements). 