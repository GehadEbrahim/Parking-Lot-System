# Garage Parking Spot Reservation System

This is a Java-based system to manage parking spot reservations in a garage. Vehicle owners can register, log in, and reserve spots based on their vehicle type (normal, bike, or large spots). Admins can manage spots, view data, and calculate revenues.


## Detailed Description

### Overview:
This project manages a system for garage parking spot reservation. Vehicle owners can reserve parking spots for one hour or more based on their vehicle type. The system supports the following spot types:
- *Normal Spot*: For cars.
- *Bike Spot*: For bikes.
- *Large Spot*: For 4x4 vehicles.

### Functionalities:
1. **Admin Functionalities:**
   - Add and delete parking slots.
   - Display available slots for all spot types.
   - Manage and update all entities (spots, owners, and slots).
   - Calculate total revenue for each spot type.

2. **Vehicle Owner Functionalities:**
   - Register and log in.
   - Reserve, cancel, and update reservations.
   - Display available spots based on vehicle type.
   - Calculate payments with a reward system (1 free hour after 6 hours).

### Entities:
1. **Admin**:
   - Username: `admin`
   - Password: `admin`
   
2. **Vehicle Owner**:
   - Attributes: Name, password, ID, license number, vehicle(s).

3. **Parking Spot**:
   - Types: Normal, bike, large.
   - Slots: Contain time, date, and fees.

### Constraints:
- Reservations must be made within 3 days or less before the desired date.
- Penalty fees apply for canceled reservations.


## How to Use:
1. Clone the repository:
   ```bash
   git clone https://github.com/GehadEbrahim/Parking-Lot-System.git


