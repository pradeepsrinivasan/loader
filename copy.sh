#for ip in 10.33.37.222 10.33.201.210 10.33.10.30 10.32.153.189 10.34.37.14 10.34.17.20 10.33.113.204 10.34.105.151 10.33.41.53 10.33.105.40 10.33.229.215 10.33.213.194; do 
for ip in 10.32.153.189; do
scp loader-core/target/loader-core-1.0.0.jar loader-common-operations/target/loader-common-operations-1.0.0-jar-with-dependencies.jar "$ip":~; 
echo $ip; done
