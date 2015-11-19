---- SQL to extract some stats about the sensor data in a database
-- setup
.mode column
.load ./libsqlitefunctions
.echo on
---- Accelerometer ----
-- sample count
select count(*) from sensor_data where sensor_type = 1;
-- average x, y, and z accelerations (m/sec^2)
select avg(value1), avg(value2), avg(value3) from sensor_data where sensor_type = 1;
-- standard deviation of the x, y, and z accelerations
select stdev(value1), stdev(value2), stdev(value3) from sensor_data where sensor_type = 1;
---- Gyroscope ----
-- sample count
select count(*) from sensor_data where sensor_type = 4;
-- average angular speed (rad/sec) b around the x, y, and z axes
select avg(value1), avg(value2), avg(value3) from sensor_data where sensor_type = 4;
-- standard deviation angular speed (rad/sec) b around the x, y, and z axes
select stdev(value1), stdev(value2), stdev(value3) from sensor_data where sensor_type = 4;
---- Rotation Vector ----
-- sample count
select count(*) from sensor_data where sensor_type = 11;
-- average x, y, and z components of the rotation vector
select avg(value1), avg(value2), avg(value3) from sensor_data where sensor_type = 11;
-- standard deviation of the x, y, and z components of the rotation vector
select stdev(value1), stdev(value2), stdev(value3) from sensor_data where sensor_type = 11;
