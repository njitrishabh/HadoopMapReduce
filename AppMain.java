import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class AppMain 
{

	public static void main(String[] args) throws Exception 
	{		
		WordJob wordJob=new WordJob();
		AgricultureJob agricultureJob=new AgricultureJob();
		EducationJob educationJob=new EducationJob();
		PoliticsJob politicsJob=new PoliticsJob();
		SportsJob sportsJob=new SportsJob();
		DominantAgricultureJob dominantAgricultureJob=new DominantAgricultureJob();
		DominantEducationJob dominantEducationJob=new DominantEducationJob();
		DominantPoliticsJob dominantPoliticsJob=new DominantPoliticsJob();
		DominantSportsJob dominantSportsJob=new DominantSportsJob();
		wordJob.executeJob(args);
		agricultureJob.executeJob(args);
		educationJob.executeJob(args);
		politicsJob.executeJob(args);
		sportsJob.executeJob(args);
		dominantAgricultureJob.executeJob(args);
		dominantEducationJob.executeJob(args);
		dominantPoliticsJob.executeJob(args);
		dominantSportsJob.executeJob(args);
	}
}
