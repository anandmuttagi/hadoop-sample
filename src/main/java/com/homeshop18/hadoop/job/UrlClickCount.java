package com.homeshop18.hadoop.job;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.homeshop18.hadoop.map.UrlClickCountMapper;
import com.homeshop18.hadoop.reduce.UrlClickCountReducer;



public class UrlClickCount {

	public static void main(String[] args) throws Exception {
		
		Path inputPath = new Path(args[0]);
        Path outputPath = new Path(args[1]);
 
        // Create configuration
        Configuration conf = new Configuration(true);
        
        Job job = Job.getInstance(conf);
        job.setJobName("UrlClickCount");
        job.setMapperClass(UrlClickCountMapper.class);
        job.setReducerClass(UrlClickCountReducer.class);
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        
        FileInputFormat.addInputPath(job, inputPath);
        FileOutputFormat.setOutputPath(job, outputPath);
        job.waitForCompletion(true);
	}

}
