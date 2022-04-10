# registerstudent

A distributed system to capture student details as well as their associated scores. Every
student has an “active” current score along with any previous scores being archived within a data
store for further processing.

The system consist out of 2 parts namely Back-end, API Integrations.

System uses Postgres DB 

System can execute below functions 


-Register a new student profile :Register a new student profile
                                 Student profiles are unique based on their First and Last name combination
                                 First and Last name fields are therefore compulsory 
-Update student profile: up call only allow the following fields to be updated 
                        First Name
                        Last Name
                        Date of Birth
                        Cellphone Number
                        Email Address
-Delete student profile : System only delete by student id 

-Capture a specific student’s latest score and calculate average scores
-Search student profiles registered on the system bty below fields : Student Number
                                                                     First Name
                                                                     Last Name
                                                                     Email Address


