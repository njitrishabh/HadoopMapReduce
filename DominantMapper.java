import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

public class DominantMapper extends Mapper<Text, LongWritable, LongWritable, Text>
{
	private LongWritable count = new LongWritable();
	private Text state = new Text();
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException 
	{
		String line = value.toString();
		String s1=line.split("\t")[0];
		String s2=line.split("\t")[1];
		state.set(s1);
		count.set(Long.valueOf(s2));
		context.write(count, state);
	}
}
