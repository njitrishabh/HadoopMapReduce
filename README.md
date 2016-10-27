# HadoopMapReduce

Goal: The purpose of this assignment is to learn how to use the Amazon Web Services (AWS) platform and to learn how to develop parallel applications using the Hadoop programming framework.

Description: The assignment is divided in 2 tasks:

1. Build your own Hadoop AMI, starting from a basic Ubuntu AMI and store this AMI in S3.

2. Write a Hadoop/Yarn MapReduce application that takes as input the 50 Wikipedia web pages dedicated to the US states (we will provide these files for consistency) and:

a) Computes how many times the words “education”, “politics”, “sports”, and “agriculture” appear in each file.

b) Rank all the 50 states for each of these words (i.e., which state pages use each of these words the most)



1. Compile java source files by giving the following command
        
		cd /home/ubuntu/programs
		
      javac -cp /home/ubuntu/hadoopjars/hadoop-common.jar:/home/ubuntu/hadoopjars/commons-cli-1.2.jar:/home/ubuntu/hadoopjars/core-3.1.1.jar:/home/ubuntu/hadoopjars/hadoop-core-1.2.1.jar *.java
        
        Where cp stands for the Hadoop classpath.

2. Create a jar file named States2.jar file giving the following command

        cd /home/ubuntu/programs
		
        jar cvf States2.jar *.class 

3. Change permission of the generated States.jar file by giving the following command

        sudo chmod 777 States2.jar

4. Upload the States2.jar file to HDFS by giving the following command

   hadoop fs -copyFromLocal . States2.jar

   Make sure the state input files have already been uploaded to HDFS.

5. Run the program by giving the following command

   cd /home/ubuntu/programs

hadoop jar States2.jar AppMain Alabama Hawaii Massachusetts New_Mexico South_Dakota Alaska Idaho Michigan New_York Tennessee Arizona Illinois Minnesota North_Carolina Texas Arkansas Indiana Mississippi North_Dakota Utah California Iowa Missouri Ohio Vermont Colorado Kansas Montana Oklahoma Virginia Connecticut Kentucky Nebraska Oregon Washington Delaware Louisiana Nevada Pennsylvania West_Virginia Florida Maine New_Hampshire Rhode_Island Wisconsin Georgia Maryland New_Jersey South_Carolina Wyoming output output_1 output_2 output_3 output_4 output_5 output_6 output_7 output_8


The output of first problem is stored in the ‘output’ directory while the output of second problem is stored in the 'output_1' 'output_2' 'output_3' 'output_4' ‘output_5’, ‘output_6’, ‘output_7’ and ‘output_8’ directories.
