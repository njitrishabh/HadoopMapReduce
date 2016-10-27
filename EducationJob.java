import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class EducationJob
{
	public void executeJob(String[] args) throws IOException, ClassNotFoundException, InterruptedException
	{
		Configuration conf = new Configuration();		
		Job job = Job.getInstance(conf, "education_job");
		job.getConfiguration().set("mapreduce.output.basename", "education_job");
		job.setJarByClass(AppMain.class);
		job.setMapperClass(EducationMapper.class);
		job.setCombinerClass(ProgReducer.class);
		job.setReducerClass(ProgReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		for(int i=0;i<50;i++)
			FileInputFormat.addInputPath(job, new Path(args[i]));
		FileOutputFormat.setOutputPath(job, new Path(args[52]));
		job.waitForCompletion(true);
	}
}
