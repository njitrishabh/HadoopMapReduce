import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

//import com.google.common.collect.Iterables;

public class DominantPoliticsReducer extends Reducer<LongWritable, Text, LongWritable, Text>
{
	private Text state=new Text();
	private LongWritable count=new LongWritable();
	
	public void reduce(LongWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException 
	{
		try
		{
			state=values.iterator().next();
			String[] data=state.toString().split("\t");
			state.set(data[0]);
			count.set(Long.valueOf(data[1]));
			CountTreeMap.politicsTreeMap.put(Integer.valueOf(data[1]), state.toString());
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
}
