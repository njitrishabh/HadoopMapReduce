import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class WordMapper extends Mapper<Object, Text, Text, IntWritable>
{
	private final static IntWritable one = new IntWritable(1);
	private Text word = new Text();
	
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException 
	{
		StringTokenizer itr = new StringTokenizer(value.toString());
		while (itr.hasMoreTokens()) 
		{
			String word1=itr.nextToken();
			if(word1.equals("education"))
			{
				word.set(word1);
				context.write(word, one);
			}
			if(word1.equals("politics"))
			{
				word.set(word1);
				context.write(word, one);
			}
			if(word1.equals("sports"))
			{
				word.set(word1);
				context.write(word, one);
			}
			if(word1.equals("agriculture"))
			{
				word.set(word1);
				context.write(word, one);
			}
		}
	}
}
