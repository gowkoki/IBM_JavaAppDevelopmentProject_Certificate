About this project
For this project, you are a junior Java developer hired by your local city council to help launch a new EcoPoints Recycling Program.

Your city wants to motivate households to recycle more by giving them eco points every time they recycle items such as plastic, paper, glass, or metal. These points will later be redeemable for rewards. As an initial step for this project, which will be developed in multiple iterations, your job is to build the first version of the tracking system.

Your goal is to build a simple, console-based Java app that tracks each household's recycling activities and calculates the eco points each household earns. You'll make it easy for your community members to see how much they've contributed to a cleaner, greener neighborhood!

This is a guided project, so you'll have full starter code, clear instructions, and lots of practice applying the core Java skills you've learned so far.

This project, which will take about 60 minutes to complete, includes the following tasks:

Task 1: Create classes
Create well-structured classes:
Household with the following attributes.
unique ID
name
address
joining date
RecyclingEvent with the following attributes:
Material type (such as plastic, glass, metal, and paper)
Weight in kilograms
Date of recycling
Eco points earned
Use encapsulation to protect data and keep code organized.
Task 2: Create collections
Use ArrayList and HashMap:
Use HashMap to store multiple households mapped to the unique household id
Use Arraylist to store multiple recycling events per household
Task 3: Register households
1
2
- Create new household profiles with a unique ID, name, address, and join date. Use Date & Time API to record household join dates.
- Add the household to the collection.

Copied!

Wrap Toggled!
Task 4: Log recycling events
Allow users to log each recycling event, including:
Material type (such as plastic, glass, metal, and paper)
Weight in kilograms
Date of recycling
Apply a simple points rule to award 10 Eco points per kilogram (kg) recycled:
Update each household's total points balance.
Add the recycling event to the collection.
Task 5: Store data
Save household profiles and recycling logs to files using Java File I/O so data persists when the program closes.
Task 6: Display records
Show the following outputs based on the selected option
All the registered households
All recycling events for a household
Total weight recycled by a household
Total eco points earned by a household
Task 7: Generate reports
Produce simple reports such as:
Household with the highest total points
Total community recycling weight
Task 8: Implement Error Handling
Use exception handling to:
Catch invalid inputs (such as negative weights)
Handle duplicate household IDs
Manage file read/write errors
