## Data
##### Initial data analysis

Use get-stats.sh to get a directory containing stats on all the sensor data. Currently the testdata directory contains two databases for which info is available in the output directory.



## Notes

Relying on sqlite3 extention for stdev. 
See extension-functions.c at http://www.sqlite.org/contrib?orderby=date
Note: On OS X, I had to build the sqlite3 cli from source to enable extensions

Information on what value1, value2, and value3 represent for the various sensors:
- http://developer.android.com/reference/android/hardware/Sensor.html#TYPE_ACCELEROMETER
- http://developer.android.com/reference/android/hardware/Sensor.html#TYPE_GYROSCOPE
- http://developer.android.com/reference/android/hardware/Sensor.html#TYPE_ROTATION_VECTOR



