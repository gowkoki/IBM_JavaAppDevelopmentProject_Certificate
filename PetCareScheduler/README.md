About the project
You're a junior Java developer working for a small local pet care service that helps pet owners keep their furry friends healthy and happy.

Pet owners often forget important tasks such as vet visits, vaccinations, and grooming appointments. Paws & Whiskers wants to provide a simple console-based app to help them organize all their pet care needs in one place.

Your goal is to build a console-based, pet care scheduler application that lets users register their pets, log important appointments, track upcoming tasks, and keep a history of past visits, all while safely storing this information so it doesn't disappear when the app closes.

This is your sharable, graded project. You'll apply all of the skills you practiced in your guided Eco-Points Recycling Tracker.

This project, which will take between 90 to 120 minutes to complete, is comprised of the following tasks:

Task 1: The Object blueprint classes
Create the following well-structured classes:

Pet class with the following attributes:
- Unique Pet ID
- Name
- Species/Breed
- Age
- Owner name
- Contact Info
- Registration date
- List of appointments, using an appropriate collection object.

Appointment class with the following attributes:
- Appointment type (such as vet visit, vaccination, grooming)
- Date and time
- Notes (optional)

Important: Use encapsulation to protect data and keep your code organized.

Task 2: The main application
Create the PetCare Scheduler application that will:

Load Data: Load any existing data from the files, when the application starts up. Ensure this method is private.
Take and Process user input: Take user input and process it to perform one of the allowed operations:
Register a pet
Schedule an appointment
Store the details in a file
Display details of pets and/or appointments
Generate reports
Task 3: Add the methods to handle user input
Register the pet: Create new pet profiles that contain the following information:
- Anique Pet ID. Handle ID duplication.
- Name
- Species/Breed
- Age. Handle any errors that can be caused by invalid inputs.
- Owner/Contact name
- Registration date. Use the Date & Time packages to record pet registration dates. Handle any errors that can be caused by invalid inputs.
- Add the pet to the collection

Schedule an ppointment: Allow users to schedule appointments for a pet, including:
- Appointment type (such as vet visit, vaccination, grooming)
- Date and time of appointment. Handle any errors that can be caused by invalid inputs.
- Notes if needed
- Add the appointment to the collection for that pet.

Display the records: Show the following information based on the option chosen:
- All registered pets
- All appointments for a specific pet
- Upcoming appointments for all pets
- Past appointment history for each pet

Store data: Save pet profiles and appointment records to files using Java File I/O so data persists when the program closes. Handle any errors that can be caused during File I/O.

Generate reports: Produce simple reports including:
- Pets with upcoming appointments in the next week
- Pets overdue for a vet visit (For example: No vet visit in the last 6 months)

Task 4: Compile and run
Compile all the file you have created and run the application and verify that the application functions as per the requirements.
