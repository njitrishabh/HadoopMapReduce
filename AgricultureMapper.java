import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

public class AgricultureMapper extends Mapper<Object, Text, Text, IntWritable>
{
	private final static IntWritable one = new IntWritable(1);
	private Text state = new Text();
	
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException 
	{
		Path filePath = ((FileSplit) context.getInputSplit()).getPath();
		String filePathString = ((FileSplit) context.getInputSplit()).getPath().toString();
		String fileName = ((FileSplit) context.getInputSplit()).getPath().getName();
		StringTokenizer itr = new StringTokenizer(value.toString());
		while (itr.hasMoreTokens()) 
		{
			String word1=itr.nextToken();
			if(word1.equals("agriculture"))
			{
				state.set(fileName);
				context.write(state, one);
			}
		}
	}
}
