import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class DominantEducationJob
{
	public void executeJob(String[] args) throws IOException, ClassNotFoundException, InterruptedException
	{
		Configuration conf = new Configuration();		
		Job job = Job.getInstance(conf, "dominant_education_job");
		job.getConfiguration().set("mapreduce.output.basename", "dominant_education_job");
		job.setJarByClass(AppMain.class);
		job.setMapOutputKeyClass(LongWritable.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputKeyClass(LongWritable.class);
		job.setOutputValueClass(Text.class);
		
		job.setMapperClass(DominantMapper.class);
		job.setCombinerClass(DominantEducationReducer.class);
		job.setReducerClass(DominantEducationReducer.class);
		
		FileInputFormat.addInputPath(job, new Path("output2/education_job-r-00000"));
		FileOutputFormat.setOutputPath(job, new Path("output6"));
		job.waitForCompletion(true);
		
		
		File file=new File("output6/dominant_education_job-r-00000");
		FileWriter fileWriter=new FileWriter(file);
		BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
		Set set = CountTreeMap.educationTreeMap.entrySet();
	    Iterator i = set.iterator();
	    int count=0;
	    while(i.hasNext()) 
	    {
	    	if(count<50)
	    	{
	    		Map.Entry me = (Map.Entry)i.next();
	    		bufferedWriter.write(me.getKey().toString() + "\t");
	    		bufferedWriter.write(me.getValue().toString() + "\n");
	    		bufferedWriter.flush();
	    	}
	    	else
	    		break;
	    	count++;
	    }
	    bufferedWriter.close();
	}
}
