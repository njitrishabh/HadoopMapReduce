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

public class DominantSportsJob
{
	public void executeJob(String[] args) throws IOException, ClassNotFoundException, InterruptedException
	{
		Configuration conf = new Configuration();		
		Job job = Job.getInstance(conf, "dominant_sports_job");
		job.getConfiguration().set("mapreduce.output.basename", "dominant_sports_job");
		job.setJarByClass(AppMain.class);
		job.setMapOutputKeyClass(LongWritable.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputKeyClass(LongWritable.class);
		job.setOutputValueClass(Text.class);
		
		job.setMapperClass(DominantMapper.class);
		job.setCombinerClass(DominantSportsReducer.class);
		job.setReducerClass(DominantSportsReducer.class);
		
		FileInputFormat.addInputPath(job, new Path("output4/sports_job-r-00000"));
		FileOutputFormat.setOutputPath(job, new Path("output8"));
		job.waitForCompletion(true);
		
		
		File file=new File("output8/dominant_sports_job-r-00000");
		FileWriter fileWriter=new FileWriter(file);
		BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
		Set set = CountTreeMap.sportsTreeMap.entrySet();
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
