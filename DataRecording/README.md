# DataRecording
Records sensor data and notes into sqlite database for processing elsewhere

## Database Schema
- Tables: notes, accelerometer, gyroscope
- Schemas:
  - Notes

## App Structure
  - MainActivity
    - Starts the service if not already started
    - Allows to submit notes linked
    - Allows to stop/start data recording
  - DataRecordingService
    - Starts/stops DataRecordingThread as requested
  - DataRecordingThread
    - Gets sensor updates and saves them to database
  - DatabaseHelper
    - Handles the interfacing with the actual database
